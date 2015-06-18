package fiuba.algo3.algocraft.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algocraft.construcciones.Construccion;
import fiuba.algo3.algocraft.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.algocraft.unidades.Unidad;

public class Jugador {

	private String nombre;
	private String color;
	private Raza raza;
	private List<Construccion> construccionesList;
	private List<Unidad> unidadesList;
	
	
	public Jugador(){
		this.nombre = ""; 
		this.color = "";
		this.construccionesList = new ArrayList<Construccion>();
		this.unidadesList = new ArrayList<Unidad>();
	
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

	public List<Construccion> getConstruccionesList(){
		return this.construccionesList;
	}
	
	public List<Unidad> getUnidadesList(){
		return this.unidadesList;
	}
	
	public void agregarConstruccion(Construccion construccion){
		this.construccionesList.add(construccion);
	}
	
}
