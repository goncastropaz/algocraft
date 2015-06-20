package fiuba.algo3.classes.stats;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;

public class Posicion {

	private int columna;
	private int fila;
	
	public Posicion(int fil, int col) throws FueraDeMatriz{
		columna = col;
		fila = fil;
		if(columna>99 || fila > 99 || columna<0 || fila <0)	throw new FueraDeMatriz();
			
	}
	public int getColumna(){
		return columna;
	}
	public int getFila(){
		return fila;
	}

	
	
}