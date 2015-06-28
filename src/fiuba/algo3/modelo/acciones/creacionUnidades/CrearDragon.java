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
import fiuba.algo3.modelo.unidades.AltoTemplario;
import fiuba.algo3.modelo.unidades.Dragon;

public class CrearDragon extends Ejecutable{

	public CrearDragon(Juego juego){
		super(juego);
	}
	
	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada{
		Dragon dragon = new Dragon();
		this.juego.agregarUnidad(dragon, pos);

	}
	
}
