package utilityClasses;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/*
 *  this seems like an odd way to go about this.
 *  I'd expect something more like GuiUtil.centerText(String text, Graphics g).
 *  Or just use a JLabel and set its horizontal alignment.
 */
public class CenteredText {

	public static void draw(String text, int yVal, Graphics g) {

		int width = Windows.WIDTH;
		int height = Windows.HEIGHT;
		
		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();

		int x = (width - textWidth) / 2;
		int y = (height - textHeight) / 2;
		
		g.drawString(text, x, yVal);

	}
	
	public static void draw(String text, Rectangle r, Graphics g) {

		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();

		int x = r.x + (r.width - textWidth) / 2;
		int y = r.y + (r.height - textHeight) / 2;
		
		g.drawString(text, x, y);

	}
	
	public static void draw(String text, int w, int h, Graphics g, boolean t, int yVal) {
		
		int width = w;
		int height = h;
		
		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();

		int x = (width - textWidth) / 2;
		int y = (height - textHeight) / 2;
		
		g.drawString(text, x, yVal);
		
		
	}
	
	public static void draw(String text, int yVal, Graphics2D g, int fontSize, String fontFile) {

		int width = Windows.WIDTH;
		int height = Windows.HEIGHT;
		
		g.setFont(CustomFont.makeCustomFont(fontFile, fontSize));
		
		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();

		int x = (width - textWidth) / 2;
		int y = (height - textHeight) / 2;
		
		g.drawString(text, x, yVal);

	}
	
	public static void draw(String text, Rectangle r, Graphics2D g, int fontSize, String fontFile) {

		g.setFont(CustomFont.makeCustomFont(fontFile, fontSize));
		
		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();

		int x = r.x + (r.width - textWidth) / 2;
		int y = r.y + (r.height - textHeight) / 2;
		
		g.drawString(text, x, y);

	}
	
	
	
	

}
