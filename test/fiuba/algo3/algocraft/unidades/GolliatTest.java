package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class GolliatTest {
	@Test
	public void testCrearUnidadGolliatDeberiaSetearElNombreGolliat() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Golliat unGolliat = new Golliat(new Posicion(2,2));
		
		assertEquals(unGolliat.getNombre(),"GOLLIAT");
	}
	
	@Test
	public void testCrearUnidadGolliatDeberiaSetearCostoDeMineral100() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Golliat unGolliat = new Golliat(new Posicion(2,2));
		Integer costoMineral = 100;
		assertEquals(unGolliat.getCostoDeRecursos().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearUnidadGolliatDeberiaSetearCostoDeGas50() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Golliat unGolliat = new Golliat(new Posicion(2,2));
		Integer costoGas = 50;
		assertEquals(unGolliat.getCostoDeRecursos().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearUnidadGolliatDeberiaSetearTiempoDeConstruccion6() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Golliat unGolliat = new Golliat(new Posicion(2,2));
		Integer cantDeTurnos = 6;
		assertEquals(unGolliat.getTiempoDeConstruccion().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadGolliatDeberiaSetearVida125() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Golliat unGolliat = new Golliat(new Posicion(2,2));
		Integer vida = 125;
		assertEquals(unGolliat.getVida().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadGolliatDeberiaSetearEscudo0() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Golliat unGolliat = new Golliat(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unGolliat.getEscudo().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadGolliatDeberiaSetearVision8() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Golliat unGolliat = new Golliat(new Posicion(2,2));
		int vision=8;
		assertEquals(unGolliat.getVision(),vision);
	}
	
	@Test
	public void testCrearUnidadGolliatDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Golliat unGolliat = new Golliat(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unGolliat.getUbicacion(),celda);
	}
	
	@Test
	public void testsetUbicacionGolliatDeberiaCambiarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, CeldaOcupada, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Golliat unGolliat = new Golliat(new Posicion(2,2));
		unGolliat.setNuevaUbicacion(Mapa.getInstance().getCelda(3, 3));
		Celda celda = Mapa.getInstance().getCelda(3, 3);
		assertEquals(unGolliat.getUbicacion(),celda);
	}
	
}
