package fiuba.algo3.vista;

import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fiuba.algo3.control.ControlJuego;
import fiuba.algo3.control.ControlVistaJugador;
import fiuba.algo3.modelo.juego.Juego;


public class VistaJuego {

	private JFrame frame;
	private ControlJuego controlJuego;
	private VistaMapa vistaMapa;
	private ControlVistaJugador controlMapaJugador;
	
	private JLabel labelNombreJugador;
	private JLabel labelColorJugador;
	private JLabel labelRazaJugador;
	private JLabel labelEnergia;
	private JLabel labelMineral;
	private JLabel labelGas;
	private JLabel labelPoblacion;
	private JScrollPane Scrollmapa;
	private JPanel panelAcciones;


	public VistaJuego(Juego juego) throws IOException {
		this.frame = new JFrame();
		this.controlJuego = new ControlJuego(juego, this);
		this.controlMapaJugador = new ControlVistaJugador(juego);
		initialize();
	}

	private void initialize() throws IOException {

		this.frame.setBounds(100, 100, 700, 800);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.frame.getContentPane().setLayout(null);
		this.frame.setVisible(true);

		JLabel lNombre = new JLabel("Nombre:  "
				+ controlJuego.getNombreJugadorActual());
		lNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lNombre.setBounds(10, 11, 200, 14);
		this.labelNombreJugador = lNombre;
		this.frame.getContentPane().add(this.labelNombreJugador );

		JLabel lRaza = new JLabel("Raza:   "+ controlJuego.getRazaJugadorActual());
		lRaza.setFont(new Font("Arial", Font.BOLD, 14));
		lRaza.setBounds( 250, 11, 200, 14);
		this.labelRazaJugador = lRaza;
		this.frame.getContentPane().add(this.labelRazaJugador);

		JLabel lColor = new JLabel("Color:    "
				+ controlJuego.getColorJugadorActual());
		lColor.setFont(new Font("Arial", Font.BOLD, 14));
		lColor.setBounds(600, 11, 200, 14);
		this.labelColorJugador = lColor;
		this.frame.getContentPane().add(this.labelColorJugador);

		// JLabel imagenGas = new JLabel();
		// BufferedImage wGas =
		// ImageIO.read(this.getClass().getResource("/imagenes/recursos/gasVespeno2.jpg"));
		// ImageIcon gas = new ImageIcon(wGas);
		// imagenGas.setIcon(new
		// ImageIcon(gas.getImage().getScaledInstance(79,29,Image.SCALE_SMOOTH)));
		// imagenGas.setBounds(100, 40, 80, 40);
		// frame.getContentPane().add(imagenGas);
		
		String mineral =Integer.toString(controlJuego.getMineralJugadorActual());
		JLabel lMineral = new JLabel("Mineral:  "+ mineral);
		lMineral.setFont(new Font("Arial", Font.BOLD, 14));
		lMineral.setBounds(10, 50, 150, 14);
		this.labelMineral = lMineral;
		frame.getContentPane().add(this.labelMineral);

		String gas =Integer.toString(controlJuego.getGasJugadorActual());
		JLabel lGas = new JLabel("Gas Vespeno:  "+ gas);
		lGas.setFont(new Font("Arial", Font.BOLD, 14));
		lGas.setBounds(180, 50, 150, 14);
		this.labelGas = lGas;
		frame.getContentPane().add(this.labelGas);

		String poblacion =Integer.toString(controlJuego.getPoblacionJugadorActual());
		JLabel lPoblacion = new JLabel("Poblaci\u00F3n:  "+poblacion);
		lPoblacion.setFont(new Font("Arial", Font.BOLD, 14));
		lPoblacion.setBounds(350, 50, 150, 14);
		this.labelPoblacion = lPoblacion;
		frame.getContentPane().add(this.labelPoblacion);
		
				
		JLabel lEnergia = new JLabel("");
		lEnergia.setFont(new Font("Arial", Font.BOLD, 14));
		lEnergia.setBounds(550, 50, 200, 14);
		this.labelEnergia = lEnergia;
		this.labelEnergia.setVisible(false);
		frame.getContentPane().add(this.labelEnergia);


		JButton btnPasarTurno = new JButton("Pasar turno");
		btnPasarTurno.setFont(new Font("Arial", Font.BOLD, 14));
		btnPasarTurno.setBounds(150, 80, 200, 23);
		btnPasarTurno.addActionListener(controlJuego
				.getListenerBotonPasarTurno());
		this.frame.getContentPane().add(btnPasarTurno);

		JButton btnFinalizarPartida = new JButton("Finalizar partida");
		btnFinalizarPartida.setFont(new Font("Arial", Font.BOLD, 14));
		btnFinalizarPartida.setBounds(400, 80, 200, 23);
		btnFinalizarPartida.addActionListener(controlJuego
				.getListenerBotonFinalizarJuego());
		this.frame.getContentPane().add(btnFinalizarPartida);

		this.vistaMapa = new VistaMapa(controlJuego.getMapaDelJuego(),this.controlJuego.getControlMapa(),this.labelEnergia);
		this.vistaMapa.actualizarVista(this.controlMapaJugador);

		this.Scrollmapa = new JScrollPane(this.vistaMapa.getPanel());
		this.Scrollmapa.setBounds(10, 120, 800, 550);
		this.frame.getContentPane().add(this.Scrollmapa);
		
		this.panelAcciones = controlJuego.getVistaAcciones(this.controlJuego);
		this.frame.getContentPane().add(this.panelAcciones);

	}

	public void cambiarVistaJugador() {
		this.controlJuego.setCeldasSeleccionadasDefault();
		this.actualizarVista();
		this.frame.getContentPane().validate();
		this.frame.getContentPane().repaint();
	}

	public void actualizarVista() {
		this.labelNombreJugador.setText("Nombre:  "+ controlJuego.getNombreJugadorActual());
		this.labelColorJugador.setText("Color:    "+ controlJuego.getColorJugadorActual());
		this.labelRazaJugador.setText("Raza:   "+ controlJuego.getRazaJugadorActual());
		String mineral =Integer.toString(controlJuego.getMineralJugadorActual());
		this.labelMineral.setText("Mineral:  "+ mineral);
		String gas =Integer.toString(controlJuego.getGasJugadorActual());
		this.labelGas.setText("Gas Vespeno:  "+ gas);
		String poblacion =Integer.toString(controlJuego.getPoblacionJugadorActual());
		this.labelPoblacion.setText("Poblaci\u00F3n:  "+poblacion);
		this.labelEnergia.setVisible(false);

		this.vistaMapa.actualizarMapa();

		this.vistaMapa.actualizarVista(this.controlMapaJugador);
		
		this.controlMapaJugador.actualizarVistaBase(this.Scrollmapa);
		
		this.frame.getContentPane().remove(this.panelAcciones);
		this.panelAcciones = controlJuego.getVistaAcciones(this.controlJuego);
		this.frame.getContentPane().add(this.panelAcciones);

		
	}

	public void mostarFinalizarJuego() {
		this.frame.getContentPane().removeAll();

		JLabel lNombreJugador = new JLabel(
				"El juego ha sido finalizado, el ganador es: "
						+ controlJuego.getNombreJugadorActual());
		lNombreJugador.setFont(new Font("Arial", Font.BOLD, 14));
		lNombreJugador.setBounds(10, 20, 500, 27);
		this.frame.getContentPane().add(lNombreJugador);

		JButton btnFinalizarPartida = new JButton("Nueva partida");
		btnFinalizarPartida.setFont(new Font("Arial", Font.BOLD, 14));
		btnFinalizarPartida.setBounds(585, 408, 200, 23);
		btnFinalizarPartida.addActionListener(controlJuego
				.getListenerBotonCrearNuevoJuego());
		this.frame.getContentPane().add(btnFinalizarPartida);

		this.frame.getContentPane().validate();
		this.frame.getContentPane().repaint();
	}

	public void cerrarVentanaJuego() {
		frame.setVisible(false);
	}

	public void mostrarError(String string) {
		JOptionPane.showMessageDialog(frame, string);
		
	}

}
