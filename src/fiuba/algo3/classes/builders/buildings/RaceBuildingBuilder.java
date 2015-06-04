package fiuba.algo3.classes.builders.buildings;

import java.util.Map;

import fiuba.algo3.classes.builders.units.RaceUnitBuilder;
import fiuba.algo3.classes.buildings.RaceBuilding;
import fiuba.algo3.utils.Constants;
import fiuba.algo3.xml.reader.XmlReader;

public class RaceBuildingBuilder {

	protected static XmlReader xmlReader = null;
	protected Map<String,RaceBuilding> raceBuildingMap;
	protected RaceUnitBuilder raceUnitBuilder;
	
	protected static XmlReader getXmlReader(){
		if(xmlReader == null){
			xmlReader = new XmlReader();
		}
		return xmlReader;
	}
	
	public static RaceBuildingBuilder getRaceBuildingBuilder(Integer raceId){
		RaceBuildingBuilder raceBuildingBuilder;
		if(raceId.equals(Constants.TERRAN_ID)){
			raceBuildingBuilder = new TerranBuildingBuilder();
		} else if(raceId.equals(Constants.PROTOSS_ID)){
			raceBuildingBuilder = new ProtossBuildingBuilder();
		} else if(raceId.equals(Constants.ZERG_ID)){
			raceBuildingBuilder = new ZergBuildingBuilder();
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
