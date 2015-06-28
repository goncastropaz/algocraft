package fiuba.algo3.algocraft.acciones.creacionConstrucciones;

import fiuba.algo3.algocraft.acciones.Ejecutable;
import fiuba.algo3.algocraft.construcciones.Pilon;
import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.excepciones.celdaSinRecurso;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.classes.stats.Posicion;

public class CrearPilon extends Ejecutable{

	public CrearPilon(Juego juego){
		super(juego);
	}
	
	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada, celdaSinRecurso  {
		Pilon construccion = new Pilon();
		this.juego.agregarConstruccion(construccion,pos);

	}

}
