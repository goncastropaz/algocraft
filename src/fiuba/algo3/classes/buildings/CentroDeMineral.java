package fiuba.algo3.classes.buildings;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class CentroDeMineral extends Construccion {

	private static final String  NOMBRE = "CENTRO_DE_MINERAL";
	private static final Integer COSTO_MINERAL = 50;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 4;
	private static final Integer MAX_VIDA = 500;
	private static final Integer ESCUDO = 0;
	private static final String  UNIDAD = "";

	public CentroDeMineral(Posicion posicion) throws FueraDeMatriz {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD, posicion);
	}

}
