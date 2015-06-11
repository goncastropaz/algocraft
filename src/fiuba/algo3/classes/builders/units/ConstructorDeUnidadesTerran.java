package fiuba.algo3.classes.builders.units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiuba.algo3.algocraft.unidades.RaceUnit;
import fiuba.algo3.classes.builders.units.ConstructorDeUnidadesDeRaza;

public class ConstructorDeUnidadesTerran extends ConstructorDeUnidadesDeRaza {

	public ConstructorDeUnidadesTerran() {
		super();
		raceUnitMap = getTerranBuildingMap();
	}

	private Map<String,RaceUnit> getTerranBuildingMap(){
		Map<String,RaceUnit> raceUnitMap = new HashMap<String,RaceUnit>();
		List<RaceUnit> raceUnitList =  new ArrayList<RaceUnit>();
		for(RaceUnit raceUnit : raceUnitList){
			raceUnitMap.put(raceUnit.getNombre(), raceUnit);
		}
		return raceUnitMap;
	}
}
