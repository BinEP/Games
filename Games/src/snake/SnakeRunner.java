package snake;

import gameActions.Runner;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SnakeRunner {

	public static void main(String[] args) {

		Runner r = new Runner(new SnakePanel());
		Runner.enterFullScreen(r);
		
//		try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {}
// 
//		Runner.enterFullScreen(r);
		
//		JFrame frame = new JFrame("SNAKE!");
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(new BorderLayout());
////		frame.setAlwaysOnTop(true);
//
//		SnakePanel SnakePanel = new SnakePanel();
//		frame.add(SnakePanel, BorderLayout.CENTER);
//
//		frame.setSize(500, 500);
//		frame.setVisible(true);
	}
}


