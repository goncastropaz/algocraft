package fiuba.algo3.algocraft.acciones.creacionConstrucciones;

import fiuba.algo3.algocraft.acciones.Ejecutable;
import fiuba.algo3.algocraft.construcciones.NexoMineral;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;

public class CrearNexoMineral implements Ejecutable{

	@Override
	public boolean ejecutar() throws JugadorInvalido {
		try {
			Celda celda = Juego.getInstance().getActualCelda();
			NexoMineral construccion = new NexoMineral(celda.getPosicion());
			Jugador jugador = Juego.getInstance().getActualJugador();
			jugador.agregarConstruccion(construccion);
			return true;
		} catch (FueraDeMatriz e) {
			return false;
		}
	}

}