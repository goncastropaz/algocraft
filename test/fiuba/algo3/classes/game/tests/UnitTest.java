package fiuba.algo3.classes.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.classes.units.Marine;
import fiuba.algo3.classes.units.Zealot;

public class UnitTest {

	@Test
	public void testCrearMarine(){
		Marine marine = new Marine();
		assertNotNull(marine);
	}
	
	@Test
	public void testCrearZealot(){
		Zealot zealot = new Zealot();
		assertNotNull(zealot);
	}
	
}
