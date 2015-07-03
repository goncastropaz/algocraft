package fiuba.algo3.modelo.construcciones;

import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.modelo.unidades.Scout;

public class PuertoEstelarProtoss extends Construccion {

	private static final String  NOMBRE = "PUERTO_ESTELAR_PROTOSS";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 150;
	private static final Integer TIEMPO_CONSTRUCCION = 10;
	private static final Integer MAX_VIDA = 600;
	private static final Integer ESCUDO = 600;
	private static final String  UNIDAD = "";
		
	public PuertoEstelarProtoss(Posicion pos){
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD,pos);
	}
	
	public void crearScout(Juego juego) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente{
		
		Scout unidad = new Scout();
		juego.agregarUnidad(unidad, this.ubicacion);
	}
	
	public void crearNaveTransporte(Juego juego) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente{
	
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		juego.agregarUnidad(unidad, this.ubicacion);
	}

	@Override
	public void recibirAtaque(Danio danio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarPoblacion(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

}
