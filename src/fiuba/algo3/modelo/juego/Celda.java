package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.unidades.Unidad;

public class Celda {


	private boolean espacial; // default = false
	private Posicion posicion;
	private boolean mineral;
	private boolean gas;
	private Unidad unidad;
	private Construccion edificio;
	
	public Celda(Posicion pos) {
		this.posicion = pos;
		this.mineral=false;
		this.gas = false;
		this.unidad = null;
		this.edificio = null;
		this.espacial = false;
	}
	
	public Posicion getPosicion(){
		return this.posicion;
	}

	public boolean tieneMineral() {
		return this.mineral;
	}

	public boolean tieneGas() {
		return this.gas;
	}
	
	public void setMineral(){
		this.mineral = true;
	}
	
	public void setGas(){
		this.gas = true;
	}

	public void setUnidad(Unidad raceUnit) throws CeldaOcupada {
	
		if(this.mineral || this.gas || this.edificio != null || this.unidad != null) throw new CeldaOcupada();
		
		this.unidad = raceUnit;
	}

	public void removeUnidad() {
		this.unidad = null;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	public boolean isEspacial() {
		
		return this.espacial;
	}

	public void setAsEspacial() {
		this.espacial =true;
	}
	
	public void setConstruccion(Construccion unaConstruccion) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial{
		if(this.espacial) throw new CeldaEspacial();
		
		if(this.edificio != null || this.unidad != null) throw new CeldaOcupada();
		
		if((unaConstruccion.esProductorMineral() && !this.mineral)||(unaConstruccion.esProductorGas() && !this.gas)) throw new CeldaSinRecurso();
		
		this.edificio = unaConstruccion;
		
	}


	public void removerConstruccion() {
		this.edificio = null;		
	}
	
	public Construccion getConstruccion(){
		return this.edificio;
	}

	public boolean tieneConstruccion() {
		if(this.edificio == null) return false;
		return true;
	}
	
	public boolean tieneUnidad(){
		return this.unidad != null;
	}

	public boolean desocupada() {
		if(this.mineral || this.gas || this.edificio != null || this.unidad != null) return false;
		return true;
	}

	
}
