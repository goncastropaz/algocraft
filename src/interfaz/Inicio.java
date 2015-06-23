package interfaz;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Inicio {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
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
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(91, 37, 428, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(40);
		
		textField_1 = new JTextField();
		textField_1.setColumns(40);
		textField_1.setBounds(91, 178, 428, 27);
		frame.getContentPane().add(textField_1);
		
		//Datos Jugador 1
		
		JLabel NombreJugador1 = DefaultComponentFactory.getInstance().createTitle("Nombre Jugador 1");
		NombreJugador1.setBounds(199, 11, 204, 27);
		frame.getContentPane().add(NombreJugador1);
		
		ButtonGroup buttonGroupRazaJG1 = new ButtonGroup();
		
		JRadioButton raza1JG1 = new JRadioButton("Terran");
		raza1JG1.setBounds(103, 75, 109, 23);
		buttonGroupRazaJG1.add(raza1JG1);
		frame.getContentPane().add(raza1JG1);
		
		JRadioButton raza2JG1 = new JRadioButton("Protoss");
		raza2JG1.setBounds(346, 75, 109, 23);
		buttonGroupRazaJG1.add(raza2JG1);
		frame.getContentPane().add(raza2JG1);
		
		ButtonGroup buttonGroupColorJG1 = new ButtonGroup();
		
		JRadioButton RojoJG1 = new JRadioButton("Rojo");
		RojoJG1.setBounds(103, 106, 55, 23);
		buttonGroupColorJG1.add(RojoJG1);
		frame.getContentPane().add(RojoJG1);
		
		JRadioButton AzulJG1 = new JRadioButton("Azul");
		AzulJG1.setBounds(346, 106, 109, 23);
		buttonGroupColorJG1.add(AzulJG1);
		frame.getContentPane().add(AzulJG1);
		
		//Datos Jugador 2
		
		JLabel NombreJugador2 = DefaultComponentFactory.getInstance().createTitle("Nombre Jugador 2");
		NombreJugador2.setBounds(199, 153, 204, 14);
		frame.getContentPane().add(NombreJugador2);
		
		ButtonGroup buttonGroupRazaJG2 = new ButtonGroup();
		
		JRadioButton raza1JG2 = new JRadioButton("Terran");
		raza1JG2.setBounds(103, 232, 109, 23);
		buttonGroupRazaJG2.add(raza1JG2);
		frame.getContentPane().add(raza1JG2);
		
		JRadioButton raza2JG2 = new JRadioButton("Protoss");
		raza2JG2.setBounds(346, 232, 109, 23);
		buttonGroupRazaJG2.add(raza2JG2);
		frame.getContentPane().add(raza2JG2);
		
		ButtonGroup buttonGroupColorJG2 = new ButtonGroup();
		
		JRadioButton RojoJG2 = new JRadioButton("Rojo");
		RojoJG2.setBounds(103, 263, 55, 23);
		buttonGroupColorJG2.add(RojoJG2);
		frame.getContentPane().add(RojoJG2);
		
		JRadioButton AzulJG2 = new JRadioButton("Azul");
		AzulJG2.setBounds(346, 263, 109, 23);
		buttonGroupColorJG2.add(AzulJG2);
		frame.getContentPane().add(AzulJG2);
		
		
		JButton btnComenzarPartida = new JButton("Comenzar Partida");
		btnComenzarPartida.setBounds(197, 332, 172, 23);
		frame.getContentPane().add(btnComenzarPartida);
	
	}
}
