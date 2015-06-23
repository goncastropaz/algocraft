package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class PuertoEstelarTerranTest {
	@Test
	public void testCrearPuertoEstelarTerranDeberiaSetearElNombrePUERTO_ESTELAR_TERRAN() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarTerran unPuertoEstelarTerran = new PuertoEstelarTerran(new Posicion(2,2));
		
		assertEquals(unPuertoEstelarTerran.getName(),"PUERTO_ESTELAR_TERRAN");
	}
	
	@Test
	public void testCrearPuertoEstelarTerranDeberiaSetearCostoDeMineral150() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarTerran unPuertoEstelarTerran = new PuertoEstelarTerran(new Posicion(2,2));
		Integer costoMineral = 150;
		assertEquals(unPuertoEstelarTerran.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearPuertoEstelarTerranDeberiaSetearCostoDeGas100() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarTerran unPuertoEstelarTerran = new PuertoEstelarTerran(new Posicion(2,2));
		Integer costoGas = 100;
		assertEquals(unPuertoEstelarTerran.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearPuertoEstelarTerranDeberiaSetearTiempoDeConstruccion10() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarTerran unPuertoEstelarTerran = new PuertoEstelarTerran(new Posicion(2,2));
		Integer cantDeTurnos = 10;
		assertEquals(unPuertoEstelarTerran.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearPuertoEstelarTerranDeberiaSetearVida1300() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarTerran unPuertoEstelarTerran = new PuertoEstelarTerran(new Posicion(2,2));
		Integer vida = 1300;
		assertEquals(unPuertoEstelarTerran.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearPuertoEstelarTerranDeberiaSetearEscudo0() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarTerran unPuertoEstelarTerran = new PuertoEstelarTerran(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unPuertoEstelarTerran.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearPuertoEstelarTerranDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarTerran unPuertoEstelarTerran = new PuertoEstelarTerran(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unPuertoEstelarTerran.getUbicacion(),celda);
	}
}
