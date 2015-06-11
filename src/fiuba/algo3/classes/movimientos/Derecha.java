package fiuba.algo3.classes.movimientos;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.exceptions.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.classes.game.Celda;
import fiuba.algo3.classes.game.Mapa;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.units.RaceUnit;

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