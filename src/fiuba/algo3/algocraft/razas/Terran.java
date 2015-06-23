package fiuba.algo3.algocraft.razas;

import java.util.HashMap;

import fiuba.algo3.algocraft.acciones.Ejecutable;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearBarraca;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearCentroDeMineral;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearDepositoSuministros;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearFabrica;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearPuertoEstelarTerran;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearRefineria;
import fiuba.algo3.algocraft.acciones.creacionUnidades.CrearEspectro;
import fiuba.algo3.algocraft.acciones.creacionUnidades.CrearGolliat;
import fiuba.algo3.algocraft.acciones.creacionUnidades.CrearMarine;
import fiuba.algo3.algocraft.acciones.creacionUnidades.CrearNaveCiencia;
import fiuba.algo3.algocraft.acciones.creacionUnidades.CrearNaveTransporteTerran;

public class Terran extends Raza {

	
	public Terran(){
		
		this.listaDeCreacionUnidades = new HashMap<Integer,Ejecutable>();
		this.listaDeCreacionConstrucciones = new HashMap<Integer,Ejecutable>();
		
		this.listaDeCreacionUnidades.put(1, new CrearMarine());
		this.listaDeCreacionUnidades.put(2, new CrearGolliat());
		this.listaDeCreacionUnidades.put(3, new CrearEspectro());
		this.listaDeCreacionUnidades.put(4, new CrearNaveCiencia());
		this.listaDeCreacionUnidades.put(5, new CrearNaveTransporteTerran());
		
		this.listaDeCreacionConstrucciones.put(1, new CrearCentroDeMineral());
		this.listaDeCreacionConstrucciones.put(2, new CrearBarraca());
		this.listaDeCreacionConstrucciones.put(3, new CrearDepositoSuministros());
		this.listaDeCreacionConstrucciones.put(4, new CrearRefineria());
		this.listaDeCreacionConstrucciones.put(5, new CrearFabrica());
		this.listaDeCreacionConstrucciones.put(6, new CrearPuertoEstelarTerran());
		
	}
}
