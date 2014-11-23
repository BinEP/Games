package curvedPong;
import java.awt.BorderLayout;

import javax.swing.JFrame;


public class CurvedPongRunner {

	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("CURVED PONG!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		CurvedPongPanel curvedPongPanel = new CurvedPongPanel();
		//wWebPong pongPanel = new WebPong();
		frame.add(curvedPongPanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}
}
