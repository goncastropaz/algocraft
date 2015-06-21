package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class AsimiladorTest {
	
	@Test
	public void testCrearAsimiladorDeberiaSetearElNombreASIMILADOR() throws FueraDeMatriz{
		Asimilador unAsimilador = new Asimilador(new Posicion(2,2));
		
		assertEquals(unAsimilador.getName(),"ASIMILADOR");
	}
	
	@Test
	public void testCrearAsimiladorDeberiaSetearCostoDeMineral100() throws FueraDeMatriz{
		Asimilador unAsimilador = new Asimilador(new Posicion(2,2));
		Integer costoMineral = 100;
		assertEquals(unAsimilador.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearAsimiladorDeberiaSetearCostoDeGas0() throws FueraDeMatriz{
		Asimilador unAsimilador = new Asimilador(new Posicion(2,2));
		Integer costoGas = 0;
		assertEquals(unAsimilador.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearAsimiladorDeberiaSetearTiempoDeConstruccion6() throws FueraDeMatriz{
		Asimilador unAsimilador = new Asimilador(new Posicion(2,2));
		Integer cantDeTurnos = 6;
		assertEquals(unAsimilador.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearAsimiladorDeberiaSetearVida450() throws FueraDeMatriz{
		Asimilador unAsimilador = new Asimilador(new Posicion(2,2));
		Integer vida = 450;
		assertEquals(unAsimilador.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearAsimiladorDeberiaSetearEscudo450() throws FueraDeMatriz{
		Asimilador unAsimilador = new Asimilador(new Posicion(2,2));
		Integer escudo =450;
		assertEquals(unAsimilador.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearAsimiladorDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		Asimilador unAsimilador = new Asimilador(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unAsimilador.getUbicacion(),celda);
	}
}
