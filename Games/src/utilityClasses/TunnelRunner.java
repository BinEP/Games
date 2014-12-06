package utilityClasses;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pong.PongPanel;

public class TunnelRunner {

	public static void main(String[] args) {

		
		JFrame frame = new JFrame("TUNNEL RUNNER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		TunnelPanel TunnelPanel = new TunnelPanel();
		//wWebPong pongPanel = new WebPong();
		frame.add(TunnelPanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
