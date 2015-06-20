package fiuba.algo3.algocraft.constructores.construcciones;

import java.util.Map;

import fiuba.algo3.algocraft.construcciones.Construccion;
import fiuba.algo3.algocraft.constructores.unidades.ConstructorDeUnidadesDeRaza;
import fiuba.algo3.algocraft.utils.Constants;

public class RaceBuildingBuilder {

	protected Map<String,Construccion> raceBuildingMap;
	protected ConstructorDeUnidadesDeRaza raceUnitBuilder;
	
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
	
	public static ConstructorDeUnidadesDeRaza getRaceUnitBuilder(Integer raceId) {
		// = metodo con xml builder;
		ConstructorDeUnidadesDeRaza builder = null;
		return builder;
	}

}
