package fiuba.algo3.modelo.razas;

import java.util.HashMap;
import java.util.Set;

import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearConstruccion;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearUnidad;


public abstract class Raza {
	
	
	public HashMap<Integer,CrearUnidad> listaDeCreacionUnidades;
	
	public HashMap<Integer,CrearConstruccion> listaDeCreacionConstrucciones;
	
	public Set<String> listaDeUnidadesValidas;
	
	public Set<String> listaDeConstruccionesValidas;

	public HashMap<Integer, CrearUnidad> getListaDeCreacionUnidades() {
		return listaDeCreacionUnidades;
	}

	public HashMap<Integer, CrearConstruccion> getListaDeCreacionConstrucciones() {
		return listaDeCreacionConstrucciones;
	}

	public Set<String> getListaDeUnidadesValidas() {
		return listaDeUnidadesValidas;
	}

	public Set<String> getListaDeConstruccionesValidas() {
		return listaDeConstruccionesValidas;
	}

}
