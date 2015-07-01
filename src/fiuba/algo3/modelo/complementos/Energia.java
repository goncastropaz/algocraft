package fiuba.algo3.modelo.complementos;


public class Energia {

	
	private Integer energiaTotal;
	private Integer energiaActual;
	
	public Energia(Integer energiaTotal,Integer energiaInicial){
		this.energiaTotal = energiaTotal;
		this.energiaActual = energiaInicial;
	}

	public Integer getEnergiaTotal() {
		return energiaTotal;
	}

	public Integer getEnergiaActual() {
		return energiaActual;
	}
	
	public void setEnergiaActual(Integer energiaActual){
		this.energiaActual = energiaActual;
	}

	public void recargarEnergia(Integer energia){
		if((this.energiaActual + energia) > this.energiaTotal) this.energiaActual = this.energiaTotal;
		else{
			this.energiaActual = (this.energiaActual + energia) ;
		}
	}

	public void reducirEnergia(Integer energiaRequerida) {
		this.energiaActual = this.energiaActual - energiaRequerida;
		
	}

	public boolean esMenor(Integer energiaRequerida) {
		return (this.energiaActual< energiaRequerida);
	}
}