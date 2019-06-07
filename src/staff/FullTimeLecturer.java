package staff;

public class FullTimeLecturer extends Lecturer {
	
	private int salary;
	
	public FullTimeLecturer(int idNo, String name, String address, String phoneNo, String email, String dateStarted,
			 String department, int salary) {
		super(idNo, name, address, phoneNo, email, dateStarted, department);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
