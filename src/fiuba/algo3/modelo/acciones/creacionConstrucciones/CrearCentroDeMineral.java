package fiuba.algo3.modelo.acciones.creacionConstrucciones;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;

public class CrearCentroDeMineral extends CrearConstruccion{
	
	public CrearCentroDeMineral(Juego juego){
		super(juego);
	}

	@Override
	public void crearConstruccion(Posicion pos) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial  {
		CentroDeMineral construccion = new CentroDeMineral(pos);
		this.juego.agregarConstruccion(construccion,pos);

	}

}
