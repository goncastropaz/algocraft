package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.CostoDeRecursos;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.stats.RangoDeAtaque;

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
	private static final Integer RANGO_ATAQUE_TERRESTRE = 6;
	private static final Integer RANGO_ATAQUE_AEREO = 5;
	
	public Golliat(Posicion pos) throws FueraDeMatriz{
		
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST,pos);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		CostoDeRecursos costoDeRecursos = new CostoDeRecursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
	}
	
}
