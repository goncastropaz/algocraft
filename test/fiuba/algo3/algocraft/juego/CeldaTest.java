package fiuba.algo3.algocraft.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.construcciones.Barraca;
import fiuba.algo3.algocraft.construcciones.Construccion;
import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.unidades.Marine;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Posicion;

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
		
		@Test (expected = CeldaOcupada.class)
		public void testAgregarContruccionSiHayUnaUnidadDeberiaLanzarError() throws CeldaOcupada, FueraDeMatriz, JugadorInvalido{
			Juego juego = Juego.getInstance();
			juego.empezarJuego();
			
			Celda unaCelda = new Celda(2,1);
			Unidad marine = new Marine(unaCelda.getPosicion());
			unaCelda.setUnidad(marine);
			Construccion barraca = new Barraca(unaCelda.getPosicion());
			unaCelda.setConstruccion(barraca);
		}
		
		@Test(expected = CeldaOcupada.class)
		public void testAgregarUnidadSiHayUnaConstruccionDeberiaLanzarError() throws CeldaOcupada, FueraDeMatriz, JugadorInvalido{
			Juego juego = Juego.getInstance();
			juego.empezarJuego();
			
			Celda unaCelda = new Celda(2,1);
			Construccion barraca = new Barraca(unaCelda.getPosicion());
			unaCelda.setConstruccion(barraca);
			
			Unidad marine = new Marine(unaCelda.getPosicion());
			unaCelda.setUnidad(marine);
			
		}
		
}
