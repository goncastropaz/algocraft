package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class EspectroTest {
	@Test
	public void testCrearUnidadEspectroDeberiaSetearElNombreEspectro() throws FueraDeMatriz{
		Espectro unEspectro = new Espectro(new Posicion(2,2));
		
		assertEquals(unEspectro.getNombre(),"ESPECTRO");
	}
	
	@Test
	public void testCrearUnidadEspectroDeberiaSetearCostoDeMineral150() throws FueraDeMatriz{
		Espectro unEspectro = new Espectro(new Posicion(2,2));
		Integer costoMineral = 150;
		assertEquals(unEspectro.getCostoDeRecursos().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearUnidadEspectroDeberiaSetearCostoDeGas100() throws FueraDeMatriz{
		Espectro unEspectro = new Espectro(new Posicion(2,2));
		Integer costoGas = 100;
		assertEquals(unEspectro.getCostoDeRecursos().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearUnidadEspectroDeberiaSetearTiempoDeConstruccion8() throws FueraDeMatriz{
		Espectro unEspectro = new Espectro(new Posicion(2,2));
		Integer cantDeTurnos = 8;
		assertEquals(unEspectro.getTiempoDeConstruccion().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadEspectroDeberiaSetearVida120() throws FueraDeMatriz{
		Espectro unEspectro = new Espectro(new Posicion(2,2));
		Integer vida = 120;
		assertEquals(unEspectro.getVida().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadEspectroDeberiaSetearEscudo0() throws FueraDeMatriz{
		Espectro unEspectro = new Espectro(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unEspectro.getEscudo().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadEspectroDeberiaSetearVision7() throws FueraDeMatriz{
		Espectro unEspectro = new Espectro(new Posicion(2,2));
		int vision=7;
		assertEquals(unEspectro.getVision(),vision);
	}
	
	@Test
	public void testCrearUnidadEspectroDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		Espectro unEspectro = new Espectro(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unEspectro.getUbicacion(),celda);
	}
	
	@Test
	public void testsetUbicacionEspectroDeberiaCambiarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial{
		Espectro unEspectro = new Espectro(new Posicion(2,2));
		unEspectro.setNuevaUbicacion(Mapa.getInstance().getCelda(3, 3));
		Celda celda = Mapa.getInstance().getCelda(3, 3);
		assertEquals(unEspectro.getUbicacion(),celda);
	}
}
