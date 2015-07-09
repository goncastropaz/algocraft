package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Barraca;
import fiuba.algo3.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.modelo.construcciones.Fabrica;
import fiuba.algo3.modelo.construcciones.Refineria;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;

public class FabricaTest {

	@Test(expected = NoTieneEdificiosPrevios.class)
	public void testParaCrearseRequiereBarraca() throws CeldaOcupada,
			CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes,
			NoTieneEdificiosPrevios, CeldaInvalida, FueraDeMatriz {
		Juego juego = new Juego();

		CentroDeMineral centro = new CentroDeMineral(new Posicion(4, 4));
		Refineria refineria = new Refineria(new Posicion(5, 5));
		juego.agregarConstruccion(centro, new Posicion(4, 4));
		juego.agregarConstruccion(refineria, new Posicion(5, 5));

		for (int i = 0; i < 100; i++)
			juego.cambiarTurnoJugador();

		juego.agregarConstruccion(new Fabrica(new Posicion(10, 10)),
				new Posicion(10, 10));

	}

	@Test
	public void testSeCreaLuegoDeCrearUnaBarraca() throws CeldaOcupada,
			CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes,
			NoTieneEdificiosPrevios, CeldaInvalida, FueraDeMatriz {
		Juego juego = new Juego();

		juego.agregarConstruccion(new CentroDeMineral(new Posicion(4, 4)),
				new Posicion(4, 4));
		juego.agregarConstruccion(new Refineria(new Posicion(5, 5)),
				new Posicion(5, 5));

		for (int i = 0; i < 100; i++)
			juego.cambiarTurnoJugador();

		juego.agregarConstruccion(new Barraca(new Posicion(13, 13)),
				new Posicion(13, 13));

		Fabrica fabrica = new Fabrica(new Posicion(10, 10));
		juego.agregarConstruccion(fabrica,
				new Posicion(10, 10));
		
		assertTrue(fabrica.getCost().getMineral() == 200);

	}

}
