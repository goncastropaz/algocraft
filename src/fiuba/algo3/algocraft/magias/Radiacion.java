package fiuba.algo3.algocraft.magias;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Energia;


public class Radiacion extends Magia {
	
	private static int radio = 1;
	private static Integer energiaRequerida =75;
	private static int danio =10;
	private Energia energiaDeNave;

	public Radiacion(Energia energiaDeNave, Mapa mapa){
		super(mapa);
		this.energiaDeNave = energiaDeNave;
	}
	
	public void emitirRadiacion(Celda celdaImpacto) throws FueraDeMatriz{
		if(celdaImpacto.getUnidad() != null) celdaImpacto.getUnidad().destruir();
		ArrayList<Celda> listaDeCeldas = this.mapa.devolverCeldasRadio(celdaImpacto.getPosicion(),radio);
		for(int i = 0; i<listaDeCeldas.size(); i++){
			if(listaDeCeldas.get(i).getUnidad() != null) listaDeCeldas.get(i).getUnidad().radiacion(danio);
			
		}
		this.energiaDeNave.reducirEnergia(energiaRequerida);
	}
	
}
