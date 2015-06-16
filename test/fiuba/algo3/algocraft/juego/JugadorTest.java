package fiuba.algo3.algocraft.juego;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.juego.Raza;

public class JugadorTest {
	
	@Test
	public void testCrearJugadorDebeCrearseConNombreVacio(){
		Jugador jugador = new Jugador();
		assertEquals("",jugador.getNombre());
	}

	@Test
	public void testCrearJugadorDebeCrearseConColorVacio(){
		Jugador jugador = new Jugador();
		assertEquals("",jugador.getColor());
	}
	
	@Test
	public void testSetNombreDebeGuardarElNombreDelJugador() throws NombreConMenosDe4Caracteres{
		Jugador jugador = new Jugador();
		jugador.setNombre("Martin");
		assertEquals("Martin",jugador.getNombre());
	}
	
	@Test
	public void testSetColorDebeGuardarElColorDelJugador(){
		Jugador jugador = new Jugador();
		jugador.setColor("Rojo");
		assertEquals("Rojo",jugador.getColor());
	}
	
	@Test
	public void testSetRazaDebeGuardarLaRazaDelJugador(){
		Jugador jugador = new Jugador();
		Raza raza = new Raza();
		jugador.setRaza(raza);
		assertEquals(raza,jugador.getRaza());
	}
	
	@Test (expected = NombreConMenosDe4Caracteres.class)
	public void testSetNombreDebeTirarErrorSiElNombreTieneMenosDe4Caracteres() throws NombreConMenosDe4Caracteres{
		Jugador jugador = new Jugador();
		jugador.setNombre("Luz");
	}
}