package shapeJump;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ShapePanel extends JPanel implements ActionListener, KeyListener {

	private int shapeWidth = 20;
	private int squareSide = shapeWidth;
	private int circleDiameter = shapeWidth;
	private int borderThickness = 1;
	private int blockSize = shapeWidth + 2 * borderThickness;

	private int ground = 350;

	private int shapeSpeed = 5;
	// private int pos = nextBlockX();

	private ArrayList<Integer> shapeGroupX = new ArrayList<Integer>();

	public ShapePanel() {

		setBackground(Color.BLACK);
		shapeGroupX.add(500);
		shapeGroupX.add(670);
		shapeGroupX.add(840);

		setFocusable(true);
		addKeyListener(this);

		Timer timer = new Timer(1000 / 60, this);
		timer.start();

	}

	public void actionPerformed(ActionEvent e) {

		// ifStarted();
		moves();

	}

	public void moves() {

		if (shapeGroupX.contains(0)) {
			shapeGroupX.add(shapeGroupX.get(2) + 170);
			shapeGroupX.remove(0);
		}

		for (int i = 0; i < shapeGroupX.size(); i++) {
			shapeGroupX.set(i, shapeGroupX.get(i) - shapeSpeed);
		}

		repaint();

	}

	public void drawShape(int randomShape) {

	}

	public void drawShape(int[] x, int[] y, int pos, Graphics g) {

		// int pos = nextBlockX();
		for (int i = 0; i < x.length; i++) {
			g.setColor(Color.WHITE);
			
			int x1 = pos + (x[i] - 1) * blockSize;
			int y1 = ground - y[i] * blockSize;
			
			g.fillRect(x1 + borderThickness, y1 + borderThickness, shapeWidth, shapeWidth);
			
			g.setColor(Color.BLACK);
			g.drawRect(x1 + borderThickness / 2, y1 + borderThickness / 2, shapeWidth, shapeWidth);

		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, ground, getWidth(), 10);

		int[] x = { 1, 2, 1, 3, 2, 3 };
		int[] y = { 1, 2, 3, 2, 3, 1 };

		for (Integer n : shapeGroupX) {
			drawShape(x, y, n, g);

		}

	}

	public int nextBlockX() {

		shapeGroupX.add(shapeGroupX.get(2) + 170);
		shapeGroupX.remove(0);
		return shapeGroupX.get(shapeGroupX.size() - 1);

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
