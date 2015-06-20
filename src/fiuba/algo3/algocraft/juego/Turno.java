package fiuba.algo3.algocraft.juego;

import java.util.List;

import fiuba.algo3.algocraft.construcciones.Construccion;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.unidades.Unidad;


public class Turno {
	
	 	private static Turno INSTANCE = null;
		private Jugador actualJugador;
		private Jugador proximoJugador;
		private Celda actualCelda;
		private Celda objetivoCelda;
		private int cantidadDeAccionesDisponibles;
		
		
		private synchronized static void createInstance() throws JugadorInvalido, FueraDeMatriz{
			if (INSTANCE == null) { 
				INSTANCE = new Turno();
			}
		}
		
	    public static Turno getInstance() throws JugadorInvalido, FueraDeMatriz{
	    	if (INSTANCE == null) 
	    		createInstance();
	    	return INSTANCE;
		}
		
		private Turno() throws JugadorInvalido, FueraDeMatriz{
			this.actualJugador = Juego.getInstance().getJugador(1);
			this.proximoJugador = Juego.getInstance().getJugador(2);
			this.cantidadDeAccionesDisponibles =3;
		}
				

		public void completarAccionJugador(){
			this.cantidadDeAccionesDisponibles = this.cantidadDeAccionesDisponibles -1;
			
			if(this.cantidadDeAccionesDisponibles ==0){
				this.cambiarTurnoJugador();
			}
		}
		
		private void actualizarRecursos(Jugador jugador) {
			jugador.actualizarMineral();
			jugador.actualizarGasVespeno();
			
		}

		public Jugador getActualJugador(){
			return this.actualJugador;
		}


		public Celda getActualCelda() {
			return actualCelda;
		}


		public Celda getObjetivoCelda() {
			return objetivoCelda;
		}
		
		public void actualizarUnidadesTurno(Jugador jugador){
			List<Unidad> unidadesList = jugador.getUnidadesList();
			for(int i = 0; i< unidadesList.size(); i++){
				unidadesList.get(0).actualizarTurno(jugador);
			}
		}
		public void actualizarConstruccionesTurno(Jugador jugador){
			 List<Construccion> construccionesList = jugador.getConstruccionesList();
			for(int i = 0; i< construccionesList.size(); i++){
				construccionesList.get(0).actualizarTurno(jugador);
			}
		}
		
		public void cambiarTurnoJugador(){
			Jugador aux = actualJugador;
			this.actualJugador = proximoJugador;
			this.proximoJugador = aux;
			this.cantidadDeAccionesDisponibles =3;
			this.actualizarConstruccionesTurno(this.actualJugador);
			this.actualizarConstruccionesTurno(this.proximoJugador);
			this.actualizarUnidadesTurno(this.actualJugador);
			this.actualizarUnidadesTurno(this.proximoJugador);
			this.actualizarRecursos(this.actualJugador);
			this.actualizarRecursos(this.proximoJugador);
		}
		
}
