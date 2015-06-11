package fiuba.algo3.classes.builders.buildings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.classes.buildings.Acceso;
import fiuba.algo3.classes.buildings.ArchivoTemplario;
import fiuba.algo3.classes.buildings.Asimilador;
import fiuba.algo3.classes.buildings.NexoMineral;
import fiuba.algo3.classes.buildings.Pilon;
import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class ConstruccionesProtossTest {

	@Test
	public void testCrearNexoMineral() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Posicion posicion = new Posicion(fila, columna);
		
		NexoMineral unNexo = new NexoMineral(posicion);
		Integer cost = 50;
		
		assertNotNull(unNexo);
		assertEquals(unNexo.getCost().getCostoMineral(), cost);
	}

	@Test
	public void testCrearPilon() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Posicion posicion = new Posicion(fila, columna);
		
		Pilon unPilon = new Pilon(posicion);
		Integer escudo = 300;
		
		assertNotNull(unPilon);
		assertEquals(unPilon.getShield().getEscudoTotal(), escudo);
	}
	
	@Test
	public void testCrearAsimilador() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Posicion posicion = new Posicion(fila, columna);
		
		Asimilador unAsimilador = new Asimilador(posicion);
		Integer tiempoConstruccion = 6;
		
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
