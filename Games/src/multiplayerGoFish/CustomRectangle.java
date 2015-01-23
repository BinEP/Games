package multiplayerGoFish;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class CustomRectangle extends Rectangle {

	public boolean selected = false;
	public Color handCol = Color.CYAN;
	
	public static void main(String[] args) {
		CustomRectangle runIt = new CustomRectangle();
		runIt.runFromMain();
	}

	public void runFromMain() {

	}

	public CustomRectangle() {
		// TODO Auto-generated constructor stub
	}

	public CustomRectangle(Rectangle r) {
		super(r);
		// TODO Auto-generated constructor stub
	}

	public CustomRectangle(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public CustomRectangle(Dimension d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	public CustomRectangle(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public CustomRectangle(Point p, Dimension d) {
		super(p, d);
		// TODO Auto-generated constructor stub
	}

	public CustomRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public CustomRectangle(int x, int y, int width, int height, boolean selected) {
		super(x, y, width, height);
		this.selected = selected;
		// TODO Auto-generated constructor stub
	}
	
	public void setColor(Color c) {
		
		this.handCol = c;
		
	}

}
