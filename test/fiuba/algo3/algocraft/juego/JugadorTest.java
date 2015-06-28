package fiuba.algo3.algocraft.juego;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.razas.Protoss;
import fiuba.algo3.modelo.razas.Raza;
import fiuba.algo3.modelo.razas.Terran;

public class JugadorTest {
	
	@Test
	public void testCrearJugadorDebeCrearseConNombreVacio() throws FueraDeMatriz{
		Jugador jugador = new Jugador(new Posicion(2,2));
		assertEquals("",jugador.getNombre());
	}

	@Test
	public void testCrearJugadorDebeCrearseConColorVacio() throws FueraDeMatriz{
		Jugador jugador = new Jugador(new Posicion(2,2));
		assertEquals("",jugador.getColor());
	}
	
	@Test
	public void testSetNombreDebeGuardarElNombreDelJugador() throws NombreConMenosDe4Caracteres, FueraDeMatriz{
		Jugador jugador = new Jugador(new Posicion(2,2));
		jugador.setNombre("Martin");
		assertEquals("Martin",jugador.getNombre());
	}
	
	@Test
	public void testSetColorDebeGuardarElColorDelJugador() throws FueraDeMatriz{
		Jugador jugador = new Jugador(new Posicion(2,2));
		jugador.setColor("Rojo");
		assertEquals("Rojo",jugador.getColor());
	}
	
	@Test
	public void testSetRazaDebeGuardarLaRazaDelJugador() throws FueraDeMatriz{
		Jugador jugador = new Jugador(new Posicion(2,2));
		Juego juego = new Juego();
		Raza raza = new Protoss(juego);
		jugador.setRaza(raza);
		assertEquals(raza,jugador.getRaza());
	}
	
	@Test (expected = NombreConMenosDe4Caracteres.class)
	public void testSetNombreDebeTirarErrorSiElNombreTieneMenosDe4Caracteres() throws NombreConMenosDe4Caracteres, FueraDeMatriz{
		Jugador jugador = new Jugador(new Posicion(2,2));
		jugador.setNombre("Luz");
	}
}
