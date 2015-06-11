package fiuba.algo3.classes.movimientos;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.exceptions.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.classes.units.RaceUnit;



public abstract class Movimiento {
	
	public abstract void mover(RaceUnit unidad) throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial;
	
}