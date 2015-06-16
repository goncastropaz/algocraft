package fiuba.algo3.algocraft.construcciones;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.classes.stats.Posicion;

public class PuertoEstelarProtoss extends Construccion {

	private static final String  NOMBRE = "PUERTO_ESTELAR_PROTOSS";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 150;
	private static final Integer TIEMPO_CONSTRUCCION = 10;
	private static final Integer MAX_VIDA = 600;
	private static final Integer ESCUDO = 600;
	private static final String  UNIDAD = "";
		
	public PuertoEstelarProtoss(Posicion posicion) throws FueraDeMatriz {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD, posicion);
	}

}
