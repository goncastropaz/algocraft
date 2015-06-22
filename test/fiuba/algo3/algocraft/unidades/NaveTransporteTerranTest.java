package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class NaveTransporteTerranTest {
	@Test
	public void testCrearUnidadNaveTransporteTerranDeberiaSetearElNombreNAVE_TRANSPORTE_TERRAN() throws FueraDeMatriz{
		NaveTransporteTerran unaNaveTransporteTerran = new NaveTransporteTerran(new Posicion(2,2));
		
		assertEquals(unaNaveTransporteTerran.getNombre(),"NAVE_TRANSPORTE_TERRAN");
	}
	
	@Test
	public void testCrearUnidadNaveTransporteTerranDeberiaSetearCostoDeMineral100() throws FueraDeMatriz{
		NaveTransporteTerran unaNaveTransporteTerran = new NaveTransporteTerran(new Posicion(2,2));
		Integer costoMineral = 100;
		assertEquals(unaNaveTransporteTerran.getCostoDeRecursos().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteTerrantDeberiaSetearCostoDeGas100() throws FueraDeMatriz{
		NaveTransporteTerran unaNaveTransporteTerran = new NaveTransporteTerran(new Posicion(2,2));
		Integer costoGas = 100;
		assertEquals(unaNaveTransporteTerran.getCostoDeRecursos().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteTerranDeberiaSetearTiempoDeConstruccion7() throws FueraDeMatriz{
		NaveTransporteTerran unaNaveTransporteTerran = new NaveTransporteTerran(new Posicion(2,2));
		Integer cantDeTurnos = 7;
		assertEquals(unaNaveTransporteTerran.getTiempoDeConstruccion().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteTerranDeberiaSetearVida150() throws FueraDeMatriz{
		NaveTransporteTerran unaNaveTransporteTerran = new NaveTransporteTerran(new Posicion(2,2));
		Integer vida = 150;
		assertEquals(unaNaveTransporteTerran.getVida().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteTerranDeberiaSetearEscudo0() throws FueraDeMatriz{
		NaveTransporteTerran unaNaveTransporteTerran = new NaveTransporteTerran(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unaNaveTransporteTerran.getEscudo().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteTerranDeberiaSetearVision8() throws FueraDeMatriz{
		NaveTransporteTerran unaNaveTransporteTerran = new NaveTransporteTerran(new Posicion(2,2));
		int vision=8;
		assertEquals(unaNaveTransporteTerran.getVision(),vision);
	}
	
	@Test
	public void testCrearUnidadNaveTransporteTerranDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		NaveTransporteTerran unaNaveTransporteTerran = new NaveTransporteTerran(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unaNaveTransporteTerran.getUbicacion(),celda);
	}
	
	@Test
	public void testsetUbicacionNaveTransporteTerranDeberiaCambiarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, CeldaOcupada{
		NaveTransporteTerran unaNaveTransporteTerran = new NaveTransporteTerran(new Posicion(2,2));
		unaNaveTransporteTerran.setNuevaUbicacion(Mapa.getInstance().getCelda(3, 3));
		Celda celda = Mapa.getInstance().getCelda(3, 3);
		assertEquals(unaNaveTransporteTerran.getUbicacion(),celda);
	}
}
