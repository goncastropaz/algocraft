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

		this.tierra = new ImageIcon(getClass().getResource(
				"/imagenes/mapa/pasto.jpg"));
		this.agua = new ImageIcon(getClass().getResource(
				"/imagenes/mapa/agua.jpg"));
		// imagen gas
		// imagen mineral

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

	public VistaMapa(Mapa mapa, Jugador jugador) {
		this.controlMapa = new ControlMapa(this, mapa);
		this.tamanioMapa = 0;
		
		this.jugador = jugador;
		
		try {
			initializarMapa();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initializarMapa() throws IOException {

		this.tamanioMapa = 0;
		this.panelMapa = new JPanel();
		this.panelMapa.setBounds(1, 200, 900, 900);
		this.panelMapa.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.tamanioMapa = controlMapa.getMapa().getTamanio();

		GridLayout grid = new GridLayout(this.tamanioMapa, this.tamanioMapa);
		this.panelMapa.setLayout(grid);

		this.mapa = new JButtonID[this.tamanioMapa][this.tamanioMapa];
		llenarArrayConLabels(this.mapa);
		agregarLabels(this.mapa);
		setearImagenesDelJugador(this.mapa);

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
				if (this.controlMapa.isCeldaAerea(i, j)) {
					mapa[i][j].setIcon(this.agua);
				} else if (this.controlMapa.isMineral(i, j)) {
					mapa[i][j].setIcon(this.mineral);
				} else if (this.controlMapa.isGas(i, j)) {
					mapa[i][j].setIcon(this.gas);
				} else {
					mapa[i][j].setIcon(this.tierra);
				}

			}
		}
	}

	public void setearImagenesDelJugador(JButtonID mapa[][]) {
		VisionJugador vision = this.jugador.getVision();

		for (int i = 0; i < tamanioMapa; i++) {
			for (int j = 0; j < tamanioMapa; j++) {

				try {

					if (vision.estaDescubierto(new Posicion(i, j))) {
						if (this.controlMapa.isCeldaAerea(i, j)) {
							mapa[i][j].setIcon(new ImageIcon(getClass().getResource(
									Constants.URL_AGUA)));
						} else if (this.controlMapa.isMineral(i, j)) {
							BufferedImage bufferTierra;
							try {
								bufferTierra = ImageIO.read(this.getClass().getResource(Constants.URL_MINERAL));
								ImageIcon iTierra = new ImageIcon(bufferTierra);
								mapa[i][j].setIcon(new ImageIcon(iTierra.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));

							} catch (IOException e) {
								e.printStackTrace();
							}
							
						} else if (this.controlMapa.isGas(i, j)) {
							
							BufferedImage bufferTierra;
							try {
								bufferTierra = ImageIO.read(this.getClass().getResource(Constants.URL_GAS));
								ImageIcon iTierra = new ImageIcon(bufferTierra);
								mapa[i][j].setIcon(new ImageIcon(iTierra.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
							} catch (IOException e) {
								e.printStackTrace();
							}
								
						} else {
							mapa[i][j].setIcon(new ImageIcon(getClass().getResource(
									Constants.URL_TIERRA)));
						}

					} else {
						mapa[i][j].setBackground(Color.black);
					}

				} catch (FueraDeMatriz e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void actualizarVista(Jugador jugadorActual) {
		this.jugador = jugadorActual;

		try {
			initializarMapa();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
