package com.br.modelo;

public class Telefone {
	
	private String ddd;
	private String numero;
	
	
	public Telefone() {}
	
	// Construtor da Classe Telefone
	public Telefone(String ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	/*---- Métodos Getters e Setters ----*/
	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
