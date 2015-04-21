package com.trabalho.model;

public class Letra {
	
	// MATRIZ QUE FORMA A LETRA
	private Integer letra[][] = new Integer[8][8];
	
	// SEQUENCIA DE BITS RECONHECIDA PELO NEURÔNIO
	private String bits = "0;0;0;0;0";
	
	public Letra(Integer letra[][], String bits) {
		this.letra = letra;
		this.bits = bits;
	}

	public Integer[][] getLetra() {
		return letra;
	}

	public void setLetra(Integer[][] letra) {
		this.letra = letra;
	}

	public String getBits() {
		return bits;
	}

	public void setBits(String bits) {
		this.bits = bits;
	}

}
