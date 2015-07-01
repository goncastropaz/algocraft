package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.CostoDeRecursos;
import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;

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
	
	public Golliat(){
		
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		CostoDeRecursos costoDeRecursos = new CostoDeRecursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
	}
	@Override
	public Unidad generarCopia() {
		Unidad copia = new Golliat();
		copia.setCopia();
		return copia;
	}
	@Override
	public void recibirAtaque(Danio danio) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void atacarUnidad(Unidad unidad) {
		// TODO Auto-generated method stub
		
	}
	
}
