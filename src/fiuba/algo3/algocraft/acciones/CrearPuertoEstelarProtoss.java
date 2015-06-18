package fiuba.algo3.algocraft.acciones;

import fiuba.algo3.algocraft.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;

public class CrearPuertoEstelarProtoss implements Ejecutable{

	@Override
	public boolean ejecutar() {
		try {
			Celda celda = Juego.getInstance().getActualCelda();
			PuertoEstelarProtoss construccion = new PuertoEstelarProtoss(celda.getPosicion());
			Jugador jugador = Juego.getInstance().getActualJugador();
			jugador.agregarConstruccion(construccion);
			return true;
		} catch (FueraDeMatriz e) {
			return false;
		}
	}

}