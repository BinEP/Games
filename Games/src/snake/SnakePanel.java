package snake;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.Timer;
//HI

import utilityClasses.CenteredText;

public class SnakePanel extends JPanel implements ActionListener, KeyListener {

	private boolean startGame = true;
	private boolean playing = false;
	private boolean paused = false;
	private boolean endGame = false;

	private ArrayList<Point> snakeBody = new ArrayList<Point>();
	private ArrayList<Color> snakeColor = new ArrayList<Color>();
	private Color[] Colors = {Color.CYAN, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.WHITE};
	private int bodySize = 10;
	private Point head = new Point(250, 250);

	private int fruitX = 300;
	private int fruitY = 200;
	private Color fruitColor = Color.WHITE;

	private int deltaX = 0;
	private int deltaY = -bodySize;

	private int prevLoseKey = KeyEvent.VK_DOWN;

	private Timer timer;
	private double speed = 10;

	private int score = 0;

	public SnakePanel() {

		resetBody();
		for (Point x : snakeBody) {

			// System.out.print(x.x + "  " + x.y);
			// System.out.println();

		}
		setBackground(Color.BLACK);

		setFocusable(true);
		addKeyListener(this);

		timer = new Timer((int) (1000 / speed), this);
		timer.start();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		moves();
	}

	public void moves() {

		if (playing) {

			head.x += deltaX;
			head.y += deltaY;

			// System.out.println("(" + head.x + ", " + head.y + ")");

			for (int i = snakeBody.size() - 1; i > 0; i--) {

				if (head.x == snakeBody.get(i).x
						&& head.y == snakeBody.get(i).y) {
					playing = false;
					endGame = true;
				}
				snakeBody.set(i, snakeBody.get(i - 1));

				// System.out.print("(" + x.x + ", " + x.y + ") ");

			}
			snakeBody.set(0, new Point(head.x, head.y));

			/*
			 * for (Point x : snakeBody) { //snakeBody.set(i,
			 * snakeBody.get(i-1));
			 * 
			 * 
			 * System.out.print("(" + x.x + ", " + x.y + ") ");
			 * 
			 * }
			 */
			// System.out.println();

			// System.out.println();

			/*
			 * for (int i = 0; i < snakeBody.size(); i++) {
			 * 
			 * Point body = snakeBody.get(i); body.x += deltaX; body.y +=
			 * deltaY;
			 * 
			 * snakeBody.set(i, body); }
			 */
			/*
			 * Point headOfBody = new Point(); headOfBody = snakeBody.get(0);
			 */
			int nextHeadX = head.x + deltaX;
			int nextHeadY = head.y + deltaY;
			/*
			 * if (Math.abs(nextHeadX - fruitX) < 5 && Math.abs(nextHeadY -
			 * fruitY) < 5) { addBodySquare(); }
			 */

			if (Math.abs(head.x - fruitX) < 5 && Math.abs(head.y - fruitY) < 5) {
				addBodySquare();
			}

			if (head.x < 1 || head.x > 485 || head.y < 8 || head.y > 465) {

				playing = false;
				endGame = true;
			}

		}

		repaint();

	}

	public void addBodySquare() {

		int lastBodyX = snakeBody.get(snakeBody.size() - 1).x;
		int lastBodyY = snakeBody.get(snakeBody.size() - 1).y;
		int secondLastBodyX = snakeBody.get(snakeBody.size() - 2).x;
		int secondLastBodyY = snakeBody.get(snakeBody.size() - 2).y;

		int changeX = lastBodyX - secondLastBodyX;
		int changeY = lastBodyY - secondLastBodyY;

		snakeBody.add(new Point(lastBodyX + changeX, lastBodyY + changeY));
		snakeColor.add(fruitColor);
		fruitX = randNum();
		fruitY = randNum();

		speed += .5;
		//System.out.println(speed);
		//System.out.println((int) (1000.0 / speed));
		timer.setDelay((int) (1000.0 / speed));
		score++;

	}

	public void resetBody() {

		snakeBody.clear();
		snakeColor.clear();
		snakeBody.add(new Point(250, 250));
		snakeBody.add(new Point(250, 260));
		snakeBody.add(new Point(250, 270));
		snakeBody.add(new Point(250, 280));
		
		for (int i = 0; i < snakeBody.size(); i++) {
			
			//snakeColor.add(Colors[(int) (Math.random() * 6)]);
			snakeColor.add(Color.WHITE);
			
		}
		
		head.x = 250;
		head.y = 250;
		deltaY = -bodySize;
		deltaX = 0;
		prevLoseKey = KeyEvent.VK_DOWN;

	}

	public int randNum() {

		return ((int) (Math.random() * 45)) * 10 + 10;
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(15));
		g2.drawRect(0, 0, 499, 477);
		g2.setStroke(new BasicStroke(2));
		
		
		
		if (startGame) {

			g.setFont(new Font("Joystix", Font.BOLD, 80));
			CenteredText title1 = new CenteredText("SNAKE!!", 500, 500, g,
					true, 180);
			drawColorOptions(g, 415);
			g.setFont(new Font("Joystix", Font.BOLD, 20));

			CenteredText start1 = new CenteredText("Press Enter to", 500, 500,
					g, true, 300);
			CenteredText start2 = new CenteredText("Start", 500, 500, g, true,
					330);

		} else if (playing || paused) {

			g.setFont(new Font("Joystix", Font.BOLD, 40));
			g.setColor(Color.WHITE);
			CenteredText score1 = new CenteredText(String.valueOf(score), 500,
					500, g, true, 450);
			int i = 0;
			for (Point body : snakeBody) {

				g.setColor(snakeColor.get(i));
				i++;
				g.fillRect(body.x, body.y, bodySize, bodySize);
				g.setColor(Color.BLACK);
				g.drawRect(body.x, body.y, bodySize, bodySize);
				g.drawRect(fruitX, fruitY, bodySize, bodySize);

				//g.setColor(Color.WHITE);
				g.setColor(fruitColor);
				g.fillRect(fruitX + 1, fruitY + 1, bodySize - 2, bodySize - 2);

				if (paused) {
					g.setFont(new Font("Joystix", Font.BOLD, 60));
					g.setColor(Color.WHITE);
					CenteredText pause = new CenteredText("Paused", 500, 500,
							g, true, 200);
					
					drawColorOptions(g, 300);
				}
			}

		} else if (endGame) {

			g.setFont(new Font("Joystix", Font.BOLD, 40));
			g.setColor(Color.WHITE);
			CenteredText score1 = new CenteredText(String.valueOf(score), 500,
					500, g, true, 450);

			g.setFont(new Font("Joystix", Font.BOLD, 60));

			CenteredText lose = new CenteredText("You Lose!", 500, 500, g,
					true, 170);

			g.setFont(new Font("Joystix", Font.BOLD, 26));

			CenteredText restart = new CenteredText("Enter to Restart", 500,
					500, g, true, 320);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == prevLoseKey) {

			playing = false;
			endGame = true;

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {

			deltaX = 0;
			deltaY = -bodySize;
			prevLoseKey = KeyEvent.VK_DOWN;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			deltaX = 0;
			deltaY = bodySize;
			prevLoseKey = KeyEvent.VK_UP;

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			deltaY = 0;
			deltaX = -bodySize;
			prevLoseKey = KeyEvent.VK_RIGHT;

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			deltaY = 0;
			deltaX = bodySize;
			prevLoseKey = KeyEvent.VK_LEFT;

		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (startGame) {

				playing = true;
				startGame = false;

			} else if (endGame) {

				resetBody();
				playing = true;
				endGame = false;
				fruitX = randNum();
				fruitY = randNum();
				speed = 10;
				score = 0;

			}

		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			playing = !playing;
			paused = !paused;
		} else {
			//if (startGame || endGame) {
			switch (e.getKeyCode()) {
			
			case KeyEvent.VK_R:
				fruitColor = Color.RED;
				
			break;
			case KeyEvent.VK_G:
				fruitColor = Color.GREEN;
				
				break;
			case KeyEvent.VK_B:
				fruitColor = Color.CYAN;
				
				break;
			case KeyEvent.VK_Y:
				fruitColor = Color.YELLOW;
				
				break;
			case KeyEvent.VK_O:
				fruitColor = Color.ORANGE;
				
				break;
			case KeyEvent.VK_W: //VK_W - White is default case
				fruitColor = Color.WHITE;
				
				break;
			
			}
			
			
		//}
		}
	}
	
	public void drawColorOptions(Graphics g, int colorY) {
		
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 45));
		g.setColor(Color.RED);
		g.drawString("R", 50, colorY);
		g.setColor(Color.GREEN);
		g.drawString("G", 140, colorY);
		g.setColor(Color.CYAN);
		g.drawString("B", 230, colorY);
		g.setColor(Color.YELLOW);
		g.drawString("Y", 315, colorY);
		g.setColor(Color.ORANGE);
		g.drawString("O", 410, colorY);
//		g.setColor(Color.BLACK);
//		g.drawString("W", 500, colorY);
		
		
		g.setColor(Color.WHITE);
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
