package fiuba.algo3.classes.game;

public class Player {

	private String nombre;
	private String color;
	private GamePlayer game;
	
	public Player(String nombre, String color,Race raza){
		this.nombre = nombre;
		this.color = color;
		this.game = new GamePlayer(raza);
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public String getColor(){
		return this.color;
	}
	
}
