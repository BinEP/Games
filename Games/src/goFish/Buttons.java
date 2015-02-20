package goFish;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import utilityClasses.CenteredText;

public class Buttons {

	private Rectangle button;
	private String text;
	public boolean selected = false;
	private Color col = Color.WHITE;

	public Buttons() {

		button = new Rectangle();
		text = "";
		col = Color.WHITE;

	}

	public Buttons(String t, Rectangle r) {

		button = new Rectangle();
		button = r;
		text = t;

	}

	public Buttons(String t, int x, int y, int w, int h) {

		button = new Rectangle(x, y, w, h);
		text = t;

	}
	
	public Rectangle getButton() {
		
		return button;
	}
	
	public String getText() {
		return text;
	}
	
	public Rectangle setButton(String t, int x, int y, int w, int h) {
		button = new Rectangle(x, y, w, h);
		return button;
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
		
		g.drawRoundRect(button.x, button.y, button.width, button.height, 5, 5);
		g.fillRoundRect(button.x, button.y, button.width, button.height, 5, 5);
		g.setColor(Color.BLACK);
		CenteredText.draw(text, button, g);
		
		g.setColor(Color.WHITE);
		
	}

	public static void main(String[] args) {

	}
}
