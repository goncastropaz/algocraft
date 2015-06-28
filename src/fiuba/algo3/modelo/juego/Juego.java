package fiuba.algo3.modelo.juego;

import java.util.HashMap;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.ColorYaExiste;
import fiuba.algo3.modelo.excepciones.CompletarDatosException;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.modelo.excepciones.NombreYaExiste;
import fiuba.algo3.modelo.razas.Raza;
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
			this.turno = new Turno(this.jugadores);
			Jugador jugador = new Jugador(mapaJuego.getBaseJugador(1));
			jugadores.put(1, jugador);
			jugador = new Jugador(mapaJuego.getBaseJugador(2));
			jugadores.put(2, jugador);
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

	public void agregarUnidad(Unidad unidad, Posicion pos) throws CeldaOcupada{
		this.turno.getActualJugador().agregarUnidad(unidad);
		this.mapaJuego.agregarUnidad(unidad,pos);
		
	}
	public void agregarConstruccion(Construccion construccion, Posicion pos) throws CeldaOcupada, CeldaSinRecurso{
		this.turno.getActualJugador().agregarConstruccion(construccion);
		this.mapaJuego.agregarConstruccion(construccion,pos);
		
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
}