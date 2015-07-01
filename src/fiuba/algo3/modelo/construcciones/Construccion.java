package fiuba.algo3.modelo.construcciones;

import fiuba.algo3.modelo.complementos.CostoDeRecursos;
import fiuba.algo3.modelo.complementos.Daniable;
import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Escudo;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.TiempoDeConstruccion;
import fiuba.algo3.modelo.complementos.Vida;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.unidades.Unidad;

public abstract class Construccion implements Daniable{

	private String name;
	private CostoDeRecursos cost;
	private TiempoDeConstruccion constructionTime;
	private Vida health;
	private Escudo shield;
	protected Posicion ubicacion;

	public Construccion(String name, Integer mineralCost, Integer gasCost,
			Integer construtionTime, Integer maxHealth, Integer maxShield,
			String unit, Posicion pos){

		this.name = name;
		this.cost = new CostoDeRecursos(mineralCost, gasCost);
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

	public CostoDeRecursos getCost() {
		return cost;
	}

	public void setCost(CostoDeRecursos cost) {
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
	
	public void recibirAtaque(Danio danio){
		/*Integer danioTerrestre = danio
		Integer escudoActual = this.getShield().getEscudoActual();
		if(escudoActual> danio){
			this.getShield().setEscudoActual(escudoActual-danio);
		}else{
			this.getShield().setEscudoActual(0);
			this.setVida(this.getHealth().getVidaActual()-(danio-escudoActual));
		}*/
	}

	public boolean esProductorMineral() {
		return false;
	}

	public boolean esProductorGas() {
		return false;
	}

	public void actualizarPoblacion(Jugador jugador) {
	
		
	}
	
	public Posicion getUbicacion(){
		return this.ubicacion;
	}
	
	
}
