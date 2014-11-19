package utilityClasses;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;


public class CenteredText {

	
	public int x;
	public int y;

	public CenteredText() {
		this.x = 0;
		this.y = 0;
		
	}
	
	public CenteredText(String text, int width, int height, Graphics g) {
		
		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();
		
		this.x = (width - textWidth)/2;
		this.y = (height - textHeight)/2;
		
		
	}
	
public CenteredText(String text, int width, int height, Graphics g, boolean draw, int textY) {
		
		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();
		
		this.x = (width - textWidth)/2;
		this.y = (height - textHeight)/2;
		
		if(draw) {
			
			g.drawString(text, x, textY);
			
		}
		
		
	}
	
public CenteredText(String text, int width, int height, Graphics g, Font theFont) {
		
		FontMetrics fontInfo = g.getFontMetrics(theFont);
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();
		
		this.x = (width - textWidth)/2;
		this.y = (height - textHeight)/2;
		
		
	}

	
	
	
}
