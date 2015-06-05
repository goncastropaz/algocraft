package fiuba.algo3.classes.builders.buildings;

import java.util.Map;

import fiuba.algo3.classes.builders.units.RaceUnitBuilder;
import fiuba.algo3.classes.buildings.RaceBuilding;
import fiuba.algo3.utils.Constants;

public class RaceBuildingBuilder {

	protected Map<String,RaceBuilding> raceBuildingMap;
	protected RaceUnitBuilder raceUnitBuilder;
	
	public static RaceBuildingBuilder getRaceBuildingBuilder(Integer raceId){
		RaceBuildingBuilder raceBuildingBuilder;
		if(raceId.equals(Constants.TERRAN_ID)){
			raceBuildingBuilder = new TerranBuildingBuilder();
		} else if(raceId.equals(Constants.PROTOSS_ID)){
			raceBuildingBuilder = new ProtossBuildingBuilder();
		} else{
			raceBuildingBuilder = null;
		}
		return raceBuildingBuilder;
	}
	
	public static RaceUnitBuilder getRaceUnitBuilder(Integer raceId) {
		// = metodo con xml builder;
		RaceUnitBuilder builder = null;
		return builder;
	}

}
