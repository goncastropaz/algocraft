package fiuba.algo3.algocraft.acciones;

import fiuba.algo3.algocraft.construcciones.Asimilador;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;

public class CrearAsimilador implements Ejecutable{

	@Override
	public boolean ejecutar() throws JugadorInvalido {
		try {
			Celda celda = Juego.getInstance().getActualCelda();
			Asimilador construccion = new Asimilador(celda.getPosicion());
			Jugador jugador = Juego.getInstance().getActualJugador();
			jugador.agregarConstruccion(construccion);
			return true;
		} catch (FueraDeMatriz e) {
			return false;
		}
	}

}
