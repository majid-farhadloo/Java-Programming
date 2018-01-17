public class BubbleSort {
	/** Bubble sort method */
	public static void bubbleSort(double[] list) {
		//boolean needNextPass = true;

		/*for (int k = 1; k < list.length && needNextPass; k++) {
      // Array may be sorted and next pass not needed
      needNextPass = false;
      for (int i = 0; i < list.length - k; i++) {
        if (list[i] > list[i + 1]) {
          // Swap list[i] with list[i + 1]
          double temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;

          needNextPass = true; // Next pass still needed
        }
      }
    }
  }*/

		boolean swapped = false;
		int i = 1;	
		do { 
			swapped = false; 
			for(int j=0; j<list.length - i;j++){ 
				if(list[j]>list[j+1]){ 
					double temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp; 
					swapped = true; }
			}
			i++;
		}
		while(swapped && i<list.length);

	}

	/** A test method */
	public static void main(String[] args) {
		double[] list = { 2, 3, 2, 5, 6, 1, -2, 3, 14, 12 };
		bubbleSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}
}
