//hash.java
//demonstrates hash table with linear probing
//to run this program: C:>java HashTableApp
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
////////////////////////////////////////////////////////////////
class DataItem
{                                // (could have more data)
	private String word;               // data item (key)
	private String definition;
	public DataItem next;
	//--------------------------------------------------------------
	public DataItem(String ii, String def)          // constructor
	{ 
		word = ii; 
		definition = def;
	}
	//--------------------------------------------------------------
	public String getKey()
	{ return word; }
	//--------------------------------------------------------------
}  // end class DataItem
////////////////////////////////////////////////////////////////
class HashTable
{
	private DataItem[] hashArray;    // array holds hash table
	private static int arraySize;
	private DataItem nonItem;        // for deleted items
	//-------------------------------------------------------------
	public HashTable(int size)       // constructor
	{
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem("-1","-1");   // deleted item key is -1
	}
	//-------------------------------------------------------------
	public void displayTable()
	{
		DataItem current;
		System.out.print("Table: ");
		for(int j=0; j<arraySize; j++)
		{
			if(hashArray[j] != null) {
				current = hashArray[j];
				while(current != null) {
					System.out.print(current.getKey() + "    ");
					current = current.next;
				}
				System.out.println();
			}
			else
				System.out.println("** ");
		}
		//System.out.println("");
	}
	//-------------------------------------------------------------
	public static int hashFunc(String key)
	{
		int n = Math.abs(key.hashCode() % arraySize);
		System.out.println(n);
		return Math.abs(key.hashCode() % arraySize);       // hash function
	}
	//-------------------------------------------------------------
	public void insert(DataItem item) // insert a DataItem
	// (assumes table not full)
	{
		String key = item.getKey();      // extract key
		int hashVal = hashFunc(key);  // hash the key
		// until empty cell or -1,

		//LinkedList SepateChaining = new LinkedList();
		int z =1, q = 1;

		while(hashArray[hashVal] != null &&
				!hashArray[hashVal].getKey().equals("-1"))
		{ 
			DataItem current = hashArray[hashVal];
			while(current.next != null) {
				current = current.next;	
			}
			current.next = item;
			return;
			/*
			hashVal += q;                 // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
			z++;
			q=(int) Math.pow(z,2);
			 */
			//System.out.println(z);
		}
		hashArray[hashVal] = item;    // insert item
	}  // end insert()
	//-------------------------------------------------------------
	/*public static void insertSeprateChaining (DataItem item) // insert a DataItem
	// (assumes table not full)
	{
		String key = item.getKey();      // extract key
		int hashVal = hashFunc(key);  // hash the key
		// until empty cell or -1,
		//LinkedList SepateChaining = new LinkedList();
		while(hashArray[hashVal] != null &&
				!hashArray[hashVal].getKey().equals("-1"))
		{ 
			DataItem current = hashArray[hashVal];
			while(current.next != null) {
				current = current.next;	
			}
			current.next = item;
			return;
		}
		hashArray[hashVal] = item;    // insert item
	}  // end insert()*/
	//-------------------------------------------------------------
	public DataItem delete(String key)  // delete a DataItem
	{
		int hashVal = hashFunc(key);  // hash the key

		while(hashArray[hashVal] != null)  // until empty cell,
		{                               // found the key?
			if(hashArray[hashVal].getKey().equals(key))
			{
				DataItem temp = hashArray[hashVal]; // save item
				hashArray[hashVal] = nonItem;       // delete item
				return temp;                        // return item
			}
			++hashVal;                 // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
		}
		return null;                  // can't find item
	}  // end delete()
	//-------------------------------------------------------------
	public DataItem find(String key)    // find item with key
	{
		int hashVal = hashFunc(key);  // hash the key

		while(hashArray[hashVal] != null)  // until empty cell,
		{                               // found the key?
			if(hashArray[hashVal].getKey().equals(key))
				return hashArray[hashVal];   // yes, return item
			++hashVal;                 // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
		}
		return null;                  // can't find item
	}
	//-------------------------------------------------------------
}  // end class HashTable
////////////////////////////////////////////////////////////////
class HashTableDic
{
	public static void main(String[] args)
	{
		DataItem aDataItem;
		int aKey, size, n, keysPerCell;
		Scanner keyboard = new Scanner(System.in);
		// get sizes
		System.out.print("Enter size of hash table: ");
		size = keyboard.nextInt();
		System.out.print("Enter initial number of items: ");
		n = keyboard.nextInt();
		keysPerCell = 10;
		// make table
		HashTable theHashTable = new HashTable(size);

		Scanner inputStream = null;

		try {
			inputStream = new Scanner(new File("dictionary.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//for(int j=0; j<n; j++)        // insert data
		while(inputStream.hasNextLine())
		{
			//aKey = (int)(java.lang.Math.random() *
			//keysPerCell * size);
			String word = inputStream.next();
			String def = inputStream.nextLine();
			aDataItem = new DataItem(word, def);
			theHashTable.insert(aDataItem);
		}

		keyboard.nextLine();//get rid of the extra end of line character left 
		//on the keyboard buffer
		while(true)                   // interact with user
		{
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, delete, or find: ");
			char choice = keyboard.nextLine().charAt(0);
			switch(choice)
			{
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("Enter word to insert: ");
				String word = keyboard.nextLine();
				System.out.print("Enter definition for this word: ");
				String def = keyboard.nextLine();
				aDataItem = new DataItem(word, def);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("Enter the word to delete: ");
				word = keyboard.nextLine();
				theHashTable.delete(word);
				break;
			case 'f':
				System.out.print("Enter word to find: ");
				word = keyboard.nextLine();
				aDataItem = theHashTable.find(word);
				if(aDataItem != null)
				{
					System.out.println("Found " + word);
				}
				else
					System.out.println("Could not find " + word);
				break;
			default:
				System.out.print("Invalid entry\n");
			}  // end switch
		}  // end while
	}  // end main()
	//--------------------------------------------------------------
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	//--------------------------------------------------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
	//--------------------------------------------------------------
}  // end class HashTableApp
////////////////////////////////////////////////////////////////
