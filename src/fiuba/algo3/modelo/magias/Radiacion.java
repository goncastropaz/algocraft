package fiuba.algo3.modelo.magias;

import java.util.ArrayList;

import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Mapa;


public class Radiacion extends Magia {
	
	private static int radio = 1;
	private static Integer energiaRequerida =75;
	private static int danio =10;
	private Energia energiaDeNave;

	public Radiacion(Energia energiaDeNave){
		this.energiaDeNave = energiaDeNave;
	}
	
	public void emitirRadiacion(Celda celdaImpacto,Mapa mapa) throws FueraDeMatriz{
		if(celdaImpacto.getUnidad() != null) celdaImpacto.getUnidad().destruir();
		ArrayList<Celda> listaDeCeldas = mapa.devolverCeldasRadio(celdaImpacto.getPosicion(),radio);
		for(int i = 0; i<listaDeCeldas.size(); i++){
			if(listaDeCeldas.get(i).getUnidad() != null) listaDeCeldas.get(i).getUnidad().radiacion(danio);
			
		}
		this.energiaDeNave.reducirEnergia(energiaRequerida);
	}
	
}
