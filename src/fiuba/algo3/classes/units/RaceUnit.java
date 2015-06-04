package fiuba.algo3.classes.units;

import fiuba.algo3.classes.stats.ConstructionTime;
import fiuba.algo3.classes.stats.Health;
import fiuba.algo3.classes.stats.ResourceCost;

public class RaceUnit {

	private String name;
	private ResourceCost cost;
	private ConstructionTime constructionTime;
	private Health health;
	
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
	
}
