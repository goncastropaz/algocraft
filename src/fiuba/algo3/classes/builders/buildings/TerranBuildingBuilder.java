package fiuba.algo3.classes.builders.buildings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiuba.algo3.classes.builders.units.ConstructorDeUnidadesTerran;
import fiuba.algo3.classes.buildings.Construccion;

public class TerranBuildingBuilder extends RaceBuildingBuilder {

	private static final String SUPPLY_DEPOT = "SupplyDepot";

	public TerranBuildingBuilder() {
		super();
		raceBuildingMap = getTerranBuildingMap();
		raceUnitBuilder = new ConstructorDeUnidadesTerran();
	}
	
	private Map<String,Construccion> getTerranBuildingMap(){
		Map<String,Construccion> raceBuildingMap = new HashMap<String,Construccion>();
		List<Construccion> raceBuildingList = new ArrayList<Construccion>();
		for(Construccion raceBuilding : raceBuildingList){
			raceBuildingMap.put(raceBuilding.getName(), raceBuilding);
		}
		return raceBuildingMap;
	}

	public Construccion buildSupplyDeploy() {
		//deberia devolver una nueva instancia igual a la que saca del map
		return raceBuildingMap.get(SUPPLY_DEPOT);
	}
	
}
