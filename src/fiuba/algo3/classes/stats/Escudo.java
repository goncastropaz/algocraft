package fiuba.algo3.classes.stats;

public class Escudo {

	
	private Integer escudoTotal;
	private Integer escudoActual;
	
	public Escudo(Integer escudo){
		escudoTotal = escudo;
		escudoActual = escudo;
	}

	public Integer getEscudoTotal() {
		return escudoTotal;
	}

	public Integer getEscudoActual() {
		return escudoActual;
	}
	
	public void setEscudoActual(Integer escudoActual){
		this.escudoActual = escudoActual;
	}

}
