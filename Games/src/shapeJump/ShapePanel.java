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
	private int borderThickness = 2;
	private int blockSize = shapeWidth + 2 * borderThickness;
	
	private int ground = 350;
	
	private ArrayList<Integer> shapeGroupX = new ArrayList<Integer>(3);
	
	
public ShapePanel() {

		setBackground(Color.BLACK);

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
		
		
		
		
		
		
		
		
	}
	
	public void drawShape(int randomShape) {
		
		
		
		
		
		
		
	}
	
	public void drawShape(int[] x, int[] y, Graphics2D g) {
		
		int pos = nextBlockX();
		for (int i = 0; i < x.length; i++) {
			
			g.fillRect(pos + (x[i]-1) * blockSize + borderThickness, ground - y[i] * blockSize + borderThickness, shapeWidth, shapeWidth);
			g.drawRect(pos + (x[i]-1) * blockSize + borderThickness/2, ground - y[i] * blockSize + borderThickness/2, shapeWidth, shapeWidth);
			g.drawRect(pos + (x[i]-1) * blockSize, ground - y[i] * blockSize, shapeWidth, shapeWidth);
			
		}
		
		
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public int nextBlockX() {
		
		shapeGroupX.add(shapeGroupX.get(2) + 170);
		shapeGroupX.remove(0);
		return shapeGroupX.get(shapeGroupX.size()-1);
		
		
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
