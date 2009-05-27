package ngc;

import java.util.Random;

import modelo.PaginaRequisitada;

public class Rand extends Alocacao {

	Random r;
	public Rand(int tam) {
		super(tam);
		r = new Random();
	}

	@Override
	public void inserir(PaginaRequisitada elemento) {
		if(getPilha().size() == getTam()) {
			if(existe(elemento)) {
				setAcertos(getAcertos()+1);
			} else {
				int a = r.nextInt(getTam());
				getPilha().remove(a);
				getPilha().add(elemento);
				setFalhas(getFalhas()+1);
			}
		} else {
			if(existe(elemento)) {
				setAcertos(getAcertos()+1);
			} else {
				setFalhas(getFalhas() +1 );
				getPilha().add(elemento);
			}
		}
	}
	
}
