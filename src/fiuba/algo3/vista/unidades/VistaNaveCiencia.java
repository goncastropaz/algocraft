package fiuba.algo3.vista.unidades;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.algo3.modelo.complementos.Posicion;

public class VistaNaveCiencia extends VistaUnidad {

	public VistaNaveCiencia(Posicion posicion)throws IOException {
		super(posicion);
		this.rutaImagen = "/imagenes/unidades/terran/NaveCiencia.jpg";

		this.imagenInicial = ImageIO.read(VistaUnidad.class
				.getResource(this.rutaImagen));

		this.imagen = new ImageIcon(this.imagenInicial);
	}

}
