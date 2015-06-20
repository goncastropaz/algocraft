package fiuba.algo3.algocraft.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

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
		
		@Test
		public void testMapaDebeCrearseConUnaAreaEspacial() throws FueraDeMatriz{
			
			Mapa mapa = Mapa.getInstance();
			Celda espacial = mapa.getCelda(1,20);
			Celda espacial2 = mapa.getCelda(80,30);
			Celda tierra = mapa.getCelda(0,17);
			Celda tierra2 = mapa.getCelda(81,31);
			
			assertTrue(espacial.isEspacial());
			assertTrue(espacial2.isEspacial());
			assertFalse(tierra.isEspacial());
			assertFalse(tierra2.isEspacial());
		}
	
}
