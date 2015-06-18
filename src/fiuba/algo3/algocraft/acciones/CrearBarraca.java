package fiuba.algo3.algocraft.acciones;

import fiuba.algo3.algocraft.construcciones.Barraca;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;

public class CrearBarraca implements Ejecutable{

	@Override
	public boolean ejecutar() {
		try {
			Celda celda = Juego.getInstance().getActualCelda();
			Barraca acceso = new Barraca(celda.getPosicion());
			Jugador jugador = Juego.getInstance().getActualJugador();
			jugador.agregarConstruccion(acceso);
			return true;
		} catch (FueraDeMatriz e) {
			return false;
		}
	}

}
