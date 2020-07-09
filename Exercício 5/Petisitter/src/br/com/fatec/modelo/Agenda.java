package br.com.fatec.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.negocio.Controle;

public class Agenda {
 
	public List<Cliente> clientes = new ArrayList<Cliente>();
	public List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	public List<Pet> petCliente;
	public List<Pet> caes = new ArrayList<Pet>();
	public List<Pet> gatos = new ArrayList<Pet>();
	public List<Pet> outrosAnimais = new ArrayList<Pet>();
	
	Controle controle;
	Endereco e;
	Telefone t;
	Pet pt;
	DataHora d;
	Cliente novoCliente;
	Funcionario novoFuncionario;
	
	
	/*---------------------SEÇÃO DE CADASTRO----------------------------*/
	
	public void cadastroCliente() {
		petCliente  = new ArrayList<Pet>();
		novoCliente = new Cliente();
		pt = new Pet ();
		d = new DataHora(" ", " ");
		t = new Telefone(" ", " ");
		e = new Endereco(" "," "," "," "," "," ");
		
		System.out.println("\n_____ INFORME OS SEGUINTES DADOS... _____\n");
		
		System.out.print("NOME: ");
		controle = new Controle();
		novoCliente.setNome(controle.texto());
		
		System.out.print("CPF: ");
		controle = new Controle();
		String cpf_pri = controle.texto();
		
		while (cpf_pri.length()<11 || cpf_pri.length()>11) {
			System.out.println("INFORME O CPF SEM OS PONTOS E O TRAÇO!");
			System.out.println("LEMBRANDO QUE O CPF DEVE CONTER 11 DIGITOS.");
			System.out.println("INFORME NOVAMENTE O CPF.");
			
			System.out.print("CPF: ");
			cpf_pri = controle.texto();
		}
		novoCliente.setCpf(cpf_pri);
		
		
		System.out.println("CONFIRME O SEU CPF");
		System.out.print("CPF: ");
		String cpf_seg = controle.texto();
		
		while (!cpf_seg.equals(cpf_pri)) {	
			System.out.println("NAO SAO OS MESMOS CPF...");
			System.out.println("CONFIRME O SEU CPF");
			System.out.print("CPF: ");
			cpf_seg = controle.texto();
		}
		
		
		System.out.println("TELEFONE...");
		
		System.out.print("DDD: ");
		controle = new Controle();
		t.setDdd(controle.texto());
		
		System.out.print("TEL: ");
		controle = new Controle();
		t.setNum(controle.texto());
		
		System.out.println("ENDEREÇO...");
		
		System.out.print("RUA: ");
		controle = new Controle();
		e.setRua(controle.texto());
		
		System.out.print("NUMERO: ");
		controle = new Controle();
		e.setNumero(controle.texto());
		
		System.out.print("BAIRRO: ");
		controle = new Controle();
		e.setBairro(controle.texto());
		
		System.out.print("CIDADE: ");
		controle = new Controle();
		e.setCidade(controle.texto());
		
		System.out.print("ESTADO: ");
		controle = new Controle();
		e.setEstado(controle.texto());
		
		System.out.print("CEP: ");
		controle = new Controle();
		e.setCep(controle.texto());
		
		String nomePet = "";
		boolean adicionarMaisUmPet = true;
		int n = 0;
		
		while(adicionarMaisUmPet) {
			pt = new Pet();
			n += 1;
			
			System.out.println("\n_____ SOBRE O SEU " + n +"º PET... _____\n");
			
			System.out.print("NOME: ");
			controle = new Controle();
			String nomePt = controle.texto();
			pt.setNome(nomePt);
			
				
			System.out.println("\nQUAL TIPO DE PET:\n[1] CACHORRO\n[2] GATO\n[3] OUTRO");
			System.out.print("OPCAO: ");
			controle = new Controle();
			int animal = controle.opcao();
			
			while (animal < 1 || animal > 3) {
				System.out.println("\nDIGITE UM VALOR VALIDO!");
				System.out.println("QUAL TIPO DE PET:\n[1] CACHORRO\n[2] GATO\n[3] OUTRO");
				System.out.print("OPCAO: ");
				controle = new Controle();
				animal = controle.opcao(); 
			}
			
			String raca = "";
			String[] listaDogs = pt.getListaDog();
			String[] listaGatos = pt.getListaGato();
					
			if (animal == 1) {		//Cachorro
				pt.listaDog();
				raca = listaDogs[controle.opcao() - 1];
				pt.setRaca(raca);
				pt.setCategoria(1);
			}
			if (animal == 2) {		//Gato
				pt.listaGato();
				raca = listaGatos[controle.opcao() - 1];
				pt.setRaca(raca);
				pt.setCategoria(2);
			}
			if (animal == 3) {		// Outra especie
				pt.setRaca("OUTRAS ESPÉCIES");
				pt.setCategoria(3);
			}
			
			System.out.println("\n___GENERO___\n[1] FEMININO \n[2] MASCULINO");
			System.out.print("OPCAO : ");
			controle = new Controle();
			int genero = controle.opcao();
			
			while (genero < 1 || genero > 2) {
				System.out.println("\nDIGITE UM VALOR VALIDO!");
				System.out.println("\n___GENERO___\n[1] FEMININO \n[2] MASCULINO");
				System.out.print("OPCAO: ");
				controle = new Controle();
				genero = controle.opcao();
			}
			
			pt.setGenero(genero);
			
			switch(animal){
			case 1:
				caes.add(pt);
				novoCliente.setPet(pt);
				petCliente.add(pt);
			case 2:
				gatos.add(pt);
				novoCliente.setPet(pt);
				petCliente.add(pt);
			case 3:
				outrosAnimais.add(pt);
				novoCliente.setPet(pt);
				petCliente.add(pt);
			}
			
			System.out.println("\nDESEJA ADICIONAR MAIS UM PET?\n[1] SIM\n[2] NAO");
			System.out.print("OPCAO: ");
			controle = new Controle();
			int q = controle.opcao();
			
			while (q<1 || q>2) {
				System.out.println("\nDIGITE UM VALOR VALIDO!");
				System.out.println("\nDESEJA ADICIONAR MAIS UM PET?\n[1] SIM\n[2] NAO");
				System.out.print("OPCAO: ");
				controle = new Controle();
				q = controle.opcao();				
			}
			
			if (q == 1) { // Deseja adicionar +1 pet
				if (n == 5) { // Ja adicionou o limite (5) de pets
					adicionarMaisUmPet = false;
					break;
				}
				else {
					continue;
				}
			}
			else { // Nao quer adicionar mais nenhum pet
				adicionarMaisUmPet = false;
				break;
			}	
						
		}
		d.setDataAntiga("");
		d.setDataAtual("");
		
		novoCliente.setTelefone(t);
		novoCliente.setEndereco(e);
		novoCliente.setPet(pt);
		novoCliente.setDatahora(d);
		
		clientes.add(novoCliente);

		
		System.out.println("\nCADASTRO REALIZADO COM SUCESSO!!\n");
	}
	
	
	public void cadastroFuncionario() {
		
		novoFuncionario = new Funcionario();
		pt = new Pet ();
		d = new DataHora(" ", " ");
		t = new Telefone(" ", " ");
		e = new Endereco(" "," "," "," "," "," ");
		
		
		System.out.println("\n_____ INFORME OS SEGUINTES DADOS... _____\n");
		
		System.out.print("NOME: ");
		controle = new Controle();
		novoFuncionario.setNome(controle.texto());
		
		System.out.print("CPF: ");
		controle = new Controle();
		String c = controle.texto();
		
		while (c.length()<11 || c.length()>11) {
			System.out.println("INFORME O CPF SEM OS PONTOS E O TRAÇO!");
			System.out.println("LEMBRANDO QUE O CPF DEVE CONTER 11 DIGITOS.");
			System.out.println("INFORME NOVAMENTE O CPF.");
			System.out.print("CPF: ");
			controle = new Controle();
			c = controle.texto();
		} 
		
		novoFuncionario.setCpf(c);
		
		System.out.println("CONFIRME O SEU CPF");
		System.out.print("CPF: ");
		controle = new Controle();
		String cd = controle.texto();
		
		while (!cd.equals(c)) {
			System.out.println("NAO SAO OS MESMOS CPF...");
			System.out.println("CONFIRME O SEU CPF");
			System.out.print("CPF: ");
			controle = new Controle();
			cd = controle.texto();
		}
		
		
		System.out.println("TELEFONE...");
		
		System.out.print("DDD: ");
		controle = new Controle();
		t.setDdd(controle.texto());
		
		System.out.print("TEL: ");
		controle = new Controle();
		t.setNum(controle.texto());
		
		System.out.println("ENDEREÇO...");
		
		System.out.print("RUA: ");
		controle = new Controle();
		e.setRua(controle.texto());
		
		System.out.print("NUMERO: ");
		controle = new Controle();
		e.setNumero(controle.texto());
		
		System.out.print("BAIRRO: ");
		controle = new Controle();
		e.setBairro(controle.texto());
		
		System.out.print("CIDADE: ");
		controle = new Controle();
		e.setCidade(controle.texto());
		
		System.out.print("ESTADO: ");
		controle = new Controle();
		e.setEstado(controle.texto());
		
		System.out.print("CEP: ");
		controle = new Controle();
		e.setCep(controle.texto());
		
		d.setDataAntiga("");
		d.setDataAtual("");
		
		novoFuncionario.setTelefone(t);
		novoFuncionario.setEndereco(e);
		novoFuncionario.setDatahora(d);

		funcionarios.add(novoFuncionario);
		
		System.out.println("\nCADASTRADO REALIZADO COM SUCESSO!!\n");
	}
	
	
	/*---------------METODOS DE VERIFICAÇÃO--------------*/
	public String verificaCPF() {
		controle = new Controle();
		
		System.out.print("\nINFORME O CPF DO CLIENTE: ");
		controle = new Controle();
		String i = controle.texto();
		
		if (i.length() == 0) {
			System.out.print("\nINFORME O CPF DO CLIENTE: ");
			controle = new Controle();
			i = controle.texto();
		}
		
		while (i.length()<11 || i.length()>11) { // se o CPF informado não for no tamanho de um CPF
			System.out.println("INFORME O CPF SEM OS PONTOS E O TRAÇO!");
			System.out.println("LEMBRANDO QUE O CPF DEVE CONTER 11 DIGITOS.");
			System.out.println("INFORME NOVAMENTE O CPF.");
			System.out.print("CPF: ");
			controle = new Controle();
			i = controle.texto();
		}
		
		return i;
	}
	
	
	public boolean verificaLista() {
		if(clientes.isEmpty()) { // se a lista de clientes estiver vazia
			System.out.println("\nNAO HA CLIENTES CADASTRADOS!");
			return false;
		}
		
		if(funcionarios.isEmpty()) { // se a lista de funcionarios estiver vazia
			System.out.println("\nNAO HA FUNCIONARIOS DISPONIVEIS!");
			return false;
		}
		else {
			return true;
		}
		
	}
		
	public boolean verificaAgendamento(int indexCliente) {
		
		boolean existeAgendamento = clientes.get(indexCliente).getDatahora().getDataAtual() != " " || clientes.get(indexCliente).getDatahora().getDataAtual() != ""; 
		
		return existeAgendamento;
	}
	
	/*----------------LISTAGEM DOS CADASTRADOS-----------------------*/
	
	public void listaFuncionarios() { // listar a lista de funcionarios como opcao
		
		System.out.println("ID | NOME | ENDERECO");
				
		for(Pessoa funcionario: funcionarios) { // pegar cliente por cliente atraves da posicao na lista
			String nome = funcionario.getNome();
			String bairro = funcionario.getEndereco().getBairro();
			String cidade = funcionario.getEndereco().getCidade();
			String estado = funcionario.getEndereco().getEstado();
			String end = bairro + "-" + cidade + "-" + estado ;
			System.out.printf("[%d] %s -> %s\n", funcionarios.indexOf(funcionario) + 1, nome, end);
		}
	}

	
	public void listaClientes() { // listar a lista de funcionarios como opcao
		int tamanhoLista = clientes.size();
		
		System.out.println("\nID | NOME | ENDERECO");
		
		for(Cliente cliente : clientes) { // pegar cliente por cliente atraves da posicao na lista
			String nome = cliente.getNome();
			String bairro = cliente.getEndereco().getBairro();
			String cidade = cliente.getEndereco().getCidade();
			String estado = cliente.getEndereco().getEstado();
			String end = bairro + "-" + cidade + "-" + estado ;
			System.out.printf("[%d] %s -> %s\n", clientes.indexOf(cliente) + 1, nome, end);
		}
		
	}

	
	/*-----------------AGENDAMENTOS------------------------*/
	
	public int retornarPets(int i) {
		controle = new Controle();
		
		System.out.println("\nID | NOME PET");
		
		String e = petCliente.get(i).getNome(); // pega o nome dos pets do cliente
		String np[] = e.split(";"); // Separar os nomes dos pets
		
		int t = np.length; // tamanho da lista de nomes dos pets do cliente
		
		for(int k = 0; k<t; k++) {
			System.out.printf("[%d] %s\n", k+1, np[k]); // exibe na tela os nomes disponiveis
		}
		System.out.println("\nOBS: CASO QUEIRA MARCAR MAIS DE UM PET, AGENDE NOVAMENTE COM O NOME DO OUTRO PET");
		System.out.print("OPCAO: ");
		controle = new Controle();
		int j = controle.opcao();
		
		while (j > t || j < 0) { // se a opcao escolhida não tiver entre a quatidade de nomes
			System.out.println("ESCOLHA UM VALOR VALIDO");
			System.out.print("OPCAO: ");
			controle = new Controle();
			j = controle.opcao();
		}
				
		return (j-1);
	}
		
	
	public void marcarData(int n) {
		controle = new Controle();
		
		System.out.println("\n_____ AGENDA _____\n");
		
		System.out.println("ESCOLHA O SEU PET:");
		int p = retornarPets(n);
		String e = petCliente.get(n).getNome(); // pega o nome dos pets do cliente
		String np[] = e.split(";"); // Separar os nomes dos pets
		String nomePet = np[p];
				
		System.out.println("\nESCOLHA UM PET SITTER:");
		listaFuncionarios();
		
		System.out.println("\nESCOLHA UM ID");
		System.out.print("OPCAO: ");
		
		int f = controle.opcao();
		int s = funcionarios.size();
		
		while (f > s || f < 0) {
			System.out.println("ESCOLHA UM VALOR VALIDO");
			System.out.print("OPCAO: ");
			controle = new Controle();
			f = controle.opcao();
		}
		
		f = f-1;
		
		String k = funcionarios.get(f).getNome();
		
		System.out.println("\nINFORME A DATA...");
		System.out.print("DIA: ");
		controle = new Controle();
		String dia = controle.texto();
		
		while (dia.length() == 0) {
			controle = new Controle();
			dia = controle.texto();
		}
		
		System.out.print("MES: ");
		controle = new Controle();
		String mes = controle.texto();
		
		System.out.print("ANO: ");
		controle = new Controle();
		String ano = controle.texto();
		
		System.out.println("\nINFORME A HORA...");
		System.out.print("HORA: ");
		controle = new Controle();
		String hora = controle.texto();
		
		System.out.print("MINUTO: ");
		controle = new Controle();
		String minuto = controle.texto();
		
		String novo = dia+"/"+mes+"/"+ano+" - "+hora+":"+minuto;
		
		System.out.println("\nINFORME O DIA E A HORA QUE IRÁ PEGAR O SEU PET");
		
		System.out.println("\nINFORME A DATA...");
		System.out.print("DIA: ");
		controle = new Controle();
		dia = controle.texto();
		
		System.out.print("MES: ");
		controle = new Controle();
		mes = controle.texto();
		
		System.out.print("ANO: ");
		controle = new Controle();
		ano = controle.texto();
		
		System.out.println("\nINFORME A HORA...");
		System.out.print("HORA: ");
		controle = new Controle();
		hora = controle.texto();
		
		System.out.print("MINUTO: ");
		controle = new Controle();
		minuto = controle.texto();
		
		String dataA = clientes.get(n).getDatahora().getDataAtual();
		String dataB = clientes.get(n).getDatahora().getDataAntiga();
		String velhoCliente = dataA + dataB ;
		
		dataA = funcionarios.get(f).getDatahora().getDataAtual();
		dataB = funcionarios.get(f).getDatahora().getDataAntiga();
		String velhoFuncionario = dataA + dataB ;

		novo = novo +" ATÉ "+ dia +"/"+ mes +"/"+ ano + " - " + hora + ":" + minuto;
				
		String cliente ="HORA MARCADA: " + novo + " -> PET: " + nomePet + " -> PET SITTER: " + k;
		
		String novoCl = novo + " -> PET:" + nomePet+ " PET SITTER: " + k + "\n";
		
		String novoFunc = novo + "-> CLIENTE: " + clientes.get(n).getNome()+" - " + "PET:" + nomePet + "\n";
		
		System.out.println(cliente);//informa ao cliente as informacoes do agendamento
		
		novoCliente = new Cliente();
		novoFuncionario = new Funcionario();
		DataHora d = new DataHora("", "");
		
		d.setDataAntiga(velhoCliente);
		d.setDataAtual(novoCl);
		novoCliente.setDatahora(d);
		novoCliente.setNome(clientes.get(n).getNome());
		novoCliente.setCpf(clientes.get(n).getCpf());
		novoCliente.setEndereco(clientes.get(n).getEndereco());
		novoCliente.setTelefone(clientes.get(n).getTelefone());
		clientes.remove(n); // removendo as informacoes anteriores
		clientes.add(n, novoCliente); // colocando as informcaoes na posicao onde o cliente estava na lista de clientes
				
		d.setDataAntiga(velhoFuncionario);
		d.setDataAtual(novoFunc);
		novoFuncionario.setDatahora(d);
		novoFuncionario.setNome(funcionarios.get(n).getNome());
		novoFuncionario.setCpf(funcionarios.get(n).getCpf());
		novoFuncionario.setEndereco(funcionarios.get(n).getEndereco());
		novoFuncionario.setTelefone(funcionarios.get(n).getTelefone());
		funcionarios.remove(f); // removendo as informacoes anteriores
		funcionarios.add(f, novoFuncionario); //adicionando as novas informacoes na posicao anterior onde estava o funcionario na lista de funcionarios
	}
	
	
	public void editarAgendamento(int n) {
		controle = new Controle();
		
		System.out.println("\n_____ AGENDA _____\n");
		
		System.out.println("MODIFIQUE O SEU AGENDAMENTO...\n");
		
		System.out.println("ESCOLHA O SEU PET:");
		int p = retornarPets(n);
		String e = petCliente.get(n).getNome(); // pega o nome dos pets do cliente
		String np[] = e.split(";"); // Separar os nomes dos pets
		String nomePet = np[p];
				
		//
		System.out.println("\nESCOLHA UM PET SITTER:");
		listaFuncionarios();
		
		System.out.println("\nESCOLHA UM ID");
		System.out.print("OPCAO: ");
		
		controle = new Controle();
		int f = controle.opcao();
		int s = funcionarios.size();
		
		while (f > s || f < 0) {
			System.out.println("ESCOLHA UM VALOR VALIDO");
			System.out.print("OPCAO: ");
			controle = new Controle();
			f = controle.opcao();
		}
		f = f-1;
		
		String k = funcionarios.get(f).getNome();
	
		
		System.out.println("\nINFORME A DATA...");
		System.out.print("DIA: ");
		controle = new Controle();
		String dia = controle.texto();
		
		while (dia.length() == 0) {
			controle = new Controle();
			dia = controle.texto();
		}
		
		System.out.print("MES: ");
		controle = new Controle();
		String mes = controle.texto();
		
		System.out.print("ANO: ");
		controle = new Controle();
		String ano = controle.texto();
		
		System.out.println("\nINFORME A HORA...");
		System.out.print("HORA: ");
		controle = new Controle();
		String hora = controle.texto();
		
		System.out.print("MINUTO: ");
		controle = new Controle();
		String minuto = controle.texto();
		
		String novo = dia+"/"+mes+"/"+ano+" - "+hora+":"+minuto;
		
		System.out.println("\nINFORME O DIA E A HORA QUE IRÁ PEGAR O SEU PET");
		
		System.out.println("\nINFORME A DATA...");
		System.out.print("DIA: ");
		controle = new Controle();
		dia = controle.texto();
		
		System.out.print("MES: ");
		controle = new Controle();
		mes = controle.texto();
		
		System.out.print("ANO: ");
		controle = new Controle();
		ano = controle.texto();
		
		System.out.println("\nINFORME A HORA...");
		System.out.print("HORA: ");
		controle = new Controle();
		hora = controle.texto();
		
		System.out.print("MINUTO: ");
		controle = new Controle();
		minuto = controle.texto();
		
		String velhoCliente = clientes.get(n).getDatahora().getDataAntiga();
		 
		String velhoFuncionario = funcionarios.get(f).getDatahora().getDataAntiga();

		novo = novo +" ATÉ "+ dia +"/"+ mes +"/"+ ano + " - " + hora + ":" + minuto;
				
		String cliente ="HORA MARCADA: " + novo + " PET: " + nomePet + " PET SITTER: " + k;
		
		String novoCl = novo + " -> PET:" + nomePet+ " PET SITTER: " + k + "\n";
		
		String novoFunc = novo + "-> CLIENTE: " + clientes.get(n).getNome()+" - " + "PET:" + nomePet + "\n";
		
		System.out.println(cliente);//informa ao cliente as informacoes do agendamento
		
		novoCliente = new Cliente();
		novoFuncionario = new Funcionario();
		DataHora d = new DataHora("", "");
		
		d.setDataAntiga(velhoCliente);
		d.setDataAtual(novoCl);
		novoCliente.setDatahora(d);
		novoCliente.setNome(clientes.get(n).getNome());
		novoCliente.setCpf(clientes.get(n).getCpf());
		novoCliente.setEndereco(clientes.get(n).getEndereco());
		novoCliente.setTelefone(clientes.get(n).getTelefone());
		clientes.remove(n); // removendo as informacoes anteriores
		clientes.add(n, novoCliente); //adicionando as informacoes na posicao onde o cliente estava na lista de clientes
		
		d.setDataAntiga(velhoFuncionario);
		d.setDataAtual(novoFunc);
		novoFuncionario.setDatahora(d);
		novoFuncionario.setNome(funcionarios.get(n).getNome());
		novoFuncionario.setCpf(funcionarios.get(n).getCpf());
		novoFuncionario.setEndereco(funcionarios.get(n).getEndereco());
		novoFuncionario.setTelefone(funcionarios.get(n).getTelefone());
		funcionarios.remove(f); // removendo as informacoes anteriores
		funcionarios.add(f, novoFuncionario); //adicionando as informacoes onde o funcionario estava na lista de funcionarios
		
		System.out.println("\nAGENDAMENTO EDITADO COM SUCESSO!!");
	}
	
		
	public void cancelarAgendamento(int n) {
		
		DataHora dt = new DataHora(" "," ");
		
		System.out.println("\n_____ AGENDA _____\n");
		
		String data = clientes.get(n).getDatahora().getDataAtual();
		
		System.out.println(clientes.get(n).getDatahora().getDataAtual());
		
		if(clientes.get(n).getDatahora().getDataAtual() == "" || clientes.get(n).getDatahora().getDataAtual() == " ") {
			System.out.println("NENHUM CADASTRO FOI REALIZADO");
			return;
		}
		
		String cpf = verificaCPF();
		
		for(Pessoa cliente: clientes) {
			
			String cpfCliente = cliente.getCpf();
			
			if(cpf.equals(cpfCliente)) {
				cliente.setDatahora(dt);
				break;
			}
		}
		
		System.out.println("FOI CANCELADO COM SUCESSO!!!\n");
	}
	
	/*-------------HISTORICO -----------------------*/

	public void historicoFuncionario() {
		controle = new Controle();
		
		System.out.println("\nLISTA:");
		listaFuncionarios();
		
		System.out.println("\nESCOLHA UM ID");
		System.out.print("OPCAO: ");
		controle = new Controle();
		int f = controle.opcao();
		
		int s = funcionarios.size();
		
		while (f > s || f < 0) {
			System.out.println("ESCOLHA UM VALOR VALIDO");
			System.out.print("OPCAO: ");
			controle = new Controle();
			f = controle.opcao();
		}
		f = f - 1;
		
		String nome = funcionarios.get(f).getNome();
		String dataAntiga = funcionarios.get(f).getDatahora().getDataAntiga();
		String dataAtual = funcionarios.get(f).getDatahora().getDataAtual();
		
		if (dataAtual.length() == 0) {
			System.out.println("_____________FUNCIONÁRIO_____________");
			System.out.printf("\nNOME: %s \n", nome);
			System.out.println("NÃO POSSUI NENHUM HISTÓRICO!");
			System.out.println("\n_____________________________________");
		}
		else {
			System.out.println("_____________FUNCIONÁRIO_____________");
			System.out.printf("\nNOME: %s \n", nome);
			System.out.printf("\nATENDIMENTOS PASSADOS: %s\n", dataAntiga);
			System.out.printf("ÚLTIMO ATENDIMENTO: %s", dataAtual);
			System.out.println("\n_____________________________________");
		}	
	}
	
	
	public void historicoCliente() {
		controle = new Controle();
		
		System.out.println("\nLISTA:");
		listaClientes();
		
		System.out.println("\nESCOLHA UM ID");
		System.out.print("OPCAO: ");
		controle = new Controle();
		int c = controle.opcao();
		
		int s = clientes.size();
		
		while (c > s || c < 0) {
			System.out.println("ESCOLHA UM VALOR VALIDO");
			System.out.print("OPCAO: ");
			controle = new Controle();
			c = controle.opcao();
		}
		c = c - 1;
		
		String nome = clientes.get(c).getNome();
		String pet = petCliente.get(c).getNome();
		String dataAntiga = clientes.get(c).getDatahora().getDataAntiga();
		String dataAtual = clientes.get(c).getDatahora().getDataAtual();
		
		if (dataAtual.length() == 0) {
			System.out.println("_______________CLIENTE_______________");
			System.out.printf("\nNOME: %s \nPET: %s\n", nome,pet);
			System.out.println("NÃO POSSUI NENHUM HISTÓRICO!");
			System.out.println("\n_____________________________________");
		}
		else {
			System.out.println("_______________CLIENTE_______________");
			System.out.printf("\nNOME: %s \nPET: %s\n", nome,pet);
			System.out.printf("\nAGENDAMENTOS PASSADOS: %s\n", dataAntiga);
			System.out.printf("ÚLTIMO AGENDAMENTO: %s", dataAtual);
			System.out.println("\n_____________________________________");
		}	
	}
	
	/*---------------RANKING DE RAÇAS-----------------*/
	public void gerarRankingRacas(int opcao) {
		
		int naoEstaVazia = verificaListaDePets(opcao);
		if(naoEstaVazia == 1) {
			switch(opcao) {
				case 1:
					rankingCaninos();
					break;
				case 2:
					rankingFelinos();
					break;
				case 3:
					int contF = 0, contM = 0, contC = 0;
					
					for(Pet animal: outrosAnimais) {
						String categoria = animal.getCategoria();
						
						if(categoria.equals("OUTROS")) {
							contC += 1;
						}					
						if(categoria.equals("FEMEA")) {
							contF += 1;
						}
						if(categoria.equals("MACHO")) {
							contM += 1;
						}
					}
					System.out.printf("%d animais foram cadastrados com a categoria OUTROS\n", contC);
					System.out.printf("%d do gênero FEMININO\n", contF);
					System.out.printf("%d do gênero MASCULINO\n", contM);
					break;
				default:
					System.out.println("INFORME UMA OPÇÃO VÁLIDA");
					break;
			}
		}
		else {	// nenhum pet foi cadastrado
			return;
		}
		
	}
	
	public int verificaListaDePets(int opcao) {
		switch(opcao) {
			case 1:
				if(caes.isEmpty()) {
					System.out.println("NENHUM CÃOZINHO FOI CADASTRADO, LAMENTO :(");
					return -1;
				}
			case 2:
				if(gatos.isEmpty()) {
					System.out.println("NENHUM GATINHO FOI CADASTRADO, LAMENTO :(");
					return -1;
				}
			case 3:
				if(outrosAnimais.isEmpty()) {
					System.out.println("NENHUM PET FOI CADASTRADO, LAMENTO :(");
					return -1;
				}
		}
		return 1;
	}
	
	public int[] contarQuantidadeRacas(String genero, int qtd, Pet pet, int tamanhoLista, String[] listaPets) {
		int[] vetorAuxiliarPets = new int[qtd];
		
		for(int i = 0; i < tamanhoLista; i++) {
			if(listaPets[i].equals(pet.getRaca())) { 
				vetorAuxiliarPets[i] += 1; 
			}
		}
		
		return vetorAuxiliarPets;
		
	}
	
	public String encontraMaisPopular(int[] vetor, String[] listaPets, int tamanhoVetor) {
		
		String maisPopular= "";
		int maior = vetor[0];
		int posicao = 0;
		
		for(int i = 0; i< tamanhoVetor; i++) {
			if(vetor[i] > maior) {
				maior = vetor[i];
				posicao = i;
				maisPopular = listaPets[posicao];
			}
		}
		
		return maisPopular;
	}
	
	public void rankingCaninos() {
		int[] vetorAuxiliarF = new int[10];
		int[] vetorAuxiliarM = new int[10];
		String[] listaCaes = pt.getListaDog();
		int tamanhoLista = listaCaes.length;
		
		for(Pet cao: caes) {
			String genero = cao.getGenero();
			if(genero.equals("FEMEA")) {	// Contagens de raças no genero feminino
				vetorAuxiliarF = contarQuantidadeRacas("FEMEA", 10, cao, tamanhoLista, listaCaes);
			}
			if(genero.equals("MACHO")) {	// Contagens de raças no genero masculino
				vetorAuxiliarM = contarQuantidadeRacas("MACHO", 10, cao, tamanhoLista, listaCaes);
			}
		}
		
		String popularFeminino = encontraMaisPopular(vetorAuxiliarF, listaCaes, 10);
		String popularMasculino = encontraMaisPopular(vetorAuxiliarM, listaCaes, 10);
		
		if(popularFeminino == "") {
			popularFeminino = "NENHUM CADASTRO REALIZADO";
		}
		if(popularMasculino == "") {
			popularMasculino = "NENHUM CADASTRO REALIZADO";
		}
		
		System.out.println("___________RAÇA MAIS POPULAR____________");
		System.out.printf("ENTRE AS FÊMEAS:  %s \n", popularFeminino);
		System.out.printf("ENTRE OS MACHOS:  %s \n", popularMasculino);
		
	}
	
	public void rankingFelinos(){
		int[] vetorAuxiliarF = new int[10];
		int[] vetorAuxiliarM = new int[10];
		String[] listaGatos = pt.getListaGato();
		int tamanhoLista = listaGatos.length;
		
		for(Pet gato: gatos) {
			String genero = gato.getGenero();
			if(genero.equals("FEMEA")) {	// Contagens de raças no genero feminino
				vetorAuxiliarF = contarQuantidadeRacas("FEMEA", 10, gato, tamanhoLista, listaGatos);
			}
			if(genero.equals("MACHO")) {	// Contagens de raças no genero masculino
				vetorAuxiliarM = contarQuantidadeRacas("MACHO", 10, gato, tamanhoLista, listaGatos);
			}
		}
		
		String popularFeminino = encontraMaisPopular(vetorAuxiliarF, listaGatos, 10);
		String popularMasculino = encontraMaisPopular(vetorAuxiliarM, listaGatos, 10);
		
		if(popularFeminino == "") {
			popularFeminino = "NENHUM CADASTRO REALIZADO";
		}
		if(popularMasculino == "") {
			popularMasculino = "NENHUM CADASTRO REALIZADO";
		}
		
		System.out.println("___________RAÇA MAIS POPULAR____________");
		System.out.printf("ENTRE AS FÊMEAS: %s \n", popularFeminino);
		System.out.printf("ENTRE OS MACHOS: %s \n", popularMasculino);
	}

	
	/*---------------RANKING DE GENEROS-----------------*/
	
	public void gerarRankingGeneros(int opcao) {
		int naoEstaVazia = verificaListaDePets(opcao);
		
		if(naoEstaVazia == 1) {
			switch(opcao) {
				case 1: 
					calculaQuantidadeGenero(caes, "CÃES");
					break;
				case 2:
					calculaQuantidadeGenero(gatos, "GATOS");
					break;
				case 3:
					calculaQuantidadeGenero(outrosAnimais, "OUTROS ANIMAIS");
					break;
			}
		}
		else 
			return;
	}
	
	public void calculaQuantidadeGenero(List<Pet> listaPets, String categoria) {
		int qtdFeminino = 0;
		int qtdMasculino = 0;
		
		for(Pet pet: listaPets) {
			String genero = pet.getGenero();
			if(genero.equals("FEMEA")) qtdFeminino += 1;
			if(genero.equals("MACHO")) qtdMasculino += 1;
		}
		
		System.out.printf("\n--------------- %s ---------------\n", categoria);
		System.out.printf("EXISTEM %d FÊMEAS CADASTRADAS\n", qtdFeminino);
		System.out.printf("EXISTEM %d MACHOS CADASTRADOS\n", qtdMasculino);
		
		verificaGeneroComMaisPets(qtdFeminino, qtdMasculino);
		
	}
	
	public void verificaGeneroComMaisPets(int feminino, int masculino) {
		if(feminino == 0 && masculino == 0) {
			System.out.println("NENHUM PET FOI CADASTRADO EM NOSSO SISTEMA");
		}
		
		if(feminino > masculino)
			System.out.println("TEMOS UMA FREQUENCIA MAIOR DE PETS DO GENERO FEMININO");
			
		else if(masculino > feminino)
			System.out.println("TEMOS UMA FREQUENCIA MAIOR DE PETS DO GENERO MASCULINO");
		
		else
			System.out.println("PARECE QUE HOUVE UM EMPATE");
		
	}
	
	/*------------------------------------------------*/
} // FIM
