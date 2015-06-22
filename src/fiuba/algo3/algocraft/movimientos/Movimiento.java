package fiuba.algo3.algocraft.movimientos;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.unidades.Unidad;



public abstract class Movimiento extends java.util.Observable{
	
	public abstract void mover(Unidad unidad) throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido;
	
	public void ActualizarObservadores() {
		setChanged();
		notifyObservers();
	}
	
}