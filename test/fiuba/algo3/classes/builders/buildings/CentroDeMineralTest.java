package fiuba.algo3.classes.builders.buildings;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.classes.buildings.CentroDeMineral;
import fiuba.algo3.classes.exceptions.FueraDeMatriz;

public class CentroDeMineralTest {
	
	@Test
	public void testCrearMineralCenter() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		
		CentroDeMineral unCentroMineral = new CentroDeMineral(fila, columna);
		Integer max_vida = 500;
		
		assertNotNull(unCentroMineral);
		assertEquals(unCentroMineral.getHealth().getMaxHealth(), max_vida);
	}

}
