package pong;
import gameActions.Runner;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class PongRunner {

	
	
	public static void main(String[] args) {
		
		new Runner(new PongPanel());
	}
}
