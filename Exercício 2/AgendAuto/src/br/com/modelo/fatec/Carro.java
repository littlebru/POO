package br.com.modelo.fatec;

public class Carro {
	private String modelo;
	private String placa;
	private String ano;
	private String valor;
	
	
	public Carro( String modelo, String placa, String ano, String valor) {
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.valor = valor;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}






}
