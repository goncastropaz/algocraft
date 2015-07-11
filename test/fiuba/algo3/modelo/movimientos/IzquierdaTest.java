package fiuba.algo3.modelo.movimientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.TiempoDeConstruccion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinConstruccion;
import fiuba.algo3.modelo.excepciones.EdificioNoPuedeCrearUnidad;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoHayUnidadParaMoverEnCelda;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.excepciones.UnidadAtacanteInvalida;
import fiuba.algo3.modelo.excepciones.UnidadNoTerminada;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.unidades.Marine;
import fiuba.algo3.modelo.unidades.NaveCiencia;

public class IzquierdaTest {
	
	
	@Test
	public void testmoverIzquierdaDeberiaMoverLaUnidadALaCeldaDeLaIzquierda()throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento izq = new Izquierda(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		izq.mover(posMarine);
		
		assertEquals(marine.getUbicacion().getFila(),2);
		assertEquals(marine.getUbicacion().getColumna(),1);
		
		
	}
	
	@Test
	public void testmoverIzquierdaDeberiaRemoverLaUnidadDeLaViejaCelda()  throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento izq = new Izquierda(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		izq.mover(posMarine);

		assertNull(nuevoJuego.getMapaDeJuego().devolverCelda(posMarine).getUnidad());
	
		
	}
	
	@Test
	public void testmoverIzquierdaDeberiaAgregarLaUnidadALaNuevaCelda() throws CeldaOcupada, FueraDeMatriz, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento izq = new Izquierda(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		izq.mover(posMarine);
		
		assertEquals(nuevoJuego.getMapaDeJuego().devolverCelda(new Posicion(2,1)).getUnidad(),marine);
	
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverIzquierdaDeberiaLanzarErrorSiEstaEnElBordeIzquierdoDelMapa() throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento izq = new Izquierda(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,0);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		izq.mover(posMarine);
	}
	

	@Test 
	public void testmoverIzquierdaUnaUnidadDeTierraEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaALaIzquierda()  throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida{
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento izq = new Izquierda(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		izq.mover(posMarine);
		
		
		assertEquals(marine.getUbicacion().getFila(),2);
		assertEquals(marine.getUbicacion().getColumna(),1);
		
	}
	
	@Test 
	public void testmoverIzquierdaUnaUnidadAereaEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaALaIzquierda() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento izq = new Izquierda(nuevoJuego);
		NaveCiencia unidad = new NaveCiencia();
		unidad.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		unidad.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(unidad);
		nuevoJuego.getActualJugador().agregarUnidad(unidad);
		izq.mover(posMarine);
		
		assertEquals(unidad.getUbicacion().getFila(),2);
		assertEquals(unidad.getUbicacion().getColumna(),1);
		
	
	}
	
	@Test 
	public void testmoverIzquierdaUnaUnidadAereaEnAreaAereaDeberiaMoverLaUnidadUnaCeldaALaIzquierda()throws CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, FueraDeMatriz, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento izq = new Izquierda(nuevoJuego);
		NaveCiencia unidad = new NaveCiencia();
		unidad.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(20,20);
		unidad.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(unidad);
		nuevoJuego.getActualJugador().agregarUnidad(unidad);
		izq.mover(posMarine);
		
		
		assertEquals(unidad.getUbicacion().getFila(),20);
		assertEquals(unidad.getUbicacion().getColumna(),19);
		
	}
	
	@Test (expected = CeldaEspacial.class)
	public void testmoverDerechaUnaUnidadDeTierraEnAreaAereaDeberiaLanzarError() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento izq = new Izquierda(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(20,31);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		izq.mover(posMarine);
	}
	
	@Test
	public void testmoverDerechaUnaUnidadDeberiaActualizarLaVisionDelJugadorDeAcuerdoConLaVisionDeLaUnidad() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida{
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento izq = new Izquierda(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(9,9);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		izq.mover(posMarine);
		
		assertTrue(nuevoJuego.getActualJugador().getVision().estaDescubierto(new Posicion(16,15)));
		assertTrue(nuevoJuego.getActualJugador().getVision().estaDescubierto(new Posicion(16,2)));

		
	}
	 
}