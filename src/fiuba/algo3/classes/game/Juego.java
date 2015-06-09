package fiuba.algo3.classes.game;

import java.util.HashMap;

import fiuba.algo3.classes.exceptions.ColorYaExiste;
import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.exceptions.JugadorInvalido;
import fiuba.algo3.classes.exceptions.NombreConMenosDe4Caracteres;
import fiuba.algo3.classes.exceptions.NombreYaExiste;

public class Juego {
	
	  private static Juego INSTANCE = null;
      private HashMap<Integer,Jugador> jugadores;
      private Mapa mapaJuego;
            
      private Juego() throws FueraDeMatriz{
    	 
    	  this.mapaJuego = Mapa.getInstance();
    	  this.jugadores = new HashMap<Integer,Jugador>();
    	  Jugador jugador = new Jugador();
    	  jugadores.put(1,jugador);
    	  jugador = new Jugador();
    	  jugadores.put(2,jugador);
    	  
      }

      
      private synchronized static void createInstance() throws FueraDeMatriz {
			if (INSTANCE == null) { 
		       INSTANCE = new Juego();
		    }
		}
      public static Juego getInstance() throws FueraDeMatriz {
		    if (INSTANCE == null) 
		    	createInstance();
		    return INSTANCE;
		}
      
      public Jugador getJugador(int jugador) throws JugadorInvalido{
    	  
    	  	if(jugador>2 || jugador <1) throw new JugadorInvalido();
			return jugadores.get(jugador);
		}
      
		public void setNombreJugador(int jugador, String nombre) throws NombreYaExiste, JugadorInvalido, NombreConMenosDe4Caracteres{
				
			for ( Integer key : this.jugadores.keySet() ){
				if(this.getJugador(key).getNombre() == nombre) throw new NombreYaExiste();
			}
			this.getJugador(jugador).setNombre(nombre);
			
			
		}
		
		public void setColorJugador(int jugador, String color) throws JugadorInvalido, ColorYaExiste{

			
			for ( Integer key : this.jugadores.keySet() ){
				if(this.getJugador(key).getColor() == color) throw new ColorYaExiste();
			}
			this.getJugador(jugador).setColor(color);
			
			
		}
		
		

	}
