
import java.awt.*;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
			btnStudy.setBackground(new java.awt.Color(254,232,153));
			
			add(btnStudy);

			Button btnControl=new Button("Тестирование");  
			btnControl.setBounds(x,y+h*2,w,h);// setting button position  
			btnControl.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					System.out.println("Тестирование");
					startControlSession();
				}
			});
			btnControl.setBackground(new java.awt.Color(194,252,167));
			add(btnControl);  

			Button btnAbout=new Button("О программе");  
			btnAbout.setBounds(x,y+h*4,w,h);// setting button position  
			btnAbout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					System.out.println("О программе");
					about();
				}
			});
			btnAbout.setBackground(new java.awt.Color(199,237,252));
			add(btnAbout); 

	}
	
	protected void about() {
		   JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);
		 
		  dialog.setSize(640, 480);
		  dialog.setLayout(new FlowLayout());
		  dialog.setLocationRelativeTo(null);
		    
		   JLabel label = new JLabel(new ImageIcon("images.jpg"));

	        label.setLayout(new FlowLayout());
		      label.setText("<html><body><h1>О программе</h1><p>Цитология – наука об изучении живых клеток, является одной из базовых в биологии, а изучение строения клетки – одна из важнейших тем из курса школьной биологии. StudyCell – программа,   разработанная для изучения компонентов животной клетки.При запуске программы перед вами появится окно с тремя кнопками: Обучение, Тестирование, О программе. Нажав на последнюю, вы сможете ознакомиться с инструкцией пользователя.При нажатии кнопки «Обучение» перед вами появится изображение животной клетки. Если вы наведете мышкой на какой-либо компонент клетки (органоид), вверху на экране появится название этого органоида. Если вы хотите узнать подробную информацию о его строении и функциях, кликните на нём. Перед вами появится окно с подробной информацией. Изучив таким образом название, строение, функции органоидов, то как они выглядят и где расположены, вы можете перейти в режим «Тестирование» и проверить свои знания.В режиме тестирование вы проходите тест из 10 вопросов с 3 вариантами ответов, лишь один из которых правильный. После прохождения теста вы увидите ваш результат, а именно количество правильных ответов.Поработав с программой StudyCell, вы легко сможете изучить одну из самых важных и интересных тем в биологии.</p></body></html>");

		         JPanel panel = new JPanel(new BorderLayout());
		         panel.add(label, BorderLayout.NORTH);
		         panel.setPreferredSize(new Dimension(620, 460));
		         dialog.add(panel);
		         dialog.setVisible(true);
		 }

	protected void startLearningSession() {
		LearningSession session = new LearningSession ();
		session.start();
		
	}
	
	protected void startControlSession() {
		ControlSession session = new ControlSession ();
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
