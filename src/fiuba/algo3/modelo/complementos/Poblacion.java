package fiuba.algo3.modelo.complementos;

public class Poblacion {

	private int poblacionDisponible;
	private int poblacionActual;
	
	public Poblacion(){
		this.poblacionDisponible = 0;
		this.poblacionActual = 0;
	}
	
	public int getPoblacionMaxima() {
		return poblacionDisponible;
	}
	public void setPoblacionMaxima(int poblacionMaxima) {
		this.poblacionDisponible = poblacionMaxima;
	}
	public int getPoblacionActual() {
		return poblacionActual;
	}
	public void setPoblacionActual(int poblacionActual) {
		this.poblacionActual = poblacionActual;
	}
	
	public int getPoblacionDisponible(){
		return (this.poblacionDisponible - this.poblacionActual > 0) ? this.poblacionDisponible - this.poblacionActual : 0 ;
	}
	
	public void agregarPoblacionMaxima(){
		if(this.poblacionDisponible + 5 > 200){
			this.poblacionDisponible = 200;
		} else{
			this.poblacionDisponible += 5;
		}
	}
	
	public void sacarPoblacionMaxima(){
		if(this.poblacionDisponible - 5 < 0){
			this.poblacionDisponible = 0;
		} else{
			this.poblacionDisponible -= 5;
		}
	}
	
	public void agregarPoblacion(int cantidad){
		this.poblacionActual += cantidad;
	}
	
	public void sacarPoblacion(int cantidad){
		this.poblacionActual -= cantidad;
	}
	
}
