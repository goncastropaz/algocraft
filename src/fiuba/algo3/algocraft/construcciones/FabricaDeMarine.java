package fiuba.algo3.algocraft.construcciones;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.unidades.IUnidad;
import fiuba.algo3.algocraft.unidades.Marine;
import fiuba.algo3.classes.stats.Posicion;

public class FabricaDeMarine extends FabricaDeUnidades {

	@Override
	public IUnidad crearUnidad(Posicion posicion) throws FueraDeMatriz {
		return new Marine(posicion);
	}

}