package fiuba.algo3.classes.game;

import fiuba.algo3.classes.game.buildings.Building;

public class Cell {

	private String tipoDeArea = "tierra"; //por defaul, depsues podemos separarlas en clases de ultima
	private Building contruccion;
	
	public void asignarArea(String area){
		this.tipoDeArea= area;
		
	}
	
}
