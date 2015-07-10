package fiuba.algo3.vista.unidades;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.unidades.Unidad;
import fiuba.algo3.vista.JButtonID;
import fiuba.algo3.vista.construcciones.VistaConstruccion;

public abstract class VistaUnidad {

	protected Unidad unidad;
	protected String rutaImagenEnConstruccion = "/imagenes/construcciones/unitConstruction.jpg";
	protected String rutaImagen;
	protected ImageIcon imagen;
	protected ImageIcon imagenEnConstruccion;
	protected BufferedImage imagenInicial;

	public VistaUnidad(Unidad unidad) throws IOException {
		this.unidad = unidad;
		BufferedImage enConstruccion = ImageIO.read(VistaConstruccion.class
				.getResource(this.rutaImagenEnConstruccion));
		this.imagenEnConstruccion = new ImageIcon(enConstruccion);
	}

	public void dibujar(JButtonID tablero[][]) {

		if (this.unidad.getTiempoDeConstruccion().getTurnosRestantes() != 0) {
			tablero[this.unidad.getUbicacion().getFila()][this.unidad
					.getUbicacion().getColumna()].setIcon(new ImageIcon(
					this.imagenEnConstruccion.getImage().getScaledInstance(50, 50,
							Image.SCALE_SMOOTH)));
		} else {
			tablero[this.unidad.getUbicacion().getFila()][this.unidad
					.getUbicacion().getColumna()].setIcon(new ImageIcon(
					this.imagen.getImage().getScaledInstance(50, 50,
							Image.SCALE_SMOOTH)));
		}
	}

}
