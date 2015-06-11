package fiuba.algo3.algocraft.movimientos;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.unidades.RaceUnit;
import fiuba.algo3.classes.stats.Posicion;

public class Derecha extends Movimiento{

	
	public void mover(RaceUnit unidad) throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial {
		Mapa mapa = Mapa.getInstance();
		Celda celda = unidad.getUbicacion();
		Posicion posActual = celda.getPosicion();
		Posicion posNueva = new Posicion(posActual.getFila(),posActual.getColumna()+1);
		unidad.setNuevaUbicacion(mapa.devolverCelda(posNueva));
		celda.removeUnidad();
		}
	}