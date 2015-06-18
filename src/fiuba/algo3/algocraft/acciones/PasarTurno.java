package fiuba.algo3.algocraft.acciones;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Turno;

public class PasarTurno implements Ejecutable{

	@Override
	public boolean ejecutar() {
		try{
			Turno.getInstance().cambiarTurnoJugador();
			return true;
		} catch (FueraDeMatriz e) {
			e.printStackTrace();
				return false;
		}catch (JugadorInvalido e) {
			return false;
		}
	}	
	
	
}
