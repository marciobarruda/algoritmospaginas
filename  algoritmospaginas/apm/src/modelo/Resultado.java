package modelo;

public class Resultado {
	
	private Integer tamMemoria;
	
	private Integer acerto;


	public Resultado(Integer tamMemoria, Integer acerto) {
		this.tamMemoria = tamMemoria;
		this.acerto = acerto;
	}

	public Integer getTamMemoria() {
		return tamMemoria;
	}

	public void setTamMemoria(Integer tamMemoria) {
		this.tamMemoria = tamMemoria;
	}

	public Integer getAcerto() {
		return acerto;
	}

	public void setAcerto(Integer acerto) {
		this.acerto = acerto;
	}
	
}
