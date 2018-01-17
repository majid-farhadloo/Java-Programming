import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentDataTest  {
	
	static ArrayList<MCStudents> arrayList = new ArrayList<MCStudents>();

	public static void main(String[] args) {
		//See if the file is present, catch exception if not
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File("grades.csv"));
		} 
		catch (FileNotFoundException e) {

			System.out.println("Error opening the file carMPG.txt");
			System.exit(40);
		}

		int index = 0;

		//read in the first line of our file and do nothing with it
		inputStream.nextLine();

		while(inputStream.hasNext())  {
			String nextLine = inputStream.nextLine();
			String[] array = nextLine.split(",");
			String[] array2 ={array[0],array[1], array[2],
					array[3],array[10]};
			MCStudents newStudent = new MCStudents(array2);
			//System.out.println(newStudent);
			arrayList.add(newStudent);
		}
		
		Collections.sort(arrayList);
		
		for(MCStudents s: arrayList)
			System.out.println(s);

	}
}