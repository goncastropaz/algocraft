package fiuba.algo3.algocraft.magias;

import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Energia;


public class Alucinacion extends Magia {
	
	private Energia energiaDeNave;
	
	public Alucinacion(Energia energiaDeUnidad,Mapa mapa){
		super(mapa);
		this.energiaDeNave = energiaDeNave;
	}

	public void tirarMagia(Unidad unidadCopia){
		unidadCopia.setCopia();
	}
}
