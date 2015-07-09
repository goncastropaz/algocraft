package fiuba.algo3.modelo.unidades;

import java.util.List;

import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.construcciones.Construccion;

public class Zealot extends UnidadTerrestre {

	private static final String NAME = "ZEALOT";
	private static final Integer MINERAL_COST = 100;
	private static final Integer GAS_COST = 0;
	private static final Integer CONSTRUCTION_TIME = 4;
	private static final Integer MAX_HEALTH = 100;
	private static final Integer MAX_SHIELD = 60;
	private static final Integer LAND_DMG = 8;
	private static final Integer AIR_DMG = 0;
	private static final Integer SUPPLY_COST = 2;
	private static final Integer VISION = 7;
	private static final Integer TRANSPORT = 2;
	private static final Integer RANGO_ATAQUE_TERRESTRE = 1;
	private static final Integer RANGO_ATAQUE_AEREO = 0;
	
	public Zealot(){
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST,TRANSPORT);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		Recursos costoDeRecursos = new Recursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
		this.setDanio(new Danio(LAND_DMG, AIR_DMG));
	}

	public Unidad generarCopia() {
		Unidad copia = new Zealot();
		copia.setCopia();
		return copia;
	}

	@Override
	public boolean tieneEdificiosPrevios(List<Construccion> construccionesList) {
		return tieneConstruccion(construccionesList, "ACCESO");
	}
	
	@Override
	public boolean tieneMagia(String magia){
		return false;
	}
	
}
