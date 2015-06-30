package fiuba.algo3.modelo.razas;

import java.util.HashMap;

import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearConstruccion;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearUnidad;


public abstract class Raza {
	
	
	public HashMap<Integer,CrearUnidad> listaDeCreacionUnidades;
	
	public HashMap<Integer,CrearConstruccion> listaDeCreacionConstrucciones;

}
