//Joseph Newman
//CPSC 39
//Merge


import java.util.Random;


class OrdArray {

	private final long[] a;                 // ref to array a
	private int nElems;               // number of data items
	//-----------------------------------------------------------

	public OrdArray(int max) // constructor
	{
		a = new long[max];             // create array
		nElems = 0;
	}

	//-----------------------------------------------------------
	public int size() {
		return nElems;
	}

	//-----------------------------------------------------------
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;

		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == searchKey) {
				return curIn;              // found it
			} else if (lowerBound > upperBound) {
				return nElems;             // can't find it
			} else {// divide range 
				if (a[curIn] < searchKey) {
					lowerBound = curIn + 1; // it's in upper half
				} else {
					upperBound = curIn - 1; // it's in lower half
				}
			}  // end else divide range
		}  // end while
	}  // end find()
	//-----------------------------------------------------------

	public void insertBinary(long value) // put element into array
	{
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn = 0;
		int j = 0;
		if (nElems == 0) {
			a[j] = value;
			nElems++;
		} else {
			while (lowerBound <= upperBound) {
				curIn = (lowerBound + upperBound) / 2;
				if (a[curIn] < value) {
					lowerBound = curIn + 1;
				} else if (a[curIn] > value) {
					upperBound = curIn - 1;
				} else if (a[curIn] == value) {
					break;
				}
			}
			if (a[curIn] <= value) {
				j = curIn + 1;
			} else {
				j = curIn;
			}

			for (int k = nElems; k > j; k--) // move bigger ones up
			{
				a[k] = a[k - 1];
			}
			a[j] = value;				 //insert it
			nElems++;                   // increment size
		}
	}
	public void insertLinear(long value)    // put element into array
	{
		int j;
		for(j=0; j<nElems; j++)        // find where it goes
			if(a[j] > value)            // (linear search)
				break;
		for(int k=nElems; k>j; k--)    // move bigger ones up
			a[k] = a[k-1];
		a[j] = value;                  // insert it
		nElems++;                      // increment size
	}  // end insert()
	//-----------------------------------------------------------
	public boolean delete(long value) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;
		int j = 0;
		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == value) {
				j = curIn;              // found it
				break;
			} else if (lowerBound > upperBound) {
				j = nElems;             // can't find it
				break;
			} else // divide range
			{
				if (a[curIn] < value) {
					lowerBound = curIn + 1; // it's in upper half
				} else {
					upperBound = curIn - 1; // it's in lower half
				}
			}  // end else divide range
		}  // end while

		if (j == nElems) // can't find it
		{
			return false;
		} else // found it
		{
			for (int k = j; k < nElems; k++) // move bigger ones down
			{
				a[k] = a[k + 1];
			}
			nElems--;                   // decrement size
			return true;
		}
	}  // end delete()
	//-----------------------------------------------------------

	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
		{
			System.out.print(a[j] + " ");  // display it
		}
		System.out.println("");
	}
	public OrdArray merge1(OrdArray array1, OrdArray array2)  {


		OrdArray arrayFinal = new OrdArray(array1.size() + array2.size()); 

		for(int i = 0; i<array1.size(); i++){
			arrayFinal.insertBinary(array1.a[i]); 
		}
		for(int i = 0; i<array2.size(); i++){
			arrayFinal.insertBinary(array2.a[i]); 
		}

		return arrayFinal;
	}

	public OrdArray merge2(OrdArray array1, OrdArray array2) {

		OrdArray array3 = new OrdArray(array1.size() + array2.size());
		
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		
		while( index1 < array1.size() && index2 < array2.size() ){

			if( array1.a[index1] == array2.a[index2] ){
				array3.a[index3] = array1.a[index1];
				array3.nElems++;
				index3++;
				index1++;
				
				array3.a[index3] = array2.a[index2];
				array3.nElems++;
				index3++;
				index2++;
			}

			else if (array1.a[index1] < array2.a[index2]){
				array3.a[index3] = array1.a[index1];
				array3.nElems++;
				index3++;
				index1++;
			}
			else if (array1.a[index1] > array2.a[index2]){
				array3.a[index3] = array2.a[index2];
				array3.nElems++;
				index3++;
				index2++;
			}
		}

		while( index1 < array1.size() )
		{
			array3.a[index3] = array1.a[index1];
			index1++;
			index3++;
			array3.nElems++;
		}


		while( index2 < array2.size() )
		{
			array3.a[index3] = array2.a[index2];
			index2++;
			index3++;
			array3.nElems++;
		}

		return array3;
	}
	//-----------------------------------------------------------
}  // end class OrdArray
////////////////////////////////////////////////////////////////

class OrderedArrayMerge {

	public static void main(String[] args) {

		int maxSize = 1000;
		OrdArray array1 = new OrdArray(maxSize);
		OrdArray array2 = new OrdArray(maxSize);

		Random rand = new Random();
		for(int i = 0; i < maxSize; i++)
			array1.insertBinary(rand.nextInt(25)+1);
		for(int i = 0; i < maxSize; i++)
			array2.insertBinary(rand.nextInt(25)+1);

		//long startTime = System.currentTimeMillis();
		long startTime = System.nanoTime();
		
		OrdArray array3 = array1.merge2(array1, array2);
		//OrdArray array3 = array1.merge1(array1, array2);
		
		//long stopTime = System.currentTimeMillis();
		long stopTime = System.nanoTime();
		
		array1.display();
		array2.display();
		array3.display();
		
		System.out.println(stopTime - startTime);

	}  // end main()
}  // end class OrderedApp



