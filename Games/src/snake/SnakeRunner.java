
package snake;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SnakeRunner {

	public static void main(String[] args) {

		JFrame frame = new JFrame("SNAKE!");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setAlwaysOnTop(true);

		SnakePanel SnakePanel = new SnakePanel();
		frame.add(SnakePanel, BorderLayout.CENTER);

		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
