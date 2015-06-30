package fiuba.algo3.modelo.acciones.creacionConstrucciones;

import fiuba.algo3.modelo.acciones.Ejecutable;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Acceso;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;

public class CrearAcceso extends Ejecutable{
	
	public CrearAcceso(Juego juego){
		super(juego);
	}

	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial {
		Acceso construccion = new Acceso();
		this.juego.agregarConstruccion(construccion, pos);
		
		
	}


}
