package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.juego.Celda;

public abstract class UnidadTerrestre extends Unidad{

	public UnidadTerrestre(String name, Integer construtionTime, Integer maxHealth, Integer maxShield,Integer vision,Integer suministro) {
		super(name,construtionTime,maxHealth,maxShield,vision,suministro);
	}
	
	public boolean permitidaEnArea(Celda celda){
		if( celda.isEspacial()) return false;
		return true;
	}
	
	public void recibirAtaque(Danio danio){
		int danioT = danio.getDanioTerrestre();
		this.recibirAtaque(danioT);
	}
}
