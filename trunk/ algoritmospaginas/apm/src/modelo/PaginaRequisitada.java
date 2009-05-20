package modelo;

public class PaginaRequisitada {
	private String caractere;
	private int numero;
	private boolean r;
	private boolean m;
	
	public PaginaRequisitada() {
		
	}
	public PaginaRequisitada(int numero, String caractere) {
		this.numero = numero;
		this.caractere = caractere;
		this.r = false;
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
