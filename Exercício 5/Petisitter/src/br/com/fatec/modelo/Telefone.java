package br.com.fatec.modelo;

public class Telefone {
	private String ddd;
	private String num;
	
	public Telefone(String ddd, String num) {
		this.ddd=ddd;
		this.num=num;
	}
	public String getDdd() {
		return ddd;
	}
	public String getNum() {
		return num;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public void setNum(String num) {
		this.num = num;
	}
	

}
