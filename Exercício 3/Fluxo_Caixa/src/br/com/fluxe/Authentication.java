package br.com.fluxe;

public class Authentication {
	private static String user;
	private static String password;
	
	public static boolean getPermission() {
		user = Input_Handler.getUser();
		password = Input_Handler.getPassword();
		
		return true;
	}
	
}
