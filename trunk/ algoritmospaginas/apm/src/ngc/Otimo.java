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
		PaginaRequisitada z = new PaginaRequisitada();
		z.setNumero(elemento.getNumero());
		z.setCaractere(elemento.getCaractere());
		z.zera();
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
					
					for(int i = 0; i < getPilha().size();i++) {
						for(int j = 0;j < aux.size(); j++ ) {
							if(aux.get(j).getNumero() == getPilha().get(i).getNumero()) {
							
								break;
							}
							getPilha().get(i).incrementa();	
						}
					}
					
					PaginaRequisitada maior = maiorContador();
					getPilha().remove(maior);
					getPilha().add(elemento);
					setFalhas(getFalhas()+1);
					for(PaginaRequisitada p : getPilha()) {
						p.zera();
					}
				}
			} else {
				if(existe(elemento)) {
					setAcertos(getAcertos() + 1);
					
				} else {
					
					setFalhas(getFalhas()+1);
					getPilha().add(elemento);
				}
			}
		}
	}
		

}
