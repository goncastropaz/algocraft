package fiuba.algo3.modelo.acciones.creacionUnidades;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.Dragon;

public class CrearDragon extends CrearUnidad{

	public CrearDragon(Juego juego){
		super(juego);
	}
	
	@Override
	public void crearUnidad(Posicion pos) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente{
		Dragon dragon = new Dragon();
		this.juego.agregarUnidad(dragon, pos);

	}
	
}
