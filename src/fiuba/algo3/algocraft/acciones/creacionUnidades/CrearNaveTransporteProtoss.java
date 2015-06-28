package fiuba.algo3.algocraft.acciones.creacionUnidades;

import fiuba.algo3.algocraft.acciones.Ejecutable;
import fiuba.algo3.algocraft.excepciones.CeldaOcupada;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.juego.Turno;
import fiuba.algo3.algocraft.unidades.NaveCiencia;
import fiuba.algo3.algocraft.unidades.NaveTransporteProtoss;
import fiuba.algo3.classes.stats.Posicion;

public class CrearNaveTransporteProtoss extends Ejecutable{

	public CrearNaveTransporteProtoss(Juego juego){
		super(juego);
	}
	
	@Override
	public void ejecutar(Posicion pos) throws CeldaOcupada{
		NaveTransporteProtoss naveTransporteProtoss = new NaveTransporteProtoss();
		this.juego.agregarUnidad(naveTransporteProtoss, pos);

	}
	
}
