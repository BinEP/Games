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
	// private int pos = nextBlockX();

	private ArrayList<Integer> shapeGroupX = new ArrayList<Integer>();
	private ArrayList<Shape> shapeBlocks = new ArrayList<Shape>();

	private int blockY = ground - 1;
	private int blockX = 60;
	private int deltaY = 0;
	private int blockWidth = shapeWidth - 1;
	private int blockVel = 0;
	// private int gravity = 1;
	private boolean jumping = false;

	private int gravity = 1;
	private int jumpVel = 10;
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
		shapeGroupX.add(670);
		shapeGroupX.add(840);

		shapeBlocks.add(new Shape());
		shapeBlocks.add(new Shape());
		shapeBlocks.add(new Shape());

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
				shapeGroupX.add(shapeGroupX.get(2) + 170);
				shapeGroupX.remove(0);
				shapeBlocks.add(new Shape());
				shapeBlocks.remove(0);
			}

			for (int i = 0; i < shapeGroupX.size(); i++) {
				shapeGroupX.set(i, shapeGroupX.get(i) - shapeSpeed);
			}
			
			
			//Gets range of the X that the block can be on
			int[] xR = getXRange();
			//Checks if block is in bewteen the range
			if (blockX > xR[0] && blockX < xR[1]) {
				//groundY = ground - the height of the shape groups
				groundY = ground - shapeBlocks.get(0).h * blockSize;
				//jumping = true;
			} else {
				//Otherwise keep groundY as the ground
				groundY = ground;
			}
//			if(ijh == 5) {
//				jumping = true;
//				deltaY = jumpVel;
//			}
			if ((blockY == groundY || Math.abs(blockY - ground) < 5) && !jumping) {
				deltaY = 0;
			}
//			if (groundY < ground - 1) {
//				System.out.println(groundY);
//			}
			int nextDeltaY = deltaY - gravity;
			int nextBlockY = blockY - nextDeltaY;
			int deltaYToGround = blockY - (groundY - 1);
			int blockYToGround = blockY - deltaYToGround;
			if (jumping) {
			if (nextBlockY < groundY - 1) {
				
				deltaY = nextDeltaY;
			} else if (nextDeltaY > 0) {
			} else {
				deltaY = deltaYToGround;
				jumping = false;
				
				
			}
			}
					
//			if (blockY - deltaY <= groundY && jumping) {
//
//				deltaY -= gravity;
//
//			}
//
//			if (blockY >= groundY - 1 && jumping && deltaY < 0) {
//				blockY = groundY - 1;
//				blockVel = 0;
//				jumping = false;
//				timePressed = 0;
//				deltaY = w0;
//			}
//			
			
			
			//Keeps track of time
			timeSplit++;
			if (timeSplit == 60) {
				timeSplit = 0;
				timeSeconds++;
			}

			ijh++;

			blockY -= deltaY;

		}

		repaint();

	}

	public void drawShape(int[] x, int[] y, int pos, Graphics g) {

		for (int i = 0; i < x.length; i++) {
			g.setColor(Color.WHITE);
			Graphics2D g2d = (Graphics2D) g;
			
			// x1 = x of shape group + (x position of square) * Size of square
			int x1 = pos + (x[i] - 1) * blockSize;
			// y1 = ground - (y position) * size of square
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
			// g.drawString("Press Enter to", 120, 300);
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

			g.fillRect(blockX, blockY - 20, blockWidth, blockWidth);
			// g.setColor(Color.RED);
			// g.fillRect(blockX, blockY + 1, 5, 5);
			// g.fillRect(blockX + blockWidth, blockY + 1, 5, 5);

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

	public int nextBlockX() {

		shapeGroupX.add(shapeGroupX.get(2) + 170);
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
			deltaY = jumpVel;

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

			// if (endGame) {
			//
			// reset();
			//
			// }
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
		shapeGroupX.add(670);
		shapeGroupX.add(840);

		shapeBlocks.clear();
		shapeBlocks.add(new Shape());
		shapeBlocks.add(new Shape());
		shapeBlocks.add(new Shape());

		timeSplit = 0;
		timeSeconds = 0;

	}

	public int[] getXRange() {

		int width = (shapeWidth + borderThickness) * shapeBlocks.get(0).w + 20;
		int[] x = { shapeGroupX.get(0) - 20, width };
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
