package fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.modelo.complementos.Poblacion;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NombreConMenosDe4Caracteres;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneConstruccion;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.razas.Raza;
import fiuba.algo3.modelo.unidades.Unidad;

public class Jugador {

	private String nombre;
	private String color;
	private Raza raza;
	private List<Construccion> construccionesList;
	private List<Unidad> unidadesList;
	private Recursos recursos;
	private Poblacion poblacion;
	private VisionJugador visionMapa;
	
	
	public Jugador(Posicion baseInicial) throws FueraDeMatriz{
		this.nombre = ""; 
		this.color = "";
		this.construccionesList = new ArrayList<Construccion>();
		this.unidadesList = new ArrayList<Unidad>();
		this.recursos = new Recursos(0, 0);
		this.poblacion = new Poblacion();
		this.visionMapa = new VisionJugador(baseInicial);
	}
	
	public void setNombre(String nombre) throws NombreConMenosDe4Caracteres{
		if((nombre.length() < 4) || (nombre.isEmpty())) throw new NombreConMenosDe4Caracteres();
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
		construccion.actualizarPoblacion(this);
	}
	
	public void agregarUnidad(Unidad unidad){
		this.unidadesList.add(unidad);
		this.poblacion.agregarPoblacion(unidad.getSuministro());
		this.recursos.sacarRecursos(unidad.getCostoDeRecursos());
	}

	public void actualizarMineral() {
		this.recursos.agregarMinerales(10);
		
	}
	public void actualizarGasVespeno(){
		this.recursos.agregarGas(10);
	}

	public void agregarPoblacion() {
		this.poblacion.agregarPoblacionMaxima();
		
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

	public void puedeCrearUnidad(Unidad unidad ) throws RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente {
		if(!this.raza.getListaDeUnidadesValidas().contains(unidad.getNombre())) throw new RazaNoTieneUnidad();
		if(!unidad.getCostoDeRecursos().tieneSuficientesRecursos(this.recursos.getMineral(),this.recursos.getGas())) throw new RecursosInsuficientes();
		if(!(this.poblacion.getPoblacionDisponible() > unidad.getSuministro())) throw new PoblacionInsuficiente();
		//TODO agregar validacion de edificio (?)
	}

	public void puedeCrearConstruccion(Construccion construccion) throws RazaNoTieneConstruccion, RecursosInsuficientes {
		if(!this.raza.getListaDeConstruccionesValidas().contains(construccion.getName())) throw new RazaNoTieneConstruccion();
		if(!construccion.getCost().tieneSuficientesRecursos(this.recursos.getMineral(), this.recursos.getGas())) throw new RecursosInsuficientes();
		//TODO agregar validacion de edificio (?)
	}

	
}