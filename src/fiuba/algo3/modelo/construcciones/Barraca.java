package fiuba.algo3.modelo.construcciones;


public class Barraca extends Construccion {
	
	private static final String  NOMBRE = "BARRACA";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 12;
	private static final Integer MAX_VIDA = 1000;
	private static final Integer ESCUDO = 0;
	private static final String  UNIDAD = "Marine" ;

	public Barraca()  {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD);
	}

}
