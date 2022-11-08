package assignment.javaFXGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;


/**
 * @author kkhub
 *This is the factory class is to define a runtime interface for object creation
 *This extends my interface and has all methods implemented 
 */
public class Factory implements FactoryIF{
	GraphicsContext gc;
	Pane root;
	public Factory(GraphicsContext gc, Pane root) {
		super();
		this.gc = gc;
		this.root = root;
	}
	//Rock is created depending on discrim value
	@Override
	public GameObject createProduct(String discrim, double x, double y) {
		if(discrim.equals("Rock1")){
			return new Rock1(x,y,gc, root);
		}
		if(discrim.equals("Rock2")){
			return new Rock2(x,y,gc, root);
		}
	
		return null;
	}

}
