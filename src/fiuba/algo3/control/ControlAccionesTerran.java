package fiuba.algo3.control;

import java.util.ArrayList;
import java.util.HashMap;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearBarraca;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearCentroDeMineral;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearConstruccion;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearDepositoSuministros;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearFabrica;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearPuertoEstelarTerran;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearRefineria;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearEspectro;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearGolliat;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearMarine;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearNaveCiencia;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearNaveTransporteTerran;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearUnidad;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CapacidadInsuficiente;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaNoVisible;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinConstruccion;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.CeldaSinUnidad;
import fiuba.algo3.modelo.excepciones.CopiaNoCausaDanio;
import fiuba.algo3.modelo.excepciones.EdificioNoPuedeCrearUnidad;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.FueraDeRango;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.MagiaDesconocida;
import fiuba.algo3.modelo.excepciones.NaveVacia;
import fiuba.algo3.modelo.excepciones.NoHayUnidadParaMoverEnCelda;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.ObjetivoInvalido;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.excepciones.UnidadAereaNoSePuedeCargar;
import fiuba.algo3.modelo.excepciones.UnidadAtacadaInvalida;
import fiuba.algo3.modelo.excepciones.UnidadAtacanteInvalida;
import fiuba.algo3.modelo.excepciones.UnidadNoPerteneceAJugador;
import fiuba.algo3.modelo.excepciones.UnidadNoPuedeTransportar;
import fiuba.algo3.modelo.excepciones.UnidadNoTerminada;
import fiuba.algo3.modelo.excepciones.UnidadNoTieneMagia;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.movimientos.Abajo;
import fiuba.algo3.modelo.movimientos.Arriba;
import fiuba.algo3.modelo.movimientos.Derecha;
import fiuba.algo3.modelo.movimientos.Izquierda;
import fiuba.algo3.modelo.movimientos.Movimiento;
import fiuba.algo3.modelo.unidades.Unidad;

public class ControlAccionesTerran implements ControlAcciones{


	private ControlJuego controlJuego;
	private Juego juego;
	private HashMap<Integer,CrearUnidad> listaDeCreacionUnidades;
	private HashMap<Integer,CrearConstruccion> listaDeCreacionConstrucciones;
	private HashMap<Integer,Movimiento> listaDeMovimientos;
	private ArrayList<String> magias;
	
	public ControlAccionesTerran(ControlJuego controlJuego){
		this.controlJuego = controlJuego;
		this.juego = controlJuego.getJuego();
		this.listaDeCreacionUnidades = new HashMap<Integer,CrearUnidad>();
		this.listaDeCreacionConstrucciones = new HashMap<Integer,CrearConstruccion>();
		this.listaDeMovimientos = new HashMap<Integer,Movimiento>();
		this.magias = new ArrayList<String>();
			

		this.listaDeCreacionUnidades.put(1, new CrearMarine(juego));
		this.listaDeCreacionUnidades.put(2, new CrearGolliat(juego));
		this.listaDeCreacionUnidades.put(3, new CrearEspectro(juego));
		this.listaDeCreacionUnidades.put(4, new CrearNaveCiencia(juego));
		this.listaDeCreacionUnidades.put(5, new CrearNaveTransporteTerran(juego));
		
		this.listaDeCreacionConstrucciones.put(1, new CrearCentroDeMineral(juego));
		this.listaDeCreacionConstrucciones.put(2, new CrearBarraca(juego));
		this.listaDeCreacionConstrucciones.put(3, new CrearDepositoSuministros(juego));
		this.listaDeCreacionConstrucciones.put(4, new CrearRefineria(juego));
		this.listaDeCreacionConstrucciones.put(5, new CrearFabrica(juego));
		this.listaDeCreacionConstrucciones.put(6, new CrearPuertoEstelarTerran(juego));
		
		this.listaDeMovimientos.put(1, new Arriba(juego));
		this.listaDeMovimientos.put(2, new Abajo (juego));
		this.listaDeMovimientos.put(3, new Derecha(juego));
		this.listaDeMovimientos.put(4, new Izquierda(juego));
		
		this.magias.add("EMP");
		this.magias.add("RADIACION");
	}
	
	public void crearUnidad(int identificador,Posicion pos) throws CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad {
		CrearUnidad ejecutable = this.listaDeCreacionUnidades.get(identificador);
		ejecutable.crearUnidad(pos);
	}
	
	public void crearContruccion(int identificador,Posicion pos) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida, CeldaNoVisible{
		CrearConstruccion ejecutable = this.listaDeCreacionConstrucciones.get(identificador);
		ejecutable.crearConstruccion(pos);
	}

	@Override
	public void mover(int id,Posicion pos) throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Movimiento movimiento = this.listaDeMovimientos.get(id);
		movimiento.mover(pos);
		
	}

	@Override
	public void atacar(Posicion posAtacante, Posicion posAtacado) throws ObjetivoInvalido, UnidadAtacanteInvalida, UnidadAtacadaInvalida, FueraDeRango, CeldaSinUnidad, UnidadNoTerminada {
		this.juego.atacar(posAtacante, posAtacado);
		
	}

	@Override
	public void magia(Posicion unidadAtacante, Posicion unidadAtacada,int id) throws UnidadNoTieneMagia, EnergiaInsuficiente, CopiaNoCausaDanio, CeldaOcupada, CeldaEspacial, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad,  CeldaSinUnidad, UnidadNoTerminada{
		this.juego.usarMagia(unidadAtacante, this.magias.get(id), unidadAtacada);
	}

	@Override
	public void cargarEnNave(Posicion primeraPosicion, Posicion ultimaPosicion) throws CapacidadInsuficiente, UnidadAereaNoSePuedeCargar, UnidadNoPerteneceAJugador, FueraDeRango, CeldaSinUnidad, UnidadNoPuedeTransportar, UnidadNoTerminada {
		this.juego.cargarUnidad(ultimaPosicion, primeraPosicion);
	}

	@Override
	public void descargarEnNave(Posicion ultimaPosicion) throws UnidadNoPuedeTransportar, UnidadNoPerteneceAJugador, CeldaOcupada, NaveVacia, UnidadNoTerminada, CeldaSinUnidad {
		this.juego.descargarUnidades(ultimaPosicion);
		
	}

	
	

	
	
	
}
