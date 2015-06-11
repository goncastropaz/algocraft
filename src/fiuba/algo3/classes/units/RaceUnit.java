package fiuba.algo3.classes.units;

import fiuba.algo3.classes.exceptions.FueraDeMatriz;
import fiuba.algo3.classes.game.Celda;
import fiuba.algo3.classes.stats.CostoDeRecursos;
import fiuba.algo3.classes.stats.Escudo;
import fiuba.algo3.classes.stats.Posicion;
import fiuba.algo3.classes.stats.TiempoDeConstruccion;
import fiuba.algo3.classes.stats.Vida;

public class RaceUnit {

	private String nombre;
	private CostoDeRecursos costoDeRecursos;
	private TiempoDeConstruccion tiempoDeConstruccion;
	private Vida vida;
	private Escudo escudo;
	private Posicion posicion;
	private Celda ubicacion;
	
	public RaceUnit(){
		
	}
	
	public RaceUnit(String nombre, Integer costoMineral, Integer costoGas, Integer tiempoDeConstruccion, Integer vidaMaxima, Integer escudoMaximo, Posicion pos) throws FueraDeMatriz{
		this.nombre = nombre;
		this.costoDeRecursos = new CostoDeRecursos(costoMineral,costoGas);
		this.tiempoDeConstruccion = new TiempoDeConstruccion(tiempoDeConstruccion);
		this.vida = new Vida(vidaMaxima);
		this.escudo = (new Escudo(escudoMaximo));
		this.posicion = pos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CostoDeRecursos getCostoDeRecursos() {
		return costoDeRecursos;
	}

	public void setCostoDeRecursos(CostoDeRecursos costoDeRecursos) {
		this.costoDeRecursos = costoDeRecursos;
	}

	public TiempoDeConstruccion getTiempoDeConstruccion() {
		return tiempoDeConstruccion;
	}

	public void setTiempoDeConstruccion(TiempoDeConstruccion tiempoDeConstruccion) {
		this.tiempoDeConstruccion = tiempoDeConstruccion;
	}

	public Vida getVida() {
		return vida;
	}

	public void setVida(Vida vida) {
		this.vida = vida;
	}

	public Escudo getEscudo() {
		return escudo;
	}

	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
	}

	public Celda getUbicacion() {
		
		return this.ubicacion;
	}

	public void setNuevaUbicacion(Celda celda) {
		this.ubicacion = celda;
		celda.setUnidad(this);
		
	}
	
}
