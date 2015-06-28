package fiuba.algo3.algocraft.movimientos;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.unidades.Unidad;



public abstract class Movimiento extends java.util.Observable{
	
	protected Juego juego;
	
	public Movimiento(Juego juego){
		this.juego = juego;
	}
	
	public abstract void mover(Unidad unidad) throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada;
	
	public void ActualizarObservadores() {
		setChanged();
		notifyObservers();
	}
	
}