public class MergeTiming {

	public static void main(String[] args)  {

		int size = 100000000;
		int[] array = new int[size];
		int sum = 0;

		for(int j = 10000; j <100000000; j*=10) {

			for(int k =0; k < 5; k++)  {
				size = j;
				array = new int[size];

				//fill the array with size number of random numbers
				for(int i = 0; i < array.length; i++)
					//array[i] = (int)(Math.random()*size); //random
					//array[i] = i ; // in order
					array[i] = array.length -1;
			}
			long startTime = System.currentTimeMillis();
			QuickSortV2.quickSort(array);
			long endTime = System.currentTimeMillis();
			sum += (endTime - startTime);
			System.out.println("Execution time for n = " + size 
					+ " is " + (endTime - startTime) + " milliseconds");
			sum/=5;
		}
		System.out.println("Average Execution time for n = " + size 
				+ " is " + sum + " milliseconds");

	}

}
