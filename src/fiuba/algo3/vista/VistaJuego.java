package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import fiuba.algo3.control.ControlJuego;
import fiuba.algo3.modelo.juego.Juego;

public class VistaJuego {

	private JFrame frame;
	private ControlJuego controlJuego;
	private VistaMapa vistaMapa;

	public VistaJuego(Juego juego) throws IOException {
		this.frame = new JFrame();
		this.controlJuego = new ControlJuego(juego, this);
		initialize();
	}

	private void initialize() throws IOException {

		this.frame.setBounds(100, 100, 700, 800);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.frame.getContentPane().setLayout(null);
		this.frame.setVisible(true);

		JLabel lNombre = new JLabel("Nombre: "
				+ controlJuego.getNombreJugadorActual());
		lNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lNombre.setBounds(10, 11, 691, 14);
		this.frame.getContentPane().add(lNombre);

		JLabel lRaza = new JLabel("Raza      : Protoss");
		lRaza.setFont(new Font("Arial", Font.BOLD, 12));
		lRaza.setBounds(10, 36, 100, 14);
		this.frame.getContentPane().add(lRaza);

		JLabel lColor = new JLabel("Color: "
				+ controlJuego.getColorJugadorActual());
		lColor.setFont(new Font("Arial", Font.BOLD, 12));
		lColor.setBounds(121, 36, 200, 14);
		this.frame.getContentPane().add(lColor);

		JLabel lEnergia = new JLabel("Energ\u00EDa    : 1200");
		lEnergia.setFont(new Font("Arial", Font.BOLD, 12));
		lEnergia.setBounds(10, 73, 100, 14);
		frame.getContentPane().add(lEnergia);

		// JLabel imagenGas = new JLabel();
		// BufferedImage wGas =
		// ImageIO.read(this.getClass().getResource("/imagenes/recursos/gasVespeno2.jpg"));
		// ImageIcon gas = new ImageIcon(wGas);
		// imagenGas.setIcon(new
		// ImageIcon(gas.getImage().getScaledInstance(79,29,Image.SCALE_SMOOTH)));
		// imagenGas.setBounds(100, 40, 80, 40);
		// frame.getContentPane().add(imagenGas);

		JLabel lMineral = new JLabel("Minerales: 200");
		lMineral.setFont(new Font("Arial", Font.BOLD, 12));
		lMineral.setBounds(10, 98, 100, 14);
		frame.getContentPane().add(lMineral);

		JLabel lGas = new JLabel("Gas Vespeno: 500");
		lGas.setFont(new Font("Arial", Font.BOLD, 12));
		lGas.setBounds(121, 98, 300, 14);
		frame.getContentPane().add(lGas);

		JLabel lPoblacion = new JLabel("Poblaci\u00F3n: 200");
		lPoblacion.setFont(new Font("Arial", Font.BOLD, 12));
		lPoblacion.setBounds(10, 130, 100, 14);
		frame.getContentPane().add(lPoblacion);

		JButton btnPasarTurno = new JButton("Pasar turno");
		btnPasarTurno.setFont(new Font("Arial", Font.BOLD, 12));
		btnPasarTurno.setBounds(390, 150, 103, 23);
		btnPasarTurno.addActionListener(controlJuego
				.getListenerBotonPasarTurno());
		this.frame.getContentPane().add(btnPasarTurno);

		JButton btnFinalizarPartida = new JButton("Finalizar partida");
		btnFinalizarPartida.setFont(new Font("Arial", Font.BOLD, 12));
		btnFinalizarPartida.setBounds(490, 150, 125, 23);
		btnFinalizarPartida.addActionListener(controlJuego
				.getListenerBotonFinalizarJuego());
		this.frame.getContentPane().add(btnFinalizarPartida);

		VistaMapa vistaMapa = new VistaMapa(controlJuego.getMapaDelJuego());

		JPanel panel = vistaMapa.getPanel();
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setBounds(10, 200, 500, 400);
		this.frame.getContentPane().add(scroll);

	}

	public void cambiarVistaJugador() {
		this.frame.getContentPane().removeAll();
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.frame.getContentPane().revalidate();
		this.frame.getContentPane().repaint();
	}

	public void mostarFinalizarJuego() {
		this.frame.getContentPane().removeAll();

		JLabel lNombreJugador = new JLabel(
				"El juego ha sido finalizado, el ganador es: "
						+ controlJuego.getNombreJugadorActual());
		lNombreJugador.setFont(new Font("Arial", Font.BOLD, 12));
		lNombreJugador.setBounds(10, 20, 500, 27);
		this.frame.getContentPane().add(lNombreJugador);

		JButton btnFinalizarPartida = new JButton("Nueva partida");
		btnFinalizarPartida.setFont(new Font("Arial", Font.BOLD, 12));
		btnFinalizarPartida.setBounds(585, 408, 125, 23);
		btnFinalizarPartida.addActionListener(controlJuego
				.getListenerBotonCrearNuevoJuego());
		this.frame.getContentPane().add(btnFinalizarPartida);

		this.frame.getContentPane().revalidate();
		this.frame.getContentPane().repaint();
	}

	public void cerrarVentanaJuego() {
		frame.setVisible(false);
	}

}
