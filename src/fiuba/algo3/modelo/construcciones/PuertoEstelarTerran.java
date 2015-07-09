package fiuba.algo3.modelo.construcciones;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.NoTieneEdificiosPrevios;
import fiuba.algo3.modelo.excepciones.PoblacionInsuficiente;
import fiuba.algo3.modelo.excepciones.RazaNoTieneUnidad;
import fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.unidades.Espectro;
import fiuba.algo3.modelo.unidades.NaveCiencia;
import fiuba.algo3.modelo.unidades.NaveTransporteTerran;
import fiuba.algo3.modelo.unidades.Unidad;

public class PuertoEstelarTerran  extends Construccion{

	private static final String  NOMBRE = "PUERTO_ESTELAR_TERRAN";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 100;
	private static final Integer TIEMPO_CONSTRUCCION = 10;
	private static final Integer MAX_VIDA = 1300;
	private static final Integer ESCUDO = 0;
	private ArrayList<String> unidadesHabilitadas;
	
	
	public PuertoEstelarTerran(Posicion pos) {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, pos);
		
		this.unidadesHabilitadas = new ArrayList<String>();
		this.unidadesHabilitadas.add("ESPECTRO");
		this.unidadesHabilitadas.add("NAVE_TRANSPORTE_TERRAN");
		this.unidadesHabilitadas.add("NAVE_CIENCIA");
	}
	/*
	public void crearEspectro(Juego juego) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente, NoTieneEdificiosPrevios{
		
		Espectro unidad = new Espectro();
		juego.agregarUnidad(unidad, this.ubicacion);
	}
	
	public void crearNaveTransporte(Juego juego) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente, NoTieneEdificiosPrevios{
	
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		juego.agregarUnidad(unidad, this.ubicacion);
	}

	public void crearNaveCiencia(Juego juego) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente, NoTieneEdificiosPrevios{
	
		NaveCiencia unidad = new NaveCiencia();
		juego.agregarUnidad(unidad, this.ubicacion);
	}*/

	@Override
	public boolean tieneEdificiosPrevios(List<Construccion> construcciones) {
		return tieneConstruccion(construcciones, "BARRACA") && tieneConstruccion(construcciones, "FABRICA");
	}
	
	public boolean puedeCrearUnidad(Unidad unidad) {
		if(this.unidadesHabilitadas.contains(unidad.getNombre())&& this.terminado()) return true;
		return false;
		
	}
	
}
