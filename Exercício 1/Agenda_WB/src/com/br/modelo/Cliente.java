package com.br.modelo;

import java.util.ArrayList;
import java.util.List;
import com.br.modelo.Telefone;
import com.br.modelo.Servico_e_Produtos;

public class Cliente extends Pessoa	{
	
	private Telefone tel;
	private List<Servico_e_Produtos> produtos_e_servicos;
	
	/*----------Getters e Setters------------*/
	
	public void setProduto_e_Servico(List produtos) {
		produtos_e_servicos = new ArrayList();
		
		produtos_e_servicos.addAll(produtos);
	}
	
	public String[] getProduto_e_Servico() {
		String[] servico = new String[produtos_e_servicos.size()];
		int cont = 0;
		for(Servico_e_Produtos s: produtos_e_servicos) {
			servico[cont] = s.getNome();
			cont ++;
		}
		return servico;
	}
	
	public List getProduto_e_Servicos() {
		return produtos_e_servicos;
	}
	
	
	public Telefone getTel() {
		return tel;
	}

	public void setTel(Telefone tel) {
		this.tel = tel;
	}
	
	/*-------- Método Construtor ----------*/
	public Cliente() {}

	public Cliente(String nome, int idade) {
		super(nome, idade);
	}
	
	/* ---------  Metodos Adicionais ------------*/
	
	public void imprimirDetalhado() {
		System.out.printf("--- %s ---------\n", nome.toUpperCase());
		System.out.println("Idade: "+ idade);
		System.out.println("Data de Nascimento: "+ dataNascimento);
		System.out.println("Genero: "+ genero);
		System.out.println("Telefone: ("+ tel.getDdd() + ") " + tel.getNumero());
		System.out.println("Servicos Utilizados");
		
		if(produtos_e_servicos.isEmpty()) {
			System.out.println("Não utilizou algum serviço ainda");
		}
		else {
			for(Servico_e_Produtos servico: produtos_e_servicos) {
				servico.imprimirServicos();
			}
		}
		System.out.println("----------------------------------\n");
	}
	
	public void imprimirCompacto() {
		System.out.printf("-- %s \n", nome.toUpperCase());
	}
	
}
