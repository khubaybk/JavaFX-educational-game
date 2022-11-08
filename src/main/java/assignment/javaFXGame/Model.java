package assignment.javaFXGame;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;

/**
 * @author kkhub
 * The purpose of this class is to hold all information
 *
 */
public class Model {
	AudioClip sound;
	AudioClip backGround;
	//New ship declared
	Ship ship;
	//new bullet declared
	Bullet b;
	//This is set to false so I can shoot it on certain screens
	Boolean bullet = false;
	int score = 0;
	//Have rocks been added?
	boolean rocks_Added = false;
	//Lives to answer questions is 2
	int qLives = 2;
	//Arraylist holding all game objects (Rocks)
	ArrayList<GameObject> list = new ArrayList<GameObject>();
	//ArrayList holding all invaders
	ArrayList<Invader> invaders = new ArrayList<Invader>();
	//Lives is initially set to 4
	int lives = 4;
	//Collision of rocks
	boolean coll = false;
	//Collision of bullet and invader
	boolean coll2 = false;
	//There are all questions and answers being initialised
	String q1 = "What animal eats both plants and animals?";
	String q2 = "What type of rock is formed from cooled lava or magma?";
	String q3 = "When water is in a solid state, what is it called?";
	String[] q1A = {"Omnivore", "Herbivore", "Vertebrate", "Reptiles", 	"Amphibians"};
	String[] q2A = {"Igneous", "Metamorphic", "Sedimetary", "Elemntary", "Basalt"};
	String[] q3A = {"Water", "Steam", "Ice", "Bubbles", "Lava"};
	
	//This is an update method to keep adding rocks to the array list
	//It also updates them
	public void rocksOnScreen(){
		if (list.size() != 0) {
			GameObject obj = list.get(0); 		
				if(obj != null) {
					obj.active = true;
					obj.update();
				}	
				if (obj.y > 650) {
					list.remove(obj);
					score+=10;
				}
		}
	}
	//This is a method to clear all invaders from array
	public void clearList() {
		invaders.clear();
	}
	//This method generates 2 rocks depending on the random number generated#
	//It allows for me to have more than one type of rock
	public String generateRock() {
		Random rnd = new Random();
		int r = rnd.nextInt(2) + 1;
		String rock = "";
		if(r == 1) {rock =  "Rock1";}
		if(r == 2) {rock =  "Rock2";}
		return rock;
	}

	//This adds rocks depending on what number is generated
	public void addRock(GraphicsContext gc, Pane root) {
		Factory factory = new Factory(gc,root);
		Random rnd = new Random();
		int r = rnd.nextInt(800) + 1;
		int rockCount = 0;
		while(rockCount<1) {
		String rock = generateRock();
		list.add(factory.createProduct(rock, r, 0));
		rockCount++;
	}
		//Rock has been added and is set to true
		rocks_Added = true;
	}
	
}
