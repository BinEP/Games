package blackjack;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class BlackjackRunner {

	public static void main(String[] args) {

		
		JFrame frame = new JFrame("GO FISH");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
//		frame.setAlwaysOnTop(true);
		
		BlackjackPanel BlackjackPanel = new BlackjackPanel();
		frame.add(BlackjackPanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
