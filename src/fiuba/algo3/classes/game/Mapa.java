package fiuba.algo3.classes.game;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;

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
				mat[4][4].setMineral();
				mat[4][5].setMineral();
				mat[5][4].setMineral();
				mat[5][5].setGas();
				matriz= mat;
							
			}
			
			private synchronized static void createInstance() throws FueraDeMatriz {
				if (INSTANCE == null) { 
			       INSTANCE = new Mapa();
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
