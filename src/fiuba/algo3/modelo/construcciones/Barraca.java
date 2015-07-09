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
import fiuba.algo3.modelo.unidades.Marine;
import fiuba.algo3.modelo.unidades.Unidad;


public class Barraca extends Construccion {
	
	private static final String  NOMBRE = "BARRACA";
	private static final Integer COSTO_MINERAL = 150;
	private static final Integer COSTO_GAS = 0;
	private static final Integer TIEMPO_CONSTRUCCION = 12;
	private static final Integer MAX_VIDA = 1000;
	private static final Integer ESCUDO = 0;
	private ArrayList<String> unidadesHabilitadas;

	public Barraca(Posicion pos)  {
		super(NOMBRE, COSTO_MINERAL, COSTO_GAS, TIEMPO_CONSTRUCCION, MAX_VIDA,ESCUDO, pos);
		this.unidadesHabilitadas = new ArrayList<String>();
		this.unidadesHabilitadas.add("MARINE");
	}
	/*
	public void crearMarine(Juego juego) throws CeldaOcupada, CeldaEspacial, RazaNoTieneUnidad, RecursosInsuficientes, PoblacionInsuficiente, NoTieneEdificiosPrevios{
			
		Marine marine = new Marine();
		juego.agregarUnidad(marine, this.ubicacion);
	}*/

	@Override
	public boolean tieneEdificiosPrevios(List<Construccion> construcciones) {
		return true;
	}
	
	public boolean puedeCrearUnidad(Unidad unidad) {
		if(this.unidadesHabilitadas.contains(unidad.getNombre())&& this.terminado()) return true;
		return false;
		
	}
	
}
