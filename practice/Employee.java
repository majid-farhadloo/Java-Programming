public class Employee {
	// instance variables
	private String firstName;
	private String lastName;
	private String department;
	private String jobTitle;
	private int salary;
	private int salaryMinusFurloughs;

	public Employee() {
		super();
		firstName = "";
		lastName = "";
		department = "";
		jobTitle = "";
		salary = 0;
		salaryMinusFurloughs = 0;
	}

	public Employee(String[] record) {
		firstName = record[0];
		lastName = record[1];
		jobTitle = record[2];
		department = record[3];
		salary = Integer.parseInt(record[4]);
		salaryMinusFurloughs = Integer.parseInt(record[5]);
		;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalaryMinusFurloughs() {
		return salaryMinusFurloughs;
	}

	public void setSalaryMinusFurloughs(int salaryMinusFurloughs) {
		this.salaryMinusFurloughs = salaryMinusFurloughs;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName
				+ ", department=" + department + ", jobTitle=" + jobTitle
				+ ", salary=" + salary + ", salaryMinusFurloughs="
				+ salaryMinusFurloughs + "]";
	}

}
