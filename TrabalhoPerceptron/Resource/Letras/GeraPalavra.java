import java.util.*;
import java.io.*;

class GeraPalavra {

	public static void main(String[] args) throws Exception{

		// Se nao passou as letras, sai do programa
		if (args.length == 0){
			System.out.println("Informe as letras");
			System.exit(0);
		}

		// Abre os arquivos
		ArrayList <BufferedReader> arquivos = new ArrayList<BufferedReader>();
		String arquivoSaida = "";
		for(String letra: args){
			BufferedReader buf = new BufferedReader(new FileReader(new File(letra + ".txt")));
			arquivos.add(buf);
			arquivoSaida+=letra;
		}

		// Gera o arquivo de saida
		BufferedWriter saida = new BufferedWriter(new FileWriter(new File(arquivoSaida+".txt")));
		for(int i=1; i<=8; i++){
			String linha = "";
			for(BufferedReader buf: arquivos){
				linha+=buf.readLine();
				linha+="0";
			}
			saida.write(linha+"\n");
		}

		for(BufferedReader buf: arquivos){
			buf.close();
		}
		saida.close();

	}
}