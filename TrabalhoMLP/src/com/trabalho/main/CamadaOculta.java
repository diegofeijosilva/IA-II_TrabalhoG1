package com.trabalho.main;

import java.util.ArrayList;
import java.util.List;

import com.trabalho.model.NeuronioEntrada;
import com.trabalho.model.NeuronioOculta;

public class CamadaOculta {
	
	private String nomeCamada;
	private List<NeuronioOculta> listaNeuronios = new ArrayList<NeuronioOculta>();
	
	public CamadaOculta (String nome, int qtdNeuronios) {
		
		System.out.print("Adicionando camada oculta " + nome + " com " + qtdNeuronios + " neuronios.");
		this.nomeCamada = nome;
		this.inicializaCamada(qtdNeuronios);
		System.out.println(" [OK]");
	}

	private void inicializaCamada(int qtdNeuronios) {
		
		for (int i = 0; i < qtdNeuronios; i++) {
			
			this.listaNeuronios.add(new NeuronioOculta("Neuronio_" + i));

		}
		
	}

	public String getNomeCamada() {
		return nomeCamada;
	}

	public List<NeuronioOculta> getListaNeuronios() {
		return listaNeuronios;
	}

}
