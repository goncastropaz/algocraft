package fiuba.algo3.modelo.acciones.creacionConstrucciones;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaNoVisible;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;

public abstract class CrearConstruccion {
	
	protected Juego juego;
	
	public CrearConstruccion(Juego juego){
		this.juego = juego;
	}
	public abstract void crearConstruccion(Posicion pos) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida, CeldaNoVisible;
	
}
