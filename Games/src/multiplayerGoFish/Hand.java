package multiplayerGoFish;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Hand extends ArrayList<Card> {

	
	public boolean selected = false;
	public Color handCol = Color.CYAN;
	
	public Rectangle bounds;
	
	public static void main(String[] args) {
		Hand runIt = new Hand();
		runIt.runFromMain();
	}

	public void runFromMain() {

	}

	
	public Color getColor() {
		
		return handCol;
		
	}
	
	
public void setColor(Color c) {
		
		handCol = c;
		
	}

public Rectangle getBounds() {
	return bounds;
}

public void setBounds(int x, int y, int w, int h) {
	bounds = new Rectangle(x, y, w, h);
}

public void setBounds(Rectangle r) {
	bounds = new Rectangle(r.x, r.y, r.width, r.height);
}
	
}
