package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.classes.stats.CostoDeRecursos;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.stats.RangoDeAtaque;

public abstract class UnidadAerea extends Unidad{

	
	public UnidadAerea(String name, Integer construtionTime, Integer maxHealth, Integer maxShield, Integer vision,Integer suministro,Posicion pos) throws FueraDeMatriz{
		super(name,construtionTime,maxHealth,maxShield,vision,suministro,pos);
	}
	

}
