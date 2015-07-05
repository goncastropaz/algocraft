package fiuba.algo3.modelo.construcciones;

import java.util.List;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.AltoTemplario;

public class ArchivoTemplario extends Construccion {

	private static final String  NOMBRE = "ARCHIVO_TEMPLARIO";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 200;
	private static final Integer TIEMPO_CONSTRUCCION = 9;
	private static final Integer MAX_VIDA = 500;
	private static final Integer ESCUDO = 500;
	private static final String  UNIDAD = "";
	
	public ArchivoTemplario(Posicion pos) {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD,pos);
	}

	public void crearAltoTemplario(Juego juego) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente{
		
		AltoTemplario unidad = new AltoTemplario();
		juego.agregarUnidad(unidad, this.ubicacion);
	}
	
	@Override
	public boolean tieneEdificiosPrevios(List<Construccion> construcciones) {
		return tieneConstruccion(construcciones, "ACCESO") && tieneConstruccion(construcciones, "PUERTO_ESTELAR_PROTOSS");
	}

}
