package com.trabalho.model;

import java.util.List;
import java.util.Random;

public class NeuronioSaida {
	
	private static Random gerador = new Random();
	private String nome;
	
	private double w0; // Peso 0

	// Pesos dos Neurônios na camda de saída
	private Double w[] = new Double[2];
	
	public NeuronioSaida(String nome) {
		
		this.nome = nome;
		this.gerarPesosIniciais();
		
	}

	public double calculaV(double x0, List<Integer> lstValores) {
		
		Double soma = (double) 0;
		int posW = -1;
		
		for(int i=0; i < lstValores.size(); i++){
			
			soma = soma + (w[i] * lstValores.get(i));
			
		}

		return (w0*x0) + soma;

	}

	public Integer calculaY(double x0, List<Integer> lstValores) { // aplica a função

		double v = calculaV(x0, lstValores);

		if (v >= 0)
			return 1;
		return 0;
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
