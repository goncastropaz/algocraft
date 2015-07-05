package fiuba.algo3.modelo.unidades;

import fiuba.algo3.modelo.complementos.Escudo;
import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.complementos.Recursos;
import fiuba.algo3.modelo.complementos.TiempoDeConstruccion;
import fiuba.algo3.modelo.complementos.Vida;
import fiuba.algo3.modelo.excepciones.FueraDeRango;
import fiuba.algo3.modelo.excepciones.ObjetivoInvalido;
import fiuba.algo3.modelo.excepciones.UnidadAtacadaInvalida;
import fiuba.algo3.modelo.excepciones.UnidadAtacanteInvalida;
import fiuba.algo3.modelo.juego.Celda;
import fiuba.algo3.modelo.juego.Juego;

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
	
	public void ataqueEMP();
	
	public void radiacion(int danio);
	
	public void tormentaPsionica(int danio);
	
	public boolean permitidaEnArea(Celda celda);
	
	public Unidad generarCopia();
	
	public void atacarUnidad(Juego juego, Posicion posicion) throws ObjetivoInvalido, UnidadAtacanteInvalida, UnidadAtacadaInvalida, FueraDeRango;
	
}
