package utilityClasses;

import hangman.HangmanPanel;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SizeReference {

	JFrame frame;

	public SizeReference() {

		JFrame frame = new JFrame("GAME!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setAlwaysOnTop(true);
		
		Panel Panel = new Panel();
		frame.add(Panel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		this.frame = frame;
		
		
	}

	public SizeReference(JFrame frameIn) {

		
		
		this.frame = frameIn;

	}

	public static void main(String[] args) {
		SizeReference s = new SizeReference();
		s.runFromMain();
	}
	
	public void runFromMain() {
		
		System.out.println(getScale());
		
	}

	public int getTitle() {

		return 80;
	}

	public int getHeight() {

		return this.frame.getHeight();

	}

	public int getWidth() {

		return this.frame.getWidth();

	}
	
	public double getScale() {
		
		return Math.sqrt(getHeight() * getHeight() + getWidth() * getWidth()) / Math.sqrt(500000);
		
		
	}
	
	public double getTitleY() {
		
		return getHeight() / 3;
		
	}
	
	public int enterLine() {
		
		return (getHeight() / 3) * 2;
		
		
	}
	
	

	/*
	 * Title - 80 Enter - 20
	 */

}
