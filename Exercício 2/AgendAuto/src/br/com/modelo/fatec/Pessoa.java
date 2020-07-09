package br.com.modelo.fatec;

public class Pessoa {
	private String nome;
	private String cpf;
	private Telefone telefone;
	private Endereco endereco;
	private Carro carro;
	private DataHora datahora;

	public Pessoa(String nome, String cpf, Telefone telefone, Endereco endereco, Carro carro, DataHora datahora) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.carro = carro;
		this.datahora = datahora;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public Telefone getTelefone() {
		return this.telefone;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public Carro getCarro() {
		return this.carro;
	}
	
	public DataHora getDataHora() {
		return this.datahora;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public void setDataHora(DataHora datahora) {
		this.datahora = datahora;
	} 
	
	
	
	
}