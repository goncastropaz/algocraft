package fiuba.algo3.modelo.movimientos;

import static org.junit.Assert.*;

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

public class AbajoTest {

	@Test
	public void testmoverAbajoDeberiaMoverLaUnidadALaCeldaDeAbajo() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento abajo = new Abajo(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		abajo.mover(posMarine);
		
		assertEquals(marine.getUbicacion().getFila(),3);
		assertEquals(marine.getUbicacion().getColumna(),2);
		
	}
	
	@Test
	public void testmoverAbajoDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento abajo = new Abajo(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		abajo.mover(posMarine);
	
		assertNull(nuevoJuego.getMapaDeJuego().devolverCelda(posMarine).getUnidad());
		
	}
	
	@Test
	public void testmoverAbajoDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento abajo = new Abajo(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		abajo.mover(posMarine);
		
		assertEquals(nuevoJuego.getMapaDeJuego().devolverCelda(new Posicion(3,2)).getUnidad(),marine);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverAbajoDeberiaLanzarErrorSiEstaEnElBordeInferiorDelMapa() throws CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, FueraDeMatriz, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento abajo = new Abajo(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(49,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		abajo.mover(posMarine);
		
	}
	
	@Test 
	public void testmoverAbajoUnaUnidadDeTierraEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaAbajo() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento abajo = new Abajo(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		abajo.mover(posMarine);
		
		
		assertEquals(marine.getUbicacion().getFila(),3);
		assertEquals(marine.getUbicacion().getColumna(),2);
	}
	
	@Test 
	public void testmoverAbajoUnaUnidadAereaEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaAbajo() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento abajo = new Abajo(nuevoJuego);
		NaveCiencia unidad = new NaveCiencia();
		unidad.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		unidad.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(unidad);
		nuevoJuego.getActualJugador().agregarUnidad(unidad);
		abajo.mover(posMarine);
		
		assertEquals(unidad.getUbicacion().getFila(),3);
		assertEquals(unidad.getUbicacion().getColumna(),2);
	}
	
	@Test 
	public void testmoverAbajoUnaUnidadAereaEnAreaAereaDeberiaMoverLaUnidadUnaCeldaAbajo() throws CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, FueraDeMatriz, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento abajo = new Abajo(nuevoJuego);
		NaveCiencia unidad = new NaveCiencia();
		unidad.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,20);
		unidad.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(unidad);
		nuevoJuego.getActualJugador().agregarUnidad(unidad);
		abajo.mover(posMarine);
		
		
		assertEquals(unidad.getUbicacion().getFila(),3);
		assertEquals(unidad.getUbicacion().getColumna(),20);
	}
	
	@Test (expected = CeldaEspacial.class)
	public void testmoverAbajoUnaUnidadDeTierraEnAreaAereaDeberiaLanzarError() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento abajo = new Abajo(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,20);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		abajo.mover(posMarine);
	}
	
	@Test
	public void testmoverAbajoUnaUnidadDeberiaActualizarLaVisionDelJugadorDeAcuerdoConLaVisionDeLaUnidad() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida{
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento abajo = new Abajo(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(9,9);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		abajo.mover(posMarine);
		
		assertTrue(nuevoJuego.getActualJugador().getVision().estaDescubierto(new Posicion(16,16)));
		assertTrue(nuevoJuego.getActualJugador().getVision().estaDescubierto(new Posicion(16,2)));
		
	}

	 
}
