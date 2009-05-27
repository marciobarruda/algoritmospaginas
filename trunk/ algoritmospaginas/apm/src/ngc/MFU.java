package ngc;

import modelo.PaginaRequisitada;

public class MFU extends Alocacao {

	public MFU(int tam) {
		super(tam);
	}

	@Override
	public void inserir(PaginaRequisitada elemento) {
		if(getPilha().size() == getTam()) {
			if(existe(elemento)) {
				PaginaRequisitada p = consultar(elemento.getNumero());
				p.incrementa();
				setAcertos(getAcertos() + 1);
			} else {
				PaginaRequisitada p = menorContador();
				getPilha().remove(p);
				elemento.incrementa();
				getPilha().add(elemento);
				setFalhas(getFalhas() + 1);
			}
		} else {
			if(existe(elemento)) {
				PaginaRequisitada p = consultar(elemento.getNumero());
				p.incrementa();
				setAcertos(getAcertos() + 1);
			} else {
				elemento.incrementa();
				getPilha().add(elemento);
				setFalhas(getFalhas() + 1);
			}
		}
	}
	
}
