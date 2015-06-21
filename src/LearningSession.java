import java.awt.Button;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dialog;
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
		
	private JPanel panel;
	private JLabel label;
	
	public LearningSession () {
		learningImage = new LearningImage ();
		learningImage.addElement ("Митохондрия","mit.jpg", 242,305,75,35);
		learningImage.addElement ("Митохондрия","mit.jpg", 202,398,75,35);
		learningImage.addElement ("Ядро","yadro.jpg", 585,340,225,250);
		learningImage.addElement ("Лизосомы","lysosome.jpg", 390,260,60,60);
		learningImage.addElement ("x4","mit.jpg", 517,539,100,50); 
	}
	
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

		int i = 0;
		g.drawOval(this.learningImage.elements.get(i).x, 
				this.learningImage.elements.get(i).y, 
				this.learningImage.elements.get(i).w, 
				this.learningImage.elements.get(i).h);

		panel.setVisible(true);
		
	}
	
	private void prepareGUI(){
		
		this.setLayout(new FlowLayout());
		this.setSize(1024, 768);
		this.setTitle("Learning Session");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.file = new File("cell.jpg");
		loadImage(file);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		 label = new JLabel();
	      //label.setText("<html><body><h1>fghjxmf</h1></body></html>");

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
	public void mousePressed(MouseEvent e) {
		int x = e.getPoint().x;
		int y = e.getPoint().y;
		// finding the element with the hit
		for (int i=0; i<this.learningImage.elements.size(); i++) {
			LearningImageElement el = this.learningImage.elements.get(i);
			if (el.contains(x,y)) {
				displayDescription(el.name, el.image);
			}
		}
		
	}

	private void displayDescription(String string, String image) {
		String s = "";
		if (string.compareTo("Митохондрия") == 0 ) {
			s = "<h1>Митохондрия</h1> Митохо́ндрия — двумембранная сферическая или эллипсоидная органелла диаметром обычно около 1 микрон. Характерна для большинства эукариотических клеток, как автотрофов (фотосинтезирующие растения), так и гетеротрофов (грибы, животные). Энергетическая станция клетки; основная функция — окисление органических соединений и использование освобождающейся при их распаде энергии для генерации электрического потенциала, синтеза АТФ и термогенеза. Эти три процесса осуществляются за счёт движения электронов по электронно-транспортной цепи белков внутренней мембраны.Митохо́ндрия (от греч. μίτος — нить и χόνδρος — зёрнышко, крупинка) — двумембранная сферическая или эллипсоидная органелла диаметром обычно около 1 микрон. Характерна для большинства эукариотических клеток, как автотрофов (фотосинтезирующие растения), так и гетеротрофов (грибы, животные). Энергетическая станция клетки; основная функция — окисление органических соединений и использование освобождающейся при их распаде энергии для генерации электрического потенциала, синтеза АТФ и термогенеза. Эти три процесса осуществляются за счёт движения электронов по электронно-транспортной цепи белков внутренней мембраны.";
		}
		
		if (string.compareTo("Ядро") == 0 ) {
			s = "<h1>Ядро клетки</h1> Место хранения, воспроизведения и начальной реализации генетической информации, центр управления жизненными процессами клетки. Ядро состоит из поверхностного аппарата и ядерного матрикса. Поверхностный аппарат ядра состоит из двух мембран – внешней и внутренней. В пространстве между внутренней и внешней мембраной находятся поры, которые их соединяют. Поверхностный аппарат ядра соединен с мембранами ЭПС. Ядерный матрикс состоит из кариоплазмы, одного-двух ядрышек – рибонуклеопротеидных комплексов и ниток хроматина. Кариоплазма напоминает цитоплазму. В ней содержатся фибриллы, которые формируют внутренний скелет, который соединяет ядрышки, нитки хроматина, поры.  ";
		}
		
		if (string.compareTo("Лизосомы") == 0 ) {
			s = "<h1>Лизосомы</h1>Лизосо́ма  — окружённый мембраной клеточный органоид, в полости которого поддерживается кислая среда и находится множество растворимых гидролитических ферментов. Лизосома отвечает за внутриклеточное переваривание макромолекул, в том числе при аутофагии; лизосома способна к секреции своего содержимого в процессе лизосомного экзоцитоза; также лизосома участвует в некоторых внутриклеточных сигнальных путях, связанных с метаболизмом и ростом клетки. Лизосома является одним из видов везикул и относится к эндомембранной системе клетки. Разные виды лизосом могут рассматриваться как отдельные клеточные компартменты.";
		}
		
		 JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);
		 
		  dialog.setSize(640, 480);
		  dialog.setLayout(new FlowLayout());
		  dialog.setLocationRelativeTo(null);
		    
		   JLabel label = new JLabel(new ImageIcon(image));
		   String text = String.format("<html><body>%s</body></html>", s);
		   label.setLayout(new FlowLayout());
	       label.setText(text);

		         JPanel panel = new JPanel(new BorderLayout());
		         panel.add(label, BorderLayout.NORTH);
		         panel.setPreferredSize(new Dimension(620, 460));
		         dialog.add(panel);
		         dialog.setVisible(true);
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println(e.getPoint().x + ", " + e.getPoint().y);
		
		int x = e.getPoint().x;
		int y = e.getPoint().y;
		
		// finding the element with the hit
		for (int i=0; i<this.learningImage.elements.size(); i++) {
			LearningImageElement el = this.learningImage.elements.get(i);
			if (el.contains(x,y)) {
				label.setText(el.name);
			}
		}
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
