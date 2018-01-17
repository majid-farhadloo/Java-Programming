
public class StudentTest {
	public static void main(String[] args) {
		//create a variable of type Student
		Student1 student1  = new Student1();
		System.out.println(student1);
		//System.out.println(student1.getName());
		//System.out.println(student1.getAge());
		//System.out.println(student1.getNumOfClass());
		
		Student1 student2 = new Student1("Mary", 34, 5);
		System.out.println(student2);
		/*System.out.println(student2.getName());
		System.out.println(student2.getAge());
		System.out.println(student2.getNumOfClass());*/
		System.out.println(student1);
		student1 = student2;
		
		System.out.println(student1.getName());
		System.out.println(student1.getAge());
		System.out.println(student1.getNumOfClass());
		
		student1.setName("Lisa");
		System.out.println(student2.getName());
		if(student1.equals(student2))
			System.out.println(" The students are the same");
		else
			System.out.println(" the students are not the same");
	}

}

