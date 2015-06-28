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

public class VistaMapa {

	private JFrame frame;
	private JPanel panelMapa;
	private ControlMapa controlMapa;


	/**
	 * Create the application.
	 */
	public VistaMapa(JFrame frame) {
		this.frame = frame; 
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		controlMapa = new ControlMapa(this);
//		this.frame.getContentPane().removeAll();
//		this.frame.getContentPane().repaint();

		
		this.frame.setBounds(100, 100, 815, 603);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		String directorio = "/src/imagenes/terrenoPasto.jpg";
		ImageIcon imagen;

		panelMapa = new JPanel();
//		panelMapa.setBounds(10, 11, 779, 458);
		panelMapa.setBounds(42, 106, 419, 354);

		panelMapa.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelMapa.setLayout(new GridLayout(10, 10));
	
		JButtonID[][] mapaBotones = new JButtonID[10][10];
		llenarArrayConLabels(mapaBotones);
		agregarLabels(mapaBotones);
		frame.getContentPane().add(panelMapa);
//
//		JPanel panelSeleccion = new JPanel();
//		panelSeleccion.setBounds(10, 480, 100, 74);
//		frame.getContentPane().add(panelSeleccion);
//
//		JPanel panelOpciones = new JPanel();
//
//		panelOpciones.setBounds(120, 480, 669, 74);
//		frame.getContentPane().add(panelOpciones);
//
//		this.frame.getContentPane().revalidate();
//		this.frame.getContentPane().repaint();
	}
	
	
	public void llenarArrayConLabels(JButtonID tablero[][]) throws IOException{
		for (int i=0 ; i<10 ; i++){
			for (int j=0 ; j<10 ; j++){	
				final JButtonID boton = new JButtonID(i,j);
				boton.setBackground(Color.black);
				boton.addActionListener(controlMapa.getListenerBotonSeleccionarCelda());
				tablero[i][j] = boton;
				
			}
		}
	}
	
	public void agregarLabels(JButtonID tablero[][]){
		for (int i=0 ; i<10 ; i++){
			for (int j=0 ; j<10 ; j++){	
				panelMapa.add(tablero[i][j]);				
			}
		}
	}
	
}
