package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.RangoDeAtaque;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Celda;

public abstract class UnidadTerrestre extends Unidad{

	public UnidadTerrestre(String name, Integer construtionTime, Integer maxHealth, Integer maxShield,Integer vision,Integer suministro) {
		super(name,construtionTime,maxHealth,maxShield,vision,suministro);
	}
	
	
	public boolean permitidaEnArea(Celda celda){
		if( celda.isEspacial()) return false;
		return true;
	}
	
	public void ataque(Unidad unidadAtacante){
		int danio = unidadAtacante.getDanioTerrestre();
		Integer escudoActual = this.getEscudo().getEscudoActual();
		if(escudoActual> danio){
			this.getEscudo().setEscudoActual(escudoActual-danio);
		}else{
			this.getEscudo().setEscudoActual(0);
			this.vida.setVidaActual(this.getVida().getVidaActual()-(danio-escudoActual));
		}
	}
}
