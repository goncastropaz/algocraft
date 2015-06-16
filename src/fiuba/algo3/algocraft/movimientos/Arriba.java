package fiuba.algo3.algocraft.movimientos;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Posicion;

public class Arriba extends Movimiento{

	
	public void mover(Unidad unidad) throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial {
		Mapa mapa = Mapa.getInstance();
		Celda celda = unidad.getUbicacion();
		Posicion posActual = celda.getPosicion();
		Posicion posNueva = new Posicion(posActual.getFila() -1,posActual.getColumna());
		unidad.setNuevaUbicacion(mapa.devolverCelda(posNueva));
		celda.removeUnidad();
		}
	}