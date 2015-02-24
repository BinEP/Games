package pong;
import gameActions.Runner;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PongRunner {

	
	
	public static void main(String[] args) {
		
		Runner r = new Runner(new PongPanel());
		Runner.enterFullScreen(r);
	}
}
