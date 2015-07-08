package fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.modelo.complementos.Poblacion;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
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
		this.recursos = new Recursos(200, 0);
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
	public String getNombreRaza(){
		return this.raza.getNombreRaza();
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
		if(!unidad.copia){
			this.poblacion.agregarPoblacion(unidad.getSuministro());
			this.recursos.sacarRecursos(unidad.getCostoDeRecursos());
		}
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

	public void puedeCrearUnidad(Unidad unidad) throws RecursosInsuficientes, PoblacionInsuficiente {
		if(!unidad.copia){
			//if(!this.raza.getListaDeUnidadesValidas().contains(unidad.getNombre())) throw new RazaNoTieneUnidad();
			if(!unidad.getCostoDeRecursos().tieneSuficientesRecursos(this.recursos.getMineral(),this.recursos.getGas())) throw new RecursosInsuficientes();
			if(!(this.poblacion.getPoblacionDisponible() > unidad.getSuministro())) throw new PoblacionInsuficiente();
			//if(!unidad.tieneEdificiosPrevios(this.getConstruccionesList())) throw new NoTieneEdificiosPrevios();
		}
	}

	public void puedeCrearConstruccion(Construccion construccion) throws RazaNoTieneConstruccion, RecursosInsuficientes, NoTieneEdificiosPrevios {
		//if(!this.raza.getListaDeConstruccionesValidas().contains(construccion.getName())) throw new RazaNoTieneConstruccion();
		if(!construccion.getCost().tieneSuficientesRecursos(this.recursos.getMineral(), this.recursos.getGas())) throw new RecursosInsuficientes();
		if(!construccion.tieneEdificiosPrevios(this.getConstruccionesList())) throw new NoTieneEdificiosPrevios(); 
	}

	public boolean tieneDaniable(Posicion ubicacion) {
		for(Unidad unidad : this.getUnidadesList()){
			if(ubicacion.equals(unidad.getUbicacion())) return true;
		}
		for(Construccion construccion : this.getConstruccionesList()){
			if(ubicacion.equals(construccion.getUbicacion())) return true;
		}
		return false;
	}

	public void refrescar() {
		List<Unidad> unidades = new ArrayList<Unidad>();
		List<Construccion> construcciones = new ArrayList<Construccion>();
		for(Unidad unidad : unidadesList){
			if(unidad.getVida().getVidaActual().equals(0)){
				unidades.add(unidad);
				poblacion.sacarPoblacion(unidad.getSuministro());
			}
		}
		for(Construccion construccion : construccionesList){
			if(construccion.getHealth().getVidaActual().equals(0)){
				construcciones.add(construccion);
			}
		}
		if(!unidades.isEmpty()) unidadesList.removeAll(unidades);
		if(!construcciones.isEmpty()) construccionesList.removeAll(construcciones);
	}

	public Object getRaza() {
		return this.raza;
	}

	public Recursos getRecursos() {
		return this.recursos;
	}

	public int getPoblacion() {
		return this.poblacion.getPoblacionActual();

	}


}