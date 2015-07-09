package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.excepciones.CapacidadInsuficiente;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.NaveVacia;
import fiuba.algo3.modelo.excepciones.UnidadAereaNoSePuedeCargar;
import fiuba.algo3.modelo.juego.Mapa;

public interface Cargable {

	public void cargarUnidad(Unidad unidad) throws CapacidadInsuficiente, UnidadAereaNoSePuedeCargar;

	public void descargarUnidades(Mapa mapa) throws CeldaOcupada, NaveVacia;
	
}
