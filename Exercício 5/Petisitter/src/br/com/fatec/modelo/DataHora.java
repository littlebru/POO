package br.com.fatec.modelo;

public class DataHora {
	private String antiga;
	private String atual;
			
	public DataHora(String antiga, String atual) {
		this.antiga = antiga;
		this.atual = atual;
	}

	public String getDataAntiga() {
		return antiga;
	}

	public void setDataAntiga(String antiga) {
		this.antiga = antiga;
	}

	public String getDataAtual() {
		return atual;
	}

	public void setDataAtual(String atual) {
		this.atual = atual;
	}
	
	
} // FIM
