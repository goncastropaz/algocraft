package fiuba.algo3.algocraft.movimientos;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.juego.Turno;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Posicion;

public class Izquierda extends Movimiento {

	public Izquierda(Juego juego){
		super(juego);
	}
	
	public void mover(Unidad unidad) throws FueraDeMatriz,UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada {
		Mapa mapa =  this.juego.getMapaDeJuego();
		Celda celdaActual = unidad.getUbicacion();
		Posicion posActual = celdaActual.getPosicion();
		Posicion posNueva = new Posicion(posActual.getFila(),posActual.getColumna() - 1);
		Celda celdaNueva = mapa.devolverCelda(posNueva);
		celdaActual.removeUnidad();
		celdaNueva.setUnidad(unidad);
		int visionUnidad = unidad.getVision();
		this.juego.getActualJugador().actualizarVision(posNueva, visionUnidad);
		ActualizarObservadores();
	}
}
