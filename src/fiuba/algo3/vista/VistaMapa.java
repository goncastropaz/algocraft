package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.control.ControlMapa;
import fiuba.algo3.modelo.juego.Mapa;

public class VistaMapa {

	private JPanel panelMapa;
	private ControlMapa controlMapa;
	private Mapa mapa;
	private int tamanioMapa;

	public VistaMapa(Mapa mapa) {
		controlMapa = new ControlMapa(this, mapa);
		tamanioMapa = (controlMapa.getMapa() != null)?10:controlMapa.getMapa().getTamanio();
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

		panelMapa = new JPanel();
		panelMapa.setBounds(1, 80, 700, 400);

		panelMapa.setBorder(new EmptyBorder(5, 5, 5, 5));
		int tamanio = 10;
		panelMapa.setLayout(new GridLayout(tamanioMapa, tamanioMapa));

		JButtonID[][] mapaBotones = new JButtonID[tamanioMapa][tamanioMapa];
		llenarArrayConLabels(mapaBotones);
		agregarLabels(mapaBotones);

	}

	public void llenarArrayConLabels(JButtonID tablero[][]) throws IOException {
//		tamanioMapa = controlMapa.getMapa().getTamanio();

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
//		tamanioMapa = controlMapa.getMapa().getTamanio();

		for (int i = 0; i < tamanioMapa; i++) {
			for (int j = 0; j < tamanioMapa; j++) {
				panelMapa.add(tablero[i][j]);
			}
		}
	}

	public JPanel getPanel() {
		return panelMapa;
	}

}
