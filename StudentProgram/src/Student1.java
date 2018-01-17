

//a template for a single Student object

public class Student1 {
	
	//instance or data  variables - 
	//descriptors of a Student object
	private String name = "Lisa";
	private int age;
	private int numOfClasses;
	
	//default constructor - is to make the new variable
	//of type Student in RAM
	//initialize all of your instance variables
	public Student1() {
		name = "John";
		age = 24;
		numOfClasses = 9;
	}
	
	public Student1 (String newName, int newAge, int newClasses) {
		name = newName;
		age = newAge;
		numOfClasses = newClasses;
	}
// accessor method -  getter - getMethod
	//string name
	public String getName (){
		return name;
	}
	public int getAge (){
		return age;
	}
	public int getNumOfClass (){
		return numOfClasses;
	}
	//mutator method -  setter - set method
	public void setName(String name){
		this.name=name; 
	}
	public void setAge(int age){
		this.age=age; 
	}
	public void setNumOfClass(int numOfClasses){
		this.numOfClasses=numOfClasses; 
	}
	public String toString() {
		String s = "Name : " + name;
		s+= "\nAge :" + age;
		s+= "\nNumOfClass :" + numOfClasses;
		return s;
		}
	public boolean equals(Student1 student2){
		return student2.name.equalsIgnoreCase(name) && age == student2.age;
		
	}
}

	