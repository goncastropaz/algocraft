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

public class NaveCienciaTest {
	
	@Test
	public void testCrearUnidadNaveCienciaDeberiaSetearElNombreNaveCiencia() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NaveCiencia unaNaveCiencia = new NaveCiencia(new Posicion(2,2));
		
		assertEquals(unaNaveCiencia.getNombre(),"NAVE_CIENCIA");
	}
	
	@Test
	public void testCrearUnidadNaveCienciaDeberiaSetearCostoDeMineral100() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NaveCiencia unaNaveCiencia = new NaveCiencia(new Posicion(2,2));
		Integer costoMineral = 100;
		assertEquals(unaNaveCiencia.getCostoDeRecursos().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearUnidadNaveCienciaDeberiaSetearCostoDeGas225() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NaveCiencia unaNaveCiencia = new NaveCiencia(new Posicion(2,2));
		Integer costoGas = 225;
		assertEquals(unaNaveCiencia.getCostoDeRecursos().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearUnidadNaveCienciaDeberiaSetearTiempoDeConstruccion10() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NaveCiencia unaNaveCiencia = new NaveCiencia(new Posicion(2,2));
		Integer cantDeTurnos = 10;
		assertEquals(unaNaveCiencia.getTiempoDeConstruccion().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadNaveCienciaDeberiaSetearVida200() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NaveCiencia unaNaveCiencia = new NaveCiencia(new Posicion(2,2));
		Integer vida = 200;
		assertEquals(unaNaveCiencia.getVida().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadNaveCienciaDeberiaSetearEscudo0() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NaveCiencia unaNaveCiencia = new NaveCiencia(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unaNaveCiencia.getEscudo().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadNaveCienciaDeberiaSetearVision10() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NaveCiencia unaNaveCiencia = new NaveCiencia(new Posicion(2,2));
		int vision=10;
		assertEquals(unaNaveCiencia.getVision(),vision);
	}
	
	@Test
	public void testCrearUnidadNaveCienciaDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NaveCiencia unaNaveCiencia = new NaveCiencia(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unaNaveCiencia.getUbicacion(),celda);
	}
	
	@Test
	public void testsetUbicacionNaveCienciaDeberiaCambiarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, CeldaOcupada, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		NaveCiencia unaNaveCiencia = new NaveCiencia(new Posicion(2,2));
		unaNaveCiencia.setNuevaUbicacion(Mapa.getInstance().getCelda(3, 3));
		Celda celda = Mapa.getInstance().getCelda(3, 3);
		assertEquals(unaNaveCiencia.getUbicacion(),celda);
	}
}
