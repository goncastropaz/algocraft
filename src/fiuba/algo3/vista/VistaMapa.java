package fiuba.algo3.vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.control.ControlMapa;
import fiuba.algo3.control.ControlVistaJugador;
import fiuba.algo3.modelo.juego.Mapa;
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
	private Icon noVisible;



	public VistaMapa(Mapa mapa, ControlMapa controlMapa) {
		this.controlMapa = controlMapa;
		
		tamanioMapa = 0;

		this.tierra = new ImageIcon(getClass().getResource(Constants.URL_TIERRA));
		this.agua = new ImageIcon(getClass().getResource(Constants.URL_AGUA));
		this.noVisible = new ImageIcon(getClass().getResource(Constants.URL_NEGRO));
		
		BufferedImage bufferMineral = null;
		BufferedImage bufferGas =null;
	
		try {
			bufferMineral = ImageIO.read(this.getClass().getResource(Constants.URL_MINERAL));
			bufferGas = ImageIO.read(this.getClass().getResource(Constants.URL_GAS));
			} catch (IOException e1) {
			e1.printStackTrace();
		}
		ImageIcon imagenIconMineral = new ImageIcon(bufferMineral);
		ImageIcon imagenIconGas = new ImageIcon(bufferGas);
		this.mineral = new ImageIcon(imagenIconMineral.getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH));
		this.gas = new ImageIcon(imagenIconGas.getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH));
		


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
				boton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						JButtonID celdaSeleccionada = (JButtonID) e.getSource();
						controlMapa.seleccionarCelda(celdaSeleccionada);
												
					}
				});	
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
					if (this.controlMapa.isMineral(i, j)) {
						
						mapa[i][j].setIcon(this.mineral);
					} else if (this.controlMapa.isGas(i, j)) {
						
						mapa[i][j].setIcon(this.gas);
					} else {
						mapa[i][j].setIcon(this.tierra);
					}

				} else {
					mapa[i][j].setIcon(this.agua);
				}

			}
		}
	}

	public void actualizarMapa() {
		this.setearImagenesDefault(this.mapa);
		this.controlMapa.actualizarMapa(this.mapa);
	}

	public void actualizarVista(ControlVistaJugador control) {
		
		this.mapaVisibleJugador(control);
	}
	
	public void mapaVisibleJugador(ControlVistaJugador controlVistaJugador){
		
			for (int fil = 0; fil < tamanioMapa; fil++) {
				for (int col = 0; col < tamanioMapa; col++) {
						if(!controlVistaJugador.esVisible(fil,col))  mapa[fil][col].setIcon(this.noVisible);
				}
			}
	

	}

}
