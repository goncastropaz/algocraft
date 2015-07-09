package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;

public class DepositoSuministrosTest {
	
	@Test
	public void testSuma5ALaPoblacion() throws FueraDeMatriz, CeldaOcupada, CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida{
		Juego juego = new Juego();
		
		DepositoSuministro deposito = new DepositoSuministro(new Posicion(10,10));
		
		juego.agregarConstruccion(deposito, new Posicion(10,10));
		
		assertTrue(juego.getActualJugador().getPoblacion()  == 5);
		
		juego.cambiarTurnoJugador();
		juego.cambiarTurnoJugador();
		
		DepositoSuministro deposito2 = new DepositoSuministro(new Posicion(10,12));
		juego.agregarConstruccion(deposito2, new Posicion(12,12)); 
		
		assertTrue(juego.getActualJugador().getPoblacion()  == 10);
	}

}
