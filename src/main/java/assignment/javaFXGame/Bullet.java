package assignment.javaFXGame;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


/**
 * @author kkhub
 * 
 * Purpose of this class is for my bullet to be 'shot'
 * Class extends game object as it is a game object
 *
 */
public class Bullet extends GameObject{
	//Constructor takes params of super class
	public Bullet(double x, double y, GraphicsContext gc, Pane root) {
		super(x, y, gc, root);
		Image img2 = new Image(Rock1.class.getResource("bu.png").toExternalForm());
		// I have used circle as intersects method works best with this
		circle = new Circle(30);
		circle.setFill(new ImagePattern(img2));
		circle.setLayoutX(x);
		circle.setLayoutY(y);
		//Add's the image to the root
		root.getChildren().add(circle);
	}
	
	//I have done this method so I am able to remove the image of the bullet
	public void remove() {
		root.getChildren().remove(circle);
	}
	
	
	//This is my update method. I update it on the y axis as it is going up the bullet
	@Override
	public void update()
	{
		//Check to see if the image is not null and active is true as to whether they can shoot the bullet or not
		if(img!=null && active ==true) {
			y-=4;
			//Removes image bullet off screen when it passes a certain point
			if(y >= 0) {
				circle.setLayoutX(x);
				circle.setLayoutY(y);	
		}
			else {
				//off=true;
				root.getChildren().remove(circle);
			}
		}
	}
}
