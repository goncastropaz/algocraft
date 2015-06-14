package fiuba.algo3.algocraft.construcciones;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.unidades.IUnidad;
import fiuba.algo3.classes.stats.Posicion;

public abstract class FabricaDeUnidades {
	
	public abstract IUnidad crearUnidad(Posicion posicion) throws FueraDeMatriz;

}
