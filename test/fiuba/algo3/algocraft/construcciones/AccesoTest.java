package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Acceso;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.unidades.Zealot;

public class AccesoTest {
	
	
	@Test
	public void testJugadorCreaAccesoEnCeldaVacia(){
		try{
			Juego juego = new Juego();
			Acceso acceso = new Acceso();
			Posicion posicion = new Posicion(1, 1);
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
			Juego juego = new Juego();
			Acceso acceso = new Acceso();
			Posicion posicion = new Posicion(1, 1);
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
			Posicion posicion = new Posicion(1, 1);
			Zealot zealot = new Zealot(posicion);
			juego.agregarUnidad(zealot, posicion);
			Acceso acceso = new Acceso();
			juego.agregarConstruccion(acceso, posicion);
		} catch(Exception e){
			assertEquals(true, e instanceof CeldaOcupada);
		}
	}
	
	@Test
	public void testJugadorNoCreaAccesoEnCeldaEspacial(){
		try{
			Juego juego = new Juego();
			Acceso acceso = new Acceso();
			Posicion posicion = new Posicion(1, 18);
			juego.agregarConstruccion(acceso, posicion);
		} catch(Exception e){
			assertEquals(true, e instanceof CeldaEspacial);
		}
	}
	
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

