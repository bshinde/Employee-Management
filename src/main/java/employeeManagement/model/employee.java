package employeeManagement.model;

public class employee {
	private int employeeId ;
	private String Name;
	private String Address;
	private String Gender;
	private int Salary;
	private String BirthDate	;
	
	
	public employee(int employeeId, String name, String address, String gender, int salary, String  birthDate2) {
		super();
		this.employeeId = employeeId;
		this.Name = name;
		this.Address = address;
		this.Gender = gender;
		this.Salary = salary;
		this.BirthDate = birthDate2;
	}
	
	


	public employee(String name, String address, String gender, int salary, String birthDate) {
		super();
		this.Name = name;
		this.Address = address;
		this.Gender = gender;
		this.Salary = salary;
		this.BirthDate = birthDate;
	}




	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String BirthDate) {
		this.BirthDate = BirthDate;
	}
	
}