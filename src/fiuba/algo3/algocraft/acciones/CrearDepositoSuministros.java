package fiuba.algo3.algocraft.acciones;

import fiuba.algo3.algocraft.construcciones.DepositoSuministro;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;

public class CrearDepositoSuministros implements Ejecutable{

	@Override
	public boolean ejecutar() throws JugadorInvalido {
		try {
			Celda celda = Juego.getInstance().getActualCelda();
			DepositoSuministro construccion = new DepositoSuministro(celda.getPosicion());
			Jugador jugador = Juego.getInstance().getActualJugador();
			jugador.agregarConstruccion(construccion);
			jugador.agregarPoblacion();
			return true;
		} catch (FueraDeMatriz e) {
			return false;
		}
	}

}
