package staff;

public class PartTimeLecturer extends Lecturer {
	
	private int hourlyRate;
	
	public PartTimeLecturer(int idNo, String name, String address, String phoneNo, String email, String dateStarted,
			 String department, int hourlyRate) {
		super(idNo, name, address, phoneNo, email, dateStarted, department);
		this.hourlyRate = hourlyRate;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
}

