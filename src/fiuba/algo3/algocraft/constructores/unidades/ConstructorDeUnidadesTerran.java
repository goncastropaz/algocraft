package fiuba.algo3.algocraft.constructores.unidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiuba.algo3.algocraft.constructores.unidades.ConstructorDeUnidadesDeRaza;
import fiuba.algo3.algocraft.unidades.Unidad;

public class ConstructorDeUnidadesTerran extends ConstructorDeUnidadesDeRaza {

	public ConstructorDeUnidadesTerran() {
		super();
		raceUnitMap = getTerranBuildingMap();
	}

	private Map<String,Unidad> getTerranBuildingMap(){
		Map<String,Unidad> raceUnitMap = new HashMap<String,Unidad>();
		List<Unidad> raceUnitList =  new ArrayList<Unidad>();
		for(Unidad raceUnit : raceUnitList){
			raceUnitMap.put(raceUnit.getNombre(), raceUnit);
		}
		return raceUnitMap;
	}
}
