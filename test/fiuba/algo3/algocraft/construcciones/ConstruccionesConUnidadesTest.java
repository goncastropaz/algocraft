package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.unidades.IUnidad;
import fiuba.algo3.classes.stats.Posicion;

public class ConstruccionesConUnidadesTest {
	
	@Test
	public void testCrearBarracaConMarine() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer costoMineral = 50;

		Posicion posicion = new Posicion(fila, columna);
		Barraca unaBarraca = new Barraca(posicion);
		FabricaDeUnidades unaFabrica = new FabricaDeMarine(); 
		
		IUnidad unidad = unaBarraca.crearUnidad(unaFabrica);
		
		assertNotNull(unaBarraca);
		assertEquals(unidad.getCostoDeRecursos().getCostoMineral(), costoMineral);
		
	}
	
	@Test
	public void testCrearAccesoConZealot() throws FueraDeMatriz{
		Integer fila = 1;
		Integer columna = 1;
		Integer costoMineral = 100;

		Posicion posicion = new Posicion(fila, columna);
		Acceso unAcceso = new Acceso(posicion);
		FabricaDeUnidades unaFabrica = new FabricaDeZealot(); 
		
		IUnidad unidad = unAcceso.crearUnidad(unaFabrica);

		assertNotNull(unAcceso);
		assertEquals(unidad.getCostoDeRecursos().getCostoMineral(), costoMineral);
	}
	

}
