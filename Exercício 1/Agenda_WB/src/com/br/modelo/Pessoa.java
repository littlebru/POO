package com.br.modelo;

public abstract class Pessoa implements Comparable{
	
	public String nome;
	public int idade;
	public String dataNascimento;
	public String genero;
	
	
	/*-------- Getters e Setters ----------*/
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	/*-------- Metodos Construtores ----------*/
	
	public Pessoa() {}
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public Pessoa(String nome, int idade, String dataNascimento) {
		this.nome = nome;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
	}
	
	public abstract void imprimirDetalhado();
	public abstract void imprimirCompacto();
	
	  public int compareTo(Object outro) {
		    Pessoa n = (Pessoa)outro;
		    int ultimaComparacao = nome.compareTo(n.nome);
		    return (ultimaComparacao != 0 ? ultimaComparacao : nome.compareTo(n.nome));
	  }
}
