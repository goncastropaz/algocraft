package fiuba.algo3.classes.units.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.classes.units.Marine;
import fiuba.algo3.classes.units.Zealot;

public class UnitTest {

	@Test
	public void testCrearMarine(){
		Integer coordinateX = 1;
		Integer coordinateY = 1;
		Integer maxHealth = 40;
		Integer maxShield = 0;
		Marine marine = new Marine(coordinateX,coordinateY);
		
		assertNotNull(marine);
		assertEquals(marine.getHealth().getMaxHealth(), maxHealth);
		assertEquals(marine.getShield().getMaxShield(), maxShield);
	}
	
	@Test
	public void testCrearZealot(){
		Integer coordinateX = 1;
		Integer coordinateY = 1;
		Integer maxHealth = 100;
		Integer maxShield = 60;
		Zealot zealot = new Zealot(coordinateX,coordinateY);
		
		assertNotNull(zealot);
		assertEquals(zealot.getHealth().getMaxHealth(), maxHealth);
		assertEquals(zealot.getShield().getMaxShield(), maxShield);
	}
	
	@Test
	public void testMoverMarine(){
		Integer coordinateX = 1;
		Integer coordinateY = 1;
		Marine marine = new Marine(coordinateX,coordinateY);
		
		
	}
	
}