package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class NaveTransporteProtossTest {
	@Test
	public void testCrearUnidadNaveTransporteProtossDeberiaSetearElNombreNAVE_TRANSPORTE_PROTOSS() throws FueraDeMatriz{
		NaveTransporteProtoss unaNaveTransporteProtoss = new NaveTransporteProtoss(new Posicion(2,2));
		
		assertEquals(unaNaveTransporteProtoss.getNombre(),"NAVE_TRANSPORTE_PROTOSS");
	}
	
	@Test
	public void testCrearUnidadNaveTransporteProtossDeberiaSetearCostoDeMineral200() throws FueraDeMatriz{
		NaveTransporteProtoss unaNaveTransporteProtoss = new NaveTransporteProtoss(new Posicion(2,2));
		Integer costoMineral = 200;
		assertEquals(unaNaveTransporteProtoss.getCostoDeRecursos().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteProtossDeberiaSetearCostoDeGas0() throws FueraDeMatriz{
		NaveTransporteProtoss unaNaveTransporteProtoss = new NaveTransporteProtoss(new Posicion(2,2));
		Integer costoGas = 0;
		assertEquals(unaNaveTransporteProtoss.getCostoDeRecursos().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteProtossDeberiaSetearTiempoDeConstruccion8() throws FueraDeMatriz{
		NaveTransporteProtoss unaNaveTransporteProtoss = new NaveTransporteProtoss(new Posicion(2,2));
		Integer cantDeTurnos = 8;
		assertEquals(unaNaveTransporteProtoss.getTiempoDeConstruccion().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteProtossDeberiaSetearVida80() throws FueraDeMatriz{
		NaveTransporteProtoss unaNaveTransporteProtoss = new NaveTransporteProtoss(new Posicion(2,2));
		Integer vida = 80;
		assertEquals(unaNaveTransporteProtoss.getVida().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteProtossDeberiaSetearEscudo60() throws FueraDeMatriz{
		NaveTransporteProtoss unaNaveTransporteProtoss = new NaveTransporteProtoss(new Posicion(2,2));
		Integer escudo =60;
		assertEquals(unaNaveTransporteProtoss.getEscudo().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteProtossDeberiaSetearVision8() throws FueraDeMatriz{
		NaveTransporteProtoss unaNaveTransporteProtoss = new NaveTransporteProtoss(new Posicion(2,2));
		int vision=8;
		assertEquals(unaNaveTransporteProtoss.getVision(),vision);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteProtossDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		NaveTransporteProtoss unaNaveTransporteProtoss = new NaveTransporteProtoss(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unaNaveTransporteProtoss.getUbicacion(),celda);
	}
	
	@Test
	public void testsetUbicacionNaveTransporteProtossDeberiaCambiarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		NaveTransporteProtoss unaNaveTransporteProtoss = new NaveTransporteProtoss(new Posicion(2,2));
		unaNaveTransporteProtoss.setNuevaUbicacion(Mapa.getInstance().getCelda(3, 3));
		Celda celda = Mapa.getInstance().getCelda(3, 3);
		assertEquals(unaNaveTransporteProtoss.getUbicacion(),celda);
	}
}
