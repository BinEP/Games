package tunnelRunner;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pong.PongPanel;

public class RunnerRunner {

	public static void main(String[] args) {

		
		JFrame frame = new JFrame("TUNNEL RUNNER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		RunnerPanel RunnerPanel = new RunnerPanel();
		//wWebPong pongPanel = new WebPong();
		frame.add(RunnerPanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
