package p4_group_8_repo.Obstacles;

import javafx.scene.image.Image;

// TODO: Auto-generated Javadoc
/**
 * The Class Turtle.
 * 
 * Controls the behavior of turles above water
 */
public class Turtle extends Actor{
	
	/**  turtle 1. */
	Image turtle1;
	
	/**  turtle 2. */
	Image turtle2;
	
	/**  turtle 3. */
	Image turtle3;
	
	/** The speed. */
	private int speed;
	
	/** The i. */
	int i = 1;
	
	/** The bool. */
	boolean bool = true;
	
	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	/**
	 * Instantiates a new turtle.
	 *
	 * @param xpos the x position 
	 * @param ypos the y position
	 * @param s the speed
	 * @param w the width
	 * @param h the height
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/resources/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/resources/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/resources/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
