package fiuba.algo3.modelo.acciones.creacionUnidades;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;

public abstract class CrearUnidad {

	protected Juego juego;
	
	public CrearUnidad(Juego juego){
		this.juego = juego;
	}
	public abstract void crearUnidad(Posicion pos) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente;
	
}
