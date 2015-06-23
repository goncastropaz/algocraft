package fiuba.algo3.algocraft.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import fiuba.algo3.algocraft.acciones.PasarTurno;
import fiuba.algo3.algocraft.excepciones.ColorYaExiste;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.algocraft.excepciones.NombreYaExiste;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaInicio;

public class ControlJuego {
	private Juego juego;
	private ControlMapa controlMapa;
	private VistaInicio vistaInicio;
	

	public ControlJuego(VistaInicio vista) {
		vistaInicio = vista;
	}

	private class EscuchaBotonIniciarJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
	
				juego = Juego.getInstance();
				try {
					juego.setNombreJugador(1,vistaInicio.getTextField().getText());
					juego.setNombreJugador(2,vistaInicio.getTextField_1().getText());
					//juego.getJugador(1).setRaza()
					juego.setColorJugador(1, vistaInicio.getColorSeleccionadoJG1());
					juego.setColorJugador(2, vistaInicio.getColorSeleccionadoJG2());
					 
					
				} catch (NombreYaExiste e1) {
					vistaInicio.mostrarError("Los nombres no pueden ser iguales");
				} catch (JugadorInvalido e1) {
					vistaInicio.mostrarError("Jugador inválido");
				} catch (NombreConMenosDe4Caracteres e1) {
					vistaInicio.mostrarError("El nombre debe tener más de 4 caracteres.");
				}catch (ColorYaExiste e1) {
					vistaInicio.mostrarError("El color ya existe");
				}
				
				controlMapa = new ControlMapa();

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
	
	private class EscuchaBotonVolver implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}

	public ActionListener getListenerBotonVolver() {
		return new EscuchaBotonVolver();
	}

}
