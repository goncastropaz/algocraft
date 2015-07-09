package fiuba.algo3.modelo.unidades;

import java.util.List;

import fiuba.algo3.modelo.excepciones.FueraDeRango;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;

public abstract class UnidadTerrestre extends Unidad{

	public UnidadTerrestre(String name, Integer construtionTime, Integer maxHealth, Integer maxShield,Integer vision,Integer suministro, Integer transporte) {
		super(name,construtionTime,maxHealth,maxShield,vision,suministro, transporte);
	}
	
	public boolean permitidaEnArea(Celda celda){
		if( celda.isEspacial()) return false;
		return true;
	}
	
	public void recibirAtaque(Juego juego, Unidad unidad) throws FueraDeRango{
		boolean rangoValido = false;
		List<Celda> celdas = juego.getMapaDeJuego().devolverCeldasRadio(unidad.getUbicacion(), unidad.getRango().getRangoTierra());
		for(Celda celda : celdas){
			if(this.ubicacion.equals(celda.getPosicion())) rangoValido = true;
		}
		if(!rangoValido){
			throw new FueraDeRango();
		}
		int danioT = unidad.getDanio().getDanioTerrestre();
		this.recibirAtaque(danioT);
	}
	
	public boolean puedeTransportar(){
		return false;
	}
}
