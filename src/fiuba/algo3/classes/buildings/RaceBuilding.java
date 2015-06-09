package fiuba.algo3.classes.buildings;

import fiuba.algo3.classes.stats.ConstructionTime;
import fiuba.algo3.classes.stats.Coordinates;
import fiuba.algo3.classes.stats.Health;
import fiuba.algo3.classes.stats.ResourceCost;
import fiuba.algo3.classes.stats.Shield;

public abstract class RaceBuilding {

	private String name;
	private ResourceCost cost;
	private ConstructionTime constructionTime;
	private Health health;
	private Shield shield;
	private RaceUnitBuilding unitBuilder;
	private Coordinates coordenadas;

	public RaceBuilding(String name, Integer mineralCost, Integer gasCost,
			Integer construtionTime, Integer maxHealth, Integer maxShield,
			String unit, Integer coordenadaX, Integer coordenadaY) {

		this.name = name;
		this.cost = new ResourceCost(mineralCost, gasCost);
		this.constructionTime = new ConstructionTime(construtionTime);
		this.health = new Health(maxHealth);
		this.shield = new Shield(maxShield);
		this.unitBuilder = new RaceUnitBuilding();
		this.coordenadas = new Coordinates(coordenadaX, coordenadaY);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceCost getCost() {
		return cost;
	}

	public void setCost(ResourceCost cost) {
		this.cost = cost;
	}

	public ConstructionTime getConstructionTime() {
		return constructionTime;
	}

	public void setConstructionTime(ConstructionTime constructionTime) {
		this.constructionTime = constructionTime;
	}

	public Health getHealth() {
		return health;
	}

	public void setHealth(Health health) {
		this.health = health;
	}

	public Shield getShield() {
		return shield;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}

	public RaceUnitBuilding getUnitBuilder() {
		return unitBuilder;
	}

	public void setUnitBuilder(RaceUnitBuilding unitBuilder) {
		this.unitBuilder = unitBuilder;
	}

	public Coordinates getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordinates coordenadas) {
		this.coordenadas = coordenadas;
	}

}
