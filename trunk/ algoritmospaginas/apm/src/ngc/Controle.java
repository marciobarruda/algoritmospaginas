package ngc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import modelo.PaginaRequisitada;
import modelo.Referencia;
import gui.Main;

public class Controle {
	private String urlFile;
	private int frameMin;
	private int frameMax;
	private int bitR;
	private static Main main = Main.getInstacia();
	
	private Vector<PaginaRequisitada> pilha = new Vector<PaginaRequisitada>();
	private Referencia referencia;
	private Alocacao m;
	
	
	
	public Controle() throws IOException {
		urlFile = main.getJTextDiretorio().getText();
		frameMin =  (Integer) main.getFrameMin().getValue();
		frameMax = (Integer) main.getFrameMax().getValue();
		bitR = (Integer) main.getBitR().getValue();
		inicializePilha();
	}

	public void inicializePilha() throws IOException{
			referencia = new Referencia(urlFile);
			int size = referencia.getListCaract().size();
			for (int i =0;i<size; i++){
				pilha.add(new PaginaRequisitada(referencia.getListNum().get(i),referencia.getListCaract().get(i)));
			}
	}
	
	public void calcular(){
		List<Integer> list = null;
		for(int i = frameMin; i <= frameMax; i++){
			list = new Vector<Integer>();
			list.add(i);
			//Inicio - Segunda Chance
			m = new SegundaChance(i);
			
			for(PaginaRequisitada p : pilha) {
				m.inserir(p);
			}
			System.out.println("=-=-=-=-=-=-=Segunda Chance=-=-=-=-=-=-=");
			System.out.println("Quantidade de Frames: "+i+"\n");
			System.out.println("Acertos: "+m.getAcertos());
			System.out.println("Falhas: "+m.getFalhas());
			System.out.println("Porcetagem: "+m.getPorcentagem()*100+"%\n");
			list.add(m.getAcertos());
			//Fim - Segunda Chance
			
			//Inicio - NUR
			
			list.add(-1);
			
			//Fim - NUR
			
						
			//Inicio - MRU
			m = new MRU(i);
			
			for(PaginaRequisitada p : pilha) {
				m.inserir(p);
			}
			System.out.println("=-=-=-=-=-=-=MRU=-=-=-=-=-=-=");
			System.out.println("Quantidade de Frames: "+i+"\n");
			System.out.println("Acertos: "+m.getAcertos());
			System.out.println("Falhas: "+m.getFalhas());
			System.out.println("Porcetagem: "+m.getPorcentagem()*100+"%");
			System.out.println();
			list.add(m.getAcertos());
			//Fim - MUR
			
			
			//Inicio - RAND
			
			list.add(-1);
			
			//Fim - RAND
			
			//Inicio - MFU
			
			list.add(-1);
			
			//Fim - MFU
			
			//Inicio - OTIMO
			
			list.add(-1);
			
			//Fim - OTIMO
		
			
			main.addDadoSaida(list);
		}
		
		
	}
}
