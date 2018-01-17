public class MergeSort {
	/** The method for sorting the numbers */
	public static void mergeSort(int[] list) {
		if (list.length > 1) {
			// Merge sort the first half
			int[] firstHalf = new int[list.length / 2 +1];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2 +1);
			System.out.print("array 1 is ");
			for(int i = 0; i < firstHalf.length; i++)
				System.out.print(firstHalf[i] + " ");
			System.out.println();
			for(int i =0; i<list.length;i++){
				System.out.println(list[i] + " ");
			}
			mergeSort(firstHalf);
			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2 - 1;
			for(int i =0; i<list.length;i++){
				System.out.println(list[i] + " ");
			}
			System.out.println();
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2 +1,
					secondHalf, 0, secondHalfLength);
			System.out.print("array 2 is ");
			for(int i = 0; i < secondHalf.length; i++)
				System.out.print(secondHalf[i] + " ");
			System.out.println();
			mergeSort(secondHalf); 

			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
			System.out.println("merged list ");
			for(int i = 0; i < list.length; i++)
				System.out.print(list[i] + " ");
			System.out.println();
		}
	}

	/** Merge two sorted lists */
	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while (current1 < list1.length)
			temp[current3++] = list1[current1++];

		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}

	/** A test method */
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		mergeSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}
	public static int getTime(int array[]){
		//int sum=0;
		//for(int i =0; i< executionTime; i++){
			long startTime = System.currentTimeMillis();
			MergeSortV2.mergeSort(array);
			long endTime = System.currentTimeMillis();
			int difference = (int) (endTime - startTime);
			//sum+=difference;
		//}
		return difference;
	}
}