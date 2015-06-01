
public class Question {
	
	String text;
	String responseOptions[] = new String[3];
	int correctAnswer;
	

	public Question (String text, String[] responseOptions, int correctAnswer) {
		this.text = text;
		for (int i=0; i<3; i++) this.responseOptions[i] = responseOptions[i];
		this.correctAnswer = correctAnswer;
	}
	
	public void  show(){
		
	}

}
