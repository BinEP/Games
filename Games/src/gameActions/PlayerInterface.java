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

	public PlayerInterface() {
		super();
		NAME = getGameName();
		TXT_FILE = NAME.toLowerCase().replaceAll("\\s", "");
		FOLDER_PATH = getFolderPath();
		FONT_FILE = getFontFile();
	}
	public abstract void moves();
	public abstract boolean checkIfDead();
	public abstract void reset();
	public abstract void draw(Graphics2D g);
	public abstract void drawPlaying(Graphics2D g);
	public abstract void setup();
	
	public abstract String getGameName();
	public abstract int getScore();
//	public abstract String getFolderPath();
//	public abstract String getFontFile();
	
}
