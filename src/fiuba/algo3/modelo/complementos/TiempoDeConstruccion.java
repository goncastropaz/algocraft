package fiuba.algo3.modelo.complementos;

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

	public void actualizarTiempo() {
		if(this.turnosRestantes > 0 ){
			this.turnosRestantes = this.turnosRestantes -1;
		}
		
	}
	
	public boolean terminado(){
		return (this.getTurnosRestantes() == 0 );
	}

}
