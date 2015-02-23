package gameActions;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Game extends Control {

	public Game() {
		super();
	}

	/**
	 * Used to draw custom graphics on the screen Anything in this method will
	 * be painted on all screens unless the painting part is inside of if
	 * statements so that it only drawn when that is true
	 * 
	 */
	public abstract void draw(Graphics2D g);

	/**
	 * Overrides the drawPlaying method in the Control class. So if you want
	 * something different than a box that you can change the size of, change
	 * what is in here. Gets called when the screen in repainted
	 */

	public abstract void drawPlaying(Graphics2D g);

	/**
	 * Gets called constantly. Put code here that will modify the player or
	 * other variables
	 * 
	 */
	public abstract void moves();

	/**
	 * This should return a boolean indicating if the player is dead or not. By
	 * default returns false
	 */
	public abstract boolean checkIfDead();

	/**
	 * Gets called when the game is reset and you start over. Also calls the
	 * setup method. Can be used so make sure everything is cleared so the game
	 * starts new
	 */
	public abstract void reset();

	/**
	 * Sets up the game before it starts. Sets all variables needed to any
	 * certain values
	 */
	@Override
	public abstract void setup();

	@Override
	public abstract String getGameName();
}
