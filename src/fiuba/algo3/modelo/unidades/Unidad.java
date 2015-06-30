package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.CostoDeRecursos;
import fiuba.algo3.modelo.complementos.Escudo;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.complementos.TiempoDeConstruccion;
import fiuba.algo3.modelo.complementos.Vida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.juego.Turno;

public abstract class Unidad implements IUnidad{

	private String nombre;
	private CostoDeRecursos costoDeRecursos;
	private TiempoDeConstruccion tiempoDeConstruccion;
	protected Vida vida;
	private Escudo escudo;
	private int vision;
	public RangoDeAtaque rango;
	public Integer suministro;
	public Integer danioAereo;
	public Integer danioTerrestre;
	public boolean copia;
	public Posicion ubicacion;
	
	
	public Unidad(String nombre, Integer tiempoDeConstruccion, Integer vidaMaxima, Integer escudoMaximo,Integer vision,Integer suministro,Posicion pos) {
		this.nombre = nombre;
		this.tiempoDeConstruccion = new TiempoDeConstruccion(tiempoDeConstruccion);
		this.vida = new Vida(vidaMaxima);
		this.escudo = (new Escudo(escudoMaximo));
		this.vision =vision;
		this.suministro = suministro;
		this.copia = false;
		this.ubicacion = pos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CostoDeRecursos getCostoDeRecursos() {
		return costoDeRecursos;
	}

	public void setCostoDeRecursos(CostoDeRecursos costoDeRecursos) {
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
		// TODO Auto-generated method stub
		return this.vision;
	}
	
	public Integer getSuministro(){
		return this.suministro;
	}
	public void setDanios(Integer danioAereo,Integer danioTerrestre){
		this.danioTerrestre = danioTerrestre;
		this.danioAereo = danioAereo;
	}
	public Integer getDanioAereo(){
		return this.danioAereo;
	}
	public Integer getDanioTerrestre(){
		return this.danioTerrestre;
	}
	
	public boolean destruir(){
		return (!this.vida.tieneVida());
		
	}
	public void setCopia(){
		this.copia = true;
		this.danioAereo = 0;
		this.danioTerrestre = 0;
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
	
}
