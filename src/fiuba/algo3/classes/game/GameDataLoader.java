package fiuba.algo3.classes.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import javax.xml.stream.XMLStreamReader;

import fiuba.algo3.classes.builders.buildings.RaceBuildingBuilder;
import fiuba.algo3.classes.builders.races.RaceBuilder;
import fiuba.algo3.classes.builders.races.TerranBuilder;
import fiuba.algo3.classes.builders.units.RaceUnitBuilder;
import fiuba.algo3.utils.Constants;

public class GameDataLoader {

	private static final HashMap<Integer,List<String>> xmlMapper = null;
	
	private static HashMap<Integer,List<String>> getXmlMapper(){
		if(xmlMapper == null){
			HashMap<Integer, List<String>> map = new HashMap<Integer,List<String>>();
			map.put(Constants.BUILDINGS, getBuildingsList());
			map.put(Constants.UNITS, getUnitsList());
			return map;
		} else{
			return xmlMapper;
		}
	}
	
	private static List<String> getBuildingsList() {
		List<String> list = new ArrayList<String>();
		list.add(Constants.TERRAN_BUILDING_XML);
		list.add(Constants.PROTOSS_BUILDING_XML);
		list.add(Constants.ZERG_BUILDING_XML);
		return list;
	}
	
	private static List<String> getUnitsList() {
		List<String> list = new ArrayList<String>();
		list.add(Constants.TERRAN_UNIT_XML);
		list.add(Constants.PROTOSS_UNIT_XML);
		list.add(Constants.ZERG_UNIT_XML);
		return list;
	}
	
	public static RaceBuilder getTerranBuilder(){
		RaceBuilder raceBuilder = new TerranBuilder();
		raceBuilder.setRaceBuildingBuilder(getRaceBuildingBuilder(Constants.TERRAN_ID));
		raceBuilder.setRaceUnitBuilder(getRaceUnitBuilder(Constants.TERRAN_ID));
		return raceBuilder;
	}

	private static RaceBuildingBuilder getRaceBuildingBuilder(Integer raceId) {
		String xmlPath = getXmlMapper().get(Constants.UNITS).get(raceId);
		// = metodo con xml builder;
		RaceBuildingBuilder builder = null;
		return builder;
	}
	
	private static RaceUnitBuilder getRaceUnitBuilder(Integer raceId) {
		String xmlPath = getXmlMapper().get(Constants.BUILDINGS).get(raceId);
		// = metodo con xml builder;
		RaceUnitBuilder builder = null;
		return builder;
	}
}
