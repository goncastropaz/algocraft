package fiuba.algo3.classes.buildings;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;


public class Barraca extends RaceBuilding {

	public Barraca(String name, Integer mineralCost, Integer gasCost,
			Integer construtionTime, Integer maxHealth, Integer maxShield, String unit,  Integer coordenadaX, Integer coordenadaY) throws FueraDeMatriz {
		super(name, mineralCost, gasCost, construtionTime, maxHealth, maxShield, unit, coordenadaX, coordenadaY);
	}

}
