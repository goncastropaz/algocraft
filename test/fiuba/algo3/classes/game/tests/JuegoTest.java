package fiuba.algo3.classes.game.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.classes.exceptions.ColorYaExiste;
import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.exceptions.JugadorInvalido;
import fiuba.algo3.classes.exceptions.NombreConMenosDe4Caracteres;
import fiuba.algo3.classes.exceptions.NombreYaExiste;
import fiuba.algo3.classes.game.Juego;
import fiuba.algo3.classes.game.Jugador;

public class JuegoTest {

	@Test
	public void testCrearJuegoDeberiaDejarCrearUnaSolaInstancia() throws FueraDeMatriz{
		Juego juegoPrincipal = Juego.getInstance();
		Juego juegoSecundario = Juego.getInstance();
		
		 assertEquals(juegoPrincipal,juegoSecundario);	
	}
	
	
	@Test (expected = JugadorInvalido.class)
	public void testGetJugadorDebeTirarErrorSiSePideUnJugadorInvalido() throws FueraDeMatriz, JugadorInvalido{
		Juego juego = Juego.getInstance();
		Jugador jugador1 = juego.getJugador(3);
	}
	

	@Test
	public void testSetNombreJugadorDebeGuardarElNombreEnJugador() throws FueraDeMatriz, JugadorInvalido, NombreYaExiste, NombreConMenosDe4Caracteres{
		Juego juego = Juego.getInstance();
		Jugador jugador1 = juego.getJugador(1);
		juego.setNombreJugador(1,"Martin");
		assertEquals("Martin",jugador1.getNombre());
	}
	
	@Test
	public void testSetColorJugadorDebeGuardarElColorEnJugador() throws FueraDeMatriz, JugadorInvalido, ColorYaExiste{
		Juego juego = Juego.getInstance();
		Jugador jugador1 = juego.getJugador(1);
		juego.setColorJugador(1,"Rojo");
		assertEquals("Rojo",jugador1.getColor());
	}
	
	@Test (expected = NombreYaExiste.class)
	public void testSetNombreJugador2DebeTirarErrorSiEsIgualAl1() throws FueraDeMatriz, NombreYaExiste, JugadorInvalido, NombreConMenosDe4Caracteres{
		Juego juego = Juego.getInstance();
		
		juego.setNombreJugador(1,"Martin");
		juego.setNombreJugador(2,"Martin");
	
	}
	
	@Test (expected = NombreYaExiste.class)
	public void testSetNombreJugador1DebeTirarErrorSiEsIgualAl2() throws FueraDeMatriz, NombreYaExiste, JugadorInvalido, NombreConMenosDe4Caracteres{
		Juego juego = Juego.getInstance();
		
		juego.setNombreJugador(2,"Martin");
		juego.setNombreJugador(1,"Martin");
	
	}
	
	@Test (expected = ColorYaExiste.class)
	public void testSetColorJugador1DebeTirarErrorSiEsIgualAl2() throws FueraDeMatriz, JugadorInvalido, ColorYaExiste{
		Juego juego = Juego.getInstance();
		
		juego.setColorJugador(2,"Azul");
		juego.setColorJugador(1,"Azul");
	
	}
	
	@Test (expected = ColorYaExiste.class)
	public void testSetColorJugador2DebeTirarErrorSiEsIgualAl1() throws FueraDeMatriz, JugadorInvalido, ColorYaExiste{
		Juego juego = Juego.getInstance();
		
		juego.setColorJugador(1,"Azul");
		juego.setColorJugador(2,"Azul");
	
	}
}
