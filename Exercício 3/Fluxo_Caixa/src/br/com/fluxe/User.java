package br.com.fluxe;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -3833464408156555727L;
	
	private String username;
	private String password;
	
	public String nome;
	public String telefone;
	public String endereco;
	public String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
