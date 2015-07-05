package fiuba.algo3.modelo.unidades;

import java.awt.List;

import fiuba.algo3.modelo.complementos.Daniable;
import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Escudo;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.complementos.TiempoDeConstruccion;
import fiuba.algo3.modelo.complementos.Vida;
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
	
	
	public Unidad(String nombre, Integer tiempoDeConstruccion, Integer vidaMaxima, Integer escudoMaximo,Integer vision,Integer suministro) {
		this.nombre = nombre;
		this.tiempoDeConstruccion = new TiempoDeConstruccion(tiempoDeConstruccion);
		this.vida = new Vida(vidaMaxima);
		this.escudo = (new Escudo(escudoMaximo));
		this.vision =vision;
		this.suministro = suministro;
		this.copia = false;
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
			//tormenta turnos
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
		//actualizar poblacion y destruir
	}

}
