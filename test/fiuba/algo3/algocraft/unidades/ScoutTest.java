package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class ScoutTest {
	@Test
	public void testCrearUnidadScoutDeberiaSetearElNombreScout() throws FueraDeMatriz{
		Scout unScout = new Scout(new Posicion(2,2));
		
		assertEquals(unScout.getNombre(),"SCOUT");
	}
	
	@Test
	public void testCrearUnidadScoutDeberiaSetearCostoDeMineral300() throws FueraDeMatriz{
		Scout unScout = new Scout(new Posicion(2,2));
		Integer costoMineral = 300;
		assertEquals(unScout.getCostoDeRecursos().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearUnidadScoutDeberiaSetearCostoDeGas150() throws FueraDeMatriz{
		Scout unScout = new Scout(new Posicion(2,2));
		Integer costoGas = 150;
		assertEquals(unScout.getCostoDeRecursos().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearUnidadScoutDeberiaSetearTiempoDeConstruccion9() throws FueraDeMatriz{
		Scout unScout = new Scout(new Posicion(2,2));
		Integer cantDeTurnos = 9;
		assertEquals(unScout.getTiempoDeConstruccion().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadScoutDeberiaSetearVida150() throws FueraDeMatriz{
		Scout unScout = new Scout(new Posicion(2,2));
		Integer vida = 150;
		assertEquals(unScout.getVida().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadScoutDeberiaSetearEscudo100() throws FueraDeMatriz{
		Scout unScout = new Scout(new Posicion(2,2));
		Integer escudo =100;
		assertEquals(unScout.getEscudo().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadScoutDeberiaSetearVision7() throws FueraDeMatriz{
		Scout unScout = new Scout(new Posicion(2,2));
		int vision=7;
		assertEquals(unScout.getVision(),vision);
	}
	
	@Test
	public void testCrearUnidadScoutDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		Scout unScout = new Scout(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unScout.getUbicacion(),celda);
	}
	
	@Test
	public void testsetUbicacionScoutDeberiaCambiarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, CeldaOcupada{
		Scout unScout = new Scout(new Posicion(2,2));
		unScout.setNuevaUbicacion(Mapa.getInstance().getCelda(3, 3));
		Celda celda = Mapa.getInstance().getCelda(3, 3);
		assertEquals(unScout.getUbicacion(),celda);
	}
	
}
