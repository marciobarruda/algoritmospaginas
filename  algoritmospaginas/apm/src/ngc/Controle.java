package ngc;

import gui.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import modelo.PaginaRequisitada;
import modelo.Referencia;

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
		int count = 0;
		
		for(int i = frameMin; i <= frameMax; i++){
			list = new ArrayList<Integer>(7);
			list.add(i);
			//Inicio - Segunda Chance
			m = new SegundaChance(i);
			
			count = 0;
			for(PaginaRequisitada p : pilha) {
				count++;
				if(count == bitR) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
						count = 0;
					}
				}
				m.inserir(p);
			}
			list.add(m.getAcertos());
			//Fim - Segunda Chance
			
			//Inicio - NUR
			
			m = new NUR(i);
			count = 0;
			for(PaginaRequisitada p : pilha) {
				count++;
				if(count == bitR) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
						count = 0;
					}
				}
				m.inserir(p);
			}
			list.add(m.getAcertos());
			
			//Fim - NUR
			
						
			//Inicio - MRU
			m = new MRU(i);
			count = 0;
			for(PaginaRequisitada p : pilha) {
				count++;
				if(count == bitR) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
						count = 0;
					}
				}
				m.inserir(p);
			}
			list.add(m.getAcertos());
			//Fim - MUR
			
			
			//Inicio - RAND
			
			m = new Rand(i);
			count = 0;
			for(PaginaRequisitada p : pilha) {
				count++;
				if(count == bitR) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
						count = 0;
					}
				}
				m.inserir(p);
			}
			list.add(m.getAcertos());
			
			//Fim - RAND
			
			//Inicio - MFU
			
			m = new MFU(i);
			count = 0;
			for(PaginaRequisitada p : pilha) {
				count++;
				if(count == bitR) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
						count = 0;
					}
				}
				m.inserir(p);
			}
			list.add(m.getAcertos());
			
			//Fim - MFU
			
			//Inicio - OTIMO
			
			m = new Otimo(i);
			count = 0;
			for(PaginaRequisitada p : pilha) {
				count++;
				if(count == bitR) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
						count = 0;
					}
				}
				m.inserir(p);
			}
			((Otimo)m).calcular();
			list.add(m.getAcertos());
			
			//Fim - OTIMO
		
			
			main.addDadoSaida(list);
		}
		
		
	}
}
