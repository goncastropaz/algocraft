package fiuba.algo3.modelo.unidades;

import java.util.List;

import fiuba.algo3.modelo.excepciones.FueraDeRango;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;


public abstract class UnidadAerea extends Unidad{

	
	public UnidadAerea(String name, Integer construtionTime, Integer maxHealth, Integer maxShield, Integer vision,Integer suministro){
		super(name,construtionTime,maxHealth,maxShield,vision,suministro);
	}
	
	public boolean permitidaEnArea(Celda celda){
		return true;
	}
	
	public void recibirAtaque(Juego juego, Unidad unidad) throws FueraDeRango{
		boolean rangoValido = false;
		List<Celda> celdas = juego.getMapaDeJuego().devolverCeldasRadio(unidad.getUbicacion(), unidad.getRango().getRangoAerea());
		for(Celda celda : celdas){
			if(this.ubicacion.equals(celda.getPosicion())) rangoValido = true;
		}
		if(!rangoValido){
			throw new FueraDeRango();
		}
		int danioA = unidad.getDanio().getDanioAereo();
		this.recibirAtaque(danioA);
	}
}
