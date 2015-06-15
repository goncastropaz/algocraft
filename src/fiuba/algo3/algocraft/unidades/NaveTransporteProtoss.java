package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class NaveTransporteProtoss extends UnidadAerea {

	private static final String NAME = "NAVE_TRANSPORTE_PROTOSS";
	private static final Integer MINERAL_COST = 200;
	private static final Integer GAS_COST = 0;
	private static final Integer CONSTRUCTION_TIME = 8;
	private static final Integer MAX_HEALTH = 80;
	private static final Integer MAX_SHIELD = 60;
	private static final Integer LAND_RANGE = 0;
	private static final Integer AIR_RANGE = 0;
	private static final Integer LAND_DMG = 0;
	private static final Integer AIR_DMG = 0;
	private static final Integer SUPPLY_COST = 2;
	private static final Integer VISION = 8;
	private static final Integer TRANSPORT = 0;
	private static final Integer CAPACIDAD = 8;
	
	public NaveTransporteProtoss(Posicion pos) throws FueraDeMatriz{
		
		super(NAME,MINERAL_COST,GAS_COST,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,pos);
		
	}
}
