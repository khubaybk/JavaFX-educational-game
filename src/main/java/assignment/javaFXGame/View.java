package assignment.javaFXGame;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author kkhub
 * This is the view class which is utilised by the design pattern MVC
 * This class contains all the different views for certain levels
 */
public class View {
	Pane root;
	Model model;
	//Different text variables set as they can be reused
	Text t, t1, t2, t3, t4;	
	Scene scene;
	Canvas canvas;
	GraphicsContext gc;
	//Constructor for class with parameters from main class
	public View(Pane root, Model model, Scene scene, Canvas canvas, GraphicsContext gc) {
		super();
		this.root = root;
		this.model = model;
		this.scene = scene;
		this.canvas = canvas;
		this.gc = gc;
		//This is a variable for the lives and added as this is on the first screen
		t = new Text("Lives = " + model.lives);
		t.setFill(Color.RED);
		t.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t.setY(50);
		t.setX(30);
		root.getChildren().add(t);		
		//This is a variable for the lives on the question page and not added as this is on the question screen
		t2 = new Text("Question Lives = " + model.qLives);
		t2.setFill(Color.RED);
		t2.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t2.setY(50);
		t2.setX(30);
		t3 = new Text("Score = " + model.score);
		t3.setFill(Color.RED);
		t3.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t3.setY(50);
		t3.setX(550);
		//This is a variable for the text to shoot on the question page and not added as this is on the question screen
		t4 = new Text("Press Spacebar to shoot the correct answer!");
		t4.setFill(Color.YELLOW);
		t4.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t4.setY(450);
		t4.setX(150);
		root.getChildren().add(t3);
	}
	
	//Method to allow me to remove text
	public void removeSpaceText() {
		root.getChildren().remove(t4);
	}
	
	//Method to allow me to add text
	public void addLivesText(String s) {
		this.t2.setText(s);
	}
	//Method to allow me to add text
	public void generateScore(String s) {
		this.t3.setText(s);
	}
	
	//Method to allow me to add text
	public void generateLives(String s) {
		this.t.setText(s);
	}
	
	//Method to allow me to add text
	public void addLives() {
		root.getChildren().add(t);		
	}
	
	//Method to allow me to add text
	public void addQLives() {
		root.getChildren().add(t2);		
	}
	//Method to allow me to add text
	public void addScore() {
		root.getChildren().add(t3);		
	}
	
	
	//This is the for the main page when loaded
	public void setTextMenu() {
		this.t1 = new Text("                  Welcome to Science Ship!"+ "\r\n" +"        The way the game works is the following:" +  "\r\n"
		 + "                         Press A to move left" +  "\r\n" + "                        Press D to move right"  + "\r\n" + "But remember, hit an asteroid then you lose a life " + "\r\n" +"          and have to answer a science question!"
				+  "\r\n" + "\r\n" + "\r\n" +"                                Press Z to start!");
		this.t1.setFill(Color.WHITE);
		this.t1.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		this.t1.setX(100);
		this.t1.setY(200);
		root.getChildren().add(t1);
	}
	
	//Method to allow me to remove text
	public void removeTextMenu() {
		root.getChildren().remove(t1);
	}
	
	//Main view to show the main screen
	public void main() {
		root.getChildren().clear();
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		model.ship = new Ship(400, 550, gc, root);
		model.bullet = false;
	}

	//View for the question
	public void question() {
		// TODO Auto-generated method stub
		root.getChildren().clear();
		model.qLives = 2;
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		model.bullet = true;
		model.ship = new Ship(400, 550, gc, root);
		root.getChildren().add(t4);
		addScore();
		addQLives();
		Text t = new Text(model.q1);
		t.setFill(Color.WHITE);
		t.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t.setX(150);
		t.setY(75);
		root.getChildren().add(t);
		Invader inv = new Invader(100, 150, gc, root);
		Invader inv1 = new Invader(300, 150, gc, root);
		Invader inv2 = new Invader(500, 150, gc, root);
		Invader inv3 = new Invader(700, 150, gc, root);
		 model.invaders.add(inv);
		 model.invaders.add(inv1);
		 model.invaders.add(inv2);
		 model.invaders.add(inv3);
		int x = 50;
		for(int i = 0; i< model.q1A.length; i++) {
		Text t1 = new Text(model.q1A[i]);
		if(i == 0) {model.invaders.get(0).answer = true;}
		t1.setFill(Color.WHITE);
		t1.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t1.setX(x);
		t1.setY(200);
		x+=200;
		root.getChildren().add(t1);
		}
	}
	
	public void question1() {
		// TODO Auto-generated method stub
		model.clearList();
		root.getChildren().clear();
		model.qLives = 2;
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		model.bullet = true;
		model.ship = new Ship(400, 550, gc, root);
		addScore();
		addQLives();
		Text t = new Text(model.q2);
		t.setFill(Color.WHITE);
		t.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t.setX(80);
		t.setY(75);
		root.getChildren().add(t);
		Invader inv = new Invader(100, 150, gc, root);
		Invader inv1 = new Invader(300, 150, gc, root);
		Invader inv2 = new Invader(500, 150, gc, root);
		Invader inv3 = new Invader(700, 150, gc, root);
		 model.invaders.add(inv);
		 model.invaders.add(inv1);
		 model.invaders.add(inv2);
		 model.invaders.add(inv3);
		int x = 50;
		for(int i = 0; i< model.q2A.length; i++) {
		Text t1 = new Text(model.q2A[i]);
		if(i == 0) {model.invaders.get(0).answer = true;}
		t1.setFill(Color.WHITE);
		t1.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t1.setX(x);
		t1.setY(200);
		x+=200;
		root.getChildren().add(t1);
		}
	}
	
	public void question3() {

		model.clearList();
		// TODO Auto-generated method stub
		root.getChildren().clear();
		model.qLives = 2;
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		model.ship = new Ship(400, 550, gc, root);
		addScore();
		addQLives();
		model.bullet = true;
		Text t = new Text(model.q3);
		t.setFill(Color.WHITE);
		t.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t.setX(150);
		t.setY(75);
		root.getChildren().add(t);
		Invader inv = new Invader(100, 150, gc, root);
		Invader inv1 = new Invader(300, 150, gc, root);
		Invader inv2 = new Invader(500, 150, gc, root);
		Invader inv3 = new Invader(700, 150, gc, root);
		 model.invaders.add(inv);
		 model.invaders.add(inv1);
		 model.invaders.add(inv2);
		 model.invaders.add(inv3);
		int x = 50;
		for(int i = 0; i< model.q3A.length; i++) {
		Text t1 = new Text(model.q3A[i]);
		if(i == 2) {model.invaders.get(2).answer = true; model.invaders.get(0).answer = false;}
		t1.setFill(Color.WHITE);
		t1.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t1.setX(x);
		t1.setY(200);
		x+=200;
		root.getChildren().add(t1);
		}
	}
	
	public void gameOver() {
		root.getChildren().clear();
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		Text t1 = new Text("     GAME OVER!"  + "\r\n" + "Your score was: " + model.score);
		t1.setFill(Color.WHITE);
		t1.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t1.setX(300);
		t1.setY(300);
		root.getChildren().add(t1);
	}
	
	
	public void gameOverQuestion() {
		root.getChildren().clear();
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		Text t1 = new Text("                   GAME OVER!"  + "\r\n" + "You failed to answer all question's!" 
		+ "\r\n" + "              Your score was: " + model.score);
		t1.setFill(Color.WHITE);
		t1.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		t1.setX(200);
		t1.setY(300);
		root.getChildren().add(t1);
	}
	
}
