package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class ArchivoTemplarioTest {
	
	@Test
	public void testCrearArchivoTemplariosDeberiaSetearElNombreARCHIVO_TEMPLARIO() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		ArchivoTemplario unArchivosTemplario = new ArchivoTemplario(new Posicion(2,2));
		
		assertEquals(unArchivosTemplario.getName(),"ARCHIVO_TEMPLARIO");
	}
	
	@Test
	public void testCrearArchivosTemplariosDeberiaSetearCostoDeMineral150() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		ArchivoTemplario unArchivosTemplario = new ArchivoTemplario(new Posicion(2,2));
		Integer costoMineral = 150;
		assertEquals(unArchivosTemplario.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearArchivosTemplariosDeberiaSetearCostoDeGas200() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		ArchivoTemplario unArchivosTemplario = new ArchivoTemplario(new Posicion(2,2));
		Integer costoGas = 200;
		assertEquals(unArchivosTemplario.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearArchivosTemplariosDeberiaSetearTiempoDeConstruccion9() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		ArchivoTemplario unArchivosTemplario = new ArchivoTemplario(new Posicion(2,2));
		Integer cantDeTurnos = 9;
		assertEquals(unArchivosTemplario.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearArchivosTemplariosDeberiaSetearVida500() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		ArchivoTemplario unArchivosTemplario = new ArchivoTemplario(new Posicion(2,2));
		Integer vida = 500;
		assertEquals(unArchivosTemplario.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearArchivosTemplariosDeberiaSetearEscudo500() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		ArchivoTemplario unArchivosTemplario = new ArchivoTemplario(new Posicion(2,2));
		Integer escudo =500;
		assertEquals(unArchivosTemplario.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearArchivosTemplariosDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		ArchivoTemplario unArchivosTemplario = new ArchivoTemplario(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unArchivosTemplario.getUbicacion(),celda);
	}
}
