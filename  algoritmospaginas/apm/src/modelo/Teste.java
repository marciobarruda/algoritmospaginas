package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

import ngc.*;

public class Teste {
	/*public static void main(String[] args) {
		
		Vector<PaginaRequisitada> pilha = new Vector<PaginaRequisitada>();
		
		
		Referencia referencia = null;
		try {
			referencia = new Referencia("c:/Nova pasta/REFERENCIAS_20.txt");
			int size = referencia.getListCaract().size();
			
			for (int i =0;i<size; i++){
				pilha.add(new PaginaRequisitada(referencia.getListNum().get(i),referencia.getListCaract().get(i)));
			}
			
			Scanner s = new Scanner(System.in);
			System.out.println("-----Informe a quantidade de Frames-----");
			System.out.println("Quantidade minina: ");
			int min = s.nextInt();
			System.out.println("Quantidade máxima: ");
			int max = s.nextInt();
			for(int i = min; i <= max; i++){
				
				Alocacao m = new MRU(i);
				
				for(PaginaRequisitada p : pilha) {
					m.inserir(p);
				}
				System.out.println("=-=-=-=-=-=-=MRU=-=-=-=-=-=-=");
				System.out.println("Quantidade de Frames: "+i+"\n");
				System.out.println("Acertos: "+m.getAcertos());
				System.out.println("Falhas: "+m.getFalhas());
				System.out.println("Porcetagem: "+m.getPorcentagem()*100+"%");
				System.out.println();
				
				
				m = new SegundaChance(i);
				
				for(PaginaRequisitada p : pilha) {
					m.inserir(p);
				}
				System.out.println("=-=-=-=-=-=-=Segunda Chance=-=-=-=-=-=-=");
				System.out.println("Quantidade de Frames: "+i+"\n");
				System.out.println("Acertos: "+m.getAcertos());
				System.out.println("Falhas: "+m.getFalhas());
				System.out.println("Porcetagem: "+m.getPorcentagem()*100+"%\n");
			
			}
			
			
			
			
			
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	
	}*/
}
