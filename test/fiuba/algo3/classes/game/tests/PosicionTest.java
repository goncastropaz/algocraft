package fiuba.algo3.classes.game.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.game.Posicion;

public class PosicionTest {
	
	@Test
	 public void testCrearPosicionDeberiaGuardarmeFilyCol(){
		 
		 Posicion pos = new Posicion(1,3);
		 int fil = pos.getFila();
		 int col = pos.getColumna();
		  assertEquals(1, fil);
		  assertEquals(3, col);
	 } 
	
	@Test
	 public void testGetFilaDeberiaDevolvermeLaFilaAsignada(){
		Posicion pos = new Posicion(1,3);
		 int fil = pos.getFila();
		 assertEquals(1, fil);
	}
	
	@Test
	 public void testGetColumnaDeberiaDevolvermeLaColumnaAsignada(){
		Posicion pos = new Posicion(1,3);
		int col = pos.getColumna();
		assertEquals(3, col);
	}
	
	@Test (expected = FueraDeMatriz.class)
	 public void testCrearPosicionConUnValorMayorAlDelTamanioDeMatrizDeberiaDevolverError(){
		Posicion pos = new Posicion(1,23);
		
	}
	
	
}
