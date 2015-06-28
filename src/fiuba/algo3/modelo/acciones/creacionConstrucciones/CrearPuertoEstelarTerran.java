package fiuba.algo3.modelo.acciones.creacionConstrucciones;

import fiuba.algo3.modelo.acciones.Ejecutable;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.PuertoEstelarTerran;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;

public class CrearPuertoEstelarTerran extends Ejecutable{

	public CrearPuertoEstelarTerran(Juego juego){
		super(juego);
	}
	
	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada, CeldaSinRecurso  {
		PuertoEstelarTerran construccion = new PuertoEstelarTerran();
		this.juego.agregarConstruccion(construccion,pos);
	
	}

}
