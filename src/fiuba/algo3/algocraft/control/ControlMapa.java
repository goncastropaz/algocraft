package fiuba.algo3.algocraft.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.acciones.Ejecutable;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearAcceso;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.movimientos.Movimiento;
import fiuba.algo3.algocraft.vista.VistaMapa;

public class ControlMapa {

	private Mapa mapa;
	private Juego juego;
	private Movimiento movimiento;

	private VistaMapa vistaMapa;

	public ControlMapa(VistaMapa vista) {
		vistaMapa = vista;
		try {
			juego = Juego.getInstance();
			mapa = Mapa.getInstance();
		} catch (FueraDeMatriz e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private class EscuchaBotonSeleccionarCelda implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// TODO este método solo se encarga de mostrar un menú en las
			// celdas.
			Celda celdaSeleccionada = (Celda) e.getSource();

			if (celdaSeleccionada == null) {
				// mostrar menú espacial
			} else {

				// mostrar menú
			}

		}
	}

	public ActionListener getListenerBotonSeleccionarCelda() {
		return new EscuchaBotonSeleccionarCelda();
	}

	private class EscuchaBotonCrearEdificio implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// TODO: e debería traerme la interfaz de la accion
			// correspondiente.
			Ejecutable ejecutable = new CrearAcceso();
			//
			// if(ejecutable.ejecutar()){
			// //actualizar vista
			// }else{
			// //Cartel de error al crear construccion
			// }
		}
	}

	public ActionListener getListenerBotonIniciarJuego() {
		return new EscuchaBotonCrearEdificio();
	}

	private class EscuchaBotonCrearUnidad implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO: e debería traerme la interfaz de la fábrica
			// correspondiente, y la posicion

			// vista.actualizarVista(fabrica.crearUnidad(posicion));
		}
	}

	public ActionListener getListenerBotonCrearUnidad() {
		return new EscuchaBotonCrearUnidad();
	}

	private class EscuchaBotonAtacar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO: e debería traerme la interfaz de ejecutable
			// correspondiente,

		}
	}

	public ActionListener getListenerBotonAtacar() {
		return new EscuchaBotonAtacar();
	}

	private class EscuchaBotonSeleccionarUnidad implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// vistaMostrarMenuUnidad

		}
	}

	public ActionListener getListenerBotonSeleccionarUnidad() {
		return new EscuchaBotonSeleccionarUnidad();
	}

	private class EscuchaBotonMoverUnidad implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO: e me tiene q traer la unidad seleccionada.
			// movimiento.mover(unidad);

		}
	}

	public ActionListener getListenerBotonMoverUnidad() {
		return new EscuchaBotonMoverUnidad();
	}

}
