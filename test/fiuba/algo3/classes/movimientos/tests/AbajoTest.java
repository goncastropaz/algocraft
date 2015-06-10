package fiuba.algo3.classes.movimientos.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.game.Mapa;
import fiuba.algo3.classes.movimientos.Abajo;
import fiuba.algo3.classes.movimientos.Arriba;
import fiuba.algo3.classes.movimientos.Movimiento;
import fiuba.algo3.classes.units.RaceUnit;

public class AbajoTest {

	@Test
	public void testmoverAbajoDeberiaMoverLaUnidadALaCeldaDeAbajo() throws FueraDeMatriz{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		abajo.mover(unidad);
		
		assertEquals(unidad.getUbicacion().getPosicion().getFila(),3);
		assertEquals(unidad.getUbicacion().getPosicion().getColumna(),2);
		
	}
	
	@Test
	public void testmoverAbajoDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		abajo.mover(unidad);
		
		assertNull(mapa.getCelda(2,2).getUnidad());
		
	}
	
	@Test
	public void testmoverAbajoDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		abajo.mover(unidad);
		
		assertEquals(mapa.getCelda(3,2).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverAbajoDeberiaLanzarErrorSiEstaEnElBordeInferiorDelMapa() throws FueraDeMatriz{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(19, 2));
		abajo.mover(unidad);
	}
	 
}
