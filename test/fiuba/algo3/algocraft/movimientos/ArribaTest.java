package fiuba.algo3.algocraft.movimientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.movimientos.Arriba;
import fiuba.algo3.algocraft.movimientos.Movimiento;
import fiuba.algo3.algocraft.unidades.RaceUnit;

public class ArribaTest {

	@Test
	public void testmoverArribaDeberiaMoverLaUnidadALaCeldaDeArriba() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		arriba.mover(unidad);
		
		assertEquals(unidad.getUbicacion().getPosicion().getFila(),1);
		assertEquals(unidad.getUbicacion().getPosicion().getColumna(),2);
		
	}
	
	@Test
	public void testmoverArribaDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		arriba.mover(unidad);
		
		assertNull(mapa.getCelda(2,2).getUnidad());
		
	}
	
	@Test
	public void testmoverArribaDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		arriba.mover(unidad);
		
		assertEquals(mapa.getCelda(1,2).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverArribaDeberiaLanzarErrorSiEstaEnElBordeSuperiorDelMapa() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(0, 2));
		arriba.mover(unidad);
	}
	 
}