package fiuba.algo3.algocraft.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Barraca;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.unidades.Marine;
import fiuba.algo3.modelo.unidades.Unidad;

public class CeldaTest {

	@Test
	public void testCrearCeldaDebeGuardarLaPosicion() throws FueraDeMatriz {

		Celda unaCelda = new Celda(new Posicion(2, 1));
		int fil = unaCelda.getPosicion().getFila();
		int col = unaCelda.getPosicion().getColumna();

		assertEquals(2, fil);
		assertEquals(1, col);
	}

	@Test
	public void testGetPosicionDebeDevolverLaPosicionDeLaCelda()
			throws FueraDeMatriz {

		Celda unaCelda = new Celda(new Posicion(2, 1));
		Posicion pos = unaCelda.getPosicion();

		assertEquals(2, pos.getFila());
		assertEquals(1, pos.getColumna());
	}

	@Test(expected = CeldaOcupada.class)
	public void testAgregarContruccionSiHayUnaUnidadDeberiaLanzarError()
			throws CeldaOcupada, CeldaSinRecurso, FueraDeMatriz, CeldaEspacial {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
		Unidad marine = new Marine(pos);
		unaCelda.setUnidad(marine);
		Construccion barraca = new Barraca();
		unaCelda.setConstruccion(barraca);
	}

	@Test(expected = CeldaOcupada.class)
	public void testAgregarUnidadSiHayUnaConstruccionDeberiaLanzarError()
			throws CeldaOcupada, FueraDeMatriz, JugadorInvalido,
			CeldaSinRecurso, CeldaEspacial {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
		Construccion barraca = new Barraca();
		unaCelda.setConstruccion(barraca);

		Unidad marine = new Marine(pos);
		unaCelda.setUnidad(marine);

	}

}
