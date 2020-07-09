package br.com.fluxe;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Serializer_User {
	
	public Serializer_User() {
	    try {
	        File userFile = new File("users.txt");
	        if (userFile.createNewFile()) {
	          System.out.println("File created: " + userFile.getName());
	        } else {
	          System.out.println("File already exists.");
	        }
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	private static Vector<User> users;
	
	public static Vector<User> getAllUsers() {
		users.clear();
		return null;
	}
	
	public static User getUser(int position) {
		users.clear();
			
		return null;
	}
	
	public static boolean addUser(User user) {
		users.clear();
		users = getAllUsers();
		users.add(user);
		return true;
	}
}
