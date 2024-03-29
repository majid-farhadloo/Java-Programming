import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class MCStudentsTest {
	//private static ArrayList<MCStudents> students = new ArrayList<MCStudents>();
	public static void main(String[] args) {
		//create a variable of type Student
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File("grades.csv"));
		} 
		catch (FileNotFoundException e) {

			System.out.println("Error opening the file carMPG.txt");
			System.exit(40);
		}
		int index = 0;
		inputStream.nextLine();
		while(inputStream.hasNext()){
			String nextLine = inputStream.nextLine();
			String[] array = nextLine.split(",");
			String[] array2 = {array[0], array[1], array[2], array[3], array[10]};
			MCStudents newStudent = new MCStudents(array2);
			students.add(newStudent);
			//System.out.println(students);
			//Collections.sort(students);
			//System.out.println(averageOfStudent());
			//for(MCStudents s : students)
			//System.out.println(s);
			//System.out.println(mostA_s());
		}
		System.out.println(" the average grade in CPSC-39 for each of the terms, for all of the students at that term :" + average());

	}
	
	public static int average(){
		int sum =0;
		int count = 0;
		String[] semster = {"S","F","U"};
		for(int year =2009;year<=2016;year++){
			for(int i =0; i<semster.length;i++){
				String year_semster = year + semster[i];
				for(int j =0; j<students.size();j++){
					//System.out.println(students.get(j));

					String course = students.get(j).getCourse();
					String term = students.get(j).getTerm();
					String grade = students.get(j).getGrade();
					if(term.equalsIgnoreCase(year_semster) && course.equalsIgnoreCase("CPSC-39")){
						//System.out.println(students.get(j));

						count++;
						if(grade.equalsIgnoreCase("A")){
							sum +=100;
						}
						if(grade.equalsIgnoreCase("B")){
							sum +=90;
						}
						if(grade.equalsIgnoreCase("C")){
							sum +=80;
						}
						if(grade.equalsIgnoreCase("D")){
							sum +=70;
						}
						if(grade.equalsIgnoreCase("F")){
							sum +=0;
						}
						if(grade.equalsIgnoreCase("FW")){
							sum +=0;
						}
					}
				}
				
			}
		}
		if(count == 0)
			count = 1;
		return sum/count;
	}
	public static String averageOfStudent(){
		Iterator<MCStudents> iterator = students.iterator();
		String[] semster = {"S","F","U"};
		int countS = 0;
		int countF = 0;
		int countU= 0;
		int totalStudent = 0;
		for(int year = 2009;year<=2016;year++){
			String summer_semster = year +"S";
			String fall_semster = year +"F";
			String u_semster = year +"U";
			while(iterator.hasNext()){
				MCStudents studentArray = iterator.next();
				String course = studentArray.getCourse();
				String term = studentArray.getTerm();
				if(course.equalsIgnoreCase("CPSC-39")){
					totalStudent++;
					if(term.equalsIgnoreCase(summer_semster)){
						countS++;
					}
					if(term.equalsIgnoreCase(fall_semster)){
						countF++;
					}
					if(term.equalsIgnoreCase(u_semster)){
						countU++;
					}

				}
			}

		}
		return " the average studnet for the summer : " + countS/totalStudent + " \n the average studnet for the fall : " + 
		countF/totalStudent + " the average studnet for the U : " + countU/totalStudent ;
	}
	public static int mostA_s(){
		int aS = 0;
		String course2 = null;
		for(int i=0;i<students.size();i++){
			String depart = students.get(i).getDiscipline();
			String course = students.get(i).getCourse();
			String grade =  students.get(i).getGrade(); 
			if(depart.equalsIgnoreCase("CPSC")){
				for(int j=i;j<students.size();j++){
					course2 = students.get(j).getCourse();
					if(course.equalsIgnoreCase(course2) && grade.equalsIgnoreCase("A")){
						aS++;
					}
				}
			}
		}
		System.out.println(course2 + " and the A's is equal = " +aS);
		return aS;
	}

}

