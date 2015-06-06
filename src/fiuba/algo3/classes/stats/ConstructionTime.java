package fiuba.algo3.classes.stats;

public class ConstructionTime {

	private Integer maxTurn;
	private Integer currentTurn;
	
	public ConstructionTime(Integer maxTurn){
		this.maxTurn = maxTurn;
		this.currentTurn = maxTurn;
	}

	public Integer getMaxTurn() {
		return maxTurn;
	}

	public void setMaxTurn(Integer maxTurn) {
		this.maxTurn = maxTurn;
	}

	public Integer getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(Integer currentTurn) {
		this.currentTurn = currentTurn;
	}

}
