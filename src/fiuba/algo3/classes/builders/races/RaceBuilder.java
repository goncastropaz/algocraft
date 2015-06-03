package fiuba.algo3.classes.builders.races;

import fiuba.algo3.classes.builders.buildings.RaceBuildingBuilder;
import fiuba.algo3.classes.builders.units.RaceUnitBuilder;

public class RaceBuilder {

	private RaceBuildingBuilder raceBuildingBuilder;
	private RaceUnitBuilder raceUnitBuilder;
	
	public RaceBuildingBuilder getRaceBuildingBuilder() {
		return raceBuildingBuilder;
	}
	
	public void setRaceBuildingBuilder(RaceBuildingBuilder raceBuildingBuilder) {
		this.raceBuildingBuilder = raceBuildingBuilder;
	}
	
	public RaceUnitBuilder getRaceUnitBuilder() {
		return raceUnitBuilder;
	}
	
	public void setRaceUnitBuilder(RaceUnitBuilder raceUnitBuilder) {
		this.raceUnitBuilder = raceUnitBuilder;
	}
	
}
