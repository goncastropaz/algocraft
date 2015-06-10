package fiuba.algo3.classes.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.units.Marine;
import fiuba.algo3.classes.units.Zealot;

public class UnitTest {

	@Test
	public void testCrearMarine() throws FueraDeMatriz{
		Marine marine = new Marine(new Posicion(1,2));
		Integer maxHealth = 40;
		
		assertNotNull(marine);
		assertEquals(marine.getHealth().getMaxHealth(), maxHealth);
	}
	
	@Test
	public void testCrearZealot() throws FueraDeMatriz{
		Zealot zealot = new Zealot(new Posicion(1,2));
		Integer maxHealth = 100;
		Integer maxShield = 60;
		
		assertNotNull(zealot);
		assertEquals(zealot.getHealth().getMaxHealth(), maxHealth);
		assertEquals(zealot.getShield().getMaxShield(), maxShield);
	}
	
}
