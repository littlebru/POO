package com.br.modelo;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.br.negocio.Leitor;
import com.br.negocio.Menu;

public class Agenda{
	
	public List<Cliente> clientes= new ArrayList<Cliente>();
	List<Servico_e_Produtos> compras;
	List<String> maisVendidos = new ArrayList<String>();
	Menu menu = new Menu();
	Servico_e_Produtos serv_prod;
	Leitor leitor;
	Cliente c;
	Telefone tel;
	Cliente novoCliente;
	
	public List<String> servFemininos = Arrays.asList("Manicure", "Pedicure", "Design de Sobrancelhas", "Corte de Cabelo", "Pintura de Cabelo");
	public List<String> servMasculinos = Arrays.asList("Corte de Cabelo", "Modelagem e Corte de Barba","Depilação" , "Tratamento para Queda de Cabelo", "Produtos Especializados");
	public List<String> servEsteticos = Arrays.asList("Remoção de Rugas", "Remoção de Manchas na Pele", "Aplicação de Botox", "Tratamento para Emagrecimento", "Redução de Medidas");
	
	public void verificaLista() {
		if(clientes.isEmpty()) {		// Pior caso: lista vazia
			System.out.println("\nNENHUM CLIENTE FOI CADASTRADO NO SISTEMA!");
			return;
			}
		return;
	}
	
	/*Função: Cadastra os clientes na lista da agenda*/
	public Cliente cadastraCliente() {
		
			/* variaveis temporárias */
			String nome;
			String genero = "";
			String dataNascimento = "";
			String ddd, numero;
			int idade = 0;
			int anoAtual = LocalDate.now().getYear();	// Armazenando ano atual do sistema
			int diaNascimento, anoNascimento;
			String mesNascimento;
			
			String opcao;
			boolean adicionar = true;
			
		do {
			// Criando uma nova referencia do objeto
			novoCliente = new Cliente();
			tel = new Telefone();
			leitor =  new Leitor();
			
			/*------- ETAPA DE CADASTRO ------------*/
			System.out.println("\n------------CADASTRO DE CLIENTE--------------");
			System.out.println("Nome completo: ");
			nome = leitor.getTexto();
			novoCliente.setNome(nome);
			leitor =  new Leitor();
			
			System.out.println("Informe a Data de Nascimento na seguinte ordem:");
			
			System.out.print("Informe o ano: ");
			anoNascimento = leitor.getValor();
			leitor =  new Leitor();
			
			System.out.print("Informe o mês: ");
			mesNascimento = leitor.getTexto();
			leitor =  new Leitor();
			
			System.out.print("Informe o dia: ");
			diaNascimento = leitor.getValor();
			leitor =  new Leitor();
			
			idade = anoAtual - anoNascimento;
			novoCliente.setIdade(idade);
			leitor =  new Leitor();
			
			dataNascimento = diaNascimento + "/" + mesNascimento + "/" + anoNascimento;
			novoCliente.setDataNascimento(dataNascimento);
			
			idade = anoAtual - anoNascimento;
			novoCliente.setIdade(idade);
			
			System.out.println("Informe o genero:\n[1]Feminino\n[2]Masculino\n[3]Não Binário");
			opcao = leitor.getTexto();
			
			do {
			
			if(opcao.equals("1")) { /*Feminino*/
				genero = "Feminino";
				break;
			}
			if(opcao.equals("2")) { /*Masculino*/
				genero = "Masculino";
				break;
			}
			if(opcao.equals("3")) {
				genero = "Não Binário";
				break;
			}
			
			else {
				System.out.println("Selecione uma opção válida");
				}
			
			}while(!opcao.equals("1") || !opcao.equals("2") || !opcao.equals("3"));
			
			novoCliente.setGenero(genero);
			leitor =  new Leitor();
			
			System.out.println("----------- FORMAS DE  CONTATO------------");
			
			System.out.println("Telefone");
			System.out.println("Informe o (DDD): ");
			ddd = leitor.getTexto();
			tel.setDdd(ddd);
			leitor =  new Leitor();
			
			System.out.println("Informe o numero: ");
			numero = leitor.getTexto();
			tel.setNumero(numero);
			leitor  =  new Leitor();
			
			novoCliente.setTel(tel);
			
			System.out.println("\n-------- SERVICOS E PRODUTOS UTILIZADOS ----------");
			novoCliente.setProduto_e_Servico(adicionarCompra());
			
			/*Adicionando cliente na lista*/
			clientes.add(novoCliente);
		
			
			do {
				System.out.println("\nDeseja cadastrar mais um cliente? \n[1]SIM\n[2]NAO");
				opcao = leitor.getTexto();
				if(opcao.equals("1") || opcao.equals("2")) {
					break;
				}
				if(!opcao.equals("1") || !opcao.equals("2")) {
					System.out.println("\nInforme uma opção válida");
				}
				
			}while(!opcao.equals("1") || !opcao.equals("2"));
			
			if(opcao.equals("2")) {
				adicionar = false;
			}
			
		}while(adicionar);
		
		return novoCliente;
	}
	
	public void removerCadastro(String nome, int idade, String genero) {
		if(clientes.isEmpty()) {		// Pior caso: Lista vazia
			System.out.println("Nenhum cliente foi cadastrado!");
			return;
		}
		leitor = new Leitor();
		String opcao;
		
		for(Pessoa p: clientes) {
			if(p.getNome().toUpperCase().equals(nome) && p.getIdade() == idade && p.getGenero().equals(genero)) {
				System.out.println("Foi encontrado no sistema o usuario: ");
				p.imprimirDetalhado();
				do {
					System.out.println("Confirmar exclusão?\n[1]SIM\n[2]NÃO");
					opcao = leitor.getTexto();
					
					if(opcao.equals("1")) {
						clientes.remove(p);
						System.out.println("O usuario "+ nome + "\nfoi descadastrado do sistema");
						return;
					}
					if(opcao.equals("2")) {
						System.out.println("\n--OPERAÇÃO CANCELADA--");
						return;
					}
					
					else System.out.println("Informe uma opção válida!");
					
				}while(!opcao.equals("1") && opcao.equals("2"));
				
			}
			else {
				System.out.println("Não foi encontrado nenhum cadastro de " + nome + "\nIdade: "+ idade + "\nGenero: "+ genero);
				System.out.println("Verifique se os dados foram inseridos corretamente!");
			}
		}
	}
	
	public void imprimirClientes() {
		
		if(clientes.isEmpty()) {		// Pior caso: lista vazia
			System.out.println("\nNENHUM CLIENTE FOI CADASTRADO NO SISTEMA!");
			return;
		}
		
		int opcao = 0;
		
		Collections.sort(clientes);
		
		opcao = menu.menuClientes();
		
		switch(opcao) {
		case 0:
			return;
		case 1:
			for (Pessoa p : clientes) {
				p.imprimirDetalhado();
			}
			break;
		case 2:
			for(Pessoa p: clientes) {
				p.imprimirCompacto();
			}
			break;
		case 3:
			for(Pessoa p: clientes) {
				if(p.getGenero().equals("Feminino")) {
					p.imprimirDetalhado();
				}
			}
			break;
		case 4:
			for(Pessoa p: clientes) {
				if(p.getGenero().equals("Masculino")) {
					p.imprimirDetalhado();
				}
			}
			break;
		case 5:
			for(Pessoa p: clientes) {
				if(p.getGenero().equals("Não Binário")) {
					p.imprimirDetalhado();
				}
			}
			break;
	}
}
	
	public void editarCliente(String nome, int idade, String genero) {
		if(clientes.isEmpty()) {		// Pior caso: Lista vazia
			System.out.println("Nenhum cliente foi cadastrado!");
			return;
		}
		
		leitor = new Leitor();
		String opcao;
		int opcao_menu;
		int anoAtual = LocalDate.now().getYear();	// Armazenando ano atual do sistema
		
		for(Pessoa p: clientes) {
			if(p.getNome().toUpperCase().equals(nome) && p.getIdade() == idade && p.getGenero().equals(genero)) {
				System.out.println("Foi encontrado no sistema o usuario: ");
				p.imprimirDetalhado();
				do {
					System.out.println("Editar informações?\n[1]SIM\n[2]NÃO");
					opcao = leitor.getTexto();
					
					if(opcao.equals("1")) {
						
					
					boolean alterar = true;
					do {
						opcao_menu = menu.menuInfoCliente();
						
						switch(opcao_menu) {
						case 0: return;
						case 1:
							leitor = new Leitor();
							System.out.println("Informe o novo nome: ");
							opcao = leitor.getTexto();
							p.setNome(opcao);
							
							System.out.println("\nINFORMAÇÃO ALTERADA COM SUCESSO!!");
							p.imprimirDetalhado();
							break;
						case 2:
							leitor = new Leitor();
							System.out.println("Informe a nova data de nascimento (na seguinte ordem)");
							System.out.print("\nInforme o ano: ");
							int ano = leitor.getValor();
							leitor = new Leitor();
							
							System.out.print("\nInforme o mês:");
							int mes = leitor.getValor();
							leitor = new Leitor();
							
							System.out.println("\nInforme o dia:");
							int dia = leitor.getValor();
							
							int novaIdade = anoAtual - ano;
							p.setIdade(novaIdade);
							
							String novaDataNascimento = dia + "/" + mes+ "/" + ano;
							p.setDataNascimento(novaDataNascimento);
							
							System.out.println("\nINFORMAÇÃO ALTERADA COM SUCESSO!!");
							p.imprimirDetalhado();
							
							break;
						case 3:
							leitor = new Leitor();
							System.out.println("Informe o novo genero:\n[1]Feminino\n[2]Masculino\n[3]Não Binário");
							opcao = leitor.getTexto();
							
							do {
							
							if(opcao.equals("1")) { /*Feminino*/
								genero = "Feminino";
								break;
							}
							if(opcao.equals("2")) { /*Masculino*/
								genero = "Masculino";
								break;
							}
							if(opcao.equals("3")) {
								genero = "Não Binário";
								break;
							}
							
							else {
								System.out.println("Selecione uma opção válida");
								}
							
							}while(!opcao.equals("1") || !opcao.equals("2") || !opcao.equals("3"));
							
							p.setGenero(genero);
							
							System.out.println("\nINFORMAÇÃO ALTERADA COM SUCESSO!!");
							p.imprimirDetalhado();
							break;
						case 4:
							leitor = new Leitor();
							tel = new Telefone();
							
							System.out.println("Informe os dados do novo numero de telefone");
							
							System.out.println("Informe o (DDD): ");
							String novoDdd = leitor.getTexto();
							tel.setDdd(novoDdd);
							leitor =  new Leitor();
							
							System.out.println("Informe o numero: (9 9999-9999)");
							String novoNumero = leitor.getTexto();
							tel.setNumero(novoNumero);
							leitor  =  new Leitor();
							
							
							System.out.println("\nINFORMAÇÃO ALTERADA COM SUCESSO!!");
							p.imprimirDetalhado();
							break;
						}
						
						do {
							System.out.println("\nDeseja alterar mais alguma informação? \n[1]SIM\n[2]NAO");
							opcao = leitor.getTexto();
							if(opcao.equals("1") || opcao.equals("2")) {
								break;
							}
							if(!opcao.equals("1") || !opcao.equals("2")) {
								System.out.println("\nInforme uma opção válida");
							}
							
						}while(!opcao.equals("1") || !opcao.equals("2"));
						
						if(opcao.equals("2")) {
							alterar = false;
						}
						
						
					}while(alterar);
					
						return;
					}
					if(opcao.equals("2")) {
						System.out.println("\n--OPERAÇÃO CANCELADA--");
						return;
					}
					
					else System.out.println("Informe uma opção válida!");
					
				}while(!opcao.equals("1") && opcao.equals("2"));
				
			}
			else {
				System.out.println("Não foi encontrado nenhum cadastro de " + nome + "\nIdade: "+ idade + "\nGenero: "+ genero);
				System.out.println("Verifique se os dados foram inseridos corretamente!");
				break;
			}
		}
	}
	
	public List adicionarCompra() {
		compras = new ArrayList<Servico_e_Produtos>();
		compras.clear();
		
		String opcao;
		int opcao_menu = 0;
		boolean adicionar = true;
		
		do {
		
			opcao_menu = menu.menuServicos();
			
			switch(opcao_menu) {
			case 0:
				return compras;
			case 1:
				System.out.println("\n----------- PRODUTOS E SERVIÇOS FEMININOS -------------");
				compras.add(adicionarProdutosFemininos());
				break;
			case 2:
				System.out.println("\n----------- PRODUTOS E SERVIÇOS MASCULINOS -------------");
				compras.add(adicionarProdutosMasculinos());
				break;
			case 3: 
				System.out.println("\n----------- PRODUTOS E SERVIÇOS ESTETICOS -------------");
				compras.add(adicionarProdutosEsteticos());
				break;
			default:
				System.out.println("\nInforme um opção válida!!");
			}
			
			
			do {
				System.out.println("\nDeseja adicionar mais um serviço? \n[1]SIM\n[2]NAO");
				opcao = leitor.getTexto();
				if(opcao.equals("1") || opcao.equals("2")) {
					break;
				}
				if(!opcao.equals("1") || !opcao.equals("2")) {
					System.out.println("\nInforme uma opção válida");
				}
				
			}while(!opcao.equals("1") || !opcao.equals("2"));
			
			if(opcao.equals("2")) {
				adicionar = false;
			}
			
		}while(adicionar);
		
		return compras;
	}
	
	public Servico_e_Produtos adicionarProdutosFemininos() {
		
		leitor = new Leitor();
		serv_prod = new Servico_e_Produtos();
		String opcao;
		int cont = 1;
		
		for(String produto : servFemininos) {
			System.out.println("["+ cont +"]" + produto);
			cont ++;
		}
		
		do {
			System.out.println("\nSelecione um serviço: ");
			opcao = leitor.getTexto();
			
			if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("4") || opcao.equals("5")) {
				break;
			}
			
			if(!opcao.equals("1") || !opcao.equals("2") || !opcao.equals("3") || !opcao.equals("4") || !opcao.equals("5")) {
				System.out.println("Informe uma opção válida!\n");
			}
			
		}while(!opcao.equals("1") || !opcao.equals("2") || !opcao.equals("3") || !opcao.equals("4") || !opcao.equals("5"));
		
		serv_prod.setNome(servFemininos.get(Integer.parseInt(opcao)-1));
		serv_prod.setCategoria("Feminino");
		
		return serv_prod; 
	}
	
	public Servico_e_Produtos adicionarProdutosMasculinos() {
		
		leitor = new Leitor();
		serv_prod = new Servico_e_Produtos();
		String opcao;
		int cont = 1;
		
		for(String produto : servMasculinos) {
			System.out.println("["+ cont +"]" + produto);
			cont ++;
		}
		
		do {
			System.out.println("\nSelecione um serviço: ");
			opcao = leitor.getTexto();
			
			if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("4") || opcao.equals("5")) {
				break;
			}
			
			if(!opcao.equals("1") || !opcao.equals("2") || !opcao.equals("3") || !opcao.equals("4") || opcao.equals("5")) {
				System.out.println("Informe uma opção válida!\n");
			}
			
		}while(!opcao.equals("1") || !opcao.equals("2") || !opcao.equals("3") || !opcao.equals("4") || opcao.equals("5"));
		
		serv_prod.setNome(servMasculinos.get(Integer.parseInt(opcao)-1));
		serv_prod.setCategoria("Masculino");
		
		return serv_prod; 
	}

	public Servico_e_Produtos adicionarProdutosEsteticos() {
	
	leitor = new Leitor();
	serv_prod = new Servico_e_Produtos();
	String opcao;
	int cont = 1;
	
	for(String produto : servEsteticos) {
		System.out.println("["+ cont +"]" + produto);
		cont ++;
	}
	
	do {
		System.out.println("\nSelecione um serviço: ");
		opcao = leitor.getTexto();
		
		if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("4") || opcao.equals("5")) {
			break;
		}
		
		if(!opcao.equals("1") || !opcao.equals("2") || !opcao.equals("3") || !opcao.equals("4") || !opcao.equals("5")) {
			System.out.println("Informe uma opção válida!\n");
		}
		
	}while(!opcao.equals("1") || !opcao.equals("2") || !opcao.equals("3") || !opcao.equals("4") || !opcao.equals("5"));
	
	serv_prod.setNome(servEsteticos.get(Integer.parseInt(opcao)-1));
	serv_prod.setCategoria("Estético");
	
	return serv_prod; 
	}
	
	public void geraRelatorios() {
		
		if(clientes.isEmpty()) {
			System.out.println("\n\n---------DADOS INSUFICIENTES----------");
			System.out.println("    NENHUM CLIENTE FOI CADASTRADO   \n\n");
			return;
		}
		
		int opcao_menu;
		
		opcao_menu = menu.menuRelatorios();
		
		switch(opcao_menu) {
		case 0:
			return;
		case 1:
			mediaIdadeGeral();
			break;
		case 2:
			mediaIdadeFeminino();
			break;
		case 3:
			mediaIdadeMasculino();
			break;
		case 4:
			mediaIdadeNaoBinario();
			break;
		case 5:
			maisVendidosGeral();
			break;
		case 6:
			maisVendidosFeminino();
			break;
		case 7:
			maisVendidosMasculino();
			break;
		case 8:
			maisVendidosNaoBinario();
			break;
		}
	}
	
	public void mediaIdadeGeral() {
		int idadeMax = 0;
		int idadeMin = 0;
		int idadeMedia = 0;
		int somaGeral = 0;
		int qtdClientes = clientes.size();
		
		for(Pessoa p: clientes) {
			idadeMin = p.getIdade();
			idadeMax = p.getIdade();
			break;
		}
		for(Pessoa p : clientes) {
			somaGeral = somaGeral + p.getIdade();
			
			if(p.getIdade() > idadeMax) idadeMax = p.getIdade();
			if(p.getIdade() < idadeMin) idadeMin = p.getIdade();
		}
		
		idadeMedia = somaGeral/qtdClientes;
		
		System.out.println("------------------- RELATORIO DE MEDIA DE IDADE -------------------");
		System.out.printf("IDADE MAXIMA DO PUBLICO GERAL: %d\n", idadeMax);
		System.out.printf("IDADE MINIMA DO PUBLICO GERAL: %d\n\n", idadeMin);
		System.out.printf("MÉDIA DE IDADE DO PUBLICO GERAL: %d", idadeMedia);
		
	}
	
	public void mediaIdadeFeminino() {
		
		int idadeMax = 0;
		int idadeMin = 0;
		int idadeMedia = 0;
		int somaGeral = 0;
		int qtdClientes = clientes.size();
		
		for(Pessoa p: clientes) {
			if(p.getGenero().equals("Feminino")) {
				idadeMin = p.getIdade();
				idadeMax = p.getIdade();
			}
			break;
		}
		
		for(Pessoa p : clientes) {
			if(p.getGenero().equals("Feminino")) {
				somaGeral = somaGeral + p.getIdade();
				
				if(p.getIdade() > idadeMax) idadeMax = p.getIdade();
				if(p.getIdade() < idadeMin) idadeMin = p.getIdade();
			}
		}
		
		idadeMedia = somaGeral/qtdClientes;
		
		System.out.println("------------------- RELATORIO DE MEDIA DE IDADE -------------------");
		System.out.printf("IDADE MAXIMA DO PUBLICO FEMININO: %d\n", idadeMax);
		System.out.printf("IDADE MINIMA DO PUBLICO FEMININO: %d\n\n", idadeMin);
		System.out.printf("MÉDIA DE IDADE DO PUBLICO FEMININO: %d", idadeMedia);
	}
	
	public void mediaIdadeMasculino() {

		int idadeMax = 0;
		int idadeMin = 0;
		int idadeMedia = 0;
		int somaGeral = 0;
		int qtdClientes = clientes.size();
		
		for(Pessoa p: clientes) {
			if(p.getGenero().equals("Masculino")) {
				idadeMin = p.getIdade();
				idadeMax = p.getIdade();
			}
			break;
		}
		
		for(Pessoa p : clientes) {
			if(p.getGenero().equals("Masculino")) {
				somaGeral = somaGeral + p.getIdade();
				
				if(p.getIdade() > idadeMax) idadeMax = p.getIdade();
				if(p.getIdade() < idadeMin) idadeMin = p.getIdade();
			}
		}
		
		idadeMedia = somaGeral/qtdClientes;
		
		System.out.println("------------------- RELATORIO DE MEDIA DE IDADE -------------------");
		System.out.printf("IDADE MAXIMA DO PUBLICO MASCULINO: %d\n", idadeMax);
		System.out.printf("IDADE MINIMA DO PUBLICO MASCULINO: %d\n\n", idadeMin);
		System.out.printf("MÉDIA DE IDADE DO PUBLICO MASCULINO: %d", idadeMedia);
	}
	
	public void mediaIdadeNaoBinario() {

		int idadeMax = 0;
		int idadeMin = 0;
		int idadeMedia = 0;
		int somaGeral = 0;
		int qtdClientes = clientes.size();
		
		for(Pessoa p: clientes) {
			if(p.getGenero().equals("Não Binário")) {
				idadeMin = p.getIdade();
				idadeMax = p.getIdade();
			}
			break;
		}
		
		for(Pessoa p : clientes) {
			if(p.getGenero().equals("Não Binário")) {
				somaGeral = somaGeral + p.getIdade();
				
				if(p.getIdade() > idadeMax) idadeMax = p.getIdade();
				if(p.getIdade() < idadeMin) idadeMin = p.getIdade();
			}
		}
		
		idadeMedia = somaGeral/qtdClientes;
		
		System.out.println("------------------- RELATORIO DE MEDIA DE IDADE -------------------");
		System.out.printf("IDADE MAXIMA DO PUBLICO NÃO BINÁRIO: %d\n", idadeMax);
		System.out.printf("IDADE MINIMA DO PUBLICO NÃO BINÁRIO: %d\n\n", idadeMin);
		System.out.printf("MÉDIA DE IDADE DO PUBLICO NÃO BINÁRIO: %d", idadeMedia);
	}
	
	public void maisVendidosGeral() {
		maisVendidos.clear();
		
		System.out.println("------- PRODUTOS MAIS VENDIDOS NO GERAL ----------");
		
		for(Cliente p:clientes) {
			calculaMaisVendido(p);
		}
	}
	
	public void maisVendidosFeminino() {
		maisVendidos.clear();
		
		System.out.println("------- PRODUTOS MAIS VENDIDOS NO PÚBLICO FEMININO ----------");
		for(Cliente p: clientes) {
			
			if(p.getGenero().equals("Feminino")){
				calculaMaisVendido(p);
			}
		}
			
	}
	
	public void maisVendidosMasculino() {
		maisVendidos.clear();
		
		System.out.println("------- PRODUTOS MAIS VENDIDOS NO PÚBLICO MASCULINO ----------");
		for(Cliente p : clientes) {
			if(p.getGenero().equals("Masculino")) {
				calculaMaisVendido(p);
			}
		}
	}
	
	public void maisVendidosNaoBinario() {
		maisVendidos.clear();
		
		System.out.println("------- PRODUTOS MAIS VENDIDOS NO PÚBLICO NÃO BINÁRIO ----------");
		for(Cliente p: clientes) {
			if(p.getGenero().equals("Não Binário")) {
				calculaMaisVendido(p);
			}
		}
	}
	
	public void calculaMaisVendido(Cliente p) {
		
		maisVendidos.clear();
		int contF = 0;
		int contM = 5;
		int contE = 9;
		int[] produto_servico = new int[14];
		int maiorF = 0;
		int maiorM = 0, maiorm1 = 0, maiorm2=0, maiorm3=0, maiorm4=0;
		int maiorE = 0, maiore1=0, maiore2=0, maiore3=0, maiore4=0, maiore5=0;
		String nomeF = "", nomeM = "", nomeE = "";
		
		compras = new ArrayList<Servico_e_Produtos>();
		compras.addAll(p.getProduto_e_Servicos());
		
		for(Servico_e_Produtos s : compras) {
			
			for(int i = 0; i < 5; i++) {
				if(s.getNome().equals(servFemininos.get(i))) {
					produto_servico[i] += 1;
					
					if(produto_servico[i] > maiorF) {
						maiorF = produto_servico[i];
						nomeF = s.getNome();
					}
					
				}
				
				String nomem1="", nomem2="", nomem3="", nomem4="";
				
				if(s.getNome().equals(servMasculinos.get(i))) {
					if(i == 0) {
						produto_servico[contM] += 1;
						
						if(produto_servico[i] > maiorm1) {
							maiorm1 = produto_servico[i];
							nomem1 = s.getNome();
						}
					}
					if(i == 1) { 
						produto_servico[contM + 1] += 1;
						if(produto_servico[i] > maiorm2) {
							maiorm2 = produto_servico[i];
							nomem2 = s.getNome();
						}
					}
					if(i == 2) {
						produto_servico[contM + 2] += 1;
						
						if(produto_servico[i] > maiorm3) {
							maiorm3 = produto_servico[i];
							nomem3 = s.getNome();
						}
					}
					if(i == 3) {
						produto_servico[contM + 3] += 1;
						
						if(produto_servico[i] > maiorm4) {
							maiorm4 = produto_servico[i];
							nomem4 = s.getNome();
						}
					}
					int[] maior = {maiorm1, maiorm2, maiorm3, maiorm4};
						
					for(int j =0; j<maior.length ;j++) {
							if(maior[j] > maiorM) {
								maiorM = maior[j];
						}
					}
					
					String[] nomesm = {nomem1, nomem2, nomem3, nomem4};
					int[] maior_m = {maiorm1, maiorm2, maiorm3, maiorm4};
					
					for(int j =0; j<maior_m.length ;j++) {
						if(maior_m[j] > maiorM) {
							maiorM = maior_m[j];
							nomeM = nomesm[j];
					}
				}
				
				// Setor de Esteticos
				String nomee1="", nomee2="", nomee3="", nomee4="", nomee5 = "";
				
				if(s.getNome().equals(servEsteticos.get(i))) {
					if(i == 0) {
						produto_servico[contE] += 1;
						
						if(produto_servico[i] > maiore1) {
							maiore1 = produto_servico[i];
							nomee1 = s.getNome();
						}
					}
					if(i == 1) {
						produto_servico[contE + 1] += 1;
						
						if(produto_servico[i] > maiore2) {
							maiore2 = produto_servico[i];
							nomee2 = s.getNome();
						}
					}
					if(i == 2) {
						produto_servico[contE + 2] += 1;
						
						if(produto_servico[i] > maiore3) {
							maiore3 = produto_servico[i];
							nomee3 = s.getNome();
						}
					}
					if(i == 3) {
						produto_servico[contE + 3] += 1;
						
						if(produto_servico[i] > maiore4) {
							maiore4 = produto_servico[i];
							nomee4 = s.getNome();
						}
					}
					if(i == 4) {
						produto_servico[contE + 4] += 1;
						
						if(produto_servico[i] > maiore5) {
							maiore5 = produto_servico[i];
							nomee5 = s.getNome();
						}
					}
					int[] maior_e = {maiore1, maiore2, maiore3, maiore4, maiore5};
					String[] nomese = {nomee1, nomee2, nomee3, nomee4, nomee5};
					
					for(int j =0; j<maior_e.length ;j++) {
						if(maior_e[j] > maiorE) {
							maiorE = maior_e[j];
							nomeE = nomese[j];
					}
					
				}
			  
			}
		}
	}
		}
		System.out.printf("PRODUTO FEMININO MAIS VENDIDO: %s  \nQUANTIDADE DE VENDAS: %d\n", nomeF, maiorF);
		System.out.printf("PRODUTO MASCULINO MAIS VENDIDO: %s  \nQUANTIDADE DE VENDAS: %d\n", nomeM, maiorM);
		System.out.printf("PRODUTO ESTETICO MAIS VENDIDO: %s  \nQUANTIDADE DE VENDAS: %d\n", nomeE, maiorE);
	}

	public void gerarCSV(){
		int opcao_menu;
		
		opcao_menu = menu.menuCSV();
		
		switch(opcao_menu) {
		case 0: return;
		case 1:
			csvClientes();
			break;
		case 2:
			csvProdutos();
			break;
		}
	}
	
	public void csvClientes() {
		int anoAtual = LocalDate.now().getYear();	// Armazenando ano atual do sistema
		int mesAtual = LocalDate.now().getMonthValue();	// Armazenando mes atual do sistema
		int diaAtual = LocalDate.now().getDayOfMonth();	// Armazenando dia atual do sistema
		
		try
	    {
	        FileWriter writer = new FileWriter("WB_RELATORIO_CLIENTES"+ diaAtual +"-"+ mesAtual +"-"+anoAtual+".csv");

	        writer.append("CLIENTE" + "," + "IDADE" + "," + "GENERO" + "," + "DATA DE NASCIMENTO" + "," + "TELEFONE"+ "\n");
	        
	        for(Cliente p: clientes) {
	        	
	        	writer.append(p.getNome() + "," 
	        			+ p.getIdade() + ","
	        			+ p.getGenero() + "," 
	        			+ p.getDataNascimento() + "," 
	        			+"("+ p.getTel().getDdd()+ ") " 
	        			+ p.getTel().getNumero() + "\n");

	        }
	        writer.flush();
	        writer.close();
	        
	        System.out.println("ARQUIVO EXPORTADO COM SUCESSO");
	    }
	    catch(IOException e)
	    {
	         e.printStackTrace();
	    } 
		
	}
	
	public void csvProdutos() {
		int anoAtual = LocalDate.now().getYear();	// Armazenando ano atual do sistema
		int mesAtual = LocalDate.now().getMonthValue();	// Armazenando mes atual do sistema
		int diaAtual = LocalDate.now().getDayOfMonth();	// Armazenando dia atual do sistema
		
		try
	    {
			FileWriter writer = new FileWriter("WB_RELATORIO_PRODUTOS"+ diaAtual +"-"+ mesAtual +"-"+anoAtual+".csv");

	        writer.append("CLIENTE" + "," + "IDADE" + "," + "GENERO" + "," + "PRODUTOS E SERVIÇOS"+"\n");
	        
	        for(Cliente p: clientes) {
	        	
	        	writer.append(p.getNome() + "," 
	        			+ p.getIdade() + ","
	        			+ p.getGenero() + "," 
	        			+ p.getProduto_e_Servico()+ "\n");

	        }
	        writer.flush();
	        writer.close();
	        
	        System.out.println("ARQUIVO EXPORTADO COM SUCESSO");
	    }
	    catch(IOException e)
	    {
	         e.printStackTrace();
	    } 
	}
	
}
