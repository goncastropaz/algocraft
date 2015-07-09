package fiuba.algo3.modelo.juego;

import java.util.HashMap;
import java.util.List;

import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.unidades.Unidad;


public class Turno {
	
		private Jugador actualJugador;
		private Jugador proximoJugador;
		private int cantidadDeAccionesDisponibles;
		private int cantidadDeMovimientosDisponibles;
		
		
		public Turno(HashMap<Integer,Jugador> jugadores) throws JugadorInvalido, FueraDeMatriz{
			this.actualJugador = jugadores.get(1);
			this.proximoJugador = jugadores.get(2);
			this.cantidadDeAccionesDisponibles =3;
			this.cantidadDeMovimientosDisponibles =5;
		}
				

		public void completarAccionJugador(){
			this.cantidadDeAccionesDisponibles = this.cantidadDeAccionesDisponibles -1;
			this.cantidadDeMovimientosDisponibles =5;
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
				unidadesList.get(i).actualizarTurno(jugador);
			}
		}
		public void actualizarConstruccionesTurno(Jugador jugador){
			 List<Construccion> construccionesList = jugador.getConstruccionesList();
			for(int i = 0; i< construccionesList.size(); i++){
				construccionesList.get(i).actualizarTurno(jugador);
			}
		}
		
		public void cambiarTurnoJugador(){
			this.actualizarConstruccionesTurno(this.actualJugador);
			this.actualizarUnidadesTurno(this.actualJugador);
			Jugador aux = actualJugador;
			this.actualJugador = proximoJugador;
			this.proximoJugador = aux;
			this.cantidadDeAccionesDisponibles =3;
			this.cantidadDeMovimientosDisponibles =5;
			
			
		}
		
		public Jugador getProximoJugador(){
			return this.proximoJugador;
		}
		
		public int getAccionesDisponiblesJugadorActual(){
			return this.cantidadDeAccionesDisponibles;
		}


		public void completarAccionMovimiento() {
			this.cantidadDeMovimientosDisponibles = this.cantidadDeMovimientosDisponibles -1;
			if(this.cantidadDeMovimientosDisponibles ==0){
				this.completarAccionJugador();
			}			
		}
		
}
