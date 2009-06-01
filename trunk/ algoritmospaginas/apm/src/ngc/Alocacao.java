package ngc;

import java.util.Vector;

import modelo.PaginaRequisitada;

public abstract class Alocacao {
	private int acertos;
	private int falhas;
	private Vector<PaginaRequisitada> pilha;
	private int tam;
	
	public Alocacao(int tam) {
		this.acertos = 0;
		this.falhas = 0;
		this.tam = tam;
		this.pilha = new Vector<PaginaRequisitada>();
	}
	
	public PaginaRequisitada menorContador() {
		PaginaRequisitada retorno = getPilha().get(0);
		for(int i = 0; i< this.pilha.size(); i++ ) {
			PaginaRequisitada p = this.pilha.get(i);
			if(p.getContador() < retorno.getContador()) {
				retorno = p;
			}
		}
		return retorno;
	}
	
	public PaginaRequisitada maiorContador() {
		PaginaRequisitada retorno = this.pilha.get(0);
		for(int i = 0; i< this.pilha.size(); i++ ) {
			if(this.pilha.get(i).getContador() > retorno.getContador()) {
				retorno = this.pilha.get(i);
			}
		}
		return retorno;
	}
	
	public int getTam() {
		return this.tam;
	}
	
	public Vector<PaginaRequisitada> getPilha() {
		return pilha;
	}

	public void setPilha(Vector<PaginaRequisitada> pilha) {
		this.pilha = pilha;
	}

	public int getAcertos() {
		return acertos;
	}

	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}

	public int getFalhas() {
		return falhas;
	}

	public void setFalhas(int falhas) {
		this.falhas = falhas;
	}

	public double getPorcentagem() {
		return (this.acertos+0.0)/(this.acertos+this.falhas);
	}


	public abstract void inserir(PaginaRequisitada elemento);

	public boolean isEmpty() {
		return (pilha.size() == 0);
	}


	public int size() {
		return pilha.size();
	}
	
	public boolean existe(PaginaRequisitada p) {
		boolean acerto = false;
		for(PaginaRequisitada elemento : pilha) {
			if(p.getNumero() == elemento.getNumero()) {
				acerto = true;	
			}
		}
		return acerto;
	}
	
	public PaginaRequisitada consultar(int num) {		
		PaginaRequisitada retorno = null;
		for(PaginaRequisitada p : pilha) {
			if(p.getNumero() == num) {
				retorno = p;
			}
		}
		return retorno;
	}
	
	public PaginaRequisitada buscaMenorClasse() {
		PaginaRequisitada retorno = getPilha().get(0);
		for(PaginaRequisitada p : getPilha()) {
			if(p.getClasse() < retorno.getClasse()) {
				retorno = p;
			}
		}
		return retorno;
	}
	
}
