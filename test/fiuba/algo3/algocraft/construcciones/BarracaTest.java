package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class BarracaTest {

	@Test
	public void testCrearBarracaDeberiaSetearElNombreBARRACA() throws FueraDeMatriz{
		Barraca unaBarraca = new Barraca(new Posicion(2,2));
		
		assertEquals(unaBarraca.getName(),"BARRACA");
	}
	
	@Test
	public void testCrearBarracaDeberiaSetearCostoDeMineral150() throws FueraDeMatriz{
		Barraca unaBarraca = new Barraca(new Posicion(2,2));
		Integer costoMineral = 150;
		assertEquals(unaBarraca.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearBarracaDeberiaSetearCostoDeGas0() throws FueraDeMatriz{
		Barraca unaBarraca = new Barraca(new Posicion(2,2));
		Integer costoGas = 0;
		assertEquals(unaBarraca.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearBarracaDeberiaSetearTiempoDeConstruccion12() throws FueraDeMatriz{
		Barraca unaBarraca = new Barraca(new Posicion(2,2));
		Integer cantDeTurnos = 12;
		assertEquals(unaBarraca.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearBarracaDeberiaSetearVida1000() throws FueraDeMatriz{
		Barraca unaBarraca = new Barraca(new Posicion(2,2));
		Integer vida = 1000;
		assertEquals(unaBarraca.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearBarracaDeberiaSetearEscudo0() throws FueraDeMatriz{
		Barraca unaBarraca = new Barraca(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unaBarraca.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearBarracaDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		Barraca unaBarraca = new Barraca(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unaBarraca.getUbicacion(),celda);
	}
	
}
