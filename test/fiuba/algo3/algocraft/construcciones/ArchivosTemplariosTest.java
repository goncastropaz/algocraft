package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Acceso;
import fiuba.algo3.modelo.construcciones.ArchivoTemplario;
import fiuba.algo3.modelo.construcciones.Asimilador;
import fiuba.algo3.modelo.construcciones.NexoMineral;
import fiuba.algo3.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaInvalida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;

public class ArchivosTemplariosTest {
	@Test(expected = NoTieneEdificiosPrevios.class)
	public void testParaCrearseRequierePuertoEstelarProttos()
			throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial,
			RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida,
			FueraDeMatriz {
		Juego juego = new Juego();

		// Se recolectan los recursos necesarios para crear las construcciones.
		juego.agregarConstruccion(new NexoMineral(new Posicion(4, 4)),
				new Posicion(4, 4));
		juego.agregarConstruccion(new Asimilador(new Posicion(5, 5)),
				new Posicion(5, 5));

		for (int i = 0; i < 100; i++)
			juego.cambiarTurnoJugador();

		juego.agregarConstruccion(new ArchivoTemplario(new Posicion(9, 9)),
				new Posicion(9, 9));
	}

	@Test
	public void testSeCreaLuegoDeAgregarUnPuertoEstelarProttosAlJuego()
			throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial,
			RecursosInsuficientes, NoTieneEdificiosPrevios, CeldaInvalida,
			FueraDeMatriz {
		Juego juego = new Juego();

		// Se recolectan los recursos necesarios para crear las construcciones.
		juego.agregarConstruccion(new NexoMineral(new Posicion(4, 4)),
				new Posicion(4, 4));
		juego.agregarConstruccion(new Asimilador(new Posicion(5, 5)),
				new Posicion(5, 5));

		for (int i = 0; i < 100; i++)
			juego.cambiarTurnoJugador();

		juego.agregarConstruccion(new Acceso(new Posicion(9, 9)), new Posicion(
				1, 1));
		
		// Se agrega la construcción necesaria para crear el archivo templario.
		juego.agregarConstruccion(
				new PuertoEstelarProtoss(new Posicion(10, 10)), new Posicion(
						10, 10));

		ArchivoTemplario archivo = new ArchivoTemplario(new Posicion(11, 11));

		juego.agregarConstruccion(archivo, new Posicion(11, 11));

		assertTrue(archivo.getCost().getMineral() == 150);
	}
}
