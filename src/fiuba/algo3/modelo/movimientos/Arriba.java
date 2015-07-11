package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoHayUnidadParaMoverEnCelda;
import fiuba.algo3.modelo.excepciones.UnidadAtacanteInvalida;
import fiuba.algo3.modelo.excepciones.UnidadNoTerminada;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.unidades.Unidad;

public class Arriba extends Movimiento {

	public Arriba(Juego juego){
		super(juego);
	}
	
	public void mover(Posicion posActual) throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		
		Mapa mapa =  this.juego.getMapaDeJuego();
		Unidad unidad = mapa.devolverCelda(posActual).getUnidad();
		if(unidad == null) throw new NoHayUnidadParaMoverEnCelda();
		if(!juego.getActualJugador().tieneDaniable(unidad.getUbicacion())) throw new UnidadAtacanteInvalida();
		if(!unidad.terminado()) throw new UnidadNoTerminada();
		
		Celda celdaActual = mapa.devolverCelda(posActual);
		Posicion posNueva = posActual.getPosicionArriba();
		Celda celdaNueva = mapa.devolverCelda(posNueva);
		if(celdaNueva.isEspacial() && !unidad.vuela()) throw new CeldaEspacial();
		celdaNueva.setUnidad(unidad);
		celdaActual.removeUnidad();
		unidad.cambiarUbicacion(posNueva);
		int visionUnidad = unidad.getVision();
		this.juego.getActualJugador().actualizarVision(posNueva, visionUnidad);
		ActualizarObservadores();
		this.juego.completarAccionMovimiento();
	}
}