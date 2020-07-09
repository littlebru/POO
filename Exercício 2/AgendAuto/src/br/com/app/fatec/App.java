package br.com.app.fatec;

import br.com.modelo.fatec.Agenda;
import br.com.modelo.fatec.Endereco;
import br.com.modelo.fatec.Pessoa;
import br.com.modelo.fatec.Telefone;
import br.com.modelo.fatec.Carro;
import br.com.modelo.fatec.DataHora;
import br.com.negocio.fatec.AsciiArt;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.Menu;

public class App {
	public static void main(String[] args) {
		
		int i;
		
		AsciiArt.printAsciiArt("AGENDAUTO");
		
		Menu menu = new Menu();
		
		Agenda agenda = new Agenda();
		
		int op = 1000; 
		while(op != 0) {
			menu.imprimirMenu();
			
			Controle controler = new Controle();
			
			op = controler.opcao();
			
			switch (op) {			
					
				case 1: // INSERIR CLIENTE
					
					System.out.println("\nDigite os seguintes dados...");
					
					Controle controle1 = new Controle();
					Endereco e = new Endereco(" "," "," "," "," "," ");
					Telefone t = new Telefone(" ", " ");
					Carro c = new Carro (" "," ", " ", " ");
					DataHora d = new DataHora(" ", " ");
					Pessoa p = new Pessoa(" ", " ", t, e, c, d);
					
					System.out.print("Nome: ");
					p.setNome(controle1.texto());
					
					System.out.print("CPF: ");
					p.setCpf(controle1.texto());
					
					System.out.print("DDD: ");
					t.setDdd(controle1.texto());
					
					System.out.print("Telefone: ");
					t.setNum(controle1.texto());
					
					System.out.print("Rua: ");
					e.setRua(controle1.texto());	
					
					System.out.print("Número: ");
					e.setNumero(controle1.texto());
					
					System.out.print("Bairro: ");
					e.setBairro(controle1.texto());
					
					System.out.print("Cidade: ");
					e.setCidade(controle1.texto());
					
					System.out.print("Estado: ");
					e.setEstado(controle1.texto());
					
					System.out.print("CEP: ");
					e.setCep(controle1.texto());
					
					System.out.println("\nSOBRE O AUTOMÓVEL...");
					
					System.out.print("Modelo do veículo: ");
					c.setModelo(controle1.texto());
					
					System.out.print("Placa do veículo: ");
					c.setPlaca(controle1.texto());
					
					System.out.print("Ano de fabricação: ");
					c.setAno(controle1.texto());
					
					System.out.print("Valor da Compra: ");
					c.setValor(controle1.texto());
					
					System.out.println("\nAGENDAMENTO DE REVISÃO...");
					
					System.out.print("Dia: ");
					String dia = controle1.texto();
					
					System.out.print("Mês: ");
					String mes = controle1.texto();
					
					System.out.print("Ano: ");
					String ano = controle1.texto();
					
					System.out.print("Hora: ");
					String hora = controle1.texto();
					
					System.out.print("Minutos: ");
					String minutos = controle1.texto();
					
					System.out.print("Tipo de revisão: ");
					String revisao = controle1.texto();
					
					d.setAtual(dia + "/" + mes + "/" + ano + " " + "-" + " " + hora + ":" + minutos + " " + "->" + " " + revisao + "\n");
					d.setAntiga("");
					
					p.setEndereco(e);
					p.setTelefone(t);
					p.setCarro(c);
					
					agenda.clientes.add(p);
					agenda.datahora.add(d);
					System.out.println("\nCLIENTE CADASTRADO!");
					
					break;
					
					
				case 2: // HISTÓRICO DO CLIENTE
					
					if(agenda.clientes.size() == 0) {
						System.out.println("\nNão há clientes cadastrados!");
					}
					else {
						System.out.print("\nInforme o ID do cliente: ");
						
						Controle controle3 = new Controle();
						i = controle3.opcao();
						
						int n = agenda.clientes.size();
						
						if (i>n) {
							System.out.printf("\nNão existe cliente com ID %d.", i);
						}
						else {
							agenda.printID(i);
						}
					}						
					break;
									
					
				case 3: // AGENDAMENTO DO REVISÕES
					
					if(agenda.clientes.size() == 0) {
						System.out.println("\nNão há clientes cadastrados!");
					}
					else {
						System.out.print("\nInforme o ID do cliente: ");
						
						Controle controle4 = new Controle();
						i = controle4.opcao();
						
						int n = agenda.clientes.size();
						
						if (i>n) {
							System.out.printf("\nNão existe cliente com ID %d.", i);
						}
						else {
							agenda.marcar(i);
						}
						
					}
	
					break;
					
				
				case 4: // EDITAR AGENDAMENTO
					
					if(agenda.clientes.size() == 0) {
						System.out.println("\nNão há clientes cadastrados!");
					}
					else {
						System.out.print("\nInforme o ID do cliente: ");
						
						Controle controle5 = new Controle();
						i = controle5.opcao();
						
						int n = agenda.clientes.size();
						
						if (i>n) {
							System.out.printf("\nNão existe cliente com ID %d.", i);
						}
						else {
							agenda.remarcar(i);
						}
						
					}
					break;
										
					
				case 5: // CANCELAR AGENDAMENTO
					
					if(agenda.clientes.size() == 0) {
						System.out.println("\nNão há clientes cadastrados!");
					}
					else {
						System.out.print("\nInforme o ID do cliente: ");
						
						Controle controle6 = new Controle();
						i = controle6.opcao();
						
						int n = agenda.clientes.size();
						
						if (i>n) {
							System.out.printf("\nNão existe cliente com ID %d.", i);
						}
						else {
							agenda.cancelar(i);
						}
					}
					break;
	
					
				case 6: // LISTAR NOMES CLIENTES
					
					if(agenda.clientes.size() == 0) {
						System.out.println("\nA lista de clientes está vazia!");
					}
					else {
						System.out.println();
						agenda.nomes();
					}
					
					break;
										
					
				case 7: // LISTAR TODOS CLIENTES
					
					if(agenda.clientes.size() == 0) {
						System.out.println("\nA lista de clientes está vazia!");
					}
					else {
						System.out.println();
						agenda.listar();
					}
					
					break;
					

				case 8: // SAIR
					
					Controle controle0 = new Controle();
					
					System.out.println("Tem certeza que você quer fechar o programa?");
					System.out.println("Escolha:\n1 - Sim\n2 - Não");
					int escolha = controle0.opcao();
					
					while (escolha > 2 || escolha == 0) {
						System.out.println("Opção inválida.");
						System.out.println("Escolha:\n1 - Sim\n2 - Não");
						escolha = controle0.opcao();
					}
					
					if (escolha == 1) {
						System.out.println("----------PROGRAMA ENCERRADO----------");
						System.exit(1);
					}
					else {
						System.out.println("O Programa não foi encerrado.");
					}
					break;
			}
		}
	}
}
	
