package fiuba.algo3.classes.builders.buildings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.classes.buildings.NexoMineral;

public class NexoMineralTest {

	@Test
	public void testCrearMineralLink(){
		Integer coordenadaX = 1;
		Integer coordenadaY = 1;
		
		NexoMineral unNexo = new NexoMineral(coordenadaX, coordenadaY);
		Integer cost = 50;
		
		assertNotNull(unNexo);
		assertEquals(unNexo.getCost().getMineralCost(), cost);
	}

	
}
