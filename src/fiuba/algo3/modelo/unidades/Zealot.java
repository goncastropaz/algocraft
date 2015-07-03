package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Escudo;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.complementos.TiempoDeConstruccion;
import fiuba.algo3.modelo.complementos.Vida;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;

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
	
	public Zealot(){
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		Recursos costoDeRecursos = new Recursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
	}

	public Unidad generarCopia() {
		Unidad copia = new Zealot();
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
