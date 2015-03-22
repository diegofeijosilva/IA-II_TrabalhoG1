package com.trabalho.model;

public class NeuronioLetra {
	// Neuronio para 12 entradas

	private double w0; // pesos

	// Representa as 64 entradas - Matriz de 8 x 8
	private Double w[] = new Double[64];

	public double calculaV(Double x[]) {

		Double soma = (double) 0;
		for (int i = 0; i < x.length; i++) {
			soma = soma + (w[i] * x[i]);
		}

		return w0 + soma;

	}

	public int calculaY(Double x[]) { // aplica a função

		double v = calculaV(x);

		if (v >= 0)
			return 1;
		return 0;
	}

	public String toString() {
		return "w0 = " + w0;
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
