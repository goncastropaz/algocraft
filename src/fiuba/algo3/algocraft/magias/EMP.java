package fiuba.algo3.algocraft.magias;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.EnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.algocraft.unidades.NaveCiencia;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.classes.stats.Energia;


public class EMP extends Magia {
	
	private static int radio = 3;
	private static Integer energiaRequerida =100;
	private Energia energiaDeNave;
	
	public EMP(Energia energiaDeNave,Mapa mapa){
		super(mapa);
		this.energiaDeNave = energiaDeNave;
		
	}
	
	public void tirarMagia(NaveCiencia nave, Celda celdaImpacto) throws FueraDeMatriz{
		ArrayList<Celda> listaDeCeldas = this.mapa.devolverCeldasRadio(celdaImpacto.getPosicion(),this.radio);
		for(int i = 0; i<listaDeCeldas.size(); i++){
			if(listaDeCeldas.get(i).getUnidad() != null) listaDeCeldas.get(i).getUnidad().ataqueEMP();
			
		}
		this.energiaDeNave.reducirEnergia(this.energiaRequerida);
	}
}
