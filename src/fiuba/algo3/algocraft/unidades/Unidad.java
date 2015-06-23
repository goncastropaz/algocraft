package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.juego.Turno;
import fiuba.algo3.classes.stats.CostoDeRecursos;
import fiuba.algo3.classes.stats.Escudo;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.stats.RangoDeAtaque;
import fiuba.algo3.classes.stats.TiempoDeConstruccion;
import fiuba.algo3.classes.stats.Vida;

public abstract class Unidad implements IUnidad{

	Jugador JugadorCreador;
	private String nombre;
	private CostoDeRecursos costoDeRecursos;
	private TiempoDeConstruccion tiempoDeConstruccion;
	private Vida vida;
	private Escudo escudo;
	private int vision;
	public Celda ubicacion;
	public RangoDeAtaque rango;
	public Integer suministro;
	public Integer danioAereo;
	public Integer danioTerrestre;
	public boolean copia;
	
	
	public Unidad(String nombre, Integer tiempoDeConstruccion, Integer vidaMaxima, Integer escudoMaximo,Integer vision,Integer suministro,Posicion pos) throws FueraDeMatriz{
		this.nombre = nombre;
		this.tiempoDeConstruccion = new TiempoDeConstruccion(tiempoDeConstruccion);
		this.vida = new Vida(vidaMaxima);
		this.escudo = (new Escudo(escudoMaximo));
		this.ubicacion = Mapa.getInstance().getCelda(pos.getFila(),pos.getColumna()); 
		this.vision =vision;
		this.suministro = suministro;
		this.JugadorCreador = Juego.getInstance().getActualJugador();
		this.copia = false;
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

	public void setVida(Integer vida) {
		if(vida<=0){
			this.destruir();
		}else{
			this.vida.setVidaActual(vida);
		}
	}

	public Escudo getEscudo() {
		return escudo;
	}

	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
	}

	public Celda getUbicacion() {
		
		return this.ubicacion;
	}

	public void setNuevaUbicacion(Celda celda) throws UnidadTerrestreEnAreaEspacial, CeldaOcupada {
		this.ubicacion = celda;
			
	}

	public void actualizarTurno(Jugador jugador) {
			this.tiempoDeConstruccion.actualizarTiempo();	
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
	
	public void destruir(){
		this.ubicacion.removeUnidad();
		this.JugadorCreador.destruirUnidad(this);
		
	}
	public void setCopia(){
		this.copia = true;
		this.danioAereo = 0;
		this.danioTerrestre = 0;
		this.vida.setVidaActual(0);
	}
	
	
}
