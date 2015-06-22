package fiuba.algo3.algocraft.movimientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.movimientos.Derecha;
import fiuba.algo3.algocraft.movimientos.Movimiento;
import fiuba.algo3.algocraft.unidades.Marine;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Posicion;

public class DerechaTest {

	@Test
	public void testmoverDerechaDeberiaMoverLaUnidadALaCeldaDeLaDerecha() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(2,1));

		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		
		derecha.mover(unidad);
		
		assertEquals(unidad.getUbicacion().getPosicion().getFila(),1);
		assertEquals(unidad.getUbicacion().getPosicion().getColumna(),2);
		
	}
	
	@Test
	public void testmoverDerechaDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		derecha.mover(unidad);
		
		assertNull(mapa.getCelda(1,1).getUnidad());
		
	}
	
	@Test
	public void testmoverDerechaDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		derecha.mover(unidad);
		
		assertEquals(mapa.getCelda(1,2).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverDerechaDeberiaLanzarErrorSiEstaEnElBordeDerechoDelMapa() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido{
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(5, 99));
		derecha.mover(unidad);
	}
	 //agregar test areas espaciales y terrestres
	
	
	@Test
	public void testmoverDerechaUnaUnidadDeberiaActualizarLaVisionDelJugadorDeAcuerdoConLaVisionDeLaUnidad() throws FueraDeMatriz, JugadorInvalido, UnidadTerrestreEnAreaEspacial{
		Juego juego = Juego.getInstance();
		Marine unMarine = new Marine(new Posicion(9,9));
		Movimiento derecha = new Derecha();
		derecha.mover(unMarine);
		
		assertTrue(juego.getJugador(1).getVision().estaDescubierto(new Posicion(16,17)));
		assertTrue(juego.getJugador(1).getVision().estaDescubierto(new Posicion(16,3)));
		
	}
}
