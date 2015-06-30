package fiuba.algo3.modelo.magias;

import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.unidades.Unidad;


public class Alucinacion extends Magia {
	
	private Energia energiaDeNave;
	
	public Alucinacion(Energia energiaDeUnidad){
		this.energiaDeNave = energiaDeNave;
	}

	public void tirarMagia(Unidad unidadCopia){
		unidadCopia.setCopia();
	}
}
