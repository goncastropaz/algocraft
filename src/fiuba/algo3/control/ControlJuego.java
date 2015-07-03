package fiuba.algo3.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.vista.VistaJuego;
import fiuba.algo3.vista.VistaMapa;

public class ControlJuego {
	private Juego juego;
	private ControlMapa controlMapa;
	private VistaMapa vistaMapa;
	private VistaJuego vistaJuego;

	public ControlJuego(Juego juego,VistaJuego vista) {
		vistaJuego = vista;
		this.juego = juego;
	}

	private class EscuchaBotonPasarTurno implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//PasarTurno pasarTurno = new PasarTurno();
		//	if(pasarTurno.ejecutar()){
		//		vistaJuego.cambiarVistaJugador();
			//}
			
		}
	}

	public ActionListener getListenerBotonPasarTurno() {
		return new EscuchaBotonPasarTurno();
	}

	private class EscuchaBotonFinalizarJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//PasarTurno pasarTurno = new PasarTurno();
			//pasarTurno.ejecutar();
			juego.darFinalizadoElJuego();
			vistaJuego.mostarFinalizarJuego();
		}
	}

	public ActionListener getListenerBotonFinalizarJuego() {
		return new EscuchaBotonFinalizarJuego();
	}

	private class EscuchaBotonCrearNuevoJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			juego = new Juego();
			
		}
	}

	public ActionListener getListenerBotonCrearNuevoJuego() {
		return new EscuchaBotonCrearNuevoJuego();
	}

	private class EscuchaBotonVolver implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	public ActionListener getListenerBotonVolver() {
		return new EscuchaBotonVolver();
	}

	public String getNombreJugadorActual() {

		return juego.getActualJugador().getNombre();
	}

}
