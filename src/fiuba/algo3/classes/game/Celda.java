package fiuba.algo3.classes.game;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.units.RaceUnit;

public class Celda {


	private int tipo = 0; // tierra = 0
	private Posicion posicion;
	private boolean mineral;
	private boolean gas;
	private RaceUnit unidad;
	
	public Celda(int fila, int columna) throws FueraDeMatriz{
		Posicion pos = new Posicion (fila,columna);
		this.posicion = pos;
		this.mineral=false;
		this.gas = false;
		this.unidad = null;
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

	public void setUnidad(RaceUnit raceUnit) {
		this.unidad = raceUnit;
		
	}

	public void removeUnidad() {
		// TODO Auto-generated method stub
		this.unidad = null;
	}

	public RaceUnit getUnidad() {
		// TODO Auto-generated method stub
		return this.unidad;
	}

	
}
