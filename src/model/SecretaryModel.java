package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import staff.ContractLecturer;
import staff.FullTimeLecturer;
import staff.Lecturer;
import staff.PartTimeLecturer;

public class SecretaryModel {
	
	
	String sec = new String();
	
	public List<FullTimeLecturer> findAllFullTimeLecturer() {
		
		ArrayList<FullTimeLecturer> lists = new ArrayList<FullTimeLecturer>();
		
		System.out.println(sec);
		try { 
			FileInputStream fis = new FileInputStream("fullTimeLecturer.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
				if (sec.equals(((Lecturer) obj).getDepartment())) {
					lists.add((FullTimeLecturer)obj);
				}
			}
			ois.close(); 
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 } 
		return lists;  
	}
	public List<PartTimeLecturer> findAllPartTimeLecturer() {
		
		ArrayList<PartTimeLecturer> lists = new ArrayList<PartTimeLecturer>();

		try { 
			FileInputStream fis = new FileInputStream("partTimeLecturer.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
				if (sec.equals(((Lecturer) obj).getDepartment())) {
					lists.add((PartTimeLecturer)obj);
				}
			}
			ois.close(); 
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 } 
		return lists;  
	}
	public List<ContractLecturer> findAllContractLecturer() {
		
	ArrayList<ContractLecturer> lists = new ArrayList<ContractLecturer>();

	try { 
		FileInputStream fis = new FileInputStream("contractLecturer.dat"); 
		ObjectInputStream ois = new ObjectInputStream(fis); 
		
		Object obj = null;
		while ((obj = ois.readObject()) != null) {
			if (sec.equals(((Lecturer) obj).getDepartment())) {
				lists.add((ContractLecturer)obj);
			}
		}
			ois.close(); 
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
		 } 
		return lists;  
	}
	
	public void setSecretary(String sec) {
		this.sec = sec;
	}
}
