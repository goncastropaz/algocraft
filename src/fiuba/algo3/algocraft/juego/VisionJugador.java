package fiuba.algo3.algocraft.juego;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class VisionJugador {
	
	private int mat[][];
	private Posicion baseInicial;
	private int tamanio;
	
	public VisionJugador(Posicion baseInicial) throws FueraDeMatriz{
		this.tamanio = Mapa.getInstance().getTamanio();
		mat = new int[tamanio][tamanio];
		for(int f=0;f<tamanio;f++){
			for(int c=0;c<tamanio;c++){
				mat[f][c] = 0; //0 significa que no esta descubierto todavia y 1 en caso contrario.
			};
		};
		this.baseInicial = baseInicial;
		this.setRadioDeVision(baseInicial,5);
	}
	
	public void descubrirCeldas(Posicion pos){
		mat[pos.getFila()][pos.getColumna()] = 1;
	}
	
	public boolean estaDescubierto(Posicion pos){
		return (mat[pos.getFila()][pos.getColumna()] == 1);
	}
	
	public void setRadioDeVision(Posicion pos,int radio) throws FueraDeMatriz{
		int filaInicial=0;
		int filaFinal =tamanio-1;
		int colInicial =0;
		int colFinal =tamanio-1;
		if (!((pos.getFila() -radio) < 0)) filaInicial = (pos.getFila()-radio);
		if (!((pos.getFila() +radio)>(tamanio-1))) filaFinal = (pos.getFila() +radio);
		if(!((pos.getColumna() -radio) <0)) colInicial = (pos.getColumna() -radio);
		if(!((pos.getColumna() + radio) >(tamanio-1))) colFinal = (pos.getColumna() +radio);
		for(int fil = filaInicial; fil< filaFinal+1;fil++){
			for(int col = colInicial;col< colFinal+1;col++){
				descubrirCeldas(new Posicion(fil,col));
			}
		}
	}
	public int getTamanio(){
		return this.tamanio;
	}
}