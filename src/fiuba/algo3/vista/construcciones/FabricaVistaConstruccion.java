package fiuba.algo3.vista.construcciones;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.modelo.construcciones.Acceso;
import fiuba.algo3.modelo.construcciones.ArchivoTemplario;
import fiuba.algo3.modelo.construcciones.Asimilador;
import fiuba.algo3.modelo.construcciones.Barraca;
import fiuba.algo3.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.modelo.construcciones.Fabrica;
import fiuba.algo3.modelo.construcciones.NexoMineral;
import fiuba.algo3.modelo.construcciones.Pilon;
import fiuba.algo3.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.modelo.construcciones.PuertoEstelarTerran;
import fiuba.algo3.modelo.construcciones.Refineria;

public class FabricaVistaConstruccion {
	private Map<Class<? extends Construccion>, Class<? extends VistaConstruccion>> listaDeVistasConstrucciones;

	public FabricaVistaConstruccion() {
		listaDeVistasConstrucciones = new HashMap<Class<? extends Construccion>, Class<? extends VistaConstruccion>>();
		this.rellenarListaConstruccion();
	}

	private void rellenarListaConstruccion() {
		listaDeVistasConstrucciones.put(Acceso.class, VistaAcceso.class);
		listaDeVistasConstrucciones.put(ArchivoTemplario.class, VistaArchivosTemplarios.class);
		listaDeVistasConstrucciones.put(Asimilador.class, VistaAsimilador.class);
		listaDeVistasConstrucciones.put(Barraca.class, VistaBarraca.class);
		listaDeVistasConstrucciones.put(CentroDeMineral.class, VistaCentroMineral.class);
		listaDeVistasConstrucciones.put(DepositoSuministro.class, VistaDepositoSuministros.class);
		listaDeVistasConstrucciones.put(Fabrica.class, VistaFabrica.class);
		listaDeVistasConstrucciones.put(NexoMineral.class, VistaNexoMineral.class);
		listaDeVistasConstrucciones.put(Pilon.class, VistaPilon.class);
		listaDeVistasConstrucciones.put(PuertoEstelarProtoss.class, VistaPuertoEstelarProtoss.class);
		listaDeVistasConstrucciones.put(PuertoEstelarTerran.class, VistaPuertoEstelarTerran.class);
		listaDeVistasConstrucciones.put(Refineria.class, VistaRefineria.class);
	}

	public VistaConstruccion crearVistaConstruccion(Construccion construccion) {
		VistaConstruccion vistaConstruccion = null;
		Constructor<?>[] constructores;

		constructores = listaDeVistasConstrucciones
				.get(construccion.getClass()).getConstructors();

		try {
			vistaConstruccion = (VistaConstruccion) constructores[0].newInstance(construccion);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return vistaConstruccion;
	}

}
