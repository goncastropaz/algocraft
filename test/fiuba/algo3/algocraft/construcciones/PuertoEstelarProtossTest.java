package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class PuertoEstelarProtossTest {
	@Test
	public void testCrearPuertoEstelarProtossDeberiaSetearElNombrePUERTO_ESTELAR_PROTOSS() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarProtoss unPuertoEstelarProtoss = new PuertoEstelarProtoss(new Posicion(2,2));
		
		assertEquals(unPuertoEstelarProtoss.getName(),"PUERTO_ESTELAR_PROTOSS");
	}
	
	@Test
	public void testCrearPuertoEstelarProtossDeberiaSetearCostoDeMineral150() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarProtoss unPuertoEstelarProtoss = new PuertoEstelarProtoss(new Posicion(2,2));
		Integer costoMineral = 150;
		assertEquals(unPuertoEstelarProtoss.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearPuertoEstelarProtossDeberiaSetearCostoDeGas150() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarProtoss unPuertoEstelarProtoss = new PuertoEstelarProtoss(new Posicion(2,2));
		Integer costoGas = 150;
		assertEquals(unPuertoEstelarProtoss.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearPuertoEstelarProtossDeberiaSetearTiempoDeConstruccion10() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarProtoss unPuertoEstelarProtoss = new PuertoEstelarProtoss(new Posicion(2,2));
		Integer cantDeTurnos = 10;
		assertEquals(unPuertoEstelarProtoss.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearPuertoEstelarProtossDeberiaSetearVida600() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarProtoss unPuertoEstelarProtoss = new PuertoEstelarProtoss(new Posicion(2,2));
		Integer vida = 600;
		assertEquals(unPuertoEstelarProtoss.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearPuertoEstelarProtossDeberiaSetearEscudo600() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarProtoss unPuertoEstelarProtoss = new PuertoEstelarProtoss(new Posicion(2,2));
		Integer escudo =600;
		assertEquals(unPuertoEstelarProtoss.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearPuertoEstelarProtossDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		PuertoEstelarProtoss unPuertoEstelarProtoss = new PuertoEstelarProtoss(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unPuertoEstelarProtoss.getUbicacion(),celda);
	}
}
