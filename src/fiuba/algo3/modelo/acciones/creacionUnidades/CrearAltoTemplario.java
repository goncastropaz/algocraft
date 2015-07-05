package fiuba.algo3.modelo.acciones.creacionUnidades;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.AltoTemplario;


public class CrearAltoTemplario extends CrearUnidad{

	public CrearAltoTemplario(Juego juego){
		super(juego);
	}
	
	@Override
	public void crearUnidad(Posicion posConstruccion) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente{
		AltoTemplario altoTemplario = new AltoTemplario();
		this.juego.agregarUnidad(altoTemplario, posConstruccion);

	}

}