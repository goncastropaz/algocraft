package fiuba.algo3.modelo.magias;

import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.unidades.Unidad;


public class Alucinacion extends Magia {
	
	private Energia energiaDeNave;
	private static Integer energiaRequerida =100;
	
	public Alucinacion(Energia energiaDeUnidad) throws EnergiaInsuficiente{
		if(energiaDeNave.esMenor(this.energiaRequerida)) throw new EnergiaInsuficiente();
		else{
			energiaDeUnidad.reducirEnergia(this.energiaRequerida);
		}
	}
	
	public void generarAlucinacion(Unidad unidadACopiar,Juego juego) throws CeldaOcupada, CeldaEspacial{
		Unidad unidadCopia1 = unidadACopiar.generarCopia();
		juego.agregarUnidad(unidadCopia1, unidadACopiar.getUbicacion());
		Unidad unidadCopia2 = unidadACopiar.generarCopia();
		juego.agregarUnidad(unidadCopia2, unidadACopiar.getUbicacion());
	}

	
}
