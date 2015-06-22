package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.CostoDeRecursos;
import fiuba.algo3.classes.stats.Escudo;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.stats.RangoDeAtaque;
import fiuba.algo3.classes.stats.TiempoDeConstruccion;
import fiuba.algo3.classes.stats.Vida;

public class Zealot extends UnidadTerrestre {

	private static final String NAME = "ZEALOT";
	private static final Integer MINERAL_COST = 100;
	private static final Integer GAS_COST = 0;
	private static final Integer CONSTRUCTION_TIME = 4;
	private static final Integer MAX_HEALTH = 100;
	private static final Integer MAX_SHIELD = 60;
	private static final Integer LAND_RANGE = 1;
	private static final Integer AIR_RANGE = 0;
	private static final Integer LAND_DMG = 8;
	private static final Integer AIR_DMG = 0;
	private static final Integer SUPPLY_COST = 2;
	private static final Integer VISION = 7;
	private static final Integer TRANSPORT = 2;
	private static final Integer RANGO_ATAQUE_TERRESTRE = 1;
	private static final Integer RANGO_ATAQUE_AEREO = 1;
	
	public Zealot(Posicion pos) throws FueraDeMatriz{
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST,pos);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		CostoDeRecursos costoDeRecursos = new CostoDeRecursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
	}
	
}
