package fiuba.algo3.modelo.complementos;

import fiuba.algo3.modelo.excepciones.FueraDeRango;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.Unidad;

public interface Daniable {
	
	public void recibirAtaque(Juego juego, Unidad unidad) throws FueraDeRango;
	
	public void recibirAtaque(Integer danio);

}
