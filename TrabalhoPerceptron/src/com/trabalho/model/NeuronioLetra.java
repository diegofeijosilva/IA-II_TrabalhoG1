package com.trabalho.model;

public class NeuronioLetra {
	
	private double w0; // pesos

	// Representa as 64 entradas - Matriz de 8 x 8
	private Double w[] = new Double[64];
	
	public NeuronioLetra() {
		
		for(int i=0; i < 64; i++){
			w[i] = (double) 0;
		}
		
	}

	public double calculaV(int x[][]) {
		
		Double soma = (double) 0;
		int posW = -1;
		
		// Percorre as linhas da matriz
		for(int i=0; i < 8; i++){
			for(int j=0; j < 8; j++){
				
				posW++; // próximo peso
				
				soma = soma + (w[posW] * x[j][i]);
				
			}
			
		}

		return w0 + soma;

	}

	public int calculaY(int x[][]) { // aplica a função

		double v = calculaV(x);

		if (v >= 0)
			return 1;
		return 0;
	}

	public String toString() {
		String ret = "Pesos: W[0]="+getW0();
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

}
