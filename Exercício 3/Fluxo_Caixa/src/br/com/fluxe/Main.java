package br.com.fluxe;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Program_Status status = Program_Status.RUNNING;
		Menu_Options option;
		
		UI_Helper.showLogo();
		
		
		while(!status.equals(Program_Status.EXITED)) {
			UI_Helper.showMenu();
			option = Input_Handler.menu_input();
			System.out.println(option);
			
			switch(option) {
				case ADD_USER:
					Authentication.getPermission();
					
					if(Input_Handler.addUserInput()) {
						UI_Helper.showMessage("Usuário cadastrado com sucesso.");
					} else {
						UI_Helper.showMessage("Houve um problema durante o cadastramento do usuário.");
					}
					break;
					
				case ALTER_USER_DATA:
					Authentication.getPermission();
					break;
				case ALTER_PASSWORD:
					Authentication.getPermission();
					break;
				case ADD_ENTRY_FLUXE:
					Authentication.getPermission();
					break;
				case ADD_EXIT_FLUXE:
					Authentication.getPermission();
					break;
				case MAKE_FINANCIAL_REPORT:
					Authentication.getPermission();
					break;
				case EXIT:
					break;
				default:
					break;
			}
		}
	}
}
