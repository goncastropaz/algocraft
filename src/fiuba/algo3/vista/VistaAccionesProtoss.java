package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fiuba.algo3.control.ControlAcciones;
import fiuba.algo3.control.ControlAccionesProtoss;
import fiuba.algo3.control.ControlJuego;
import fiuba.algo3.modelo.excepciones.CapacidadInsuficiente;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaNoVisible;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinConstruccion;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.CeldaSinUnidad;
import fiuba.algo3.modelo.excepciones.CopiaNoCausaDanio;
import fiuba.algo3.modelo.excepciones.EdificioNoPuedeCrearUnidad;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.FueraDeRango;
import fiuba.algo3.modelo.excepciones.MagiaDesconocida;
import fiuba.algo3.modelo.excepciones.NaveVacia;
import fiuba.algo3.modelo.excepciones.NoHayUnidadParaMoverEnCelda;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.ObjetivoInvalido;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.excepciones.UnidadAereaNoSePuedeCargar;
import fiuba.algo3.modelo.excepciones.UnidadAtacadaInvalida;
import fiuba.algo3.modelo.excepciones.UnidadAtacanteInvalida;
import fiuba.algo3.modelo.excepciones.UnidadNoPerteneceAJugador;
import fiuba.algo3.modelo.excepciones.UnidadNoPuedeTransportar;
import fiuba.algo3.modelo.excepciones.UnidadNoTerminada;
import fiuba.algo3.modelo.excepciones.UnidadNoTieneMagia;


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
			
			JButton crear_nexo_Mineral = new JButton("Crear Nexo Mineral");
			crear_nexo_Mineral.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					crearConstruccion(1);
				}
			});
			crear_nexo_Mineral.setBounds(12,42,175,25);
			add(crear_nexo_Mineral);
		
			JLabel costoNexo = new JLabel("50 M");
			costoNexo.setFont(new Font("Arial", Font.BOLD, 14));
			costoNexo.setBounds(220,42,175,25);
			add(costoNexo);
			
			JButton crear_Pilon = new JButton("Crear Pilon");
			crear_Pilon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearConstruccion(2);
				}
			});
			crear_Pilon.setBounds(12,70,120,25);
			add(crear_Pilon);
			
			JLabel costoPilon = new JLabel("100 M");
			costoPilon.setFont(new Font("Arial", Font.BOLD, 14));
			costoPilon.setBounds(150,70,120,25);
			add(costoPilon);
			
			JButton crear_Asimilador = new JButton("Crear Asimilador");
			crear_Asimilador.setBounds(12, 98, 160, 25);
			crear_Asimilador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearConstruccion(3);
				}
			});
			add(crear_Asimilador);
			
			JLabel costoAsimilador = new JLabel("100 M");
			costoAsimilador.setFont(new Font("Arial", Font.BOLD, 14));
			costoAsimilador.setBounds(190, 98, 160, 25);
			add(costoAsimilador);
			
			JButton btnCrearAcceso = new JButton("Crear Acceso");
			btnCrearAcceso.setBounds(12, 129, 135, 25);
			btnCrearAcceso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearConstruccion(4);
				}
			});
			add(btnCrearAcceso);
			
			JLabel costoAcceso = new JLabel("150 M");
			costoAcceso.setFont(new Font("Arial", Font.BOLD, 14));
			costoAcceso.setBounds(180, 129, 135, 25);
			add(costoAcceso);
			
			JButton btnCrearPuerto = new JButton("Crear Puerto Estelar");
			btnCrearPuerto.setBounds(12, 160, 185, 25);
			btnCrearPuerto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearConstruccion(5);
				}
			});
			add(btnCrearPuerto);
			
			JLabel costoPuerto = new JLabel("150 M / 150 G");
			costoPuerto.setFont(new Font("Arial", Font.BOLD, 14));
			costoPuerto.setBounds(220, 160, 185, 25);
			add(costoPuerto);
			
			JButton btnCrearArchivo = new JButton("Crear Archivos Templarios");
			btnCrearArchivo.setBounds(12, 188, 218, 25);
			btnCrearArchivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearConstruccion(6);
				}
			});
			add(btnCrearArchivo);
			
			JLabel costoArchivo = new JLabel("150 M / 200 G");
			costoArchivo.setFont(new Font("Arial", Font.BOLD, 14));
			costoArchivo.setBounds(260, 188, 218, 25);
			add(costoArchivo);
			
			txtCrearUnidades = new JTextField();
			txtCrearUnidades.setBounds(12, 225, 171, 25);
			txtCrearUnidades.setForeground(new Color(255, 255, 255));
			txtCrearUnidades.setBackground(new Color(0, 153, 51));
			txtCrearUnidades.setText("CREAR UNIDADES");
			add(txtCrearUnidades);
			txtCrearUnidades.setColumns(11);
			
			JButton btnCrearZealot = new JButton("Crear Zealot");
			btnCrearZealot.setBounds(12, 256, 129, 25);
			btnCrearZealot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearUnidad(1);
				}
			});
			add(btnCrearZealot);
			
			JLabel costoZealot = new JLabel("100 M");
			costoZealot.setFont(new Font("Arial", Font.BOLD, 14));
			costoZealot.setBounds(160, 256, 129, 25);
			add(costoZealot);
			
			JButton btnCrearDragon = new JButton("Crear Dragon");
			btnCrearDragon.setBounds(12, 285, 135, 25);
			btnCrearDragon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearUnidad(2);
				}
			});
			add(btnCrearDragon);
			
			JLabel costoDragon = new JLabel("125 M / 50 G");
			costoDragon.setFont(new Font("Arial", Font.BOLD, 14));
			costoDragon.setBounds(180, 285, 135, 25);
			add(costoDragon);
			
			JButton btnCrearScout = new JButton("Crear Scout");
			btnCrearScout.setBounds(12, 315, 120, 25);
			btnCrearScout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearUnidad(3);
				}
			});
			add(btnCrearScout);
			
			JLabel costoScout = new JLabel("300 M / 150 G");
			costoScout.setFont(new Font("Arial", Font.BOLD, 14));
			costoScout.setBounds(160, 315, 120, 25);
			add(costoScout);
			
			JButton btnCrearAlto = new JButton("Crear Alto Templario");
			btnCrearAlto.setBounds(12, 347, 185, 25);
			btnCrearAlto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearUnidad(4);
				}
			});
			add(btnCrearAlto);
			
			JLabel costoAlto = new JLabel("50 M / 150 G");
			costoAlto.setFont(new Font("Arial", Font.BOLD, 14));
			costoAlto.setBounds(220, 347, 185, 25);
			add(costoAlto);
			
			JButton btnCrearNave = new JButton("Crear Nave Transportadora");
			btnCrearNave.setBounds(12, 378, 231, 25);
			btnCrearNave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearUnidad(5);
				}
			});
			add(btnCrearNave);
			
			JLabel costoNave = new JLabel("200 M");
			costoNave.setFont(new Font("Arial", Font.BOLD, 14));
			costoNave.setBounds(260, 378, 231, 25);
			add(costoNave);
			
			
			txtAcciones = new JTextField();
			txtAcciones.setBackground(new Color(255, 102, 0));
			txtAcciones.setForeground(new Color(255, 255, 255));
			txtAcciones.setText("ACCIONES");
			txtAcciones.setBounds(12, 415, 171, 25);
			add(txtAcciones);
			txtAcciones.setColumns(10);
			
			JButton btnNewButton_4 = new JButton("Mover Arriba");
			btnNewButton_4.setBounds(120, 446, 148, 25);
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mover(1);
				}
			});
			add(btnNewButton_4);
			
			JButton btnMoverAbajo = new JButton("Mover Abajo");
			btnMoverAbajo.setBounds(120, 476, 148, 25);
			btnMoverAbajo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mover(2);
				}
			});
			add(btnMoverAbajo);
			
			JButton btnMoverIzquierda = new JButton("Mover Izquierda");
			btnMoverIzquierda.setBounds(120, 507, 148, 25);
			btnMoverIzquierda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mover(4);
				}
			});
			add(btnMoverIzquierda);
			
			JButton btnMoverDerecha = new JButton("Mover Derecha");
			btnMoverDerecha.setBounds(120, 537, 148, 25);
			btnMoverDerecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mover(3);
				}
			});
			add(btnMoverDerecha);
			
			JButton btnCargar =   new JButton("<html>"+"Cargar "+"<br>"+"Unidades"+"<br>"+"en Nave"+"</html>");
			btnCargar.setBounds(280, 446, 100, 50);
			btnCargar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						controlAccionesProtoss.cargarEnNave(controlJuego.getPrimeraPosicion(),controlJuego.getUltimaPosicion());
						controlJuego.actualizarVista();
					} catch (CapacidadInsuficiente e1) {
						controlJuego.mostrarMensajeError("Capacidad insuficiente.");
					} catch (UnidadAereaNoSePuedeCargar e1) {
						controlJuego.mostrarMensajeError("No se puede cargar unidades aereas.");
					} catch (UnidadNoPerteneceAJugador e1) {
						controlJuego.mostrarMensajeError("La unidad no pertenece al jugador.");
					} catch (FueraDeRango e1) {
						controlJuego.mostrarMensajeError("Fuera de rango de la Unidad.");
					} catch (CeldaSinUnidad e1) {
						controlJuego.mostrarMensajeError("La celda seleccionada no posee una unidad.");
					} catch (UnidadNoPuedeTransportar e1) {
						controlJuego.mostrarMensajeError("La unidad seleccionada no puede transportar otras unidades.");
					} catch (UnidadNoTerminada e1) {
						controlJuego.mostrarMensajeError("La unidad no se ha terminado de construir.");
					}
					
				}
			});
			add(btnCargar);
			
			JButton btnDescargar =   new JButton("<html>"+"Descargar "+"<br>"+"Unidades"+"<br>"+"de Nave"+"</html>");
			btnDescargar.setBounds(280, 510, 100, 50);
			btnDescargar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						controlAccionesProtoss.descargarEnNave(controlJuego.getUltimaPosicion());
						controlJuego.actualizarVista();
					} catch (UnidadNoPuedeTransportar e1) {
						controlJuego.mostrarMensajeError("La unidad seleccionada no puede transportar otras unidades.");
					} catch (UnidadNoPerteneceAJugador e1) {
						controlJuego.mostrarMensajeError("La unidad no pertenece al jugador.");
					} catch (CeldaOcupada e1) {
						controlJuego.mostrarMensajeError("Celdas ocupadas para la descarga de unidades.");
					} catch (NaveVacia e1) {
						controlJuego.mostrarMensajeError("La nave esta vacia.");
					} catch (UnidadNoTerminada e1) {
						controlJuego.mostrarMensajeError("La unidad no se ha terminado de construir.");
					} catch (CeldaSinUnidad e1) {
						controlJuego.mostrarMensajeError("La celda seleccionada no posee una unidad.");
					}
				}
			});
			add(btnDescargar);
			
			JButton btnNewButton_5 = new JButton("Atacar");
			btnNewButton_5.setBounds(12, 574, 117, 25);
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try {
							controlAccionesProtoss.atacar(controlJuego.getPrimeraPosicion(),controlJuego.getUltimaPosicion());
							controlJuego.actualizarVista();
						} catch (ObjetivoInvalido e1) {
							controlJuego.mostrarMensajeError("El objetivo seleccionado para ser atacado es invalido.");
						} catch (UnidadAtacanteInvalida e1) {
							controlJuego.mostrarMensajeError("La unidad Atacante seleccionada no pertenece a sus tropas.");
						} catch (UnidadAtacadaInvalida e1) {
							controlJuego.mostrarMensajeError("La unidad seleccionada para ser atacada no pertenece a las tropas enemigas.");
						} catch (FueraDeRango e1) {
							controlJuego.mostrarMensajeError("El rango de su unidad no permite atacar a la unidad enemiga seleccionada.");
						} catch (CeldaSinUnidad e1) {
							controlJuego.mostrarMensajeError("La celda seleccionada no posee unidad para atacar.");
						} catch (UnidadNoTerminada e1) {
							controlJuego.mostrarMensajeError("La no esta terminada.");
						}
				}
			});
			add(btnNewButton_5);
			
			JButton btnEmp = new JButton("Tormenta Psionica");
			btnEmp.setBounds(120, 610, 170, 25);
			btnEmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					usarMagia(0);
				}
			});
			add(btnEmp);
			
			JLabel costoTormenta = new JLabel("75 E");
			costoTormenta.setFont(new Font("Arial", Font.BOLD, 14));
			costoTormenta.setBounds(300, 610, 170, 25);
			add(costoTormenta);
			
			JButton btnRadiacion = new JButton("Alucinacion");
			btnRadiacion.setBounds(120, 640, 117, 25);
			btnRadiacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					usarMagia(1);
				}
			});
			add(btnRadiacion);
			
			JLabel costoRadiacion = new JLabel("100 E");
			costoRadiacion.setFont(new Font("Arial", Font.BOLD, 14));
			costoRadiacion.setBounds(245, 640, 117, 25);
			add(costoRadiacion);
			
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
			} catch (CeldaInvalida e) {
				controlJuego.mostrarMensajeError("La construccion no puede ser creada en una celda con recursos.");
			} catch (CeldaOcupada e) {
				controlJuego.mostrarMensajeError("La construccion no puede ser creada en una celda ocupada.");
			} catch (CeldaSinRecurso e) {
				controlJuego.mostrarMensajeError("La construccion debe crearse sobre mineral.");
			} catch (CeldaEspacial e) {
				controlJuego.mostrarMensajeError("La construccion debe crearse sobre una celda terrestre.");
			} catch (RecursosInsuficientes e) {
				controlJuego.mostrarMensajeError("Recursos insuficientes.");
			} catch (NoTieneEdificiosPrevios e) {
				controlJuego.mostrarMensajeError("Requiere edificios previos");
			} catch (CeldaNoVisible e) {
				controlJuego.mostrarMensajeError("Celda no visible.");
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
		public void mover(int id){
			try {
				controlAccionesProtoss.mover(id, controlJuego.getUltimaPosicion());
				controlJuego.actualizarVista();
			} catch (FueraDeMatriz e) {
				controlJuego.mostrarMensajeError("No se puede mover la unidad fuera de los limites del mapa.");
			} catch (CeldaOcupada e) {
				controlJuego.mostrarMensajeError("No se puede mover la unidad a una celda ocupada.");
			} catch (NoHayUnidadParaMoverEnCelda e) {
				controlJuego.mostrarMensajeError("Seleccione una unidad para mover.");
			} catch (CeldaEspacial e) {
				controlJuego.mostrarMensajeError("No se puede mover la unidad terrestre a una celda espacial.");
			} catch (UnidadNoTerminada e1) {
				controlJuego.mostrarMensajeError("La no esta terminada.");
			}catch (UnidadAtacanteInvalida e1) {
				controlJuego.mostrarMensajeError("La unidad no pertenece a sus tropas.");
			}
		}
		
		public void usarMagia(int id){
			try {
				controlAccionesProtoss.magia(controlJuego.getPrimeraPosicion(),controlJuego.getUltimaPosicion(),id);
				controlJuego.actualizarVista();
			} catch (UnidadNoTieneMagia e) {
				controlJuego.mostrarMensajeError("La unidad seleccionada no tiene magias.");
			} catch (EnergiaInsuficiente e) {
				controlJuego.mostrarMensajeError("Energia insuficiente.");
			} catch (CopiaNoCausaDanio e) {
				controlJuego.mostrarMensajeError("La unidad copia no posee magias.");
			} catch (CeldaOcupada e) {
				controlJuego.mostrarMensajeError("Las celdas para la creacion de la unidad estan ocupadas.");
			} catch (CeldaEspacial e) {
				controlJuego.mostrarMensajeError("Unidad no puede crearse en celda espacial.");
			} catch (RecursosInsuficientes e) {
				controlJuego.mostrarMensajeError("Recursos insuficientes.");
			} catch (PoblacionInsuficiente e) {
				controlJuego.mostrarMensajeError("Poblacion insuficiente para crear unidad copia.");
			} catch (CeldaSinConstruccion e) {
				controlJuego.mostrarMensajeError("La celda seleccionada no posee construccion.");
			} catch (EdificioNoPuedeCrearUnidad e) {
				controlJuego.mostrarMensajeError("El edificio no puede crear unidad.");
			} catch (CeldaSinUnidad e) {
				controlJuego.mostrarMensajeError("La celda seleccionada no tiene unidad para copiar.");
			} catch (UnidadNoTerminada e1) {
				controlJuego.mostrarMensajeError("La no esta terminada.");
			}
		}

}

