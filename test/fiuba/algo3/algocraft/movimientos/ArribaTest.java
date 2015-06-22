package fiuba.algo3.algocraft.movimientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.movimientos.Arriba;
import fiuba.algo3.algocraft.movimientos.Movimiento;
import fiuba.algo3.algocraft.unidades.Marine;
import fiuba.algo3.algocraft.unidades.NaveCiencia;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Posicion;

public class ArribaTest {

	@Test
	public void testmoverArribaDeberiaMoverLaUnidadALaCeldaDeArriba() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(2,2));
		arriba.mover(unidad);
		
		assertEquals(unidad.getUbicacion().getPosicion().getFila(),1);
		assertEquals(unidad.getUbicacion().getPosicion().getColumna(),2);
		
	}
	
	@Test
	public void testmoverArribaDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(2,2));
		arriba.mover(unidad);
		
		assertNull(mapa.getCelda(2,2).getUnidad());
		
	}
	
	@Test
	public void testmoverArribaDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(2,2));
		arriba.mover(unidad);
		
		assertEquals(mapa.getCelda(1,2).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverArribaDeberiaLanzarErrorSiEstaEnElBordeSuperiorDelMapa() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(0,2));

		arriba.mover(unidad);
	}


	@Test 
	public void testmoverArribaUnaUnidadDeTierraEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaArriba() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		Marine unidadDeTierra = new Marine(new Posicion(2,2));
		arriba.mover(unidadDeTierra);
		
		assertEquals(unidadDeTierra.getUbicacion().getPosicion().getFila(),1);
		assertEquals(unidadDeTierra.getUbicacion().getPosicion().getColumna(),2);
	}
	
	@Test 
	public void testmoverArribaUnaUnidadAereaEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaArriba() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		Unidad unidadAerea = new NaveCiencia(new Posicion(41,20));
		arriba.mover(unidadAerea);
		
		assertEquals(unidadAerea.getUbicacion().getPosicion().getFila(),40);
		assertEquals(unidadAerea.getUbicacion().getPosicion().getColumna(),20);
	}
	
	@Test 
	public void testmoverArribaUnaUnidadAereaEnAreaAereaDeberiaMoverLaUnidadUnaCeldaArriba() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		Unidad unidadAerea = new NaveCiencia(new Posicion(40,20));
		arriba.mover(unidadAerea);
		
		assertEquals(unidadAerea.getUbicacion().getPosicion().getFila(),39);
		assertEquals(unidadAerea.getUbicacion().getPosicion().getColumna(),20);
	}
	
	@Test (expected = UnidadTerrestreEnAreaEspacial.class)
	public void testmoverArribaUnaUnidadDeTierraEnAreaAereaDeberiaLanzarError() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Movimiento arriba = new Arriba();
		Mapa mapa = Mapa.getInstance();
		Marine unidadDeTierra = new Marine(new Posicion(41,20));
		arriba.mover(unidadDeTierra);

	}
	
	@Test
	public void testmoverArribaUnaUnidadDeberiaActualizarLaVisionDelJugadorDeAcuerdoConLaVisionDeLaUnidad() throws FueraDeMatriz, JugadorInvalido, UnidadTerrestreEnAreaEspacial, CeldaOcupada{
		Juego juego = Juego.getInstance();
		Marine unMarine = new Marine(new Posicion(9,9));
		Movimiento arriba = new Arriba();
		arriba.mover(unMarine);
		
		assertTrue(juego.getJugador(1).getVision().estaDescubierto(new Posicion(15,15)));
		assertTrue(juego.getJugador(1).getVision().estaDescubierto(new Posicion(2,16)));
	}
	
}