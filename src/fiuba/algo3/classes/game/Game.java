package fiuba.algo3.classes.game;

import java.util.HashMap;

public class Game {
      private HashMap<String,Player> players;
      
      public Game(){
    	  String namePlayer = getNombrePlayer("");
    	  String colorPlayer = getColorPlayer("");
    	  Race razaPlayer = getRacePlayer();
    	  Player player1 = new Player(namePlayer,colorPlayer,razaPlayer);
    	  this.players = new HashMap<String,Player>();
    	  this.players.put(namePlayer, player1);
    	  namePlayer = getNombrePlayer(namePlayer);
    	  colorPlayer = getColorPlayer(colorPlayer);
    	  razaPlayer = getRacePlayer();
    	  Player player2 = new Player(namePlayer,colorPlayer,razaPlayer);
    	  this.players.put(namePlayer, player2);
    	  
      }

	private Race getRacePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getColorPlayer(String colorNoPermitido) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getNombrePlayer(String nombreNoPermitido) {
		// TODO Auto-generated method stub
		return null;
	}
      
}
