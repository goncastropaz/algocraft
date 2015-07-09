package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Barraca;
import fiuba.algo3.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinConstruccion;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.EdificioNoPuedeCrearUnidad;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneConstruccion;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.Marine;

public class BarracaTest {

	@Test
	public void testEntrenaMarine() throws FueraDeMatriz, CeldaOcupada,
			CeldaSinRecurso, CeldaEspacial, CeldaInvalida,
			RazaNoTieneConstruccion, RecursosInsuficientes,
			NoTieneEdificiosPrevios, PoblacionInsuficiente,
			CeldaSinConstruccion, EdificioNoPuedeCrearUnidad {

		Juego juego = new Juego();

		Barraca construccion = new Barraca(new Posicion(1, 1));
		juego.agregarConstruccion(construccion, new Posicion(1, 1));
		
		CentroDeMineral centro = new CentroDeMineral(new Posicion(4, 4));
		juego.agregarConstruccion(centro, new Posicion(4, 4));
		
		for (int i = 0; i < 90; i++)
			juego.cambiarTurnoJugador();

		//Barraca requiere de población para crear marine.
		DepositoSuministro construccionDeposito = new DepositoSuministro(new Posicion(10, 10));
		juego.agregarConstruccion(construccionDeposito, new Posicion(10, 10));

		//Se crea la unidad marine en la barraca.
		Marine marine = new Marine();
		juego.agregarUnidad(marine, new Posicion(1, 1));
		
		assertTrue(marine.getCostoDeRecursos().getMineral() == 50);
	
	}
}
