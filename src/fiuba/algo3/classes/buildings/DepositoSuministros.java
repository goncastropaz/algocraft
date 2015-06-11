package fiuba.algo3.classes.buildings;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class DepositoSuministros extends Construccion {

	private static final String  NOMBRE = "DEPOSITO_SUMINISTROS";
	private static final Integer COSTO_MINERAL = 100;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 6;
	private static final Integer MAX_VIDA = 500;
	private static final Integer ESCUDO = 0;
	private static final String  UNIDAD = "";
	
	public DepositoSuministros(Posicion posicion) throws FueraDeMatriz {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD, posicion);
	}

}
