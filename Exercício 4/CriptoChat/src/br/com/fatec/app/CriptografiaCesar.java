package br.com.fatec.app;

import java.util.Random;

public class CriptografiaCesar{
	
	//public int senha = 0;
	
	Random gerar = new Random();
	int senha = gerar.nextInt(26);
	
//	public int gerarChave() {
//		Random gerar = new Random();
//		senha = gerar.nextInt(26);
//		// gera um numero aleatório entre 0 e 26
//		return senha;
//	}

	public String encriptar(String texto) {
	    StringBuilder textoCifrado = new StringBuilder();
	    int tamanhoTexto = texto.length();

	    for (int c = 0; c < tamanhoTexto; c++) {
	        int letraCifradaASCII = ((int) texto.charAt(c)) + (this.senha - 1);

	        while (letraCifradaASCII > 126) {
	            letraCifradaASCII -= 94;
	        }

	        textoCifrado.append((char) letraCifradaASCII);
	    }

	    return textoCifrado.toString();
	}
	

	public String decriptar(String textoCifrado) {
	    StringBuilder texto = new StringBuilder();
	    int tamanhoTexto = textoCifrado.length();

	    for (int c = 0; c < tamanhoTexto; c++) {
	        int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - (this.senha - 1);

	        while (letraDecifradaASCII < 32) {
	            letraDecifradaASCII += 94;
	        }

	        texto.append((char) letraDecifradaASCII);
	    }

	    return texto.toString();
	}
}
