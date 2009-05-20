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
	
}
