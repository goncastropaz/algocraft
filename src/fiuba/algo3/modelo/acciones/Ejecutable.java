package fiuba.algo3.modelo.acciones;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.juego.Juego;

public abstract class Ejecutable {
	
	protected Juego juego;
	
	public Ejecutable(Juego juego){
		this.juego = juego;
	}
	public abstract void ejecutar(Posicion pos) throws CeldaOcupada, CeldaSinRecurso;
	
}
