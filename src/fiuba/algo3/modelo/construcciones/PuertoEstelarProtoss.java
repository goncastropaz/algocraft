package fiuba.algo3.modelo.construcciones;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.unidades.Unidad;

public class PuertoEstelarProtoss extends Construccion {

	private static final String  NOMBRE = "PUERTO_ESTELAR_PROTOSS";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 150;
	private static final Integer TIEMPO_CONSTRUCCION = 10;
	private static final Integer MAX_VIDA = 600;
	private static final Integer ESCUDO = 600;
	private ArrayList<String> unidadesHabilitadas;
		
	public PuertoEstelarProtoss(Posicion pos){
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, pos);

		this.unidadesHabilitadas = new ArrayList<String>();
		this.unidadesHabilitadas.add("SCOUT");
		this.unidadesHabilitadas.add("NAVE_TRANSPORTE_PROTOSS");
		
	}
	
	@Override
	public boolean tieneEdificiosPrevios(List<Construccion> construcciones) {
		return tieneConstruccion(construcciones, "ACCESO");
	}
	
	
	public boolean puedeCrearUnidad(Unidad unidad) {
		if(this.unidadesHabilitadas.contains(unidad.getNombre())&& this.terminado()) return true;
		return false;
		
	}
	
}
