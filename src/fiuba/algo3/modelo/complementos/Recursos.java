package fiuba.algo3.modelo.complementos;

public class Recursos {

	private Integer mineral;
	private Integer gas;
	
	public Recursos(Integer costoMineral, Integer costoGas) {
		this.mineral = costoMineral;
		this.gas = costoGas;
	}

	public Integer getMineral() {
		return mineral;
	}

	public Integer getGas() {
		return gas;
	}

	public void agregarMinerales(int mineral) {
		this.mineral += mineral;
	}

	public void agregarGas(int gas) {
		this.gas += gas;
	}

	public boolean tieneSuficientesRecursos(int mineral, int gasVespeno) {
		if (this.mineral <= mineral && this.gas <= gasVespeno) return true;
		return false;
	}

	public void sacarRecursos(Recursos recursos) {
		this.mineral -= recursos.getMineral();
		this.gas -= recursos.getGas();
	}
	
}
