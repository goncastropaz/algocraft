package fiuba.algo3.classes.units;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class Marine extends RaceUnit{

	private static final String NAME = "MARINE";
	private static final Integer MINERAL_COST = 50;
	private static final Integer GAS_COST = 0;
	private static final Integer CONSTRUCTION_TIME = 3;
	private static final Integer MAX_HEALTH = 40;
	private static final Integer MAX_SHIELD = 0;
	private static final Integer RANGE = 4;
	private static final Integer LAND_DMG = 6;
	private static final Integer AIR_DMG = 6;
	private static final Integer SUPPLY_COST = 1;
	private static final Integer VISION = 7;
	private static final Integer TRANSPORT = 1;
	
	public Marine(Posicion pos) throws FueraDeMatriz{
		
		super(NAME,MINERAL_COST,GAS_COST,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,pos);
		
	}
}
