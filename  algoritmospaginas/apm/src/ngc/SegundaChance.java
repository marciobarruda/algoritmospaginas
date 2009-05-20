package ngc;

import modelo.PaginaRequisitada;

public class SegundaChance extends Alocacao {

	public SegundaChance(int tam) {
		super(tam);
	}

	@Override
	public void inserir(PaginaRequisitada elemento) {
		if(getPilha().size() < getTam()) {
			if(existe(elemento)) {
				setAcertos(getAcertos() + 1);
				PaginaRequisitada p = consultar(elemento.getNumero());
				p.setR(true);
			} else {
				setFalhas(getFalhas() + 1);
				elemento.setR(true);
				getPilha().add(elemento);
			}
		} else {
			if(existe(elemento)) {
				setAcertos(getAcertos() + 1);
				PaginaRequisitada p = consultar(elemento.getNumero());
				p.setR(true);
			} else {
				setFalhas(getFalhas() + 1);
				while(getPilha().get(0).getR()) {
					PaginaRequisitada p = getPilha().get(0);
					getPilha().remove(p);
					p.setR(false);
					getPilha().add(p);
				}
				getPilha().remove(0);
				elemento.setR(true);
				getPilha().add(elemento);
			}
		}
	}
	
}
