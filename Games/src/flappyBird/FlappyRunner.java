package flappyBird;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pong.PongPanel;

public class FlappyRunner {

	public static void main(String[] args) {

		
		JFrame frame = new JFrame("JUMPY BALL!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		FlappyPanel FlappyPanel = new FlappyPanel();
		//wWebPong pongPanel = new WebPong();
		frame.add(FlappyPanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
