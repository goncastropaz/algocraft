package fiuba.algo3.algocraft.movimientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.movimientos.Abajo;
import fiuba.algo3.algocraft.movimientos.Movimiento;
import fiuba.algo3.algocraft.unidades.Marine;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.algocraft.unidades.UnidadAerea;
import fiuba.algo3.algocraft.unidades.UnidadTerrestre;
import fiuba.algo3.classes.stats.Posicion;

public class AbajoTest {

	@Test
	public void testmoverAbajoDeberiaMoverLaUnidadALaCeldaDeAbajo() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Posicion posicion = new Posicion(1,1);
		Marine marine = new Marine(posicion);
		marine.setNuevaUbicacion(mapa.getCelda(2, 2));
		abajo.mover(marine);
		
		assertEquals(marine.getUbicacion().getPosicion().getFila(),3);
		assertEquals(marine.getUbicacion().getPosicion().getColumna(),2);
		
	}
	
	@Test
	public void testmoverAbajoDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		abajo.mover(unidad);
		
		assertNull(mapa.getCelda(2,2).getUnidad());
		
	}
	
	@Test
	public void testmoverAbajoDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		abajo.mover(unidad);
		
		assertEquals(mapa.getCelda(3,2).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverAbajoDeberiaLanzarErrorSiEstaEnElBordeInferiorDelMapa() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));
		unidad.setNuevaUbicacion(mapa.getCelda(19, 2));
		abajo.mover(unidad);
	}
	
	@Test 
	public void testmoverAbajoUnaUnidadDeTierraEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaAbajo() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Marine unidadDeTierra = new Marine(new Posicion(2,2));
//		Unidad unidadDeTierra = new UnidadTerrestre("ejemplo",100,50,4,300,100,new Posicion(2,2));
		abajo.mover(unidadDeTierra);
		
		assertEquals(unidadDeTierra.getUbicacion().getPosicion().getFila(),3);
		assertEquals(unidadDeTierra.getUbicacion().getPosicion().getColumna(),2);
	}
	
//	@Test 
//	public void testmoverAbajoUnaUnidadAereaEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaAbajo() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
//		Movimiento abajo = new Abajo();
//		Mapa mapa = Mapa.getInstance();
//		Unidad unidadAerea = new UnidadAerea("ejemplo",100,50,4,300,100,new Posicion(2,2));
//		abajo.mover(unidadAerea);
//		
//		assertEquals(unidadAerea.getUbicacion().getPosicion().getFila(),3);
//		assertEquals(unidadAerea.getUbicacion().getPosicion().getColumna(),2);
//	}
//	
//	@Test 
//	public void testmoverAbajoUnaUnidadAereaEnAreaAereaDeberiaMoverLaUnidadUnaCeldaAbajo() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
//		Movimiento abajo = new Abajo();
//		Mapa mapa = Mapa.getInstance();
//		Unidad unidadAerea = new UnidadAerea("ejemplo",100,50,4,300,100,new Posicion(0,8));
//		abajo.mover(unidadAerea);
//		
//		assertEquals(unidadAerea.getUbicacion().getPosicion().getFila(),1);
//		assertEquals(unidadAerea.getUbicacion().getPosicion().getColumna(),8);
//	}
	
	@Test (expected = UnidadTerrestreEnAreaEspacial.class)
	public void testmoverAbajoUnaUnidadDeTierraEnAreaAereaDeberiaLanzarError() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Movimiento abajo = new Abajo();
//		Mapa mapa = Mapa.getInstance();
		Marine unidadDeTierra = new Marine(new Posicion(0,8));
//		Marine unidadDeTierra = new UnidadTerrestre("ejemplo",100,50,4,300,100,new Posicion(0,8));
		abajo.mover(unidadDeTierra);

	}
	 
}