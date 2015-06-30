package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.CostoDeRecursos;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;

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
	
	public Scout(Posicion pos){
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST,pos);
		CostoDeRecursos costoDeRecursos = new CostoDeRecursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO));
	}
}
