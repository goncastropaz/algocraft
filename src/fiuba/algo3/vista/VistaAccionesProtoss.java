package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fiuba.algo3.control.ControlAcciones;
import fiuba.algo3.control.ControlAccionesProtoss;
import fiuba.algo3.control.ControlJuego;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinConstruccion;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.EdificioNoPuedeCrearUnidad;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneConstruccion;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;

public class VistaAccionesProtoss extends JPanel{

		private JTextField txtCrearContrucciones;
		private JTextField txtCrearUnidades;
		private JTextField txtAcciones;
		private JTextField txtMover;
		private JTextField txtMagias;
		private ControlJuego controlJuego;
		private ControlAcciones controlAccionesProtoss;
	
		public VistaAccionesProtoss(ControlJuego control){
			this.controlJuego =control;
			this.controlAccionesProtoss = new ControlAccionesProtoss(control);
			initialize();			
		}
		
		private void initialize() {
			setLayout(null);
			
			
			JTextField txtCrearConstrucciones = new JTextField();
			txtCrearConstrucciones.setForeground(new Color(255, 255, 255));
			txtCrearConstrucciones.setBackground(new Color(153, 0, 102));
			txtCrearConstrucciones.setText("CREAR CONSTRUCCIONES");
			txtCrearConstrucciones.setBounds(12,12,171,25);
			add(txtCrearConstrucciones);
			
			JButton crear_centro_Mineral = new JButton("Crear Nexo Mineral");
			crear_centro_Mineral.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					crearConstruccion(1);
				}
			});
			crear_centro_Mineral.setBounds(12,42,175,25);
			add(crear_centro_Mineral);
		
			
			
			JButton crear_Barraca = new JButton("Crear Pilon");
			crear_Barraca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearConstruccion(2);
				}
			});
			crear_Barraca.setBounds(12,70,120,25);
			add(crear_Barraca);
			
			JButton crear_DepositoSuministro = new JButton("Crear Asimilador");
			crear_DepositoSuministro.setBounds(12, 98, 160, 25);
			crear_DepositoSuministro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearConstruccion(3);
				}
			});
			add(crear_DepositoSuministro);
			
			JButton btnCrearRefineria = new JButton("Crear Acceso");
			btnCrearRefineria.setBounds(12, 129, 135, 25);
			btnCrearRefineria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearConstruccion(4);
				}
			});
			add(btnCrearRefineria);
			
			JButton btnCrearc = new JButton("Crear Zealot");
			btnCrearc.setBounds(12, 256, 129, 25);
			btnCrearc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearUnidad(1);
				}
			});
			add(btnCrearc);
			
			JButton btnNewButton = new JButton("Crear Archivos Templarios");
			btnNewButton.setBounds(12, 188, 218, 25);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearConstruccion(6);
				}
			});
			add(btnNewButton);
			
			txtCrearUnidades = new JTextField();
			txtCrearUnidades.setBounds(12, 225, 171, 25);
			txtCrearUnidades.setForeground(new Color(255, 255, 255));
			txtCrearUnidades.setBackground(new Color(0, 153, 51));
			txtCrearUnidades.setText("CREAR UNIDADES");
			add(txtCrearUnidades);
			txtCrearUnidades.setColumns(11);
			
			JButton btnCrearMarine = new JButton("Crear Puerto Estelar");
			btnCrearMarine.setBounds(12, 160, 185, 25);
			btnCrearMarine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearConstruccion(5);
				}
			});
			add(btnCrearMarine);
			
			JButton btnNewButton_1 = new JButton("Crear Dragon");
			btnNewButton_1.setBounds(12, 285, 135, 25);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearUnidad(2);
				}
			});
			add(btnNewButton_1);
			
			JButton btnCrearEspectro = new JButton("Crear Scout");
			btnCrearEspectro.setBounds(12, 315, 120, 25);
			btnCrearEspectro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearUnidad(3);
				}
			});
			add(btnCrearEspectro);
			
			JButton btnNewButton_2 = new JButton("Crear Alto Templario");
			btnNewButton_2.setBounds(12, 347, 185, 25);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearUnidad(4);
				}
			});
			add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("Crear Nave Transportadora");
			btnNewButton_3.setBounds(12, 378, 231, 25);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearUnidad(5);
				}
			});
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
			
			JButton btnEmp = new JButton("Tormenta Psionica");
			btnEmp.setBounds(120, 610, 170, 25);
			add(btnEmp);
			
			JButton btnRadiacion = new JButton("Alucinacion");
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

		public void crearConstruccion(int id){
			try {
				controlAccionesProtoss.crearContruccion(id,controlJuego.getUltimaPosicion());
				controlJuego.actualizarVista();
			} catch (CeldaOcupada e) {
				controlJuego.mostrarMensajeError("La construccion no puede ser creada en una celda ocupada.");
			} catch (CeldaSinRecurso e) {
				controlJuego.mostrarMensajeError("La construccion debe crearse sobre mineral.");
			} catch (CeldaEspacial e) {
				controlJuego.mostrarMensajeError("La construccion debe crearse sobre una celda terrestre.");
			} catch (RazaNoTieneConstruccion e) {
				controlJuego.mostrarMensajeError("WHAT!?.");  //CHEQUEAR CON GON!!!
			} catch (RecursosInsuficientes e) {
				controlJuego.mostrarMensajeError("Recursos insuficientes.");
			} catch (NoTieneEdificiosPrevios e) {
				controlJuego.mostrarMensajeError("Requiere edificios previos");
			}
		}
		
		public void crearUnidad(int id){
			
			try {
				controlAccionesProtoss.crearUnidad(id, controlJuego.getUltimaPosicion());
				controlJuego.actualizarVista();
			} catch (CeldaOcupada e) {
				controlJuego.mostrarMensajeError("La unidad no tiene celda disponible para crearse.");
			} catch (RecursosInsuficientes e) {
				controlJuego.mostrarMensajeError("Recursos insuficientes para crear la unidad");
			} catch (PoblacionInsuficiente e) {
				controlJuego.mostrarMensajeError("Poblacion insuficiente para crear la unidad");
			} catch (CeldaSinConstruccion e) {
				controlJuego.mostrarMensajeError("Debe seleccionar la construccion correspondiente para crear la unidad.");
			} catch (EdificioNoPuedeCrearUnidad e) {
				controlJuego.mostrarMensajeError("Este edificio no habilita la creacion de la unidad.");
			}
	
	}

}

