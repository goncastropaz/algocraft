package fiuba.algo3.algocraft.control;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import fiuba.algo3.algocraft.acciones.Ejecutable;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearAcceso;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.movimientos.Movimiento;
import fiuba.algo3.algocraft.vista.JButtonID;
import fiuba.algo3.algocraft.vista.VistaMapa;
import fiuba.algo3.classes.stats.Posicion;

public class ControlMapa {

	private Mapa mapa;
	private Juego juego;
	private Movimiento movimiento;

	private VistaMapa vistaMapa;

	public ControlMapa(VistaMapa vista) {
		vistaMapa = vista;
		juego = new Juego();
		mapa = juego.getMapaDeJuego();
		
		
	}

	private class EscuchaBotonSeleccionarCelda implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			final JButtonID celdaSeleccionada = (JButtonID) e.getSource();
			final Map<String,Ejecutable> acciones = getAccionesDisponibles(celdaSeleccionada.getFila(),celdaSeleccionada.getColumna());
			
			//--
			final JFrame frame = new JFrame("Acciones");
			 
	        // build poup menu
	        final JPopupMenu popup = new JPopupMenu();
	        // New project menu item
	        
	        for(final String key : acciones.keySet()){
	        	JButton btn = new JButton(key);
	    		btn.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	try {
							acciones.get(key).ejecutar(new Posicion(celdaSeleccionada.getFila(),celdaSeleccionada.getColumna()));
							frame.dispose();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(frame, e1.getMessage());
						}
		            }
	    		});
	    		frame.getContentPane().add(btn);
//		        JMenuItem menuItem = new JMenuItem(key);
//		        menuItem.setMnemonic(KeyEvent.VK_P);
//		        menuItem.getAccessibleContext().setAccessibleDescription(key);
//		        menuItem.addActionListener(new ActionListener() {
//		            public void actionPerformed(ActionEvent e) {
//		            	try {
//							acciones.get(key).ejecutar();
//						} catch (Exception e1) {
//							JOptionPane.showMessageDialog(frame, e1.getMessage());
//						}
//		            }
//		        });
//		        popup.add(menuItem);
	        }
	        frame.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mousePressed(MouseEvent e) {
	                showPopup(e);
	            }
	            @Override
	            public void mouseReleased(MouseEvent e) {
	                showPopup(e);
	            }
	            private void showPopup(MouseEvent e) {
	                if (e.isPopupTrigger()) {
	                    popup.show(e.getComponent(),
	                            e.getX(), e.getY());
	                }
	            }
	        });
	        frame.getContentPane().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setSize(200*acciones.size(), 100*acciones.size());
	        frame.setVisible(true);
		}
	}

	public ActionListener getListenerBotonSeleccionarCelda() {
		return new EscuchaBotonSeleccionarCelda();
	}

	public Map<String, Ejecutable> getAccionesDisponibles(int fila, int columna) {
//		return mapa.getCelda(fila, columna).getAcciones();
		Map<String, Ejecutable> map = new HashMap<String, Ejecutable>();
		//map.put("ASD", new Seleccionar());
		return map;
	}

	private class EscuchaBotonCrearEdificio implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// TODO: e debería traerme la interfaz de la accion
			// correspondiente.
			//Ejecutable ejecutable = new CrearAcceso();
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
