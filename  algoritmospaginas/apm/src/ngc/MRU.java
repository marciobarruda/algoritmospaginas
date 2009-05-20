package ngc;

import modelo.PaginaRequisitada;

public class MRU extends Alocacao {


	public MRU(int tam) {
		super(tam);
	}

@Override
	public void inserir(PaginaRequisitada elemento) {
		if(getPilha().size() == getTam()) {
			if(existe(elemento)) {
				setAcertos(getAcertos()+1); 
				PaginaRequisitada pagina = this.consultar(elemento.getNumero());
				getPilha().remove(pagina);
				getPilha().add(elemento);
			} else {
				setFalhas(getFalhas()+1);
				getPilha().remove(0);
				getPilha().add(elemento);
			}
		} else {
			if(existe(elemento)) {
				setAcertos(getAcertos()+1);
				PaginaRequisitada pagina = this.consultar(elemento.getNumero());
				getPilha().remove(pagina);
				getPilha().add(elemento);
			} else {
				setFalhas(getFalhas()+1);
				getPilha().add(elemento);
			}
		}
		// TODO Auto-generated method stub
		
	}


	
}
