package assignment.javaFXGame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author kkhub
 * This is my main class
 * The purpose of this is to get the game started and initialise all variables 
 * The purpose of the game is a science game that is used to educate children on basic science skills
 * I have used MVC and factory in this
 */
public class Main extends Application {
	Model model;
	View view;
	Controller controller;
	Pane root;
	Scene scene;
	Canvas canvas;
	GraphicsContext gc;
	Ship ship;
	Bullet b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//Title is set to game as it is a game
		primaryStage.setTitle("Game");
		//Root created
		Pane root = new Pane();
		//Primary stage declared to set the scene
		primaryStage.setScene(new Scene(root, 600, 400));
		//root is instantiated
		root = new Pane();
		//Scene declared and widt and height have been set
		scene = new Scene(root, 800, 600);
		//width and height set
		canvas = new Canvas(800, 600);
		//GC is declared
		gc = canvas.getGraphicsContext2D();
		//Scene is set
		primaryStage.setScene(scene);
		//This shows the scene
		primaryStage.show();
		//Adds canvas to root
		root.getChildren().add(canvas);
		//Fill color is added
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		this.ship = new Ship(400, 550, gc, root);
		primaryStage.show();
		model = new Model();
		view = new View(root, model, scene, canvas, gc);
		controller = new Controller(model, view, this.ship,canvas);
		scene.setOnKeyPressed(controller.keyHandler);
		view.setTextMenu();
	}	
}
