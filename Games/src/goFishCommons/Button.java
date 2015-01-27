package goFishCommons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import utilityClasses.CenteredText;

/*
 * If there is a reason to use this instead of JButton
 * it would be good to explain what it is here.
 * 
 * Also, since it appears to represent only a single button, 
 * it would be much less confusing to call it 'Button' instead of 'Buttons'.
 */

public class Button implements Serializable {

	private Rectangle bounds; // calling this 'button' is confusing. 'bounds' would be a much better name
	private String text;
	public boolean selected = false;
	private Color col = Color.WHITE;

	public Button() {

		bounds = new Rectangle();
		text = "";
		col = Color.WHITE;

	}

	public Button(String t, Rectangle r) {

		bounds = new Rectangle();
		bounds = r;
		text = t;

	}

	public Button(String t, int x, int y, int w, int h) {

		bounds = new Rectangle(x, y, w, h);
		text = t;

	}
	
	public Rectangle getButton() {
		
		return bounds;
	}
	
	public String getText() {
		return text;
	}
	
	public Rectangle setButton(String t, int x, int y, int w, int h) {
		bounds = new Rectangle(x, y, w, h);
		return bounds;
	}
	
	public String setText(String t) {
		text = t;
		return text;
	}
	
public void setColor(Color color) {
		
		col = color;
	}
	
	public void drawRectangle(Graphics g) {
		
		g.setColor(Color.WHITE);
		
		g.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 5, 5);
		g.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 5, 5);
		CenteredText t = new CenteredText(text, bounds.width, bounds.height, g, true);
		g.setColor(Color.BLACK);
		g.drawString(text, bounds.x + t.x, bounds.y + t.y);
		g.setColor(Color.WHITE);
		
	}

	public static void main(String[] args) {

	}
}
