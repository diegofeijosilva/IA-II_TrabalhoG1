package com.trabalho.enuns;

public enum LetraEnum {
	
	A("A","00000"),
	B("B","00001"),
	C("C","00010"),
	D("D","00011"),
	E("E","00100"),
	F("F","00101"),
	G("G","00110"),
	H("H","00111"),
	I("I","01000"),
	J("J","01001"),
	K("K","01010"),
	L("L","01011"),
	M("M","01100"),
	N("N","01101"),
	O("O","01110"),
	P("P","01111"),
	Q("Q","10000"),
	R("R","10001"),
	S("S","10010"),
	T("T","10011"),
	U("U","10100"),
	V("V","10101"),
	W("W","10110"),
	X("X","10111"),
	Y("Y","11000"),
	Z("Z","11001");
	
	 private String letra;
	 
	 private String codigo;
	
	  private LetraEnum(String letra, String codigo) {
		    this.setCodigo(codigo);
		    this.setLetra(letra);
	  }

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public static String letra(String codigo) {
		LetraEnum[] vet = LetraEnum.values();
		for(int i=0; i<vet.length; i++) {
			if(codigo.equals(vet[i].getCodigo())) {
				return vet[i].getLetra();
			}
		}
		
		return "Não identificado";
	}

}
