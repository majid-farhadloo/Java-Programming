import java.util.ArrayList;

public class TestingSearching {

	public static int linearSearch(int[] array, int numOfElements, int key)  {

		int index = 0;
		int countSteps = 0;
		while(index < numOfElements)  {
			countSteps++;
			if(array[index] == key) {
				System.out.println("The number of steps for linear search is " + countSteps);
				return index;
			}
			index++;
		}
		System.out.println("The number of steps for linear search is " + countSteps);
		return -1;
	}

	public static int binarySearch(int[] array, int numOfElements, int key)  {

		int low = 0;
		int high = numOfElements - 1;
		int countSteps = 0;

		while (high >= low) {
			countSteps++;
			int mid = (low + high) / 2;
			if (key < array[mid])
				high = mid - 1;
			else if (key == array[mid]) {
				System.out.println("The number of steps for binary search is " + countSteps);
				return mid;
			}
			else
				low = mid + 1;
			System.out.println(low);
			System.out.println(high);
		}
		System.out.println("The number of steps for binary search is " + countSteps);
		return -1; // Not found 
	}


	public static void main(String[] args) {

		int [] numArray = new int[] {1,4,6,8,10,15,20};
		//int SIZE = 64;
		int keyWeAreSearchingFor = 52;
		
		//create a test array - in order
		/*int[] numArray = new int[SIZE];
		for(int i = 0; i < SIZE; i++)
			numArray[i] = i;
			int i =0;
			int num =0;
			//Empty String
			int location = 0;
			int [] primeNumbers = new int [SIZE];

			for (i = 2; i <= 312; i++)         
			{ 		  	  
				int counter=0; 	  
				for(num =i; num>=1; num--)
				{
					if(i%num==0)
					{
						counter = counter + 1;
					}
				}
				if (counter ==2)
				{
					
					//Appended the Prime number to the String
					primeNumbers[location] =i;
					location++;
					System.out.println(i);
				}	
			}*/
			//linearSearch(numArray, SIZE, keyWeAreSearchingFor);
			binarySearch(numArray,7,11);

		}

	}