package holeInTheWall;

import gameActions.Runner;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pong.PongPanel;
import snake.SnakePanel;

public class HoleRunner {

	public static void main(String[] args) {

	Runner r = new Runner(new HolePanel());
	Runner.enterFullScreen(r);
	
	}
}
