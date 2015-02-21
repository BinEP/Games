package gameActions;

import java.awt.Graphics2D;
/**
 * Methods that UserGame needs to have, the draw methods are in control, so only need of you want a custom
 * screen
 * 
 * @author Brady
 *
 */
public abstract class PlayerInterface extends Control {

	public abstract void moves();
	public abstract boolean checkIfDead();
	public abstract void reset();
	public abstract void draw(Graphics2D g);
	public abstract void setup();
	
	
}
