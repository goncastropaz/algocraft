package fiuba.algo3.control;

import java.util.HashMap;

import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearConstruccion;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearUnidad;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinConstruccion;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.EdificioNoPuedeCrearUnidad;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoHayUnidadParaMoverEnCelda;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneConstruccion;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.unidades.Unidad;

public interface ControlAcciones {
		
	
	
	public void crearUnidad(int identificador,Posicion pos) throws CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad;
	public void crearContruccion(int identificador,Posicion pos) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, RazaNoTieneConstruccion, RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida;
	public void mover(int i,Posicion pos) throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, CeldaOcupada, NoHayUnidadParaMoverEnCelda;
	
	
}