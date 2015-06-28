package fiuba.algo3.algocraft.juego;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.excepciones.ColorYaExiste;
import fiuba.algo3.modelo.excepciones.CompletarDatosException;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.modelo.excepciones.NombreYaExiste;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.utiles.Constants;

public class JuegoTest {

	
	@Test (expected = JugadorInvalido.class)
	public void testGetJugadorDebeTirarErrorSiSePideUnJugadorInvalido() throws FueraDeMatriz, JugadorInvalido{
		Juego juego = new Juego();
		Jugador jugador1 = juego.getJugador(3);
	}
	

	@Test
	public void testSetNombreJugadorDebeGuardarElNombreEnJugador() throws FueraDeMatriz, NombreYaExiste, NombreConMenosDe4Caracteres, JugadorInvalido, CompletarDatosException{
		Juego juego = new Juego();
		Jugador jugador1 = juego.getJugador(1);
		juego.setNombreJugador(1,"Lucas");
		assertEquals("Lucas",jugador1.getNombre());
	}
	
	@Test
	public void testSetColorJugadorDebeGuardarElColorEnJugador() throws FueraDeMatriz, ColorYaExiste, JugadorInvalido, CompletarDatosException{
		Juego juego = new Juego();
		Jugador jugador1 = juego.getJugador(1);
		juego.setColorJugador(1,Constants.ROJO);
		assertEquals(Constants.ROJO,jugador1.getColor());
	}
	
	@Test (expected = NombreYaExiste.class)
	public void testSetNombreJugador2DebeTirarErrorSiEsIgualAl1() throws FueraDeMatriz, NombreYaExiste,NombreConMenosDe4Caracteres, JugadorInvalido, CompletarDatosException{
		Juego juego = new Juego();
		
		juego.setNombreJugador(1,"Martin");
		juego.setNombreJugador(2,"Martin");
	
	}
	
	@Test (expected = NombreYaExiste.class)
	public void testSetNombreJugador1DebeTirarErrorSiEsIgualAl2() throws FueraDeMatriz, NombreYaExiste, JugadorInvalido, NombreConMenosDe4Caracteres, CompletarDatosException{
		Juego juego = new Juego();
		
		juego.setNombreJugador(2,"Martin");
		juego.setNombreJugador(1,"Martin");
	
	}
	
	@Test (expected = ColorYaExiste.class)
	public void testSetColorJugador1DebeTirarErrorSiEsIgualAl2() throws FueraDeMatriz, JugadorInvalido, ColorYaExiste, CompletarDatosException{
		Juego juego = new Juego();
		
		juego.setColorJugador(2,Constants.AZUL);
		juego.setColorJugador(1,Constants.AZUL);
	
	}
	
	@Test (expected = ColorYaExiste.class)
	public void testSetColorJugador2DebeTirarErrorSiEsIgualAl1() throws FueraDeMatriz, JugadorInvalido, ColorYaExiste, CompletarDatosException{
		Juego juego = new Juego();
		
		juego.setColorJugador(1,Constants.AZUL);
		juego.setColorJugador(2,Constants.AZUL);
	
	}
	

}
