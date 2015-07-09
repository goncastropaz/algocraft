package fiuba.algo3.control;

import java.util.HashMap;

import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearAcceso;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearArchivoTemplario;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearAsimilador;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearBarraca;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearCentroDeMineral;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearConstruccion;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearDepositoSuministros;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearFabrica;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearNexoMineral;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearPilon;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearPuertoEstelarProtoss;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearPuertoEstelarTerran;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearRefineria;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearAltoTemplario;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearDragon;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearEspectro;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearGolliat;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearMarine;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearNaveCiencia;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearNaveTransporteProtoss;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearNaveTransporteTerran;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearScout;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearUnidad;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearZealot;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinConstruccion;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.CeldaSinUnidad;
import fiuba.algo3.modelo.excepciones.EdificioNoPuedeCrearUnidad;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.FueraDeRango;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.NoHayUnidadParaMoverEnCelda;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.ObjetivoInvalido;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneConstruccion;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.excepciones.UnidadAtacadaInvalida;
import fiuba.algo3.modelo.excepciones.UnidadAtacanteInvalida;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
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
	
	public ControlAccionesTerran(ControlJuego controlJuego){
		this.controlJuego = controlJuego;
		this.juego = controlJuego.getJuego();
		this.listaDeCreacionUnidades = new HashMap<Integer,CrearUnidad>();
		this.listaDeCreacionConstrucciones = new HashMap<Integer,CrearConstruccion>();
		this.listaDeMovimientos = new HashMap<Integer,Movimiento>();
			
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
		
	}
	
	public void crearUnidad(int identificador,Posicion pos) throws CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad {
		CrearUnidad ejecutable = this.listaDeCreacionUnidades.get(identificador);
		ejecutable.crearUnidad(pos);
	}
	
	public void crearContruccion(int identificador,Posicion pos) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida{
		CrearConstruccion ejecutable = this.listaDeCreacionConstrucciones.get(identificador);
		ejecutable.crearConstruccion(pos);
	}

	@Override
	public void mover(int id,Posicion pos) throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial {
		Movimiento movimiento = this.listaDeMovimientos.get(id);
		movimiento.mover(pos);
		
	}

	@Override
	public void atacar(Posicion posAtacante, Posicion posAtacado) throws ObjetivoInvalido, UnidadAtacanteInvalida, UnidadAtacadaInvalida, FueraDeRango, CeldaSinUnidad {
		this.juego.atacar(posAtacante, posAtacado);
		
	}

	
	

	
	
	
}
