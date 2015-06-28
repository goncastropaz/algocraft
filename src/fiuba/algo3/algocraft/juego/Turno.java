package fiuba.algo3.algocraft.juego;

import java.util.HashMap;
import java.util.List;

import fiuba.algo3.algocraft.construcciones.Construccion;
import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.unidades.Unidad;


public class Turno {
	
		private Jugador actualJugador;
		private Jugador proximoJugador;
		private int cantidadDeAccionesDisponibles;
		
		
		public Turno(HashMap<Integer,Jugador> jugadores) throws JugadorInvalido, FueraDeMatriz{
			this.actualJugador = jugadores.get(1);
			this.proximoJugador = jugadores.get(2);
			this.cantidadDeAccionesDisponibles =3;
		}
				

		public void completarAccionJugador(){
			this.cantidadDeAccionesDisponibles = this.cantidadDeAccionesDisponibles -1;
			
			if(this.cantidadDeAccionesDisponibles ==0){
				this.cambiarTurnoJugador();
			}
		}
		
	
		public Jugador getActualJugador(){
			return this.actualJugador;
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
			
		}
		
		public Jugador getProximoJugador(){
			return this.proximoJugador;
		}
		
}
