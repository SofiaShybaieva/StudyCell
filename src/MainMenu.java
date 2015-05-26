
import java.awt.*;
import java.io.File;

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
				}
			});
			
			add(btnAbout); 

	}
	
	protected void startLearningSession() {
		LearningSession session = new LearningSession ();
		session.start();
		
	}

	MainMenu () {

		
		
		prepareGUI();
		
//		JPanel panel = new JPanel();
//		panel.setLayout(new FlowLayout());
//		JLabel label = new JLabel("StudyCell");
//		panel.add(label);
//		add(panel);
//		setSize(300, 300);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
//		addWindowListener(new WindowAdapter() {
//	         public void windowClosing(WindowEvent windowEvent){
//	            System.exit(0);
//	         }        
//	      });    

		//		Button b=new Button("click me");  
//		b.setBounds(30,100,80,30);// setting button position  
//		  
//		add(b);//adding button into frame  
//		setSize(300,300);//frame size 300 width and 300 height  
//		setLayout(null);//no layout manager  
//		pack();
//		setVisible(true);//now frame will be visible, by default not visible 
		
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
