package fiuba.algo3.algocraft.movimientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
/*
public class IzquierdaTest {
	
	
	@Test
	public void testmoverIzquierdaDeberiaMoverLaUnidadALaCeldaDeLaIzquierda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		izquierda.mover(unidad);
		
		assertEquals(unidad.getUbicacion().getPosicion().getFila(),2);
		assertEquals(unidad.getUbicacion().getPosicion().getColumna(),1);
		
	}
	
	@Test
	public void testmoverIzquierdaDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));
		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		izquierda.mover(unidad);
		
		assertNull(mapa.getCelda(2,2).getUnidad());
		
	}
	
	@Test
	public void testmoverIzquierdaDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(2, 2));
		izquierda.mover(unidad);
		
		assertEquals(mapa.getCelda(2,1).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverIzquierdaDeberiaLanzarErrorSiEstaEnElBordeIzquierdoDelMapa() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(2, 0));
		izquierda.mover(unidad);
	}
	

	@Test 
	public void testmoverIzquierdaUnaUnidadDeTierraEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaALaIzquierda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		Marine unidadDeTierra = new Marine(new Posicion(2,2));
		izquierda.mover(unidadDeTierra);
		
		assertEquals(unidadDeTierra.getUbicacion().getPosicion().getFila(),2);
		assertEquals(unidadDeTierra.getUbicacion().getPosicion().getColumna(),1);
	}
	
	@Test 
	public void testmoverIzquierdaUnaUnidadAereaEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaALaIzquierda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		Unidad unidadAerea = new NaveCiencia(new Posicion(2,2));
		izquierda.mover(unidadAerea);
		
		assertEquals(unidadAerea.getUbicacion().getPosicion().getFila(),2);
		assertEquals(unidadAerea.getUbicacion().getPosicion().getColumna(),1);
	}
	
	@Test 
	public void testmoverIzquierdaUnaUnidadAereaEnAreaAereaDeberiaMoverLaUnidadUnaCeldaALaIzquierda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		Unidad unidadAerea = new NaveCiencia(new Posicion(20,20));
		izquierda.mover(unidadAerea);
		
		assertEquals(unidadAerea.getUbicacion().getPosicion().getFila(),20);
		assertEquals(unidadAerea.getUbicacion().getPosicion().getColumna(),19);
	}
	
	@Test (expected = UnidadTerrestreEnAreaEspacial.class)
	public void testmoverDerechaUnaUnidadDeTierraEnAreaAereaDeberiaLanzarError() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento izquierda = new Izquierda();
		Mapa mapa = Mapa.getInstance();
		Marine unidadDeTierra = new Marine(new Posicion(20,31));
		izquierda.mover(unidadDeTierra);

	}
	
	@Test
	public void testmoverDerechaUnaUnidadDeberiaActualizarLaVisionDelJugadorDeAcuerdoConLaVisionDeLaUnidad() throws FueraDeMatriz, JugadorInvalido, UnidadTerrestreEnAreaEspacial, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Juego juego = Juego.getInstance();
		Marine unMarine = new Marine(new Posicion(9,9));
		Movimiento izq = new Izquierda();
		izq.mover(unMarine);
		
		assertTrue(juego.getJugador(1).getVision().estaDescubierto(new Posicion(16,15)));
		assertTrue(juego.getJugador(1).getVision().estaDescubierto(new Posicion(16,2)));
		
	}
	 
}
*/import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.movimientos.Izquierda;
import fiuba.algo3.modelo.movimientos.Movimiento;
import fiuba.algo3.modelo.unidades.Marine;
import fiuba.algo3.modelo.unidades.NaveCiencia;
import fiuba.algo3.modelo.unidades.Unidad;

