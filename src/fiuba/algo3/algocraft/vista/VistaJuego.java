package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaJuego {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaJuego window = new VistaJuego();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaJuego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String directorio = "/src/imagenes/terrenoPasto.jpg";
		ImageIcon imagen;

		JPanel panelMapa = new JPanel();
		panelMapa.setBounds(10, 11, 779, 458);

		JButtonID[][] mapaBotones = new JButtonID[100][100];
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				JButtonID boton = new JButtonID(i, j);
				boton.setBackground(Color.black);
				mapaBotones[i][j] = boton;
				
				panelMapa.add(mapaBotones[i][j]);
			}
		}

		frame.getContentPane().add(panelMapa);


		JPanel panelSeleccion = new JPanel();
		panelSeleccion.setBounds(10, 480, 100, 74);
		frame.getContentPane().add(panelSeleccion);

		JPanel panelOpciones = new JPanel();
		panelOpciones.setBounds(120, 480, 669, 74);
		frame.getContentPane().add(panelOpciones);
	}
}
