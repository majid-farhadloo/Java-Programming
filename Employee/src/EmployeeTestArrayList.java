import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeTestArrayList {
	//private static Employee[] employees = new Employee[34218];
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	public static void main(String[] args) {
		// See if the file is present, catch exception if not
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File("Employee_data.csv"));
		} catch (FileNotFoundException e) {

			System.out.println("Error opening the file carMPG.txt");
			System.exit(40);
		}
		// read in the first line o four files and do nothing with
		inputStream.nextLine();
		while (inputStream.hasNext()) {
			// System.out.println(inputStream.nextLine());
			String stringReadIn = inputStream.nextLine();
			String[] arrayOfFields = stringReadIn.split(",");
			Employee employeeObject = new Employee(arrayOfFields);
			System.out.println(employeeObject);
			//employees[index++] = employeeObject;
			employees.add(employeeObject);

		}
		System.out.println(" the average pay for the police employee is "
				+ averagePayForPolice() + "\n the is the max salary a person make " + 
				maxSalary() + "\n The Record of the  S Murphy : " + record("MURPHY") +
				"\n these are the the number of people who have the same last name : " + sameName());	
	}

	// what was the average pay for all employee
	// that work in the police department
	public static double averagePayForPolice() {
		int total = 0;
		int count = 0;
		/*	Employee spot = null;
		for(int i =0; i<employees.size(); i++){
			//System.out.println(employees.get(i));
			if(employees.get(i).getLastName().equals(" S Murphy")){
				spot = employees.get(i);
				/*max = employees.get(i).getSalary();
				spot = employees.get(i);
			}
		}*/
		Iterator<Employee> iterator = employees.iterator();
		while(iterator.hasNext()){
			Employee e = iterator.next();
			String dept = e.getDepartment();
			if(dept.equals("POLICE")){
				total += e.getSalary();
				count++;
			}
			//System.out.println(iterator.next());
		}
		/*for (int i = 0; i < employees.length; i++) {
			// check to see if the department is Police
			if (employees[i].getDepartment().equals("POLICE")) {
				// add salary to total
				total += employees[i].getSalary();
				// increment count
				count++;
			}
		}*/

		return total / count;
	}
	public static Employee maxSalary(){
		int max = 0;
		Employee spot = null;
		Iterator<Employee> iterator = employees.iterator();
		while(iterator.hasNext()){
			Employee e = iterator.next();
			int salary = e.getSalary();
			if(salary > max){
				max = salary;
				spot = e;
			}
		}
		//System.out.println(iterator.next());
		return spot;
	}
	public static Employee record(String last){
		Employee place = null;
		Iterator<Employee> iterator = employees.iterator();
		while(iterator.hasNext()){
			Employee e = iterator.next();
			String lastName = e.getLastName();
			if(lastName.equals(last)){
				place = e;
			}
		}
		//System.out.println(iterator.next());
		return place;
	}
	public static int sameName(){
		String info = null;
		int count = 0;
		for(int i = 0; i<employees.size();i++){
			String lastSameName = employees.get(i).getLastName();
			for(int j= 0;j<employees.size();j++){
				String nextLastName = employees.get(j).getLastName();
				if(lastSameName.equals(nextLastName)){
					//System.out.println(employees.get(i).getLastName());
					//System.out.println(employees.get(j).getLastName());
					count++;
					//System.exit(0);	
				}
			}
		}
		//count++;
		return count;
	}
}




/*public static int maxSalary(){
		int maxPayment = 0;2
		int spot = 0;
		Iterator<Employee> iterator = employees.iterator();
		Employee e = iterator.next();
		for (int i = 0; i < employees.size(); i++) {
			//Employee e = iterator.next();
			int salary = employees.getSalary(i);
			if (salary(i) > maxPayment){
				maxPayment = salary(i);
				spot = i;
			}
		}
		System.out.println(employees[spot].getFirstName() + employees[spot].getLastName() + employees[spot].getJobTitle() + " " + employees[spot].getDepartment());
		return maxPayment;
	}*/
/*
	public static Employee maxSalary() {
		int maxPayment = 0;
		Employee spot = null;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getSalary() > maxPayment){
				maxPayment = employees[i].getSalary();
				//spot = i;
				spot = employees[i];
			}
		}
		//System.out.println(employees[spot].getFirstName() + employees[spot].getLastName() + employees[spot].getJobTitle() + " " + employees[spot].getDepartment());
		//return maxPayment;
		return spot;
	}
 */
/*public static String Info() {
		int max = maxSalary();
		for (int i = 0; i < employees.length; i++) {
			if(employees[i].getSalary()== max){
				String name = employees[i].getFirstName();
				String lastN = employees[i].getLastName(); 
				String job = employees[i].getJobTitle(); 
				String deprt = employees[i].getDepartment(); 
			}
		}

	}*/


