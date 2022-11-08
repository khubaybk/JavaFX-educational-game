package assignment.javaFXGame;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
/**
 * @author kkhub
 * 
 * Purpose of this class is for my rock to fall down the screen
 * Class extends game object as it is a game object
 *
 */
public class Rock2 extends GameObject{
	//Constructor takes params of super class
	public Rock2(double x, double y, GraphicsContext gc, Pane pane) {
		super(x, y, gc, pane);
		Image img2 = new Image(Rock1.class.getResource("asteroid2.png").toExternalForm());
		img.setImage(img2);
		// I have used circle as intersects method works best with this
		circle = new Circle(40);
		circle.setFill(new ImagePattern(img2));
		circle.setLayoutX(x);
		circle.setLayoutY(y);
		root.getChildren().add(circle);
		AudioClip sound  = new AudioClip(this.getClass().getResource("rockDrop1.wav").toExternalForm());
		sound.play();

	}
	//This is my update method. I update it on the y axis as it is going down the rock
	@Override
	public void update()
	{
		//Check to see if the image is not null and active is true as to whether it should be added
		if(img!=null) {
			y+=1*speed;
			if(y <= 620) {
				circle.setLayoutX(x);
				circle.setLayoutY(y);
			}
			else {
				//Removes image rock off screen when it passes a certain point
				root.getChildren().remove(circle);
			}
		}
	}	
}
