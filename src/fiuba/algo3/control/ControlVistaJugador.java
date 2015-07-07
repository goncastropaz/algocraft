package fiuba.algo3.control;

import java.awt.Rectangle;

import javax.swing.JScrollPane;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.JugadorInvalido;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;

public class ControlVistaJugador {

		private Juego juego;
		
		public ControlVistaJugador(Juego juego){
			this.juego = juego;
		}

		public Rectangle getBoundsJugadorActual() {
			try {
				if(juego.getJugador(1) == juego.getActualJugador()) return new Rectangle(0,0,1,1);
				else{
					return new Rectangle(2500,2500,1,1);
				}
			} catch (JugadorInvalido e) {
				e.printStackTrace();
			}
			return new Rectangle(0,0,1,1);

	
		}

		public void actualizarVistaBase(JScrollPane scrollmapa) {
			try {
				if(juego.getJugador(1) == juego.getActualJugador()){
					scrollmapa.getHorizontalScrollBar().setValue(scrollmapa.getHorizontalScrollBar().getMinimum());
					scrollmapa.getVerticalScrollBar().setValue(scrollmapa.getVerticalScrollBar().getMinimum());
					
				}
				else{
					scrollmapa.getHorizontalScrollBar().setValue(scrollmapa.getHorizontalScrollBar().getMaximum());
					scrollmapa.getVerticalScrollBar().setValue(scrollmapa.getVerticalScrollBar().getMaximum());
					
				}
			} catch (JugadorInvalido e) {
				e.printStackTrace();
			}
				
		}

		public boolean esVisible(int fil, int col) {
			Jugador jugadorActual = this.juego.getActualJugador();
			try {
				return jugadorActual.getVision().estaDescubierto(new Posicion(fil,col));
			} catch (FueraDeMatriz e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		
		//.scrollRectToVisible(new Rectangle(2000,2500,1,1));
}
