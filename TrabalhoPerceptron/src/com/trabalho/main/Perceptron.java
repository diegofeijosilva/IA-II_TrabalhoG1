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

	public static void main(String args[]) {

		int letra[][] = new int[8][8]; // ENTRADA

		// Realiza o treinamento da REDE
		treinarRede(letra);

		// Realizar os testes
		testaRede();

	}

	private static void treinarRede(int letra[][]) {

		// LETRA A = 0 0 0 0 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraA()));
		treinar(letra, 0, neuronio01);
		treinar(letra, 0, neuronio02);
		treinar(letra, 0, neuronio03);
		treinar(letra, 0, neuronio04);
		treinar(letra, 0, neuronio05);

		// LETRA B = 0 0 0 0 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraB()));
		treinar(letra, 0, neuronio01);
		treinar(letra, 0, neuronio02);
		treinar(letra, 0, neuronio03);
		treinar(letra, 0, neuronio04);
		treinar(letra, 1, neuronio05);

		// LETRA C = 0 0 0 1 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraC()));
		treinar(letra, 0, neuronio01);
		treinar(letra, 0, neuronio02);
		treinar(letra, 0, neuronio03);
		treinar(letra, 1, neuronio04);
		treinar(letra, 0, neuronio05);

		// LETRA D = 0 0 0 1 1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraD()));
		treinar(letra, 0, neuronio01);
		treinar(letra, 0, neuronio02);
		treinar(letra, 0, neuronio03);
		treinar(letra, 1, neuronio04);
		treinar(letra, 1, neuronio05);

		// LETRA E = 0 0 1 0 0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraE()));
		treinar(letra, 0, neuronio01);
		treinar(letra, 0, neuronio02);
		treinar(letra, 1, neuronio03);
		treinar(letra, 0, neuronio04);
		treinar(letra, 0, neuronio05);
		
		//Letra F =	0	0	1	0	1
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraF()));
		treinar(letra, 0, neuronio01);
		treinar(letra, 0, neuronio02);
		treinar(letra, 1, neuronio03);
		treinar(letra, 0, neuronio04);
		treinar(letra, 1, neuronio05);
		
		//Letra G =	0	0	1	1	0
		letra = populaMatriz(leArquivo(Arquivos.getDirLetraG()));
		treinar(letra, 0, neuronio01);
		treinar(letra, 0, neuronio02);
		treinar(letra, 1, neuronio03);
		treinar(letra, 1, neuronio04);
		treinar(letra, 0, neuronio05);

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

		while (true) {
			// digita novas entradas
			System.out.println("\n*** Digite -100 para encerrar ***");
			System.out.print("Digite 1: ");
			entrada1 = dados.nextInt();
			if (entrada1 == -100)
				break;

			if (entrada1 == 1) {

				// TESTA A LETRA A
				letra = populaMatriz(leArquivo(Arquivos.getDirLetraA()));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);
				retornoNeuronio03 = testaEntrada(letra, neuronio03);
				retornoNeuronio04 = testaEntrada(letra, neuronio04);
				retornoNeuronio05 = testaEntrada(letra, neuronio05);

			}
			if (entrada1 == 2) {

				// TESTA A LETRA B
				letra = populaMatriz(leArquivo(Arquivos.getDirLetraB()));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);
				retornoNeuronio03 = testaEntrada(letra, neuronio03);
				retornoNeuronio04 = testaEntrada(letra, neuronio04);
				retornoNeuronio05 = testaEntrada(letra, neuronio05);

			}
			if (entrada1 == 3) {

				// TESTA A LETRA C
				letra = populaMatriz(leArquivo(Arquivos.getDirLetraC()));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);
				retornoNeuronio03 = testaEntrada(letra, neuronio03);
				retornoNeuronio04 = testaEntrada(letra, neuronio04);
				retornoNeuronio05 = testaEntrada(letra, neuronio05);

			}

			if (entrada1 == 4) {

				// TESTA A LETRA D
				letra = populaMatriz(leArquivo(Arquivos.getDirLetraD()));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);
				retornoNeuronio03 = testaEntrada(letra, neuronio03);
				retornoNeuronio04 = testaEntrada(letra, neuronio04);
				retornoNeuronio05 = testaEntrada(letra, neuronio05);

			}

			if (entrada1 == 5) {

				// TESTA A LETRA E
				letra = populaMatriz(leArquivo(Arquivos.getDirLetraE()));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);
				retornoNeuronio03 = testaEntrada(letra, neuronio03);
				retornoNeuronio04 = testaEntrada(letra, neuronio04);
				retornoNeuronio05 = testaEntrada(letra, neuronio05);

			}
			
			if (entrada1 == 6) {

				// TESTA A LETRA F
				letra = populaMatriz(leArquivo(Arquivos.getDirLetraF()));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);
				retornoNeuronio03 = testaEntrada(letra, neuronio03);
				retornoNeuronio04 = testaEntrada(letra, neuronio04);
				retornoNeuronio05 = testaEntrada(letra, neuronio05);

			}
			
			if (entrada1 == 7) {

				// TESTA A LETRA G
				letra = populaMatriz(leArquivo(Arquivos.getDirLetraG()));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);
				retornoNeuronio03 = testaEntrada(letra, neuronio03);
				retornoNeuronio04 = testaEntrada(letra, neuronio04);
				retornoNeuronio05 = testaEntrada(letra, neuronio05);

			}

			// LETRA A = 0 0 0 0 0
			if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
					&& retornoNeuronio03 == 0 && retornoNeuronio04 == 0
					&& retornoNeuronio05 == 0)
				System.out.println("\nLETRA A");
			
			// LETRA B = 0 0 0 0 1
			else if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
					&& retornoNeuronio03 == 0 && retornoNeuronio04 == 0
					&& retornoNeuronio05 == 1)
				System.out.println("\nLETRA B");
			
			// LETRA C = 0 0 0 1 0
			else if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
					&& retornoNeuronio03 == 0 && retornoNeuronio04 == 1
					&& retornoNeuronio05 == 0)
				System.out.println("\nLETRA C");
			
			// LETRA D = 0 0 0 1 1
			else if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
					&& retornoNeuronio03 == 0 && retornoNeuronio04 == 1
					&& retornoNeuronio05 == 1)
				System.out.println("\nLETRA D");
			
			// LETRA E = 0 0 1 0 0
			else if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
					&& retornoNeuronio03 == 1 && retornoNeuronio04 == 0
					&& retornoNeuronio05 == 0)
				System.out.println("\nLETRA E");
			
			//Letra F =	0	0	1	0	1
			else if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
					&& retornoNeuronio03 == 1 && retornoNeuronio04 == 0
					&& retornoNeuronio05 == 1)
				System.out.println("\nLETRA F");
			
			//Letra G =	0	0	1	1	0
			else if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0
					&& retornoNeuronio03 == 1 && retornoNeuronio04 == 1
					&& retornoNeuronio05 == 0)
				System.out.println("\nLETRA G");

		}

	}

	public static int testaEntrada(int[][] letra, NeuronioLetra neuronio) {

		// TESTA LETRA DE ENTRADA
		return neuronio.calculaY(1, letra);

	}

	public static void treinar(int x1[][], int letra, NeuronioLetra neuronio) {

		// Treinamento
		int epocas = 0, i;
		double y, erro, erroGeral;
		double eta = 0.0001d;
		// eta é a constante (taxa) de aprendizagem

		System.out.println("--- TREINAMENTO");
		while (true) {
			epocas++;
			erroGeral = 0;

			System.out.println("Epoca: " + epocas);
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
				System.out.println(neuronio);
				erroGeral = erroGeral + abs(erro);
			}

			// pára quando para todas as entradas o erro for zero
			if (erroGeral == 0)
				break;
		}

	}

}
