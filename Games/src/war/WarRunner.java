package war;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class WarRunner {

	public static void main(String[] args) {

		
		JFrame frame = new JFrame("WAR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		//frame.setAlwaysOnTop(true);
		
		WarPanel WarPanel = new WarPanel();
		frame.add(WarPanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
