package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class CustomRectangle extends Rectangle {

	public Color color = Color.WHITE;

	public CustomRectangle(int x, int y, int width, int height, Color c) {
		// TODO Auto-generated constructor stub
		super(x, y, width, height);
		this.color = c;

	}

	public void draw(Graphics2D g, boolean blackBorder) {

		g.setColor(color);
		g.fillRect(x, y, width, height);
		if (blackBorder) {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
		}

	}

	public void draw(Graphics2D g) {

		draw(g, true);

	}
}