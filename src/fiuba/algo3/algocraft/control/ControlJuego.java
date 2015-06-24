package fiuba.algo3.algocraft.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.acciones.PasarTurno;
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
import fiuba.algo3.algocraft.vista.VistaInicio;
import fiuba.algo3.algocraft.vista.VistaMapa;

public class ControlJuego {
	private Juego juego;
	private ControlMapa controlMapa;
	private VistaInicio vistaInicio;
	private VistaMapa vistaMapa;
	

	public ControlJuego(VistaInicio vista) {
		vistaInicio = vista;
	}

	private class EscuchaBotonIniciarJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Boolean  error = false;
				juego = Juego.getInstance();
				try {
					juego.setNombreJugador(1,vistaInicio.getTextField().getText());
					juego.setNombreJugador(2,vistaInicio.getTextField_1().getText());
					Raza raza1;
					if(vistaInicio.getRazaSeleccionadaJG1().equalsIgnoreCase(Constants.TERRAN)){
						raza1 = new Terran();
					} else{
						raza1 = new Protoss();
					}
					juego.setRazaJugador(1,raza1);
					Raza raza2;
					if(vistaInicio.getRazaSeleccionadaJG2().equalsIgnoreCase(Constants.TERRAN)){
						raza2 = new Terran();
					} else{
						raza2 = new Protoss();
					}
					juego.setRazaJugador(2,raza2);
					juego.setColorJugador(1, vistaInicio.getColorSeleccionadoJG1());
					juego.setColorJugador(2, vistaInicio.getColorSeleccionadoJG2());
					 
				} catch (CompletarDatosException e1){
					error = true;
					vistaInicio.mostrarError("Debe completar todos los campos");
				} catch (NombreYaExiste e1) {
					error = true;
					vistaInicio.mostrarError("Los nombres no pueden ser iguales");
				} catch (JugadorInvalido e1) {
					error = true;
					vistaInicio.mostrarError("Jugador invalido");
				} catch (NombreConMenosDe4Caracteres e1) {
					error = true;
					vistaInicio.mostrarError("El nombre debe tener mas de 4 caracteres.");
				}catch (ColorYaExiste e1) {
					error = true;
					vistaInicio.mostrarError("El color ya existe");
				}
				if(!error){
					vistaMapa = new VistaMapa(vistaInicio.getFrame());
					controlMapa = new ControlMapa(vistaMapa);
				}

			} catch (FueraDeMatriz e1) {
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
