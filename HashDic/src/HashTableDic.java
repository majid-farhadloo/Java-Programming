// hash.java
// demonstrates hash table with linear probing
// to run this program: C:>java HashTableApp
import java.io.*;
import java.util.Scanner;
////////////////////////////////////////////////////////////////
class DataItem
{                                // (could have more data)
	private String word;               // data item (key)
	private String definition ; 

	//--------------------------------------------------------------
	public DataItem(String ii, String def)          // constructor
	{ word = ii;
	definition = def;}
	//--------------------------------------------------------------
	public String getKey()
	{ return word; }
	//--------------------------------------------------------------
}  // end class DataItem
////////////////////////////////////////////////////////////////
class HashTable
{
	private DataItem[] hashArray;    // array holds hash table
	private int arraySize;
	private DataItem nonItem;        // for deleted items
	// -------------------------------------------------------------
	public HashTable(int size)       // constructor
	{
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem("-1","-1");   // deleted item key is -1
	}
	// -------------------------------------------------------------
	public void displayTable()
	{
		System.out.print("Table: ");
		for(int j=0; j<arraySize; j++)
		{
			if(hashArray[j] != null)
				System.out.println(hashArray[j].getKey() + " ");
			else
				System.out.print("** ");
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
	public int hashFunc(String key)
	{
		return Math.abs(key.hashCode() % arraySize);       // hash function
	}
	// -------------------------------------------------------------
	public void insert(DataItem item) // insert a DataItem
	// (assumes table not full)
	{
		String key = item.getKey();      // extract key
		int hashVal = hashFunc(key);  // hash the key
		// until empty cell or -1,
		while(hashArray[hashVal] != null &&
				!hashArray[hashVal].getKey().equals("-1"))
		{
			++hashVal;                 // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
		}
		hashArray[hashVal] = item;    // insert item
	}  // end insert()
	// -------------------------------------------------------------
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
	// -------------------------------------------------------------
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
	// -------------------------------------------------------------
}  // end class HashTable
////////////////////////////////////////////////////////////////
class HashTableApp
{
	public static void main(String[] args) throws IOException
	{
		DataItem aDataItem;
		int aKey, size, n, keysPerCell;
		Scanner keyboard = new Scanner(System.in);
		// get sizes
		System.out.print("Enter size of hash table: ");
		size = getInt();
		System.out.print("Enter initial number of items: ");
		n = keyboard.nextInt();
		keysPerCell = 10;
		// make table
		HashTable theHashTable = new HashTable(size);
		Scanner inputStream = null;
		inputStream = new Scanner(new File("dictionary.txt"));
		while(inputStream.hasNextLine())        // insert data
		{
			// aKey = (int)(java.lang.Math.random() *
			//                               keysPerCell * size);
			String word = inputStream.next();
			String def = inputStream.nextLine();
			aDataItem = new DataItem(word,def);
			theHashTable.insert(aDataItem);
		}
		keyboard.nextLine();// get rid of the extra endline in our keyboard
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
				System.out.print("Enter definition to insert: ");
				String def = keyboard.nextLine();
				aDataItem = new DataItem(word,def);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("Enter word to delet: ");
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
