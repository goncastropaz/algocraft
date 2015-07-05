package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.control.ControlMapa;
import fiuba.algo3.modelo.juego.Mapa;

public class VistaMapa {

	private JPanel panelMapa;
	private JScrollPane scrollPaneMapa;
	private ControlMapa controlMapa;
	private Mapa mapa;
	private int tamanioMapa;

	public VistaMapa(Mapa mapa) {
		controlMapa = new ControlMapa(this, mapa);
//		tamanioMapa = (controlMapa.getMapa() != null)?10:controlMapa.getMapa().getTamanio();
		tamanioMapa = 0;
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initialize() throws IOException {

		String directorio = "/src/imagenes/terrenoPasto.jpg";
		ImageIcon imagen;
		
		
		tamanioMapa = 0;

		panelMapa = new JPanel();
		panelMapa.setBounds(1, 200, 900, 900);
		
		panelMapa.setBorder(new EmptyBorder(5, 5, 5, 5));
		tamanioMapa = controlMapa.getMapa().getTamanio();
		panelMapa.setLayout(new GridLayout(tamanioMapa, tamanioMapa));

		JButtonID[][] mapaBotones = new JButtonID[tamanioMapa][tamanioMapa];
		llenarArrayConLabels(mapaBotones);
		agregarLabels(mapaBotones);

	}

	public void llenarArrayConLabels(JButtonID tablero[][]) throws IOException {

		for (int i = 0; i < tamanioMapa; i++) {
			for (int j = 0; j < tamanioMapa; j++) {
				final JButtonID boton = new JButtonID(i, j);
				boton.setBackground(Color.black);
				boton.addActionListener(controlMapa
						.getListenerBotonSeleccionarCelda());
				tablero[i][j] = boton;

			}
		}
	}

	public void agregarLabels(JButtonID tablero[][]) {

		for (int i = 0; i < tamanioMapa; i++) {
			for (int j = 0; j < tamanioMapa; j++) {
				panelMapa.add(tablero[i][j]);
			}
		}
	}

	public JPanel getPanel() {
		return panelMapa;
	}
	
	public JScrollPane getScrollPanel(){
		return new JScrollPane(panelMapa);
	}
	
	
}
