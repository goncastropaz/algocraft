package fiuba.algo3.modelo.magias;

import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinConstruccion;
import fiuba.algo3.modelo.excepciones.EdificioNoPuedeCrearUnidad;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.Unidad;


public class Alucinacion extends Magia {
	
	private Energia energiaDeNave;
	private static Integer energiaRequerida =100;
	
	public Alucinacion(Energia energiaDeUnidad) throws EnergiaInsuficiente{
		if(energiaDeNave.esMenor(energiaRequerida)) throw new EnergiaInsuficiente();
		else{
			energiaDeUnidad.reducirEnergia(energiaRequerida);
		}
	}
	
	public void generarAlucinacion(Posicion pos,Juego juego) throws RecursosInsuficientes, PoblacionInsuficiente, CeldaOcupada {
		Unidad unidadACopiar = juego.getMapaDeJuego().devolverCelda(pos).getUnidad();
		Unidad unidadCopia1 = unidadACopiar.generarCopia();
		juego.agregarUnidadCopia(unidadCopia1, unidadACopiar.getUbicacion());
		Unidad unidadCopia2 = unidadACopiar.generarCopia();
		juego.agregarUnidadCopia(unidadCopia2, unidadACopiar.getUbicacion());
	}

	
}
