package fiuba.algo3.classes.stats;

public class ResourceCost {

	private Integer mineralCost;
	private Integer gasCost;
	
	public ResourceCost(Integer mineralCost, Integer gasCost) {
		this.mineralCost = mineralCost;
		this.gasCost = gasCost;
	}

	public Integer getMineralCost() {
		return mineralCost;
	}

	public void setMineralCost(Integer mineralCost) {
		this.mineralCost = mineralCost;
	}

	public Integer getGasCost() {
		return gasCost;
	}

	public void setGasCost(Integer gasCost) {
		this.gasCost = gasCost;
	}
	
}
