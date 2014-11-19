package pong;
import java.awt.BorderLayout;

import javax.swing.JFrame;


public class PongRunner {

	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("PONG!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		PongPanel pongPanel = new PongPanel();
		//wWebPong pongPanel = new WebPong();
		frame.add(pongPanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}
}
