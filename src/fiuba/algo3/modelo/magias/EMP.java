package fiuba.algo3.modelo.magias;

import java.util.ArrayList;

import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Mapa;
import fiuba.algo3.modelo.unidades.NaveCiencia;
import fiuba.algo3.modelo.unidades.Unidad;


public class EMP extends Magia {
	
	private static int radio = 3;
	private static Integer energiaRequerida =100;
	private Energia energiaDeNave;
	
	public EMP(Energia energiaDeNave){

		this.energiaDeNave = energiaDeNave;
		
	}
	
	public void tirarMagia(NaveCiencia nave, Celda celdaImpacto, Mapa mapa) throws FueraDeMatriz{
		ArrayList<Celda> listaDeCeldas = mapa.devolverCeldasRadio(celdaImpacto.getPosicion(),this.radio);
		for(int i = 0; i<listaDeCeldas.size(); i++){
			if(listaDeCeldas.get(i).getUnidad() != null) listaDeCeldas.get(i).getUnidad().ataqueEMP();
			
		}
		this.energiaDeNave.reducirEnergia(this.energiaRequerida);
	}
}
