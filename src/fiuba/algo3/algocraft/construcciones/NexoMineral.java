package fiuba.algo3.algocraft.construcciones;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.classes.stats.Posicion;

public class NexoMineral extends Construccion {

	private static final String  NOMBRE = "NEXO_MINERAL";
	private static final Integer COSTO_MINERAL = 50;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 4;
	private static final Integer MAX_VIDA = 250;
	private static final Integer ESCUDO = 250;
	private static final String  UNIDAD = "";

	public NexoMineral(Posicion posicion) throws FueraDeMatriz {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD, posicion);
	}
	
	public void actualizarTurno(Jugador jugador){
		if(this.getConstructionTime().getTurnosRestantes()==0)	jugador.actualizarMineral();
		this.getConstructionTime().actualizarTiempo();
}


}
