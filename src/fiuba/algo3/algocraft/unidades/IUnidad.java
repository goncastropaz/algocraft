package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.algocraft.juego.Celda;
import fiuba.algo3.classes.stats.CostoDeRecursos;
import fiuba.algo3.classes.stats.Escudo;
import fiuba.algo3.classes.stats.TiempoDeConstruccion;
import fiuba.algo3.classes.stats.Vida;

public interface IUnidad {

	public String getNombre();

	public void setNombre(String nombre);
	
	public CostoDeRecursos getCostoDeRecursos();

	public void setCostoDeRecursos(CostoDeRecursos costoDeRecursos);

	public TiempoDeConstruccion getTiempoDeConstruccion();

	public void setTiempoDeConstruccion(TiempoDeConstruccion tiempoDeConstruccion);

	public Vida getVida();

	public void setVida(Vida vida);
	
	public Escudo getEscudo();

	public void setEscudo(Escudo escudo);

	public Celda getUbicacion();

	public void setNuevaUbicacion(Celda celda) throws UnidadTerrestreEnAreaEspacial;
	
}
