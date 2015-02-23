package gameActions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.Timer;

import utilityClasses.*;

public class UserGame extends Game {

	/*
	 * int deltaX int deltaY int movementVar
	 * 
	 * int playerX int playerY
	 * 
	 * boolean startGame boolean playing boolean endGame boolean nameEnter
	 * boolean highScores
	 * 
	 * boolean singleDirection sets if only one directin per frame
	 */

	/*
	 * You can override these methods to customize actions
	 * 
	 * drawStart(Graphics2D g)
	 * drawPlaying(Graphics2D g)
	 * drawPaused(Graphics2D g)
	 * drawEnd(Graphics2D g)
	 * up()
	 * down()
	 * left()
	 * right()
	 * upReleased()
	 * downReleased()
	 * rightReleased()
	 * leftReleased()
	 * 
	 */
	
	
	
	public UserGame() {

		super();
		
	}

	/**
	 * Used to draw custom graphics on the screen
	 * Anything in this method will be painted on all screens
	 * unless the painting part is inside of if statements so
	 * that it only drawn when that is true
	 * 
	 */
	public void draw(Graphics2D g) {

	}
	/**
	 * Overrides the drawPlaying method in the Control class. So if you want something different than a
	 * box that you can change the size of, change what is in here. Gets called when the screen in repainted
	 */

	public void drawPlaying(Graphics2D g) {
		
		g.setColor(Color.CYAN);
		g.fillRect(20, 30, playerX, playerY);
		
		
		g.drawString(String.valueOf(getTime()), 5, 15);

	}
	/**
	 * Gets called constantly. Put code here that will modify the player or other variables
	 * 
	 */
	public void moves() {

		playerX += deltaX;
		playerY += deltaY;

		

	}
	/**
	 * This should return a boolean indicating if the player is dead or not. By default returns false
	 */
	public boolean checkIfDead() {
		
		
		return false;
	}
	
	/**
	 * Gets called when the game is reset and you start over. Also calls the setup method. Can be used
	 * so make sure everything is cleared so the game starts new
	 */
	public void reset() {

		setup();

	}
/**
 	* Sets up the game before it starts. Sets all variables needed to any certain values
 */
	@Override
	public void setup() {

		deltaX = 2;
		deltaY = 2;
		playerX = 100;
		playerY = 100;

	}

@Override
public String getGameName() {
	// TODO Auto-generated method stub
	return "Game";
}

@Override
public int getScore() {
	// TODO Auto-generated method stub
	return 0;
}





}
