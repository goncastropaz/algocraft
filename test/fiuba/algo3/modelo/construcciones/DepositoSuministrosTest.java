package fiuba.algo3.modelo.construcciones;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaNoVisible;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;

public class DepositoSuministrosTest {
	
	@Test
	public void testSuma5ALaPoblacion() throws FueraDeMatriz, CeldaOcupada, CeldaSinRecurso, CeldaEspacial, RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida, CeldaNoVisible{
		Juego juego = new Juego();
		
		DepositoSuministro deposito = new DepositoSuministro(new Posicion(10,10));
		
		juego.agregarConstruccion(deposito, new Posicion(7,7));
		
		assertTrue(juego.getActualJugador().getPoblacion()  == 5);
		
		juego.cambiarTurnoJugador();
		juego.cambiarTurnoJugador();
		
		juego.agregarConstruccion( new DepositoSuministro(new Posicion(6,6)), new Posicion(6,6)); 
		
		assertTrue(juego.getActualJugador().getPoblacion()  == 10);
	}

}
