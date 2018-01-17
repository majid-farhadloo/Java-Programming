import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// stack.java
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////
class StackX
{
   private int maxSize;        // size of stack array
   private AffordableRentalHousing[] affordableRentalHouse; // our object
   private int top;            // top of stack
//--------------------------------------------------------------
   public StackX(int s)         // constructor
   {
      maxSize = s;             // set array size
      affordableRentalHouse = new AffordableRentalHousing[maxSize];  // create array
      top = -1;                // no items yet
   }
//--------------------------------------------------------------
   public void push(AffordableRentalHousing j)    // put item on top of stack
   {
	   affordableRentalHouse[++top] = j;     // increment top, insert item
   }
//--------------------------------------------------------------
   public AffordableRentalHousing pop()           // take item from top of stack
   {
      return affordableRentalHouse[top--];  // access item, decrement top
   }
//--------------------------------------------------------------
   public AffordableRentalHousing peek()          // peek at top of stack
   {
      return affordableRentalHouse[top];
   }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if stack is empty
   {
      return (top == -1);
   }
//--------------------------------------------------------------
   public boolean isFull()     // true if stack is full
   {
      return (top == maxSize-1);
   }
//--------------------------------------------------------------
}  // end class StackX
////////////////////////////////////////////////////////////////
class AffordableRentalHousingTest
{
   public static void main(String[] args)
   {
      StackX housingInfo = new StackX(264); // initialize the size of array
      Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File("asas.csv")); // read from the file
		} 
		catch (FileNotFoundException e) {

			System.out.println("Error opening the file asas.CSV"); // print out when it is error to open the file
			System.exit(40);
		}
		
		inputStream.nextLine(); // read the header
		while(inputStream.hasNextLine()){ // until we have inputstream.hasNextline() continue;
			String aRH = inputStream.nextLine(); // read the second line from the file
			String newARH [] = aRH.split(","); // split the line by the comma
			AffordableRentalHousing lastARH = new AffordableRentalHousing(newARH); // make an object in the type of AffordableRentalHousing; this is going to call the constructor; 
			//System.out.println(aRH);
			housingInfo.push(lastARH); // stack them			
		}

		while(!housingInfo.isEmpty() )     // until it's empty,
      {                             // delete item from stack
    	  AffordableRentalHousing value = housingInfo.pop();
         System.out.println(value);      // display it
         System.out.print(" ");
      }  // end while
      System.out.println("");
   }  // end main()
}  // end class StackApp
////////////////////////////////////////////////////////////////
