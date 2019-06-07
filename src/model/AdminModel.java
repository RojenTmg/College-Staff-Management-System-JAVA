package model;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import appendableOOS.AppendableObjectOutputStream;
import staff.*;

import person.*;

public class AdminModel {
	
	private ArrayList<String> dept = new ArrayList<String>();
	
	public void addDepartment(String name, String type, String webAddress, String username, String password) {
		try { 

     		File file = new File("department.dat");
			if (!file.exists()) {
				FileOutputStream fos = new FileOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(fos); 
				oos.writeObject(new Department(name, type, webAddress, username, password));
				oos.close(); 
			}
			else {
				FileOutputStream fos1 = new FileOutputStream(file, true); 
				BufferedOutputStream outputBuffer = new BufferedOutputStream(fos1);
				AppendableObjectOutputStream aoos = new AppendableObjectOutputStream(outputBuffer); 
				aoos.writeObject(new Department(name, type, webAddress, username, password));
				aoos.close();
			}
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 }  
	}
	public void updateDepartment(String updateData, String departmentName, String departmentType, String departmentWebAddress, String departmentUsername, String departmentPassword) {
		
		try {
			FileInputStream fis = new FileInputStream("department.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			File tempFile = new File("temp.dat");
			FileOutputStream fos = new FileOutputStream(tempFile); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
			    if (obj instanceof Department) {
			    	Department dept = (Department) obj;
			    	if (dept.getDeptName().equals(updateData)) {
			    		dept.setDeptName(departmentName);
			    		dept.setDepttype(departmentType);
			    		dept.setDeptWebAddress(departmentWebAddress);
			    		dept.setDeptUsername(departmentUsername);
			    		dept.setDeptPassword(departmentPassword);
			    		oos.writeObject(dept);
			    	}
			    	else {
			    		oos.writeObject(dept);
			    	}
			    }
			}
			ois.close(); 
			oos.close();
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
			 System.out.println("One department updated!!!");
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 } 
		replaceFile("temp.dat", "department.dat");
	}
	public List<Department> findAllDepartment() {
		
		ArrayList<Department> lists = new ArrayList<Department>();
		dept.clear();
		
		try { 
			FileInputStream fis = new FileInputStream("department.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
				dept.add(((Department) obj).getDeptName());
		    	lists.add((Department)obj);
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
	String file;
	
	
	public void removeDepartment(String departmentName) {
		try {
			FileInputStream fis = new FileInputStream(file); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			File tempFile = new File("temp.dat");
			FileOutputStream fos = new FileOutputStream(tempFile); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
			    if (obj instanceof Department) {
			    	Department dept = (Department) obj;
			    	
			    	if (!(dept.getDeptName().equals(departmentName))) {
			    		oos.writeObject(dept);
			    	}
			    }
			}
			ois.close(); 
			oos.close();
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
			 System.out.println("One Department deleted."); 
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 } 
		replaceFile("temp.dat", "department.dat");
	}
	public List<String> findAllDepartmentDropDown() {
		return dept;
	}
	

	public void addFullTimeLecturer(String idNo,	String name, String address, String phoneNo, String email, String dateStarted, String salary, String department) throws NumberFormatException{
		try { 
     		File file = new File("fullTimeLecturer.dat");
			if (!file.exists()) {
				FileOutputStream fos = new FileOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(fos); 
				oos.writeObject( new FullTimeLecturer(Integer.parseInt(idNo), name, address, phoneNo, email, dateStarted, department, Integer.parseInt(salary)));
				oos.close(); 
			}
			else {
				FileOutputStream fos1 = new FileOutputStream(file, true); 
				BufferedOutputStream outputBuffer = new BufferedOutputStream(fos1);
				AppendableObjectOutputStream aoos = new AppendableObjectOutputStream(outputBuffer); 
				aoos.writeObject( new FullTimeLecturer(Integer.parseInt(idNo), name, address, phoneNo, email, dateStarted, department, Integer.parseInt(salary)));
				aoos.close();
			}
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 }  
	}
	public void updateFullTimeLecturer(String updateData, String idNo,	String name, String address, String phoneNo, String email, String dateStarted, String salary, String department) throws NumberFormatException{
		try {
			FileInputStream fis = new FileInputStream("fullTimeLecturer.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			File tempFile = new File("temp.dat");
			FileOutputStream fos = new FileOutputStream(tempFile); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
			    if (obj instanceof FullTimeLecturer) {
			    	FullTimeLecturer lec = (FullTimeLecturer) obj;
			    	if (lec.getIdNo() == Integer.parseInt(updateData)) {
			    		lec.setIdNo(Integer.parseInt(idNo));
			    		lec.setName(name);
			    		lec.setAddress(address);
			    		lec.setPhoneNo(phoneNo);
			    		lec.setEmail(email);
			    		lec.setDateStarted(dateStarted);
			    		lec.setDepartment(department);
			    		lec.setSalary(Integer.parseInt(salary));
			    		oos.writeObject(lec);
			    	}
			    	else {
			    		oos.writeObject(lec);
			    	}
			    }
			}
			ois.close(); 
			oos.close();
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
			 System.out.println("One Full-Time Lecturer updated!!!");
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");  
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found.");       
	 	 } catch (IOException ex) {             
	 		System.out.println("I/O operation failed.");         
		 }
		replaceFile("temp.dat", "fullTimeLecturer.dat");
	}	
	public List<FullTimeLecturer> findAllFullTimeLecturer() {
		
		ArrayList<FullTimeLecturer> lists = new ArrayList<FullTimeLecturer>();

		try { 
			FileInputStream fis = new FileInputStream("fullTimeLecturer.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
		    	lists.add((FullTimeLecturer)obj);
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
	public void removeFullTimeLecturer(String lecId) {
		try {
			FileInputStream fis = new FileInputStream("fullTimeLecturer.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			File tempFile = new File("temp.dat");
			FileOutputStream fos = new FileOutputStream(tempFile); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
			    if (obj instanceof FullTimeLecturer) {
			    	FullTimeLecturer lec = (FullTimeLecturer) obj;
			    	
			    	if (!(lec.getIdNo() == Integer.parseInt(lecId))) {
			    		oos.writeObject(lec);
			    	}
			    }
			}
			ois.close(); 
			oos.close();
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
			 System.out.println("One Full-Time Lecturer deleted."); 
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 } 
		replaceFile("temp.dat", "fullTimeLecturer.dat");
	}
		
	public void addPartTimeLecturer(String lecId, String lecName, String lecAddress, String lecPhNo, String lecEmail, String lecStarted, String lecHRate, String department)  throws NumberFormatException {
		try { 
     		File file = new File("partTimeLecturer.dat");
			if (!file.exists()) {
				FileOutputStream fos = new FileOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(fos); 
				oos.writeObject(new PartTimeLecturer(Integer.parseInt(lecId), lecName, lecAddress, lecPhNo, lecEmail, lecStarted, department, Integer.parseInt(lecHRate)));
				oos.close(); 
			}
			else {
				FileOutputStream fos1 = new FileOutputStream(file, true); 
				BufferedOutputStream outputBuffer = new BufferedOutputStream(fos1);
				AppendableObjectOutputStream aoos = new AppendableObjectOutputStream(outputBuffer); 
				aoos.writeObject(new PartTimeLecturer(Integer.parseInt(lecId), lecName, lecAddress, lecPhNo, lecEmail, lecStarted, department, Integer.parseInt(lecHRate)));
				aoos.close();
			}
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 }   
	}
	public void updatePartTimeLecturer(String updateData, String idNo, String name, String address, String phoneNo, String email, String dateStarted, String HRate, String department)  throws NumberFormatException {
		try {
			FileInputStream fis = new FileInputStream("partTimeLecturer.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			File tempFile = new File("temp.dat");
			FileOutputStream fos = new FileOutputStream(tempFile); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
			    if (obj instanceof PartTimeLecturer) {
			    	PartTimeLecturer lec = (PartTimeLecturer) obj;
			    	if (lec.getIdNo() == Integer.parseInt(updateData)) {
			    		lec.setIdNo(Integer.parseInt(idNo));
			    		lec.setName(name);
			    		lec.setAddress(address);
			    		lec.setPhoneNo(phoneNo);
			    		lec.setEmail(email);
			    		lec.setDateStarted(dateStarted);
			    		lec.setDepartment(department);
			    		lec.setHourlyRate(Integer.parseInt(HRate));
			    		oos.writeObject(lec);
			    	}
			    	else {
			    		oos.writeObject(lec);
			    	}
			    }
			}
			ois.close(); 
			oos.close();
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
			 System.out.println("One Part-Time Lecturer updated!!!");
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");  
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found.");       
	 	 } catch (IOException ex) {             
	 		System.out.println("I/O operation failed.");         
		 }
		replaceFile("temp.dat", "partTimeLecturer.dat");
	}
	public List<PartTimeLecturer> findAllPartTimeLecturer() {
		
		ArrayList<PartTimeLecturer> lists = new ArrayList<PartTimeLecturer>();

		try { 
			FileInputStream fis = new FileInputStream("partTimeLecturer.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
		    	lists.add((PartTimeLecturer)obj);
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
	public void removePartTimeLecturer(String lecId) {
		try {
			FileInputStream fis = new FileInputStream("partTimeLecturer.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			File tempFile = new File("temp.dat");
			FileOutputStream fos = new FileOutputStream(tempFile); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
			    if (obj instanceof PartTimeLecturer) {
			    	PartTimeLecturer lec = (PartTimeLecturer) obj;
			    	
			    	if (!(lec.getIdNo() == Integer.parseInt(lecId))) {
			    		oos.writeObject(lec);
			    	}
			    }
			}
			ois.close(); 
			oos.close();
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
			 System.out.println("One Part-Time Lecturer deleted."); 
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 } 
		replaceFile("temp.dat", "partTimeLecturer.dat");
	}

	public void addContractLecturer(String lecId, String lecName, String lecAddress, String lecPhNo, String lecEmail, String lecStarted, String lecSalary, String lecContractEx, String department)  throws NumberFormatException {
		try { 
     		File file = new File("contractLecturer.dat");
			if (!file.exists()) {
				FileOutputStream fos = new FileOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(fos); 
				oos.writeObject(new ContractLecturer(Integer.parseInt(lecId), lecName, lecAddress, lecPhNo, lecEmail, lecStarted, department, Integer.parseInt(lecSalary), lecContractEx));
				oos.close(); 
			}
			else {
				FileOutputStream fos1 = new FileOutputStream(file, true); 
				BufferedOutputStream outputBuffer = new BufferedOutputStream(fos1);
				AppendableObjectOutputStream aoos = new AppendableObjectOutputStream(outputBuffer); 
				aoos.writeObject(new ContractLecturer(Integer.parseInt(lecId), lecName, lecAddress, lecPhNo, lecEmail, lecStarted, department, Integer.parseInt(lecSalary), lecContractEx));
				aoos.close();
			}
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 }   
	}	
	public void updateContractLecturer(String updateData, String lecId, String lecName, String lecAddress, String lecPhNo, String lecEmail, String lecStarted, String lecSalary, String lecContractEx, String department)  throws NumberFormatException  {
		try {
			FileInputStream fis = new FileInputStream("contractLecturer.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			File tempFile = new File("temp.dat");
			FileOutputStream fos = new FileOutputStream(tempFile); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
			    if (obj instanceof ContractLecturer) {
			    	ContractLecturer lec = (ContractLecturer) obj;
			    	if (lec.getIdNo() == Integer.parseInt(updateData)) {
			    		lec.setIdNo(Integer.parseInt(lecId));
			    		lec.setName(lecName);
			    		lec.setAddress(lecAddress);
			    		lec.setPhoneNo(lecPhNo);
			    		lec.setEmail(lecEmail);
			    		lec.setDateStarted(lecStarted);
			    		lec.setDepartment(department);
			    		lec.setSalary(Integer.parseInt(lecSalary));
			    		lec.setDateExipiry(lecContractEx);
			    		oos.writeObject(lec);
			    	}
			    	else {
			    		oos.writeObject(lec);
			    	}
			    }
			}
			ois.close(); 
			oos.close();
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
			 System.out.println("One Contract Lecturer updated!!!");
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");  
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found.");       
	 	 } catch (IOException ex) {             
	 		System.out.println("I/O operation failed.");         
		 }	
		replaceFile("temp.dat", "contractLecturer.dat");
	}
	public List<ContractLecturer> findAllContractLecturer() {
	
	ArrayList<ContractLecturer> lists = new ArrayList<ContractLecturer>();

	try { 
		FileInputStream fis = new FileInputStream("contractLecturer.dat"); 
		ObjectInputStream ois = new ObjectInputStream(fis); 
		
		Object obj = null;
		while ((obj = ois.readObject()) != null) {
	    	lists.add((ContractLecturer)obj);
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
	public void removeContractLecturer(String lecId) {
		try {
			FileInputStream fis = new FileInputStream("contractLecturer.dat"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			File tempFile = new File("temp.dat");
			FileOutputStream fos = new FileOutputStream(tempFile); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			Object obj = null;
			while ((obj = ois.readObject()) != null) {
			    if (obj instanceof ContractLecturer) {
			    	ContractLecturer lec = (ContractLecturer) obj;
			    	
			    	if (!(lec.getIdNo() == Integer.parseInt(lecId))) {
			    		oos.writeObject(lec);
			    	}
			    }
			}
			ois.close(); 
			oos.close();
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
			 System.out.println("One Contract Lecturer deleted."); 
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 } 
		replaceFile("temp.dat", "contractLecturer.dat");
	}
	
	public void replaceFile(String tempFile, String newFile) {
		try {
			FileInputStream fisTemp = new FileInputStream(tempFile); 
			ObjectInputStream oisTemp = new ObjectInputStream(fisTemp); 
//			System.out.println(1);
			boolean exists = true;
			
			Object obj1 = null;
			
			while ((obj1 = oisTemp.readObject()) != null) {
	    		File file = new File(newFile);
	    		if (exists) {
//	    			System.out.println(2);
					FileOutputStream fosFinal = new FileOutputStream(file); 
					ObjectOutputStream oosFinal = new ObjectOutputStream(fosFinal); 
					oosFinal.writeObject(obj1);
					oosFinal.close();
					exists = false;
				}
				else {
					FileOutputStream fos1 = new FileOutputStream(file, true); 
					BufferedOutputStream outputBuffer = new BufferedOutputStream(fos1);
					AppendableObjectOutputStream aoos = new AppendableObjectOutputStream(outputBuffer); 
					aoos.writeObject(obj1);
					aoos.close();
				}
			}
			oisTemp.close();
		 } catch (EOFException ex) {  
			 System.out.println("End of file reached."); 
		 } catch (ClassNotFoundException ex) {             
			 System.out.println("Class is not found.");
		 } catch (FileNotFoundException ex) {             
			 System.out.println("File is not found at the moment.");
	 	 } catch (IOException ex) {             
	 		 System.out.println("I/O operation failed.");         
 		 } 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void saveDepartment(String deptName, String deptType, String deptWebAddress, String deptUsername, char[] deptPassword) {
//		listProducts.add(new Department(deptName, deptType, deptWebAddress, deptUsername, deptPassword));
//	}
	
	
//	public List<Department> findAll() {
//		
////		ArrayList<Department> listProducts = new ArrayList<Department>();
////		
////		while (!listProducts.isEmpty()) {
////			listProducts.add(product);
////		}
////		listProducts.add(new Department("Department 1", "Science", "www.science.com", "sci123"));
//		
//		return listProducts;
//	}
//	public Department search(String deptName) {
//		for (Department department : findAll()) {
//			if (department.getDeptName().equals(deptName)) 
//				return department;
//		}
//		return null;
//	}
}
