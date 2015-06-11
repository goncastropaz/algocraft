package fiuba.algo3.algocraft.units.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.unidades.Marine;
import fiuba.algo3.algocraft.unidades.Zealot;
import fiuba.algo3.classes.stats.Posicion;

public class UnitTest {

	@Test
	public void testCrearMarine() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer maxHealth = 40;
		Integer maxShield = 0;
		Marine marine = new Marine(new Posicion(fila,columna));
		
		assertNotNull(marine);
		assertEquals(marine.getVida().getVidaMaxima(), maxHealth);
		assertEquals(marine.getEscudo().getEscudoTotal(), maxShield);
	}
	
	@Test
	public void testCrearZealot() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer maxHealth = 100;
		Integer maxShield = 60;
		Zealot zealot = new Zealot(new Posicion(fila,columna));
		
		assertNotNull(zealot);
		assertEquals(zealot.getVida().getVidaMaxima(), maxHealth);
		assertEquals(zealot.getEscudo().getEscudoTotal(), maxShield);
	}
	
	@Test
	public void testMoverMarine() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Marine marine = new Marine(new Posicion(fila,columna));
		
		
	}
	
}