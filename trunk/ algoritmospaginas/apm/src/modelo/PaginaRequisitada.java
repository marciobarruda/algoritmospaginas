package modelo;

public class PaginaRequisitada {
	
	private String caractere;
	private int numero;
	private boolean r;
	private boolean m;
	private int contador;

	public PaginaRequisitada(int numero, String caractere) {
		this.numero = numero;
		this.caractere = caractere;
		if(this.caractere.equalsIgnoreCase("w")) {
			this.m = true;
		} else if (this.caractere.equalsIgnoreCase("r")) {
			this.m = false;
		}
		this.r = false;
		this.contador = 0;
	}
	
	public void incrementa() {
		this.contador++;
	}
	public void zera() {
		this.contador = 0;
	}
	
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	public PaginaRequisitada() {
		
	}
	
	public int getClasse() {
		int retorno = -1;
		if((this.getR()) && (this.getM())) {
			retorno = 4;
		} else if((this.getR()) && (!this.getM()) ) {
			retorno = 3;
		} else if((!this.getR()) && (this.getM())) {
			retorno = 2;
		} else if((!this.getR()) && (!this.getM())) {
			retorno = 1;
		}
		return retorno;
	}
	
	public boolean getM() {
		return m;
	}
	public void setM(boolean m) {
		this.m = m;
	}
	public boolean getR() {
		return r;
	}
	public void setR(boolean r) {
		this.r = r;
	}
	public String getCaractere() {
		return caractere;
	}
	public void setCaractere(String caractere) {
		this.caractere = caractere;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

}
