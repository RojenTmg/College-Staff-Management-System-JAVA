package staff;

import java.io.Serializable;

public class Lecturer implements Serializable {
	
	protected int idNo;
	protected String name;
	protected String address;
	protected String phoneNo;
	protected String email;
	protected String dateStarted;
	protected String department;
	
	public Lecturer(int idNo, String name, String address, String phoneNo, String email, String dateStarted, String department) {

		this.idNo = idNo;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.dateStarted = dateStarted;
		this.department = department;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(String dateStarted) {
		this.dateStarted = dateStarted;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
