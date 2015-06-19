package fiuba.algo3.algocraft.control;

import fiuba.algo3.algocraft.acciones.PasarTurno;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Turno;
import fiuba.algo3.algocraft.juego.VisionJugador;

public class ControlJuego {
	private Juego juego;
	private boolean inicioJuego = false;

	public ControlJuego() throws FueraDeMatriz, JugadorInvalido {
		Juego nuevoJuego = Juego.getInstance();
		juego = nuevoJuego;
	}

	public boolean inicioJuego() {
		return this.inicioJuego;
	}

	public void finalizarJuego() {
		this.inicioJuego = false;
	}

	public boolean juegoEstaTerminado() {
		return this.juego.juegoTerminado();
	}

	public Turno getTurno() {
		return juego.getTurno();
	}

	public VisionJugador pasarTurno() {
		PasarTurno pasarTurno = new PasarTurno();
		VisionJugador visionJugador = null; 
		
		if (pasarTurno.ejecutar()) {
			visionJugador = this.juego.getActualJugador().getVisionMapa();
		}
		
		return visionJugador;
	}

	public void crearNuevoJuego() throws FueraDeMatriz {
		juego = Juego.getInstance();
		inicioJuego = true;
	}

}
