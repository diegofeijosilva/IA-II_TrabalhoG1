package com.trabalho.model;

import java.util.Random;

public class NeuronioEntrada {
	
	private static Random gerador = new Random();
	private String nome;
	
	private double w0; // Peso 0

	// Pesos dos Neurônios na camada de entrada
	private Double w[] = new Double[64];
	
	public NeuronioEntrada(String nome) {
		
		this.nome = nome;
		this.gerarPesosIniciais();
		
	}

	public double calculaVk(double x0, Integer x[][]) {
		
		Double soma = (double) 0;
		int posW = -1;
		
		// Percorre as linhas da matriz
		for(int i=0; i < 8; i++){
			for(int j=0; j < 8; j++){
				
				posW++; // próximo peso
				
				soma = soma + (w[posW] * x[j][i]);
				
			}
			
		}

		return (w0*x0) + soma;

	}

	public Integer calculaY(double x0, Integer x[][]) { // aplica a função

		double v = calculaVk(x0, x);

		v = funcaoQ(v);
		
		if (v >= 0)
			return 1;
		return 0;
	}
	
	private Double funcaoQ(Double v){
		
		return v / 2;
		
	}
	
	public void gerarPesosIniciais() {
		for (int j = 0; j < this.w.length; j++) {
			this.w[j] = gerador.nextDouble();
		}
	}

	public String toString() {
		String ret = this.nome+" - Pesos: W[0]="+getW0();
		for(int i=0; i < 64; i++){
			ret = ret + ",W[" +i+ "]=" + w[i];
		}
		
		return ret;
	}

	public double getW0() {
		return w0;
	}

	public void setW0(double w0) {
		this.w0 = w0;
	}

	public Double[] getW() {
		return w;
	}

	public void setW(Double[] w) {
		this.w = w;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
