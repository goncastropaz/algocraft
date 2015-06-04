package fiuba.algo3.classes.builders.buildings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiuba.algo3.classes.builders.units.TerranUnitBuilder;
import fiuba.algo3.classes.buildings.RaceBuilding;
import fiuba.algo3.utils.Constants;

public class TerranBuildingBuilder extends RaceBuildingBuilder {

	private static final String SUPPLY_DEPOT = "SupplyDepot";

	public TerranBuildingBuilder() {
		super();
		raceBuildingMap = getTerranBuildingMap();
		raceUnitBuilder = new TerranUnitBuilder();
	}
	
	private Map<String,RaceBuilding> getTerranBuildingMap(){
		Map<String,RaceBuilding> raceBuildingMap = new HashMap<String,RaceBuilding>();
		List<RaceBuilding> raceBuildingList = xmlReader.getBuildings(Constants.TERRAN_BUILDING_XML);
		for(RaceBuilding raceBuilding : raceBuildingList){
			raceBuildingMap.put(raceBuilding.getName(), raceBuilding);
		}
		return raceBuildingMap;
	}

	public RaceBuilding buildSupplyDeploy() {
		//deberia devolver una nueva instancia igual a la que saca del map
		return raceBuildingMap.get(SUPPLY_DEPOT);
	}
	
}
