package fiuba.algo3.modelo.unidades;

import java.util.ArrayList;

import fiuba.algo3.modelo.complementos.CostoDeRecursos;
import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.complementos.Vida;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CopiaNoCausaDanio;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.magias.Alucinacion;
import fiuba.algo3.modelo.magias.EMP;
import fiuba.algo3.modelo.magias.Magia;
import fiuba.algo3.modelo.magias.Radiacion;
import fiuba.algo3.modelo.magias.TormentaPsionica;

public class AltoTemplario extends UnidadTerrestre {

	private static final String NAME = "ALTO_TEMPLARIO";
	private static final Integer MINERAL_COST = 50;
	private static final Integer GAS_COST = 150;
	private static final Integer CONSTRUCTION_TIME = 7;
	private static final Integer MAX_HEALTH = 40;
	private static final Integer MAX_SHIELD = 40;
	private static final Integer LAND_RANGE = 0;
	private static final Integer AIR_RANGE = 0;
	private static final Integer LAND_DMG = 0;
	private static final Integer AIR_DMG = 0;
	private static final Integer SUPPLY_COST = 2;
	private static final Integer VISION = 7;
	private static final Integer TRANSPORT = 2;
	private static final Integer MAX_ENERGY = 200;
	private static final Integer INITIAL_ENERGY = 50;
	private static final Integer RECHARGED_ENERGY = 15;
	private static final Integer RANGO_ATAQUE_TERRESTRE = 0;
	private static final Integer RANGO_ATAQUE_AEREO = 0;
	

	private Energia energia;
	private ArrayList<TormentaPsionica> tormentasPsionicas;
	
	public AltoTemplario(){
		
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST);
		RangoDeAtaque rango = new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO);
		CostoDeRecursos costoDeRecursos = new CostoDeRecursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(rango);
		
		this.energia = new Energia(MAX_ENERGY,INITIAL_ENERGY);
		this.tormentasPsionicas = new ArrayList<TormentaPsionica>();
		
	}
	
	public void actualizarTurno(Jugador jugador){
		if(this.getTiempoDeConstruccion().getTurnosRestantes()==0){
			this.energia.recargarEnergia(RECHARGED_ENERGY);
			for(int tormenta = 0; tormenta< this.tormentasPsionicas.size();tormenta--){
				if(this.tormentasPsionicas.get(tormenta).getTurno() ==0 ){
					this.tormentasPsionicas.remove(tormenta);
				}
			}
			
		}
		this.getTiempoDeConstruccion().actualizarTiempo();
	}


	public void provocarTormentaPsionica(Posicion pos,Mapa mapa) throws EnergiaInsuficiente, CopiaNoCausaDanio{
		if(this.copia) throw new CopiaNoCausaDanio();
		TormentaPsionica tormenta = new TormentaPsionica(this.energia,pos, mapa);
		this.tormentasPsionicas.add(tormenta);
		tormenta.provocarTormenta();
	}
	
	public void provocarAlucinacion(Unidad unidadACopiar, Juego juego) throws EnergiaInsuficiente, CeldaOcupada, CeldaEspacial, CopiaNoCausaDanio{
		if(this.copia) throw new CopiaNoCausaDanio();
		Alucinacion alucinacion = new Alucinacion(this.energia);
		alucinacion.generarAlucinacion(unidadACopiar, juego);
	}

	@Override
	public Unidad generarCopia() {
		Unidad copia = new AltoTemplario();
		copia.setCopia();
		return copia;
	}
	
	public void ataqueEMP(){
		this.energia.setEnergiaActual(0);
		this.getEscudo().setEscudoActual(0);
	}
	
}
