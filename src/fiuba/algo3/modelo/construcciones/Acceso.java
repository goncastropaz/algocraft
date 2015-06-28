package fiuba.algo3.modelo.construcciones;


public class Acceso extends Construccion {

	private static final String  NOMBRE = "ACCESO";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 8;
	private static final Integer MAX_VIDA = 500;
	private static final Integer ESCUDO = 500;
	private static final String  UNIDAD = "";
	
	public Acceso() {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD);
	}

}
