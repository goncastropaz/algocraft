package fiuba.algo3.classes.stats;

public class Shield {

	
	private Integer maxShield;
	private Integer currentShield;
	
	public Shield(Integer shield){
		maxShield = shield;
		currentShield = shield;
	}

	public Integer getMaxShield() {
		return maxShield;
	}

	public Integer getCurrentShield() {
		return currentShield;
	}

}
