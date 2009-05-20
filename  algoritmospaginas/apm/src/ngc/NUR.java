package ngc;

import modelo.PaginaRequisitada;
public class NUR extends Alocacao {

	public NUR(int tam) {
		super(tam);
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

	@Override
	public void inserir(PaginaRequisitada elemento) {
		if(getPilha().size() < getTam()) {
			if(existe(elemento)) {
				setAcertos(getAcertos()+1);
				elemento.setR(true);
				PaginaRequisitada p = consultar(elemento.getNumero());
				if(!p.getM() && elemento.getM()) {
					p.setM(true);
				}
			} else {
				setFalhas(getFalhas()+1);
				elemento.setR(true);
				getPilha().add(elemento);
			}
		} else {
			if(existe(elemento)) {
				setAcertos(getAcertos()+1);
				PaginaRequisitada p = consultar(elemento.getNumero());
				p.setR(true);
				if(!p.getM() && elemento.getM()) {
					p.setM(true);
				}
			} else {
				setFalhas(getFalhas()+1);
				PaginaRequisitada p = buscaMenorClasse();
				getPilha().remove(p);
				elemento.setR(true);
				getPilha().add(elemento);
			}
		}
	}
}
