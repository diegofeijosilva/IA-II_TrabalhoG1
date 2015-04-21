package com.trabalho.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trabalho.model.Arquivos;
import com.trabalho.model.Letra;
import com.trabalho.model.NeuronioEntrada;
import com.trabalho.model.NeuronioOculta;
import com.trabalho.model.NeuronioSaida;

public class RedeMLP {

	// NOME DA CAMADA E QUANTIDADE DE NEURONIOS
	private static CamadaEntrada camadaEntrada = new CamadaEntrada("Entrada", 2);
	//private static CamadaOculta camadaOculta = new CamadaOculta("Oculta", 1);
	private static CamadaSaida camadaSaida = new CamadaSaida("Saida", 5);

	// LETRAS
	private static Letra letraA, letraB, letraC, letraD, letraE, letraF,
			letraG, letraH, letraI, letraJ, letraK, letraL, letraM, letraN,
			letraO, letraP, letraQ, letraR, letraS, letraT, letraU, letraV,
			letraW, letraX, letraY;

	// eta é a constante (taxa) de aprendizagem
	private static double ETA = 0.05;

	// CONSTANTE DE TREINAMENTO
	private static int CONSTANTE_DE_TREINAMENTO = 1000;
	
	private static double ERRO_INSTANTANEO = 0.5;

	private static String DIRETORIO_EXEMPLOS = "Resource/Exemplos/";

	private static int acertos = 0;
	private static int erros = 0;

	public static void main(String[] args) {

		// FAZ A LEITURA DOS ARQUIVOS E CRIA OS OBJETOS COM AS LETRAS
		inicializaLetras();

		// TREINA A REDE COM AS LETRAS
		treinarRede();

		testaRede(letraA);
		
	}

	private static boolean testaRede(Letra letra) {

		String bitsLetra[] = letra.getBits().split(";");
		
		// ENTRA COM A LETRA NA REDE
		List<Integer> retornoCamadaEntrada = new ArrayList<Integer>();
		//List<Integer> retornoCamadaOculta = new ArrayList<Integer>();
		List<Integer> retornoCamadaSaida = new ArrayList<Integer>();

		// ENTRA COM A LETRA NOS NEURÔNIOS DA CAMADA DE ENTRADA
		for (NeuronioEntrada neuronioEntrada : camadaEntrada.getListaNeuronios()) {

			Integer v = neuronioEntrada.calculaY(1, letra.getLetra());

			retornoCamadaEntrada.add(v);

		}

		// ENTRA COM OS VALORES DA CAMADA OCULTA NA CAMADA DE SAIDA
		for (NeuronioSaida neuronioSaida : camadaSaida.getListaNeuronios()) {

			Integer v = neuronioSaida.calculaY(1, retornoCamadaEntrada);

			retornoCamadaSaida.add(v);

		}
		
		System.out.println("\nRESULTADO: ");
		
		// VERIFICA SE CONVERGIU
		if(retornoCamadaSaida.get(0) == Integer.parseInt(bitsLetra[0])
				&& retornoCamadaSaida.get(1) == Integer.parseInt(bitsLetra[1])
				&& retornoCamadaSaida.get(2) == Integer.parseInt(bitsLetra[2])
				&& retornoCamadaSaida.get(3) == Integer.parseInt(bitsLetra[3])
				&& retornoCamadaSaida.get(4) == Integer.parseInt(bitsLetra[4]) ){
			
			System.out.println("Padrão: " + retornoCamadaSaida);
			System.out.println("REDE ENCONTROU A LETRA");

			return true;
		}
		else {
			System.out.println("RETORNO DA REDE: " + retornoCamadaSaida);
			System.out.println("LETRA NÃO RECONHECIDA");
			return false;
		}
		
	}

	private static void treinarRede() {
		
		int treino=-1;
		
		// TREINA ATÉ RECONHECER AS 2 LETRAS
		do {
			
			treino++;
			if(treino == CONSTANTE_DE_TREINAMENTO){ 
				System.out.println("REDE NÃO CONVERGIU!");
				break;
			}
			
			// LETRA A = 0 0 0 0 0
			System.out.println("\n*** TREINANDO LETRA A ***");
			treinaLetra(letraA);
			
//			// LETRA B = 0 0 0 0 1
//			System.out.println("\n*** TREINANDO LETRA B ***");
//			treinaLetra(letraB);
			
			if(testaRede(letraA))
				break;
			
		} while (true);

		
		
//		// LETRA C = 0 0 0 1 0
//		System.out.println("\n*** TREINANDO LETRA C ***");
//		treinaLetra(letraC);
//
//		// LETRA D = 0 0 0 1 1
//		System.out.println("\n*** TREINANDO LETRA D ***");
//		treinaLetra(letraD);
//
//		// LETRA E = 0 0 1 0 0
//		System.out.println("\n*** TREINANDO LETRA E ***");
//		treinaLetra(letraE);
//
//		// Letra F = 0 0 1 0 1
//		System.out.println("\n*** TREINANDO LETRA F ***");
//		treinaLetra(letraF);
//		
//		System.out.println("\n*** TREINANDO LETRA G ***");
//		treinaLetra(letraG);
//		
//		System.out.println("\n*** TREINANDO LETRA H ***");
//		treinaLetra(letraH);

	}

	private static void treinaLetra(Letra letra) {
		
		int epocas=0;
		String bitsLetra[] = letra.getBits().split(";");
		
		do {
			
			//System.out.println("\nEPOCA: " + epocas);
			
			List<Integer> retornoCamadaEntrada = new ArrayList<Integer>();
			List<Integer> retornoCamadaOculta = new ArrayList<Integer>();
			List<Integer> retornoCamadaSaida = new ArrayList<Integer>();

			// ENTRA COM A LETRA NOS NEURÔNIOS DA CAMADA DE ENTRADA
			for (NeuronioEntrada neuronioEntrada : camadaEntrada.getListaNeuronios()) {

				Integer v = neuronioEntrada.calculaY(1, letra.getLetra());

				retornoCamadaEntrada.add(v);

			}

			// ENTRA COM OS VALORES NA CAMADA DE SAIDA
			for (NeuronioSaida neuronioSaida : camadaSaida.getListaNeuronios()) {

				Integer v = neuronioSaida.calculaY(1, retornoCamadaEntrada);

				retornoCamadaSaida.add(v);

			}
			
			// VERIFICA SE CONVERGIU
			if(retornoCamadaSaida.get(0) == Integer.parseInt(bitsLetra[0])
					&& retornoCamadaSaida.get(1) == Integer.parseInt(bitsLetra[1])
					&& retornoCamadaSaida.get(2) == Integer.parseInt(bitsLetra[2])
					&& retornoCamadaSaida.get(3) == Integer.parseInt(bitsLetra[3])
					&& retornoCamadaSaida.get(4) == Integer.parseInt(bitsLetra[4]) ){
				
				System.out.println("\nPadrão: " + retornoCamadaSaida);
				System.out.println("REDE ENCONTROU A LETRA");
				System.out.println("EPOCAS NECESSÁRIAS: " + epocas);
				
				break;
			}
			
			List<Double> listaErros = new ArrayList<Double>();
			
			listaErros.add((double) (Integer.parseInt(bitsLetra[0]) - retornoCamadaSaida.get(0)));
			listaErros.add((double) (Integer.parseInt(bitsLetra[1]) - retornoCamadaSaida.get(1)));
			listaErros.add((double) (Integer.parseInt(bitsLetra[2]) - retornoCamadaSaida.get(2)));
			listaErros.add((double) (Integer.parseInt(bitsLetra[3]) - retornoCamadaSaida.get(3)));
			listaErros.add((double) (Integer.parseInt(bitsLetra[4]) - retornoCamadaSaida.get(4)));
			
			/* Calcular a energia do erro instantâneopara*/
			
			/* Calcular os gradientes da camada de saída. */
			
			List<Double> gradientesSaida = new ArrayList<Double>();
			
			gradientesSaida.add(ERRO_INSTANTANEO * listaErros.get(0));
			gradientesSaida.add(ERRO_INSTANTANEO * listaErros.get(1));
			gradientesSaida.add(ERRO_INSTANTANEO * listaErros.get(2));
			gradientesSaida.add(ERRO_INSTANTANEO * listaErros.get(3));
			gradientesSaida.add(ERRO_INSTANTANEO * listaErros.get(4));		

			/* Calcular o ajuste dos pesos de k */

			int i=0;
			for (NeuronioSaida neuronioSaida : camadaSaida.getListaNeuronios()) {
				
				Double w0 = gradientesSaida.get(i) * ETA * 1;
				
				neuronioSaida.setW0(w0);
				
				Double pesosAjustados[] = ajustaPesos(gradientesSaida.get(i), retornoCamadaSaida.get(i));
				Double pesosAntigos[] = neuronioSaida.getW();
				
				pesosAjustados[0] = pesosAntigos[0] + pesosAjustados[0];
				pesosAjustados[1] = pesosAntigos[1] + pesosAjustados[1];
//				pesosAjustados[2] = pesosAntigos[2] + pesosAjustados[2];
//				pesosAjustados[3] = pesosAntigos[3] + pesosAjustados[3];
//				pesosAjustados[4] = pesosAntigos[4] + pesosAjustados[4];
//				pesosAjustados[5] = pesosAntigos[5] + pesosAjustados[5];
//				pesosAjustados[6] = pesosAntigos[6] + pesosAjustados[6];
//				pesosAjustados[7] = pesosAntigos[7] + pesosAjustados[7];
//				pesosAjustados[8] = pesosAntigos[8] + pesosAjustados[8];
				
				neuronioSaida.setW(pesosAjustados);
				
				i++;

			}
			
			// SOMATÓRIO PESOS
			Double somatorioPesos=(double) 0;
			i = 0;
			for (NeuronioSaida neuronioSaida : camadaSaida.getListaNeuronios()) {
				
				somatorioPesos += (gradientesSaida.get(i) * neuronioSaida.getW()[0] );
				somatorioPesos += (gradientesSaida.get(i) * neuronioSaida.getW()[1] );
				i++;
			}
			
			
			System.out.println("SOMATÓRIO PESOS: " + somatorioPesos);
			
			Double g1 = somatorioPesos * ERRO_INSTANTANEO;
			
			
			for (NeuronioEntrada neuronioEntrada : camadaEntrada.getListaNeuronios()) {
				
				Double pesosAjustados[] = new Double[64];
				Double pesosAtuais[] = neuronioEntrada.getW();
				i=0;
				
				for(i=0; i < pesosAtuais.length; i++){
					pesosAjustados[i] = g1 * ETA * pesosAtuais[i];
				}
				
				neuronioEntrada.setW(pesosAjustados);
				
			}
				
//			for (Integer double1 : retornoCamadaSaida) {
//				System.out.println("Saida: " + double1);
//			}
			
			epocas++;
			
		} while (true);
		
		
		
	}
	
	private static Double[] ajustaPesos (Double gradiente, Integer retornoCamadaSaida){
		
		Double pesos[] = new Double[2];
		
		pesos[0] = gradiente * ETA * retornoCamadaSaida;
		pesos[1] = gradiente * ETA * retornoCamadaSaida;
//		pesos[2] = gradiente * eta * retornoCamadaSaida;
//		pesos[3] = gradiente * eta * retornoCamadaSaida;
//		pesos[4] = gradiente * eta * retornoCamadaSaida;
//		pesos[5] = gradiente * eta * retornoCamadaSaida;
//		pesos[6] = gradiente * eta * retornoCamadaSaida;
//		pesos[7] = gradiente * eta * retornoCamadaSaida;
//		pesos[8] = gradiente * eta * retornoCamadaSaida;
		
		return pesos;
		
	}

	// INICIALIZA AS VARIÁVEIS QUE CORRESPONDE AS LETRAS
	private static void inicializaLetras() {

		// LETRA A = 0 0 0 0 0
		letraA = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraA())),
				"0;0;0;0;0");

		// LETRA B = 0 0 0 0 1
		letraB = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraB())),
				"0;0;0;0;1");

		// LETRA C = 0 0 0 1 0
		letraC = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraC())),
				"0;0;0;1;0");

		// LETRA D = 0 0 0 1 1
		letraD = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraD())),
				"0;0;0;1;1");

		// LETRA E = 0 0 1 0 0
		letraE = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraE())),
				"0;0;1;0;0");

		// Letra F = 0 0 1 0 1
		letraF = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraF())),
				"0;0;1;0;1");

		// Letra G = 0 0 1 1 0
		letraG = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraG())),
				"0;0;1;1;0");

		// Letra H = 0 0 1 1 1
		letraH = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraH())),
				"0;0;1;1;1");

		// Letra I = 0 1 0 0 0
		letraI = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraI())),
				"0;1;0;0;0");

		// Letra J = 0 1 0 0 1
		letraJ = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraJ())),
				"0;1;0;0;1");

		// Letra K = 0 1 0 1 0
		letraK = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraK())),
				"0;1;0;1;0");

		// Letra L = 0 1 0 1 1
		letraL = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraL())),
				"0;1;0;1;1");

		// Letra M = 0 1 1 0 0
		letraM = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraM())),
				"0;1;1;0;0");

		// Letra N = 0 1 1 0 1
		letraN = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraN())),
				"0;1;1;0;1");

		// Letra O = 0 1 1 1 0
		letraO = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraO())),
				"0;1;1;1;0");

		// Letra P = 0 1 1 1 1
		letraP = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraP())),
				"0;1;1;1;1");

		// Letra Q = 1 0 0 0 0
		letraQ = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraQ())),
				"1;0;0;0;0");

		// Letra R = 1 0 0 0 1
		letraR = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraR())),
				"1;0;0;0;1");

		// Letra S = 1 0 0 1 0
		letraS = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraS())),
				"1;0;0;1;0");

		// Letra T = 1 0 0 1 1
		letraT = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraT())),
				"1;0;0;1;1");

		// Letra U = 1 0 1 0 0
		letraU = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraU())),
				"1;0;1;0;0");

		// Letra V = 1 0 1 0 1
		letraV = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraV())),
				"1;0;1;0;1");

		// Letra W = 1 0 1 1 0
		letraW = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraW())),
				"1;0;1;1;0");

		// Letra X = 1 0 1 1 1
		letraX = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraX())),
				"1;0;1;1;1");

		// Letra Y = 1 1 0 0 0
		letraY = new Letra(populaMatriz(leArquivo(Arquivos.getDirLetraY())),
				"1;1;0;0;0");

		System.out.println("Letra inicializadas. [OK]");

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

	// FAZ A LEITURA DO ARQUIVO DE LETRA
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

}
