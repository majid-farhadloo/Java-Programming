import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeTest {
	private static Employee[] employees = new Employee[34218];

	public static void main(String[] args) {
		// See if the file is present, catch exception if not
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File("Employee_data.csv"));
		} catch (FileNotFoundException e) {

			System.out.println("Error opening the file Employee_data.csv");
			System.exit(40);
		}
		int index = 0;
		// read in the first line o four files and do nothing with
		inputStream.nextLine();
		while (inputStream.hasNext()) {
			//System.out.println(inputStream.nextLine());
			String stringReadIn = inputStream.nextLine();
			String[] arrayOfFields = stringReadIn.split(",");
			Employee employeeObject = new Employee(arrayOfFields);
			System.out.println(employeeObject);
			employees[index++] = employeeObject;

		}
		System.out.println(" the average pay for the police employee is " + averagePayForPolice()
				+ "\n the is the max salary a person make " + maxSalary() + " which his information is :" + info() );
	}

	// what was the average pay for all employee
	// that work in the police department
	public static double averagePayForPolice() {
		double total = 0;
		int i = 0;
		for (i = 0; i < employees.length; i++) {
			// check to see if the department is Police
			if (employees[i].getDepartment().equals("POLICE")) {
				// add salary to total
				total += employees[i].getSalary();
			}
		}
		return total / i;
	}

	public static int maxSalary() {
		int maxPayment = 0;
		int spot = 0;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getSalary() > maxPayment) {
				maxPayment = employees[i].getSalary();
				spot = i;
			}
		}
		System.out.println("The maxumin salary is = " + maxPayment);
		return maxPayment;
		/*
		 * return " " + employees[spot].getFirstName() +
		 * employees[spot].getLastName() + " " + employees[spot].getJobTitle() +
		 * " " + employees[spot].getDepartment();
		 */
	}
	/*
	 * public static Employee maxSalary() {
	 *  int maxPayment = 0; 
	 *  Employee spot = null; 
	 *  for (int i = 0; i < employees.length; i++) {
	 *  if(employees[i].getSalary() > maxPayment){
	 *   maxPayment = employees[i].getSalary(); 
	 *   spot = employees[i];
	 *   	} 
	 *   } 
	 *   return spot;
	 *}
	 */
	// System.out.println(employees[spot].getFirstName() +
	// return maxPayment; }

	public static String info() {
		int max = maxSalary();
		String name = ""; 
		String lastN= "" ;
		String job = "";
		String depart = "";
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getSalary() == max) {
				 name = employees[i].getFirstName();
				 lastN = employees[i].getLastName();
				 job = employees[i].getJobTitle();
				 depart = employees[i].getDepartment();

			}
		}
		return " " + name +" "+ lastN + " " + job + " " + depart;
	}
}
