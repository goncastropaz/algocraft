package fiuba.algo3.modelo.razas;

import java.util.HashMap;

import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearAcceso;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearArchivoTemplario;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearAsimilador;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearConstruccion;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearNexoMineral;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearPilon;
import fiuba.algo3.modelo.acciones.creacionConstrucciones.CrearPuertoEstelarProtoss;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearAltoTemplario;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearDragon;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearNaveTransporteProtoss;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearScout;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearUnidad;
import fiuba.algo3.modelo.acciones.creacionUnidades.CrearZealot;
import fiuba.algo3.modelo.juego.Juego;


public class Protoss extends Raza{


	public Protoss(Juego juego){
		this.listaDeCreacionUnidades = new HashMap<Integer,CrearUnidad>();
		this.listaDeCreacionConstrucciones = new HashMap<Integer,CrearConstruccion>();
		
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
