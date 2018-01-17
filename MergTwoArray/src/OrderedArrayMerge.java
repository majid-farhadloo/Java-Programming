import java.util.Random;

class OrderedArrayMerge {

	public static void main(String[] args) {

		int maxSize = 1000000;
		OrdArray array1 = new OrdArray(maxSize);
		OrdArray array2 = new OrdArray(maxSize);

		Random rand = new Random();
		for(int i = 0; i < maxSize; i++)
			array1.insertBinary(rand.nextInt(25)+1);
		for(int i = 0; i < maxSize; i++)
			array2.insertBinary(rand.nextInt(25)+1);

		long startTime = System.currentTimeMillis();
		//long startTime = System.nanoTime();
		
		OrdArray array3 = array1.merge2(array1, array2);
		//OrdArray array3 = array1.merge1(array1, array2);
		
		long stopTime = System.currentTimeMillis();
		//long stopTime = System.nanoTime();
		
		//array1.display();
		//array2.display();
		//array3.display();
		
		System.out.println(stopTime - startTime);

	}  // end main()
}  // end class OrderedApp


