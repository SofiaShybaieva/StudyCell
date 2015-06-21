
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class LearningImage {
	
	File jpegFile;
	// LearningImageElement elements;
	public List<LearningImageElement> elements = new ArrayList<LearningImageElement>();
	
	public void  show(){
		
	}
	
	public void  isOnElement(){
		
	}
	public void  onElementClick(){
		
	}
	public void  onElementDack(){
		
	}
	
	public void addElement (String name, String image, int x, int y, int w, int h) {
		LearningImageElement el = new LearningImageElement (name, image, x, y, w, h);
		elements.add(el);
	}
}
