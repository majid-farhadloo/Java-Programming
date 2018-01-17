public class testing {
	public static void main(String args[]) {
		int size = 100000000;
		int sum1= 0;
		int sum2= 0;
		int sum3 = 0;
		int array1[] = new int[size];
		int array2[] = new int[size];
		int array3[] = new int[size];
		int i = 0;
		for (int j = 10000; j < 100000000; j*=10) {
			size = j;
			array1 = new int[size];
			array2 = new int[size];
			array3 = new int[size];
			//for (i = 0; i <=5; i++) {
				for (int k = 0; k < (array1.length & array2.length & array3.length);k++) {
					array1[k] = (int )(Math.random() * size + 1);
					array2[k] = k ; // in order 
					array3[k] = array3.length - k ; //reverse order
				}
				average = MergeSort.getTimeAverage(array2,5);
			//}
			
			/*int difference2 = MergeSort.getTime(array2);
			int difference3 = MergeSort.getTime(array3);
			sum2+=difference2;
			sum3+=difference3;*/
			//sum+=difference;
			
		}
		
		//int average = sum/i;
		//int average2 = sum2/i;
		//int average3 = sum3/i;*/
		System.out.println("Average Execution time for n = " + size 
				+ " Random items is " + (average) + " milliseconds");
		/*System.out.println("Average Execution time for n = " + size 
				+ " Order items is " + (average2) + " milliseconds");
		System.out.println("Average Execution time for n = " + size 
				+ " Unordered is " + (average3) + " milliseconds");*/

	}
}
