package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class PilonTest {
	@Test
	public void testCrearPilonDeberiaSetearElNombrePILON() throws FueraDeMatriz{
		Pilon unPilon = new Pilon(new Posicion(2,2));
		
		assertEquals(unPilon.getName(),"PILON");
	}
	
	@Test
	public void testCrearPilonDeberiaSetearCostoDeMineral100() throws FueraDeMatriz{
		Pilon unPilon = new Pilon(new Posicion(2,2));
		Integer costoMineral = 100;
		assertEquals(unPilon.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearPilonDeberiaSetearCostoDeGas0() throws FueraDeMatriz{
		Pilon unPilon = new Pilon(new Posicion(2,2));
		Integer costoGas = 0;
		assertEquals(unPilon.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearPilonDeberiaSetearTiempoDeConstruccion5() throws FueraDeMatriz{
		Pilon unPilon = new Pilon(new Posicion(2,2));
		Integer cantDeTurnos = 5;
		assertEquals(unPilon.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearPilonDeberiaSetearVida300() throws FueraDeMatriz{
		Pilon unPilon = new Pilon(new Posicion(2,2));
		Integer vida = 300;
		assertEquals(unPilon.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearPilonDeberiaSetearEscudo300() throws FueraDeMatriz{
		Pilon unPilon = new Pilon(new Posicion(2,2));
		Integer escudo =300;
		assertEquals(unPilon.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearPilonDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		Pilon unPilon = new Pilon(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unPilon.getUbicacion(),celda);
	}
}
