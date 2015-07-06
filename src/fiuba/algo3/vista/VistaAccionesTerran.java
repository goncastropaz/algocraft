package fiuba.algo3.vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.Color;

public class VistaAccionesTerran extends JPanel {
	private JTextField txtCrearContrucciones;
	private JTextField txtCrearUnidades;
	private JTextField txtAcciones;
	private JTextField txtMover;
	private JTextField txtMagias;

	/**
	 * Create the panel.
	 */
	public VistaAccionesTerran() {
		setLayout(null);
		
		
		JTextField txtCrearConstrucciones = new JTextField();
		txtCrearConstrucciones.setForeground(new Color(255, 255, 255));
		txtCrearConstrucciones.setBackground(new Color(153, 0, 102));
		txtCrearConstrucciones.setText("CREAR CONSTRUCCIONES");
		txtCrearConstrucciones.setBounds(12,12,171,25);
		add(txtCrearConstrucciones);
		
		JButton crear_centro_Mineral = new JButton("Crear Centro de Mineral");
		crear_centro_Mineral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		crear_centro_Mineral.setBounds(12,42,204,25);
		add(crear_centro_Mineral);
	
		
		
		JButton crear_Barraca = new JButton("Crear Barraca");
		crear_Barraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		crear_Barraca.setBounds(12,70,132,25);
		add(crear_Barraca);
		
		JButton crear_DepositoSuministro = new JButton("Crear Deposito Suministro");
		crear_DepositoSuministro.setBounds(12, 98, 221, 25);
		crear_DepositoSuministro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(crear_DepositoSuministro);
		
		JButton btnCrearRefineria = new JButton("Crear Refineria");
		btnCrearRefineria.setBounds(12, 129, 141, 25);
		add(btnCrearRefineria);
		
		JButton btnCrearc = new JButton("Crear Marine");
		btnCrearc.setBounds(12, 256, 129, 25);
		add(btnCrearc);
		
		JButton btnNewButton = new JButton("Crear Puerto Estelar");
		btnNewButton.setBounds(12, 188, 179, 25);
		add(btnNewButton);
		
		txtCrearUnidades = new JTextField();
		txtCrearUnidades.setBounds(12, 225, 171, 25);
		txtCrearUnidades.setForeground(new Color(255, 255, 255));
		txtCrearUnidades.setBackground(new Color(0, 153, 51));
		txtCrearUnidades.setText("CREAR UNIDADES");
		add(txtCrearUnidades);
		txtCrearUnidades.setColumns(11);
		
		JButton btnCrearMarine = new JButton("Crear Fabrica");
		btnCrearMarine.setBounds(12, 160, 132, 25);
		add(btnCrearMarine);
		
		JButton btnNewButton_1 = new JButton("Crear Golliat");
		btnNewButton_1.setBounds(12, 285, 127, 25);
		add(btnNewButton_1);
		
		JButton btnCrearEspectro = new JButton("Crear Espectro");
		btnCrearEspectro.setBounds(12, 315, 141, 25);
		add(btnCrearEspectro);
		
		JButton btnNewButton_2 = new JButton("Crear Nave Ciencia");
		btnNewButton_2.setBounds(12, 347, 171, 25);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Crear Nave Transportadora");
		btnNewButton_3.setBounds(12, 378, 231, 25);
		add(btnNewButton_3);
		
		txtAcciones = new JTextField();
		txtAcciones.setBackground(new Color(255, 102, 0));
		txtAcciones.setForeground(new Color(255, 255, 255));
		txtAcciones.setText("ACCIONES");
		txtAcciones.setBounds(12, 415, 171, 25);
		add(txtAcciones);
		txtAcciones.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Mover Arriba");
		btnNewButton_4.setBounds(120, 446, 132, 25);
		add(btnNewButton_4);
		
		JButton btnMoverAbajo = new JButton("Mover Abajo");
		btnMoverAbajo.setBounds(120, 476, 132, 25);
		add(btnMoverAbajo);
		
		JButton btnMoverIzquierda = new JButton("Mover Izquierda");
		btnMoverIzquierda.setBounds(120, 507, 148, 25);
		add(btnMoverIzquierda);
		
		JButton btnMoverDerecha = new JButton("Mover Derecha");
		btnMoverDerecha.setBounds(120, 537, 141, 25);
		add(btnMoverDerecha);
		
		JButton btnNewButton_5 = new JButton("Atacar");
		btnNewButton_5.setBounds(12, 574, 117, 25);
		add(btnNewButton_5);
		
		JButton btnEmp = new JButton("EMP");
		btnEmp.setBounds(120, 610, 170, 25);
		add(btnEmp);
		
		JButton btnRadiacion = new JButton("Radiacion");
		btnRadiacion.setBounds(120, 640, 117, 25);
		add(btnRadiacion);
		
		txtMover = new JTextField();
		txtMover.setBackground(new Color(255, 255, 51));
		txtMover.setText("  MOVER");
		txtMover.setBounds(25, 477, 69, 55);
		add(txtMover);
		txtMover.setColumns(10);
		
		txtMagias = new JTextField();
		txtMagias.setBackground(new Color(255, 255, 51));
		txtMagias.setText("  MAGIAS");
		txtMagias.setBounds(25, 610, 69, 55);
		add(txtMagias);
		txtMagias.setColumns(10);
	

	}
}
