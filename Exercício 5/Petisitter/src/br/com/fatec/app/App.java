package br.com.fatec.app;

import br.com.fatec.negocio.*;
import br.com.fatec.modelo.*;


public class App {
	public static void main(String[] args) {
		
		AsciiArt.printAsciiArt("🐾 PetSitter");
		
		Menu menu = new Menu();
		Agenda agenda = new Agenda();
		Controle controle;		
		
		int op = 1000;
		boolean encontrado = false;
		boolean naoEstaVazia = false;
		
		do{
			
			menu.imprimirMenu();
			controle = new Controle();
			op = controle.opcao();
			
			switch(op) {
			
			case 0:	//SAIR
				menu.fecharPrograma();
				
				continue;
				
			case 1:	// REALIZAR CADASTRO
				menu.menuCadastro();
				controle = new Controle();
				op = controle.opcao();
				
				switch(op) {
				case 1:	// CADASTRA CLIENTE
					agenda.cadastroCliente();
					break;
				
				case 2:	// CADASTRA FUNCIONARIO
					agenda.cadastroFuncionario();
					break;
				
				case 0: // VOLTAR 
					continue;
				default:
					while(op>2 || op<1) {
						System.out.println("\nINFORME UMA OPÇÃO VÁLIDA!");
						System.out.print("ESCOLHA UMA OPÇÃO:");
						op = controle.opcao();
					}
					break;
				}
				
				
				break;
			case 2:	//REALIZAR AGENDAMENTO
				menu.agendamento();
				controle = new Controle();
				op = controle.opcao();
				
				switch(op) {
				case 0:	// VOLTAR
					break;
					
				case 1: // ADICIONAR AGENDAMENTO
					encontrado = false;
					
					naoEstaVazia = agenda.verificaLista();
					
					if(naoEstaVazia){
						
						String cpf = agenda.verificaCPF();
												
						for(Pessoa cliente: agenda.clientes) {
							// Pegar o CPF de todos os clientes cadastrados na lista
							String k = cliente.getCpf(); 
													
							if (cpf.equals(k)) {	// Verifica se o CPF solicitado é igual a um CPF da lista de clientes
								encontrado = true;
	
								int posicao = agenda.clientes.indexOf(cliente);
								agenda.marcarData(posicao);
								System.out.println("AGENDAMENTO MARCADO!");
								break;
							}
							else {
								continue;
							}							
						}
						if(!encontrado) {
							System.out.printf("\nNAO EXISTE CLIENTE COM O CPF %s.", cpf);
						}
					}else{
						System.out.print("ESCOLHA UMA OPÇÃO:");
					}
					break;
					
				case 2: // EDITAR AGENDAMENTO
					encontrado = false;
					naoEstaVazia = agenda.verificaLista();
					
					if(naoEstaVazia) {
						
						String cpf = agenda.verificaCPF();
												
						for(Pessoa cliente: agenda.clientes) {
							// Pegar o CPF de todos os clientes cadastrados na lista
							String k = cliente.getCpf(); 
							
							boolean cpfValido = cpf.equals(k);
							
							if (cpfValido) {
								encontrado = true;
								
								int indexCliente = agenda.clientes.indexOf(cliente);								
								boolean existeAgendamento = agenda.verificaAgendamento(indexCliente);	// Verifica se existe algum agendamento do cliente
								
								if(existeAgendamento) {
									// Vê se o CPF solicitado é igual a um CPF da lista de clientes
									int posicao = agenda.clientes.indexOf(cliente);
									
									agenda.editarAgendamento(posicao);
									System.out.println("AGENDAMENTO MARCADO!");
									break;
								}
								else {
									System.out.println("NÃO FOI REALIZADO UM AGENDAMENTO NO NOME DO CLIENTE: " + cliente.getNome());
									break;
								}
								
							}
							else {
								continue;
							}							
						}
						if(!encontrado) {
							System.out.printf("\nNAO EXISTE CLIENTE COM O CPF %s.", cpf);
						}
					}
					break;
					
				case 3:	// CANCELAR AGENDAMENTO
					encontrado = false;
					naoEstaVazia = agenda.verificaLista();
					
					if(naoEstaVazia) {
						
						String cpf = agenda.verificaCPF();
												
						for(Pessoa cliente: agenda.clientes) {
							// Pegar o CPF de todos os clientes cadastrados na lista
							String k = cliente.getCpf(); 
							
							boolean cpfValido = cpf.equals(k);
							
							if (cpfValido) {
								encontrado = true;
								
								int indexCliente = agenda.clientes.indexOf(cliente);								
								boolean existeAgendamento = agenda.verificaAgendamento(indexCliente);	// Verifica se existe algum agendamento do cliente
								
								if(existeAgendamento) {
									// Vê se o CPF solicitado é igual a um CPF da lista de clientes
									int posicao = agenda.clientes.indexOf(cliente);
									
									agenda.cancelarAgendamento(posicao);
									break;
								}
								else {
									System.out.println("NÃO FOI REALIZADO UM AGENDAMENTO NO NOME DO CLIENTE: " + cliente.getNome());
									break;
								}
							}
							else {
								continue;
							}							
						}
						if(!encontrado) {
							System.out.printf("\nNAO EXISTE CLIENTE COM O CPF %s.", cpf);
						}
					}
					
					break;
				
				default:
					while(op>3 || op<0) {
						System.out.println("\nINFORME UMA OPÇÃO VÁLIDA!");
						System.out.print("ESCOLHA UMA OPÇÃO:");
						op = controle.opcao();
					}
				break;
				}
				
				break;
				
			case 3:	//LISTAGEM DE CLIENTES E FUNCIONARIOS
				menu.menuListagem();
				controle = new Controle();
				op = controle.opcao();
				
				switch(op) {
				
				case 1: // LISTAGEM DOS CLIENTES
					agenda.listaClientes();
					break;
				
				case 2: // LISTAGEM DOS FUNCIONÁRIOS
					agenda.listaFuncionarios();
					break;
				
				case 0: // VOLTAR
					continue;
				
				default:
					while(op>2 || op<1) {
						System.out.println("\nINFORME UMA OPÇÃO VÁLIDA!");
						System.out.print("ESCOLHA UMA OPÇÃO:");
						op = controle.opcao();
					}
					break;
				}
				break;
			case 4:	//RANKING PETS
				controle = new Controle();
				
				menu.menuRanking();
				op = controle.opcao();
				
				switch(op) {
				case 1:	// RANKING DAS RAÇAS 
					menu.menuRankingRacasComuns();
					
					controle = new Controle();
					op = controle.opcao();
					
					agenda.gerarRankingRacas(op);
					break;
				case 2: // RANKING DOS GENEROS
					menu.menuRankingGenerosFavoritos();
					
					controle = new Controle();
					op = controle.opcao();
					
					agenda.gerarRankingGeneros(op);
					
					break;
				case 0: // VOLTAR
					continue;
				
				default:
					while(op>2 || op<1) {
						System.out.println("\nINFORME UMA OPÇÃO VÁLIDA!");
						System.out.print("ESCOLHA UMA OPÇÃO:");
						op = controle.opcao();
					}
					break;
				}
				break;
			case 5:	//HISTORICO DE ATENDIMENTO FUNCIONARIO
				menu.menuHistorico();
				controle = new Controle();
				op = controle.opcao();
				
				naoEstaVazia = agenda.verificaLista();
				
				if(naoEstaVazia) {
					switch(op) {
					case 1:	// HISTORICO DO CLIENTE				
						agenda.historicoCliente();
						break;
					case 2: // HISTORICO DO FUNCIONARIO
						agenda.historicoFuncionario();
						break;
					case 0: // VOLTAR
						break;
					
					default:
						while(op>2 || op<1) {
							System.out.println("\nINFORME UMA OPÇÃO VÁLIDA!");
							System.out.print("ESCOLHA UMA OPÇÃO:");
							op = controle.opcao();
						}
						break;
					}
				}else {
					break;
				}
				
				break;
			}
			
		}while(op != 0);
		
		
		
	}
}
