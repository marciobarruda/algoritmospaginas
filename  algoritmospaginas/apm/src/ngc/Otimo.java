package ngc;

import java.util.Vector;

import modelo.PaginaRequisitada;

public class Otimo extends Alocacao {
	
	Vector<PaginaRequisitada> a;
	
	public Otimo(int tam) {
		super(tam);
		a = new Vector<PaginaRequisitada>();
	}

	@Override
	public void inserir(PaginaRequisitada elemento) {
		a.add(elemento);
	}
	
	public void calcular() {
		
		while(!a.isEmpty()) {
			PaginaRequisitada elemento = a.remove(0);
			if(getPilha().size() == getTam()) {
				if(existe(elemento)) {
					setAcertos(getAcertos() + 1);
				} else {
					Vector<PaginaRequisitada> aux = a;
					for(PaginaRequisitada p : getPilha()) {
						for(PaginaRequisitada pAux : aux) {
							if(pAux.getNumero() != p.getNumero()) {
								p.incrementa();
							} else {
								break;
							}
						}
					}
					PaginaRequisitada maior = maiorContador();
					getPilha().remove(maior);
					getPilha().add(elemento);
					setFalhas(getFalhas()+1);
				}
			} else {
				if(existe(elemento)) {
					setAcertos(getAcertos() + 1);
					getPilha().add(elemento);
				} else {
					setFalhas(getFalhas()+1);
					getPilha().add(elemento);
				}
			}
		}
	}
		

}
