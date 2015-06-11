package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.algocraft.construcciones.Acceso;
import fiuba.algo3.algocraft.construcciones.ArchivoTemplario;
import fiuba.algo3.algocraft.construcciones.Asimilador;
import fiuba.algo3.algocraft.construcciones.NexoMineral;
import fiuba.algo3.algocraft.construcciones.Pilon;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class ConstruccionesProtossTest {

	@Test
	public void testCrearNexoMineral() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer cost = 50;
		
		Posicion posicion = new Posicion(fila, columna);
		NexoMineral unNexo = new NexoMineral(posicion);
		
		assertNotNull(unNexo);
		assertEquals(unNexo.getCost().getCostoMineral(), cost);
	}

	@Test
	public void testCrearPilon() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer escudo = 300;
	
		Posicion posicion = new Posicion(fila, columna);
		Pilon unPilon = new Pilon(posicion);
		
		assertNotNull(unPilon);
		assertEquals(unPilon.getShield().getEscudoTotal(), escudo);
	}
	
	@Test
	public void testCrearAsimilador() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer tiempoConstruccion = 6;

		Posicion posicion = new Posicion(fila, columna);
		Asimilador unAsimilador = new Asimilador(posicion);
		
		assertNotNull(unAsimilador);
		assertEquals(unAsimilador.getConstructionTime().getTurnosMaximos(), tiempoConstruccion);
	}
	
	@Test
	public void testCrearAcceso() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer tiempoConstruccion = 8;

		Posicion posicion = new Posicion(fila, columna);
		Acceso unAcceso = new Acceso(posicion);
		
		assertNotNull(unAcceso);
		assertEquals(unAcceso.getConstructionTime().getTurnosMaximos(), tiempoConstruccion);
	}
	
	@Test
	public void testCrearArchivoTemplario() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer tiempoConstruccion = 9;

		Posicion posicion = new Posicion(fila, columna);
		ArchivoTemplario unAcceso = new ArchivoTemplario(posicion);
		
		assertNotNull(unAcceso);
		assertEquals(unAcceso.getConstructionTime().getTurnosMaximos(), tiempoConstruccion);
	}
	
	

}
