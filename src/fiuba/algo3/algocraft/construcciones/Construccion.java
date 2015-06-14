package fiuba.algo3.algocraft.construcciones;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.unidades.IUnidad;
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
	private Posicion coordenadas;

	public Construccion(String name, Integer mineralCost, Integer gasCost,
			Integer construtionTime, Integer maxHealth, Integer maxShield,
			String unit, Posicion posicion) throws FueraDeMatriz {

		this.name = name;
		this.cost = new CostoDeRecursos(mineralCost, gasCost);
		this.constructionTime = new TiempoDeConstruccion(construtionTime);
		this.health = new  Vida(maxHealth);
		this.shield = new Escudo(maxShield);
		this.unitBuilder = new RaceUnitBuilding();
		this.coordenadas = posicion;

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

	public void setHealth( Vida health) {
		this.health = health;
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

	public Posicion getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Posicion coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	public IUnidad crearUnidad(FabricaDeUnidades fabrica) throws FueraDeMatriz{
		//la unidad se crea en la misma posicion que el edificio
		return fabrica.crearUnidad(this.getCoordenadas());
	}

}
