package fiuba.algo3.modelo.acciones.creacionUnidades;

import fiuba.algo3.modelo.acciones.Ejecutable;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Turno;
import fiuba.algo3.modelo.unidades.Golliat;
import fiuba.algo3.modelo.unidades.Marine;


public class CrearMarine extends Ejecutable{

	public CrearMarine(Juego juego){
		super(juego);
	}
	
	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada{
		Marine marine = new Marine();
		this.juego.agregarUnidad(marine, pos);

	}
	

}
