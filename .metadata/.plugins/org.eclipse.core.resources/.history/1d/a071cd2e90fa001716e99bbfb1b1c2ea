 public class TestingSimpleSorts {

	public static void main(String[] args)  {

		int size = 1000000;
		double [] array = new double[size];

		for(int j = 1000; j <= 1000000; j*=10) {
			
			size = j;
			array = new double[size];

			//fill the array with size number of random numbers
			for(int i = 0; i < array.length; i++)
				array[i] = (int)(Math.random()*size); //random
				System.out.println(array);
				//array[i] = i;							//in order
				//array[i] = array.length - i;			//reverse order

			//for(int i = 0; i < array.length; i++)
				//System.out.println("array " + i + " " + array[i]);

			long startTime = System.currentTimeMillis();
			//BubbleSort.bubbleSort(array);
			//SelectionSort.selectionSort(array);
			//InsertionSort.insertionSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println("Execution time for n = " + size 
					+ " is " + (endTime - startTime) + " milliseconds");
		}

	}

}