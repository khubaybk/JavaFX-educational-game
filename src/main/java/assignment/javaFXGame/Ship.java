package assignment.javaFXGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
/**
 * @author kkhub
 * 
 * Purpose of this class is for my ship to move accross the screen
 * Class extends game object as it is a game object
 *
 */
public class Ship extends GameObject{
	//Constructor takes params of super class
	public Ship(double x, double y, GraphicsContext gc, Pane p) {
		super(x, y, gc, p);
		// TODO Auto-generated constructor stub
		Image img2 = new Image(Ship.class.getResource("shipW.png").toExternalForm());
		// I have used circle as intersects method works best with this
		circle = new Circle(50);
		circle.setFill(new ImagePattern(img2));
		circle.setLayoutX(x);
		circle.setLayoutY(y);
		root.getChildren().add(circle);
		
	}
	//This is my move method. I update it on the x axis as it is going across the screen
	public void moveLeft() {
		//Can only move ship and not off the screen
		if(x <=15) {}
		else {
		x-=5;
		circle.setLayoutX(x);
		circle.setLayoutY(y);
	}
	}
	
	//This is my move method. I update it on the x axis as it is going across the screen
	public void moveRight() {
		//Can only move ship and not off the screen
		if(x>780) {}
		else {
		x+=5;
		circle.setLayoutX(x);
		circle.setLayoutY(y);
		}
		
	}
	
}
