import java.util.ArrayList;

public class WordTest {
	public static void main(String[] args){
		String s = "majidfarhadlood";
		String t = "farhadloomajidd";
		//System.out.println(phrase(s,t));
		array();
	}
	public static String phrase (String s, String t){
		if(t.length()==s.length()){
			for(int i=0;i<s.length();i++){
				char sChar = s.charAt(i);
				for(int j=0;j<t.length();j++){
					char tChar =  t.charAt(j);
					if(sChar == tChar){
						//char newChar = '*';
						t = t.substring(0, j) + t.substring(j+1);
						//System.out.print(""+ sChar);
						//System.out.print(""+ tChar);
						//System.out.println();
					}
				}
			}
		}
		if(t.isEmpty())
			return "they are equal";
		return "they are not equal";
	}
	public static void array(){
		int newArray[] = new int[1000];
		for(int i=0;i<1000;i++){
			newArray[i]=i+1;
		}
		//System.out.println(newArray);
		int n=1000;
		//int j=1000;
		//ArrayList<Integer> finalArray = new ArrayList<>();
		int finalArray[] = new int[500];
		while(n>=2){
		int j=0;
		for(int z=0;z<n;z++){
			if(z%2==0){
				finalArray[j] = newArray[z];
				j++;
			}
		}
		System.arraycopy(finalArray, 0, newArray, 0,1000);
		n/=2;
		}
		for(int z=0;z<finalArray.length;z++){
			System.out.print(" " +finalArray[z]);
		}
		
	}
	//n/=2;
}
//System.out.println();
//System.out.println(finalArray.size());


