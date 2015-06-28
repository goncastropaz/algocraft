package fiuba.algo3.modelo.construcciones;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Jugador;

public class DepositoSuministro extends Construccion {

	private static final String  NOMBRE = "DEPOSITO_SUMINISTRO";
	private static final Integer COSTO_MINERAL = 100;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 6;
	private static final Integer MAX_VIDA = 500;
	private static final Integer ESCUDO = 0;
	private static final String  UNIDAD = "";
	
	public DepositoSuministro() {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD);
	}
	
	public void actualizarPoblacion(Jugador jugador) {
		jugador.agregarPoblacion();
		
	}
}
