package fiuba.algo3.modelo.acciones;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.juego.Juego;

public class PasarTurno extends Ejecutable{
	
	public PasarTurno(Juego juego){
		super(juego);
	}

	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada, CeldaSinRecurso{
			this.juego.cambiarTurnoJugador();

	}	
	
	
}
