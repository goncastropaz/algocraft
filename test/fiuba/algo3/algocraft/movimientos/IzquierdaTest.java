package fiuba.algo3.algocraft.movimientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.movimientos.Izquierda;
import fiuba.algo3.algocraft.movimientos.Movimiento;
import fiuba.algo3.algocraft.unidades.RaceUnit;

public class IzquierdaTest {
	
	
	@Test
	public void testmoverIzquierdaDeberiaMoverLaUnidadALaCeldaDeLaIzquierda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		izquierda.mover(unidad);
		
		assertEquals(unidad.getUbicacion().getPosicion().getFila(),2);
		assertEquals(unidad.getUbicacion().getPosicion().getColumna(),1);
		
	}
	
	@Test
	public void testmoverIzquierdaDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		izquierda.mover(unidad);
		
		assertNull(mapa.getCelda(2,2).getUnidad());
		
	}
	
	@Test
	public void testmoverIzquierdaDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		izquierda.mover(unidad);
		
		assertEquals(mapa.getCelda(2,1).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverIzquierdaDeberiaLanzarErrorSiEstaEnElBordeIzquierdoDelMapa() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(2, 0));
		izquierda.mover(unidad);
	}
	 
}

