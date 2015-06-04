package fiuba.algo3.classes.builders.units;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiuba.algo3.classes.units.RaceUnit;
import fiuba.algo3.utils.Constants;

public class TerranUnitBuilder extends RaceUnitBuilder {

	public TerranUnitBuilder() {
		super();
		raceUnitMap = getTerranBuildingMap();
	}

	private Map<String,RaceUnit> getTerranBuildingMap(){
		Map<String,RaceUnit> raceUnitMap = new HashMap<String,RaceUnit>();
		List<RaceUnit> raceUnitList = xmlReader.getUnits(Constants.TERRAN_UNIT_XML);
		for(RaceUnit raceUnit : raceUnitList){
			raceUnitMap.put(raceUnit.getName(), raceUnit);
		}
		return raceUnitMap;
	}
}
