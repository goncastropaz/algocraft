package fiuba.algo3.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.utiles.Constants;
import fiuba.algo3.vista.VistaAccionesProtoss;
import fiuba.algo3.vista.VistaAccionesTerran;
import fiuba.algo3.vista.VistaInicial;
import fiuba.algo3.vista.VistaJuego;

public class ControlJuego {
	private Juego juego;
	private VistaJuego vistaJuego;
	private ControlMapa controlMapa;
	
	public ControlJuego(Juego juego, VistaJuego vista) {
		vistaJuego = vista;
		this.juego = juego;
		this.controlMapa = new ControlMapa(juego.getMapaDeJuego());
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

	public String getRazaJugadorActual() {
		return juego.getActualJugador().getNombreRaza();
	}

	public JPanel getVistaAcciones(ControlJuego control) {
		JPanel vistaAcciones;
		if(this.getRazaJugadorActual().endsWith(Constants.TERRAN)){
			vistaAcciones = new VistaAccionesTerran(control);
			vistaAcciones.setBounds(900, 10, 400, 700);
		} else {
			vistaAcciones = new VistaAccionesProtoss(control);
			vistaAcciones.setBounds(900, 10, 400, 700);
		}
		return vistaAcciones;
	}

	public int getMineralJugadorActual() {
		return juego.getActualJugador().getRecursos().getMineral();
	}
	
	public int getGasJugadorActual() {
		return juego.getActualJugador().getRecursos().getGas();
	}

	public int getPoblacionJugadorActual() {
		return juego.getActualJugador().getPoblacion();
	}

	public Jugador getJugadorActual(){
		return juego.getActualJugador();
	}
	
	public ControlMapa getControlMapa(){
		return this.controlMapa;
	}
	

}
