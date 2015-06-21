package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.unidades.AltoTemplario;
import fiuba.algo3.classes.stats.Posicion;

public class CentroDeMineralTest {

	@Test
	public void testCrearCentroDeMineralDeberiaSetearElNombreCENTRO_DE_MINERAL() throws FueraDeMatriz{
		CentroDeMineral unCentroDeMineral = new CentroDeMineral(new Posicion(2,2));
		
		assertEquals(unCentroDeMineral.getName(),"CENTRO_DE_MINERAL");
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearCostoDeMineral50() throws FueraDeMatriz{
		CentroDeMineral unCentroDeMineral = new CentroDeMineral(new Posicion(2,2));
		Integer costoMineral = 50;
		assertEquals(unCentroDeMineral.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearCostoDeGas0() throws FueraDeMatriz{
		CentroDeMineral unCentroDeMineral = new CentroDeMineral(new Posicion(2,2));
		Integer costoGas = 0;
		assertEquals(unCentroDeMineral.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearCentroDeMineralDeberiaSetearTiempoDeConstruccion4() throws FueraDeMatriz{
		CentroDeMineral unCentroDeMineral = new CentroDeMineral(new Posicion(2,2)); 
		Integer cantDeTurnos = 4;
		assertEquals(unCentroDeMineral.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearVida500() throws FueraDeMatriz{
		CentroDeMineral unCentroDeMineral = new CentroDeMineral(new Posicion(2,2));
		Integer vida = 500;
		assertEquals(unCentroDeMineral.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearEscudo0() throws FueraDeMatriz{
		CentroDeMineral unCentroDeMineral = new CentroDeMineral(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unCentroDeMineral.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		CentroDeMineral unCentroDeMineral = new CentroDeMineral(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unCentroDeMineral.getUbicacion(),celda);
	}
	

}
