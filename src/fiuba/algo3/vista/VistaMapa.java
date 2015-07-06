package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.control.ControlMapa;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.juego.VisionJugador;
import fiuba.algo3.modelo.utiles.Constants;

public class VistaMapa {

	private JPanel panelMapa;
	private JButtonID[][] mapa;
	private ControlMapa controlMapa;
	private int tamanioMapa;

	private Icon agua;
	private Icon tierra;
	private Icon mineral;
	private Icon gas;

	private Jugador jugador;


	public VistaMapa(Mapa mapa) {
		controlMapa = new ControlMapa(this, mapa);
		tamanioMapa = 0;

		this.tierra = new ImageIcon(getClass()
				.getResource(Constants.URL_TIERRA));
		this.agua = new ImageIcon(getClass().getResource(Constants.URL_AGUA));
		this.gas = new ImageIcon(getClass().getResource(Constants.URL_GAS));
		this.mineral = new ImageIcon(getClass().getResource(
				Constants.URL_MINERAL));

		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initialize() throws IOException {

		tamanioMapa = 0;

		panelMapa = new JPanel();
		panelMapa.setBounds(1, 200, 900, 900);

		panelMapa.setBorder(new EmptyBorder(5, 5, 5, 5));
		tamanioMapa = controlMapa.getMapa().getTamanio();
		GridLayout grid = new GridLayout(tamanioMapa, tamanioMapa);
		panelMapa.setLayout(grid);

		this.mapa = new JButtonID[tamanioMapa][tamanioMapa];
		llenarArrayConLabels(this.mapa);
		agregarLabels(this.mapa);
		setearImagenesDefault(this.mapa);
	}

	public void llenarArrayConLabels(JButtonID tablero[][]) throws IOException {

		for (int i = 0; i < tamanioMapa; i++) {
			for (int j = 0; j < tamanioMapa; j++) {
				final JButtonID boton = new JButtonID(i, j);
				boton.addActionListener(controlMapa
						.getListenerBotonSeleccionarCelda());
				Dimension dim = new Dimension(50, 50);
				boton.setPreferredSize(dim);
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

	public void setearImagenesDefault(JButtonID mapa[][]) {
		for (int i = 0; i < tamanioMapa; i++) {
			for (int j = 0; j < tamanioMapa; j++) {

				if (!this.controlMapa.isCeldaAerea(i, j)) {
					try {
						if (this.controlMapa.isMineral(i, j)) {
							BufferedImage bufferImage = ImageIO.read(this.getClass().getResource(Constants.URL_MINERAL));
							ImageIcon imagenIcon = new ImageIcon(bufferImage);
							mapa[i][j].setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH)));
						} else if (this.controlMapa.isGas(i, j)) {
							BufferedImage bufferImage = ImageIO.read(this.getClass().getResource(Constants.URL_GAS));
							ImageIcon imagenIcon = new ImageIcon(bufferImage);
							mapa[i][j].setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH)));
						} else {
							mapa[i][j].setIcon(this.tierra);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {
					mapa[i][j].setIcon(this.agua);
				}

			}
		}
	}

	public void actualizarMapa() {
		
	}

}
