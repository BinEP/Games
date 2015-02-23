package tunnelRunner;

import gameActions.Runner;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pong.PongPanel;

public class TunnelRunner {

	public static void main(String[] args) {

		
		new Runner(new TunnelPanel());
	}
}
