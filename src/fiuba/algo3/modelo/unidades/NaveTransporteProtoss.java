package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;

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
	private static final Integer RANGO_ATAQUE_TERRESTRE = 0;
	private static final Integer RANGO_ATAQUE_AEREO = 0;
	
	public NaveTransporteProtoss() {
		
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST);
		Recursos costoDeRecursos = new Recursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO));
	}
	
	@Override
	public Unidad generarCopia() {
		Unidad copia = new NaveTransporteProtoss();
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
