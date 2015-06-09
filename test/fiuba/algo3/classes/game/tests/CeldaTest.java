package fiuba.algo3.classes.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.game.Celda;
import fiuba.algo3.classes.game.Posicion;

public class CeldaTest {

		@Test
		public void testCrearCeldaDebeGuardarLaPosicion() throws FueraDeMatriz{
			
			Celda unaCelda = new Celda(2,1);
			int fil = unaCelda.getPosicion().getFila();
			int col = unaCelda.getPosicion().getColumna();
			
			assertEquals(2,fil);
			assertEquals(1,col);
		}
		
		@Test
		public void testGetPosicionDebeDevolverLaPosicionDeLaCelda() throws FueraDeMatriz{
			
			Celda unaCelda = new Celda(2,1);
			Posicion pos = unaCelda.getPosicion();
						
			assertEquals(2,pos.getFila());
			assertEquals(1,pos.getColumna());
		}
		
}
