package fiuba.algo3.classes.buildings;

public class CentroDeMineral extends RaceBuilding {

	private static final String  NOMBRE = "CENTRO_DE_MINERAL";
	private static final Integer COSTO_MINERAL = 50;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 4;
	private static final Integer MAX_VIDA = 500;
	private static final Integer ESCUDO = 0;
	private static final String  UNIDAD = "";

	public CentroDeMineral(Integer coordenadaX, Integer coordenadaY) {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD, coordenadaX, coordenadaY);
	}

}
