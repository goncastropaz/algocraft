package fiuba.algo3.classes.game;

public class GamePlayer {
	private Race raza;
	private int mineral;
	private Cell base;
	private int poblacion;
	private int unidades;
	private int contrucciones;
	
	public GamePlayer(Race raza) {
		this.raza = raza;
		this.mineral = 200;
		this.poblacion =0;
		//contruir diccionario unidades.
		//contruir diccionario contrucciones.
	}

	public void setBase(Cell base){
		this.base = base;
	}
	public void destruccionCasa(){
		//si poblacion =0 error.
		this.poblacion = this.poblacion -5;
	}
	public void construccionCasa(){
		if(this.poblacion<= 195){
			this.poblacion = this.poblacion +5;
		} else{
			//error.
		}
	}
}
