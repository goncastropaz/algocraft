package fiuba.algo3.algocraft.construcciones;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.unidades.IUnidad;
import fiuba.algo3.classes.stats.Posicion;


public class Barraca extends Construccion {
	
	private static final String  NOMBRE = "BARRACA";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 12;
	private static final Integer MAX_VIDA = 1000;
	private static final Integer ESCUDO = 0;
	private static final String  UNIDAD = "Marine" ;

	public Barraca(Posicion posicion) throws FueraDeMatriz {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD, posicion);
	}

}
