package fiuba.algo3.algocraft.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.excepciones.ColorYaExiste;
import fiuba.algo3.algocraft.excepciones.CompletarDatosException;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.algocraft.excepciones.NombreYaExiste;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.razas.Protoss;
import fiuba.algo3.algocraft.razas.Raza;
import fiuba.algo3.algocraft.razas.Terran;
import fiuba.algo3.algocraft.utils.Constants;
import fiuba.algo3.algocraft.vista.VistaInicial;
import fiuba.algo3.algocraft.vista.VistaJuego;

public class ControlInicial {
	private VistaInicial vistaInicial;
	private VistaJuego vistaJuego;
	private Juego juego;

	public ControlInicial(VistaInicial vista) {
		vistaInicial = vista;
		try {
			juego = Juego.getInstance();
		} catch (FueraDeMatriz e) {
			e.printStackTrace();
		}
	}
	
	private class EscuchaBotonGuardarJugadores implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				
				juego.setNombreJugador(1, vistaInicial.getTextField().getText());
				juego.setNombreJugador(2, vistaInicial.getTextField_1()
						.getText());
				Raza raza1;
				if (vistaInicial.getRazaSeleccionadaJG1().equalsIgnoreCase(
						Constants.TERRAN)) {
					raza1 = new Terran();
				} else {
					raza1 = new Protoss();
				}
				juego.setRazaJugador(1, raza1);
				Raza raza2;
				if (vistaInicial.getRazaSeleccionadaJG2().equalsIgnoreCase(
						Constants.TERRAN)) {
					raza2 = new Terran();
				} else {
					raza2 = new Protoss();
				}
				juego.setRazaJugador(2, raza2);
				juego.setColorJugador(1, vistaInicial.getColorSeleccionadoJG1());
				juego.setColorJugador(2, vistaInicial.getColorSeleccionadoJG2());

				vistaInicial.cerrarVentanaInicio();
				vistaJuego = new VistaJuego();

			} catch (CompletarDatosException e1) {
				vistaInicial.mostrarError("Debe completar todos los campos");
			} catch (NombreYaExiste e1) {
				vistaInicial.mostrarError("Los nombres no pueden ser iguales");
			} catch (JugadorInvalido e1) {
				vistaInicial.mostrarError("Jugador invalido");
			} catch (NombreConMenosDe4Caracteres e1) {
				vistaInicial
						.mostrarError("El nombre debe tener mas de 4 caracteres.");
			} catch (ColorYaExiste e1) {
				vistaInicial.mostrarError("El color ya existe");
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
