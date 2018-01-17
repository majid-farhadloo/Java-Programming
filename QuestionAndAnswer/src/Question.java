import java.util.ArrayList;

public class Question {

	//instance variables
	private String question;
	private ArrayList<String> answers;
	//private String[] answers;
	private int rightAnswer;

	public Question(String question, ArrayList<String> answers ) {
		super();
		this.question = question;
		this.answers = answers;
		for(int i = 0 ; i <4; i++) {
			if(answers.get(i).charAt(0) == '*') {
				rightAnswer = i;
				answers.get(i).replace(answers.get(i).substring(0), answers.get(i).substring(1)) ;
				//answers.get(0).(answers.get(i).substring(1)); 
			}
		}

}

public Question(String question, String[] ans ) {
	super();
	this.question = question;
	answers = new ArrayList<String>();
	//this.answers = answers;
	for(int i = 0 ; i < 4; i++) {
		if(ans[i].charAt(0) == '*') {
			rightAnswer = i;
			ans[i] = ans[i].substring(1) ;
		}
		answers.add(ans[i]);
	}

}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public ArrayList<String> getAnswers() {
	return answers;
}

public void setAnswers(ArrayList<String> answers) {
	this.answers = answers;
}
public int getRightAnswer() {
	return rightAnswer;
}

public void setRightAnswer(int rightAnswer) {
	this.rightAnswer = rightAnswer;
}

@Override
public String toString() {
	String s = question + "\n";
	for(int i = 0; i <4; i++) { //answers.length
		s += "   " + (char)('1' + i) + ". " + answers.get(i) + "\n";
	}
	return s;
}



}