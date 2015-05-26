import java.awt.Button;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class LearningSession extends JFrame{

	LearningImage learningImage;
	private Image image;
	private File file;
	
	private void loadImage(File file) {
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			System.err.println("Image Cell not found!");
		}
	}

	@Override
	public void paint (Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, this);
	}
	
	private void prepareGUI(){
		this.setLayout(null);
		this.setSize(1024, 768);
		this.setTitle("Learning Session");
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		this.file = new File("cell.jpg");
		loadImage(file);
		
		
	}
	
	public void  start() {
		prepareGUI();
	}
	public void  finish(){
		
	}
	public void  init(){
		
	}
	public void  cancel(){
		
	}
	
	
}
