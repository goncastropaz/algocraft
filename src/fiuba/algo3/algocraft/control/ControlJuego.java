package fiuba.algo3.algocraft.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.acciones.PasarTurno;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Juego;

public class ControlJuego {
	private Juego juego;

	// VistaJuego vista;

	// public ControlJuego(VistaJuego vista) {
	// vista = vista;
	// }

	public void iniciarVista() {

	}

	private class EscuchaBotonIniciarJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				juego = Juego.getInstance();
			} catch (FueraDeMatriz e1) {
				// TODO Por que el juego tira FUERA DE LA MATRIZ?! :-/
				e1.printStackTrace();
			}

		}
	}

	public ActionListener getListenerBotonIniciarJuego() {
		return new EscuchaBotonIniciarJuego();
	}

	private class EscuchaBotonAgregarJugador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO: necesito de la vista para obtener los valores de los
			// atributos de los controles.

			// juego.setNombreJugador(vista.getOrdenJugador(),
			// vista.getNombre());
			// juego.setColorJugador(vista.getOrdenJugador(), vista.getColor());
		}
	}

	public ActionListener getListenerBotonAgregarJugador() {
		return new EscuchaBotonAgregarJugador();
	}

	private class EscuchaBotonPasarTurno implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO: e tiene que traer la Interfaz Ejecutable del pasar turno.
			PasarTurno pasarTurno = new PasarTurno();
			pasarTurno.ejecutar();
		}
	}

	public ActionListener getListenerBotonPasarTurno() {
		return new EscuchaBotonPasarTurno();
	}

	private class EscuchaBotonFinalizarJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			juego.darFinalizadoElJuego();
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

}
