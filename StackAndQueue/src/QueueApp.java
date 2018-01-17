import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Queue.java
//demonstrates queue
//to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue
{
	private int maxSize;
	private RainFall[] queArray;
	private int front;
	private int rear;
	private int nItems;
	//--------------------------------------------------------------
	public Queue(int s)          // constructor
	{
		maxSize = s;
		queArray = new RainFall[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	//--------------------------------------------------------------
	public void insert(RainFall j)   // put item at rear of queue
	{
		if(nItems==maxSize)						//check to see it the array is full
			return;
		if(rear == maxSize-1)         // deal with wraparound
			rear = -1;
		queArray[++rear] = j;         // increment rear and insert
		nItems++;                     // one more item
	}
	//--------------------------------------------------------------
	public RainFall remove()         // take item from front of queue
	{
		RainFall temp = queArray[front++]; // get value and incr front
		if(front == maxSize)           // deal with wraparound
			front = 0;
		nItems--;                      // one less item
		return temp;
	}
	//--------------------------------------------------------------
	public RainFall peekFront()      // peek at front of queue
	{
		return queArray[front];
	}
	//--------------------------------------------------------------
	public boolean isEmpty()    // true if queue is empty
	{
		return (nItems==0);
	}
	//--------------------------------------------------------------
	public boolean isFull()     // true if queue is full
	{
		return (nItems==maxSize);
	}
	//--------------------------------------------------------------
	public int size()           // number of items in queue
	{
		return nItems;
	}
	//--------------------------------------------------------------
}  // end class Queue
////////////////////////////////////////////////////////////////
class QueueApp
{
	public static void main(String[] args)
	{
		Queue theQueue = new Queue(6000);  // queue holds 5 items

		//read in the data from the file 
		//and create a RainFall object for each row of data
		//insert that RainFall object into the Queue
		//read in the first line of our file and do nothing with it

		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File("dailyRainfallMerced.csv"));
		} 
		catch (FileNotFoundException e) {

			System.out.println("Error opening the file dailyRainfallMerced.CSV");
			System.exit(40);
		}
		inputStream.nextLine();//read in the header

		while(inputStream.hasNext())  {
			
			String temp = inputStream.nextLine();//read in the next line
			String array[] = temp.split(",");
			double number = Double.parseDouble(array[1]);//convert to a double
			
			RainFall newRF = new RainFall(array[0], number);//make an object of type Rainfall
			theQueue.insert(newRF);
		}
		
		while( !theQueue.isEmpty() )    // remove and display
		{                            //    all items
			RainFall n = theQueue.remove();  // (40, 50, 60, 70, 80)
			System.out.println(n);
			System.out.print(" ");
		}


		}  // end main()
	}  // end class QueueApp
	////////////////////////////////////////////////////////////////