package fiuba.algo3.algocraft.movimientos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
/*
public class DerechaTest {

	@Test
	public void testmoverDerechaDeberiaMoverLaUnidadALaCeldaDeLaDerecha() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();

		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(2,1));

		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		
		derecha.mover(unidad);
		
		assertEquals(unidad.getUbicacion().getPosicion().getFila(),1);
		assertEquals(unidad.getUbicacion().getPosicion().getColumna(),2);
		
	}
	
	@Test
	public void testmoverDerechaDeberiaRemoverLaUnidadDeLaViejaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();

		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		derecha.mover(unidad);
		
		assertNull(mapa.getCelda(1,1).getUnidad());
		
	}
	
	@Test
	public void testmoverDerechaDeberiaAgregarLaUnidadALaNuevaCelda() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(1, 1));
		derecha.mover(unidad);
		
		assertEquals(mapa.getCelda(1,2).getUnidad(),unidad);
		
	}
	
	@Test (expected = FueraDeMatriz.class)
	public void testmoverDerechaDeberiaLanzarErrorSiEstaEnElBordeDerechoDelMapa() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();

		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Marine unidad = new Marine(new Posicion(1,1));

		unidad.setNuevaUbicacion(mapa.getCelda(5, 49));
		derecha.mover(unidad);
	}

	@Test 
	public void testmoverDerechaUnaUnidadDeTierraEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaALaDerecha() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Marine unidadDeTierra = new Marine(new Posicion(2,2));
		derecha.mover(unidadDeTierra);
		
		assertEquals(unidadDeTierra.getUbicacion().getPosicion().getFila(),2);
		assertEquals(unidadDeTierra.getUbicacion().getPosicion().getColumna(),3);
	}
	
	@Test 
	public void testmoverDerechaUnaUnidadAereaEnAreaDeTierraDeberiaMoverLaUnidadUnaCeldaALaDerecha() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Unidad unidadAerea = new NaveCiencia(new Posicion(2,2));
		derecha.mover(unidadAerea);
		
		assertEquals(unidadAerea.getUbicacion().getPosicion().getFila(),2);
		assertEquals(unidadAerea.getUbicacion().getPosicion().getColumna(),3);
	}
	
	@Test 
	public void testmoverDerechaUnaUnidadAereaEnAreaAereaDeberiaMoverLaUnidadUnaCeldaALaDerecha() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
			Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Unidad unidadAerea = new NaveCiencia(new Posicion(20,20));
		derecha.mover(unidadAerea);
		
		assertEquals(unidadAerea.getUbicacion().getPosicion().getFila(),20);
		assertEquals(unidadAerea.getUbicacion().getPosicion().getColumna(),21);
	}
	
	@Test (expected = UnidadTerrestreEnAreaEspacial.class)
	public void testmoverDerechaUnaUnidadDeTierraEnAreaAereaDeberiaLanzarError() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, JugadorInvalido, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Movimiento derecha = new Derecha();
		Mapa mapa = Mapa.getInstance();
		Marine unidadDeTierra = new Marine(new Posicion(20,17));
		derecha.mover(unidadDeTierra);

	}
	
	
	@Test
	public void testmoverDerechaUnaUnidadDeberiaActualizarLaVisionDelJugadorDeAcuerdoConLaVisionDeLaUnidad() throws FueraDeMatriz, JugadorInvalido, UnidadTerrestreEnAreaEspacial, CeldaOcupada{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Juego juego = Juego.getInstance();
		Marine unMarine = new Marine(new Posicion(9,9));
		Movimiento derecha = new Derecha();
		derecha.mover(unMarine);
		
		assertTrue(juego.getJugador(1).getVision().estaDescubierto(new Posicion(16,17)));
		assertTrue(juego.getJugador(1).getVision().estaDescubierto(new Posicion(16,3)));
		
	}
}*/import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.movimientos.Derecha;
import fiuba.algo3.modelo.movimientos.Movimiento;
import fiuba.algo3.modelo.unidades.Marine;
import fiuba.algo3.modelo.unidades.NaveCiencia;
import fiuba.algo3.modelo.unidades.Unidad;

