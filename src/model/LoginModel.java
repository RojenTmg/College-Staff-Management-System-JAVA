package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import person.Department;

public class LoginModel {
	
	public String checkUser(String username, char[] password) {
		
		String user = "error";
		if (username.equals("admin")) {
			user = "admin";
			char[] pass = {'a', 'd', 'm', 'i', 'n'};
			
			if (password.length == pass.length) {
				for (int i = 0; i < password.length; i++) {
					if (pass[i] != password[i]) {
						user = "error";
					}
					else {
						return user;
					}
				}
			}
			else {
				user = "error";
			}
		}
		
		try { 
			FileInputStream fis = new FileInputStream("department.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			Object obj = null;
			String lecPass = new String(password);

			while ((obj = ois.readObject()) != null) {
				if (username.equals(((Department)obj).getDeptUsername()) && lecPass.equals(((Department) obj).getDeptPassword())) {
						user = ((Department)obj).getDeptName();
						return user;						
				}
				else {
					user = "error";
				}
			}
			ois.close(); 
		 } catch (EOFException ex1) {  
			 System.out.println("End of file reached."); 
		 } catch (ClassNotFoundException ex2) {             
			 System.out.println("Class is not found.");
		 } catch (FileNotFoundException ex3) {             
			 System.out.println("File is not found at the moment.");
		 } catch (IOException ex4) {             
			 System.out.println("I/O operation failed.");         
		 }
		return user;
	}
	
}
