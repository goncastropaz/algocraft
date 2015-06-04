package fiuba.algo3.classes.builders.units;

import java.util.Map;

import fiuba.algo3.classes.units.RaceUnit;
import fiuba.algo3.xml.reader.XmlReader;

public class RaceUnitBuilder {

	protected static XmlReader xmlReader = null;
	protected Map<String,RaceUnit> raceUnitMap;
	
	protected static XmlReader getXmlReader(){
		if(xmlReader == null){
			xmlReader = new XmlReader();
		}
		return xmlReader;
	}
}
