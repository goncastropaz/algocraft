package fiuba.algo3.algocraft.juego;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ColorYaExiste;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.algocraft.excepciones.NombreYaExiste;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;

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
	public void testSetNombreJugadorDebeGuardarElNombreEnJugador() throws FueraDeMatriz, NombreYaExiste, NombreConMenosDe4Caracteres, JugadorInvalido{
		Juego juego = Juego.getInstance();
		Jugador jugador1 = juego.getJugador(1);
		juego.setNombreJugador(1,"Lucas");
		assertEquals("Lucas",jugador1.getNombre());
	}
	
	@Test
	public void testSetColorJugadorDebeGuardarElColorEnJugador() throws FueraDeMatriz, ColorYaExiste, JugadorInvalido{
		Juego juego = Juego.getInstance();
		Jugador jugador1 = juego.getJugador(1);
		juego.setColorJugador(1,"Rojo");
		assertEquals("Rojo",jugador1.getColor());
	}
	
	@Test (expected = NombreYaExiste.class)
	public void testSetNombreJugador2DebeTirarErrorSiEsIgualAl1() throws FueraDeMatriz, NombreYaExiste,NombreConMenosDe4Caracteres, JugadorInvalido{
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
