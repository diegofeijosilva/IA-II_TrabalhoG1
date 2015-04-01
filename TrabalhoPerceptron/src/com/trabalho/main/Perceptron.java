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
import java.util.Scanner;

import com.trabalho.model.NeuronioLetra;

public class Perceptron {

	// 24 letras = 12 Neuronios
	static NeuronioLetra neuronio01 = new NeuronioLetra();
	static NeuronioLetra neuronio02 = new NeuronioLetra();
	static NeuronioLetra neuronio03 = new NeuronioLetra();
	static NeuronioLetra neuronio04 = new NeuronioLetra();
	static NeuronioLetra neuronio05 = new NeuronioLetra();
	static NeuronioLetra neuronio06 = new NeuronioLetra();
	static NeuronioLetra neuronio07 = new NeuronioLetra();
	static NeuronioLetra neuronio08 = new NeuronioLetra();
	static NeuronioLetra neuronio09 = new NeuronioLetra();
	static NeuronioLetra neuronio10 = new NeuronioLetra();
	static NeuronioLetra neuronio11 = new NeuronioLetra();
	static NeuronioLetra neuronio12 = new NeuronioLetra();

	// DIRETÓRIO ONDE SE ENCONTRA AS LETRAS
	static String dirLetraA = System.getProperty("user.dir")+ "\\Resource\\Letras\\a.txt";
	static String dirLetraB = System.getProperty("user.dir")+ "\\Resource\\Letras\\b.txt";
	static String dirLetraC = System.getProperty("user.dir")+ "\\Resource\\Letras\\c.txt";
	static String dirLetraD = System.getProperty("user.dir")+ "\\Resource\\Letras\\d.txt";

	public static void main(String args[]) {

		int letra[][] = new int[8][8]; // ENTRADA

		// LETRA A = 0 - 0
		letra = populaMatriz(leArquivo(dirLetraA));
		treinar(letra, 0, neuronio01);
		treinar(letra, 0, neuronio02);

		// LETRA B = 1 - 1
		letra = populaMatriz(leArquivo(dirLetraB));
		treinar(letra, 1, neuronio01);
		treinar(letra, 1, neuronio02);

		// LETRA C = 0 - 1
		letra = populaMatriz(leArquivo(dirLetraC));
		treinar(letra, 0, neuronio01);
		treinar(letra, 1, neuronio02);

		// LETRA C = 0 - 1
		letra = populaMatriz(leArquivo(dirLetraD));
		treinar(letra, 1, neuronio01);
		treinar(letra, 0, neuronio02);

		testaRede();

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

		int retornoNeuronio01 = 0, retornoNeuronio02 = 0;

		while (true) {
			// digita novas entradas
			System.out.println("\n*** Digite -100 para encerrar ***");
			System.out.print("Digite 1: ");
			entrada1 = dados.nextInt();
			if (entrada1 == -100)
				break;

			if (entrada1 == 1) {

				// TESTA A LETRA A
				letra = populaMatriz(leArquivo(dirLetraA));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);

			}
			if (entrada1 == 2) {

				// TESTA A LETRA B
				letra = populaMatriz(leArquivo(dirLetraB));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);

			}
			if (entrada1 == 3) {

				// TESTA A LETRA C
				letra = populaMatriz(leArquivo(dirLetraC));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);

			}
			
			if (entrada1 == 4) {

				// TESTA A LETRA D
				letra = populaMatriz(leArquivo(dirLetraD));
				retornoNeuronio01 = testaEntrada(letra, neuronio01);
				retornoNeuronio02 = testaEntrada(letra, neuronio02);

			}

			if (retornoNeuronio01 == 0 && retornoNeuronio02 == 0)
				System.out.println("\nLETRA A");
			if (retornoNeuronio01 == 1 && retornoNeuronio02 == 1)
				System.out.println("\nLETRA B");
			if (retornoNeuronio01 == 0 && retornoNeuronio02 == 1)
				System.out.println("\nLETRA C");
			if (retornoNeuronio01 == 1 && retornoNeuronio02 == 0)
				System.out.println("\nLETRA D");

		}

	}

	public static int testaEntrada(int[][] letra, NeuronioLetra neuronio) {

		// TESTA LETRA DE ENTRADA
		return neuronio.calculaY(letra);

	}

	public static void treinar(int x1[][], int letra, NeuronioLetra neuronio) {

		// Treinamento
		int epocas = 0, i;
		double y, erro, erroGeral;
		double eta = 0.5d;
		// eta é a constante (taxa) de aprendizagem

		System.out.println("--- TREINAMENTO");
		while (true) {
			epocas++;
			erroGeral = 0;

			System.out.println("Epoca: " + epocas);
			for (i = 0; i < 1; i++) {

				// propagação
				y = neuronio.calculaY(x1);

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
				System.out.println("Neuronio " + neuronio);
				erroGeral = erroGeral + abs(erro);
			}

			// pára quando para todas as entradas o erro for zero
			if (erroGeral == 0)
				break;
		}

	}

}
