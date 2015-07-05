package fiuba.algo3.modelo.construcciones;

import java.util.List;

import fiuba.algo3.modelo.complementos.Daniable;
import fiuba.algo3.modelo.complementos.Escudo;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.complementos.TiempoDeConstruccion;
import fiuba.algo3.modelo.complementos.Vida;
import fiuba.algo3.modelo.excepciones.FueraDeRango;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.unidades.Unidad;

public abstract class Construccion implements Daniable{

	private String name;
	private Recursos cost;
	private TiempoDeConstruccion constructionTime;
	private Vida health;
	private Escudo shield;
	protected Posicion ubicacion;

	public Construccion(String name, Integer mineralCost, Integer gasCost,
			Integer construtionTime, Integer maxHealth, Integer maxShield,
			String unit, Posicion pos){

		this.name = name;
		this.cost = new Recursos(mineralCost, gasCost);
		this.constructionTime = new TiempoDeConstruccion(construtionTime);
		this.health = new  Vida(maxHealth);
		this.shield = new Escudo(maxShield);
		this.ubicacion = pos;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Recursos getCost() {
		return cost;
	}

	public void setCost(Recursos cost) {
		this.cost = cost;
	}

	public TiempoDeConstruccion getConstructionTime() {
		return constructionTime;
	}

	public void setConstructionTime(TiempoDeConstruccion constructionTime) {
		this.constructionTime = constructionTime;
	}

	public Vida getHealth() {
		return health;
	}

	public void setVida( Integer vida) {
		if(vida<=0){
			this.destruir();
		}else{
			this.health.setVidaActual(vida);
		}
	}

	public Escudo getShield() {
		return shield;
	}

	public void setShield(Escudo shield) {
		this.shield = shield;
	}
	
	public void actualizarTurno(Jugador jugador){
		this.constructionTime.actualizarTiempo();
	}
	
	private void destruir() {
// hablarlo porque no puedo tener ubicacion ni jugador
	}
	
	public void recibirAtaque(Juego juego, Unidad unidad) throws FueraDeRango{
		boolean rangoValido = false;
		List<Celda> celdas = juego.getMapaDeJuego().devolverCeldasRadio(unidad.getUbicacion(), unidad.getRango().getRangoTierra());
		for(Celda celda : celdas){
			if(this.ubicacion.equals(celda.getPosicion())) rangoValido = true;
		}
		if(!rangoValido){
			throw new FueraDeRango();
		}
		int danioT = unidad.getDanio().getDanioTerrestre();
		recibirAtaque(danioT);
	}

	public void recibirAtaque(Integer danio){
		Integer escudoActual = this.shield.getEscudoActual();
		if(escudoActual> danio){
			this.shield.setEscudoActual(escudoActual-danio);
		}else{
			this.shield.setEscudoActual(0);
			this.health.setVidaActual(this.health.getVidaActual()-(danio-escudoActual));
		}
		//actualizar poblacion y destruir
	}
	
	public boolean esProductorMineral() {
		return false;
	}

	public boolean esProductorGas() {
		return false;
	}

	public void actualizarPoblacion(Jugador jugador){}
	
	public Posicion getUbicacion(){
		return this.ubicacion;
	}

	public abstract boolean tieneEdificiosPrevios(List<Construccion> construcciones);
	
	public boolean tieneConstruccion(List<Construccion> construcciones, String edificio){
		for(Construccion construccion : construcciones){
			if(edificio.equals(construccion.getName())){
				return true;
			}
		}
		return false;
	}
	
}
