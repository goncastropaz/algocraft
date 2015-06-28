package fiuba.algo3.algocraft.movimientos;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
/*
public class AbajoTest {

	@Test
	public void testmoverAbajoDeberiaMoverLaUnidadALaCeldaDeAbajo() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		//Movimiento abajo = new Abajo();
		//Mapa mapa = Mapa.getInstance();
		Marine marine = new Marine(new Posicion(2,2));
		abajo.mover(marine);
		
		assertEquals(marine.getUbicacion().getPosicion().getFila(),3);
		assertEquals(marine.getUbicacion().getPosicion().getColumna(),2);
		
	}
	
	@Test
	public void testmoverAbajoDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(2,2));
		abajo.mover(unidad);
		
		assertNull(mapa.getCelda(2,2).getUnidad());
		
	}
	
	@Test
	public void testmoverAbajoDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(2,2));
		abajo.mover(unidad);
		
		assertEquals(mapa.getCelda(3,2).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverAbajoDeberiaLanzarErrorSiEstaEnElBordeInferiorDelMapa() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(49,2));
		abajo.mover(unidad);
	}
	
	@Test 
	public void testmoverAbajoUnaUnidadDeTierraEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaAbajo() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Marine unidadDeTierra = new Marine(new Posicion(2,2));
		abajo.mover(unidadDeTierra);
		
		assertEquals(unidadDeTierra.getUbicacion().getPosicion().getFila(),3);
		assertEquals(unidadDeTierra.getUbicacion().getPosicion().getColumna(),2);
	}
	
	@Test 
	public void testmoverAbajoUnaUnidadAereaEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaAbajo() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Unidad unidadAerea = new NaveCiencia(new Posicion(2,2));
		abajo.mover(unidadAerea);
		
		assertEquals(unidadAerea.getUbicacion().getPosicion().getFila(),3);
		assertEquals(unidadAerea.getUbicacion().getPosicion().getColumna(),2);
	}
	
	@Test 
	public void testmoverAbajoUnaUnidadAereaEnAreaAereaDeberiaMoverLaUnidadUnaCeldaAbajo() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Unidad unidadAerea = new NaveCiencia(new Posicion(0,20));
		abajo.mover(unidadAerea);
		
		assertEquals(unidadAerea.getUbicacion().getPosicion().getFila(),1);
		assertEquals(unidadAerea.getUbicacion().getPosicion().getColumna(),20);
	}
	
	@Test (expected = UnidadTerrestreEnAreaEspacial.class)
	public void testmoverAbajoUnaUnidadDeTierraEnAreaAereaDeberiaLanzarError() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento abajo = new Abajo();
		Mapa mapa = Mapa.getInstance();
		Marine unidadDeTierra = new Marine(new Posicion(0,20));
		abajo.mover(unidadDeTierra);

	}
	
	@Test
	public void testmoverAbajoUnaUnidadDeberiaActualizarLaVisionDelJugadorDeAcuerdoConLaVisionDeLaUnidad() throws FueraDeMatriz, JugadorInvalido, UnidadTerrestreEnAreaEspacial, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Juego juego = Juego.getInstance();
		Marine unMarine = new Marine(new Posicion(9,9));
		Movimiento abajo = new Abajo();
		abajo.mover(unMarine);
		
		assertTrue(juego.getJugador(1).getVision().estaDescubierto(new Posicion(16,16)));
		assertTrue(juego.getJugador(1).getVision().estaDescubierto(new Posicion(16,2)));
		
	}

	 
}*/import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.movimientos.Abajo;
import fiuba.algo3.modelo.movimientos.Movimiento;
import fiuba.algo3.modelo.unidades.Marine;
import fiuba.algo3.modelo.unidades.NaveCiencia;
import fiuba.algo3.modelo.unidades.Unidad;
import fiuba.algo3.modelo.unidades.UnidadAerea;
import fiuba.algo3.modelo.unidades.UnidadTerrestre;

