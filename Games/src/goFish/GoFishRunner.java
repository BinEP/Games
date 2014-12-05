package goFish;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import utilityClasses.CenteredText;

public class GoFishRunner {

	public static void main(String[] args) {

		
		JFrame frame = new JFrame("GO FISH");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setAlwaysOnTop(true);
		
		GoFishPanel GoFishPanel = new GoFishPanel();
		frame.add(GoFishPanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
