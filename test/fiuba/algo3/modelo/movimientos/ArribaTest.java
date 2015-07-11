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

public class ArribaTest {

	@Test
	public void testmoverArribaDeberiaMoverLaUnidadALaCeldaDeArriba() throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento arriba = new Arriba(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		arriba.mover(posMarine);
		
		assertEquals(marine.getUbicacion().getFila(),1);
		assertEquals(marine.getUbicacion().getColumna(),2);
		
	
	}
	
	@Test
	public void testmoverArribaDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento arriba = new Arriba(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		arriba.mover(posMarine);

		assertNull(nuevoJuego.getMapaDeJuego().devolverCelda(posMarine).getUnidad());
		
		
	}
	
	@Test
	public void testmoverArribaDeberiaAgregarLaUnidadALaNuevaCelda() throws CeldaOcupada, FueraDeMatriz, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento arriba = new Arriba(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		arriba.mover(posMarine);
		
		assertEquals(nuevoJuego.getMapaDeJuego().devolverCelda(new Posicion(1,2)).getUnidad(),marine);
				
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverArribaDeberiaLanzarErrorSiEstaEnElBordeSuperiorDelMapa() throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento arriba = new Arriba(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(0,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		arriba.mover(posMarine);
	}


	@Test 
	public void testmoverArribaUnaUnidadDeTierraEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaArriba() throws FueraDeMatriz, CeldaOcupada, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida{
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento arriba = new Arriba(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(2,2);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		arriba.mover(posMarine);
		
		
		assertEquals(marine.getUbicacion().getFila(),1);
		assertEquals(marine.getUbicacion().getColumna(),2);
		
	}
	
	@Test 
	public void testmoverArribaUnaUnidadAereaEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaArriba()throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento arriba = new Arriba(nuevoJuego);
		NaveCiencia unidad = new NaveCiencia();
		unidad.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(41,20);
		unidad.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(unidad);
		nuevoJuego.getActualJugador().agregarUnidad(unidad);
		arriba.mover(posMarine);
		
		assertEquals(unidad.getUbicacion().getFila(),40);
		assertEquals(unidad.getUbicacion().getColumna(),20);
		
	}
	
	@Test 
	public void testmoverArribaUnaUnidadAereaEnAreaAereaDeberiaMoverLaUnidadUnaCeldaArriba() throws CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, FueraDeMatriz, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento arriba = new Arriba(nuevoJuego);
		NaveCiencia unidad = new NaveCiencia();
		unidad.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(40,20);
		unidad.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(unidad);
		nuevoJuego.getActualJugador().agregarUnidad(unidad);
		arriba.mover(posMarine);
		
		
		assertEquals(unidad.getUbicacion().getFila(),39);
		assertEquals(unidad.getUbicacion().getColumna(),20);
		
	
	}
	
	@Test (expected = CeldaEspacial.class)
	public void testmoverArribaUnaUnidadDeTierraEnAreaAereaDeberiaLanzarError()throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida {
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento arriba = new Arriba(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(41,20);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		arriba.mover(posMarine);

	}
	
	@Test
	public void testmoverArribaUnaUnidadDeberiaActualizarLaVisionDelJugadorDeAcuerdoConLaVisionDeLaUnidad()  throws FueraDeMatriz, CeldaOcupada, RecursosInsuficientes, PoblacionInsuficiente, CeldaSinConstruccion, EdificioNoPuedeCrearUnidad, NoHayUnidadParaMoverEnCelda, CeldaEspacial, UnidadNoTerminada, UnidadAtacanteInvalida{
		Juego nuevoJuego = new Juego();
		Mapa mapa = nuevoJuego.getMapaDeJuego();
		Movimiento arriba = new Arriba(nuevoJuego);
		Marine marine = new Marine();
		marine.setTiempoDeConstruccion(new TiempoDeConstruccion(0));
		Posicion posMarine = new Posicion(9,9);
		marine.setUbicacion(posMarine);
		mapa.devolverCelda(posMarine).setUnidad(marine);
		nuevoJuego.getActualJugador().agregarUnidad(marine);
		arriba.mover(posMarine);
		
		assertTrue(nuevoJuego.getActualJugador().getVision().estaDescubierto(new Posicion(15,15)));
		assertTrue(nuevoJuego.getActualJugador().getVision().estaDescubierto(new Posicion(2,16)));
		
	}
	
}