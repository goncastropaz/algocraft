package fiuba.algo3.algocraft.juego;

import fiuba.algo3.algocraft.construcciones.Construccion;
import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Posicion;

public class Celda {


	private boolean espacial; // default = false
	private Posicion posicion;
	private boolean mineral;
	private boolean gas;
	private Unidad unidad;
	private Construccion edificio;
	
	public Celda(int fila, int columna) throws FueraDeMatriz{
		Posicion pos = new Posicion (fila,columna);
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
		// TODO Auto-generated method stub
		return this.mineral;
	}

	public boolean tieneGas() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		this.espacial =true;
	}
	
	public void setConstruccion(Construccion unaConstruccion) throws CeldaOcupada{
		if(this.unidad ==null){
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
