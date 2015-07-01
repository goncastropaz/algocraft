package fiuba.algo3.modelo.unidades;

import java.util.ArrayList;

import fiuba.algo3.modelo.complementos.CostoDeRecursos;
import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.magias.EMP;
import fiuba.algo3.modelo.magias.Magia;
import fiuba.algo3.modelo.magias.Radiacion;

public class NaveCiencia extends UnidadAerea{

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
	
	private Energia energia;
	
	public NaveCiencia() {
		
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		CostoDeRecursos costoDeRecursos = new CostoDeRecursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
		this.energia = new Energia(MAX_ENERGY,INITIAL_ENERGY);

	}
	
	public void actualizarTurno(Jugador jugador){
		if(this.getTiempoDeConstruccion().getTurnosRestantes()==0){
			this.energia.recargarEnergia(RECHARGED_ENERGY);

		}
		this.getTiempoDeConstruccion().actualizarTiempo();
	}

	
	public void generarEMP(Posicion pos,Mapa mapa) throws EnergiaInsuficiente{
		EMP magiaEMP = new EMP(this.energia);
		magiaEMP.tirarMagia(pos, mapa);
	}
	
	public void generarRadiacion(Posicion pos,Mapa mapa) throws EnergiaInsuficiente{
		Radiacion magiaRadiacion = new Radiacion(this.energia);
		magiaRadiacion.emitirRadiacion(pos, mapa);
	}
	
	@Override
	public Unidad generarCopia() {
		Unidad copia = new NaveCiencia();
		copia.setCopia();
		return copia;
	}

	public void ataqueEMP(){
		this.energia.setEnergiaActual(0);
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
