package fiuba.algo3.classes.movimientos.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.exceptions.NombreConMenosDe4Caracteres;
import fiuba.algo3.classes.game.Mapa;
import fiuba.algo3.classes.movimientos.Derecha;
import fiuba.algo3.classes.movimientos.Movimiento;
import fiuba.algo3.classes.units.RaceUnit;

public class DerechaTest {

	@Test
	public void testmoverDerechaDeberiaMoverLaUnidadALaCeldaDeLaDerecha() throws FueraDeMatriz{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		derecha.mover(unidad);
		
		assertEquals(unidad.getUbicacion().getPosicion().getFila(),1);
		assertEquals(unidad.getUbicacion().getPosicion().getColumna(),2);
		
	}
	
	@Test
	public void testmoverDerechaDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		derecha.mover(unidad);
		
		assertNull(mapa.getCelda(1,1).getUnidad());
		
	}
	
	@Test
	public void testmoverDerechaDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		derecha.mover(unidad);
		
		assertEquals(mapa.getCelda(1,2).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverDerechaDeberiaLanzarErrorSiEstaEnElBordeDerechoDelMapa() throws FueraDeMatriz{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		RaceUnit unidad = new RaceUnit();
		unidad.setNuevaUbicacion(mapa.getCelda(5, 19));
		derecha.mover(unidad);
	}
	 
}
