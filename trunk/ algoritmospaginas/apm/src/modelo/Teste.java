package modelo;

import java.util.*;

import ngc.*;

public class Teste {
	public static void main(String[] args) {
		Vector<PaginaRequisitada> vetor = new Vector<PaginaRequisitada>();
		vetor.add(new PaginaRequisitada(0,"r"));
		vetor.add(new PaginaRequisitada(1,"w"));
		vetor.add(new PaginaRequisitada(0,"w"));
		vetor.add(new PaginaRequisitada(3,"r"));
		vetor.add(new PaginaRequisitada(1,"r"));
		vetor.add(new PaginaRequisitada(5,"w"));
		vetor.add(new PaginaRequisitada(2,"r"));
		vetor.add(new PaginaRequisitada(7,"r"));
		
		vetor.add(new PaginaRequisitada(5,"r"));
		vetor.add(new PaginaRequisitada(2,"r"));
		vetor.add(new PaginaRequisitada(4,"r"));
		vetor.add(new PaginaRequisitada(2,"w"));
		vetor.add(new PaginaRequisitada(6,"r"));
		vetor.add(new PaginaRequisitada(0,"r"));
		
		for(int k = 4; k <= 8; k++) {
			Alocacao a = new MFU(k);
			int count = 0;
			for(PaginaRequisitada p : vetor) {
				count++;
				if(count == 9) {
					Vector<PaginaRequisitada> paginas = a.getPilha();
					for( PaginaRequisitada pag : paginas) {
						pag.setR(false);
					}
					count = 0;
				}
				a.inserir(p);
			}
			
			if(a instanceof Otimo) {
				((Otimo) a).calcular();
			}
			System.out.println("Acertos: "+a.getAcertos());
			System.out.println("Falhas: "+a.getFalhas());
			System.out.println("Porcentagem: "+a.getPorcentagem());
			System.out.println("-------------------------------------");
			

		}		
		
	}
}
