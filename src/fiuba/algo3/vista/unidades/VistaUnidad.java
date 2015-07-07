package fiuba.algo3.vista.unidades;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.vista.JButtonID;

public abstract class VistaUnidad {

	protected Posicion posUnidad;
	protected String rutaImagen;
	protected ImageIcon imagen;
	protected BufferedImage imagenInicial;

	public VistaUnidad(Posicion posicion){
		this.posUnidad = posicion;
	}
	
	public void dibujar(JButtonID tablero[][]){
		tablero[this.posUnidad.getFila()][this.posUnidad.getColumna()]
				.setIcon(new ImageIcon(this.imagen.getImage()
						.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

	}


}
