package fiuba.algo3.algocraft.juego;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class VisionJugador {
	
	private int mat[][];
	
	public VisionJugador() throws FueraDeMatriz{
		int tamanio = Mapa.getInstance().getTamanio();
		mat = new int[tamanio][tamanio];
		for(int f=0;f<tamanio;f++){
			for(int c=0;c<tamanio;c++){
				mat[f][c] = 0; //0 significa que no esta descubierto todavia y 1 en caso contrario.
			};
		};
	}
	
	public void descubrirCeldas(Posicion pos){
		mat[pos.getFila()][pos.getColumna()] = 1;
	}
	
	public boolean estaDescubierto(Posicion pos){
		return (mat[pos.getFila()][pos.getColumna()] == 1);
	}
}
