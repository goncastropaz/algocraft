package fiuba.algo3.modelo.unidades;

import java.util.List;

import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.construcciones.Construccion;

public class Scout extends UnidadAerea {

	private static final String NAME = "SCOUT";
	private static final Integer MINERAL_COST = 300;
	private static final Integer GAS_COST = 150;
	private static final Integer CONSTRUCTION_TIME = 9;
	private static final Integer MAX_HEALTH = 150;
	private static final Integer MAX_SHIELD = 100;
	private static final Integer LAND_RANGE = 4;
	private static final Integer AIR_RANGE = 4;
	private static final Integer LAND_DMG = 8;
	private static final Integer AIR_DMG = 14;
	private static final Integer SUPPLY_COST = 3;
	private static final Integer VISION = 7;
	private static final Integer TRANSPORT = 0;
	private static final Integer RANGO_ATAQUE_TERRESTRE = 4;
	private static final Integer RANGO_ATAQUE_AEREO = 4;
	
	public Scout(){
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST);
		Recursos costoDeRecursos = new Recursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO));
	}
	
	@Override
	public Unidad generarCopia() {
		Unidad copia = new Scout();
		copia.setCopia();
		return copia;
	}

	@Override
	public boolean tieneEdificiosPrevios(List<Construccion> construccionesList) {
		return tieneConstruccion(construccionesList, "PUERTO_ESTELAR_PROTOSS");
	}
	
	@Override
	public boolean tieneMagia(String magia){
		return false;
	}
	
}
