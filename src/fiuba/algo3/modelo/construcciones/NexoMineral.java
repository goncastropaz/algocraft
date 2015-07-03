package fiuba.algo3.modelo.construcciones;

import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.juego.Jugador;

public class NexoMineral extends Construccion {

	private static final String  NOMBRE = "NEXO_MINERAL";
	private static final Integer COSTO_MINERAL = 50;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 4;
	private static final Integer MAX_VIDA = 250;
	private static final Integer ESCUDO = 250;
	private static final String  UNIDAD = "";

	public NexoMineral(Posicion pos) {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD,pos);
	}
	
	public void actualizarTurno(Jugador jugador){
		if(this.getConstructionTime().getTurnosRestantes()==0)	jugador.actualizarMineral();
		this.getConstructionTime().actualizarTiempo();
	}

	public boolean esProductorMineral() {
		return true;
	}

	@Override
	public void recibirAtaque(Danio danio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarPoblacion(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}


}
