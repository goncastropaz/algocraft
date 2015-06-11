package fiuba.algo3.classes.builders.buildings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.classes.buildings.NexoMineral;
import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class NexoMineralTest {

	@Test
	public void testCrearMineralLink() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Posicion posicion = new Posicion(fila, columna);
		
		NexoMineral unNexo = new NexoMineral(posicion);
		Integer cost = 50;
		
		assertNotNull(unNexo);
		assertEquals(unNexo.getCost().getCostoMineral(), cost);
	}

	
}
