package fiuba.algo3.modelo.construcciones;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.unidades.Unidad;

public class DepositoSuministro extends Construccion {

	private static final String  NOMBRE = "DEPOSITO_SUMINISTRO";
	private static final Integer COSTO_MINERAL = 100;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 6;
	private static final Integer MAX_VIDA = 500;
	private static final Integer ESCUDO = 0;
	private ArrayList<String> unidadesHabilitadas;
	
	
	public DepositoSuministro(Posicion pos) {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, pos);
		this.unidadesHabilitadas = new ArrayList<String>();
	}
	
	@Override
	public void actualizarPoblacion(Jugador jugador) {
		jugador.agregarPoblacion();
		
	}

	@Override
	public boolean tieneEdificiosPrevios(List<Construccion> construcciones) {
		return true;
	}
	
	public boolean puedeCrearUnidad(Unidad unidad) {
		if(this.unidadesHabilitadas.contains(unidad.getNombre())&& this.terminado()) return true;
		return false;
		
	}
	
}
