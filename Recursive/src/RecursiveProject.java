
public class RecursiveProject {
	public static int countDigit(int number){
		if(number==0){
			return number;
		}
		int sum = 0;
		int digit = number%10;
		number/=10;
		sum = digit + countDigit(number);
		return sum;
	}
	public static int knapsack(int[] array, int target){
		if(target == 0){
			return 0;
		}
		int i = 0;
		int sum = 0;
		int []set = new int[array.length -1];
		int []set1 = new int[array.length -1];
		while(array[i]<target || target==0){
			int element = array[i];
			set1[i] = array[i];
			target-=element;
			i++;
		}
		if(target==0){
			System.arraycopy(array,0, set,0,i-1);
			for(int j=0;j<set.length;j++)
				System.out.print(set[j] + " ");
			System.out.println();
			return set1[i];
		}
		System.arraycopy(array,i++, set,0,set.length);
		return knapsack(set, target-sum);	
	}

	public static void main(String []args){
		//System.out.println(countDigit(1775910));
		int []list = {4,5,7,3,1,9,11,8};
		System.out.println(knapsack(list, 12));
	}
	
}



