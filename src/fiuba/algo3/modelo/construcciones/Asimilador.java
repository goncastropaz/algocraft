package fiuba.algo3.modelo.construcciones;

import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.juego.Jugador;

public class Asimilador extends Construccion {

	private static final String  NOMBRE = "ASIMILADOR";
	private static final Integer COSTO_MINERAL = 100;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 6;
	private static final Integer MAX_VIDA = 450;
	private static final Integer ESCUDO = 450;
	private static final String  UNIDAD = "";
	
	public Asimilador(Posicion pos){
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD,pos);
	}
	
	public void actualizarTurno(Jugador jugador){
		if(this.getConstructionTime().getTurnosRestantes()==0)	jugador.actualizarGasVespeno();
		this.getConstructionTime().actualizarTiempo();
	}

	public boolean esProductorGas() {
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
