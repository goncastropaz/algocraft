package fiuba.algo3.classes.game;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;

public class Celda {


	private int tipo = 0; // tierra = 0
	private Posicion posicion;
	private boolean mineral;
	private boolean gas;
	
	public Celda(int fila, int columna) throws FueraDeMatriz{
		Posicion pos = new Posicion (fila,columna);
		this.posicion = pos;
		this.mineral=false;
		this.gas = false;
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

	
}
