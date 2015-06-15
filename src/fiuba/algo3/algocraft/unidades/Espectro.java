package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class Espectro extends UnidadAerea {

	private static final String NAME = "ESPECTRO";
	private static final Integer MINERAL_COST = 150;
	private static final Integer GAS_COST = 120;
	private static final Integer CONSTRUCTION_TIME = 8;
	private static final Integer MAX_HEALTH = 125;
	private static final Integer MAX_SHIELD = 0;
	private static final Integer LAND_RANGE = 5;
	private static final Integer AIR_RANGE = 5;
	private static final Integer LAND_DMG = 8;
	private static final Integer AIR_DMG = 20;
	private static final Integer SUPPLY_COST = 2;
	private static final Integer VISION = 7;
	private static final Integer TRANSPORT = 0;
	
	public Espectro(Posicion pos) throws FueraDeMatriz{
		
		super(NAME,MINERAL_COST,GAS_COST,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,pos);
		
	}
}
