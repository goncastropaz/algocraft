package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class MarineTest {

	
	@Test
	public void testCrearUnidadMarineDeberiaSetearElNombreMarine() throws FueraDeMatriz{
		Marine unMarine = new Marine(new Posicion(2,2));
		
		assertEquals(unMarine.getNombre(),"MARINE");
	}
	
	@Test
	public void testCrearUnidadMarineDeberiaSetearCostoDeMineral50() throws FueraDeMatriz{
		Marine unMarine = new Marine(new Posicion(2,2));
		Integer costoMineralMarine = 50;
		assertEquals(unMarine.getCostoDeRecursos().getCostoMineral(),costoMineralMarine);
	}
	
	@Test
	public void testCrearUnidadMarineDeberiaSetearCostoDeGas0() throws FueraDeMatriz{
		Marine unMarine = new Marine(new Posicion(2,2));
		Integer costoGasMarine = 0;
		assertEquals(unMarine.getCostoDeRecursos().getCostoGas(),costoGasMarine);
	}
	
	@Test
	public void testCrearUnidadMarineDeberiaSetearTiempoDeConstruccion3() throws FueraDeMatriz{
		Marine unMarine = new Marine(new Posicion(2,2));
		Integer cantDeTurnos = 3;
		assertEquals(unMarine.getTiempoDeConstruccion().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadMarineDeberiaSetearVida40() throws FueraDeMatriz{
		Marine unMarine = new Marine(new Posicion(2,2));
		Integer vida = 40;
		assertEquals(unMarine.getVida().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadMarineDeberiaSetearEscudo0() throws FueraDeMatriz{
		Marine unMarine = new Marine(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unMarine.getEscudo().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadMarineDeberiaSetearVision7() throws FueraDeMatriz{
		Marine unMarine = new Marine(new Posicion(2,2));
		int vision=7;
		assertEquals(unMarine.getVision(),vision);
	}
	
	@Test
	public void testCrearUnidadMarineDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz{
		Marine unMarine = new Marine(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unMarine.getUbicacion(),celda);
	}
	
	@Test
	public void testsetUbicacionMarineDeberiaCambiarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, CeldaOcupada{
		Marine unMarine = new Marine(new Posicion(2,2));
		unMarine.setNuevaUbicacion(Mapa.getInstance().getCelda(3, 3));
		Celda celda = Mapa.getInstance().getCelda(3, 3);
		assertEquals(unMarine.getUbicacion(),celda);
	}
}
