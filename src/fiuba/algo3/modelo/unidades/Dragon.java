package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.CostoDeRecursos;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;

public class Dragon extends UnidadTerrestre {

	private static final String NAME = "DRAGON";
	private static final Integer MINERAL_COST = 125;
	private static final Integer GAS_COST = 50;
	private static final Integer CONSTRUCTION_TIME = 6;
	private static final Integer MAX_HEALTH = 100;
	private static final Integer MAX_SHIELD = 80;
	private static final Integer LAND_RANGE = 4;
	private static final Integer AIR_RANGE = 4;
	private static final Integer LAND_DMG = 20;
	private static final Integer AIR_DMG = 20;
	private static final Integer SUPPLY_COST = 2;
	private static final Integer VISION = 8;
	private static final Integer TRANSPORT = 2;
	private static final Integer RANGO_ATAQUE_TERRESTRE = 4;
	private static final Integer RANGO_ATAQUE_AEREO = 4;
	
	public Dragon(){
		
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		CostoDeRecursos costoDeRecursos = new CostoDeRecursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
	}
}
