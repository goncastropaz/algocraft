package fiuba.algo3.vista.construcciones;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fiuba.algo3.modelo.construcciones.Construccion;

public class VistaAcceso extends VistaConstruccion {
	
	public VistaAcceso(Construccion construccion) throws IOException {
		super(construccion);

		this.rutaImagenEnConstruccion = "";
		this.rutaImagenConstruida = "/imagenes/construcciones/terran/Acceso.jpg";

		BufferedImage enConstruccion = ImageIO.read(VistaConstruccion.class.getResource(this.rutaImagenEnConstruccion));
		BufferedImage construida = ImageIO.read(VistaConstruccion.class.getResource(this.rutaImagenConstruida));

		this.imagenEnConstruccion = new ImageIcon(enConstruccion);
		this.imagenConstruida = new ImageIcon(construida);

	}



}
