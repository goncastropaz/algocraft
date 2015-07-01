package fiuba.algo3.modelo.construcciones;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.Dragon;
import fiuba.algo3.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.modelo.unidades.Scout;
import fiuba.algo3.modelo.unidades.Zealot;


public class Acceso extends Construccion {

	private static final String  NOMBRE = "ACCESO";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 8;
	private static final Integer MAX_VIDA = 500;
	private static final Integer ESCUDO = 500;
	private static final String  UNIDAD = "";
	
	public Acceso(Posicion pos) {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD, pos);
	}
	
	public void crearZealot(Juego juego) throws CeldaOcupada, CeldaEspacial{
		
		Zealot unidad = new Zealot();
		juego.agregarUnidad(unidad, this.ubicacion);
	}
	
	public void crearDragon(Juego juego) throws CeldaOcupada, CeldaEspacial{
	
		Dragon unidad = new Dragon();
		juego.agregarUnidad(unidad, this.ubicacion);
	}

}
