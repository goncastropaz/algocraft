package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.unidades.Marine;
import fiuba.algo3.algocraft.unidades.Zealot;
import fiuba.algo3.classes.stats.Posicion;

public class ZealotTest {

	@Test
	public void testCrearUnidadZealotDeberiaSetearElNombreZealot() throws FueraDeMatriz{
		Zealot unZealot = new Zealot(new Posicion(2,2));
		
		assertEquals(unZealot.getNombre(),"ZEALOT");
	}
	
	@Test
	public void testCrearUnidadZealotDeberiaSetearCostoDeMineral100() throws FueraDeMatriz{
		Zealot unZealot = new Zealot(new Posicion(2,2));
		Integer costoMineralZealot = 100;
		assertEquals(unZealot.getCostoDeRecursos().getCostoMineral(),costoMineralZealot);
	}
	
	@Test
	public void testCrearUnidadZealotDeberiaSetearCostoDeGas0() throws FueraDeMatriz{
		Zealot unZealot = new Zealot(new Posicion(2,2));
		Integer costoGasZealot = 0;
		assertEquals(unZealot.getCostoDeRecursos().getCostoGas(),costoGasZealot);
	}
	
	@Test
	public void testCrearUnidadZealotDeberiaSetearTiempoDeConstruccion4() throws FueraDeMatriz{
		Zealot unZealot = new Zealot(new Posicion(2,2));
		Integer cantDeTurnos = 4;
		assertEquals(unZealot.getTiempoDeConstruccion().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadZealotDeberiaSetearVida100() throws FueraDeMatriz{
		Zealot unZealot = new Zealot(new Posicion(2,2));
		Integer vida = 100;
		assertEquals(unZealot.getVida().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadZealotDeberiaSetearEscudo60() throws FueraDeMatriz{
		Zealot unZealot = new Zealot(new Posicion(2,2));
		Integer escudo =60;
		assertEquals(unZealot.getEscudo().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadZealotDeberiaSetearVision7() throws FueraDeMatriz{
		Zealot unZealot = new Zealot(new Posicion(2,2));
		int vision=7;
		assertEquals(unZealot.getVision(),vision);
	}
	
	@Test
	public void testCrearUnidadZealotDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		Zealot unZealot = new Zealot(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unZealot.getUbicacion(),celda);
	}
	
	@Test
	public void testsetUbicacionZealotDeberiaCambiarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, CeldaOcupada{
		Zealot unZealot = new Zealot(new Posicion(2,2));
		unZealot.setNuevaUbicacion(Mapa.getInstance().getCelda(3, 3));
		Celda celda = Mapa.getInstance().getCelda(3, 3);
		assertEquals(unZealot.getUbicacion(),celda);
	}
	
}