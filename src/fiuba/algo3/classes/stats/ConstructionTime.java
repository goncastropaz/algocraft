package fiuba.algo3.classes.stats;

public class ConstructionTime {

	private Integer minutes;
	private Integer seconds;
	
	public ConstructionTime(Integer totalSeconds){
		minutes = totalSeconds/60;
		seconds = totalSeconds%60;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public Integer getSeconds() {
		return seconds;
	}
	
}
