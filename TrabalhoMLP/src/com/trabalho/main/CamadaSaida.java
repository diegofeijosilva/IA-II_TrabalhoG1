package com.trabalho.main;

import java.util.ArrayList;
import java.util.List;

import com.trabalho.model.NeuronioEntrada;
import com.trabalho.model.NeuronioSaida;

public class CamadaSaida {
	
	private String nomeCamada;
	private List<NeuronioSaida> listaNeuronios = new ArrayList<NeuronioSaida>();
	
	public CamadaSaida (String nome, int qtdNeuronios) {
		
		System.out.print("Adicionando camada saída " + nome + " com " + qtdNeuronios + " neuronioss.");
		this.nomeCamada = nome;
		this.inicializaCamada(qtdNeuronios);
		System.out.println(" [OK]");
	}

	private void inicializaCamada(int qtdNeuronios) {
		
		for (int i = 0; i < qtdNeuronios; i++) {
			
			this.listaNeuronios.add(new NeuronioSaida("Neuronio_" + i));

		}
		
	}

	public String getNomeCamada() {
		return nomeCamada;
	}

	public List<NeuronioSaida> getListaNeuronios() {
		return listaNeuronios;
	}

}
