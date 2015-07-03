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
import fiuba.algo3.modelo.unidades.Marine;


public class Barraca extends Construccion {
	
	private static final String  NOMBRE = "BARRACA";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 12;
	private static final Integer MAX_VIDA = 1000;
	private static final Integer ESCUDO = 0;
	private static final String  UNIDAD = "Marine" ;

	public Barraca(Posicion pos)  {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,ESCUDO, UNIDAD,pos);
	}
	
	public void crearMarine(Juego juego) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente{
			
		Marine marine = new Marine();
		juego.agregarUnidad(marine, this.ubicacion);
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
