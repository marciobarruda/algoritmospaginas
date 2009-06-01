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
	
	private Vector<PaginaRequisitada> pilha;
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
			pilha = new Vector<PaginaRequisitada>();
			for (int i =0;i<size; i++){
				pilha.add(new PaginaRequisitada(referencia.getListNum().get(i),referencia.getListCaract().get(i)));
			}
	}
	
	public void calcular(){
		List<Integer> list = null;
		int count;
		Vector<PaginaRequisitada> teste = new Vector<PaginaRequisitada>();
		for(PaginaRequisitada p:pilha) {
			teste.add(p);
		}
		for(int i = frameMin; i <= frameMax; i++){
			list = new ArrayList<Integer>();
			list.add(i);
			//Inicio - Segunda Chance
			m = new SegundaChance(i);
			
			count = 0;
			for(PaginaRequisitada p : pilha) {
				
				if(count == bitR) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
					}
					count = 0;
				}
				m.inserir(p);
				count++;
			}
			list.add(m.getAcertos());
			
			//Fim - Segunda Chance
			
			//Inicio - NUR
			
			m = new NUR(i);
			count = 0;
			try {
				inicializePilha();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(PaginaRequisitada p : pilha) {
				
				if(count == bitR) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
					}
					count = 0;
				}
				m.inserir(p);
				count++;
			}
			list.add(m.getAcertos());
			
			
			//Fim - NUR
			
			//Inicio - MRU
			try {
				inicializePilha();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m = new MRU(i);
			count = 0;
			for(PaginaRequisitada p : pilha) {
			
				if(count == bitR ) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
					}
					count = 0;
				}
				m.inserir(p);
				count++;
				
			}
			list.add(m.getAcertos());
			
			//Fim - MUR
			
			
			//Inicio - RAND
			try {
				inicializePilha();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m = new Rand(i);
			count = 0;
			for(PaginaRequisitada p : pilha) {
				
				if(count == bitR) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
					}
					count = 0;
				}
				m.inserir(p);
				count++;
			}
			list.add(m.getAcertos());
			
			
			//Fim - RAND
			
			//Inicio - MFU
			try {
				inicializePilha();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Alocacao x = new MFU(i);
		
			for(PaginaRequisitada p : teste) {
				x.inserir(p);
			}
			list.add(x.getAcertos());
			System.out.println(x.getAcertos());
			//Fim - MFU
			
			//Inicio - OTIMO
			try {
				inicializePilha();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m = new Otimo(i);
			count = 0;
			for(PaginaRequisitada p : pilha) {
				if(count == bitR) {
					Vector<PaginaRequisitada> b = m.getPilha();
					for(PaginaRequisitada pagina : b) {
						pagina.setR(false);
					}
					count = 0;
				}
				m.inserir(p);
				count++;
			}
			((Otimo)m).calcular();
			list.add(m.getAcertos());
			
			//Fim - OTIMO
		
			
			main.addDadoSaida(list);
		}
	}
}
