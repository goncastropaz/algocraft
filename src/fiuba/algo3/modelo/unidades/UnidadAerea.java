package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.CostoDeRecursos;
import fiuba.algo3.modelo.complementos.Escudo;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.juego.Celda;

public abstract class UnidadAerea extends Unidad{

	
	public UnidadAerea(String name, Integer construtionTime, Integer maxHealth, Integer maxShield, Integer vision,Integer suministro,Posicion pos){
		super(name,construtionTime,maxHealth,maxShield,vision,suministro,pos);
	}
	
	public void ataque(Unidad unidadAtacante){
		int danio = unidadAtacante.getDanioAereo();
		Integer escudoActual = this.getEscudo().getEscudoActual();
		if(escudoActual> danio){
			this.getEscudo().setEscudoActual(escudoActual-danio);
		}else{
			this.getEscudo().setEscudoActual(0);
			this.vida.setVidaActual(this.getVida().getVidaActual()-(danio-escudoActual));
		}
		//actualizar poblacion y destruir
	}
}
