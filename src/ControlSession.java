import javax.swing.JFrame;


public class ControlSession extends JFrame {
	
	Question questions;
	
	private void prepareGUI(){
		this.setLayout(null);
		this.setSize(1024, 768);
		this.setTitle("Тест");
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	public void  start(){
		
		prepareGUI();
		
	}
	public void  finish(){
		
	}
	public void  cancel(){
		
	}
	public void  back(){
		
	}
	public void  forward(){
		
	}
	public void  selectAnswer(){
		
	}

}
