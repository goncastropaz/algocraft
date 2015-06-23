package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class NexoMineralTest {
	@Test
	public void testCrearNexoMineralDeberiaSetearElNombreNEXO_MINERAL() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NexoMineral unNexoMineral = new NexoMineral(new Posicion(2,2));
		
		assertEquals(unNexoMineral.getName(),"NEXO_MINERAL");
	}
	
	@Test
	public void testCrearNexoMineralDeberiaSetearCostoDeMineral50() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NexoMineral unNexoMineral = new NexoMineral(new Posicion(2,2));
		Integer costoMineral = 50;
		assertEquals(unNexoMineral.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearNexoMineralDeberiaSetearCostoDeGas0() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NexoMineral unNexoMineral = new NexoMineral(new Posicion(2,2));
		Integer costoGas = 0;
		assertEquals(unNexoMineral.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearNexoMineralDeberiaSetearTiempoDeConstruccion4() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NexoMineral unNexoMineral = new NexoMineral(new Posicion(2,2));
		Integer cantDeTurnos = 4;
		assertEquals(unNexoMineral.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearNexoMineralDeberiaSetearVida250() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NexoMineral unNexoMineral = new NexoMineral(new Posicion(2,2));
		Integer vida = 250;
		assertEquals(unNexoMineral.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearNexoMineralDeberiaSetearEscudo250() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NexoMineral unNexoMineral = new NexoMineral(new Posicion(2,2));
		Integer escudo =250;
		assertEquals(unNexoMineral.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearNexoMineralDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NexoMineral unNexoMineral = new NexoMineral(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unNexoMineral.getUbicacion(),celda);
	}
}
