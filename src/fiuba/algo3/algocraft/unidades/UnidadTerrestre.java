package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.classes.stats.CostoDeRecursos;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.stats.RangoDeAtaque;

public abstract class UnidadTerrestre extends Unidad{

	public UnidadTerrestre(String name, Integer construtionTime, Integer maxHealth, Integer maxShield,Integer vision,Integer suministro, Posicion pos) throws FueraDeMatriz{
		super(name,construtionTime,maxHealth,maxShield,vision,suministro,pos);
	}
	
	public void setNuevaUbicacion(Celda celda) throws UnidadTerrestreEnAreaEspacial, CeldaOcupada {
		if( celda.isEspacial()) throw new UnidadTerrestreEnAreaEspacial();
		this.ubicacion = celda;
		celda.setUnidad(this);
		
	}
	
	public void ataque(Unidad unidadAtacante){
		int danio = unidadAtacante.getDanioTerrestre();
		Integer escudoActual = this.getEscudo().getEscudoActual();
		if(escudoActual> danio){
			this.getEscudo().setEscudoActual(escudoActual-danio);
		}else{
			this.getEscudo().setEscudoActual(0);
			this.setVida(danio-escudoActual);
		}
	}
}
