package fiuba.algo3.classes.builders.buildings;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.classes.buildings.CentroDeMineral;

public class CentroDeMineralTest {
	
	@Test
	public void testCrearMineralCenter(){
		Integer coordenadaX = 1;
		Integer coordenadaY = 1;
		
		CentroDeMineral unCentroMineral = new CentroDeMineral(coordenadaX, coordenadaY);
		Integer max_vida = 40;
		
		assertNotNull(unCentroMineral);
		assertEquals(unCentroMineral.getHealth().getMaxHealth(), max_vida);
	}

}
