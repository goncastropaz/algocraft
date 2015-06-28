package fiuba.algo3.modelo.acciones.creacionConstrucciones;

import fiuba.algo3.modelo.acciones.Ejecutable;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;

public class CrearPuertoEstelarProtoss extends Ejecutable{

	public CrearPuertoEstelarProtoss(Juego juego){
		super(juego);
	}
		
	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada, CeldaSinRecurso{
		PuertoEstelarProtoss construccion = new PuertoEstelarProtoss();
		this.juego.agregarConstruccion(construccion,pos);

	}

}