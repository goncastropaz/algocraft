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
import fiuba.algo3.algocraft.unidades.Zealot;
import fiuba.algo3.classes.stats.Posicion;

public class CrearZealot extends Ejecutable{


	public CrearZealot(Juego juego){
		super(juego);
	}
	
	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada{
		Zealot zealot = new Zealot();
		this.juego.agregarUnidad(zealot, pos);

	}
	
}
