package fiuba.algo3.algocraft.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.acciones.PasarTurno;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaJuego;
import fiuba.algo3.algocraft.vista.VistaMapa;

public class ControlJuego {
	private Juego juego;
	private ControlMapa controlMapa;
	private VistaMapa vistaMapa;
	private VistaJuego vistaJuego;

	public ControlJuego(VistaJuego vista) {
		vistaJuego = vista;
		try {
			juego = Juego.getInstance();
			juego.empezarJuego();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class EscuchaBotonPasarTurno implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			PasarTurno pasarTurno = new PasarTurno();
			if(pasarTurno.ejecutar()){
				vistaJuego.cambiarVistaJugador();
			}
			
		}
	}

	public ActionListener getListenerBotonPasarTurno() {
		return new EscuchaBotonPasarTurno();
	}

	private class EscuchaBotonFinalizarJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			PasarTurno pasarTurno = new PasarTurno();
			pasarTurno.ejecutar();
			juego.darFinalizadoElJuego();
			vistaJuego.mostarFinalizarJuego();
		}
	}

	public ActionListener getListenerBotonFinalizarJuego() {
		return new EscuchaBotonFinalizarJuego();
	}

	private class EscuchaBotonCrearNuevoJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				juego = Juego.getInstance();
			} catch (FueraDeMatriz e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
