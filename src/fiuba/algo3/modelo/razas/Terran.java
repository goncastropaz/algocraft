package fiuba.algo3.modelo.razas;

import java.util.HashMap;
import java.util.HashSet;

import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearBarraca;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearCentroDeMineral;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearConstruccion;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearDepositoSuministros;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearFabrica;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearPuertoEstelarTerran;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearRefineria;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearEspectro;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearGolliat;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearMarine;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearNaveCiencia;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearNaveTransporteTerran;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearUnidad;
import fiuba.algo3.modelo.juego.Juego;

public class Terran extends Raza {

	
	public Terran(Juego juego){
		
		this.listaDeCreacionUnidades = new HashMap<Integer,CrearUnidad>();
		this.listaDeCreacionConstrucciones = new HashMap<Integer,CrearConstruccion>();
		this.listaDeUnidadesValidas = new HashSet<String>();
		this.listaDeConstruccionesValidas = new HashSet<String>();
		
		this.listaDeCreacionUnidades.put(1, new CrearMarine(juego));
		this.listaDeCreacionUnidades.put(2, new CrearGolliat(juego));
		this.listaDeCreacionUnidades.put(3, new CrearEspectro(juego));
		this.listaDeCreacionUnidades.put(4, new CrearNaveCiencia(juego));
		this.listaDeCreacionUnidades.put(5, new CrearNaveTransporteTerran(juego));
		
		this.listaDeCreacionConstrucciones.put(1, new CrearCentroDeMineral(juego));
		this.listaDeCreacionConstrucciones.put(2, new CrearBarraca(juego));
		this.listaDeCreacionConstrucciones.put(3, new CrearDepositoSuministros(juego));
		this.listaDeCreacionConstrucciones.put(4, new CrearRefineria(juego));
		this.listaDeCreacionConstrucciones.put(5, new CrearFabrica(juego));
		this.listaDeCreacionConstrucciones.put(6, new CrearPuertoEstelarTerran(juego));
		
		
		this.listaDeUnidadesValidas.add("MARINE");
		this.listaDeUnidadesValidas.add("GOLLIAT");
		this.listaDeUnidadesValidas.add("ESPECTRO");
		this.listaDeUnidadesValidas.add("NAVE_CIENCIA");
		this.listaDeUnidadesValidas.add("NAVE_TRANSPORTE_TERRAN");
		
		this.listaDeConstruccionesValidas.add("BARRACA");
		this.listaDeConstruccionesValidas.add("CENTRO_DE_MINERAL");
		this.listaDeConstruccionesValidas.add("DEPOSITO_SUMINISTRO");
		this.listaDeConstruccionesValidas.add("REFINERIA");
		this.listaDeConstruccionesValidas.add("FABRICA");
		this.listaDeConstruccionesValidas.add("PUERTO_ESTELAR_TERRAN");
	}

	@Override
	public String getNombreRaza() {
		return "Terran";
	}
}
