package fiuba.algo3.algocraft.unidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
/*
public class AltoTemplarioTest {
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearElNombreunAltoTemplario() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		AltoTemplario unAltoTemplario = new AltoTemplario(new Posicion(2,2));
		
		assertEquals(unAltoTemplario.getNombre(),"ALTO_TEMPLARIO");
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearCostoDeMineral50() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		AltoTemplario unAltoTemplario = new AltoTemplario(new Posicion(2,2));
		Integer costoMineral = 50;
		assertEquals(unAltoTemplario.getCostoDeRecursos().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearCostoDeGas150() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		AltoTemplario unAltoTemplario = new AltoTemplario(new Posicion(2,2));
		Integer costoGas = 150;
		assertEquals(unAltoTemplario.getCostoDeRecursos().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearTiempoDeConstruccion7() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		AltoTemplario unAltoTemplario = new AltoTemplario(new Posicion(2,2));
		Integer cantDeTurnos = 7;
		assertEquals(unAltoTemplario.getTiempoDeConstruccion().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearVida40() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		AltoTemplario unAltoTemplario = new AltoTemplario(new Posicion(2,2));
		Integer vida = 40;
		assertEquals(unAltoTemplario.getVida().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearEscudo40() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		AltoTemplario unAltoTemplario = new AltoTemplario(new Posicion(2,2));
		Integer escudo =40;
		assertEquals(unAltoTemplario.getEscudo().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaSetearVision7() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		AltoTemplario unAltoTemplario = new AltoTemplario(new Posicion(2,2));
		int vision=7;
		assertEquals(unAltoTemplario.getVision(),vision);
	}
	
	@Test
	public void testCrearUnidadAltoTemplarioDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		AltoTemplario unAltoTemplario = new AltoTemplario(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unAltoTemplario.getUbicacion(),celda);
	}
	
	@Test
	public void testsetUbicacionAltoTemplarioDeberiaCambiarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, UnidadTerrestreEnAreaEspacial, CeldaOcupada, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		AltoTemplario unAltoTemplario = new AltoTemplario(new Posicion(2,2));
		unAltoTemplario.setNuevaUbicacion(Mapa.getInstance().getCelda(3, 3));
		Celda celda = Mapa.getInstance().getCelda(3, 3);
		assertEquals(unAltoTemplario.getUbicacion(),celda);
	}
}*/import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;

