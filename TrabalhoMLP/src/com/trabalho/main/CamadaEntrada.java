package com.trabalho.main;

import java.util.ArrayList;
import java.util.List;

import com.trabalho.model.NeuronioEntrada;

public class CamadaEntrada {
	
	private String nomeCamada;
	private List<NeuronioEntrada> listaNeuronios = new ArrayList<NeuronioEntrada>();
	
	public CamadaEntrada (String nome, int qtdNeuronios) {
		
		System.out.print("Adicionando camada de entrada " + nome + " com " + qtdNeuronios + " neuronios.");
		this.nomeCamada = nome;
		this.inicializaCamada(qtdNeuronios);
		System.out.println(" [OK]");
	}

	private void inicializaCamada(int qtdNeuronios) {
		
		for (int i = 0; i < qtdNeuronios; i++) {
			
			this.listaNeuronios.add(new NeuronioEntrada("Neuronio_" + i));

		}
		
	}

	public String getNomeCamada() {
		return nomeCamada;
	}

	public List<NeuronioEntrada> getListaNeuronios() {
		return listaNeuronios;
	}
		

}
