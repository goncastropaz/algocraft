package fiuba.algo3.classes.game;

import fiuba.algo3.classes.exceptions.NombreConMenosDe4Caracteres;

public class Jugador {

	private String nombre;
	private String color;
	private Raza raza;
	
	public Jugador(){
		this.nombre = ""; 
		this.color = "";
			
	
	}
	
	public void setNombre(String nombre) throws NombreConMenosDe4Caracteres{
		if(nombre.length() < 4) throw new NombreConMenosDe4Caracteres();
		this.nombre = nombre;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setRaza(Raza unaRaza){
		this.raza = unaRaza;
	}
	public String getNombre(){
		return this.nombre;
	}
	public String getColor(){
		return this.color;
	}
	public Raza getRaza(){
		return this.raza;
	}
}
