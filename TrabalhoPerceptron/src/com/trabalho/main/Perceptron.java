package com.trabalho.main;

//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.abs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.trabalho.model.Arquivos;
import com.trabalho.model.Letra;
import com.trabalho.model.NeuronioLetra;

public class Perceptron {

	// NEURÔNIOS
	static NeuronioLetra neuronio01 = new NeuronioLetra("Neuronio01");
	static NeuronioLetra neuronio02 = new NeuronioLetra("Neuronio02");
	static NeuronioLetra neuronio03 = new NeuronioLetra("Neuronio03");
	static NeuronioLetra neuronio04 = new NeuronioLetra("Neuronio04");
	static NeuronioLetra neuronio05 = new NeuronioLetra("Neuronio05");
	
	// LETRAS
	static Letra letraA, letraB, letraC, letraD, letraE, letraF, letraG, letraH,
			     letraI, letraJ, letraK, letraL, letraM, letraN, letraO, letraP,
			     letraQ, letraR, letraS, letraT, letraU, letraV, letraW, letraX,
			     letraY;

	// eta é a constante (taxa) de aprendizagem
	static double eta = 0.05d;

	// CONSTANTE DE TREINAMENTO
	static int CONSTANTE_DE_TREINAMENTO = 100000;

	static int acertos = 0;
	static int erros = 0;

	public static void main(String args[]) {
		
		// FAZ A LEITURA DOS ARQUIVOS E CRIA OS OBJETOS COM AS LETRAS
		inicializaLetras();

		// Realiza o treinamento da REDE
		treinarRede();

		// Realizar os testes
		testaRede();

	}

	

	private static void treinarRede() {

		int letra[][] = new int[8][8]; // ENTRADA
		int epocas = -1;

		Boolean retA = true, retB = true, retC = true, retD = true, retE = true, retF = true, retG = true, retH = true, retI = true, retJ = true, retK = true, retL = true, retM = true, retN = true, retO = true, retP = true, retQ = true, retR = true, retS = true, retT = true, retU = true, retV = true, retW = true, retX = true, retY = true;

		do {

			epocas++;

			System.out.println("Epoca: " + epocas);

			// LETRA A = 0 0 0 0 0
			treinaLetra(letraA);

			// LETRA B = 0 0 0 0 1
			treinaLetra(letraB);

			// LETRA C = 0 0 0 1 0
			treinaLetra(letraC);

			// LETRA D = 0 0 0 1 1
			treinaLetra(letraD);

			// LETRA E = 0 0 1 0 0
			treinaLetra(letraE);

			// Letra F = 0 0 1 0 1
			treinaLetra(letraF);

			// Letra G = 0 0 1 1 0
			treinaLetra(letraG);

			// Letra H = 0 0 1 1 1
			treinaLetra(letraH);

			// Letra I = 0 1 0 0 0
			treinaLetra(letraI);

			// Letra J = 0 1 0 0 1
			treinaLetra(letraJ);

			// Letra K = 0 1 0 1 0
			treinaLetra(letraK);

			// Letra L = 0 1 0 1 1
			treinaLetra(letraL);

			// Letra M = 0 1 1 0 0
			treinaLetra(letraM);

			// Letra N = 0 1 1 0 1
			treinaLetra(letraN);

			// Letra O = 0 1 1 1 0
			treinaLetra(letraO);

			// Letra P = 0 1 1 1 1
			treinaLetra(letraP);

			// Letra Q = 1 0 0 0 0
			treinaLetra(letraQ);

			// Letra R = 1 0 0 0 1
			treinaLetra(letraR);

			// Letra S = 1 0 0 1 0
			treinaLetra(letraS);

			// Letra T = 1 0 0 1 1
			treinaLetra(letraT);

			// Letra U = 1 0 1 0 0
			treinaLetra(letraU);

			// Letra V = 1 0 1 0 1
			treinaLetra(letraV);

			// Letra W = 1 0 1 1 0
			treinaLetra(letraW);

			// Letra X = 1 0 1 1 1
			treinaLetra(letraX);

			// Letra Y = 1 1 0 0 0
			treinaLetra(letraY);

			// TESTA TODAS AS LETRAS APÓS A ÉPOCA DE TREINO
			retA = verificaLetra(letraA);
			retB = verificaLetra(letraB);
			retC = verificaLetra(letraC);
			retD = verificaLetra(letraD);
			retE = verificaLetra(letraE);
			retF = verificaLetra(letraF);
			retG = verificaLetra(letraG);
			retH = verificaLetra(letraH);
			
			retI = verificaLetra(letraI);
			retJ = verificaLetra(letraJ);
			retK = verificaLetra(letraK);
			retL = verificaLetra(letraL);
			retM = verificaLetra(letraM);
			retN = verificaLetra(letraN);
			retO = verificaLetra(letraO);
			retP = verificaLetra(letraP);
			
			retQ = verificaLetra(letraQ);
			retR = verificaLetra(letraR);
			retS = verificaLetra(letraS);
			retT = verificaLetra(letraT);
			retU = verificaLetra(letraU);
			retV = verificaLetra(letraV);
			retW = verificaLetra(letraW);
			retX = verificaLetra(letraX);
			retY = verificaLetra(letraY);
			
			if(epocas == CONSTANTE_DE_TREINAMENTO) break;
			
			// SAI DO TREINAMENTO SOMENTE QUANDO TODAS AS LETRAS FOREM
			// RECONHECIDAS
		} while (!retA || !retB || !retC || !retD || !retE || !retF || !retG || !retH
				|| !retI || !retJ || !retK || !retL || !retM || !retN || !retO || !retP
				|| !retQ || !retR || !retS || !retT || !retU || !retV || !retW || !retX
				|| !retY);

		System.out.println("EPOCAS NECESSÁRIAS: " + epocas);
		System.out.println("TOTAL DE ACERTOS: " + acertos);
		System.out.println("TOTAL DE ERROS: " + erros);

		System.out.println("PESOS:");
		System.out.println("NEURONIO01:" + neuronio01);
		System.out.println("NEURONIO02:" + neuronio02);
		System.out.println("NEURONIO03:" + neuronio03);
		System.out.println("NEURONIO04:" + neuronio04);
		System.out.println("NEURONIO05:" + neuronio05);

	}

	// FUNÇÃO RECEBE A LETRA E A SEQUENCIA DE BITS QUE DEVERÁ RETORNAR DOS
	// NEURÔNIOS
	private static void treinaLetra(Letra letra) {

		boolean condicao = true;
		
		String bits[] = letra.getBits().split(";");

		do {

			treinar(letra.getLetra(), Integer.parseInt(bits[0]), neuronio01);
			treinar(letra.getLetra(), Integer.parseInt(bits[1]), neuronio02);
			treinar(letra.getLetra(), Integer.parseInt(bits[2]), neuronio03);
			treinar(letra.getLetra(), Integer.parseInt(bits[3]), neuronio04);
			treinar(letra.getLetra(), Integer.parseInt(bits[4]), neuronio05);

			if (testaEntrada(letra.getLetra(), neuronio01).equals(Integer.parseInt(bits[0]))
			 && testaEntrada(letra.getLetra(), neuronio02).equals(Integer.parseInt(bits[1]))
			 && testaEntrada(letra.getLetra(), neuronio03).equals(Integer.parseInt(bits[2]))
			 && testaEntrada(letra.getLetra(), neuronio04).equals(Integer.parseInt(bits[3]))
			 && testaEntrada(letra.getLetra(), neuronio05).equals(Integer.parseInt(bits[4]))) {
				acertos++;
				condicao = false;
			} else {
				erros++;
				condicao = true;
			}

		} while (condicao);

	}

	// VERIFICA SE A LETRA ENVIADA É RECONHECIDA
	private static Boolean verificaLetra(Letra letra) {

		Integer retornoNeuronio01, retornoNeuronio02, retornoNeuronio03, retornoNeuronio04, retornoNeuronio05;
		
		String bits[] = letra.getBits().split(";");

		retornoNeuronio01 = testaEntrada(letra.getLetra(), neuronio01);
		retornoNeuronio02 = testaEntrada(letra.getLetra(), neuronio02);
		retornoNeuronio03 = testaEntrada(letra.getLetra(), neuronio03);
		retornoNeuronio04 = testaEntrada(letra.getLetra(), neuronio04);
		retornoNeuronio05 = testaEntrada(letra.getLetra(), neuronio05);

		if (retornoNeuronio01.equals(Integer.parseInt(bits[0])) 
		 && retornoNeuronio02.equals(Integer.parseInt(bits[1]))
		 && retornoNeuronio03.equals(Integer.parseInt(bits[2]))
		 && retornoNeuronio04.equals(Integer.parseInt(bits[3]))
		 && retornoNeuronio05.equals(Integer.parseInt(bits[4])))
			return true;

		return false;
	}
	
	private static void inicializaLetras() {
		
		// LETRA A = 0 0 0 0 0
		letraA = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraA())), "0;0;0;0;0");

		// LETRA B = 0 0 0 0 1
		letraB = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraB())), "0;0;0;0;1");
		
		// LETRA C = 0 0 0 1 0
		letraC = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraC())), "0;0;0;1;0");
		
		// LETRA D = 0 0 0 1 1	
		letraD = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraD())), "0;0;0;1;1");
		
		// LETRA E = 0 0 1 0 0
		letraE = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraE())), "0;0;1;0;0");
		
		// Letra F = 0 0 1 0 1
		letraF = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraF())), "0;0;1;0;1");
		
		// Letra G = 0 0 1 1 0
		letraG = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraG())), "0;0;1;1;0");
		
		// Letra H = 0 0 1 1 1	
		letraH = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraH())), "0;0;1;1;1");
		
		// Letra I = 0 1 0 0 0
		letraI = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraI())), "0;1;0;0;0");
		
		// Letra J = 0 1 0 0 1
		letraJ = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraJ())), "0;1;0;0;1");
		
		// Letra K = 0 1 0 1 0
		letraK = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraK())), "0;1;0;1;0");
		
		// Letra L = 0 1 0 1 1
		letraL = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraL())), "0;1;0;1;1");
		
		// Letra M = 0 1 1 0 0
		letraM = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraM())), "0;1;1;0;0");
		
		// Letra N = 0 1 1 0 1
		letraN = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraN())), "0;1;1;0;1");
		
		// Letra O = 0 1 1 1 0
		letraO = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraO())), "0;1;1;1;0");
		
		// Letra P = 0 1 1 1 1
		letraP = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraP())), "0;1;1;1;1");
		
		// Letra Q = 1 0 0 0 0
		letraQ = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraQ())), "1;0;0;0;0");
		
		// Letra R = 1 0 0 0 1
		letraR = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraR())), "1;0;0;0;1");
		
		// Letra S = 1 0 0 1 0
		letraS = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraS())), "1;0;0;1;0");
		
		// Letra T = 1 0 0 1 1
		letraT = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraT())), "1;0;0;1;1");
		
		// Letra U = 1 0 1 0 0
		letraU = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraU())), "1;0;1;0;0");
		
		// Letra V = 1 0 1 0 1
		letraV = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraV())), "1;0;1;0;1");
		
		// Letra W = 1 0 1 1 0
		letraW = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraW())), "1;0;1;1;0");
		
		// Letra X = 1 0 1 1 1
		letraX = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraX())), "1;0;1;1;1");
		
		// Letra Y = 1 1 0 0 0
		letraY = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraY())), "1;1;0;0;0");
					
	}

	private static String leArquivo(String caminhoDoArquivo) {
		// Abre os arquivos

		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader(caminhoDoArquivo))
					.useDelimiter("\\||\\n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strSaida = new String();
		while (scanner.hasNext()) {

			strSaida = strSaida + scanner.next();

		}

		return strSaida;

	}

	private static Integer[][] populaMatriz(String letra) {

		Integer matrizLetra[][] = new Integer[8][8];
		int set, col, lin;

		col = -1;
		lin = 0;
		for (int i = 0; i < letra.length(); i++) {

			if (letra.charAt(i) == 'X')
				set = 1;
			else
				set = 0;

			if (col == 7) {
				col = -1;
				++lin;
			}

			matrizLetra[lin][++col] = set;

		}

		return matrizLetra;

	}

	private static void testaRede() {

		// Generalizacao - Teste da rede
		int entrada1;
		Scanner dados = new Scanner(System.in);
		System.out.println("\n--- GENERALIZACAO");

		int letra[][] = new int[8][8]; // ENTRADA

		int retornoNeuronio01 = 0, retornoNeuronio02 = 0, retornoNeuronio03 = 0, retornoNeuronio04 = 0, retornoNeuronio05 = 0;

		// LETRA A = 0 0 0 0 0
		if (verificaLetra(letraA))
			System.out.println("\nLETRA A");

		// LETRA B = 0 0 0 0 1
		if (verificaLetra(letraB))
			System.out.println("\nLETRA B");

		// TESTA C = 0 0 0 1 0
		if (verificaLetra(letraC))
			System.out.println("\nLETRA C");

		// TESTA D = 0 0 0 1 1
		if (verificaLetra(letraD))
			System.out.println("\nLETRA D");

		// TESTA E = 0 0 1 0 0
		if (verificaLetra(letraE))
			System.out.println("\nLETRA E");

		// TESTA A LETRA F
		if (verificaLetra(letraF))
			System.out.println("\nLETRA F");

		// TESTA A LETRA G
		if (verificaLetra(letraG))
			System.out.println("\nLETRA G");

		// TESTA A LETRA H
		if (verificaLetra(letraH))
			System.out.println("\nLETRA H");

		// TESTA A LETRA I
		if (verificaLetra(letraI))
			System.out.println("\nLETRA I");

		// Letra J = 0 1 0 0 1
		if (verificaLetra(letraJ))
			System.out.println("\nLETRA J");

		// Letra K = 0 1 0 1 0
		if (verificaLetra(letraK))
			System.out.println("\nLETRA K");

		// Letra L = 0 1 0 1 1
		if (verificaLetra(letraL))
			System.out.println("\nLETRA L");

		// Letra M = 0 1 1 0 0
		if (verificaLetra(letraM))
			System.out.println("\nLETRA M");

		// Letra N = 0 1 1 0 1
		if (verificaLetra(letraN))
			System.out.println("\nLETRA N");

		// Letra O = 0 1 1 1 0
		if (verificaLetra(letraO))
			System.out.println("\nLETRA O");

		// Letra P = 0 1 1 1 1
		if (verificaLetra(letraP))
			System.out.println("\nLETRA P");

		// Letra Q = 1 0 0 0 0
		if (verificaLetra(letraQ))
			System.out.println("\nLETRA Q");

		// Letra R = 1 0 0 0 1
		if (verificaLetra(letraR))
			System.out.println("\nLETRA R");

		// Letra S = 1 0 0 1 0
		if (verificaLetra(letraS))
			System.out.println("\nLETRA S");

		// Letra T = 1 0 0 1 1
		if (verificaLetra(letraT))
			System.out.println("\nLETRA T");

		// Letra U = 1 0 1 0 0
		if (verificaLetra(letraU))
			System.out.println("\nLETRA U");

		// Letra V = 1 0 1 0 1
		if (verificaLetra(letraV))
			System.out.println("\nLETRA V");

		// Letra W = 1 0 1 1 0
		if (verificaLetra(letraW))
			System.out.println("\nLETRA W");

		// Letra X = 1 0 1 1 1
		if (verificaLetra(letraX))
			System.out.println("\nLETRA X");

		// Letra Y = 1 1 0 0 0
		if (verificaLetra(letraY))
			System.out.println("\nLETRA Y");

	}

	public static Integer testaEntrada(Integer[][] letra, NeuronioLetra neuronio) {

		// TESTA LETRA DE ENTRADA
		return neuronio.calculaY(1, letra);

	}

	public static void treinar(Integer x1[][], int letra, NeuronioLetra neuronio) {

		// Treinamento
		int i;
		double y, erro, erroGeral;

		while (true) {

			erroGeral = 0;

			for (i = 0; i < 1; i++) {

				// propagação
				y = neuronio.calculaY(1, x1);

				// calcula do erro
				erro = letra - y;

				// ajuste dos pesos
				if (erro != 0) {
					neuronio.setW0(neuronio.getW0() + eta * erro);

					Double w[] = neuronio.getW();

					int posW = -1;

					// Percorre as linhas da matriz
					for (int z = 0; z < 8; z++) {
						for (int x = 0; x < 8; x++) {

							posW++; // próximo peso

							w[posW] = w[posW] + eta * erro * x1[x][z];

						}

					}

					neuronio.setW(w);

				}
				// System.out.println(neuronio);
				erroGeral = erroGeral + abs(erro);
			}

			// pára quando para todas as entradas o erro for zero
			if (erroGeral == 0)
				break;
		}

	}

}
