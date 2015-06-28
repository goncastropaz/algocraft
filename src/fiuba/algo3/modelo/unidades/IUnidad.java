package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.CostoDeRecursos;
import fiuba.algo3.modelo.complementos.Escudo;
import fiuba.algo3.modelo.complementos.TiempoDeConstruccion;
import fiuba.algo3.modelo.complementos.Vida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Celda;

public interface IUnidad {

	public String getNombre();

	public void setNombre(String nombre);
	
	public CostoDeRecursos getCostoDeRecursos();

	public void setCostoDeRecursos(CostoDeRecursos costoDeRecursos);

	public TiempoDeConstruccion getTiempoDeConstruccion();

	public void setTiempoDeConstruccion(TiempoDeConstruccion tiempoDeConstruccion);

	public Vida getVida();

	public void setVida(Integer vida);
	
	public Escudo getEscudo();

	public void setEscudo(Escudo escudo);

	public Celda getUbicacion();

	public void setNuevaUbicacion(Celda celda) throws UnidadTerrestreEnAreaEspacial, CeldaOcupada;
	
	public void destruir();
	
	public void setCopia();
	
	public void ataque(Unidad unidadAtacante);
	
	public void ataqueEMP();
	
	public void radiacion(int danio);
	
	public void tormentaPsionica(int danio);
	
}
