package fiuba.algo3.algocraft.construcciones;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.classes.stats.Posicion;

public class Asimilador extends Construccion {

	private static final String  NOMBRE = "ASIMILADOR";
	private static final Integer COSTO_MINERAL = 100;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 6;
	private static final Integer MAX_VIDA = 450;
	private static final Integer ESCUDO = 450;
	private static final String  UNIDAD = "";
	
	public Asimilador(){
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD);
	}
	
	public void actualizarTurno(Jugador jugador){
		if(this.getConstructionTime().getTurnosRestantes()==0)	jugador.actualizarGasVespeno();
		this.getConstructionTime().actualizarTiempo();
	}

	public boolean esProductorGas() {
		return true;
	}
}
