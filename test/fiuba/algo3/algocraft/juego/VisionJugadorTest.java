package fiuba.algo3.algocraft.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class VisionJugadorTest {

	
	@Test
	public void testVisionJugadorDeberiaCrearseConUnRangoDe5VisiblesDesdeLaBase() throws FueraDeMatriz{
		VisionJugador visionJ = new VisionJugador(new Posicion(4,4));
				
		assertTrue(visionJ.estaDescubierto(new Posicion(0,0)));
		assertTrue(visionJ.estaDescubierto(new Posicion(9,9)));
		assertTrue(visionJ.estaDescubierto(new Posicion(0,9)));
		assertTrue(visionJ.estaDescubierto(new Posicion(9,0)));
		assertFalse(visionJ.estaDescubierto(new Posicion(10,10)));
				
	}

	@Test
	public void testDescubrirCeldaDeberiaSetearLaCeldaComoVisible() throws FueraDeMatriz{
		VisionJugador visionJ = new VisionJugador(new Posicion(4,4));
		visionJ.descubrirCeldas(new Posicion(20,20));
		
		assertTrue(visionJ.estaDescubierto(new Posicion(20,20)));
				
	}
	
	@Test
	public void testSetRadioVisionDeberiaSetearComoVisibleTodasLasCeldasDeRadioALaPosicion() throws FueraDeMatriz{
		VisionJugador visionJ = new VisionJugador(new Posicion(4,4));
		visionJ.setRadioDeVision(new Posicion(20,20), 3);
		
		assertTrue(visionJ.estaDescubierto(new Posicion(17,17)));
		assertTrue(visionJ.estaDescubierto(new Posicion(23,17)));
		assertTrue(visionJ.estaDescubierto(new Posicion(23,23)));
		assertTrue(visionJ.estaDescubierto(new Posicion(17,23)));
				
	}
	
	@Test
	public void testSetRadioVisionNoDeberiaTenerEnCuentaFueraDeLosBordesDeLaMatrizSiElRadioEsMayor() throws FueraDeMatriz{
		VisionJugador visionJ = new VisionJugador(new Posicion(4,4));
		visionJ.setRadioDeVision(new Posicion(0,20), 3);
		
		assertTrue(visionJ.estaDescubierto(new Posicion(0,17)));
		assertTrue(visionJ.estaDescubierto(new Posicion(3,17)));
		assertTrue(visionJ.estaDescubierto(new Posicion(0,23)));
		assertTrue(visionJ.estaDescubierto(new Posicion(3,23)));
				
	}
}
