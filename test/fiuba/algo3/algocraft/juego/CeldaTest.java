package fiuba.algo3.algocraft.juego;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Barraca;
import fiuba.algo3.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.construcciones.Refineria;
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
		Unidad marine = new Marine();
		unaCelda.setUnidad(marine);
		Construccion barraca = new Barraca(pos);
		unaCelda.setConstruccion(barraca);
	}

	@Test(expected = CeldaOcupada.class)
	public void testAgregarUnidadSiHayUnaConstruccionDeberiaLanzarError()
			throws CeldaOcupada, FueraDeMatriz, JugadorInvalido,
			CeldaSinRecurso, CeldaEspacial {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
		Construccion barraca = new Barraca(pos);
		unaCelda.setConstruccion(barraca);

		Unidad marine = new Marine();
		unaCelda.setUnidad(marine);

	}
	@Test(expected = CeldaOcupada.class)
	public void testAgregarUnidadSiHayMineralDeberiaLanzarError()
			throws CeldaOcupada, FueraDeMatriz, CeldaSinRecurso, CeldaEspacial {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
		unaCelda.setMineral();

		Unidad marine = new Marine();
		unaCelda.setUnidad(marine);

	}
	
	@Test(expected = CeldaOcupada.class)
	public void testAgregarUnidadSiHayGasDeberiaLanzarError()
			throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, FueraDeMatriz {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
		unaCelda.setGas();

		Unidad marine = new Marine();
		unaCelda.setUnidad(marine);

	}
	@Test(expected = CeldaOcupada.class)
	public void testAgregarConstruccionSiHayUnaConstruccionDeberiaLanzarError() throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, FueraDeMatriz {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
		Construccion barraca = new Barraca(pos);
		unaCelda.setConstruccion(barraca);
	
		Construccion barraca2 = new Barraca(pos);
		unaCelda.setConstruccion(barraca2);

	}
	@Test(expected = CeldaOcupada.class)
	public void testAgregarConstruccionSiHayUnaUnidadDeberiaLanzarError() throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, FueraDeMatriz {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
		Unidad marine = new Marine();
		unaCelda.setUnidad(marine);
	
		Construccion barraca = new Barraca(pos);
		unaCelda.setConstruccion(barraca);

	}
	
	@Test(expected = CeldaEspacial.class)
	public void testAgregarConstruccionEnCeldaEspacialDeberiaLanzarError() throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, FueraDeMatriz {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
		unaCelda.setAsEspacial();
	
		Construccion barraca = new Barraca(pos);
		unaCelda.setConstruccion(barraca);

	}
	@Test(expected = CeldaSinRecurso.class)
	public void testAgregarCentroDeMineralEnCeldaSinMineralDeberiaLanzarError() throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, FueraDeMatriz {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
			
		Construccion centroMineral = new CentroDeMineral(pos);
		unaCelda.setConstruccion(centroMineral);

	}
	@Test(expected = CeldaSinRecurso.class)
	public void testAgregarRecolectoDeGasEnCeldaSinGasDeberiaLanzarError() throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, FueraDeMatriz {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
			
		Construccion refineria = new Refineria(pos);
		unaCelda.setConstruccion(refineria);

	}
	@Ignore
	@Test
	public void testAgregarRecolectoDeGasEnCeldaConGasDeberiaDejarAgregar() throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, FueraDeMatriz {
		Posicion pos = new Posicion(2, 1);
		Celda unaCelda = new Celda(pos);
			
		Construccion refineria = new Refineria(pos);
		unaCelda.setConstruccion(refineria);

	}
}
