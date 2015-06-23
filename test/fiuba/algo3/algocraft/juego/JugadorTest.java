package fiuba.algo3.algocraft.juego;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.razas.Protoss;
import fiuba.algo3.algocraft.razas.Raza;
import fiuba.algo3.algocraft.razas.Terran;
import fiuba.algo3.classes.stats.Posicion;

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
		Raza raza = new Protoss();
		jugador.setRaza(raza);
		assertEquals(raza,jugador.getRaza());
	}
	
	@Test (expected = NombreConMenosDe4Caracteres.class)
	public void testSetNombreDebeTirarErrorSiElNombreTieneMenosDe4Caracteres() throws NombreConMenosDe4Caracteres, FueraDeMatriz{
		Jugador jugador = new Jugador(new Posicion(2,2));
		jugador.setNombre("Luz");
	}
}
