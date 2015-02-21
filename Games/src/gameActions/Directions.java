package gameActions;

import java.util.ArrayList;

public abstract class Directions extends Control {

	
	
	public Directions() {
		
		super();
		
	}
	public abstract void up();
	public abstract void down();
	public abstract void left();
	public abstract void right();
	
	public abstract void upReleased();
	public abstract void downReleased();
	public abstract void leftReleased();
	public abstract void rightReleased();
	
	
	
}
