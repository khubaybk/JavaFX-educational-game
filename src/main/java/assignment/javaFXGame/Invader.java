package assignment.javaFXGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * @author kkhub
 * This class is used for the purpose of my invaders that hold questions.
 * This extends game object
 */
public class Invader extends GameObject{
//This is boolean answer and is used to help me deduce whether or not the answer is correct upon intersection
boolean answer;
//Correct image (green invader)
Image imgG;
//Incorrect image (red invader)
Image imgR;
//Hit is set to false as it has not been hit originally
boolean hit = false;
	public Invader(double x, double y, GraphicsContext gc, Pane root) {
		super(x, y, gc, root);
		// TODO Auto-generated constructor stub
		//Answer is default and set to false
		answer = false;
		//New images declared and initialised
		Image img = new Image(Invader.class.getResource("spaceY.png").toExternalForm());
		imgG = new Image(Invader.class.getResource("greenS.png").toExternalForm());
		imgR = new Image(Invader.class.getResource("red.png").toExternalForm());

		 circle = new Circle(40);
			circle.setFill(new ImagePattern(img));
			circle.setLayoutX(x);
			circle.setLayoutY(y);
			root.getChildren().add(circle);
	}
}
