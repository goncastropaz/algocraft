package fiuba.algo3.vista;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import fiuba.algo3.control.ControlInicial;
import fiuba.algo3.modelo.excepciones.CompletarDatosException;
import fiuba.algo3.modelo.utiles.Constants;

public class VistaInicial {

	private JFrame frame;
	private ControlInicial control;

	private JTextField tfNombreJugadorUno;
	private JTextField tfNombreJugadorDos;
	private JRadioButton raza1JG1;
	private JRadioButton raza2JG1;
	private JRadioButton raza1JG2;
	private JRadioButton raza2JG2;
	private JRadioButton rojoJG1;
	private JRadioButton azulJG1;
	private JRadioButton rojoJG2;
	private JRadioButton azulJG2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicial window = new VistaInicial();
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
	public VistaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		control = new ControlInicial(this);

		frame = new JFrame();
		frame.setBounds(100, 100, 605, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tfNombreJugadorUno = new JTextField();
		tfNombreJugadorUno.setBounds(91, 37, 428, 27);
		frame.getContentPane().add(tfNombreJugadorUno);

		tfNombreJugadorDos = new JTextField();
		tfNombreJugadorDos.setBounds(91, 178, 428, 27);
		frame.getContentPane().add(tfNombreJugadorDos);

		// Datos Jugador 1

		JLabel nombreJugador1 = new JLabel("Nombre Jugador 1");
		nombreJugador1.setBounds(199, 11, 204, 27);
		frame.getContentPane().add(nombreJugador1);

		ButtonGroup buttonGroupRazaJG1 = new ButtonGroup();

		raza1JG1 = new JRadioButton(Constants.TERRAN);
		raza1JG1.setBounds(103, 75, 109, 23);
		buttonGroupRazaJG1.add(raza1JG1);
		frame.getContentPane().add(raza1JG1);

		raza2JG1 = new JRadioButton(Constants.PROTOSS);
		raza2JG1.setBounds(346, 75, 109, 23);
		buttonGroupRazaJG1.add(raza2JG1);
		frame.getContentPane().add(raza2JG1);

		ButtonGroup buttonGroupColorJG1 = new ButtonGroup();

		rojoJG1 = new JRadioButton(Constants.ROJO);
		rojoJG1.setBounds(103, 106, 55, 23);
		buttonGroupColorJG1.add(rojoJG1);
		frame.getContentPane().add(rojoJG1);

		azulJG1 = new JRadioButton(Constants.AZUL);
		azulJG1.setBounds(346, 106, 109, 23);
		buttonGroupColorJG1.add(azulJG1);
		frame.getContentPane().add(azulJG1);

		// Datos Jugador 2

		JLabel NombreJugador2 = new JLabel("Nombre Jugador 2");
		NombreJugador2.setBounds(199, 153, 204, 14);
		frame.getContentPane().add(NombreJugador2);

		ButtonGroup buttonGroupRazaJG2 = new ButtonGroup();

		raza1JG2 = new JRadioButton(Constants.TERRAN);
		raza1JG2.setBounds(103, 232, 109, 23);
		buttonGroupRazaJG2.add(raza1JG2);
		frame.getContentPane().add(raza1JG2);

		raza2JG2 = new JRadioButton(Constants.PROTOSS);
		raza2JG2.setBounds(346, 232, 109, 23);
		buttonGroupRazaJG2.add(raza2JG2);
		frame.getContentPane().add(raza2JG2);

		ButtonGroup buttonGroupColorJG2 = new ButtonGroup();

		rojoJG2 = new JRadioButton(Constants.ROJO);
		rojoJG2.setBounds(103, 263, 55, 23);
		buttonGroupColorJG2.add(rojoJG2);
		frame.getContentPane().add(rojoJG2);

		azulJG2 = new JRadioButton(Constants.AZUL);
		azulJG2.setBounds(346, 263, 109, 23);
		buttonGroupColorJG2.add(azulJG2);
		frame.getContentPane().add(azulJG2);

		JButton btnComenzarPartida = new JButton("Comenzar Partida");
		btnComenzarPartida.setBounds(197, 332, 172, 23);
		btnComenzarPartida.addActionListener(control
				.getListenerBotonGuardarJugadores());

		frame.getContentPane().add(btnComenzarPartida);

	}

	public void mostrarError(String string) {
		JOptionPane.showMessageDialog(frame, string);
	}

	public String getColorSeleccionadoJG1() throws CompletarDatosException {

		if (this.rojoJG1.isSelected()) {
			return this.rojoJG1.getText();
		} else if (this.azulJG1.isSelected()) {
			return this.azulJG1.getText();
		}
		throw new CompletarDatosException();
	}

	public String getColorSeleccionadoJG2() throws CompletarDatosException {

		if (this.rojoJG2.isSelected()) {
			return this.rojoJG2.getText();
		} else if (this.azulJG2.isSelected()) {
			return this.azulJG2.getText();
		}
		throw new CompletarDatosException();
	}

	public String getRazaSeleccionadaJG1() throws CompletarDatosException {

		if (this.raza1JG1.isSelected()) {
			return this.raza1JG1.getText();
		} else if (this.raza2JG1.isSelected()) {
			return this.raza2JG1.getText();
		}
		throw new CompletarDatosException();
	}

	public String getRazaSeleccionadaJG2() throws CompletarDatosException {

		if (this.raza1JG2.isSelected()) {
			return this.raza1JG2.getText();
		} else if (this.raza2JG2.isSelected()) {
			return this.raza2JG2.getText();
		}
		throw new CompletarDatosException();
	}

	public String getNombreJugadorUno() throws CompletarDatosException {

		if (tfNombreJugadorUno.getText().trim().equals("")) {
			throw new CompletarDatosException();
		}

		return tfNombreJugadorUno.getText();

	}

	public void setNombreJugadorUno(JTextField textField) {
		this.tfNombreJugadorUno = textField;
	}

	
	public String getNombreJugadorDos() throws CompletarDatosException {

		if (tfNombreJugadorDos.getText().trim().equals("")) {
			throw new CompletarDatosException();
		}
		return tfNombreJugadorDos.getText();
	}

	public void setNombreJugadorDos(JTextField textField_1) {
		this.tfNombreJugadorDos = textField_1;
	}

	public void cerrarVentanaInicio() {
		frame.setVisible(false);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void mostrarVentanaNuevoJuego() {
		frame.setVisible(true);		
	}

}
