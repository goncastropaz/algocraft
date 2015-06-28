package fiuba.algo3.modelo.magias;

import java.util.ArrayList;

import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Mapa;


public class TormentaPsionica extends Magia {

	private static int radio = 2;
	private static Integer energiaRequerida =75;
	private Energia energiaDeNave;
	private static int danio = 100;
	private int turno;
	private ArrayList<Celda> listaDeCeldasImpactadas;

	public TormentaPsionica(Energia energiaDeNave, Mapa mapa){
		super(mapa);
		this.energiaDeNave = energiaDeNave;
		this.turno =0;
	}
	
	public void provocarTormenta(Celda celdaImpacto) throws FueraDeMatriz{
		
		if(celdaImpacto.getUnidad() != null) celdaImpacto.getUnidad().destruir();
		ArrayList<Celda> listaDeCeldas = this.mapa.devolverCeldasRadio(celdaImpacto.getPosicion(),radio);
		for(int i = 0; i<listaDeCeldas.size(); i++){
			if(listaDeCeldas.get(i).getUnidad() != null) listaDeCeldas.get(i).getUnidad().tormentaPsionica(danio);
			
		}
		this.energiaDeNave.reducirEnergia(energiaRequerida);
		if(this.turno == 0 )this.turno = 1; //si es 0 es que es la primera vez que lo ejecuta.
		if(this.turno ==1) this.turno =0; //si es 1 es que ya lo ejecuto.

		
	}
	
	public int getTurno(){
		return this.turno;
	}
	
	

}
