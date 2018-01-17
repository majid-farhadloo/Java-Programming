import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;
class DesireMusic{
	static String firstSong = "Does it have four legs?";
	static String leftSdieArtist = "Dog";
	static String rightSideAnimal = "Chicken";
	private static MusicNode[] allMusicInfo = new MusicNode[1300];
	public static void main(String args[]) throws IOException{
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File("MusicLibrary1.csv")); // read from the file
		} 
		catch (FileNotFoundException e) {

			System.out.println("Error opening the file MusicLibrary1.csv"); // print out when it is error to open the file
			System.exit(40);
		}
		inputStream.nextLine(); // read the header
		int index =0;
		while(inputStream.hasNextLine()) { // until we have inputstream.hasNextline() continue;
			String musicInfo = inputStream.nextLine(); // read the second line from the file
			String [] allInfo= musicInfo.split(","); // split the line by the comma
			MusicNode  musicArray = new MusicNode(allInfo);
			allMusicInfo[index++] = musicArray;
		}
		for(int j =0;j<allMusicInfo.length;j++){
			String artistName = allMusicInfo[j].getArtist();
			int i =0;
			String currentArtist = null;
			int firstTime = 0;
			while(currentArtist.equals(artistName) || firstTime==0 ){
				currentArtist = allMusicInfo[i].getArtist();
				String songs = allMusicInfo[i].getSongName();
				ArrayList<String> tracks = new ArrayList<String>();
				tracks.add(songs);
				System.out.println(tracks);
				i++;
				firstTime=0;
			}
		}
		/*JOptionPane.showMessageDialog(null, "Think of an Genre, I will try play the music of your taste");
		Node current;
		//GussingAnimalName theTree = new GussingAnimalName();
		current = root; 
		while(current.question != null){
			int response = JOptionPane.showConfirmDialog(null,current.question);
			System.out.println(response);
			if(response == 0){	//yes
				if(current.leftChild == null){
					//guess the question
					int res = JOptionPane.showConfirmDialog(null, " then, it is a " + current.leftAnimal);
					if(res == 0){// yes
						JOptionPane.showMessageDialog(null, "I guessed it");
						break;
					}
					else{ // No
						String secondAnimal = JOptionPane.showInputDialog("Enter value:", "what is your animal");
						String q = JOptionPane.showInputDialog("Write a question that differentiates your animal from the animal I guessed, it would be yes for your animal");
						Node newNode = new Node(q,secondAnimal,current.leftAnimal);
						current.leftChild = newNode;
						current = root;
					}
				}
				else{
					current = current.leftChild;
					System.out.println(current.leftAnimal + current.rightAnimal);
				}
			}
			else if(response == 1){
				if(current.rightChild == null){
					int res = JOptionPane.showConfirmDialog(null, "Then it is " + current.rightAnimal);
					if(res == 0){
						JOptionPane.showMessageDialog(null, "I guessed it");	
						break;
					}
					else{
						String secondAnimal = JOptionPane.showInputDialog("Enter value:", "what is your animal");
						String q = JOptionPane.showInputDialog("Write a question that differentiates your animal from the animal I guessed, it would be yes for your animal");
						MuiscNode newNodes = new MuiscNodeNode(q,secondAnimal,current.rightAnimal);
						current.rightChild = newNodes;
						current = root;
					}
				}
				else
					current = current.rightChild;
			}
		}  // end while*/
	}// end main() 
}  // end class TreeApp


