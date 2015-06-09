package fiuba.algo3.classes.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.game.Celda;
import fiuba.algo3.classes.game.Mapa;
import fiuba.algo3.classes.game.Posicion;

public class MapaTest {
	
		@Test
		public void testCrearMapaDeberiaDejarCrearUnaSolaInstancia() throws FueraDeMatriz{
			Mapa mapaPrincipal = Mapa.getInstance();
			Mapa mapaSecundario = Mapa.getInstance();
			
			assertEquals(mapaSecundario,mapaPrincipal);
		}
		
		@Test
		public void testDevolverCeldaDeberiaDevolverLaCeldaDeLaPos() throws FueraDeMatriz{
			Mapa mapa = Mapa.getInstance();
			Posicion pos = new Posicion(1,2);
			Celda celda = mapa.devolverCelda(pos);
			
			assertEquals(1,celda.getPosicion().getFila());
			assertEquals(2,celda.getPosicion().getColumna());
		}
		
		@Test
		public void testCrearMapaDebeCrearElMapaConUnaBase() throws FueraDeMatriz{
			Mapa mapa = Mapa.getInstance();
			Celda mineral1 = mapa.getCelda(4,4);
			Celda mineral2 = mapa.getCelda(4,5);
			Celda mineral3 = mapa.getCelda(5,4);
			Celda gas = mapa.getCelda(5,5);
			
			assertTrue(mineral1.tieneMineral());
			assertTrue(mineral2.tieneMineral());		
			assertTrue(mineral3.tieneMineral());
			assertTrue(gas.tieneGas());
		}
	
}
