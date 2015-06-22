package fiuba.algo3.classes.stats;

public class RangoDeAtaque {
	
	private Integer rangoTierra;
	private Integer	rangoAerea;
	
	public RangoDeAtaque(Integer rangoTierra,Integer rangoAereo){
		this.rangoAerea = rangoAereo;
		this.rangoTierra = rangoTierra;
	}

	public Integer getRangoTierra() {
		return this.rangoTierra;
	}

	public Integer getRangoAerea() {
		return this.rangoAerea;
	}

}
