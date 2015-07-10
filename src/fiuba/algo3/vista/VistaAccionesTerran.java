package fiuba.algo3.vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JToggleButton;
import javax.swing.JTextField;

import fiuba.algo3.control.ControlAcciones;
import fiuba.algo3.control.ControlAccionesProtoss;
import fiuba.algo3.control.ControlAccionesTerran;
import fiuba.algo3.control.ControlJuego;
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
import fiuba.algo3.modelo.excepciones.NoHayUnidadParaMoverEnCelda;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.ObjetivoInvalido;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneConstruccion;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.excepciones.UnidadAtacadaInvalida;
import fiuba.algo3.modelo.excepciones.UnidadAtacanteInvalida;
import fiuba.algo3.modelo.excepciones.UnidadNoTerminada;
import fiuba.algo3.modelo.excepciones.UnidadNoTieneMagia;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;

import java.awt.Color;
import java.awt.Font;

public class VistaAccionesTerran extends JPanel {
	private JTextField txtCrearContrucciones;
	private JTextField txtCrearUnidades;
	private JTextField txtAcciones;
	private JTextField txtMover;
	private JTextField txtMagias;
	private ControlJuego controlJuego;
	private ControlAcciones controlAccionesTerran;
	/**
	 * Create the panel.
	 */
	public VistaAccionesTerran(ControlJuego control) {
		this.controlJuego =control;
		this.controlAccionesTerran = new ControlAccionesTerran(control);
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
				crearConstruccion(1);
			}
		});
		crear_centro_Mineral.setBounds(12,42,204,25);
		add(crear_centro_Mineral);
	
		JLabel costoCentro = new JLabel("50 M");
		costoCentro.setFont(new Font("Arial", Font.BOLD, 14));
		costoCentro.setBounds(240,42,204,25);
		add(costoCentro);
		
		JButton crear_Barraca = new JButton("Crear Barraca");
		crear_Barraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearConstruccion(2);
			}
		});
		crear_Barraca.setBounds(12,70,132,25);
		add(crear_Barraca);
		
		JLabel costoBarraca = new JLabel("150 M");
		costoBarraca.setFont(new Font("Arial", Font.BOLD, 14));
		costoBarraca.setBounds(170,70,132,25);
		add(costoBarraca);
		
		JButton crear_DepositoSuministro = new JButton("Crear Deposito Suministro");
		crear_DepositoSuministro.setBounds(12, 98, 221, 25);
		crear_DepositoSuministro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearConstruccion(3);
			}
		});
		add(crear_DepositoSuministro);
		
		JLabel costoDeposito = new JLabel("100 M");
		costoDeposito.setFont(new Font("Arial", Font.BOLD, 14));
		costoDeposito.setBounds(250, 98, 221, 25);
		add(costoDeposito);
		
		JButton btnCrearRefineria = new JButton("Crear Refineria");
		btnCrearRefineria.setBounds(12, 129, 141, 25);
		btnCrearRefineria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearConstruccion(4);
			}
		});
		add(btnCrearRefineria);
		
		JLabel costoRefineria = new JLabel("100 M");
		costoRefineria.setFont(new Font("Arial", Font.BOLD, 14));
		costoRefineria.setBounds(180, 129, 141, 25);
		add(costoRefineria);
		
		JButton btnCrearFabrica = new JButton("Crear Fabrica");
		btnCrearFabrica.setBounds(12, 160, 132, 25);
		btnCrearFabrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearConstruccion(5);
			}
		});
		add(btnCrearFabrica);
		
		JLabel costoFabrica = new JLabel("200 M / 100 G");
		costoFabrica.setFont(new Font("Arial", Font.BOLD, 14));
		costoFabrica.setBounds(180, 160, 132, 25);
		add(costoFabrica);
		
		JButton btnNewButton = new JButton("Crear Puerto Estelar");
		btnNewButton.setBounds(12, 188, 179, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearConstruccion(6);
			}
		});
		add(btnNewButton);
		
		JLabel costoPuerto = new JLabel("150 M / 100 G");
		costoPuerto.setFont(new Font("Arial", Font.BOLD, 14));
		costoPuerto.setBounds(220, 188, 179, 25);
		add(costoPuerto);
		
		txtCrearUnidades = new JTextField();
		txtCrearUnidades.setBounds(12, 225, 171, 25);
		txtCrearUnidades.setForeground(new Color(255, 255, 255));
		txtCrearUnidades.setBackground(new Color(0, 153, 51));
		txtCrearUnidades.setText("CREAR UNIDADES");
		add(txtCrearUnidades);
		txtCrearUnidades.setColumns(11);
		
		JButton btnCrearMarine = new JButton("Crear Marine");
		btnCrearMarine.setBounds(12, 256, 129, 25);
		btnCrearMarine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearUnidad(1);
			}
		});
		add(btnCrearMarine);
		
		JLabel costoMarine = new JLabel("50 M");
		costoMarine.setFont(new Font("Arial", Font.BOLD, 14));
		costoMarine.setBounds(170, 256, 129, 25);
		add(costoMarine);
		
			
		JButton btnCrearGolliat = new JButton("Crear Golliat");
		btnCrearGolliat.setBounds(12, 285, 127, 25);
		btnCrearGolliat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearUnidad(2);
			}
		});
		add(btnCrearGolliat);
		
		JLabel costoGolliat = new JLabel("100 M / 50 G");
		costoGolliat.setFont(new Font("Arial", Font.BOLD, 14));
		costoGolliat.setBounds(170, 285, 127, 25);
		add(costoGolliat);
		
		JButton btnCrearEspectro = new JButton("Crear Espectro");
		btnCrearEspectro.setBounds(12, 315, 141, 25);
		btnCrearEspectro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearUnidad(3);
			}
		});
		add(btnCrearEspectro);
		
		JLabel costoEspectro = new JLabel("150 M / 100 G");
		costoEspectro.setFont(new Font("Arial", Font.BOLD, 14));
		costoEspectro.setBounds(170, 315, 141, 25);
		add(costoEspectro);
		
		JButton btnCrearNaveC = new JButton("Crear Nave Ciencia");
		btnCrearNaveC.setBounds(12, 347, 171, 25);
		btnCrearNaveC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearUnidad(4);
			}
		});
		add(btnCrearNaveC);
		
		JLabel costoNaveC = new JLabel("100 M / 225 G");
		costoNaveC.setFont(new Font("Arial", Font.BOLD, 14));
		costoNaveC.setBounds(200, 347, 171, 25);
		add(costoNaveC);
		
		JButton btnCrearNaveT = new JButton("Crear Nave Transportadora");
		btnCrearNaveT.setBounds(12, 378, 231, 25);
		btnCrearNaveT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearUnidad(5);
			}
		});
		add(btnCrearNaveT);
		
		JLabel costoNaveT = new JLabel("100 M / 100 G");
		costoNaveT.setFont(new Font("Arial", Font.BOLD, 14));
		costoNaveT.setBounds(250, 378, 231, 25);
		add(costoNaveT);
		
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
	
		JButton btnCargar =   new JButton("<html>"+"Cargar en"+"<br>"+"Nave"+"<br>"+"Transporte"+"</html>");
		btnCargar.setBounds(280, 446, 100, 110);
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		add(btnCargar);
		
		JButton btnNewButton_5 = new JButton("Atacar");
		btnNewButton_5.setBounds(12, 574, 117, 25);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlAccionesTerran.atacar(controlJuego.getPrimeraPosicion(),controlJuego.getUltimaPosicion());
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
				}catch (UnidadNoTerminada e1) {
					controlJuego.mostrarMensajeError("La no esta terminada.");
				}
		}	
			
		});
		add(btnNewButton_5);
		
		JButton btnEmp = new JButton("EMP");
		btnEmp.setBounds(120, 610, 170, 25);
		btnEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usarMagia(0);
			}
		});
		add(btnEmp);
		
		JLabel costoEMP = new JLabel("100 E");
		costoEMP.setFont(new Font("Arial", Font.BOLD, 14));
		costoEMP.setBounds(300, 610, 170, 25);
		add(costoEMP);
		
		
		JButton btnRadiacion = new JButton("Radiacion");
		btnRadiacion.setBounds(120, 640, 117, 25);
		btnRadiacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usarMagia(1);
			}
		});
		add(btnRadiacion);
		
		JLabel costoRadiacion = new JLabel("100 E");
		costoRadiacion.setFont(new Font("Arial", Font.BOLD, 14));
		costoRadiacion.setBounds(260, 640, 117, 25);
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
			controlAccionesTerran.crearContruccion(id,controlJuego.getUltimaPosicion());
			controlJuego.actualizarVista();
		}catch (CeldaInvalida e) {
			controlJuego.mostrarMensajeError("La construccion no puede ser creada en una celda con recursos.");
		} catch (CeldaOcupada e) {
			controlJuego.mostrarMensajeError("La construccion no puede ser creada en una celda ocupada.");
		} catch (CeldaSinRecurso e) {
			controlJuego.mostrarMensajeError("La construccion debe crearse sobre mineral.");
		} catch (CeldaEspacial e) {
			controlJuego.mostrarMensajeError("La construccion debe crearse sobre una celda terrestre.");
		} catch (RecursosInsuficientes e) {
			controlJuego.mostrarMensajeError("Recursos insuficientes para crear el edificio.");
		} catch (NoTieneEdificiosPrevios e) {
			controlJuego.mostrarMensajeError("Requiere edificios previos");
		}catch (CeldaNoVisible e) {
			controlJuego.mostrarMensajeError("Celda no visible.");
		}
	}
	
	public void crearUnidad(int id){
	
			try {
				controlAccionesTerran.crearUnidad(id, controlJuego.getUltimaPosicion());
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
			controlAccionesTerran.mover(id, controlJuego.getUltimaPosicion());
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
			controlAccionesTerran.magia(controlJuego.getPrimeraPosicion(),controlJuego.getUltimaPosicion(),id);
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
