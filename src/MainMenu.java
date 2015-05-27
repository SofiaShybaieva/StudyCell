
import java.awt.*;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MainMenu extends JFrame{
	private JFrame mainFrame;
	
	private void prepareGUI(){
	      
			this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			this.setLayout(null);
			this.setSize(350, 400);
			this.setTitle("StudyCell");
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			
			int x = 75;
			int y = 20;
			int w = 200;
			int h = 60;
			Button btnStudy=new Button("Обучение");  
			btnStudy.setBounds(x,y,w,h);  
			btnStudy.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					startLearningSession ();
				}
			});
			
			add(btnStudy);

			Button btnControl=new Button("Тестирование");  
			btnControl.setBounds(x,y+h*2,w,h);// setting button position  
			btnControl.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					System.out.println("Тестирование");
				}
			});
			add(btnControl);  

			Button btnAbout=new Button("О программе");  
			btnAbout.setBounds(x,y+h*4,w,h);// setting button position  
			btnAbout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					System.out.println("О программе");
					about();
				}
			});
			
			add(btnAbout); 

	}
	
	protected void about() {
		 JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);
	
		dialog.setSize(400, 300);
		dialog.setLayout(new FlowLayout());
		dialog.setLocationRelativeTo(null);
	    JLabel label1 = new JLabel();
		    
	    label1.setText("<html><h1>О программе</h1>");
	   
	    dialog.getContentPane().add(label1);
	   
	    dialog.setVisible(true);
	}

	protected void startLearningSession() {
		LearningSession session = new LearningSession ();
		session.start();
		
	}

	MainMenu () {

		
		
		prepareGUI();
		

		
	}
	
	public static void main (String args[]) {
		
			
		 	System.out.println("StudyCell");
            MainMenu m = new MainMenu();
		 
		
		
	}

	File file;
	
	public void  onLearning(){
		
	}
	public void  onControl(){
	
	}
	public void  onAbout(){
		
	}
	
	

	
}
