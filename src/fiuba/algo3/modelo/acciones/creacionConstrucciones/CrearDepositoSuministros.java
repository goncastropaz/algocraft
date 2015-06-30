package fiuba.algo3.modelo.acciones.creacionConstrucciones;

import fiuba.algo3.modelo.acciones.Ejecutable;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;

public class CrearDepositoSuministros extends Ejecutable{

	public CrearDepositoSuministros(Juego juego){
		super(juego);
	}
	
	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial  {

		DepositoSuministro construccion = new DepositoSuministro();
		this.juego.agregarConstruccion(construccion,pos);


	}

}
