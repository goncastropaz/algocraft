package fiuba.algo3.algocraft.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.magias.Magia;
import fiuba.algo3.classes.stats.Posicion;

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
	
	private int energia;
	private ArrayList<Magia> magias;
	
	public NaveCiencia(Posicion pos) throws FueraDeMatriz{
		
		super(NAME,MINERAL_COST,GAS_COST,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,pos);
		this.energia = INITIAL_ENERGY;
		
		this.magias = new ArrayList<Magia>();
		this.magias.add(new EMP());
		this.magias.add(new Radiacion());
		
	}
	
	public void actualizarTurno(Jugador jugador){
		this.energia = this.energia + RECHARGED_ENERGY;
		if (this.energia> MAX_ENERGY) this.energia = MAX_ENERGY;
	}
}
