package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.CostoDeRecursos;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.stats.RangoDeAtaque;

public class Espectro extends UnidadAerea {

	private static final String NAME = "ESPECTRO";
	private static final Integer MINERAL_COST = 150;
	private static final Integer GAS_COST = 100;
	private static final Integer CONSTRUCTION_TIME = 8;
	private static final Integer MAX_HEALTH = 120;
	private static final Integer MAX_SHIELD = 0;
	private static final Integer LAND_RANGE = 5;
	private static final Integer AIR_RANGE = 5;
	private static final Integer LAND_DMG = 8;
	private static final Integer AIR_DMG = 20;
	private static final Integer SUPPLY_COST = 2;
	private static final Integer VISION = 7;
	private static final Integer TRANSPORT = 0;
	private static final Integer RANGO_ATAQUE_TERRESTRE = 5;
	private static final Integer RANGO_ATAQUE_AEREO = 5;
	
	public Espectro(Posicion pos) throws FueraDeMatriz{
		
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST,pos);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		CostoDeRecursos costoDeRecursos = new CostoDeRecursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
	}
}
