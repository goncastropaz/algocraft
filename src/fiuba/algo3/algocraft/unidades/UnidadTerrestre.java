package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.classes.stats.Posicion;

public class UnidadTerrestre extends RaceUnit{

	public UnidadTerrestre(String name, Integer mineralCost, Integer gasCost, Integer construtionTime, Integer maxHealth, Integer maxShield, Posicion pos) throws FueraDeMatriz{
		super(name,mineralCost,gasCost,construtionTime,maxHealth,maxShield,pos);
	}
	
	public void setNuevaUbicacion(Celda celda) throws UnidadTerrestreEnAreaEspacial {
		if( celda.isEspacial()) throw new UnidadTerrestreEnAreaEspacial();
		this.ubicacion = celda;
		celda.setUnidad(this);
		
	}
}
