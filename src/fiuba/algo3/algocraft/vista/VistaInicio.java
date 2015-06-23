package fiuba.algo3.algocraft.vista;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import fiuba.algo3.algocraft.control.ControlJuego;

public class VistaInicio {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private ControlJuego control;
	private JRadioButton raza1JG1;
	private JRadioButton raza1JG2;
	private JRadioButton rojoJG1;
	private JRadioButton rojoJG2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicio window = new VistaInicio();
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
	public VistaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		control = new ControlJuego(this);

		frame = new JFrame();
		frame.setBounds(100, 100, 605, 400);
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

		// Datos Jugador 1

		JLabel nombreJugador1 = new JLabel("Nombre Jugador 1");
		nombreJugador1.setBounds(199, 11, 204, 27);
		frame.getContentPane().add(nombreJugador1);

		ButtonGroup buttonGroupRazaJG1 = new ButtonGroup();

		raza1JG1 = new JRadioButton("Terran");
		raza1JG1.setBounds(103, 75, 109, 23);
		buttonGroupRazaJG1.add(raza1JG1);
		frame.getContentPane().add(raza1JG1);

		JRadioButton raza2JG1 = new JRadioButton("Protoss");
		raza2JG1.setBounds(346, 75, 109, 23);
		buttonGroupRazaJG1.add(raza2JG1);
		frame.getContentPane().add(raza2JG1);

		ButtonGroup buttonGroupColorJG1 = new ButtonGroup();

		rojoJG1 = new JRadioButton("Rojo");
		rojoJG1.setBounds(103, 106, 55, 23);
		buttonGroupColorJG1.add(rojoJG1);
		frame.getContentPane().add(rojoJG1);

		JRadioButton azulJG1 = new JRadioButton("Azul");
		azulJG1.setBounds(346, 106, 109, 23);
		buttonGroupColorJG1.add(azulJG1);
		frame.getContentPane().add(azulJG1);

		// Datos Jugador 2

		JLabel NombreJugador2 = new JLabel("Nombre Jugador 2");
		NombreJugador2.setBounds(199, 153, 204, 14);
		frame.getContentPane().add(NombreJugador2);

		ButtonGroup buttonGroupRazaJG2 = new ButtonGroup();

		raza1JG2 = new JRadioButton("Terran");
		raza1JG2.setBounds(103, 232, 109, 23);
		buttonGroupRazaJG2.add(raza1JG2);
		frame.getContentPane().add(raza1JG2);

		JRadioButton raza2JG2 = new JRadioButton("Protoss");
		raza2JG2.setBounds(346, 232, 109, 23);
		buttonGroupRazaJG2.add(raza2JG2);
		frame.getContentPane().add(raza2JG2);

		ButtonGroup buttonGroupColorJG2 = new ButtonGroup();

		rojoJG2 = new JRadioButton("Rojo");
		rojoJG2.setBounds(103, 263, 55, 23);
		buttonGroupColorJG2.add(rojoJG2);
		frame.getContentPane().add(rojoJG2);

		JRadioButton AzulJG2 = new JRadioButton("Azul");
		AzulJG2.setBounds(346, 263, 109, 23);
		buttonGroupColorJG2.add(AzulJG2);
		frame.getContentPane().add(AzulJG2);

		JButton btnComenzarPartida = new JButton("Comenzar Partida");
		btnComenzarPartida.setBounds(197, 332, 172, 23);
		btnComenzarPartida.addActionListener(control
				.getListenerBotonIniciarJuego());
		frame.getContentPane().add(btnComenzarPartida);

	}

	public void mostrarError(String string) {

		JOptionPane.showMessageDialog(frame, string);

	}
	public String getColorSeleccionadoJG1() {

		if (this.rojoJG1.isSelected()) {
			return "rojo";
		}
		return "azul";
	}

	public String getColorSeleccionadoJG2() {

		if (this.rojoJG2.isSelected()) {
			return "rojo";
		}
		return "azul";
	}

	public String getRazaSeleccionadaJG1() {

		if (this.raza1JG1.isSelected()) {
			return raza1JG1.getText();
		}
		return raza1JG1.getText();
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}	
	
	
}
