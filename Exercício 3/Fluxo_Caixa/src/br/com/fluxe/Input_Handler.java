package br.com.fluxe;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Input_Handler {

	public static String getUser() {
		return "Admin";
	}
	
	public static String getPassword() {
		return "Admin";
	}

	public static Menu_Options menu_input() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner user_input = new Scanner(System.in);
		int option;
		
		while(true) {
			try {
				option = user_input.nextInt();
				
				if(option < 1 || option > Menu_Options.values().length) {
					System.out.println("Você digitou um número fora do escopo, tente novamente.");
					TimeUnit.SECONDS.sleep(3);
					UI_Helper.showMenu();
					continue;
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("Ocorreu um erro: " + e);
				System.out.println("Por favor, digite novamente");
				TimeUnit.SECONDS.sleep(4);
				user_input.next();
				System.out.println();
				UI_Helper.showMenu();
			}		
		}
		
		return Menu_Options.values()[option-1];
	}

	public static boolean addUserInput() throws InterruptedException {
		@SuppressWarnings("resource")
		
		Scanner user_input = new Scanner(System.in);
		User user = new User();
		
		try {
			System.out.println("Por favor, digite o nome a ser cadastrado:\n");
			user.nome = user_input.nextLine();
			System.out.println("Por favor, digite o telefone a ser cadastrado:\n");
			user.telefone = user_input.nextLine();
			System.out.println("Por favor, digite o endereço a ser cadastrado:\n");
			user.endereco = user_input.nextLine();
			System.out.println("Por favor, insira o email a ser usado:\n");
			user.email = user_input.nextLine();
			
			System.out.println("Por favor, insira o login do usuário:\n");
			user.setPassword(user_input.nextLine());
			System.out.println("Por favor, insira a senha do usuário:\n");
			user.setPassword(user_input.nextLine());
			
			if(Serializer_User.addUser(user)) {				
				System.out.println("USUÁRIO CADASTRADO COM SUCESSO!!!");
				TimeUnit.SECONDS.sleep(4);
				
				return true;
			} else {
				System.out.println("Ocorreu um erro!");
				TimeUnit.SECONDS.sleep(4);
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e);
			System.out.println("Por favor, digite novamente");
			TimeUnit.SECONDS.sleep(4);
			user_input.next();
			System.out.println();
			UI_Helper.showMenu();
			
			return false;
		}
	}
	
}
