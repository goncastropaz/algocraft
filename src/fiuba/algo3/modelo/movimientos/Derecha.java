package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.juego.Turno;
import fiuba.algo3.modelo.unidades.Unidad;

public class Derecha extends Movimiento {

	public Derecha(Juego juego){
		super(juego);
	}
	
	
	public void mover(Unidad unidad) throws FueraDeMatriz,UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada {
		Mapa mapa =  this.juego.getMapaDeJuego();
		Posicion posActual = unidad.getUbicacion();
		Celda celdaActual = mapa.devolverCelda(posActual);
		Posicion posNueva = posActual.getPosicionDerecha();
		Celda celdaNueva = mapa.devolverCelda(posNueva);
		celdaActual.removeUnidad();
		celdaNueva.setUnidad(unidad);
		unidad.cambiarUbicacion(posNueva);
		int visionUnidad = unidad.getVision();
		this.juego.getActualJugador().actualizarVision(posNueva, visionUnidad);
		ActualizarObservadores();
	}
}