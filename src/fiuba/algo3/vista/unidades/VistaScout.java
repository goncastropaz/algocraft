package fiuba.algo3.vista.unidades;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.algo3.modelo.unidades.Unidad;

public class VistaScout extends VistaUnidad {

	public VistaScout(Unidad unidad)throws IOException {
		super(unidad);
		this.rutaImagen = "/imagenes/unidades/protoss/Scout.jpg";

		this.imagenInicial = ImageIO.read(VistaUnidad.class
				.getResource(this.rutaImagen));

		this.imagen = new ImageIcon(this.imagenInicial);
	}
}
