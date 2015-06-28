package fiuba.algo3.algocraft.acciones;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.celdaSinRecurso;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.classes.stats.Posicion;

public abstract class Ejecutable {
	
	protected Juego juego;
	
	public Ejecutable(Juego juego){
		this.juego = juego;
	}
	public abstract void ejecutar(Posicion pos) throws CeldaOcupada, celdaSinRecurso;
	
}
