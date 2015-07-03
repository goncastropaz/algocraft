package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.Danio;
import fiuba.algo3.modelo.juego.Celda;


public abstract class UnidadAerea extends Unidad{

	
	public UnidadAerea(String name, Integer construtionTime, Integer maxHealth, Integer maxShield, Integer vision,Integer suministro){
		super(name,construtionTime,maxHealth,maxShield,vision,suministro);
	}
	
	public boolean permitidaEnArea(Celda celda){
		return true;
	}
	
	public void recibirAtaque(Danio danio){
		int danioA = danio.getDanioAereo();
		this.recibirAtaque(danioA);
	}
}
