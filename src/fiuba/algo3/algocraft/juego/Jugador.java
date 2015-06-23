package fiuba.algo3.algocraft.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algocraft.construcciones.Construccion;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Posicion;

public class Jugador {

	private String nombre;
	private String color;
	private Raza raza;
	private List<Construccion> construccionesList;
	private List<Unidad> unidadesList;
	private int mineral;
	private int gasVespeno;
	private int poblacion;
	private int cuposDePoblacionOcupada;
	private VisionJugador visionMapa;
	
	
	public Jugador(Posicion baseInicial) throws FueraDeMatriz{
		this.nombre = ""; 
		this.color = "";
		this.construccionesList = new ArrayList<Construccion>();
		this.unidadesList = new ArrayList<Unidad>();
		this.mineral = 0;
		this.gasVespeno = 0;
		this.poblacion = 0;
		this.cuposDePoblacionOcupada =0;
		this.visionMapa = new VisionJugador(baseInicial);
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
	
	public void agregarUnidad(Unidad unidad){
		this.unidadesList.add(unidad);
		this.cuposDePoblacionOcupada= this.cuposDePoblacionOcupada +unidad.getSuministro();
	}

	public void actualizarMineral() {
		this.mineral = this.mineral + 10;
		
	}
	public void actualizarGasVespeno(){
		this.gasVespeno = this.gasVespeno +10;
	}

	public void agregarPoblacion() {
		this.poblacion = this.poblacion + 5;
		if(this.poblacion>200) this.poblacion=200;
		
	}
	public boolean tieneCupoDePoblacion(int cupo){
		return ((this.poblacion-this.cuposDePoblacionOcupada)>= cupo);
	}

	public void actualizarVision(Posicion pos, int radio) throws FueraDeMatriz {
		this.visionMapa.setRadioDeVision(pos, radio);
		
	}
	
	public VisionJugador getVision(){
		return this.visionMapa;
	}

	public void destruirUnidad(Unidad unidad) {
		this.unidadesList.remove(unidad);
		
	}

	public void destruirConstruccion(Construccion construccion) {
		this.construccionesList.remove(construccion);
		
	}

	
}