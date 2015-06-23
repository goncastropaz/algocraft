package fiuba.algo3.algocraft.construcciones;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.unidades.IUnidad;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.CostoDeRecursos;
import fiuba.algo3.classes.stats.Escudo;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.stats.TiempoDeConstruccion;
import fiuba.algo3.classes.stats.Vida;

public abstract class Construccion {

	private String name;
	private CostoDeRecursos cost;
	private TiempoDeConstruccion constructionTime;
	private Vida health;
	private Escudo shield;
	private RaceUnitBuilding unitBuilder;
	private Celda ubicacion;
	private Jugador jugadorCreador;

	public Construccion(String name, Integer mineralCost, Integer gasCost,
			Integer construtionTime, Integer maxHealth, Integer maxShield,
			String unit, Posicion posicion) throws FueraDeMatriz {

		this.name = name;
		this.cost = new CostoDeRecursos(mineralCost, gasCost);
		this.constructionTime = new TiempoDeConstruccion(construtionTime);
		this.health = new  Vida(maxHealth);
		this.shield = new Escudo(maxShield);
		this.unitBuilder = new RaceUnitBuilding();
		this.ubicacion= Mapa.getInstance().getCelda(posicion.getFila(),posicion.getColumna());
		this.jugadorCreador = Juego.getInstance().getActualJugador();
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

	public RaceUnitBuilding getUnitBuilder() {
		return unitBuilder;
	}

	public void setUnitBuilder(RaceUnitBuilding unitBuilder) {
		this.unitBuilder = unitBuilder;
	}

	public Celda getUbicacion() {
		return this.ubicacion;
	}

	
	public void actualizarTurno(Jugador jugador){
		this.constructionTime.actualizarTiempo();
	}
	
	private void destruir() {
		this.ubicacion.removerConstruccion();
			this.jugadorCreador.destruirConstruccion(this);
			
		
		
	}
	
	public void ataque(Unidad unidadAtacante){
		int danio = unidadAtacante.getDanioTerrestre();
		Integer escudoActual = this.getShield().getEscudoActual();
		if(escudoActual> danio){
			this.getShield().setEscudoActual(escudoActual-danio);
		}else{
			this.getShield().setEscudoActual(0);
			this.setVida(this.getHealth().getVidaActual()-(danio-escudoActual));
		}
	}
	
	
}
