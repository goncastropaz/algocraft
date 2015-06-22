package fiuba.algo3.algocraft.acciones.creacionUnidades;

import fiuba.algo3.algocraft.acciones.Ejecutable;
import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.juego.Turno;
import fiuba.algo3.algocraft.unidades.Scout;

public class CrearScout implements Ejecutable{

	@Override
	public boolean ejecutar() throws JugadorInvalido {
		try {
			Celda celda = Turno.getInstance().getObjetivoCelda();
			Scout scout = new Scout(celda.getPosicion());
			Jugador jugador = Juego.getInstance().getActualJugador();
			jugador.agregarUnidad(scout);
			celda.setUnidad(scout);
			return true;
		} catch (FueraDeMatriz e) {
			return false;
		}  catch (CeldaOcupada e) {
			return false;
		}
	}

}
