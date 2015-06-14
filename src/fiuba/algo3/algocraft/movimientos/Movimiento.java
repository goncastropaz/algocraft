package fiuba.algo3.algocraft.movimientos;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.unidades.Unidad;



public abstract class Movimiento {
	
	public abstract void mover(Unidad unidad) throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial;
	
}