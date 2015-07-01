package fiuba.algo3.modelo.magias;

import java.util.ArrayList;

import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Mapa;


public class Radiacion extends Magia {
	
	private static int radio = 1;
	private static Integer energiaRequerida =75;
	private static int danio =10;


	public Radiacion(Energia energiaDeNave) throws EnergiaInsuficiente{
		if(energiaDeNave.esMenor(this.energiaRequerida)) throw new EnergiaInsuficiente();
	}
	
	public void emitirRadiacion(Posicion posImpacto,Mapa mapa) {
		Celda celdaImpacto = mapa.devolverCelda(posImpacto);
		if(celdaImpacto.getUnidad() != null) celdaImpacto.getUnidad().destruir();
		ArrayList<Celda> listaDeCeldas = mapa.devolverCeldasRadio(posImpacto,radio);
		for(int i = 0; i<listaDeCeldas.size(); i++){
			if(listaDeCeldas.get(i).getUnidad() != null) listaDeCeldas.get(i).getUnidad().radiacion(danio);
			
		}
	}
	
}
