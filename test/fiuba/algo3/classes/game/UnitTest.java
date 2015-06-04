package fiuba.algo3.classes.game;

import org.junit.Ignore;
import org.junit.Test;

import fiuba.algo3.classes.builders.buildings.RaceBuildingBuilder;
import fiuba.algo3.classes.builders.buildings.TerranBuildingBuilder;
import fiuba.algo3.classes.buildings.RaceBuilding;
import fiuba.algo3.utils.Constants;

public class UnitTest {

	@Ignore
	@Test
	public void createMarineTest(){
		TerranBuildingBuilder builder = (TerranBuildingBuilder) RaceBuildingBuilder.getRaceBuildingBuilder(Constants.TERRAN_ID);
		RaceBuilding building = builder.buildSupplyDeploy();
		
	}
}
