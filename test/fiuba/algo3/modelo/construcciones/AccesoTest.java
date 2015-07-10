package fiuba.algo3.modelo.construcciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Acceso;
import fiuba.algo3.modelo.construcciones.Pilon;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.razas.Protoss;
import fiuba.algo3.modelo.unidades.Zealot;

public class AccesoTest {
	
	
	@Test
	public void testJugadorCreaAccesoEnCeldaVacia(){
		try{
			Posicion posicion = new Posicion(1, 1);
			Juego juego = new Juego();
			Acceso acceso = new Acceso(posicion);
			juego.getActualJugador().setRaza(new Protoss(juego));
			for(int i = 0; i < 15; i++) juego.getActualJugador().actualizarMineral();
			juego.agregarConstruccion(acceso, posicion);
			assertEquals(1, juego.getActualJugador().getConstruccionesList().size());
			assertEquals(true, juego.getActualJugador().getConstruccionesList().contains(acceso));
		} catch(Exception e){
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testJugadorNoCreaAccesoEnCeldaOcupadaConEdificio(){
		try{
			Posicion posicion = new Posicion(1, 1);
			Juego juego = new Juego();
			Acceso acceso = new Acceso(posicion);
			juego.getActualJugador().setRaza(new Protoss(juego));
			for(int i = 0; i < 30; i++) juego.getActualJugador().actualizarMineral();
			juego.agregarConstruccion(acceso, posicion);
			juego.agregarConstruccion(acceso, posicion);
		} catch(Exception e){
			assertEquals(true, e instanceof CeldaOcupada);
		}
	}
	
	@Test
	public void testJugadorNoCreaAccesoEnCeldaOcupadaConUnidad(){
		try{
			Juego juego = new Juego();
			Posicion posicion1 = new Posicion(1, 1);
			Posicion posicion2 = new Posicion(2, 2);
			Posicion posicion3 = new Posicion(3, 3);
			Zealot zealot = new Zealot();
			Pilon pilon = new Pilon(posicion1);
			Acceso acceso1 = new Acceso(posicion2);
			Acceso acceso2 = new Acceso(posicion3);
			juego.getActualJugador().setRaza(new Protoss(juego));
			for(int i = 0; i < 50; i++) juego.getActualJugador().actualizarMineral();
			juego.getActualJugador().agregarConstruccion(pilon);
			juego.agregarConstruccion(acceso1, posicion2);
			juego.getMapaDeJuego().devolverCelda(posicion3).setUnidad(zealot);
			juego.agregarConstruccion(acceso2, posicion3);
		} catch(Exception e){
			assertEquals(true, e instanceof CeldaOcupada);
		}
	}
	
//	@Test
//	public void testJugadorNoCreaAccesoEnCeldaEspacial(){
//		try{
//			Posicion posicion = new Posicion(1, 18);
//			Juego juego = new Juego();
//			Acceso acceso = new Acceso(posicion);
//			juego.getActualJugador().setRaza(new Protoss(juego));
//			for(int i = 0; i < 35; i++) juego.getActualJugador().actualizarMineral();
//			juego.agregarConstruccion(acceso, posicion);
//		} catch(Exception e){
//			assertEquals(true, e instanceof CeldaEspacial);
//		}
//	}
	
//	@Test
//	public void testCrearAccesoDeberiaSetearElNombreACCESO() throws FueraDeMatriz, JugadorInvalido{
//		Juego nuevoJuego = Juego.getInstance();
//		nuevoJuego.empezarJuego();
//		Acceso unAcceso = new Acceso(new Posicion(2,2));
//		
//		assertEquals(unAcceso.getName(),"ACCESO");
//	}
//	
//	@Test
//	public void testCrearAccesoDeberiaSetearCostoDeMineral150() throws FueraDeMatriz, JugadorInvalido{
//		Juego nuevoJuego = Juego.getInstance();
//		nuevoJuego.empezarJuego();
//		Acceso unAcceso = new Acceso(new Posicion(2,2));
//		Integer costoMineral = 150;
//		assertEquals(unAcceso.getCost().getCostoMineral(),costoMineral);
//	}
//	
//	@Test
//	public void testCrearAccesoDeberiaSetearCostoDeGas0() throws FueraDeMatriz, JugadorInvalido{
//		Juego nuevoJuego = Juego.getInstance();
//		nuevoJuego.empezarJuego();
//		Acceso unAcceso = new Acceso(new Posicion(2,2));
//		Integer costoGas = 0;
//		assertEquals(unAcceso.getCost().getCostoGas(),costoGas);
//	}
//	
//	@Test
//	public void testCrearAccesoDeberiaSetearTiempoDeConstruccion8() throws FueraDeMatriz, JugadorInvalido{
//		Juego nuevoJuego = Juego.getInstance();
//		nuevoJuego.empezarJuego();
//		Acceso unAcceso = new Acceso(new Posicion(2,2));
//		Integer cantDeTurnos = 8;
//		assertEquals(unAcceso.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
//	}
//	
//	@Test
//	public void testCrearAccesoDeberiaSetearVida500() throws FueraDeMatriz, JugadorInvalido{
//		Juego nuevoJuego = Juego.getInstance();
//		nuevoJuego.empezarJuego();
//		Acceso unAcceso = new Acceso(new Posicion(2,2));
//		Integer vida = 500;
//		assertEquals(unAcceso.getHealth().getVidaMaxima(),vida);
//	}
//	
//	@Test
//	public void testCrearAccesoDeberiaSetearEscudo500() throws FueraDeMatriz, JugadorInvalido{
//		Juego nuevoJuego = Juego.getInstance();
//		nuevoJuego.empezarJuego();
//		Acceso unAcceso = new Acceso(new Posicion(2,2));
//		Integer escudo =500;
//		assertEquals(unAcceso.getShield().getEscudoTotal(),escudo);
//	}
//	
//	@Test
//	public void testCrearAccesoDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, JugadorInvalido{
//		Juego nuevoJuego = Juego.getInstance();
//		nuevoJuego.empezarJuego();
//		Acceso unAcceso = new Acceso(new Posicion(2,2));
//		Celda celda = Mapa.getInstance().getCelda(2, 2);
//		assertEquals(unAcceso.getUbicacion(),celda);
//	}
}

