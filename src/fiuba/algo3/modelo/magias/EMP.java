package fiuba.algo3.modelo.magias;

import java.util.List;

import fiuba.algo3.modelo.complementos.Energia;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Mapa;


public class EMP extends Magia {
	
	private static int radio = 3;
	private static Integer energiaRequerida =100;

	
	public EMP(Energia energiaDeNave) throws EnergiaInsuficiente{

		if(energiaDeNave.esMenor(energiaRequerida)) throw new EnergiaInsuficiente();
		
	}
	
	public void tirarMagia(Posicion pos, Mapa mapa){
		List<Celda> listaDeCeldas = mapa.devolverCeldasRadio(pos,radio);
		for(int i = 0; i<listaDeCeldas.size(); i++){
			if(listaDeCeldas.get(i).getUnidad() != null) listaDeCeldas.get(i).getUnidad().ataqueEMP();
			
		}
	}
}
