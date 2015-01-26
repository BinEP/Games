package utilityClasses;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NewFont {

	private String path;
	
//	public Font customFont;
	public Font customFont;
	public String fontName;

	public static void main(String[] args) {
		NewFont runIt = new NewFont();
		runIt.runFromMain();
	}

	public void runFromMain() {
		makeCustomFont("tele.ttf");
		getFontName();
	}

	public NewFont() {
		// TODO Auto-generated constructor stub

	}

	public NewFont(String fontPath) {

		makeCustomFont(fontPath);
	}

	public void makeCustomFont(String fontPath) {

		try {

			fontPath = "InfoFiles/Fonts/" + fontPath + ".ttf";
			this.path = fontPath;

			InputStream fontStream = new BufferedInputStream(
					new FileInputStream(fontPath));

			GraphicsEnvironment ge = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
			ge.registerFont(customFont);
		} catch (Exception e) {
			// Handle exception
			e.printStackTrace();
		}

		this.fontName = customFont.getName();

	}

	public String getFontName() {

		return fontName;

	}

	public Font getFontVariation(int fontThickness, int size) {

		return customFont.deriveFont(fontThickness, size);

	}

	public Font getFontSizeVariation(int size) {

		return customFont.deriveFont(size);

	}

	public Font getFontStyleVariation(int fontThickness) {

		return customFont.deriveFont(fontThickness);

	}

	public Font setFontVariation(int fontThickness, int size) {

		customFont = customFont.deriveFont(fontThickness, size);
		return customFont;
	}

	public Font setFontSizeVariation(int size) {

		customFont = customFont.deriveFont(size);
		return customFont;
	}

	public Font setFontStyleVariation(int fontThickness) {

		customFont = customFont.deriveFont(fontThickness);
		return customFont;
	}
	
	public Font getCustomFont() {
		
		
		return customFont;
		
		
	}
	
	public Font fontAtSize(int size) {
		
		return customFont.deriveFont(Font.BOLD, size);
		
	}

}
