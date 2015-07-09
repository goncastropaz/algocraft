package fiuba.algo3.modelo.juego;

import java.util.HashMap;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.CapacidadInsuficiente;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinConstruccion;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.CeldaSinUnidad;
import fiuba.algo3.modelo.excepciones.ColorYaExiste;
import fiuba.algo3.modelo.excepciones.CompletarDatosException;
import fiuba.algo3.modelo.excepciones.CopiaNoCausaDanio;
import fiuba.algo3.modelo.excepciones.EdificioNoPuedeCrearUnidad;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.FueraDeRango;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.MagiaDesconocida;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.modelo.excepciones.NombreYaExiste;
import fiuba.algo3.modelo.excepciones.ObjetivoInvalido;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneConstruccion;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.excepciones.UnidadAereaNoSePuedeCargar;
import fiuba.algo3.modelo.excepciones.UnidadAtacadaInvalida;
import fiuba.algo3.modelo.excepciones.UnidadAtacanteInvalida;
import fiuba.algo3.modelo.excepciones.UnidadNoPerteneceAJugador;
import fiuba.algo3.modelo.excepciones.UnidadNoPuedeTransportar;
import fiuba.algo3.modelo.excepciones.UnidadNoTieneMagia;
import fiuba.algo3.modelo.razas.Raza;
import fiuba.algo3.modelo.unidades.AltoTemplario;
import fiuba.algo3.modelo.unidades.Cargable;
import fiuba.algo3.modelo.unidades.NaveCiencia;
import fiuba.algo3.modelo.unidades.Unidad;

public class Juego {

	private HashMap<Integer, Jugador> jugadores;
	private Mapa mapaJuego;
	private Turno turno;
	private boolean juegoFinalizado;

	public Juego() {

		this.mapaJuego = new Mapa();
		this.jugadores = new HashMap<Integer, Jugador>();
		
		try {
			Jugador jugador1 = new Jugador(mapaJuego.getBaseJugador(1));
			jugadores.put(1, jugador1);
			Jugador jugador2 = new Jugador(mapaJuego.getBaseJugador(2));
			jugadores.put(2, jugador2);
			this.turno = new Turno(this.jugadores);
		} catch (JugadorInvalido e) {
			e.printStackTrace();
		} catch (FueraDeMatriz e) {
			e.printStackTrace();
		}
		this.juegoFinalizado = false;

	}

	public Jugador getJugador(int jugador) throws JugadorInvalido {

		if (jugador > 2 || jugador < 1)
			throw new JugadorInvalido();
		return jugadores.get(jugador);
	}

	public void setNombreJugador(int jugador, String nombre)
			throws NombreYaExiste, JugadorInvalido, NombreConMenosDe4Caracteres{

		
		for (Integer key : this.jugadores.keySet()) {
			if (this.getJugador(key).getNombre().equalsIgnoreCase(nombre) && !key.equals(jugador))
				throw new NombreYaExiste();
		}
		this.getJugador(jugador).setNombre(nombre);

	}
	
	public void setRazaJugador(int jugador, Raza raza) throws JugadorInvalido {
		this.getJugador(jugador).setRaza(raza);
	}

	public void setColorJugador(int jugador, String color) throws JugadorInvalido, ColorYaExiste, CompletarDatosException {
		
		if(color.isEmpty()){
			throw new CompletarDatosException();
		}
		for (Integer key : this.jugadores.keySet()) {
			if (this.getJugador(key).getColor().equalsIgnoreCase(color) && !key.equals(jugador))
				throw new ColorYaExiste();
		}
		this.getJugador(jugador).setColor(color);

	}

	public void darFinalizadoElJuego() {
		this.juegoFinalizado = true;
	}

	public boolean juegoTerminado() {
		return this.juegoFinalizado;
	}

	public void agregarUnidad(Unidad unidad, Posicion posConstruccion) throws CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad{
		if(!this.mapaJuego.tieneConstruccion(posConstruccion)) throw new CeldaSinConstruccion();
		if(!this.mapaJuego.devolverCelda(posConstruccion).getConstruccion().puedeCrearUnidad(unidad)) throw new EdificioNoPuedeCrearUnidad();
		this.turno.getActualJugador().puedeCrearUnidad(unidad);
		Posicion posUnidad = this.mapaJuego.agregarUnidad(unidad,posConstruccion);
		unidad.setUbicacion(posUnidad);
		this.turno.getActualJugador().agregarUnidad(unidad);
	}
	public void agregarUnidadCopia(Unidad copia, Posicion posUnidadCopiada) throws RecursosInsuficientes, PoblacionInsuficiente, CeldaOcupada{
		this.turno.getActualJugador().puedeCrearUnidad(copia);
		Posicion posUnidad = this.mapaJuego.agregarUnidad(copia,posUnidadCopiada);
		copia.setUbicacion(posUnidad);
		this.turno.getActualJugador().agregarUnidad(copia);
	}
	
	public void agregarConstruccion(Construccion construccion, Posicion pos) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, RazaNoTieneConstruccion, RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida{
		this.turno.getActualJugador().puedeCrearConstruccion(construccion);
		this.mapaJuego.agregarConstruccion(construccion,pos);
		this.turno.getActualJugador().agregarConstruccion(construccion);
	}
	
	public void atacar(Unidad unidad, Posicion pos) throws ObjetivoInvalido, UnidadAtacanteInvalida, UnidadAtacadaInvalida, FueraDeRango{
		unidad.atacarUnidad(this,pos);
		this.refrescar();
	}
	
	public void usarMagia(Unidad unidad, String magia, Posicion pos) throws UnidadNoTieneMagia, EnergiaInsuficiente, CopiaNoCausaDanio, CeldaOcupada, CeldaEspacial, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, MagiaDesconocida {
		if(!unidad.tieneMagia(magia)) throw new UnidadNoTieneMagia();
		if(magia.equals("TORMENTA")){
			((AltoTemplario) unidad).provocarTormentaPsionica(pos, this.mapaJuego);
		} else if(magia.equals("ALUCINACION")){
			((AltoTemplario) unidad).provocarAlucinacion(pos, this);
		} else if(magia.equals("RADIACION")){
			((NaveCiencia) unidad).generarRadiacion(pos, this.mapaJuego);
		} else if(magia.equals("EMP")){
			((NaveCiencia) unidad).generarEMP(pos, this.mapaJuego);
		} else{
			throw new MagiaDesconocida();
		}
		this.refrescar();
	}
	
	public void cargarUnidad(Unidad unidad, Posicion pos) throws CapacidadInsuficiente, UnidadAereaNoSePuedeCargar, UnidadNoPerteneceAJugador, FueraDeRango, CeldaSinUnidad, UnidadNoPuedeTransportar{
		if(!unidad.puedeTransportar()) throw new UnidadNoPuedeTransportar();
		if(!this.mapaJuego.devolverCelda(pos).tieneUnidad()) throw new CeldaSinUnidad();
		if(!this.getActualJugador().tieneDaniable(unidad.getUbicacion())) throw new UnidadNoPerteneceAJugador();
		if(!this.getActualJugador().tieneDaniable(pos)) throw new UnidadNoPerteneceAJugador();
		if(!this.mapaJuego.devolverCeldasRadio(pos, unidad.getVision()).contains(this.mapaJuego.devolverCelda(pos))) throw new FueraDeRango();
		((Cargable) unidad).cargarUnidad(this.mapaJuego, this.mapaJuego.devolverCelda(pos).getUnidad());
	}
	
	public void descargarUnidades(){
		
	}

	public void cambiarTurnoJugador() {
		this.turno.cambiarTurnoJugador();
		
	}

	public Jugador getActualJugador() {
		return this.turno.getActualJugador();
	}

	public Mapa getMapaDeJuego() {
		return this.mapaJuego;
	}
	
	public void refrescar(){
		for(int i = 1; i < 3;i++){
			jugadores.get(i).refrescar();
		}
	}

}