package com.br.negocio;

import com.br.modelo.Servico_e_Produtos;

public class Menu {
	
	Leitor leitor = new Leitor();
	int opcao = 0;
	
	// Função: Menu Principal da Aplicação
	public int menuPrincipal() {
		System.out.println("\n--------------AGENDA WB-------------\n");
		System.out.println("[1] Cadastrar Cliente");
		System.out.println("[2] Descadastrar Cliente");
		System.out.println("[3] Editar Cliente");
		System.out.println("[4] Listar Clientes");
		System.out.println("[5] Relatórios");
		System.out.println("[6] Guardar Informações em Arquivos CSV ");
		System.out.println("[0] SAIR");
		System.out.println("------------------------------------\n");

		System.out.println("\nInforme sua opcao: ");
		
		return leitor.getValor();
	}
	
	public int menuClientes() {
		System.out.println("\n------------ LISTA DE CLIENTES -------------\n");
		System.out.println("[1] Listar Informações Detalhadas");
		System.out.println("[2] Listar Apenas os Nomes");
		System.out.println("[3] Listar Clientes do Genero Feminino");
		System.out.println("[4] Listar Clientes do Genero Masculino");
		System.out.println("[5] Listar Clientes de Genero Não Binário\n");
		System.out.println("[0] VOLTAR");
		System.out.println("------------------------------------\n");
		
		
		System.out.println("\nInforme sua opção: ");
		
		return leitor.getValor();
	}
	
	public int menuInfoCliente() {
		System.out.println("\n-------- ATUALIZAR DADOS ---------");
		System.out.println("[1] Alterar nome");
		System.out.println("[2] Alterar dataNascimento");
		System.out.println("[3] Alterar genero");
		System.out.println("[4] Alterar Telefone\n");
		System.out.println("[0] CANCELAR");
		System.out.println("------------------------------------\n");
		
		System.out.println("\nInforme sua opção: ");
		
		return leitor.getValor();
	}
	
	public int menuServicos() {
		System.out.println("\n------------ LISTA DE SERVICOS ------------\n");
		System.out.println("[1] Serviços Femininos");
		System.out.println("[2] Servicos Masculinos");
		System.out.println("[3] Servicos Estéticos\n");
		System.out.println("[0] VOLTAR");
		
		System.out.println("\nInforme sua opção: ");
		
		return leitor.getValor();
	}
	
	public int menuRelatorios() {
		System.out.println("\n------------ RELATÓRIOS -----------------\n");
		System.out.println("-------------- GERAL ---------------");
		System.out.println("[1] Média de Idade do Público em Geral");
		System.out.println("[2] Média de Idade do Público Feminino");
		System.out.println("[3] Média de Idade do Público Masculino");
		System.out.println("[4] Média de Idade do Público Não Binário\n");
		System.out.println("----------- PRODUTOS E SERVIÇOS --------");
		System.out.println("[5] Produtos e Serviços mais vendido no Mês");
		System.out.println("[6] Produtos e Serviços mais vendidos no público Feminino");
		System.out.println("[7] Produtos e Serviços mais vendidos no público Masculino");
		System.out.println("[8] Produtos e Serviços mais vendidos no público Não Binário\n");
		System.out.println("[0] VOLTAR");
		
		System.out.println("\nInforme sua opção: ");
		
		return leitor.getValor();
	}
	
	public int menuCSV() {
		System.out.println("----------------EXPORTAR ARQUIVOS----------------\n");
		System.out.println("[1] Exportar Informações de Clientes");
		System.out.println("[2] Exportar Informações de Produtos\n");
		System.out.println("[0] VOLTAR");
		
		System.out.println("\nInforme sua opção: ");
		
		return leitor.getValor();
	}
	
	//--------------------------------------------------------------
	
	/* Opção Sair do Programa */
	public void finalizarPrograma() {
		System.out.println("\n\n------------------------------------\n");
		System.out.println("Voce escolheu fechar o programa\nTem certeza?");
		System.out.println("[1] Sim\n[2] Não");
		System.out.println("------------------------------------\n");
		
		int opcao = leitor.getValor();
		
		if(opcao == 1) {
			System.out.println("\n------------------------------------\n");
			System.out.println("PROGRAMA ENCERRADO");
			System.out.println("\n------------------------------------\n");
			System.exit(0);
		}
	}
}
