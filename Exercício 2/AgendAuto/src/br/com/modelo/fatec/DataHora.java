package br.com.modelo.fatec;

public class DataHora {
	private String antiga;
	private String atual;
	
	
	public DataHora(String antiga, String atual) {
		super();
		this.antiga = antiga;
		this.atual = atual;
	}

	public String getAntiga() {
		return antiga;
	}

	public void setAntiga(String antiga) {
		this.antiga = antiga;
	}

	public String getAtual() {
		return atual;
	}

	public void setAtual(String atual) {
		this.atual = atual;
	}

}
