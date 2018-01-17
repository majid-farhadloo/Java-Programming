import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;
class GussingAnimalName{
	static String firstQuestion = "Does it have four legs?";
	static String leftSdieAnimal = "Dog";
	static String rightSideAnimal = "Chicken";
	static Node root = new Node(firstQuestion,leftSdieAnimal,rightSideAnimal);
	public static void main(String args[]) throws IOException{
		JOptionPane.showMessageDialog(null, "Think of an animal, I will try to guess it, answer yes or no");
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
						String q = JOptionPane.showInputDialog("Write a question that differentiates"
								+ " your animal from the animal I guessed, it would be yes for your animal");
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
						String q = JOptionPane.showInputDialog("Write a question that differentiates"
								+ " your animal from the animal I guessed, it would be yes for your animal");
						Node newNodes = new Node(q,secondAnimal,current.rightAnimal);
						current.rightChild = newNodes;
						current = root;
					}
				}
				else
					current = current.rightChild;
			}
		}  // end while
	}// end main()  
}  // end class TreeApp


