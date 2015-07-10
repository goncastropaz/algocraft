package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Acceso;
import fiuba.algo3.modelo.construcciones.ArchivoTemplario;
import fiuba.algo3.modelo.construcciones.Asimilador;
import fiuba.algo3.modelo.construcciones.Barraca;
import fiuba.algo3.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.modelo.construcciones.Fabrica;
import fiuba.algo3.modelo.construcciones.NexoMineral;
import fiuba.algo3.modelo.construcciones.Pilon;
import fiuba.algo3.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.modelo.construcciones.PuertoEstelarTerran;
import fiuba.algo3.modelo.construcciones.Refineria;
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
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.MagiaDesconocida;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.modelo.excepciones.NombreYaExiste;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.excepciones.UnidadNoTerminada;
import fiuba.algo3.modelo.excepciones.UnidadNoTieneMagia;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.AltoTemplario;
import fiuba.algo3.modelo.unidades.NaveCiencia;
import fiuba.algo3.modelo.unidades.Zealot;

public class NaveCienciaTest {

	@Test
	public void testSuma10DeEnergiaAlPasarElTurno() throws FueraDeMatriz,
			CeldaOcupada, CeldaSinRecurso, CeldaEspacial,
			RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida,
			PoblacionInsuficiente, CeldaSinConstruccion,
			EdificioNoPuedeCrearUnidad, NombreYaExiste, JugadorInvalido,
			NombreConMenosDe4Caracteres, CeldaNoVisible {

		Juego juego = new Juego();

		CentroDeMineral centro = new CentroDeMineral(new Posicion(4, 4));
		Refineria refineria = new Refineria(new Posicion(5, 5));
		juego.agregarConstruccion(centro, new Posicion(4, 4));
		juego.agregarConstruccion(refineria, new Posicion(5, 5));

		for (int i = 0; i < 100; i++)
			juego.cambiarTurnoJugador();

		juego.agregarConstruccion(new Barraca(new Posicion(9, 9)),
				new Posicion(9, 9));
		juego.agregarConstruccion(new Fabrica(new Posicion(8, 8)),
				new Posicion(8, 8));
		juego.agregarConstruccion(new DepositoSuministro(new Posicion(7, 7)),
				new Posicion(7, 7));
		for (int i = 0; i < 201; i++)
			juego.cambiarTurnoJugador();

		juego.agregarConstruccion(
				new PuertoEstelarTerran(new Posicion(9, 8)), new Posicion(9,
						8));

		for (int i = 0; i < 100; i++)
			juego.cambiarTurnoJugador();

		NaveCiencia nave = new NaveCiencia();
		juego.agregarUnidad(nave, new Posicion(9, 8));

		assertTrue(nave.getEnergia() == 50);

		// tarda 10 turnos en crerse, y luego comienza a generar 10 de energia.
		for (int i = 0; i < 22; i++)
			juego.cambiarTurnoJugador();

		assertTrue(nave.getEnergia() == 60);
	}

	@Test
	public void testAtacarConEmpHaceQueLasUnidadesMagicasEnemigasPierdanSuEnergiaYProtossSuEscudo() throws FueraDeMatriz, CeldaOcupada,
			CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes,
			NoTieneEdificiosPrevios, CeldaInvalida, PoblacionInsuficiente,
			CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, UnidadNoTieneMagia, EnergiaInsuficiente, CopiaNoCausaDanio, MagiaDesconocida, CeldaSinUnidad, CeldaNoVisible, UnidadNoTerminada {
		
		Juego juego = new Juego();
		
		//Jugador uno TERRAN
		juego.agregarConstruccion(new CentroDeMineral(new Posicion(4, 4)), new Posicion(4, 4));
		juego.agregarConstruccion(new Refineria(new Posicion(5, 5)), new Posicion(5, 5));
		
		juego.cambiarTurnoJugador();

		//Jugador dos PROTOSS
		juego.agregarConstruccion(new NexoMineral(new Posicion(45, 45)), new Posicion(45, 45));
		juego.agregarConstruccion(new Asimilador(new Posicion(46, 46)), new Posicion(46, 46));

		//Se recolectan minerales y gas para poder construir los edificios.
		for (int i = 0; i < 201; i++)juego.cambiarTurnoJugador();

		//Jugador uno TERRAN
		juego.agregarConstruccion(new Barraca(new Posicion(9, 9)), new Posicion(9, 9));
		juego.agregarConstruccion(new Fabrica(new Posicion(8, 8)), new Posicion(8, 8));
		juego.agregarConstruccion(new DepositoSuministro(new Posicion(7, 7)), new Posicion(7, 7));
		
		//Jugador dos PROTOSS
		juego.agregarConstruccion(new Pilon(new Posicion(47, 47)), new Posicion(47,47));
		juego.agregarConstruccion(new Acceso(new Posicion(47, 48)), new Posicion(47, 48));
		
		for (int i = 0; i < 201; i++)juego.cambiarTurnoJugador();
		
		//Jugador uno TERRAN
		juego.agregarConstruccion(new PuertoEstelarTerran(new Posicion(6, 5)), new Posicion(6, 5));
		
		juego.cambiarTurnoJugador();
		
		//Jugador dos PROTOSS
		juego.agregarConstruccion(new PuertoEstelarProtoss(new Posicion(40, 40)), new Posicion(40, 40));
		juego.agregarConstruccion(new ArchivoTemplario(new Posicion(43, 42)), new Posicion(43,42));
		
		for (int i = 0; i < 101; i++) juego.cambiarTurnoJugador();
		
		//Jugador uno TERRAN
		NaveCiencia naveCienciaUno = new NaveCiencia();
		juego.agregarUnidad(naveCienciaUno, new Posicion(6, 5));

		juego.cambiarTurnoJugador();
		
		//Jugador dos PROTOSS
		AltoTemplario altoTemplario = new AltoTemplario();
		juego.agregarUnidad(altoTemplario, new Posicion(43,42));
		Zealot zealot = new Zealot();
		juego.agregarUnidad(zealot, new Posicion(47,48));
		
		for (int i = 0; i <100; i++)juego.cambiarTurnoJugador();

		juego.getMapaDeJuego().devolverCelda(new Posicion(2,2)).setUnidad(altoTemplario);
		juego.getMapaDeJuego().devolverCelda(new Posicion(1,1)).setUnidad(zealot);
		
		juego.cambiarTurnoJugador();
		
		juego.usarMagia(new Posicion(5,6), "EMP", new Posicion(2,2));

		assertTrue(altoTemplario.getEnergia() == 0);
		assertTrue(zealot.getEscudo().getEscudoActual() == 0);
	}
	
	@Test
	public void testAtaqueRadiacionAfectaUnaUnidadEnParticularYLeSacaVidaALaUnidadQueSeEncuentreCerca()
			throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial,
			RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida,
			FueraDeMatriz, PoblacionInsuficiente, CeldaSinConstruccion,
			EdificioNoPuedeCrearUnidad, UnidadNoTieneMagia,
			EnergiaInsuficiente, CopiaNoCausaDanio, CeldaSinUnidad, CeldaNoVisible, UnidadNoTerminada {

		Juego juego = new Juego();

		// Jugador uno TERRAN
		juego.agregarConstruccion(new CentroDeMineral(new Posicion(4, 4)),
				new Posicion(4, 4));
		juego.agregarConstruccion(new Refineria(new Posicion(5, 5)),
				new Posicion(5, 5));

		juego.cambiarTurnoJugador();

		// Jugador dos PROTOSS
		juego.agregarConstruccion(new NexoMineral(new Posicion(45, 45)),
				new Posicion(45, 45));
		juego.agregarConstruccion(new Asimilador(new Posicion(46, 46)),
				new Posicion(46, 46));

		// Se recolectan minerales y gas para poder construir los edificios.
		for (int i = 0; i < 201; i++)
			juego.cambiarTurnoJugador();

		// Jugador uno TERRAN
		juego.agregarConstruccion(new Barraca(new Posicion(9, 9)),
				new Posicion(9, 9));
		juego.agregarConstruccion(new Fabrica(new Posicion(8, 8)),
				new Posicion(8, 8));
		juego.agregarConstruccion(new DepositoSuministro(new Posicion(7, 7)),
				new Posicion(7, 7));

		//juego.cambiarTurnoJugador();

		// Jugador dos PROTOSS
		juego.agregarConstruccion(new Pilon(new Posicion(44, 44)),
				new Posicion(44, 44));
		juego.agregarConstruccion(new Acceso(new Posicion(43, 44)),
				new Posicion(43, 44));

		for (int i = 0; i < 201; i++)
			juego.cambiarTurnoJugador();

		// Jugador uno TERRAN
		juego.agregarConstruccion(
				new PuertoEstelarTerran(new Posicion(6, 5)), new Posicion(6,
						5));

		for (int i = 0; i < 100; i++)
			juego.cambiarTurnoJugador();

		// Jugador uno TERRAN
		NaveCiencia naveCienciaUno = new NaveCiencia();
		juego.agregarUnidad(naveCienciaUno, new Posicion(6, 5));

		juego.cambiarTurnoJugador();

		// Jugador dos PROTOSS
		Zealot unZealot = new Zealot();
		Zealot otroZealot = new Zealot();
		juego.agregarUnidad(unZealot, new Posicion(43, 44));
		juego.agregarUnidad(otroZealot, new Posicion(43, 44));

		for (int i = 0; i < 100; i++)
			juego.cambiarTurnoJugador();

		juego.getMapaDeJuego().devolverCelda(new Posicion(1, 1))
				.setUnidad(unZealot);
		juego.getMapaDeJuego().devolverCelda(new Posicion(0, 0))
				.setUnidad(otroZealot);

		juego.cambiarTurnoJugador();

		juego.usarMagia(new Posicion(5, 6), "RADIACION", new Posicion(1, 1));

		juego.cambiarTurnoJugador();
		juego.cambiarTurnoJugador();

		assertTrue(unZealot.getVida().getVidaActual() < unZealot.getVida()
				.getVidaMaxima());
		assertTrue(otroZealot.getVida().getVidaActual() < otroZealot.getVida()
				.getVidaMaxima());

	}
	
	
}
