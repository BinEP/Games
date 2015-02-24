package tunnelRunner;

import gameActions.Runner;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TunnelRunner {

	public static void main(String[] args) {

		Runner r = new Runner(new TunnelPanel());
		Runner.enterFullScreen(r);
	}
}
