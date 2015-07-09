package fiuba.algo3.modelo.unidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import fiuba.algo3.modelo.complementos.Capacidad;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.CapacidadInsuficiente;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.NaveVacia;
import fiuba.algo3.modelo.excepciones.UnidadAereaNoSePuedeCargar;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Mapa;

public class NaveTransporteProtoss extends UnidadAerea implements Cargable{

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
	private static final Integer MAX_CAPACIDAD = 8;
	private static final Integer RANGO_ATAQUE_TERRESTRE = 0;
	private static final Integer RANGO_ATAQUE_AEREO = 0;
	private Capacidad capacidad;
	private List<Unidad> unidadesCargadas;
	
	public NaveTransporteProtoss() {
		
		super(NAME,CONSTRUCTION_TIME,MAX_HEALTH,MAX_SHIELD,VISION,SUPPLY_COST,TRANSPORT);
		Recursos costoDeRecursos = new Recursos(MINERAL_COST,GAS_COST);
		this.setCostoDeRecursos(costoDeRecursos);
		this.setRangoDeAtaque(new RangoDeAtaque(RANGO_ATAQUE_TERRESTRE,RANGO_ATAQUE_AEREO));
		this.capacidad = new Capacidad(MAX_CAPACIDAD);
		this.unidadesCargadas = new ArrayList<Unidad>();
	}
	
	public Capacidad getCapacidad() {
		return capacidad;
	}

	@Override
	public Unidad generarCopia() {
		Unidad copia = new NaveTransporteProtoss();
		copia.setCopia();
		return copia;
	}

	@Override
	public boolean tieneEdificiosPrevios(List<Construccion> construccionesList) {
		return tieneConstruccion(construccionesList, "PUERTO_ESTELAR_PROTOSS");
	}
	
	@Override
	public boolean tieneMagia(String magia){
		return false;
	}
	
	public boolean puedeTransportar(){
		return true;
	}

	@Override
	public void cargarUnidad(Unidad unidad) throws CapacidadInsuficiente, UnidadAereaNoSePuedeCargar {
		if(unidad.vuela()) throw new UnidadAereaNoSePuedeCargar();
		if(!this.capacidad.tieneCapacidad(unidad.getTransporte())) throw new CapacidadInsuficiente();
		this.capacidad.sacarCapacidad(unidad.getTransporte());
		this.unidadesCargadas.add(unidad);
	}
	
	@Override
	public void descargarUnidades(Mapa mapa) throws CeldaOcupada, NaveVacia {
		if(unidadesCargadas.isEmpty()) throw new NaveVacia();
		Iterator<Celda> iterator = mapa.devolverCeldasRadio(this.getUbicacion(),this.VISION).iterator();
		boolean descargoUnidad = false;
		while(!unidadesCargadas.isEmpty() && iterator.hasNext()){
			Celda celda = iterator.next();
			if(!celda.isEspacial() && celda.desocupada()){
				Unidad unidad = unidadesCargadas.get(0);
				celda.setUnidad(unidad);
				this.capacidad.agregarCapacidad(unidad.getTransporte());
				unidadesCargadas.remove(unidad);
				descargoUnidad = true;
			}
		}
		if(!descargoUnidad) throw new CeldaOcupada();
	}
	
}
