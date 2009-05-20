package modelo;

import java.util.Vector;

import ngc.*;

public class Teste {
	public static void main(String[] args) {
		
		Vector<PaginaRequisitada> pilha = new Vector<PaginaRequisitada>();
		
		pilha.add(new PaginaRequisitada(6,"w"));
		pilha.add(new PaginaRequisitada(7,"w"));
		pilha.add(new PaginaRequisitada(5,"w"));
		pilha.add(new PaginaRequisitada(5,"r"));
		pilha.add(new PaginaRequisitada(0,"r"));
		pilha.add(new PaginaRequisitada(3,"r"));
		pilha.add(new PaginaRequisitada(3,"r"));
		pilha.add(new PaginaRequisitada(0,"r"));
		pilha.add(new PaginaRequisitada(6,"r"));
		pilha.add(new PaginaRequisitada(0,"r"));
		pilha.add(new PaginaRequisitada(4,"r"));
		pilha.add(new PaginaRequisitada(1,"r"));
		pilha.add(new PaginaRequisitada(3,"r"));
		pilha.add(new PaginaRequisitada(6,"r"));
		pilha.add(new PaginaRequisitada(3,"r"));
		pilha.add(new PaginaRequisitada(7,"r"));
		pilha.add(new PaginaRequisitada(4,"r"));
		pilha.add(new PaginaRequisitada(5,"r"));
		pilha.add(new PaginaRequisitada(7,"r"));
		pilha.add(new PaginaRequisitada(4,"r"));
		
	
		Alocacao m = new MRU(4);
		
		for(PaginaRequisitada p : pilha) {
			m.inserir(p);
		}
		
		System.out.println(m.getAcertos());
		System.out.println(m.getFalhas());
		System.out.println(m.getPorcentagem());
		/*for(PaginaRequisitada p : m.getPilha()) {
			System.out.println(p.getNumero());
		}*/
		
		
	
	}
}
