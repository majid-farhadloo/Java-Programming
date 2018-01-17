import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//linkList2.java
//demonstrates linked list
//to run this program: C>java LinkList2App
////////////////////////////////////////////////////////////////
class Link
{
	public Question question;
	public Link next;              // next link in list
	//-------------------------------------------------------------
	public Link(Question q) // constructor
	{
		question = q;
	}
	//-------------------------------------------------------------
	public void displayLink()      // display ourself
	{
		System.out.print(question);
	}
}  // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
	private Link first;            // ref to first link on list

	//-------------------------------------------------------------
	public LinkList()              // constructor
	{
		first = null;               // no links on list yet
	}
	//-------------------------------------------------------------
	public void insertFirst(Question q)
	{                           // make new link
		Link newLink = new Link(q);
		newLink.next = first;       // it points to old first link
		first = newLink;            // now first points to this
	}
	//-------------------------------------------------------------
	public Link find(String key)      // find link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // start at 'first'
		while(!current.question.getQuestion().equals(key))       // while no match,
		{
			if(current.next == null)        // if end of list,
				return null;                 // didn't find it
			else                            // not end of list,
				current = current.next;      // go to next link
		}
		return current;                    // found it
	}
	//-------------------------------------------------------------
	public Link delete(String key)    // delete link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // search for link
		Link previous = first;
		while(!current.question.getQuestion().equals(key))
		{
			if(current.next == null)
				return null;                 // didn't find it
			else
			{
				previous = current;          // go to next link
				current = current.next;
			}
		}                               // found it
		if(current == first)               // if first link,
			first = first.next;             //    change first
		else                               // otherwise,
			previous.next = current.next;   //    bypass it
		return current;
	}
	//-------------------------------------------------------------
	public void displayList()      // display the list
	{
		//System.out.print("List (first-->last): ");
		Link current = first;       // start at beginning of list
		while(current != null)      // until end of list,
		{
			current.displayLink();   // print data
			current = current.next;  // move to next link
		}
		System.out.println("");
	}

	//-------------------------------------------------------------
	public Link getFirst()      // display the list
	{
		return first;
	}
	//-------------------------------------------------------------
}  // end class LinkList
////////////////////////////////////////////////////////////////
class QuestionTest
{
	public static void main(String[] args){
		LinkList answerAndQuestion = new LinkList();
		//ArrayList<String> answers = new ArrayList<String>();
		String[] answers = new String[4];
		Question question;
		//LinkList question = new LinkList();  // make list
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File("QuestionsAndAnswers_withAnswersMarked.txt"));
		} 
		catch (FileNotFoundException e) {

			System.out.println("Error opening the file QuestionsAndAnswers_withAnswersMarked.txt");
			System.exit(41);
		}
		int rightAnswer = 0;
		int wrongAnswer = 0;
		int count = 0;
		String q = null;
		while(inputStream.hasNext()){
			q = inputStream.nextLine();
			String newAnswers = null;
			for(int i=0;i<4;i++){
				newAnswers = inputStream.nextLine();
				//answers.add(newAnswers);
				answers[i] = newAnswers;
			}
			question = new Question(q, answers);
			answerAndQuestion.insertFirst(question);
		}
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		Link current = answerAndQuestion.getFirst();     // start at beginning of list
		while(current != null)      // until end of list,
		{
			current.displayLink();   // print data
			System.out.println("Enter a number as your answer between 1 to 4: ");
			int userAnswer = reader.nextInt();
			//Link user  = testQuestion.find(qUser);
			if(current.question.getRightAnswer() == userAnswer){
				rightAnswer++;
			}
			else
				wrongAnswer++;

			count++;
			current = current.next;  // move to next link
		}
		System.out.println("");	
		System.out.println(" You have " + rightAnswer+ " right answer(s)" );
		System.out.println(" You have " + wrongAnswer + " wrong answer(s)" );
		System.out.println(" Your score is : " + (count-wrongAnswer)/(count*1.0));


		//answerAndQuestion.displayList();
		/*LinkList testQuestion = new LinkList();
		ArrayList<String> ansWOMark = new ArrayList<String>();
		Question realTest;
		Scanner input = null;
		try {
			input = new Scanner(new File("QuestionsAndAnswers(1).txt"));
		} 
		catch (FileNotFoundException e) {

			System.out.println("Error opening the file QuestionsAndAnswers(1).txt");
			System.exit(40);
		}
		//arrayOfAnswers = null;
		//String[] arrayOfQuestions = null;
		String qUser = null;
		//int z = 0;
		while(input.hasNext()){
			//String questions = question.insertFirst((inputStream.nextLine()));
			qUser = input.nextLine();
			//System.out.println(q);
			String ans = null;
			//j++;
			for(int i=0;i<4;i++){
				ans = input.nextLine();
				ansWOMark.add(ans);
				//System.out.println(answers);
				//System.out.println(answers[j]);
				//j++;
			}
			//System.out.println(j);
			realTest = new Question(qUser, ansWOMark);
			testQuestion.insertFirst(realTest);
			testQuestion.displayList();
			//Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.println("Enter a number as your answer between 1 to 4: ");
			int userAnswer = reader.nextInt();
			Link user  = testQuestion.find(qUser);
			if(user.equals(qUser)){
				if(user.question.getRightAnswer() == userAnswer){
					rightAnswer++;
				}
				else
					wrongAnswer++;
			}
			count++;
		}
		System.out.println(" You have " + rightAnswer+ " right answer(s)" );
		System.out.println(" You have " + wrongAnswer + " wrong answer(s)" );
		System.out.println(" Your score is : " + (count-wrongAnswer)/count);
	}*/

	}
}
//answerAndQuestion.displayList();    


