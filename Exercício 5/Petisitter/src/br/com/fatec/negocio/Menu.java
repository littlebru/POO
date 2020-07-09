package br.com.fatec.negocio;


public class Menu {
	
	Controle leitor = new Controle();
		
	public void imprimirMenu() {
		System.out.println("\n________ MENU ________");
		System.out.println("[1] REALIZAR CADASTRO");
		System.out.println("[2] AGENDAMENTO");
		System.out.println("[3] LISTAGEM DE CLIENTE E FUNCIONARIOS");
		System.out.println("[4] RANKING DE PETS");
		System.out.println("[5] HISTÓRICO\n");
		System.out.println("[0] SAIR");
		System.out.print("\nESCOLHA UMA OPÇÃO: ");
	}
	
	public void fecharPrograma() {
		int escolha;
		do {
			System.out.println("TEM CERTEZA QUE QUER FECHAR O PROGRAMA?");
			System.out.println("ESCOLHA:\n[1] SIM\n[2] NAO");
			
			System.out.print("OPCAO: ");
			escolha = leitor.opcao();
			
		}while(escolha != 1 && escolha != 2);
		
		if (escolha == 1) {
			System.out.println("----------PROGRAMA ENCERRADO----------");
			System.exit(1);
		}
		else {
			return;
		}
	}
	
	public void agendamento() {
		System.out.println("\n________ AGENDAMENTO ________");
		System.out.println("[1] AGENDAR O CUIDADO DO SEU PET");
		System.out.println("[2] EDITAR AGENDAMENTO");
		System.out.println("[3] CANCELAR AGENDAMENTO");
		System.out.println("[0] VOLTAR");
		System.out.print("\nESCOLHA UMA OPÇÃO: ");
	}
	
	public void menuRanking() {
		System.out.println("\n________ VISUALIZAR RANKING ________");
		System.out.println("[1] RANKING DAS RAÇAS MAIS COMUNS");
		System.out.println("[2] RANKING DOS GÊNEROS FAVORITOS POR RAÇA");
		System.out.println("[0] VOLTAR");
		System.out.print("\nESCOLHA UMA OPÇÃO: ");
	}
	
public void menuRankingRacasComuns() {
		System.out.println("\n________ RANKING DE RAÇAS ________");
		System.out.println("[1] RAÇAS MAIS COMUNS DOS CÃES");
		System.out.println("[2] RAÇAS MAIS COMUNS DOS GATOS");
		System.out.println("[3] RAÇAS MAIS COMUNS DE OUTRAS ESPECIES");
		System.out.println("[0] VOLTAR");
		System.out.print("\nESCOLHA UMA OPÇÃO: ");
	}
	
	public void menuRankingGenerosFavoritos() {
		System.out.println("\n________ RANKING DE GENEROS ________");
		System.out.println("[1] GENEROS FAVORITOS DE CÃES");
		System.out.println("[2] GENEROS FAVORITOS DE GATOS");
		System.out.println("[3] GENEROS FAVORITOS DE OUTRAS ESPECIES");
		System.out.println("[0] VOLTAR");
		System.out.print("\nESCOLHA UMA OPÇÃO: ");
	}
	
	public void menuCadastro() {
		System.out.println("\n________ CADASTRO ________");
		System.out.println("[1] CADASTRAR COMO CLIENTE");
		System.out.println("[2] CADASTRAR COMO FUNCIONÁRIO\n");
		System.out.println("[0] VOLTAR");
		System.out.print("\nESCOLHA UMA OPÇÃO: ");
	}
	
	public void menuListagem() {
		System.out.println("\n________ LISTAGEM ________");
		System.out.println("[1] LISTAGEM DE CLIENTES");
		System.out.println("[2] LISTAGEM DE FUNCIONÁRIOS\n");
		System.out.println("[0] VOLTAR");
		System.out.print("\nESCOLHA UMA OPÇÃO: ");
	}
	
	public void menuHistorico() {
		System.out.println("\n________ VISUALIZAR HISTORICO ________");
		System.out.println("[1] HISTORICO DE CLIENTES");
		System.out.println("[2] HISTORICO DE FUNCIONÁRIOS\n");
		System.out.println("[0] VOLTAR");
		System.out.print("\nESCOLHA UMA OPÇÃO: ");
	}

} // FIM


