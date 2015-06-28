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
import fiuba.algo3.modelo.unidades.Espectro;
import fiuba.algo3.modelo.unidades.Golliat;

public class CrearGolliat extends Ejecutable{

	public CrearGolliat(Juego juego){
		super(juego);
	}
	
	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada{
		Golliat golliat = new Golliat();
		this.juego.agregarUnidad(golliat, pos);

	}
	

}
