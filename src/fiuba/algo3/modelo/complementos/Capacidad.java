package fiuba.algo3.modelo.complementos;

public class Capacidad {

	private Integer capacidadMaxima;
	private Integer capacidadActual;
	
	public Capacidad(Integer maxCapacidad) {
		this.capacidadMaxima = maxCapacidad;
		this.capacidadActual = maxCapacidad;
	}

	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public Integer getCapacidadActual() {
		return capacidadActual;
	}

	public void agregarCapacidad(int capacidad) {
		this.capacidadActual -= capacidad;
	}

	public boolean tieneCapacidad(int capacidad) {
		return this.capacidadMaxima <= (capacidadActual + capacidad);
	}

	public void sacarCapacidad(int capacidad) {
		this.capacidadActual += capacidad;
	}
	
}
