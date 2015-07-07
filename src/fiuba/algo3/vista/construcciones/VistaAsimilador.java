package fiuba.algo3.vista.construcciones;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.algo3.modelo.construcciones.Construccion;

public class VistaAsimilador extends VistaConstruccion {

	public VistaAsimilador(Construccion construccion) throws IOException {
		super(construccion);

		this.rutaImagenEnConstruccion = "";
		this.rutaImagenConstruida = "/imagenes/construcciones/protoss/Asimilador.jpg";

		BufferedImage enConstruccion = ImageIO.read(VistaConstruccion.class
				.getResource(this.rutaImagenEnConstruccion));
		this.imagenEnConstruccion = new ImageIcon(enConstruccion);

		BufferedImage construida = ImageIO.read(VistaConstruccion.class
				.getResource(this.rutaImagenConstruida));
		this.imagenConstruida = new ImageIcon(construida);
	}

}
