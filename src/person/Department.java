package person;

import java.io.Serializable;

public class Department implements Serializable{
	
	private String deptName;
	private String depttype; 
	private String deptWebAddress;
	private String deptUsername;
	private String deptPassword;
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDepttype() {
		return depttype;
	}
	public void setDepttype(String depttype) {
		this.depttype = depttype;
	}
	public String getDeptWebAddress() {
		return deptWebAddress;
	}
	public void setDeptWebAddress(String deptWebAddress) {
		this.deptWebAddress = deptWebAddress;
	}
	public String getDeptUsername() {
		return deptUsername;
	}
	public void setDeptUsername(String deptUsername) {
		this.deptUsername = deptUsername;
	}
	public String getDeptPassword() {
		return deptPassword;
	}
	public void setDeptPassword(String deptPassword) {
		this.deptPassword = deptPassword;
	}
	public Department(String deptName, String depttype, String deptWebAddress, String deptUsername,
			String deptPassword) {
		this.deptName = deptName;
		this.depttype = depttype;
		this.deptWebAddress = deptWebAddress;
		this.deptUsername = deptUsername;
		this.deptPassword = deptPassword;
	}
	public Department() {
	}
}
