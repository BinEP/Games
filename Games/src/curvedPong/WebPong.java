package curvedPong;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WebPong extends JPanel implements ActionListener, KeyListener {

	private boolean upPressed = false;
	private boolean downPressed = false;
	private boolean wPressed = false;
	private boolean sPressed = false;

	private int ballX = 250;
	private int ballY = 250;
	private int diameter = 20;
	private int ballDeltaX = -1;
	private int ballDeltaY = 3;

	private int playerOneX = 25;
	private int playerOneY = 250;
	private int playerOneWidth = 10;
	private int playerOneHeight = 50;

	private int playerTwoX = 465;
	private int playerTwoY = 250;
	private int playerTwoWidth = 10;
	private int playerTwoHeight = 50;

	private int paddleSpeed = 5;

	// construct a PongPanel
	public WebPong() {
		setBackground(Color.BLACK);

		// listen to key presses
		setFocusable(true);
		addKeyListener(this);

		// call step() 60 fps
		Timer timer = new Timer(1000 / 60, this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		step();
	}

	public void step() {

		// move player 1
		if (upPressed) {
			if (playerOneY - paddleSpeed > 0) {
				playerOneY -= paddleSpeed;
			}
		}
		if (downPressed) {
			if (playerOneY + paddleSpeed + playerOneHeight < getHeight()) {
				playerOneY += paddleSpeed;
			}
		}

		// move player 2
		if (wPressed) {
			if (playerTwoY - paddleSpeed > 0) {
				playerTwoY -= paddleSpeed;
			}
		}
		if (sPressed) {
			if (playerTwoY + paddleSpeed + playerTwoHeight < getHeight()) {
				playerTwoY += paddleSpeed;
			}
		}

		// where will the ball be after it moves?
		
		int nextBallLeft = ballX + ballDeltaX;
		int nextBallRight = ballX + diameter + ballDeltaX;
		int nextBallTop = ballY + ballDeltaY;
		int nextBallBottom = ballY + diameter + ballDeltaY;

		int playerOneRight = playerOneX + playerOneWidth;
		int playerOneTop = playerOneY;
		int playerOneBottom = playerOneY + playerOneHeight;

		float playerTwoLeft = playerTwoX;
		float playerTwoTop = playerTwoY;
		float playerTwoBottom = playerTwoY + playerTwoHeight;

		// ball bounces off top and bottom of screen
		if (nextBallTop < 0 || nextBallBottom > getHeight()) {
			ballDeltaY *= -1;
		}

		// will the ball go off the left side?
		if (nextBallLeft < playerOneRight) {
			// is it going to miss the paddle?
			if (nextBallTop > playerOneBottom || nextBallBottom < playerOneTop) {

				System.out.println("PLAYER TWO SCORED");

				ballX = 250;
				ballY = 250;
			} else {
				ballDeltaX *= -1;
			}
		}

		// will the ball go off the right side?
		if (nextBallRight > playerTwoLeft) {
			// is it going to miss the paddle?
			if (nextBallTop > playerTwoBottom || nextBallBottom < playerTwoTop) {

				System.out.println("PLAYER ONE SCORED");

				ballX = 250;
				ballY = 250;
			} else {
				ballDeltaX *= -1;
			}
		}

		// move the ball
		ballX += ballDeltaX;
		ballY += ballDeltaY;

		// stuff has moved, tell this JPanel to repaint itself
		repaint();
	}

	// paint the ball and paddle
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);

		g.fillOval(ballX, ballY, diameter, diameter);

		g.fillRect(playerOneX, playerOneY, playerOneWidth, playerOneHeight);
		g.fillRect(playerTwoX, playerTwoY, playerTwoWidth, playerTwoHeight);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			wPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			sPressed = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			wPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			sPressed = false;
		}
	}

}