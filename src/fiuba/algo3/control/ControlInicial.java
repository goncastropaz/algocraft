package fiuba.algo3.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import fiuba.algo3.modelo.excepciones.ColorYaExiste;
import fiuba.algo3.modelo.excepciones.CompletarDatosException;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.modelo.excepciones.NombreYaExiste;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.razas.Protoss;
import fiuba.algo3.modelo.razas.Raza;
import fiuba.algo3.modelo.razas.Terran;
import fiuba.algo3.modelo.utiles.Constants;
import fiuba.algo3.vista.VistaInicial;
import fiuba.algo3.vista.VistaJuego;

public class ControlInicial {
	private VistaInicial vistaInicial;
	private VistaJuego vistaJuego;
	private Juego juego;

	public ControlInicial(VistaInicial vista) {
		vistaInicial = vista;
		juego = new Juego();
	}

	private class EscuchaBotonGuardarJugadores implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {

				juego.setNombreJugador(1, vistaInicial.getNombreJugadorUno());
				juego.setNombreJugador(2, vistaInicial.getNombreJugadorDos());
				Raza raza1;
				if (vistaInicial.getRazaSeleccionadaJG1().equalsIgnoreCase(
						Constants.TERRAN)) {
					raza1 = new Terran(juego);
				} else {
					raza1 = new Protoss(juego);
				}
				juego.setRazaJugador(1, raza1);
				Raza raza2;
				if (vistaInicial.getRazaSeleccionadaJG2().equalsIgnoreCase(
						Constants.TERRAN)) {
					raza2 = new Terran(juego);
				} else {
					raza2 = new Protoss(juego);
				}
				juego.setRazaJugador(2, raza2);
				juego.setColorJugador(1, vistaInicial.getColorSeleccionadoJG1());
				juego.setColorJugador(2, vistaInicial.getColorSeleccionadoJG2());

				vistaInicial.cerrarVentanaInicio();
				try {
					vistaJuego = new VistaJuego(juego);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} catch (CompletarDatosException e1) {
				vistaInicial.mostrarError("Debe completar todos los datos de los jugadores.");
			} catch (NombreYaExiste e1) {
				vistaInicial.mostrarError("Los nombres no pueden ser iguales.");
			} catch (JugadorInvalido e1) {
				vistaInicial.mostrarError("Jugador invalido.");
			} catch (NombreConMenosDe4Caracteres e1) {
				vistaInicial
						.mostrarError("El nombre debe tener mas de 4 caracteres.");
			} catch (ColorYaExiste e1) {
				vistaInicial.mostrarError("El color ya fue seleccionado.");
			}

		}
	}

	public ActionListener getListenerBotonGuardarJugadores() {
		return new EscuchaBotonGuardarJugadores();
	}

	public VistaJuego getVistaJuego() {
		return vistaJuego;
	}

	public void setVistaJuego(VistaJuego vistaJuego) {
		this.vistaJuego = vistaJuego;
	}

}
