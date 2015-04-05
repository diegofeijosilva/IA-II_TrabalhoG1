package com.trabalho.main;

//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.trabalho.model.Arquivos;
import com.trabalho.model.NeuronioLetra;

public class Perceptron {

	static NeuronioLetra neuronio01 = new NeuronioLetra("Neuronio01");
	static NeuronioLetra neuronio02 = new NeuronioLetra("Neuronio02");
	static NeuronioLetra neuronio03 = new NeuronioLetra("Neuronio03");
	static NeuronioLetra neuronio04 = new NeuronioLetra("Neuronio04");
	static NeuronioLetra neuronio05 = new NeuronioLetra("Neuronio05");

	// eta é a constante (taxa) de aprendizagem
	static double eta = 0.001d;
	
	// CONSTANTE DE TREINAMENTO
	static int CONTANTE_DE_TREINAMENTO = 10000;

	static int acertos = 0;
	static int erros = 0;

	public static void main(String args[]) {

		// Realiza o treinamento da REDE
		treinarRede();

		// Realizar os testes
		testaRede();

	}

	private static void treinarRede() {

		int letra[][] = new int[8][8]; // ENTRADA
		int epocas = -1;

		for (int i = 0; i < CONTANTE_DE_TREINAMENTO; i++) {

			epocas++;

			System.out.println("Epoca: " + epocas);

			// LETRA A = 0 0 0 0 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraA()));
			treinaLetra(letra, 0, 0, 0, 0, 0);

			// LETRA B = 0 0 0 0 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraB()));
			treinaLetra(letra, 0, 0, 0, 0, 1);

			// LETRA C = 0 0 0 1 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraC()));
			treinaLetra(letra, 0, 0, 0, 1, 0);

			// LETRA D = 0 0 0 1 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraD()));
			treinaLetra(letra, 0, 0, 0, 1, 1);

			// LETRA E = 0 0 1 0 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraE()));
			treinaLetra(letra, 0, 0, 1, 0, 0);

			// Letra F = 0 0 1 0 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraF()));
			treinaLetra(letra, 0, 0, 1, 0, 1);

			// Letra G = 0 0 1 1 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraG()));
			treinaLetra(letra, 0, 0, 1, 1, 0);

			// Letra H = 0 0 1 1 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraH()));
			treinaLetra(letra, 0, 0, 1, 1, 1);

			// Letra I = 0 1 0 0 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraI()));
			treinaLetra(letra, 0, 1, 0, 0, 0);

			// Letra J = 0 1 0 0 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraJ()));
			treinaLetra(letra, 0, 1, 0, 0, 1);

			// Letra K = 0 1 0 1 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraK()));
			treinaLetra(letra, 0, 1, 0, 1, 0);

			// Letra L = 0 1 0 1 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraL()));
			treinaLetra(letra, 0, 1, 0, 1, 1);

			// Letra M = 0 1 1 0 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraM()));
			treinaLetra(letra, 0, 1, 1, 0, 0);

			// Letra N = 0 1 1 0 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraN()));
			treinaLetra(letra, 0, 1, 1, 0, 1);

			// Letra O = 0 1 1 1 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraO()));
			treinaLetra(letra, 0, 1, 1, 1, 0);
				
			// Letra P = 0 1 1 1 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraP()));
			treinaLetra(letra, 0, 1, 1, 1, 1);

			// Letra Q = 1 0 0 0 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraQ()));
			treinaLetra(letra, 1, 0, 0, 0, 0);

			// Letra R = 1 0 0 0 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraR()));
			treinaLetra(letra, 1, 0, 0, 0, 1);

			// Letra S = 1 0 0 1 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraS()));
			treinaLetra(letra, 1, 0, 0, 1, 0);

			// Letra T = 1 0 0 1 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraT()));
			treinaLetra(letra, 1, 0, 0, 1, 1);

			// Letra U = 1 0 1 0 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraU()));
			treinaLetra(letra, 1, 0, 1, 0, 0);

			// Letra V = 1 0 1 0 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraV()));
			treinaLetra(letra, 1, 0, 1, 0, 1);

			// Letra W = 1 0 1 1 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraW()));
			treinaLetra(letra, 1, 0, 1, 1, 0);

			// Letra X = 1 0 1 1 1
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraX()));
			treinaLetra(letra, 1, 0, 1, 1, 1);

			// Letra Y = 1 1 0 0 0
			letra = populaMatriz(leArquivo(Arquivos.getDirLetraY()));
			treinaLetra(letra, 1, 1, 0, 0, 0);

		}

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
	private static void treinaLetra(int letra[][], int vl1, int vl2, int vl3,
			int vl4, int vl5) {

		boolean condicao = true;

		do {

			treinar(letra, vl1, neuronio01);
			treinar(letra, vl2, neuronio02);
			treinar(letra, vl3, neuronio03);
			treinar(letra, vl4, neuronio04);
			treinar(letra, vl5, neuronio05);

			if (testaEntrada(letra, neuronio01).equals(vl1)
					&& testaEntrada(letra, neuronio02).equals(vl2)
					&& testaEntrada(letra, neuronio03).equals(vl3)
					&& testaEntrada(letra, neuronio04).equals(vl4)
					&& testaEntrada(letra, neuronio05).equals(vl5)) {
				acertos++;
				condicao = false;
			} else {
				erros++;
				condicao = true;
			}

		} while (condicao);

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

	private static int[][] populaMatriz(String letra) {

		int matrizLetra[][] = new int[8][8];
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

		// TESTA A LETRA A
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraA()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		// LETRA A = 0 0 0 0 0
		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA A");

		// TESTA A LETRA B
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraB()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		// LETRA B = 0 0 0 0 1
		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA B");

		// TESTA C = 0 0 0 1 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraC()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		// LETRA C = 0 0 0 1 0
		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA C");

		// TESTA D = 0 0 0 1 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraD()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		// LETRA D = 0 0 0 1 1
		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA D");

		// TESTA E = 0 0 1 0 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraE()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		// LETRA E = 0 0 1 0 0
		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA E");

		// TESTA A LETRA F
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraF()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		// Letra F = 0 0 1 0 1
		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA F");

		// TESTA A LETRA G
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraG()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		// Letra G = 0 0 1 1 0
		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA G");

		// TESTA A LETRA H
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraH()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		// Letra H = 0 0 1 1 1
		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA H");

		// TESTA A LETRA I
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraI()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		// Letra I = 0 1 0 0 0
		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 1
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA I");

		// Letra J = 0 1 0 0 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraJ()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 1
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA J");

		// Letra K = 0 1 0 1 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraK()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 1
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA K");

		// Letra L = 0 1 0 1 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraL()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 1
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA L");

		// Letra M = 0 1 1 0 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraM()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 1
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA M");

		// Letra N = 0 1 1 0 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraN()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 1
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA N");

		// Letra O = 0 1 1 1 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraO()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 1
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA O");

		// Letra P = 0 1 1 1 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraP()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 0 && retornoNeuronio02 == 1
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA P");

		// Letra Q = 1 0 0 0 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraQ()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 1 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA Q");

		// Letra R = 1 0 0 0 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraR()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 1 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA R");

		// Letra S = 1 0 0 1 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraS()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 1 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA S");

		// Letra T = 1 0 0 1 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraT()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 1 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA T");

		// Letra U = 1 0 1 0 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraU()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 1 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA U");

		// Letra V = 1 0 1 0 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraV()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 1 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA V");

		// Letra W = 1 0 1 1 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraW()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 1 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA W");

		// Letra X = 1 0 1 1 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraX()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 1 && retornoNeuronio02 == 0
				&& retornoNeuronio03 == 1 && retornoNeuronio04 == 1
				&& retornoNeuronio05 == 1)
			System.out.println("\nLETRA X");

		// Letra Y = 1 1 0 0 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraY()));
		retornoNeuronio01 = testaEntrada(letra, neuronio01);
		retornoNeuronio02 = testaEntrada(letra, neuronio02);
		retornoNeuronio03 = testaEntrada(letra, neuronio03);
		retornoNeuronio04 = testaEntrada(letra, neuronio04);
		retornoNeuronio05 = testaEntrada(letra, neuronio05);

		if (retornoNeuronio01 == 1 && retornoNeuronio02 == 1
				&& retornoNeuronio03 == 0 && retornoNeuronio04 == 0
				&& retornoNeuronio05 == 0)
			System.out.println("\nLETRA Y");

	}

	public static Integer testaEntrada(int[][] letra, NeuronioLetra neuronio) {

		// TESTA LETRA DE ENTRADA
		return neuronio.calculaY(1, letra);

	}

	public static void treinar(int x1[][], int letra, NeuronioLetra neuronio) {

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
