package br.com.modelo.fatec;

import java.util.ArrayList;
import java.util.List;

import br.com.negocio.fatec.Controle;


public class Agenda {
	public List<Pessoa> clientes = new ArrayList<Pessoa>();
	public List<DataHora> datahora = new ArrayList<DataHora>();

	
	
	public void listar() {
		
		int n = clientes.size();
		
		for (int x = 0; x < n; x++) {
			System.out.printf("ID Cliente: " + x + "\n" +
	 				"Nome: " + clientes.get(x).getNome() + "\n" + 
	 				"CPF: " + clientes.get(x).getCpf() + "\n" +
	 				"Telefone: " + "(" + clientes.get(x).getTelefone().getDdd() + ")" + " " + clientes.get(x).getTelefone().getNum() + "\n" +
	 				"Rua: " + clientes.get(x).getEndereco().getRua() + "\n" +
	 				"Numero: " + clientes.get(x).getEndereco().getNumero() + "\n" +
	 				"Bairro: " + clientes.get(x).getEndereco().getBairro() + "\n" +
	 				"Cidade: " + clientes.get(x).getEndereco().getCidade() + "\n" +
	 				"Endereço: " + clientes.get(x).getEndereco().getEstado() + "\n"+
	     			"CEP: " + clientes.get(x).getEndereco().getCep() + "\n" + 
	 				"___Sobre o automável___" + "\n" + 
	     			"Modelo do automóvel: " + clientes.get(x).getCarro().getModelo() + "\n" +
	     			"Placa: " + clientes.get(x).getCarro().getPlaca() + "\n" +
	     			"Ano: " + clientes.get(x).getCarro().getAno() + "\n" +
	     			"Valor da Compra: " + clientes.get(x).getCarro().getValor() + "\n" + "\n" +	
	     			"___Histórico de Agendamentos___" + "\n" + 
	     			"* Agendamento atual: " +
	     			datahora.get(x).getAtual() + "\n" +
	     			"\n* Agendamentos passados: \n" +
        			datahora.get(x).getAntiga() + "\n" +
        			"_______x_______" + "\n");
		}
	}
	
	public void nomes() {
		int n = clientes.size();
		
		System.out.println("ID - CLIENTES\n_______________");
		
		for (int x = 0; x < n; x++) {
			System.out.printf(" " + x + " - " + clientes.get(x).getNome() + "\n");
		}
	}
	
	public void printID(int x) {	     
	     System.out.printf("ID Cliente: " + x + "\n" +
		 				"Nome: " + clientes.get(x).getNome() + "\n" + 
		 				"CPF: " + clientes.get(x).getCpf() + "\n" +
		 				"Telefone: " + "(" + clientes.get(x).getTelefone().getDdd() + ")" + " " + clientes.get(x).getTelefone().getNum() + "\n" +
		 				"Rua: " + clientes.get(x).getEndereco().getRua() + "\n" +
		 				"Numero: " + clientes.get(x).getEndereco().getNumero() + "\n" +
		 				"Bairro: " + clientes.get(x).getEndereco().getBairro() + "\n" +
		 				"Cidade: " + clientes.get(x).getEndereco().getCidade() + "\n" +
		 				"Endereço: " + clientes.get(x).getEndereco().getEstado() + "\n"+
		     			"CEP: " + clientes.get(x).getEndereco().getCep() + "\n" + "\n" +
		 				"___Sobre o automável___" + "\n" + 
		     			"Modelo do automóvel: " + clientes.get(x).getCarro().getModelo() + "\n" +
		     			"Placa: " + clientes.get(x).getCarro().getPlaca() + "\n" +
		     			"Ano: " + clientes.get(x).getCarro().getAno() + "\n" +
		     			"Valor da Compra: " + clientes.get(x).getCarro().getValor() + "\n" + "\n" +
		     			"___Histórico de Agendamentos___" + "\n" + 
		     			"* Agendamento atual: " +
		     			datahora.get(x).getAtual() +  "\n" +
		     			"\n* Agendamentos passados: \n" +
	        			datahora.get(x).getAntiga());
		
}
	   
	
	
	public void marcar(int x) {
		Controle controle4 = new Controle();
		DataHora dh = new DataHora(" ", " ");
		
		System.out.println("\nDigite a data e a hora para efetuar o agendamento...");
		
		System.out.print("Dia: ");
		String dia = controle4.texto();
		
		System.out.print("Mês: ");
		String mes = controle4.texto();
		
		System.out.print("Ano: ");
		String ano = controle4.texto();
		
		System.out.print("Hora: ");
		String hora = controle4.texto();
		
		System.out.print("Minutos: ");
		String minutos = controle4.texto();
		
		System.out.print("Tipo de Revisão: ");
		String revisao = controle4.texto();
		
		String velho = datahora.get(x).getAtual() + "\n" + datahora.get(x).getAntiga();
		
		String novo =  dia + "/" + mes + "/" + ano + " " + "-" + " " + hora + ":" + minutos + " " + "->" + " " + revisao ;
		
		dh.setAntiga(velho);
		dh.setAtual(novo);
		
		datahora.add(x, dh);
				
		System.out.printf("Hora marcada: %s\n", novo);
	
	}
	
	
	
	public void remarcar(int x) {
		
		Controle controle5 = new Controle();
		DataHora dh = new DataHora(" ", " ");
		
		System.out.println("Digite a data e a hora para editar o agendamento...");
		
		System.out.print("Dia: ");
		String dia = controle5.texto();
		
		System.out.print("Mês: ");
		String mes = controle5.texto();
		
		System.out.print("Ano: ");
		String ano = controle5.texto();
		
		System.out.print("Hora: ");
		String hora = controle5.texto();
		
		System.out.print("Minutos: ");
		String minutos = controle5.texto();
		
		System.out.print("Tipo de Revisão: ");
		String revisao = controle5.texto();
				
		String editado =  dia + "/" + mes + "/" + ano + " " + "-" + " " + hora + ":" + minutos + " " + "->" + " " + revisao ;
		
		String historico = datahora.get(x).getAntiga();
		
		dh.setAntiga(historico);
		dh.setAtual(editado);
		
		datahora.add(x, dh);
				
		System.out.printf("Hora marcada: %s\n", editado);
		
	}
	
	
	
	public void cancelar(int x) {

		DataHora dh = new DataHora(" ", " ");
		
		
		String historico = datahora.get(x).getAntiga();
		
		String agendamento = datahora.get(x).getAtual();
		
		String cancelado = agendamento + " - (Cancelado)";
		
		dh.setAntiga(historico);
		dh.setAtual(cancelado);
		
		datahora.add(x, dh);
				
		System.out.printf("O horário do dia: %s foi cancelado com sucesso!\n", agendamento);
	}
	
}
