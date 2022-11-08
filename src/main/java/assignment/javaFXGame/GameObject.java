package assignment.javaFXGame;

import java.util.Random;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

/**
 * @author kkhub
 * This class is my game object class and it is extended in all gameobjects that I create i.e space invader
 */
public class GameObject {
	
	//Contains all methods that all gameobjects have in common
	protected ImageView img;
	protected double x,y;
	protected GraphicsContext gc;
	protected boolean active;
	protected double speed;
	protected Circle circle;
	protected Pane root;
	
	
public GameObject(double x, double y, GraphicsContext gc, Pane root) {
	super();
	this.x = x;
	this.y = y;
	this.gc = gc;
	this.root = root;
	//Boolean active to see if the object can or should move
	active = false;
	img = new ImageView();
	//This is used to help generate the speed of the rocks falling down
	Random rnd = new Random();
	speed = 2 + (5 - 2) * rnd.nextDouble();
	circle = new Circle();

}

//Update method all gameobjects should have 
public void update()
{
	if(img!=null) {
		circle.setLayoutX(x);
	circle.setLayoutY(y);
	
	}
}

}