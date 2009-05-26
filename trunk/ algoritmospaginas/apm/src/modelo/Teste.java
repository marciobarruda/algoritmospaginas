package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import ngc.*;

public class Teste {
	public static void main(String[] args) {
		
		Vector<PaginaRequisitada> pilha = new Vector<PaginaRequisitada>();
		
		
		Referencia r = null;
		try {
			r = new Referencia("c:/REFERENCIAS_10000.txt");
			int size = r.getListCaract().size();
			
			for (int i =0;i<size; i++){
				pilha.add(new PaginaRequisitada(r.getListNum().get(i),r.getListCaract().get(i)));
			}
			
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	
		Alocacao m = new SegundaChance(4);
		
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
