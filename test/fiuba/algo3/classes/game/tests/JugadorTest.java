package fiuba.algo3.classes.game.tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.exceptions.NombreConMenosDe4Caracteres;
import fiuba.algo3.classes.game.Jugador;
import fiuba.algo3.classes.game.Raza;

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
