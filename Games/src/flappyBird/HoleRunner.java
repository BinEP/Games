package flappyBird;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pong.PongPanel;

public class HoleRunner {

	public static void main(String[] args) {

		
		JFrame frame = new JFrame("HOLE IN THE WALL!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		HolePanel HolePanel = new HolePanel();
		//wWebPong pongPanel = new WebPong();
		frame.add(HolePanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
