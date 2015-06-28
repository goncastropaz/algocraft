package fiuba.algo3.modelo.construcciones;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;

public class Fabrica extends Construccion {

	private static final String  NOMBRE = "FABRICA";
	private static final Integer COSTO_MINERAL = 200;
	private static final Integer COSTO_GAS = 100;
	private static final Integer TIEMPO_CONSTRUCCION = 12;
	private static final Integer MAX_VIDA = 1250;
	private static final Integer ESCUDO = 0;
	private static final String  UNIDAD = "";
	
	public Fabrica(){
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD);
	}

}
