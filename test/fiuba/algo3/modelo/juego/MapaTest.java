package fiuba.algo3.modelo.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Mapa;

public class MapaTest {
	
		@Test
		public void testDevolverCeldaDeberiaDevolverLaCeldaDeLaPos() throws FueraDeMatriz{
			Mapa mapa = new Mapa();
			Posicion pos = new Posicion(1,2);
			Celda celda = mapa.devolverCelda(pos);
			
			assertEquals(1,celda.getPosicion().getFila());
			assertEquals(2,celda.getPosicion().getColumna());
		}
		
		@Test
		public void testCrearMapaDebeCrearElMapaConUnaBase() throws FueraDeMatriz{
			Mapa mapa = new Mapa();
			Celda mineral1 = mapa.devolverCelda(new Posicion(4,4));
			Celda mineral2 = mapa.devolverCelda(new Posicion(4,5));
			Celda mineral3 = mapa.devolverCelda(new Posicion(5,4));
			Celda gas = mapa.devolverCelda(new Posicion(5,5));
			
			assertTrue(mineral1.tieneMineral());
			assertTrue(mineral2.tieneMineral());		
			assertTrue(mineral3.tieneMineral());
			assertTrue(gas.tieneGas());
		}
		
		@Test
		public void testMapaDebeCrearseConUnaAreaEspacial() throws FueraDeMatriz{
			
			Mapa mapa = new Mapa();
			Celda espacial = mapa.devolverCelda(new Posicion(1,20));
			Celda espacial2 = mapa.devolverCelda(new Posicion(40,30));
			Celda tierra = mapa.devolverCelda(new Posicion(0,17));
			Celda tierra2 = mapa.devolverCelda(new Posicion(41,31));
			
			assertTrue(espacial.isEspacial());
			assertTrue(espacial2.isEspacial());
			assertFalse(tierra.isEspacial());
			assertFalse(tierra2.isEspacial());
		}
	
}
