package fiuba.algo3.modelo.construcciones;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Barraca;
import fiuba.algo3.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.modelo.construcciones.Fabrica;
import fiuba.algo3.modelo.construcciones.PuertoEstelarTerran;
import fiuba.algo3.modelo.construcciones.Refineria;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaNoVisible;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;

public class PuertoEstelarTerranTest {

	@Test(expected = NoTieneEdificiosPrevios.class)
	public void testParaCrearseRequiereFabrica() throws CeldaOcupada,
			CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes,
			NoTieneEdificiosPrevios, CeldaInvalida, FueraDeMatriz, CeldaNoVisible {
		Juego juego = new Juego();

		CentroDeMineral centro = new CentroDeMineral(new Posicion(4, 4));
		Refineria refineria = new Refineria(new Posicion(5, 5));
		juego.agregarConstruccion(centro, new Posicion(4, 4));
		juego.agregarConstruccion(refineria, new Posicion(5, 5));

		for (int i = 0; i < 100; i++)
			juego.cambiarTurnoJugador();

		juego.agregarConstruccion(
				new PuertoEstelarTerran(new Posicion(7,7)), new Posicion(7,
						7));

	}

	@Test
	public void testSeCreaLuegoDeCrearUnaFabrica() throws FueraDeMatriz,
			CeldaOcupada, CeldaSinRecurso, CeldaEspacial,
			RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida, CeldaNoVisible {
		Juego juego = new Juego();

		CentroDeMineral centro = new CentroDeMineral(new Posicion(4, 4));
		Refineria refineria = new Refineria(new Posicion(5, 5));
		juego.agregarConstruccion(centro, new Posicion(4, 4));
		juego.agregarConstruccion(refineria, new Posicion(5, 5));

		for (int i = 0; i < 100; i++)
			juego.cambiarTurnoJugador();

		juego.agregarConstruccion(new Barraca(new Posicion(9, 9)),
				new Posicion(9, 9));
		juego.agregarConstruccion(new Fabrica(new Posicion(7,7)),
				new Posicion(7, 7));

		PuertoEstelarTerran puertoEstelar = new PuertoEstelarTerran(
				new Posicion(3,3));
		juego.agregarConstruccion(puertoEstelar, new Posicion(3,3));

		assertTrue(puertoEstelar.getCost().getGas() == 100);
	}
}
