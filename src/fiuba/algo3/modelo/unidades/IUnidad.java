package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.complementos.Escudo;
import fiuba.algo3.modelo.complementos.TiempoDeConstruccion;
import fiuba.algo3.modelo.complementos.Vida;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.UnidadTerrestreEnAreaEspacial;
import fiuba.algo3.modelo.juego.Celda;

public interface IUnidad {

	public String getNombre();

	public void setNombre(String nombre);
	
	public Recursos getCostoDeRecursos();

	public void setCostoDeRecursos(Recursos costoDeRecursos);

	public TiempoDeConstruccion getTiempoDeConstruccion();

	public void setTiempoDeConstruccion(TiempoDeConstruccion tiempoDeConstruccion);

	public Vida getVida();

	public Escudo getEscudo();

	public void setEscudo(Escudo escudo);

	public boolean destruir();
	
	public void setCopia();
	
	public void ataque(Unidad unidadAtacante);
	
	public void ataqueEMP();
	
	public void radiacion(int danio);
	
	public void tormentaPsionica(int danio);
	
	public boolean permitidaEnArea(Celda celda);
	
}
