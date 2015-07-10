package fiuba.algo3.modelo.construcciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaNoVisible;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.RazaNoTieneConstruccion;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.Marine;
import fiuba.algo3.modelo.unidades.Unidad;

public class CentroMineralTest {

	@Test(expected = CeldaSinRecurso.class)
	public void testSiLaCeldaNoTieneRecursoNoPuedeCrearse()
			throws FueraDeMatriz, CeldaOcupada, CeldaSinRecurso, CeldaEspacial,
			RazaNoTieneConstruccion, RecursosInsuficientes,
			NoTieneEdificiosPrevios, CeldaInvalida, CeldaNoVisible {
		Juego juego = new Juego();
		CentroDeMineral construccion = new CentroDeMineral(new Posicion(1, 1));
		juego.agregarConstruccion(construccion, new Posicion(1, 1));
	}

	@Test(expected = CeldaEspacial.class)
	public void testSoloSeCreaSobreUnaCeldaTerrestre() throws FueraDeMatriz,
			CeldaOcupada, CeldaSinRecurso, CeldaEspacial, CeldaInvalida {

		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
		unaCelda.setMineral();
		unaCelda.setAsEspacial();

		CentroDeMineral construccion = new CentroDeMineral(new Posicion(1, 1));
		unaCelda.setConstruccion(construccion);

	}

	@Test
	public void testSoloSeCreaSobreUnaCeldaTerrestreConMineral()
			throws FueraDeMatriz, CeldaOcupada, CeldaSinRecurso, CeldaEspacial, CeldaInvalida {

		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
		unaCelda.setMineral();

		CentroDeMineral construccion = new CentroDeMineral(new Posicion(1, 1));
		unaCelda.setConstruccion(construccion);
		
		assertTrue(construccion.esProductorMineral());


	}

	@Test
	public void testSeEncargaDeReunirElMineral() throws FueraDeMatriz,
			CeldaOcupada, CeldaSinRecurso, CeldaEspacial,
			RazaNoTieneConstruccion, RecursosInsuficientes,
			NoTieneEdificiosPrevios, CeldaInvalida, CeldaNoVisible {

		Juego juego = new Juego();

		//El juego se comienza con 200 Mineral para cada jugador.
		assertTrue(juego.getActualJugador().getRecursos().getMineral() == 200);

		CentroDeMineral construccion = new CentroDeMineral(new Posicion(4, 4));
		juego.agregarConstruccion(construccion, new Posicion(4, 4));
		
		for (int i = 0; i < 8; i++)
			juego.cambiarTurnoJugador();
		
		//Luego de 4 turnos se construye el Centro de mineral. Cuesta 50 Mineral.
		assertTrue(juego.getActualJugador().getRecursos().getMineral() == 150);
		
		for (int i = 0; i < 2; i++)
			juego.cambiarTurnoJugador();

		//Luego de construise, comienza a recolectar minerales.
		assertTrue(juego.getActualJugador().getRecursos().getMineral()  == 160);
	}

}
