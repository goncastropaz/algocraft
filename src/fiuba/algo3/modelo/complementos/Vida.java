package fiuba.algo3.modelo.complementos;

public class Vida {

	private Integer vidaMaxima;
	private Integer vidaActual;
	
	public Vida(Integer vida){
		vidaMaxima = vida;
		vidaActual = vida;
	}

	public Integer getVidaMaxima() {
		return vidaMaxima;
	}

	public Integer getVidaActual() {
		return vidaActual;
	}
	
	public void setVidaActual(Integer vida){
		this.vidaActual = vida;
	}
}
