package fiuba.algo3.algocraft.movimientos;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.unidades.RaceUnit;



public abstract class Movimiento {
	
	public abstract void mover(RaceUnit unidad) throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial;
	
}