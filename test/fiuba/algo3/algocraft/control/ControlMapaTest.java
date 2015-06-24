package fiuba.algo3.algocraft.control;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JFrame;

import org.junit.Test;

import fiuba.algo3.algocraft.acciones.Ejecutable;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearBarraca;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaMapa;

public class ControlMapaTest {
	
	
	@Test
	public void testAccionCrearBarraca() throws FueraDeMatriz{
//		try {
//			ControlJuego controlJuego = new ControlJuego();
//			controlJuego.getTurno().getActualCelda();
//		} catch (JugadorInvalido e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		Juego juegoPrincipal = Juego.getInstance();
		Juego juegoSecundario = Juego.getInstance();
		
		 assertEquals(juegoPrincipal,juegoSecundario);	
		
	}
	

}
