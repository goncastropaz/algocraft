package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class RefineriaTest {

	@Test
	public void testCrearRefineriaDeberiaSetearElNombreREFINERIA() throws FueraDeMatriz{
		Refineria unaRefineria = new Refineria(new Posicion(2,2));
		
		assertEquals(unaRefineria.getName(),"REFINERIA");
	}
	
	@Test
	public void testCrearRefineriaDeberiaSetearCostoDeMineral100() throws FueraDeMatriz{
		Refineria unaRefineria = new Refineria(new Posicion(2,2));
		Integer costoMineral = 100;
		assertEquals(unaRefineria.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearRefineriaDeberiaSetearCostoDeGas0() throws FueraDeMatriz{
		Refineria unaRefineria = new Refineria(new Posicion(2,2));
		Integer costoGas = 0;
		assertEquals(unaRefineria.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearRefineriaDeberiaSetearTiempoDeConstruccion6() throws FueraDeMatriz{
		Refineria unaRefineria = new Refineria(new Posicion(2,2));
		Integer cantDeTurnos = 6;
		assertEquals(unaRefineria.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearRefineriaDeberiaSetearVida750() throws FueraDeMatriz{
		Refineria unaRefineria = new Refineria(new Posicion(2,2));
		Integer vida = 750;
		assertEquals(unaRefineria.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearRefineriaDeberiaSetearEscudo0() throws FueraDeMatriz{
		Refineria unaRefineria = new Refineria(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unaRefineria.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearRefineriaDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		Refineria unaRefineria = new Refineria(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unaRefineria.getUbicacion(),celda);
	}
}
