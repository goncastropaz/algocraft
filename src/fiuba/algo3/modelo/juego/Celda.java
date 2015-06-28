package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
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
		if(!(this.mineral) && !(this.gas) && (this.edificio ==null)){
			this.unidad = raceUnit;
		}else{
			throw new CeldaOcupada();
		}
	}

	public void removeUnidad() {
		// TODO Auto-generated method stub
		this.unidad = null;
	}

	public Unidad getUnidad() {
		// TODO Auto-generated method stub
		return this.unidad;
	}

	public boolean isEspacial() {
		
		return this.espacial;
	}

	public void setAsEspacial() {
		this.espacial =true;
	}
	
	public void setConstruccion(Construccion unaConstruccion) throws CeldaOcupada, CeldaSinRecurso{
		if((unaConstruccion.esProductorMineral() && !this.mineral)||(unaConstruccion.esProductorGas() && !this.gas)) throw new CeldaSinRecurso();
		
		if(this.unidad ==null ){
			this.edificio = unaConstruccion;
		}else{
			throw new CeldaOcupada();
		}
	}


	public void removerConstruccion() {
		this.edificio = null;		
	}
	
	public Construccion getConstruccion(){
		return this.edificio;
	}

	
}
