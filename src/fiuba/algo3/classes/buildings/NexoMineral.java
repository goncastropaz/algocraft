package fiuba.algo3.classes.buildings;

public class NexoMineral extends RaceBuilding {

	private static final String  NOMBRE = "NEXO_MINERAL";
	private static final Integer COSTO_MINERAL = 50;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 4;
	private static final Integer MAX_VIDA = 250;
	private static final Integer ESCUDO = 250;
	private static final String  UNIDAD = "";

	public NexoMineral(Integer coordenadaX, Integer coordenadaY) {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD, coordenadaX, coordenadaY);
	}

}
