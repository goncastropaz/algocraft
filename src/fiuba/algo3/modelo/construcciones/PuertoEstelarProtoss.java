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
import fiuba.algo3.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.modelo.unidades.Scout;
import fiuba.algo3.modelo.unidades.Unidad;

public class PuertoEstelarProtoss extends Construccion {

	private static final String  NOMBRE = "PUERTO_ESTELAR_PROTOSS";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 150;
	private static final Integer TIEMPO_CONSTRUCCION = 10;
	private static final Integer MAX_VIDA = 600;
	private static final Integer ESCUDO = 600;
	private ArrayList<String> unidadesHabilitadas;
		
	public PuertoEstelarProtoss(Posicion pos){
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,
				ESCUDO, pos);

		this.unidadesHabilitadas = new ArrayList<String>();
		this.unidadesHabilitadas.add("SCOUT");
		this.unidadesHabilitadas.add("NAVE_TRANSPORTE_PROTOSS");
		
	}
	/*
	public void crearScout(Juego juego) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente, NoTieneEdificiosPrevios{
		
		Scout unidad = new Scout();
		juego.agregarUnidad(unidad, this.ubicacion);
	}
	
	public void crearNaveTransporte(Juego juego) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente, NoTieneEdificiosPrevios{
	
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		juego.agregarUnidad(unidad, this.ubicacion);
	}*/

	@Override
	public boolean tieneEdificiosPrevios(List<Construccion> construcciones) {
		return tieneConstruccion(construcciones, "ACCESO");
	}
	
	
	public boolean puedeCrearUnidad(Unidad unidad) {
		if(this.unidadesHabilitadas.contains(unidad.getNombre())&& this.terminado()) return true;
		return false;
		
	}
	
}
