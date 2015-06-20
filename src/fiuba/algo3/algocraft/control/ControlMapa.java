package fiuba.algo3.algocraft.control;

import fiuba.algo3.algocraft.acciones.Ejecutable;
import fiuba.algo3.algocraft.construcciones.FabricaDeUnidades;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.unidades.IUnidad;

public class ControlMapa {

	Mapa mapa;

	public ControlMapa() throws FueraDeMatriz {
		mapa = Mapa.getInstance();
	}

	public boolean crearEdificio(Ejecutable ejecutable) {
		// TODO: Ver qu� le devuelvo a la vista
		return ejecutable.ejecutar();
	}

	public IUnidad crearUnidad(FabricaDeUnidades fabrica) throws FueraDeMatriz {
		//Ahora devuelve la interfaz de la unidad, ver qu� hacemos con esto.
		IUnidad unidad = fabrica.crearUnidad(Juego.getInstance()
				.getActualCelda().getPosicion());
		
		return unidad;
	}
	
	// seleccionar celda
	// Atacar 
	// mover unidad o edificio.
	

}
