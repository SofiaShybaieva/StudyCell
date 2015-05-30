import java.awt.Button;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class LearningSession extends JFrame implements MouseListener, MouseMotionListener{

	LearningImage learningImage;
	private Image image;
	private File file;
	private Ellipse2D.Double ellipse = new Ellipse2D.Double(100,100,50,25);
	private JPanel panel;
	private JLabel label;
	
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
		g.drawOval((int)ellipse.x, (int) ellipse.y, (int)ellipse.width, (int)ellipse.height);
		panel.setVisible(true);
		
	}
	
	private void prepareGUI(){
		
		this.setLayout(new FlowLayout());
		this.setSize(1024, 768);
		this.setTitle("Learning Session");
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		this.file = new File("cell.jpg");
		loadImage(file);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		 label = new JLabel();
	      label.setText("<html><body><h1>Rktnrf</h1></body></html>");

	         panel = new JPanel(new BorderLayout());
	         panel.add(label, BorderLayout.NORTH);
	         panel.setPreferredSize(new Dimension(1000, 50));
	         this.add(panel);
		
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

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("Mouse Clicked at X: " + x + " - Y: " + y);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("Mouse Entered frame at X: " + x + " - Y: " + y);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("Mouse Exited frame at X: " + x + " - Y: " + y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("Mouse Pressed at X: " + x + " - Y: " + y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("Mouse Released at X: " + x + " - Y: " + y);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println(e.getPoint().x + ", " + e.getPoint().y);
		
		int x = e.getPoint().x;
		int y = e.getPoint().y;
		
		
		if (ellipse.contains(x, y)) {
			label.setText("kjhgg");
			System.out.println("");
		}
		else
			label.setText("");
			
			
		
	}

	
	
}
