package fiuba.algo3.algocraft.movimientos;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.juego.Turno;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Posicion;

public class Derecha extends Movimiento{

	
	public void mover(Unidad unidad) throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido {
		Mapa mapa = Mapa.getInstance();
		Celda celdaActual = unidad.getUbicacion();
		Posicion posActual = celdaActual.getPosicion();
		Posicion posNueva = new Posicion(posActual.getFila(),posActual.getColumna()+1);
		Celda celdaNueva = mapa.devolverCelda(posNueva);
		unidad.setNuevaUbicacion(celdaNueva);
		celdaActual.removeUnidad();
		celdaNueva.setUnidad(unidad);
		int visionUnidad = unidad.getVision();
		Turno.getInstance().getActualJugador().actualizarVision(posNueva,visionUnidad);
		}
	}