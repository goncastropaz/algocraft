package fiuba.algo3.modelo.magias;

import java.util.ArrayList;

import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Mapa;


public class TormentaPsionica extends Magia {

	private static int radio = 2;
	private static Integer energiaRequerida =75;
	private static int danio = 100;
	private int turno;
	private ArrayList<Celda> listaDeCeldasImpactadas;

	public TormentaPsionica(Energia energiaDeNave,Posicion posImpacto,Mapa mapa) throws EnergiaInsuficiente{
		if(energiaDeNave.esMenor(this.energiaRequerida)) throw new EnergiaInsuficiente();
		else {
			Celda celdaImpacto = mapa.devolverCelda(posImpacto);
			this.listaDeCeldasImpactadas = mapa.devolverCeldasRadio(celdaImpacto.getPosicion(),radio);
			energiaDeNave.reducirEnergia(energiaRequerida);
			this.turno =0;
		}
	}
	
	public void provocarTormenta(){
		
		for(int i = 0; i<listaDeCeldasImpactadas.size(); i++){
			if(listaDeCeldasImpactadas.get(i).getUnidad() != null) listaDeCeldasImpactadas.get(i).getUnidad().tormentaPsionica(danio);
			
		}
		
		if(this.turno == 0 )this.turno = 1; //si es 0 es que es la primera vez que lo ejecuta.
		if(this.turno ==1) this.turno =0; //si es 1 es que ya lo ejecuto.

		
	}
	
	public int getTurno(){
		return this.turno;
	}
	
	

}
