package snake;

import gameActions.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.Timer;

import utilityClasses.*;


/**
 * @author Brady Stoffel
 */
public class SnakePanel extends Directions {

	/*
	 * To force implement of direction methods, have UserGame extend the
	 * Directions class It force the methods to be extended
	 * 
	 * int deltaX 
	 * int deltaY 
	 * int movementVar
	 * 
	 * int playerX int playerY
	 * 
	 * boolean startGame 
	 * boolean playing 
	 * boolean endGame 
	 * boolean nameEnter
	 * boolean highScores
	 * 
	 * boolean singleDirection only executes one direction per frame
	 * 
	 * You can override these methods to customize actions
	 * 
	 * drawStart(Graphics2D g) 
	 * drawPlaying(Graphics2D g) 
	 * drawPaused(Graphics2D g)
	 * drawEnd(Graphics2D g)
	 */

	
	
	public CustomRectangle head;
	public Color[] Colors = { Color.CYAN, Color.RED, Color.GREEN, Color.YELLOW,
			Color.ORANGE, Color.WHITE };
	public ArrayList<CustomRectangle> snakeBody = new ArrayList<CustomRectangle>();
	public ArrayList<CustomRectangle> fruits = new ArrayList<CustomRectangle>();
//	public Rectangle outerbox = new Rectangle(0, 0, width - 1, height);
	public Rectangle boundary = new Rectangle(18, 18, width - 8 - 20, height - 8 - 20);
	public int initialBodySize = 4;
	public int numOfFruits = 4;
	public int playingWidth = (width - 8 - 20) - ((width - 8 - 20) % 10) - 10;

	public SnakePanel() {
		super();
		setSpeed(movementVar);
		speedUp = true;
	}

	/**
	 * Used to draw custom graphics on the screen Anything in this method will
	 * be painted on all screens unless the painting part is inside of if
	 * statements so that it only drawn when that is true
	 */
	@Override
	public void draw(Graphics2D g) {

		g.setColor(Color.WHITE);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(15));
		g2.drawRect(outerbox.x, outerbox.y, outerbox.width, outerbox.height);
		g2.setStroke(new BasicStroke(2));
	}

	/**
	 * Overrides the drawPlaying method in the Control class. So if you want
	 * something different than a box that you can change the size of, change
	 * what is in here. Gets called when the screen in repainted
	 */
	@Override
	public void drawPlaying(Graphics2D g) {

		for (CustomRectangle r : snakeBody) {
			r.draw(g);
		}

		for (CustomRectangle r : fruits) {
			r.draw(g);
		}
		
		g.setColor(Color.WHITE);
		ScoreCoords.bottom_middle.draw(String.valueOf(score), g);
	}

	/**
	 * Gets called constantly. Put code here that will modify the player or
	 * other variables
	 */
	@Override
	public void moves() {
		
		head.x += deltaX;
		head.y += deltaY;

		snakeBody.add(0, (CustomRectangle) head.clone());

		for (int i = 1; i < snakeBody.size(); i++) {

			CustomRectangle l = snakeBody.get(i);
			snakeBody.get(i - 1).color = l.color;
		}

		boolean fruitOverlap = false;
		for (CustomRectangle r : fruits) {
			if (r.intersects(head)) {
				snakeBody.get(snakeBody.size() - 1).color = r.color;
				score++;
				newFruit(fruits.indexOf(r));
				fruitOverlap = true;
			}
		}

		if (!fruitOverlap) {
			snakeBody.remove(snakeBody.size() - 1);
		}
	}

	/**
	 * This should return a boolean indicating if the player is dead or not. By
	 * default returns false
	 */
	@Override
	public boolean checkIfDead() {

		boolean snakeBodyCheck = snakeBody.lastIndexOf(head) > 0;
		boolean boundaryCheck = !head.intersects(boundary);

		return snakeBody.lastIndexOf(head) > 0 || !head.intersects(boundary);
	}

	/**
	 * Gets called when the game is reset and you start over. Also calls the
	 * setup method. Can be used so make sure everything is cleared so the game
	 * starts new
	 */
	@Override
	public void reset() {

		fruits.clear();
		snakeBody.clear();
		
		setup();
	}

	/**
	 * Sets up the game before it starts. Sets all variables needed to any
	 * certain values
	 */
	@Override
	public void setup() {

		deltaX = 0;
		deltaY = -movementVar;

		for (int i = 0; i < numOfFruits; i++) {

			fruits.add(new CustomRectangle(randNum(), randNum(), 10, 10,
					randColor()));
		}

		head = new CustomRectangle(250, 250, 10, 10, Color.WHITE);

		for (int i = 0; i < initialBodySize; i++) {
			snakeBody.add(new CustomRectangle(250, 250 + 10 * i, 10, 10,
					Color.WHITE));
		}
	}

	public int randNum() {
		return ((int) (Math.random() * (playingWidth / 10))) * 10 + 10;
	}

	public Color randColor() {
		return Colors[(int) (Math.random() * Colors.length)];
	}
	
	public void newFruit(int index) {
		
		fruits.get(index).setBounds(randNum(), randNum(), 10, 10);
		fruits.get(index).color = randColor();
	}

	@Override
	public void up() {
		
		if (deltaX != 0) {

			deltaX = 0;
			deltaY = -movementVar;
		}
	}

	@Override
	public void down() {

		if (deltaX != 0) {

			deltaX = 0;
			deltaY = movementVar;
		}
	}

	@Override
	public void left() {

		if (deltaY != 0) {

			deltaY = 0;
			deltaX = -movementVar;
		}
	}

	@Override
	public void right() {
		if (deltaY != 0) {

			deltaY = 0;
			deltaX = movementVar;
		}
	}

	@Override
	public void upReleased() {}

	@Override
	public void downReleased() {}

	@Override
	public void leftReleased() {}

	@Override
	public void rightReleased() {}

	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return "Snake";
	}

	

}
