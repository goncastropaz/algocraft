package fiuba.algo3.modelo.construcciones;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.juego.Jugador;

public class Pilon extends Construccion {

	private static final String  NOMBRE = "PILON";
	private static final Integer COSTO_MINERAL = 100;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 5;
	private static final Integer MAX_VIDA = 300;
	private static final Integer ESCUDO = 300;
	private static final String  UNIDAD = "";
	
	public Pilon(Posicion pos) {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD,pos);
	}
	
	@Override
	public void actualizarPoblacion(Jugador jugador) {
		jugador.agregarPoblacion();	
	}

}
