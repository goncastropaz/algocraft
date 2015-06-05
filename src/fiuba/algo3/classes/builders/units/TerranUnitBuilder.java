package fiuba.algo3.classes.builders.units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiuba.algo3.classes.units.RaceUnit;

public class TerranUnitBuilder extends RaceUnitBuilder {

	public TerranUnitBuilder() {
		super();
		raceUnitMap = getTerranBuildingMap();
	}

	private Map<String,RaceUnit> getTerranBuildingMap(){
		Map<String,RaceUnit> raceUnitMap = new HashMap<String,RaceUnit>();
		List<RaceUnit> raceUnitList =  new ArrayList<RaceUnit>();
		for(RaceUnit raceUnit : raceUnitList){
			raceUnitMap.put(raceUnit.getName(), raceUnit);
		}
		return raceUnitMap;
	}
}
