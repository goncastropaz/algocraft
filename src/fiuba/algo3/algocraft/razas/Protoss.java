package fiuba.algo3.algocraft.razas;

import java.util.HashMap;

import fiuba.algo3.algocraft.acciones.Ejecutable;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearAcceso;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearArchivoTemplario;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearAsimilador;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearNexoMineral;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearPilon;
import fiuba.algo3.algocraft.acciones.creacionConstrucciones.CrearPuertoEstelarProtoss;
import fiuba.algo3.algocraft.acciones.creacionUnidades.CrearAltoTemplario;
import fiuba.algo3.algocraft.acciones.creacionUnidades.CrearDragon;
import fiuba.algo3.algocraft.acciones.creacionUnidades.CrearNaveTransporteProtoss;
import fiuba.algo3.algocraft.acciones.creacionUnidades.CrearScout;
import fiuba.algo3.algocraft.acciones.creacionUnidades.CrearZealot;


public class Protoss extends Raza{


	public Protoss(){
		this.listaDeCreacionUnidades = new HashMap<Integer,Ejecutable>();
		this.listaDeCreacionConstrucciones = new HashMap<Integer,Ejecutable>();
		
		this.listaDeCreacionUnidades.put(1, new CrearZealot());
		this.listaDeCreacionUnidades.put(2, new CrearDragon());
		this.listaDeCreacionUnidades.put(3, new CrearScout());
		this.listaDeCreacionUnidades.put(4, new CrearAltoTemplario());
		this.listaDeCreacionUnidades.put(5, new CrearNaveTransporteProtoss());
		
		this.listaDeCreacionConstrucciones.put(1, new CrearNexoMineral());
		this.listaDeCreacionConstrucciones.put(2, new CrearPilon());
		this.listaDeCreacionConstrucciones.put(3, new CrearAsimilador());
		this.listaDeCreacionConstrucciones.put(4, new CrearAcceso());
		this.listaDeCreacionConstrucciones.put(5, new CrearPuertoEstelarProtoss());
		this.listaDeCreacionConstrucciones.put(6, new CrearArchivoTemplario());
	}
}
