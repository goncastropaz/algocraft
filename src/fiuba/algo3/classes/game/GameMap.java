package fiuba.algo3.classes.game;

public class GameMap {

	private int size; 
	private Cell[][] map;  //matriz de tamanio dado por 'size'
	private Cell[] playerBase;
	
	public GameMap(int cantBases){
			//cantBases debe ser mayor a 2.
			this.size = this.getMapSize(cantBases);
			map= new Cell[this.size][this.size];
		
			for(int i=0;i<this.size ; i++){
				for(int j=0; i<this.size;i++){
					map[i][j] = new Cell();
					
				}
			}
			this.asignarAreas();
			this.asignarBases(cantBases);
			this.setBasePlayers();
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
	
	private void setBasePlayers(){
		playerBase = new Cell[2];
		int colFil = this.size /4 -1;
		playerBase[0] = map[colFil][colFil];
		colFil = this.size - (this.size/4);
		playerBase[1] =  map[colFil][colFil];
	}
	
	public Cell getBasePlayer(int numPlayer){
		return playerBase[numPlayer-1];
	}
	
}
