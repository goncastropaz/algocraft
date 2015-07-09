package fiuba.algo3.modelo.acciones.creacionConstrucciones;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.PuertoEstelarTerran;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.RazaNoTieneConstruccion;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;

public class CrearPuertoEstelarTerran extends CrearConstruccion{

	public CrearPuertoEstelarTerran(Juego juego){
		super(juego);
	}
	
	@Override
	public void crearConstruccion(Posicion pos) throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial, RazaNoTieneConstruccion, RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida  {
		PuertoEstelarTerran construccion = new PuertoEstelarTerran(pos);
		this.juego.agregarConstruccion(construccion,pos);
	
	}

}
