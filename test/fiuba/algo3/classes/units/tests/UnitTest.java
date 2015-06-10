package fiuba.algo3.classes.units.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.units.Marine;
import fiuba.algo3.classes.units.Zealot;

public class UnitTest {

	@Test
	public void testCrearMarine() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer maxHealth = 40;
		Integer maxShield = 0;
		Marine marine = new Marine(new Posicion(fila,columna));
		
		assertNotNull(marine);
		assertEquals(marine.getHealth().getMaxHealth(), maxHealth);
		assertEquals(marine.getShield().getMaxShield(), maxShield);
	}
	
	@Test
	public void testCrearZealot() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer maxHealth = 100;
		Integer maxShield = 60;
		Zealot zealot = new Zealot(new Posicion(fila,columna));
		
		assertNotNull(zealot);
		assertEquals(zealot.getHealth().getMaxHealth(), maxHealth);
		assertEquals(zealot.getShield().getMaxShield(), maxShield);
	}
	
	@Test
	public void testMoverMarine() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Marine marine = new Marine(new Posicion(fila,columna));
		
		
	}
	
}