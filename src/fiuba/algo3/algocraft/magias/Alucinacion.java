package fiuba.algo3.algocraft.magias;

import fiuba.algo3.algocraft.unidades.Unidad;


public class Alucinacion extends Magia {

	public void tirarMagia(Unidad unidadCopia){
		unidadCopia.setCopia();
	}
}
