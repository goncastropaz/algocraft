package fiuba.algo3.classes.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.classes.units.Marine;
import fiuba.algo3.classes.units.Zealot;

public class UnitTest {

	@Test
	public void testCrearMarine(){
		Marine marine = new Marine(1,2);
		Integer maxHealth = 40;
		
		assertNotNull(marine);
		assertEquals(marine.getHealth().getMaxHealth(), maxHealth);
	}
	
	@Test
	public void testCrearZealot(){
		Zealot zealot = new Zealot(1,2);
		Integer maxHealth = 100;
		Integer maxShield = 60;
		
		assertNotNull(zealot);
		assertEquals(zealot.getHealth().getMaxHealth(), maxHealth);
		assertEquals(zealot.getShield().getMaxShield(), maxShield);
	}
	
}
