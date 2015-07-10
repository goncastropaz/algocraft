package fiuba.algo3.vista.unidades;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.modelo.unidades.AltoTemplario;
import fiuba.algo3.modelo.unidades.Dragon;
import fiuba.algo3.modelo.unidades.Espectro;
import fiuba.algo3.modelo.unidades.Golliat;
import fiuba.algo3.modelo.unidades.Marine;
import fiuba.algo3.modelo.unidades.NaveCiencia;
import fiuba.algo3.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.modelo.unidades.NaveTransporteTerran;
import fiuba.algo3.modelo.unidades.Scout;
import fiuba.algo3.modelo.unidades.Unidad;
import fiuba.algo3.modelo.unidades.Zealot;

public class FabricaVistaUnidad {

	private Map<Class<? extends Unidad>, Class<? extends VistaUnidad>> listaDeVistasUnidades;

	public FabricaVistaUnidad(){
		listaDeVistasUnidades = new HashMap<Class<? extends Unidad>, Class<? extends VistaUnidad>>();
		this.rellenarListaUnidad();
	}

	private void rellenarListaUnidad() {
		listaDeVistasUnidades.put(AltoTemplario.class, VistaAltoTemplario.class);
		listaDeVistasUnidades.put(Dragon.class, VistaDragon.class);
		listaDeVistasUnidades.put(Espectro.class, VistaEspectro.class);
		listaDeVistasUnidades.put(Golliat.class, VistaGolliat.class);
		listaDeVistasUnidades.put(Marine.class, VistaMarine.class);
		listaDeVistasUnidades.put(NaveCiencia.class, VistaNaveCiencia.class);
		listaDeVistasUnidades.put(NaveTransporteProtoss.class, VistaNaveTransporteProtoss.class);
		listaDeVistasUnidades.put(NaveTransporteTerran.class, VistaNaveTransporteTerran.class);
		listaDeVistasUnidades.put(Scout.class, VistaScout.class);
		listaDeVistasUnidades.put(Zealot.class, VistaZealot.class);
	}

	public VistaUnidad crearVistaUnidad(Unidad unidad) {
		VistaUnidad vistaUnidad = null;
		Constructor<?>[] constructores;

		constructores = listaDeVistasUnidades.get(unidad.getClass()).getConstructors();
		
		try {
			vistaUnidad = (VistaUnidad) constructores[0].newInstance(unidad);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return vistaUnidad;
	}
	
}
