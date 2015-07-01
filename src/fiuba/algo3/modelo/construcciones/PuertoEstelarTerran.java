package fiuba.algo3.modelo.construcciones;

import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.Espectro;
import fiuba.algo3.modelo.unidades.Golliat;
import fiuba.algo3.modelo.unidades.NaveCiencia;
import fiuba.algo3.modelo.unidades.NaveTransporteTerran;

public class PuertoEstelarTerran  extends Construccion{

	private static final String  NOMBRE = "PUERTO_ESTELAR_TERRAN";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 100;
	private static final Integer TIEMPO_CONSTRUCCION = 10;
	private static final Integer MAX_VIDA = 1300;
	private static final Integer ESCUDO = 0;
	private static final String  UNIDAD = "";
	
	
	public PuertoEstelarTerran(Posicion pos) {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, UNIDAD,pos);
	}
	
	public void crearEspectro(Juego juego) throws CeldaOcupada, CeldaEspacial{
		
		Espectro unidad = new Espectro();
		juego.agregarUnidad(unidad, this.ubicacion);
	}
	
	public void crearNaveTransporte(Juego juego) throws CeldaOcupada, CeldaEspacial{
	
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		juego.agregarUnidad(unidad, this.ubicacion);
	}

	public void crearNaveCiencia(Juego juego) throws CeldaOcupada, CeldaEspacial{
	
		NaveCiencia unidad = new NaveCiencia();
		juego.agregarUnidad(unidad, this.ubicacion);
	}

	@Override
	public void recibirAtaque(Danio danio) {
		// TODO Auto-generated method stub
		
	}

}
