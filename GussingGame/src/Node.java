public class Node{
	public String question;	
	public String leftAnimal;	
	//public String compData;			// computer data
	public String rightAnimal;		
	public Node leftChild;         // this node's left child
	public Node rightChild; 
	public Node(String q, String lHs, String rHs){
		this.question = q;
		this.leftAnimal =lHs ;
		this.rightAnimal = rHs;
	}
}