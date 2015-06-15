package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

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
	private static final Integer VISION = 7;
	private static final Integer TRANSPORT = 2;
	
	public Dragon(Posicion pos) throws FueraDeMatriz{
		
		super(NAME,MINERAL_COST,GAS_COST,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,pos);
		
	}
}
