package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class DragonTest {
	@Test
	public void testCrearUnidadDragonDeberiaSetearElNombreDragon() throws FueraDeMatriz{
		Dragon unDragon = new Dragon(new Posicion(2,2));
		
		assertEquals(unDragon.getNombre(),"DRAGON");
	}
	
	@Test
	public void testCrearUnidadDragonDeberiaSetearCostoDeMineral125() throws FueraDeMatriz{
		Dragon unDragon = new Dragon(new Posicion(2,2));
		Integer costoMineral = 125;
		assertEquals(unDragon.getCostoDeRecursos().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearUnidadDragonDeberiaSetearCostoDeGas50() throws FueraDeMatriz{
		Dragon unDragon = new Dragon(new Posicion(2,2));
		Integer costoGas = 50;
		assertEquals(unDragon.getCostoDeRecursos().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearUnidadDragonDeberiaSetearTiempoDeConstruccion6() throws FueraDeMatriz{
		Dragon unDragon = new Dragon(new Posicion(2,2));
		Integer cantDeTurnos = 6;
		assertEquals(unDragon.getTiempoDeConstruccion().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadDragonDeberiaSetearVida100() throws FueraDeMatriz{
		Dragon unDragon = new Dragon(new Posicion(2,2));
		Integer vida = 100;
		assertEquals(unDragon.getVida().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadDragonDeberiaSetearEscudo80() throws FueraDeMatriz{
		Dragon unDragon = new Dragon(new Posicion(2,2));
		Integer escudo =80;
		assertEquals(unDragon.getEscudo().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadDragonDeberiaSetearVision8() throws FueraDeMatriz{
		Dragon unDragon = new Dragon(new Posicion(2,2));
		int vision=8;
		assertEquals(unDragon.getVision(),vision);
	}
	
	@Test
	public void testCrearUnidadDragonDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		Dragon unDragon = new Dragon(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unDragon.getUbicacion(),celda);
	}
	
	@Test
	public void testsetUbicacionDragonDeberiaCambiarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, CeldaOcupada{
		Dragon unDragon = new Dragon(new Posicion(2,2));
		unDragon.setNuevaUbicacion(Mapa.getInstance().getCelda(3, 3));
		Celda celda = Mapa.getInstance().getCelda(3, 3);
		assertEquals(unDragon.getUbicacion(),celda);
	}
}
