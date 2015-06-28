package fiuba.algo3.algocraft.acciones;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.celdaSinRecurso;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.classes.stats.Posicion;

public class PasarTurno extends Ejecutable{
	
	public PasarTurno(Juego juego){
		super(juego);
	}

	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada, celdaSinRecurso{
			this.juego.cambiarTurnoJugador();

	}	
	
	
}
