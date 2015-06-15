package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class Golliat extends UnidadTerrestre{

	private static final String NAME = "GOLLIAT";
	private static final Integer MINERAL_COST = 100;
	private static final Integer GAS_COST = 50;
	private static final Integer CONSTRUCTION_TIME = 6;
	private static final Integer MAX_HEALTH = 125;
	private static final Integer MAX_SHIELD = 0;
	private static final Integer LAND_RANGE = 6;
	private static final Integer AIR_RANGE = 5;
	private static final Integer LAND_DMG = 12;
	private static final Integer AIR_DMG = 10;
	private static final Integer SUPPLY_COST = 2;
	private static final Integer VISION = 8;
	private static final Integer TRANSPORT = 2;
	
	public Golliat(Posicion pos) throws FueraDeMatriz{
		
		super(NAME,MINERAL_COST,GAS_COST,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,pos);
		
	}
	
}
