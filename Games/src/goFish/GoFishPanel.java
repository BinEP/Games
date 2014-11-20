package goFish;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GoFishPanel extends JPanel implements ActionListener, KeyListener {

	public GoFishPanel() {

		setBackground(Color.BLACK);

		setFocusable(true);
		addKeyListener(this);

		Timer timer = new Timer(1000 / 60, this);
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		moves();
	}

	public void moves() {

		
		
		
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
