package fiuba.algo3.modelo.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;

public class PosicionTest {
	
	@Test
	 public void testCrearPosicionDeberiaGuardarmeFilyCol() throws FueraDeMatriz{
		 
		 Posicion pos = new Posicion(1,3);
		 int fil = pos.getFila();
		 int col = pos.getColumna();
		  assertEquals(1, fil);
		  assertEquals(3, col);
	 } 
	
	@Test
	 public void testGetFilaDeberiaDevolvermeLaFilaAsignada() throws FueraDeMatriz{
		Posicion pos = new Posicion(1,3);
		 int fil = pos.getFila();
		 assertEquals(1, fil);
	}
	
	@Test
	 public void testGetColumnaDeberiaDevolvermeLaColumnaAsignada() throws FueraDeMatriz{
		Posicion pos = new Posicion(1,3);
		int col = pos.getColumna();
		assertEquals(3, col);
	}

	@Test (expected = FueraDeMatriz.class)
	 public void testCrearPosicionConUnValorMayorAlDelTamanioDeMatrizDeberiaDevolverError() throws FueraDeMatriz{
		Posicion pos = new Posicion(1,53);
		
	}
	
	
}
