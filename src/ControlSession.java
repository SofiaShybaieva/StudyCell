import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class ControlSession extends JFrame {
	
	Question questions[] = new Question[2];
	int currentQuestion = 0;
	int maxQuestions = 2;
	JLabel questionLabel;
	JRadioButton y[] = new JRadioButton [3];
	int answers[] = new int[2];
	ButtonGroup buttonGroup;
	
	private void prepareGUI(){
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
		this.setSize(1024, 600);
		this.setTitle("Тест");
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new BorderLayout());		
		panel.setPreferredSize(new Dimension(620, 100));

		JLabel label = new JLabel();
		label.setText(String.format("<html><body><h1>%s</h1></body></html>", questions[0].text));
		panel.add(label, BorderLayout.NORTH);
		this.questionLabel = label;
		
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setPreferredSize(new Dimension(620, 100));

		
		buttonGroup = new ButtonGroup();
		
		for (int i=0; i<3; i++) {
			this.y[i] = new JRadioButton(questions[0].responseOptions[i]);
			buttonGroup.add(this.y[i]);
		}
		
		panel2.add(this.y[0], BorderLayout.NORTH);
		panel2.add(this.y[1], BorderLayout.CENTER);
		panel2.add(this.y[2], BorderLayout.SOUTH);
		
		
		JPanel panel3 = new JPanel(new BorderLayout());
		panel3.setPreferredSize(new Dimension(620, 30));
		
		Button btnBack=new Button("  Back  ");
		Button btnForward=new Button("  Forward  ");
		Button btnFinish=new Button("  Finish  ");
		
		btnForward.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				forward ();
			}
		});
		
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				back ();
			}
		});

		btnFinish.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				finish ();
			}
		});
		
		panel3.add(btnBack,BorderLayout.WEST); 
		panel3.add(btnForward,BorderLayout.EAST);
		panel3.add(btnFinish,BorderLayout.CENTER);
		
		this.add(panel);
		this.add(panel2);
		this.add(panel3);

		this.setVisible(true);
	}
	
	private void prepareQuestions() {
		Question question = new Question ("Question1", new String[]{"q","r","t"}, 3);
		questions[0] = question;
		
		question = new Question ("Question2", new String[]{"a","s","d"}, 2);
		questions[1] = question;
	
		// initialize answers with empty responses
		for (int i=0; i<this.maxQuestions; i++) answers[i] = 0;
	}
	
	
	public void  start(){
		prepareQuestions();
		prepareGUI();
		
	}
	public void  finish() {
		// check the responses with the right answers
		int wrongAnswers = 0;
		for (int i=0; i<this.maxQuestions; i++) {
			if (this.answers[i] != this.questions[i].correctAnswer) {
				wrongAnswers ++;
			}
		}
		String s;
		if (wrongAnswers > 0) {
			s = String.format("You've got %d wrong answers", wrongAnswers);
		}
		else {
			// congratulate the user
			s = "Fantastic! All answers correct.";
		}
		JOptionPane.showMessageDialog(null, s, "StudyCell", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void  cancel() {
		
	}
	private void  back() {
		
		// store new response in the answers
		this.answers[this.currentQuestion] = this.getResponseNumber();
		
		// limit back clicks with the first question
		if (this.currentQuestion>0)
			this.currentQuestion --;
		
		this.updateQuestion();
	}
	private void  forward() {
		
		// store new response in the answers
		this.answers[this.currentQuestion] = this.getResponseNumber();
		
		// limit forward clicks with the last question
		if (this.currentQuestion<this.maxQuestions-1)
			this.currentQuestion ++;
		
		this.updateQuestion();
		
	}
	
	
	// updates the screen with the current question text, response options, and the answer 
	private void updateQuestion () {
		
		this.questionLabel.setText(String.format("<html><body><h1>%s</h1></body></html>", this.questions[this.currentQuestion].text));
		
		this.buttonGroup.clearSelection();
		for (int i=0; i<3; i++) {
			this.y[i].setText(this.questions[this.currentQuestion].responseOptions[i]);
			this.y[i].setSelected((i+1) == this.answers[this.currentQuestion]);
		}
	}
	
	// returns the number of the selected radio button, i.e. the response number
	// returns zero when no selection was made
	private int getResponseNumber() {
		for (int i=0; i<3; i++) {
			if (this.y[i].isSelected()) return i+1;
		}
		return 0;
		
	}

}
