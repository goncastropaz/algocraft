package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class FabricaTest {

	@Test
	public void testCrearFabricaDeberiaSetearElNombreFABRICA() throws FueraDeMatriz{
		Fabrica unaFabrica = new Fabrica(new Posicion(2,2));
		
		assertEquals(unaFabrica.getName(),"FABRICA");
	}
	
	@Test
	public void testCrearFabricaDeberiaSetearCostoDeMineral200() throws FueraDeMatriz{
		Fabrica unaFabrica = new Fabrica(new Posicion(2,2));
		Integer costoMineral = 200;
		assertEquals(unaFabrica.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearFabricaDeberiaSetearCostoDeGas100() throws FueraDeMatriz{
		Fabrica unaFabrica = new Fabrica(new Posicion(2,2));
		Integer costoGas = 100;
		assertEquals(unaFabrica.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearFabricaaDeberiaSetearTiempoDeConstruccion12() throws FueraDeMatriz{
		Fabrica unaFabrica = new Fabrica(new Posicion(2,2));
		Integer cantDeTurnos = 12;
		assertEquals(unaFabrica.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearFabricaDeberiaSetearVida1250() throws FueraDeMatriz{
		Fabrica unaFabrica = new Fabrica(new Posicion(2,2));
		Integer vida = 1250;
		assertEquals(unaFabrica.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearFabricaDeberiaSetearEscudo0() throws FueraDeMatriz{
		Fabrica unaFabrica = new Fabrica(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unaFabrica.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearFabricaDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		Fabrica unaFabrica = new Fabrica(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unaFabrica.getUbicacion(),celda);
	}
}
