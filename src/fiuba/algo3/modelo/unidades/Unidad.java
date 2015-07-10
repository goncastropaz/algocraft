package fiuba.algo3.modelo.unidades;


import java.util.List;

import fiuba.algo3.modelo.complementos.Daniable;
import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Escudo;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.complementos.TiempoDeConstruccion;
import fiuba.algo3.modelo.complementos.Vida;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.FueraDeRango;
import fiuba.algo3.modelo.excepciones.ObjetivoInvalido;
import fiuba.algo3.modelo.excepciones.UnidadAtacadaInvalida;
import fiuba.algo3.modelo.excepciones.UnidadAtacanteInvalida;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;

public abstract class Unidad implements IUnidad, Daniable{

	private String nombre;
	private Recursos costoDeRecursos;
	private TiempoDeConstruccion tiempoDeConstruccion;
	protected Vida vida;
	private Escudo escudo;
	private int vision;
	public RangoDeAtaque rango;
	public Integer suministro;
	public Danio danio;
	public boolean copia;
	public Posicion ubicacion;
	private Integer transporte;
	
	
	public Unidad(String nombre, Integer tiempoDeConstruccion, Integer vidaMaxima, Integer escudoMaximo,Integer vision,Integer suministro, Integer transporte) {
		this.nombre = nombre;
		this.tiempoDeConstruccion = new TiempoDeConstruccion(tiempoDeConstruccion);
		this.vida = new Vida(vidaMaxima);
		this.escudo = (new Escudo(escudoMaximo));
		this.vision =vision;
		this.suministro = suministro;
		this.copia = false;
		this.transporte = transporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Recursos getCostoDeRecursos() {
		return costoDeRecursos;
	}

	public void setCostoDeRecursos(Recursos costoDeRecursos) {
		this.costoDeRecursos = costoDeRecursos;
	}
	
	public void setRangoDeAtaque(RangoDeAtaque rango){
		this.rango = rango;
	}

	public TiempoDeConstruccion getTiempoDeConstruccion() {
		return tiempoDeConstruccion;
	}

	public void setTiempoDeConstruccion(TiempoDeConstruccion tiempoDeConstruccion) {
		this.tiempoDeConstruccion = tiempoDeConstruccion;
	}

	public Vida getVida() {
		return vida;
	}


	public Escudo getEscudo() {
		return escudo;
	}

	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
	}


	public void actualizarTurno(Jugador jugador) {
			this.tiempoDeConstruccion.actualizarTiempo();	
	}

	public int getVision() {
		return this.vision;
	}
	
	public Integer getSuministro(){
		return this.suministro;
	}
	public void setDanio(Danio danio){
		this.danio = danio;
	}
	public Danio getDanio(){
		return this.danio;
	}
	
	public boolean destruir(){
		return (!this.vida.tieneVida());
		
	}
	public void setCopia(){
		this.copia = true;
		this.danio = new Danio(0,0);
		this.setCostoDeRecursos(new Recursos(0,0));
		this.vida.setVidaActual(0);
	}
	
	public void ataqueEMP(){
		this.getEscudo().setEscudoActual(0);
	}
	
	public void radiacion(int danio){
		this.vida.setVidaActual(this.getVida().getVidaActual()-(danio));
		
	}

	public void tormentaPsionica(int danio) {
		Integer escudoActual = this.getEscudo().getEscudoActual();
		if(escudoActual> danio){
			this.getEscudo().setEscudoActual(escudoActual-danio);
		}else{
			this.getEscudo().setEscudoActual(0);
			this.vida.setVidaActual(this.getVida().getVidaActual()-(danio-escudoActual));
		}
		
	}

	public boolean permitidaEnArea(Celda celda){
		return true;
	}
	
	public void cambiarUbicacion(Posicion pos){
		this.ubicacion = pos;
	}

	public Posicion getUbicacion() {
		return this.ubicacion;
	}
	
	public RangoDeAtaque getRango(){
		return this.rango;
	}

	public void setUbicacion(Posicion posUnidad) {
		this.ubicacion = posUnidad;
		
	}

	public void atacarUnidad(Juego juego, Posicion posicion) throws ObjetivoInvalido, UnidadAtacanteInvalida, UnidadAtacadaInvalida, FueraDeRango{
		if(!juego.getActualJugador().tieneDaniable(this.getUbicacion())) throw new UnidadAtacanteInvalida();
		if(juego.getActualJugador().tieneDaniable(posicion)) throw new UnidadAtacadaInvalida();
		juego.getMapaDeJuego().getDaniable(posicion).recibirAtaque(juego,this);
	}
	
	public void recibirAtaque(Integer danio){
		Integer escudoActual = this.getEscudo().getEscudoActual();
		if(escudoActual> danio){
			this.getEscudo().setEscudoActual(escudoActual-danio);
		}else{
			this.getEscudo().setEscudoActual(0);
			this.vida.setVidaActual(this.getVida().getVidaActual()-(danio-escudoActual));
		}
	}

	public abstract boolean tieneEdificiosPrevios(List<Construccion> construccionesList);

	public boolean tieneConstruccion(List<Construccion> construcciones, String edificio){
		for(Construccion construccion : construcciones){
			if(edificio.equals(construccion.getName())){
				return true;
			}
		}
		return false;
	}

	public abstract boolean tieneMagia(String magia);

	public abstract boolean puedeTransportar();

	public boolean vuela() {
		return this.transporte == 0;
	}
	
	public Integer getTransporte(){
		return this.transporte;
	}

	public boolean isUnidadMagica() {
		return false;
	}
	
	public int getEnergia(){
		return 0;
	}
	
	public boolean terminado() {
		return this.tiempoDeConstruccion.terminado();
	}
}
