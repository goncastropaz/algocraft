package fiuba.algo3.classes.game;

public class GameMap {

	private int size; 
	private Cell[][] map;  //matriz de tamanio dado por 'size'
	
	public void GameMap(int cantBases){
			
			this.size = this.getMapSize(cantBases);
			map= new Cell[this.size][this.size];
		
			for(int i=0;i<this.size ; i++){
				for(int j=0; i<this.size;i++){
					map[i][j] = new Cell();
					
				}
			}
			this.asignarAreas();
			this.asignarBases(cantBases);
	}
	
	private int getMapSize(int cantBases){
		//codigo para calcular tamanio de mapa dependiendo del total de bases
		return 10; // default
	}
	private void asignarAreas(){
		//se asigna a un conjunto de celdas si son espaciales.
	}
	private void asignarBases(int cantBases){
		//se le asigna equidistantemente las bases al mapa.
	}
	
}
