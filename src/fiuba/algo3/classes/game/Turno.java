package fiuba.algo3.classes.game;

public class Turno {
	
		private Jugador actualJugador;
		private Jugador proximoJugador;
		
		public Turno(Jugador jugador1, Jugador jugador2){
			this.actualJugador = jugador1;
			this.proximoJugador = jugador2;
		}
				

		public Jugador cambiarTurno(){
			
			Jugador aux = actualJugador;
			this.actualJugador = proximoJugador;
			this.proximoJugador = aux;
			
			return this.actualJugador;
		}
		
		public Jugador getActualJugador(){
			return this.actualJugador;
		}
}

