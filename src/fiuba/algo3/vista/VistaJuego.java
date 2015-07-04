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

		this.frame.setBounds(100, 100, 730, 481);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		this.frame.setVisible(true);

		JLabel lNombre = new JLabel("Nombre: "
				+ controlJuego.getNombreJugadorActual());
		lNombre.setBounds(10, 11, 691, 14);
		this.frame.getContentPane().add(lNombre);

		JLabel lRaza = new JLabel("Raza      : Protoss");
		lRaza.setBounds(10, 36, 100, 14);
		this.frame.getContentPane().add(lRaza);
		
		JLabel lColor = new JLabel("Color: "
				+ controlJuego.getColorJugadorActual());
		lColor.setBounds(121, 36, 200, 14);
		this.frame.getContentPane().add(lColor);
		
		JLabel lEnergia = new JLabel("Energ\u00EDa    : 1200");
		lEnergia.setBounds(10, 73, 100, 14);
		frame.getContentPane().add(lEnergia);
		
//		JLabel imagenGas = new JLabel();
//		BufferedImage wGas = ImageIO.read(this.getClass().getResource("/imagenes/recursos/gasVespeno2.jpg"));
//		ImageIcon gas = new ImageIcon(wGas);
//		imagenGas.setIcon(new ImageIcon(gas.getImage().getScaledInstance(79,29,Image.SCALE_SMOOTH)));
//		imagenGas.setBounds(100, 40, 80, 40);
//		frame.getContentPane().add(imagenGas);

		JLabel lMineral = new JLabel("Minerales: 200");
		lMineral.setBounds(10, 98, 100, 14);
		frame.getContentPane().add(lMineral);

		JLabel lGas = new JLabel("Gas Vespeno: 500");
		lGas.setBounds(121, 98, 300, 14);
		frame.getContentPane().add(lGas);
		
		JLabel lPoblacion = new JLabel("Poblaci\u00F3n: 200");
		lPoblacion.setBounds(10, 130, 100, 14);
		frame.getContentPane().add(lPoblacion);
		
		JButton btnPasarTurno = new JButton("Pasar turno");
		btnPasarTurno.setBounds(465, 408, 103, 23);
		btnPasarTurno.addActionListener(controlJuego
				.getListenerBotonPasarTurno());
		this.frame.getContentPane().add(btnPasarTurno);
		
		JButton btnFinalizarPartida = new JButton("Finalizar partida");
		btnFinalizarPartida.setBounds(585, 408, 125, 23);
		btnFinalizarPartida.addActionListener(controlJuego
				.getListenerBotonFinalizarJuego());
		this.frame.getContentPane().add(btnFinalizarPartida);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 155, 694, 242);
		this.frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));


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
		lNombreJugador.setBounds(10, 20, 500, 27);
		this.frame.getContentPane().add(lNombreJugador);

		JButton btnFinalizarPartida = new JButton("Finalizar partida");
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
