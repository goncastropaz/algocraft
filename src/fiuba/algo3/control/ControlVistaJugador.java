package fiuba.algo3.control;

import java.awt.Rectangle;

import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Juego;

public class ControlVistaJugador {

		private Juego juego;
		
		public ControlVistaJugador(Juego juego){
			this.juego = juego;
		}

		public Rectangle getBoundsJugadorActual() {
			try {
				if(juego.getJugador(1) == juego.getActualJugador()) return new Rectangle(1,1,1,1);
				else{
					return new Rectangle(2000,2500,1,1);
				}
			} catch (JugadorInvalido e) {
				e.printStackTrace();
			}
			return new Rectangle(1,1,1,1);
		}
		
		
		//.scrollRectToVisible(new Rectangle(2000,2500,1,1));
}
