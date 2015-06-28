package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
/*
public class AccesoTest {
	
	@Test
	public void testCrearAccesoDeberiaSetearElNombreACCESO() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Acceso unAcceso = new Acceso(new Posicion(2,2));
		
		assertEquals(unAcceso.getName(),"ACCESO");
	}
	
	@Test
	public void testCrearAccesoDeberiaSetearCostoDeMineral150() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Acceso unAcceso = new Acceso(new Posicion(2,2));
		Integer costoMineral = 150;
		assertEquals(unAcceso.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearAccesoDeberiaSetearCostoDeGas0() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Acceso unAcceso = new Acceso(new Posicion(2,2));
		Integer costoGas = 0;
		assertEquals(unAcceso.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearAccesoDeberiaSetearTiempoDeConstruccion8() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Acceso unAcceso = new Acceso(new Posicion(2,2));
		Integer cantDeTurnos = 8;
		assertEquals(unAcceso.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearAccesoDeberiaSetearVida500() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Acceso unAcceso = new Acceso(new Posicion(2,2));
		Integer vida = 500;
		assertEquals(unAcceso.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearAccesoDeberiaSetearEscudo500() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Acceso unAcceso = new Acceso(new Posicion(2,2));
		Integer escudo =500;
		assertEquals(unAcceso.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearAccesoDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Acceso unAcceso = new Acceso(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unAcceso.getUbicacion(),celda);
	}
}
*/import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;

