package fiuba.algo3.algocraft.juego;


public class Turno {
	
		private Jugador actualJugador;
		private Jugador proximoJugador;
		private Celda actualCelda;
		private Celda objetivoCelda;
		
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


		public Celda getActualCelda() {
			return actualCelda;
		}


		public Celda getObjetivoCelda() {
			return objetivoCelda;
		}
		
}

