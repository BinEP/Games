package gameActions;

import java.awt.Graphics2D;
/**
 * Methods that UserGame needs to have, the draw methods are in control, so only need of you want a custom
 * screen
 * 
 * @author Brady
 *
 */
public interface PlayerInterface {

	public void moves();
	public boolean checkIfDead();
	public void reset();
	public void draw(Graphics2D g);
	public void setup();
	
	public void drawStart(Graphics2D g);
	public void drawPlaying(Graphics2D g);
	public void drawEnd(Graphics2D g);
	
}
