package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.complementos.Recursos;

public class Marine extends UnidadTerrestre{

	private static final String NAME = "MARINE";
	private static final Integer MINERAL_COST = 50;
	private static final Integer GAS_COST = 0;
	private static final Integer CONSTRUCTION_TIME = 3;
	private static final Integer MAX_HEALTH = 40;
	private static final Integer MAX_SHIELD = 0;
	private static final Integer LAND_RANGE = 4;
	private static final Integer AIR_RANGE = 4;
	private static final Integer LAND_DMG = 6;
	private static final Integer AIR_DMG = 6;
	private static final Integer SUPPLY_COST = 1;
	private static final Integer VISION = 7;
	private static final Integer TRANSPORT = 1;
	private static final Integer RANGO_ATAQUE_TERRESTRE = 4;
	private static final Integer RANGO_ATAQUE_AEREO = 4;
	
	public Marine(){
		
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		Recursos costoDeRecursos = new Recursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
	}
	
	@Override
	public Unidad generarCopia() {
		Unidad copia = new Marine();
		copia.setCopia();
		return copia;
	}

}