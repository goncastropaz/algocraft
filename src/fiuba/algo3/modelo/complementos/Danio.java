package fiuba.algo3.modelo.complementos;

public class Danio {

	private Integer danioTerrestre;
	private Integer danioAereo;
	
	public Danio(){
		
	}
	
	public Danio(Integer danioTerrestre, Integer danioAereo){
		this.danioTerrestre = danioTerrestre;
				this.danioAereo = danioAereo;
	}
	
	public Integer getDanioTerrestre() {
		return danioTerrestre;
	}
	public void setDanioTerrestre(Integer danioTerrestre) {
		this.danioTerrestre = danioTerrestre;
	}
	public Integer getDanioAereo() {
		return danioAereo;
	}
	public void setDanioAereo(Integer danioAereo) {
		this.danioAereo = danioAereo;
	}
	
}
