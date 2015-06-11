package fiuba.algo3.classes.stats;

public class TiempoDeConstruccion {

	private Integer turnosMaximos;
	private Integer turnosRestantes;
	
	public TiempoDeConstruccion(Integer turnos){
		this.turnosMaximos = turnos;
		this.turnosRestantes = turnos;
	}

	public Integer getTurnosMaximos() {
		return turnosMaximos;
	}

	public Integer getTurnosRestantes() {
		return turnosRestantes;
	}

}
