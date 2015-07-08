package fiuba.algo3.vista.construcciones;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.algo3.modelo.construcciones.Construccion;

public class VistaFabrica extends VistaConstruccion {

	public VistaFabrica(Construccion construccion) throws IOException {
		super(construccion);
//		rutaImagenEnConstruccion = "";
		rutaImagenConstruida = "/imagenes/construcciones/terran/Fabrica.jpg";

		BufferedImage enConstruccion = ImageIO.read(VistaConstruccion.class
				.getResource(rutaImagenEnConstruccion));
		this.imagenEnConstruccion = new ImageIcon(enConstruccion);

		BufferedImage construida = ImageIO.read(VistaConstruccion.class
				.getResource(rutaImagenConstruida));
		this.imagenConstruida = new ImageIcon(construida);
	}

}
