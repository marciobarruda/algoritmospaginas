package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
/**
 * Classe que represnta o arquivo
 * @author Frota Júnior
 *
 */
public class Referencia {
	/*Lista de numeros do arquivo*/
	private List<Integer> listNum;
	/*Lista de caracter do arquivo (W or R) */
	private List<String> listCaract;
	
	public Referencia(String urlFile) throws IOException {
		//inicializa listNum
		listNum = new Vector<Integer>();
		//inicializa listCaract
		listCaract = new Vector<String>();
		//abre o arquivo
		BufferedReader file = new BufferedReader(new FileReader(urlFile));
		//Ler uma linha do arquivo
		String linha = file.readLine();
		//Fecha arquivo
		file.close();
		//Indice para pegar caracter ou número
		int indice = 0;
		for(int i=0; i < linha.length()-1; i++){
			//Pega o número e adiciona da lista
			listNum.add(Integer.parseInt(linha.substring(indice, indice+1)));
			//Pega o caracter e adiciona da lista
			listCaract.add(linha.substring(indice+1, indice+2));
			indice += 3;
			if (indice == linha.length())
				break;
		}
		
	}
	public List<Integer> getListNum() {
		return listNum;
	}
	public void setListNum(List<Integer> listNum) {
		this.listNum = listNum;
	}
	public List<String> getListCaract() {
		return listCaract;
	}
	public void setListCaract(List<String> listCaract) {
		this.listCaract = listCaract;
	}
	
}
