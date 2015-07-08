package fiuba.algo3.modelo.construcciones;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.unidades.Unidad;

public class NexoMineral extends Construccion {

	private static final String  NOMBRE = "NEXO_MINERAL";
	private static final Integer COSTO_MINERAL = 50;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 4;
	private static final Integer MAX_VIDA = 250;
	private static final Integer ESCUDO = 250;
	private ArrayList<String> unidadesHabilitadas;

	public NexoMineral(Posicion pos) {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, pos);
		
		this.unidadesHabilitadas = new ArrayList<String>();
	}
	
	public void actualizarTurno(Jugador jugador){
		if(this.getConstructionTime().getTurnosRestantes()==0)	jugador.actualizarMineral();
		this.getConstructionTime().actualizarTiempo();
	}

	public boolean esProductorMineral() {
		return true;
	}

	@Override
	public boolean tieneEdificiosPrevios(List<Construccion> construcciones) {
		return true;
	}
	
	public boolean puedeCrearUnidad(Unidad unidad) {
		if(this.unidadesHabilitadas.contains(unidad.getNombre())) return true;
		return false;
		
	}
	
}
