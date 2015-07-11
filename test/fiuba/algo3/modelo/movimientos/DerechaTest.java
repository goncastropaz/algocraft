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

public class DerechaTest {

	@Test
	public void testmoverDerechaDeberiaMoverLaUnidadALaCeldaDeLaDerecha() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento der = new Derecha(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		der.mover(posMarine);
		
		assertEquals(marine.getUbicacion().getFila(),2);
		assertEquals(marine.getUbicacion().getColumna(),3);
	}
	
	@Test
	public void testmoverDerechaDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento der = new Derecha(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		der.mover(posMarine);

		assertNull(nuevoJuego.getMapaDeJuego().devolverCelda(posMarine).getUnidad());
		
	}
	
	@Test
	public void testmoverDerechaDeberiaAgregarLaUnidadALaNuevaCelda() throws CeldaOcupada, FueraDeMatriz, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento der = new Derecha(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(1,1);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		der.mover(posMarine);
		
		assertEquals(nuevoJuego.getMapaDeJuego().devolverCelda(new Posicion(1,2)).getUnidad(),marine);
	
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverDerechaDeberiaLanzarErrorSiEstaEnElBordeDerechoDelMapa()throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento der = new Derecha(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(0,49);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		der.mover(posMarine);
	}

	@Test 
	public void testmoverDerechaUnaUnidadDeTierraEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaALaDerecha()  throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida{
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento der = new Derecha(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		der.mover(posMarine);
		
		
		assertEquals(marine.getUbicacion().getFila(),2);
		assertEquals(marine.getUbicacion().getColumna(),3);
		
	}
	
	@Test 
	public void testmoverDerechaUnaUnidadAereaEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaALaDerecha() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento der = new Derecha(nuevoJuego);
		NaveCiencia unidad = new NaveCiencia();
		unidad.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		unidad.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(unidad);
		nuevoJuego.getActualJugador().agregarUnidad(unidad);
		der.mover(posMarine);
		
		assertEquals(unidad.getUbicacion().getFila(),2);
		assertEquals(unidad.getUbicacion().getColumna(),3);
		

	}
	
	@Test 
	public void testmoverDerechaUnaUnidadAereaEnAreaAereaDeberiaMoverLaUnidadUnaCeldaALaDerecha() throws CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, FueraDeMatriz, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento der = new Derecha(nuevoJuego);
		NaveCiencia unidad = new NaveCiencia();
		unidad.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(20,20);
		unidad.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(unidad);
		nuevoJuego.getActualJugador().agregarUnidad(unidad);
		der.mover(posMarine);
		
		
		assertEquals(unidad.getUbicacion().getFila(),20);
		assertEquals(unidad.getUbicacion().getColumna(),21);
		
	}
	
	@Test (expected = CeldaEspacial.class)
	public void testmoverDerechaUnaUnidadDeTierraEnAreaAereaDeberiaLanzarError() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento der = new Derecha(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(20,17);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		der.mover(posMarine);
	}
	
	
	@Test
	public void testmoverDerechaUnaUnidadDeberiaActualizarLaVisionDelJugadorDeAcuerdoConLaVisionDeLaUnidad()  throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida{
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento der = new Derecha(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(9,9);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		der.mover(posMarine);
		
		assertTrue(nuevoJuego.getActualJugador().getVision().estaDescubierto(new Posicion(16,17)));
		assertTrue(nuevoJuego.getActualJugador().getVision().estaDescubierto(new Posicion(16,3)));
		
		
	}
}