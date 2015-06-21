import java.awt.geom.Ellipse2D;


public class LearningImageElement {
	
	int x;
	int y;
	int w; 
	int h;
	String name;
	String image;
	
LearningImage learningImage;
	
	public void  Highlight() {
		
	}
	
	public void  ShowInfo() {
		
	}
	
	public LearningImageElement (String name, String image, int x, int y, int w, int h) {
		this.name = name;
		this.image = image;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	boolean contains (int x, int y) {
		 Ellipse2D.Double ellipse = new Ellipse2D.Double(this.x, this.y, this.w, this.h);
		 return ellipse.contains(x, y);
	}

}
