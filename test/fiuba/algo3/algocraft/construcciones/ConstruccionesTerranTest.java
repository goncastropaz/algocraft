package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.algocraft.construcciones.Barraca;
import fiuba.algo3.algocraft.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.construcciones.DepositoSuministro;
import fiuba.algo3.algocraft.construcciones.Fabrica;
import fiuba.algo3.algocraft.construcciones.Refineria;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.classes.stats.Posicion;

public class ConstruccionesTerranTest {
	@Test
	public void testCrearCentroMineral() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Integer fila = 1;
		Integer columna = 1;
		Integer max_vida = 500;

		Posicion posicion = new Posicion(fila, columna);		
		CentroDeMineral unCentroMineral = new CentroDeMineral(posicion);
		
		assertNotNull(unCentroMineral);
		assertEquals(unCentroMineral.getHealth().getVidaMaxima(), max_vida);
	}
	
	@Test
	public void testCrearBarraca() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Integer fila = 1;
		Integer columna = 1;
		Integer costoMineral = 150;

		Posicion posicion = new Posicion(fila, columna);		
		Barraca unaBarraca = new Barraca(posicion);
		
		assertNotNull(unaBarraca);
		assertEquals(unaBarraca.getCost().getCostoMineral(), costoMineral);
	}
	
	@Test
	public void testCrearDepositoSuminitros() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Integer fila = 1;
		Integer columna = 1;
		Integer costoMineral = 100;

		Posicion posicion = new Posicion(fila, columna);		
		DepositoSuministro unaBarraca = new DepositoSuministro(posicion);
		
		assertNotNull(unaBarraca);
		assertEquals(unaBarraca.getCost().getCostoMineral(), costoMineral);
	}
	
	@Test
	public void testCrearRefineria() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Integer fila = 1;
		Integer columna = 1;
		Integer tiempoConstruccion = 6;

		Posicion posicion = new Posicion(fila, columna);		
		Refineria unaRefineria = new Refineria(posicion);
		
		assertNotNull(unaRefineria);
		assertEquals(unaRefineria.getConstructionTime().getTurnosMaximos(), tiempoConstruccion);
	}
	
	@Test
	public void testCrearFabrica() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		Integer fila = 1;
		Integer columna = 1;
		Integer costoGas = 100;

		Posicion posicion = new Posicion(fila, columna);		
		Fabrica unaFabrica = new Fabrica(posicion);
		
		assertNotNull(unaFabrica);
		assertEquals(unaFabrica.getCost().getCostoGas(), costoGas);
	}


}
