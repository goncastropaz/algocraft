package fiuba.algo3.algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.FueraDeMatriz;
import fiuba.algo3.algocraft.excepciones.JugadorInvalido;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Mapa;
import fiuba.algo3.classes.stats.Posicion;

public class DepositoSuministroTest {
	
	@Test
	public void testCrearDepositoSuministroDeberiaSetearElNombreDEPOSITO_SUMINISTRO() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		DepositoSuministro unDepositoSuministro = new DepositoSuministro(new Posicion(2,2));
		
		assertEquals(unDepositoSuministro.getName(),"DEPOSITO_SUMINISTRO");
	}
	
	@Test
	public void testCrearDepositoSuministroDeberiaSetearCostoDeMineral100() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		DepositoSuministro unDepositoSuministro = new DepositoSuministro(new Posicion(2,2));
		Integer costoMineral = 100;
		assertEquals(unDepositoSuministro.getCost().getCostoMineral(),costoMineral);
	}
	
	@Test
	public void testCrearDepositoSuministroDeberiaSetearCostoDeGas0() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		DepositoSuministro unDepositoSuministro = new DepositoSuministro(new Posicion(2,2));
		Integer costoGas = 0;
		assertEquals(unDepositoSuministro.getCost().getCostoGas(),costoGas);
	}
	
	@Test
	public void testCrearDepositoSuministroDeberiaSetearTiempoDeConstruccion6() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		DepositoSuministro unDepositoSuministro = new DepositoSuministro(new Posicion(2,2));
		Integer cantDeTurnos = 6;
		assertEquals(unDepositoSuministro.getConstructionTime().getTurnosRestantes(),cantDeTurnos);
	}
	
	@Test
	public void testCrearDepositoSuministroDeberiaSetearVida500() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		DepositoSuministro unDepositoSuministro = new DepositoSuministro(new Posicion(2,2));
		Integer vida = 500;
		assertEquals(unDepositoSuministro.getHealth().getVidaMaxima(),vida);
	}
	
	@Test
	public void testCrearDepositoSuministroDeberiaSetearEscudo0() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		DepositoSuministro unDepositoSuministro = new DepositoSuministro(new Posicion(2,2));
		Integer escudo =0;
		assertEquals(unDepositoSuministro.getShield().getEscudoTotal(),escudo);
	}
	
	@Test
	public void testCrearDepositoSuministroDeberiaGuardarLaCeldaDondeEstaUbicada() throws FueraDeMatriz, JugadorInvalido{
		Juego nuevoJuego = Juego.getInstance();
		nuevoJuego.empezarJuego();
		DepositoSuministro unDepositoSuministro = new DepositoSuministro(new Posicion(2,2));
		Celda celda = Mapa.getInstance().getCelda(2, 2);
		assertEquals(unDepositoSuministro.getUbicacion(),celda);
	}
}
