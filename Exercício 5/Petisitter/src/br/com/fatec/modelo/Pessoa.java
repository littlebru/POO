package br.com.fatec.modelo;


public class Pessoa {
	String nome;
	String cpf;
	Telefone telefone;
	Endereco endereco;
	DataHora datahora;
	
	
	/*-------Métodos Construtores------*/
	public Pessoa(String nome, String cpf, Telefone telefone, Endereco endereco, DataHora datahora) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.datahora = datahora;
	}
		public Pessoa() {
			
	}


	/*-------Getters & Setters------*/
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public DataHora getDatahora() {
		return datahora;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setDatahora(DataHora datahora) {
		this.datahora = datahora;
	}	
	
	public void imprimir() {
		System.out.println(this.nome.toUpperCase());
		System.out.println("CPF: " + this.cpf);
		System.out.println("TELEFONE: (" + this.telefone.getDdd() + ") " + this.telefone.getNum());
		System.out.println("ENDEREÇO: " + " R." + this.endereco.getRua() + " , " + this.endereco.getBairro() + ", " + this.endereco.getNumero() );
		System.out.println("CIDADE: "+ this.endereco.getCidade() + " - " + this.endereco.getEstado());
	}
		
}
