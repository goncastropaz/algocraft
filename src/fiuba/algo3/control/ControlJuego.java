package fiuba.algo3.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.vista.VistaInicial;
import fiuba.algo3.vista.VistaJuego;
import fiuba.algo3.vista.VistaMapa;

public class ControlJuego {
	private Juego juego;
	private ControlMapa controlMapa;
	private VistaMapa vistaMapa;
	private VistaJuego vistaJuego;

	public ControlJuego(Juego juego, VistaJuego vista) {
		vistaJuego = vista;
		this.juego = juego;
	}

	private class EscuchaBotonPasarTurno implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			juego.cambiarTurnoJugador();
			vistaJuego.cambiarVistaJugador();

		}
	}

	public ActionListener getListenerBotonPasarTurno() {
		return new EscuchaBotonPasarTurno();
	}

	private class EscuchaBotonFinalizarJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// PasarTurno pasarTurno = new PasarTurno();
			// pasarTurno.ejecutar();
			juego.darFinalizadoElJuego();
			vistaJuego.mostarFinalizarJuego();
		}
	}

	public ActionListener getListenerBotonFinalizarJuego() {
		return new EscuchaBotonFinalizarJuego();
	}

	private class EscuchaBotonCrearNuevoJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vistaJuego.cerrarVentanaJuego();
			VistaInicial vista = new VistaInicial();
			vista.mostrarVentanaNuevoJuego();

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
	
	public Juego getJuego() {
		return juego;
	}
	
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	public String getColorJugadorActual(){
		return juego.getActualJugador().getColor();
	}

	public Mapa getMapaDelJuego() {
		return juego.getMapaDeJuego();
	}
	
//	public String getRecursosJugadorActual(){
//		return juego.getActualJugador().
//	}
	
	

}
