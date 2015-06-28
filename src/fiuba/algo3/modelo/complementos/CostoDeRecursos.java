package fiuba.algo3.modelo.complementos;

public class CostoDeRecursos {

	private Integer costoMineral;
	private Integer costoGas;
	
	public CostoDeRecursos(Integer costoMineral, Integer costoGas) {
		this.costoMineral = costoMineral;
		this.costoGas = costoGas;
	}

	public Integer getCostoMineral() {
		return costoMineral;
	}

	public Integer getCostoGas() {
		return costoGas;
	}
	
}
