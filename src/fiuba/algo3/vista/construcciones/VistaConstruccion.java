package fiuba.algo3.vista.construcciones;

import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.vista.JButtonID;

public abstract class VistaConstruccion {

	protected Construccion construccion;
	protected String rutaImagenEnConstruccion;
	protected String rutaImagenConstruida;
	protected ImageIcon imagenEnConstruccion;
	protected ImageIcon  imagenConstruida;

	public VistaConstruccion(Construccion construccion) throws IOException {
		this.construccion = construccion;
	}
	
	public void dibujar(JButtonID[][] tablero) {
		Posicion posicion = this.construccion.getUbicacion();
		
		if(this.construccion.getConstructionTime().getTurnosMaximos()<this.construccion.getConstructionTime().getTurnosRestantes()){
			tablero[posicion.getFila()][posicion.getColumna()].setIcon(new ImageIcon(this.imagenEnConstruccion.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
		}else{
			tablero[posicion.getFila()][posicion.getColumna()].setIcon(new ImageIcon(this.imagenConstruida.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
		}
	}
}
