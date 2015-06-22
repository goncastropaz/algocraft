package fiuba.algo3.algocraft.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.magias.EMP;
import fiuba.algo3.algocraft.magias.Magia;
import fiuba.algo3.algocraft.magias.Radiacion;
import fiuba.algo3.classes.stats.CostoDeRecursos;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.stats.RangoDeAtaque;

public class NaveCiencia extends UnidadAerea {

	private static final String NAME = "NAVE_CIENCIA";
	private static final Integer MINERAL_COST = 100;
	private static final Integer GAS_COST = 225;
	private static final Integer CONSTRUCTION_TIME = 10;
	private static final Integer MAX_HEALTH = 200;
	private static final Integer MAX_SHIELD = 0;
	private static final Integer LAND_RANGE = 0;
	private static final Integer AIR_RANGE = 0;
	private static final Integer LAND_DMG = 0;
	private static final Integer AIR_DMG = 0;
	private static final Integer SUPPLY_COST = 2;
	private static final Integer VISION = 10;
	private static final Integer TRANSPORT = 0;
	private static final Integer MAX_ENERGY = 200;
	private static final Integer INITIAL_ENERGY = 50;
	private static final Integer RECHARGED_ENERGY = 10;
	private static final Integer RANGO_ATAQUE_TERRESTRE = 0;
	private static final Integer RANGO_ATAQUE_AEREO = 0;
	
	private int energia;
	private ArrayList<Magia> magias;
	
	public NaveCiencia(Posicion pos) throws FueraDeMatriz{
		
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST,pos);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		CostoDeRecursos costoDeRecursos = new CostoDeRecursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
		this.energia = INITIAL_ENERGY;
		
		this.magias = new ArrayList<Magia>();
		this.magias.add(new EMP());
		this.magias.add(new Radiacion());
		
	}
	
	public void actualizarTurno(Jugador jugador){
		if(this.getTiempoDeConstruccion().getTurnosRestantes()==0){
			this.energia = this.energia + RECHARGED_ENERGY;
			if (this.energia> MAX_ENERGY) this.energia = MAX_ENERGY;
	
		}
		this.getTiempoDeConstruccion().actualizarTiempo();
	}
}	
