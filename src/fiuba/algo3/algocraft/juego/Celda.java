package fiuba.algo3.algocraft.juego;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Posicion;

public class Celda {


	private boolean espacial; // default = false
	private Posicion posicion;
	private boolean mineral;
	private boolean gas;
	private Unidad unidad;
	
	public Celda(int fila, int columna) throws FueraDeMatriz{
		Posicion pos = new Posicion (fila,columna);
		this.posicion = pos;
		this.mineral=false;
		this.gas = false;
		this.unidad = null;
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

	public void setUnidad(Unidad raceUnit) {
		this.unidad = raceUnit;
		
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

	
}