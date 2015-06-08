package fiuba.algo3.classes.units;

public class Zealot extends RaceUnit {

	private static final String NAME = "ZEALOT";
	private static final Integer MINERAL_COST = 100;
	private static final Integer GAS_COST = 0;
	private static final Integer CONSTRUCTION_TIME = 4;
	private static final Integer MAX_HEALTH = 100;
	private static final Integer MAX_SHIELD = 60;
	private static final Integer RANGE = 1;
	private static final Integer LAND_DMG = 8;
	private static final Integer AIR_DMG = 0;
	private static final Integer SUPPLY_COST = 2;
	private static final Integer VISION = 7;
	private static final Integer TRANSPORT = 2;
	
	public Zealot(Integer coordinateX, Integer coordinateY){
		
		super(NAME,MINERAL_COST,GAS_COST,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,coordinateX,coordinateY);
		
	}
	
}
