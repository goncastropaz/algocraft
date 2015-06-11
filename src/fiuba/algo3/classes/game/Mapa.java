package fiuba.algo3.classes.game;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class Mapa {

			
			private static Mapa INSTANCE = null;
			private Celda[][] matriz;
						
			private Mapa() throws FueraDeMatriz{
				
				Celda mat[][] = new Celda[20][20];
				for(int f=0;f<20;f++){
					for(int c=0;c<20;c++){
						Celda unaCelda = new Celda(f,c);
						mat[f][c] = unaCelda;
					};
				};
				
				matriz= mat;
				this.setRecursosEnMapa();
				this.setAreasEspaciales();
							
			}
			
			private synchronized static void createInstance() throws FueraDeMatriz {
				if (INSTANCE == null) { 
			       INSTANCE = new Mapa();
			    }
			}
			
			private void setRecursosEnMapa(){
				matriz[4][4].setMineral();
				matriz[4][5].setMineral();
				matriz[5][4].setMineral();
				matriz[5][5].setGas();
			}
			
			private void setAreasEspaciales(){
				for(int fil=1; fil<15; fil++){
					for(int col= 8; col<12; col++){
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
			
					
			   
		
		
	
}
