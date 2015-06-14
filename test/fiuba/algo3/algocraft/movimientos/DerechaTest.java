package fiuba.algo3.algocraft.movimientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.movimientos.Derecha;
import fiuba.algo3.algocraft.movimientos.Movimiento;
import fiuba.algo3.algocraft.unidades.Marine;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Posicion;

public class DerechaTest {

	@Test
	public void testmoverDerechaDeberiaMoverLaUnidadALaCeldaDeLaDerecha() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
//		Unidad unidad = new Unidad();
		Marine unidad = new Marine(new Posicion(2,1));

		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		
		derecha.mover(unidad);
		
		assertEquals(unidad.getUbicacion().getPosicion().getFila(),1);
		assertEquals(unidad.getUbicacion().getPosicion().getColumna(),2);
		
	}
	
	@Test
	public void testmoverDerechaDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
//		Unidad unidad = new Unidad();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		derecha.mover(unidad);
		
		assertNull(mapa.getCelda(1,1).getUnidad());
		
	}
	
	@Test
	public void testmoverDerechaDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
//		Unidad unidad = new Unidad();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		derecha.mover(unidad);
		
		assertEquals(mapa.getCelda(1,2).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverDerechaDeberiaLanzarErrorSiEstaEnElBordeDerechoDelMapa() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
//		Unidad unidad = new Unidad();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(5, 19));
		derecha.mover(unidad);
	}
	 
}
