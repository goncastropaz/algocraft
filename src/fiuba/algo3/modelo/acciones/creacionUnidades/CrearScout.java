package fiuba.algo3.modelo.acciones.creacionUnidades;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Turno;
import fiuba.algo3.modelo.unidades.NaveTransporteTerran;
import fiuba.algo3.modelo.unidades.Scout;

public class CrearScout extends CrearUnidad{

	public CrearScout(Juego juego){
		super(juego);
	}
	
	@Override
	public void crearUnidad(Posicion pos) throws CeldaOcupada, CeldaEspacial{
		Scout scout = new Scout();
		this.juego.agregarUnidad(scout, pos);

	}
	

}
