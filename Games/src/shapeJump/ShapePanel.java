package shapeJump;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.Timer;

import utilityClasses.CenteredText;

public class ShapePanel extends JPanel implements ActionListener, KeyListener {

	private boolean startGame = true;
	private boolean playing = false;
	private boolean endGame = false;
	private boolean paused = false;

	private int shapeWidth = 20;
	private int squareSide = shapeWidth;
	private int circleDiameter = shapeWidth;
	private int borderThickness = 1;
	private int blockSize = shapeWidth + 2 * borderThickness;

	private int ground = 400;
	private int groundY = ground;

	private int shapeSpeed = 5;
	private int spacing = 250;
	// private int pos = nextBlockX();

	private ArrayList<Integer> shapeGroupX = new ArrayList<Integer>();
	private ArrayList<Shape> shapeBlocks = new ArrayList<Shape>();

	private int blockY = ground - 1;
	private int blockX = 80;
	private int deltaY = 0;
	private int blockWidth = shapeWidth - 1;
	private int blockVel = 0;
	// private int gravity = 1;
	private boolean jumping = false;

	private int gravity = 1;
	private int jumpVel = 20;
	private int ijh = 0;

	private int timeSplit;
	private int timeSeconds;
	private double timePressed = 0.0;
	private double jumpTime;
	private boolean UpPressed;
	private boolean DownPressed;

	private boolean glitch = false;

	public ShapePanel() {

		setBackground(Color.BLACK);
		shapeGroupX.add(500);
		shapeGroupX.add(500 + spacing);
//		shapeGroupX.add(500 + spacing * 2);
		

		shapeBlocks.add(new Shape());
		shapeBlocks.add(new Shape());
//		shapeBlocks.add(new Shape());

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

		if (playing) {
			if (shapeGroupX.contains(0)) {
				shapeGroupX.add(shapeGroupX.get(shapeGroupX.size() - 1) + spacing);
				shapeGroupX.remove(0);
				shapeBlocks.add(new Shape());
				shapeBlocks.remove(0);
			}

			for (int i = 0; i < shapeGroupX.size(); i++) {
				shapeGroupX.set(i, shapeGroupX.get(i) - shapeSpeed);
			}
			
			setGroundY();
//			System.out.println(groundY);
			if (blockY + 1 < groundY) jumping = true;
			if (jumping) {
				
				deltaY += gravity;
				blockY += deltaY;
				
				
				if (blockY > groundY) {
					
					blockY = groundY - 1;
					deltaY = 0;
					jumping = false;
				}
				
			}
			
			//Keeps track of time
			timeSplit++;
			if (timeSplit == 60) {
				timeSplit = 0;
				timeSeconds++;
			}
		}

		repaint();

	}

	public void drawShape(int[] x, int[] y, int pos, Graphics g) {

		for (int i = 0; i < x.length; i++) {
			g.setColor(Color.WHITE);
			
			int x1 = pos + (x[i] - 1) * blockSize;
			int y1 = ground - y[i] * blockSize;

			g.fillRect(x1 + borderThickness, y1 + borderThickness, shapeWidth,
					shapeWidth);

			g.setColor(Color.BLACK);
			g.drawRect(x1 + borderThickness / 2, y1 + borderThickness / 2,
					shapeWidth, shapeWidth);

		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, ground, getWidth(), 10);

		if (startGame) {

			g.setFont(new Font("Joystix", Font.BOLD, 80));
			CenteredText title1 = new CenteredText("SHAPE", 500, 500, g, true,
					130);
			CenteredText title2 = new CenteredText("JUMPER", 500, 500, g, true,
					200);

			g.setFont(new Font("Joystix", Font.BOLD, 20));

			CenteredText start1 = new CenteredText("Press Enter to", 500, 500,
					g, true, 300);
			CenteredText start2 = new CenteredText("Start", 500, 500, g, true,
					330);

		} else if (playing || paused) {
			int i = 0;
			for (Integer n : shapeGroupX) {
				drawShape(shapeBlocks.get(i).x, shapeBlocks.get(i).y, n, g);
				i++;
			}

			g.setColor(Color.WHITE);
			g.setFont(new Font("Joystix", Font.BOLD, 20));
			g.drawString(String.valueOf(timeSeconds), 5, 20);

			g.fillRect(blockX - 20, blockY - 20, blockWidth, blockWidth);
			

			if (paused) {
				g.setFont(new Font("Joystix", Font.BOLD, 60));
				CenteredText pause = new CenteredText("Paused", 500, 500, g,
						true, 200);
			}

			if (paused) {
				g.setFont(new Font("Joystix", Font.BOLD, 60));
				CenteredText pause = new CenteredText("Paused", 500, 500, g,
						true, 200);
			}

		} else if (endGame) {

			g.setColor(Color.WHITE);
			g.setFont(new Font("Joystix", Font.BOLD, 20));
			g.drawString(String.valueOf(timeSeconds), 5, 20);

			g.setFont(new Font("Joystix", Font.BOLD, 60));
			g.setColor(Color.WHITE);
			CenteredText lose = new CenteredText("You Lose!", 500, 500, g,
					true, 170);
			// g.drawString("You Lose!", 50, 270);

			g.setFont(new Font("Joystix", Font.BOLD, 26));

			CenteredText restart = new CenteredText("Enter to Restart", 500,
					500, g, true, 320);

		}

	}
	
	public void setGroundY() {
		
		int shapeGroupStart = shapeGroupX.get(0);
		
		int shapeGroupEnd = (shapeBlocks.get(0).w * blockSize) + shapeGroupStart;
//		System.out.println(shapeGroupStart + ", " + shapeGroupEnd);
		
		groundY = 400;
		for (int[] xy : shapeBlocks.get(0).topXY) {
		
			int x = (xy[0] - 1) * blockSize + shapeGroupStart;
			int y = 400 - (xy[1]) * blockSize;
			if (blockX > x && blockX - 20 < shapeGroupEnd) {
				groundY = y;
				if (getColor(blockX + 2, blockY + 2).equals(Color.WHITE)) {
					playing = false;
					endGame = true;
					return;
				}
				return;
			}
			
			
		}
		
		
	}

	public int nextBlockX() {

		shapeGroupX.add(shapeGroupX.get(shapeGroupX.size() - 1) + spacing);
		shapeGroupX.remove(0);
		return shapeGroupX.get(shapeGroupX.size() - 1);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyChar() == 'w'
				&& ((!jumping || glitch) || (blockY >= ground - 20 && timeSeconds != 0))) {

			jumping = true;
			// timePressed = getTimeHund();
			deltaY = -jumpVel;

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// UpPressed = false;
			if (!paused) {
				playing = false;
				paused = true;
			} else {
				playing = true;
				paused = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// UpPressed = false;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// DownPressed = false;

		} else if (e.getKeyCode() == KeyEvent.VK_1) {
			glitch = !glitch;

		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			reset();
			startGame = false;
			endGame = false;
			playing = true;

		}

	}

	public double getTimeHund() {
		// System.out.println(((timeSeconds * 60) + timeSplit) * 5 / (3 * 100));
		return ((timeSeconds * 60) + timeSplit) * 5 / 3;
	}

	public void reset() {

		shapeGroupX.clear();
		shapeGroupX.add(500);
		shapeGroupX.add(500 + spacing);
//		shapeGroupX.add(500 + spacing * 2);

		shapeBlocks.clear();
		shapeBlocks.add(new Shape());
		shapeBlocks.add(new Shape());
//		shapeBlocks.add(new Shape());

		timeSplit = 0;
		timeSeconds = 0;

	}

	public int[] getXRange() {

		int width = (shapeWidth + borderThickness) * shapeBlocks.get(0).w + 20;
		int[] x = { shapeGroupX.get(0) - 20, width };
		Arrays.sort(x);
//		System.out.println("[" + x[0] + ", " + x[1] + "]");
		return x;

	}

	public static Color getColor(int x, int y) {
		try {
			// System.out.print("(" + x + ", " + y + ")  ");
			return new Robot().getPixelColor(x, y + 40);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Color.BLACK;
		}
	}
}
