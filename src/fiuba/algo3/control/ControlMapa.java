package fiuba.algo3.control;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import fiuba.algo3.modelo.acciones.Ejecutable;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Barraca;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.unidades.Marine;
import fiuba.algo3.vista.JButtonID;
import fiuba.algo3.vista.VistaMapa;
import fiuba.algo3.vista.construcciones.FabricaVistaConstruccion;
import fiuba.algo3.vista.unidades.FabricaVistaUnidad;

public class ControlMapa {

	private Mapa mapa;
	private VistaMapa vistaMapa;
	private Posicion primerCeldaSeleccionada;
	private Posicion segundaCeldaSeleccionada;

	private FabricaVistaConstruccion fabricaVistaConstruccion;
	private FabricaVistaUnidad fabricaVistaUnidad;

	public ControlMapa(Mapa mapa) {
		this.mapa = mapa;
		this.primerCeldaSeleccionada = null;
		this.segundaCeldaSeleccionada = null;
		this.fabricaVistaConstruccion = new FabricaVistaConstruccion();
		this.fabricaVistaUnidad = new FabricaVistaUnidad();

	}

	private class EscuchaBotonSeleccionarCelda implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	public ActionListener getListenerBotonSeleccionarCelda() {
		return new EscuchaBotonSeleccionarCelda();
	}

	public Map<String, Ejecutable> getAccionesDisponibles(int fila, int columna) {
		// return mapa.getCelda(fila, columna).getAcciones();
		Map<String, Ejecutable> map = new HashMap<String, Ejecutable>();
		// map.put("ASD", new Seleccionar());
		return map;
	}

	private class EscuchaBotonCrearEdificio implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// TODO: e debería traerme la interfaz de la accion
			// correspondiente.
			// Ejecutable ejecutable = new CrearAcceso();
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

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public boolean isCeldaAerea(int fil, int col) {
		try {
			return this.mapa.devolverCelda(new Posicion(fil, col)).isEspacial();
		} catch (FueraDeMatriz e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean isMineral(int fil, int col) {

		try {
			return this.mapa.devolverCelda(new Posicion(fil, col))
					.tieneMineral();
		} catch (FueraDeMatriz e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean isGas(int fil, int col) {

		try {
			return this.mapa.devolverCelda(new Posicion(fil, col)).tieneGas();
		} catch (FueraDeMatriz e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void seleccionarCelda(JButtonID celdaSeleccionada,JLabel lEnergia) {
		Posicion posCelda = null;
		try{
			posCelda = new Posicion(celdaSeleccionada.getFila(), celdaSeleccionada.getColumna());
		} catch (FueraDeMatriz e) {
			e.printStackTrace();
		}
		if(this.mapa.devolverCelda(posCelda).tieneUnidadMagica()){
			String energia =Integer.toString(this.mapa.devolverCelda(posCelda).getUnidad().getEnergia());
			lEnergia.setText("Energia:  "+ energia);
			lEnergia.setVisible(true);
		}else{
			lEnergia.setVisible(false);
		}
		this.primerCeldaSeleccionada = this.segundaCeldaSeleccionada;
		this.segundaCeldaSeleccionada = posCelda;
		
	}

	public void actualizarMapa(JButtonID[][] mapaDibujado) {
		
		int tamanioMapa = this.mapa.getTamanio();

		for (int i = 0; i < tamanioMapa; i++) {
			for (int j = 0; j < tamanioMapa; j++) {
				try {
					Celda celda = this.mapa.devolverCelda(new Posicion(i, j));

					if (celda.getConstruccion() != null) {
						this.fabricaVistaConstruccion.crearVistaConstruccion(celda.getConstruccion()).dibujar(mapaDibujado);
					} else if (celda.getUnidad() != null) {
						this.fabricaVistaUnidad.crearVistaUnidad(celda.getUnidad()).dibujar(mapaDibujado);
					}

				} catch (FueraDeMatriz e) {
					e.printStackTrace();
				}

			}
		}

	}

	public Posicion getUltimaPosicion() {
		return this.segundaCeldaSeleccionada;
	}
	
	public void setCeldasSeleccionadasDefault(){
		this.primerCeldaSeleccionada = null;
		this.segundaCeldaSeleccionada=null;
	}

	public Posicion getPrimeraPosicion() {
		return this.primerCeldaSeleccionada;
	}
}