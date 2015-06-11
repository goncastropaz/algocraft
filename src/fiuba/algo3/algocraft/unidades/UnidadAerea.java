package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.classes.stats.Posicion;

public class UnidadAerea extends RaceUnit{

	
	public UnidadAerea(String name, Integer mineralCost, Integer gasCost, Integer construtionTime, Integer maxHealth, Integer maxShield, Posicion pos) throws FueraDeMatriz{
		super(name,mineralCost,gasCost,construtionTime,maxHealth,maxShield,pos);
	}
	

}
