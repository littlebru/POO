package br.com.fluxe;

import java.util.concurrent.TimeUnit;

public class UI_Helper {
	
	public static void showUserInputRequest() {
		UI_Helper.clearConsole();
		
		System.out.println("Digite seu login: \n");
	}
	
	public static void showPasswordInputRequest() {
		UI_Helper.clearConsole();
		
		System.out.println("Digite sua senha: \n");
	}

	public final static void showLogo() throws InterruptedException {
		UI_Helper.clearConsole();
		
		System.out.println("  ______   _                       \n" + 
				" |  ____| | |                      \n" + 
				" | |__    | |  _   _  __  __   ___ \n" + 
				" |  __|   | | | | | | \\ \\/ /  / _ \\\n" + 
				" | |      | | | |_| |  >  <  |  __/\n" + 
				" |_|      |_|  \\__,_| /_/\\_\\  \\___|\n" + 
				"                                   \n" + 
				"                                   ");
			TimeUnit.SECONDS.sleep(4);
	}
	
	public final static void showMenu() {
		UI_Helper.clearConsole();
		
		System.out.println("  __  __                     \n" + 
				" |  \\/  |  ___   _ _    _  _ \n" + 
				" | |\\/| | / -_) | ' \\  | || |\n" + 
				" |_|  |_| \\___| |_||_|  \\_,_|\n" + 
				"                              \n");
		
		System.out.println("--------------------------------------------------------------------------------------\n" + 
				"\n" + 
				"Digite o número da sua escolha:\n" + 
				"\n" + 
				"( 1 ) - Cadastrar um usuário\n" + 
				"\n" + 
				"( 2 ) - Alterar dados de um usuário\n" + 
				"\n" + 
				"( 3 ) - Alterar minha senha\n" + 
				"\n" + 
				"( 4 ) - Cadastrar uma entrada no Fluxo de caixa\n" + 
				"\n" + 
				"( 5 ) - Cadastrar uma saída no Fluxo de caixa \n" + 
				"\n" + 
				"( 6 ) - Gerar Relatórios\n" + 
				"\n" + 
				"( 7 ) - Sair\n" + 
				"");
	}
	
	
	public final static void clearConsole()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	    	System.out.println(e);
	    }
	}

	public static void showMessage(String string) throws InterruptedException {
		System.out.println(string);
		TimeUnit.SECONDS.sleep(4);
	}
}
