package shapeJump;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pong.PongPanel;

public class ShapeRunner {

	public static void main(String[] args) {

		
		JFrame frame = new JFrame("Shape Jumper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
//		frame.setAlwaysOnTop(true);
		
		ShapePanel shapePanel = new ShapePanel();
		//wWebPong pongPanel = new WebPong();
		frame.add(shapePanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		//grrrrr
	}
}
