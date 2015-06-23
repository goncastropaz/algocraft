package fiuba.algo3.algocraft.juego;

import java.util.ArrayList;
import java.util.HashMap;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class Mapa {

			
			private static Mapa INSTANCE = null;
			private Celda[][] matriz;
			private static int tamanio =50;
			private static int baseSuperior =4;
			private static int baseInferior = 45;
			private static HashMap<Integer,Posicion> baseJugadores;
	
						
			private Mapa() throws FueraDeMatriz{
				
				Celda mat[][] = new Celda[tamanio][tamanio];
				for(int f=0;f<tamanio;f++){
					for(int c=0;c<tamanio;c++){
						Celda unaCelda = new Celda(f,c);
						mat[f][c] = unaCelda;
					};
				};
				
				matriz= mat;
				baseJugadores = new HashMap<Integer,Posicion>();
				baseJugadores.put(1, new Posicion(baseSuperior,baseSuperior));
				baseJugadores.put(2, new Posicion(baseInferior,baseInferior));
				this.setRecursosEnMapa();
				this.setAreasEspaciales();
							
			}
			
			private synchronized static void createInstance() throws FueraDeMatriz {
				if (INSTANCE == null) { 
			       INSTANCE = new Mapa();
			    }
			}
			
			private void setRecursosEnMapa(){
				matriz[baseSuperior][baseSuperior].setMineral();
				matriz[baseSuperior][baseSuperior+1].setMineral();
				matriz[baseSuperior+1][baseSuperior].setMineral();
				matriz[baseSuperior+1][baseSuperior+1].setGas();
				matriz[baseInferior][baseInferior].setMineral();
				matriz[baseInferior][baseInferior+1].setMineral();
				matriz[baseInferior+1][baseInferior].setMineral();
				matriz[baseInferior+1][baseInferior+1].setGas();
			}
			
			private void setAreasEspaciales(){
				for(int fil=1; fil<41; fil++){
					for(int col= 18; col<31; col++){
						matriz[fil][col].setAsEspacial();
					}
				}
				
			}
			
			public static Mapa getInstance() throws FueraDeMatriz {
			    if (INSTANCE == null) 
			    	createInstance();
			    return INSTANCE;
			}
			
					
			public Celda devolverCelda(Posicion pos) {
				int fila = pos.getFila();
				int columna = pos.getColumna();
				return matriz[fila][columna];
			}

			public Celda getCelda(int fil, int col) {
				// TODO Auto-generated method stub
				return matriz[fil][col];
			}
			public int getTamanio(){
				return this.tamanio;
			}

			public Posicion getBaseJugador(int jugador) {
				// TODO Auto-generated method stub
				return this.baseJugadores.get(jugador);
			}

			public ArrayList<Celda> devolverCeldasRadio(Posicion pos, int radio) {
				ArrayList<Celda> listaDeCeldas = new ArrayList<Celda>();
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
						listaDeCeldas.add(this.getCelda(fil, col));
					}
				}
				return listaDeCeldas;
				
			}
					
			   
		
		
	
}