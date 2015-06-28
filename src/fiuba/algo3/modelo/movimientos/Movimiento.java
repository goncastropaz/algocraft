package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.Unidad;



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