package fiuba.algo3.algocraft.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.control.ControlJuego;

public class VistaJuego {

	private JFrame frame;
	private ControlJuego controlJuego;
	private VistaMapa vistaMapa;

	public VistaJuego() {
		frame = new JFrame();
		controlJuego = new ControlJuego(this);
		initialize();
	}

	private void initialize() {

		this.frame.setBounds(100, 100, 815, 603);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);

		JLabel lNombreJugador = new JLabel("Nombre Jugador: "
				+ controlJuego.getNombreJugadorActual());
		lNombreJugador.setBounds(199, 11, 204, 27);
		frame.getContentPane().add(lNombreJugador);

		vistaMapa = new VistaMapa(frame);

		JPanel panelOpciones = new JPanel();
		panelOpciones.setBounds(10, 480, 669, 74);
		JButton btnPasarTurno = new JButton("Pasar turno");
		btnPasarTurno.setBounds(197, 332, 172, 23);
		btnPasarTurno.addActionListener(controlJuego
				.getListenerBotonPasarTurno());
		panelOpciones.add(btnPasarTurno);
		
		JButton btnFinalizarJuego = new JButton("Finalizar juego");
		btnFinalizarJuego.setBounds(197, 332, 172, 23);
		btnFinalizarJuego.addActionListener(controlJuego
				.getListenerBotonFinalizarJuego());
		panelOpciones.add(btnFinalizarJuego);

		frame.getContentPane().add(panelOpciones);
		frame.setVisible(true);

	}

	public void cambiarVistaJugador() {
		this.frame.getContentPane().removeAll();
		initialize();
		this.frame.getContentPane().revalidate();
		this.frame.getContentPane().repaint();
	}

	public void mostarFinalizarJuego() {
		this.frame.getContentPane().removeAll();
		JLabel lNombreJugador = new JLabel("El juego ha sido finalizado, el ganador es: " + controlJuego.getNombreJugadorActual());
		lNombreJugador.setBounds(10, 20, 500, 27);
		frame.getContentPane().add(lNombreJugador);
		this.frame.getContentPane().revalidate();
		this.frame.getContentPane().repaint();
	}

}
