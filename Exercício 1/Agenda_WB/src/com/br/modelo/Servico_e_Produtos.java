package com.br.modelo;

public class Servico_e_Produtos{
	
	private String nome;
	private String categoria;
	
	/*-------- Getters & Setters----------*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	/*----- Construtor --------*/
	public Servico_e_Produtos() {}
	
	/*METODOS ADICIONAIS*/
	
	public void imprimirServicos() {
		System.out.printf("Servico:  %s  Categoria:  %s\n", nome, categoria);
	}
	
}
