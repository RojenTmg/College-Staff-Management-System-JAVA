package staff;

public class ContractLecturer extends Lecturer {
	
	private int salary;
	private String dateExipiry;
	
	public ContractLecturer(int idNo, String name, String address, String phoneNo, String email, String dateStarted,
			 String department, int salary, String dateExipiry) {
		super(idNo, name, address, phoneNo, email, dateStarted, department);
		this.salary = salary;
		this.dateExipiry = dateExipiry;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDateExipiry() {
		return dateExipiry;
	}

	public void setDateExipiry(String dateExipiry) {
		this.dateExipiry = dateExipiry;
	}
}
