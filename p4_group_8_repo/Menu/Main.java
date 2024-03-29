package p4_group_8_repo.Menu;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import p4_group_8_repo.Obstacles.Animal;
import p4_group_8_repo.Obstacles.Log;
import p4_group_8_repo.Obstacles.Obstacle;
import p4_group_8_repo.Obstacles.Turtle;
import p4_group_8_repo.Obstacles.WetTurtle;
import p4_group_8_repo.ScoreSystem.Digit;
import p4_group_8_repo.ScoreSystem.End;
import p4_group_8_repo.Stage.BackgroundImage;
import p4_group_8_repo.Stage.MyStage;


/**
 * The Class Main.
 * @author Mohanad
 *@version Java 15 and JavaFX 15.0.1
 *
 *Compiles all the other classes to intiate the main game 
 */
public class Main extends Application {
	
	/** Defines a timer object */
	AnimationTimer timer;
	
	/** Defines a MyStage object*/
	MyStage background;
	
	Animal animal;

	/**
	 * The main function of the program.
	 *
	 * @param primaryStage the primary stage
	 * @throws Exception throws an exception in case there are any errors
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new MyStage();
	    Scene scene  = new Scene(background,600,800);

		BackgroundImage froggerback = new BackgroundImage("file:src/resources/iKogsKW.png");

		background.add(froggerback);
		createStage();

		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}
	
	/**
	 * Creates the timer.
	 */
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
/** 
 * plays background music
 */
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

	/** 
	 * stops timer
	 */
    public void stop() {
        timer.stop();
    }
    /**
     * Displays the score to the player
     * @param n the score
     */
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 530 - shift, 30));
    		  shift+=30;
    		}
    }


/**
 * Creates the obstacles of the game and putting them into place
 */
public void createStage() {

	background.add(new Log("file:src/resources/log3.png", 150, 0, 166, 0.75));
	background.add(new Log("file:src/resources/log3.png", 150, 220, 166, 0.75));
	background.add(new Log("file:src/resources/log3.png", 150, 440, 166, 0.75));
	background.add(new Log("file:src/resources/logs.png", 300, 0, 276, -2));
	background.add(new Log("file:src/resources/logs.png", 300, 400, 276, -2));
	background.add(new Log("file:src/resources/log3.png", 150, 50, 329, 0.75));
	background.add(new Log("file:src/resources/log3.png", 150, 270, 329, 0.75));
	background.add(new Log("file:src/resources/log3.png", 150, 490, 329, 0.75));	
	background.add(new Turtle(500, 376, -1, 130, 130));
	background.add(new Turtle(300, 376, -1, 130, 130));
	background.add(new WetTurtle(700, 376, -1, 130, 130));
	background.add(new WetTurtle(600, 217, -1, 130, 130));
	background.add(new WetTurtle(400, 217, -1, 130, 130));
	background.add(new WetTurtle(200, 217, -1, 130, 130));

	background.add(new End(13,96));
	background.add(new End(141,96));
	background.add(new End(141 + 141-13,96));
	background.add(new End(141 + 141-13+141-13+1,96));
	background.add(new End(141 + 141-13+141-13+141-13+3,96));
	animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
	background.add(animal);
	background.add(new Obstacle("file:src/resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
	background.add(new Obstacle("file:src/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
	background.add(new Obstacle("file:src/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
	background.add(new Obstacle("file:src/resources/car1Left.png", 100, 597, -1, 50, 50));
	background.add(new Obstacle("file:src/resources/car1Left.png", 250, 597, -1, 50, 50));
	background.add(new Obstacle("file:src/resources/car1Left.png", 400, 597, -1, 50, 50));
	background.add(new Obstacle("file:src/resources/car1Left.png", 550, 597, -1, 50, 50));
	background.add(new Obstacle("file:src/resources/truck2Right.png", 0, 540, 1, 200, 200));
	background.add(new Obstacle("file:src/resources/truck2Right.png", 500, 540, 1, 200, 200));
	background.add(new Obstacle("file:src/resources/car1Left.png", 500, 490, -5, 50, 50));
	background.add(new Digit(0, 30, 480, 30));
	background.start();
}
}