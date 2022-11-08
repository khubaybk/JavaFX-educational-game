package assignment.javaFXGame;

import java.util.Random;


import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;



/**
 * @author kkhub
 * The purpose of this class is in relation with MVC itself.
 * This is the controller and has access to the model and view
 */

public class Controller implements EventHandler{
Model model;
View view;

Canvas canvas;
//This checks if rocks are added
boolean rocksAdded = false;

/**
 * This is my constructor. It takes different parameters.
 * and implements eventhandler as it deals with all events
 *
 */
public Controller(Model model, View view, Ship ship, Canvas canvas) {
	super();
	this.model = model;
	this.view = view;
	model.ship = ship;
	this.canvas = canvas;

}


/**
 * This is my animation timer. This deals with all intersections of the ship, with an asteroid.
 * It also takes into account all lives and changes views depending on the lives
 *
 */
AnimationTimer rockTimer = new AnimationTimer() {
	@Override
	public void handle(long now) {
		// TODO Auto-generated method stub
		//This Checks if there is an item in the list that stores all asteroids. This is a check
		if(model.list.size() ==1)
		{
			//This adds the score to the screen
			view.generateScore("Score = " + model.score);
			//This retrieves the rock and check if it intersects with the ship
			GameObject obj = model.list.get(0);
			//This calls my rocks to be updated
			model.rocksOnScreen();
			
			//Intersection method to check intersection
			if(model.ship.circle.getBoundsInParent().intersects(obj.circle.getBoundsInParent())) {
				model.coll = true;
				return;
				}
			//Dependent on lives here, the level changes 
			if(model.coll == true) {
				if(model.lives == 4) {
					rockTimer.stop();
				model.lives--;
				model.score-=10;
				model.coll = false;
				view.generateLives("Lives = " + model.lives  );
				//Generating lives message and score
				view.generateScore("Score = " + model.score);
				//View is changed to question1
				view.question();
				//clear list as rock still exists and could cause a conflict
				model.list.clear();
				return;

				}
				
				else if(model.lives == 3) {
					rockTimer.stop();
					model.lives--;
					model.coll = false;
					model.score-=10;
					//Generating lives message and score
					view.generateLives("Lives = " + model.lives  );
					view.generateScore("Score = " + model.score);
					//View is changed to question2
					view.question1();
					//clear list as rock still exists and could cause a conflict
					model.list.clear();
					return;
					}
				
				else if(model.lives == 2) {
					rockTimer.stop();
					model.lives--;
					model.coll = false;
					model.score-=10;
					//Generating lives message and score
					view.generateLives("Lives = " + model.lives  );
					view.generateScore("Score = " + model.score);
					rockTimer.stop();
					//View is changed to question2
					view.question3();
					//clear list as rock still exists and could cause a conflict
					model.list.clear();
					return;
					}
				else {
					model.score-=10;
					rockTimer.stop();
					//view is changed to game over as lives are finished
					view.gameOver();
					model.backGround.stop();
				}
				}
		}				
		else{
			//Adds rocks if array is empty 
			model.addRock(view.gc, view.root);
		}
		//Updates ship
		model.ship.update();	
	}
};



/**
 * This is my animation timer. This deals with all intersections of the bullet, with a space invader.
 * It also takes into account all lives and changes views depending on the lives
 *
 */
AnimationTimer invaderTimer = new AnimationTimer() {

	@Override
	public void handle(long now) {
		//Method to add lives text to screen
		view.addLivesText("Question Lives = " + model.qLives);
		//Check in array list to ensure invaders exist
		if(model.invaders.size() != 0) {
			//If lives are greater than 0 then carry on with checks
			if(model.qLives !=0) {
				//for each loop to check and go through the array of invaders
				//and checks if they have intersected
			for(Invader inv : model.invaders) {
		if(model.b.circle.getBoundsInParent().intersects(inv.circle.getBoundsInParent())) {
			//If invader hasn't been hit already
			if(inv.hit == false) {
			//if the answer boolean value in the invader class is true, change views 	
			if(inv.answer == true) {
				inv.circle.setFill(new ImagePattern(inv.imgG));
				model.sound  = new AudioClip(this.getClass().getResource("success.wav").toExternalForm());
				model.sound.play();
				invaderTimer.stop();
				view.main();
				view.addLives();
				view.addScore();
				rockTimer.start();
			}
			else {
				//This changes the images picture upon intersection
				inv.circle.setFill(new ImagePattern(inv.imgR));
				model.sound  = new AudioClip(this.getClass().getResource("incorrect.wav").toExternalForm());
				model.sound.play();
				//Invader has now been hit
				inv.hit = true;
				//remove the bullet
				model.b.remove();
				//lives are to be deducted as the answer was incorrect
				model.qLives--;
			}	
			}
			}
			}
			}
			else {
				//If all questions are answered incorrectly on that screen, change view to game over view
				view.gameOverQuestion();
			}
		}
		//This updates the bullet
		model.b.update();
	}
};

EventHandler<KeyEvent> keyHandler = new EventHandler <KeyEvent>() {
	@Override
	public void handle(KeyEvent keyEvent) {
		
		if(keyEvent.getCode() == KeyCode.A) {
			model.ship.moveLeft();
		}
		if(keyEvent.getCode() == KeyCode.D) {
			model.ship.moveRight();
		}
		if(keyEvent.getCode() == KeyCode.Z) {
			view.removeTextMenu();
			rockTimer.start();
			model.backGround  = new AudioClip(this.getClass().getResource("back.mp3").toExternalForm());
			model.backGround.play();
		}
		//If this is true, I am on a screen where I can shoot(not asteroid screen)
		if(model.bullet == true) {
		if(keyEvent.getCode() == KeyCode.SPACE) {
			view.removeSpaceText();
			//If a bullet already exists and is on screen
			if(model.b != null) {
				//remove the bullet
				model.b.remove();
			}
			//Create a new bullet
			model.sound  = new AudioClip(this.getClass().getResource("shoot.wav").toExternalForm());
			model.sound.play();
			model.b = new Bullet(model.ship.x, model.ship.y, view.gc, view.root);
			//set it to be active
			
			model.b.active = true;
			//Start the timer for the bullet to move
			invaderTimer.start();
		}
	}
	}
};

@Override
public void handle(Event event) {
	// TODO Auto-generated method stub
}
}
