package fiuba.algo3.modelo.construcciones;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;

public class ArchivoTemplario extends Construccion {

	private static final String  NOMBRE = "ARCHIVO_TEMPLARIO";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 200;
	private static final Integer TIEMPO_CONSTRUCCION = 9;
	private static final Integer MAX_VIDA = 500;
	private static final Integer ESCUDO = 500;
	private static final String  UNIDAD = "";
	
	public ArchivoTemplario() {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD);
	}

}
