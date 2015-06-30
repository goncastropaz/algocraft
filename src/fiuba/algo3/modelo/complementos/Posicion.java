package fiuba.algo3.modelo.complementos;

import fiuba.algo3.modelo.excepciones.FueraDeMatriz;

public class Posicion {

	private int columna;
	private int fila;
	
	public Posicion(int fil, int col) throws FueraDeMatriz{
		columna = col;
		fila = fil;
		if(columna>49 || fila > 49 || columna<0 || fila <0)	throw new FueraDeMatriz();
			
	}
	public int getColumna(){
		return columna;
	}
	public int getFila(){
		return fila;
	}

	public Posicion getPosicionArriba() throws FueraDeMatriz{
		return new Posicion(this.fila+1,this.columna);
	}
	public Posicion getPosicionAbajo() throws FueraDeMatriz{
		return new Posicion(this.fila-1,this.columna);
	}
	public Posicion getPosicionDerecha() throws FueraDeMatriz{
		return new Posicion(this.fila,this.columna+1);
	}
	public Posicion getPosicionIzquierda() throws FueraDeMatriz{
		return new Posicion(this.fila,this.columna-1);
	}
	
	
}