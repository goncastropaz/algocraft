package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Acceso;
import fiuba.algo3.modelo.construcciones.ArchivoTemplario;
import fiuba.algo3.modelo.construcciones.Asimilador;
import fiuba.algo3.modelo.construcciones.NexoMineral;
import fiuba.algo3.modelo.construcciones.Pilon;
import fiuba.algo3.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinConstruccion;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.EdificioNoPuedeCrearUnidad;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.modelo.excepciones.NombreYaExiste;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.AltoTemplario;

public class AltoTemplarioTest {

	@Test
	public void testCrearUnAltoTemplarioCarga15DeEnergiaPorTurno() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, CeldaSinRecurso, CeldaEspacial, NoTieneEdificiosPrevios, CeldaInvalida, NombreYaExiste, JugadorInvalido, NombreConMenosDe4Caracteres{
		
		Juego juego = new Juego();
		
		// Se recolectan los recursos necesarios para crear las construcciones.
		juego.agregarConstruccion(new NexoMineral(new Posicion(4, 4)), new Posicion(4, 4));
		juego.agregarConstruccion(new Asimilador(new Posicion(5, 5)), new Posicion(5, 5));
		for (int i = 0; i < 150; i++)juego.cambiarTurnoJugador();
		juego.agregarConstruccion(new Pilon(new Posicion(14, 14)), new Posicion(14, 14));
		for (int i = 0; i < 18; i++)juego.cambiarTurnoJugador();
		juego.agregarConstruccion(new Acceso(new Posicion(9, 9)), new Posicion(9, 9));
		juego.agregarConstruccion(new PuertoEstelarProtoss(new Posicion(10, 10)), new Posicion(10, 10));
		juego.agregarConstruccion(new ArchivoTemplario(new Posicion(11, 11)), new Posicion(11, 11));
		for (int i = 0; i < 197; i++)juego.cambiarTurnoJugador();
		
		AltoTemplario unAltoTemplario = new AltoTemplario();
		juego.agregarUnidad(unAltoTemplario, new Posicion(11, 11));
		
		//Se crea con 50 de energia.
		assertTrue(unAltoTemplario.getEnergia() == 50);
		
		//El tiempo de construcción de un alto templario es de 7 turnos del jugador, luego comienza a cargar energia
		for (int i = 0; i <16; i++)juego.cambiarTurnoJugador();
		
		assertTrue(unAltoTemplario.getEnergia() == 65);
	}
	
//	@Test
//	public void testTormentaPsionicaInflinge100DanioATodasLasUnidadesQueEstenDebajoPorDosTurnos() throws NombreYaExiste, JugadorInvalido, NombreConMenosDe4Caracteres, CeldaOcupada, CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida, FueraDeMatriz, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad{
//		
//		Juego juego = new Juego();
//		
//		// Se recolectan los recursos necesarios para crear las construcciones.
//		juego.agregarConstruccion(new NexoMineral(new Posicion(4, 4)), new Posicion(4, 4));
//		juego.agregarConstruccion(new Asimilador(new Posicion(5, 5)), new Posicion(5, 5));
//		for (int i = 0; i < 100; i++)juego.cambiarTurnoJugador();
//		juego.agregarConstruccion(new Pilon(new Posicion(14, 14)), new Posicion(14, 14));
//		for (int i = 0; i < 10; i++)juego.cambiarTurnoJugador();
//		juego.agregarConstruccion(new Acceso(new Posicion(9, 9)), new Posicion(9, 9));
//		juego.agregarConstruccion(new PuertoEstelarProtoss(new Posicion(10, 10)), new Posicion(10, 10));
//		juego.agregarConstruccion(new ArchivoTemplario(new Posicion(11, 11)), new Posicion(11, 11));
//		for (int i = 0; i < 20; i++)juego.cambiarTurnoJugador();
//		
//		juego.agregarUnidad(new AltoTemplario(), new Posicion(11, 11));
//		
//		
//		
//		
//	}
}

