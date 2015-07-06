package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
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
	private JButtonID[][] mapa;
	private ControlMapa controlMapa;
	private int tamanioMapa;
	
	private Icon agua;
	private Icon tierra;
	private Icon mineral;
	private Icon gas;

	public VistaMapa(Mapa mapa) {
		controlMapa = new ControlMapa(this, mapa);
		tamanioMapa = 0;
		
		this.tierra  = new ImageIcon(getClass().getResource("/imagenes/mapa/pasto.jpg"));
		this.agua = new ImageIcon(getClass().getResource("/imagenes/mapa/agua.jpg"));
		//imagen gas
		//imagen mineral
		
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initialize() throws IOException {

		String directorio = "/src/imagenes/mapa/pasto2.jpg";
		ImageIcon imagen;
		
		
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
				//boton.setBackground(Color.black);
				boton.addActionListener(controlMapa
						.getListenerBotonSeleccionarCelda());
				Dimension dim = new Dimension(50,50);
				boton.setPreferredSize(dim);
				boton.setIcon(this.tierra);
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
		//	actualizar panel
		return panelMapa;
	}
	
	public JScrollPane getScrollPanel(){
		return new JScrollPane(panelMapa);
	}
	
	public void setearImagenesDefault(JButtonID mapa[][]){
		for (int i = 0; i < tamanioMapa; i++) {
			for (int j = 0; j < tamanioMapa; j++) {
				if(this.controlMapa.isCeldaAerea(i,j)){
					mapa[i][j].setIcon(this.agua);
				}
			}
		}
	}
	
	
}
