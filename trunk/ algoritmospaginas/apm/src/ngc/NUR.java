package ngc;

import modelo.PaginaRequisitada;
public class NUR extends Alocacao {

	public NUR(int tam) {
		super(tam);
	}
	


	@Override
	public void inserir(PaginaRequisitada elemento) {
		
		if(getPilha().size() < getTam()) {
			if(existe(elemento)) {
				setAcertos(getAcertos()+1);
				PaginaRequisitada p = consultar(elemento.getNumero());
				if(!p.getM() && elemento.getM()) {
					p.setM(true);
				}
				p.setR(true);
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
