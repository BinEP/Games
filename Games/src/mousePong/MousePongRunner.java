package mousePong;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pong.PongPanel;

public class MousePongRunner {

	public static void main(String[] args) {

		
		JFrame frame = new JFrame("Mouse Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		MousePongPanel MousePongPanel = new MousePongPanel();
		frame.add(MousePongPanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
