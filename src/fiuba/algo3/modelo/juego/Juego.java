package fiuba.algo3.modelo.juego;

import java.util.HashMap;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.CapacidadInsuficiente;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaNoVisible;
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
import fiuba.algo3.modelo.excepciones.NaveVacia;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.modelo.excepciones.NombreYaExiste;
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
		Posicion posUnidad = this.mapaJuego.agregarUnidad(unidad,posConstruccion,this.turno.getActualJugador());
		unidad.setUbicacion(posUnidad);
		this.turno.getActualJugador().agregarUnidad(unidad);
		this.turno.completarAccionJugador();
	}
	public void agregarUnidadCopia(Unidad copia, Posicion posUnidadCopiada) throws RecursosInsuficientes, PoblacionInsuficiente, CeldaOcupada{
		this.turno.getActualJugador().puedeCrearUnidad(copia);
		Posicion posUnidad = this.mapaJuego.agregarUnidad(copia,posUnidadCopiada,this.turno.getActualJugador());
		copia.setUbicacion(posUnidad);
		this.turno.getActualJugador().agregarUnidad(copia);
	}
	
	public void agregarConstruccion(Construccion construccion, Posicion pos) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida, CeldaNoVisible{
		if(!this.turno.getActualJugador().tieneVisionDeCelda(pos)) throw new CeldaNoVisible();
		this.turno.getActualJugador().puedeCrearConstruccion(construccion);
		this.mapaJuego.agregarConstruccion(construccion,pos);
		this.turno.getActualJugador().agregarConstruccion(construccion);
		this.turno.completarAccionJugador();
	}
	
	public void atacar(Posicion posUnidadAtacante, Posicion posUnidadAtacada) throws ObjetivoInvalido, UnidadAtacanteInvalida, UnidadAtacadaInvalida, FueraDeRango, CeldaSinUnidad, UnidadNoTerminada{
		Unidad unidad = this.mapaJuego.devolverCelda(posUnidadAtacante).getUnidad();
		if(unidad ==null) throw new CeldaSinUnidad();
		if(!unidad.terminado()) throw new UnidadNoTerminada();
		unidad.atacarUnidad(this,posUnidadAtacada);
		this.refrescar(this.mapaJuego);
		this.turno.completarAccionJugador();
	}
	
	public void usarMagia(Posicion atacante, String magia, Posicion pos) throws UnidadNoTieneMagia, EnergiaInsuficiente, CopiaNoCausaDanio, CeldaOcupada, CeldaEspacial, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, CeldaSinUnidad, UnidadNoTerminada {
		Unidad unidad = this.mapaJuego.devolverCelda(atacante).getUnidad();
		if(unidad ==null) throw new CeldaSinUnidad();
		if(!unidad.terminado()) throw new UnidadNoTerminada();
		if(!unidad.tieneMagia(magia)) throw new UnidadNoTieneMagia();
		if(magia.equals("TORMENTA")){
			((AltoTemplario) unidad).provocarTormentaPsionica(pos, this.mapaJuego);
		} else if(magia.equals("ALUCINACION")){
			((AltoTemplario) unidad).provocarAlucinacion(pos, this);
		} else if(magia.equals("RADIACION")){
			((NaveCiencia) unidad).generarRadiacion(pos, this.mapaJuego);
		} else if(magia.equals("EMP")){
			((NaveCiencia) unidad).generarEMP(pos, this.mapaJuego);
		} 
		this.refrescar(this.mapaJuego);
		this.turno.completarAccionJugador();
	}
	
	public void cargarUnidad(Posicion posNave, Posicion pos) throws CapacidadInsuficiente, UnidadAereaNoSePuedeCargar, UnidadNoPerteneceAJugador, FueraDeRango, CeldaSinUnidad, UnidadNoPuedeTransportar, UnidadNoTerminada{
		Unidad unidad = this.mapaJuego.devolverCelda(posNave).getUnidad();
		if(unidad ==null) throw new CeldaSinUnidad();
		if(!unidad.terminado()) throw new UnidadNoTerminada();
		if(!unidad.puedeTransportar()) throw new UnidadNoPuedeTransportar();
		Celda celda = this.mapaJuego.devolverCelda(pos);
		if(!celda.tieneUnidad()) throw new CeldaSinUnidad();
		if(!this.getActualJugador().tieneDaniable(unidad.getUbicacion())) throw new UnidadNoPerteneceAJugador();
		if(!this.getActualJugador().tieneDaniable(pos)) throw new UnidadNoPerteneceAJugador();
		if(!this.mapaJuego.devolverCeldasRadio(pos, unidad.getVision()).contains(this.mapaJuego.devolverCelda(pos))) throw new FueraDeRango();
		((Cargable) unidad).cargarUnidad(this.mapaJuego.devolverCelda(pos).getUnidad());
		celda.removeUnidad();
		this.turno.completarAccionJugador();
	}
	
	public void descargarUnidades(Posicion posNave) throws UnidadNoPuedeTransportar, UnidadNoPerteneceAJugador, CeldaOcupada, NaveVacia, UnidadNoTerminada, CeldaSinUnidad{
		Unidad unidad = this.mapaJuego.devolverCelda(posNave).getUnidad();
		if(unidad ==null) throw new CeldaSinUnidad();
		if(!unidad.terminado()) throw new UnidadNoTerminada();
		if(!unidad.puedeTransportar()) throw new UnidadNoPuedeTransportar();
		if(!this.getActualJugador().tieneDaniable(unidad.getUbicacion())) throw new UnidadNoPerteneceAJugador();
		((Cargable) unidad).descargarUnidades(this.mapaJuego);
		
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
	
	public void refrescar(Mapa mapa){
		for(int i = 1; i < 3;i++){
			jugadores.get(i).refrescar(mapa);
		}
	}

	public int getAccionesDisponiblesJugadorActual() {
		return this.turno.getAccionesDisponiblesJugadorActual();
		
	}
	
	public void completarAccionMovimiento(){
		this.turno.completarAccionMovimiento();
	}

	
}