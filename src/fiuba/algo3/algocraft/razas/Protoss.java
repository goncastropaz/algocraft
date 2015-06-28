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
import fiuba.algo3.algocraft.juego.Juego;


public class Protoss extends Raza{


	public Protoss(Juego juego){
		this.listaDeCreacionUnidades = new HashMap<Integer,Ejecutable>();
		this.listaDeCreacionConstrucciones = new HashMap<Integer,Ejecutable>();
		
		this.listaDeCreacionUnidades.put(1, new CrearZealot(juego));
		this.listaDeCreacionUnidades.put(2, new CrearDragon(juego));
		this.listaDeCreacionUnidades.put(3, new CrearScout(juego));
		this.listaDeCreacionUnidades.put(4, new CrearAltoTemplario(juego));
		this.listaDeCreacionUnidades.put(5, new CrearNaveTransporteProtoss(juego));
		
		this.listaDeCreacionConstrucciones.put(1, new CrearNexoMineral(juego));
		this.listaDeCreacionConstrucciones.put(2, new CrearPilon(juego));
		this.listaDeCreacionConstrucciones.put(3, new CrearAsimilador(juego));
		this.listaDeCreacionConstrucciones.put(4, new CrearAcceso(juego));
		this.listaDeCreacionConstrucciones.put(5, new CrearPuertoEstelarProtoss(juego));
		this.listaDeCreacionConstrucciones.put(6, new CrearArchivoTemplario(juego));
	}
}
