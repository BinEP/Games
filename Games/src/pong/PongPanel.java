package pong;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

import javax.lang.model.element.Element;
import javax.swing.JPanel;
import javax.swing.Timer;

import utilityClasses.CenteredText;

public class PongPanel extends JPanel implements ActionListener, KeyListener {

	private int ballX = 250;
	private int ballY = 250;
	private int deltaX = ((((int) (Math.random() * 2 )) * 2) - 1) * 6;
	private int deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * 3;;
	private int diameter = 20;

	private int widthOfFrame = 500;

	private boolean startScreen = true;
	private boolean playing = false;
	private boolean endGame = false;
	//private boolean nextBall = true;
	//private int countDown = 3;
	//private int countDownTiming = 20;

	private int paddleHeight = 100;
	private int paddleWidth = 15;
	private int paddleDistanceFromSide = 30;
	private int paddleVerticalLocation = 200;
	private int dashedY = 5;

	private int p1DistanceFromSide = paddleDistanceFromSide;
	private int p2DistanceFromSide = widthOfFrame - paddleDistanceFromSide - 10;

	// ///////////////////////////////////////
	private boolean WPressed = false;
	private boolean SPressed = false;

	private int player1X = p1DistanceFromSide;
	private int player1Y = paddleVerticalLocation;
	private int player1Height = paddleHeight;
	private int player1Width = paddleWidth;

	private int player1Score = 0;

	// ///////////////////////////////////////
	private boolean UpPressed = false;
	private boolean DownPressed = false;

	private int player2X = p2DistanceFromSide;
	private int player2Y = paddleVerticalLocation;
	private int player2Height = paddleHeight;
	private int player2Width = paddleWidth;

	private int player2Score = 0;

	// ///////////////////////////////////////

	private int paddleSpeed = 5;

	public PongPanel() {

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

		if (playing) {
			if (WPressed && player1Y - paddleSpeed > 0)
				player1Y -= paddleSpeed;

			if (SPressed
					&& player1Y + player1Height + paddleSpeed < getHeight())
				player1Y += paddleSpeed;

			if (UpPressed && player2Y - paddleSpeed > 0)
				player2Y -= paddleSpeed;

			if (DownPressed
					&& player2Y + player2Height + paddleSpeed < getHeight())
				player2Y += paddleSpeed;

			int nextBallLeft = ballX + deltaX;
			int nextBallRight = ballX + deltaX + diameter;
			int nextBallTop = ballY + deltaY;
			int nextBallBottom = ballY + deltaY + diameter;

			int player1Right = player1X + player1Width;
			int player1Top = player1Y;
			int player1Bottom = player1Y + player1Height;

			int player2Left = player2X;
			int player2Top = player2Y;
			int player2Bottom = player2Y + player2Height;

			if (nextBallTop < 0 || nextBallBottom > getHeight())
				deltaY *= -1;

			if (nextBallLeft < player1Right) {

				if (!(nextBallTop > player1Bottom || nextBallBottom < player1Top)) {

					deltaX *= -1;

				} else if (nextBallLeft < 0) {
					// System.out.println("Score Player 2!");
					player2Score++;
					gameEnds();
					deltaX = ((((int) (Math.random() * 2 )) * 2) - 1) * 6;
					deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * 3;
					ballX = 250;
					ballY = 250;
					//nextBall = false;
				}
			}

			if (nextBallRight > player2Left) {

				if (!(nextBallTop > player2Bottom || nextBallBottom < player2Top)) {

					deltaX *= -1;

				} else if (nextBallRight > getWidth()) {

					// System.out.println("Score Player 1!");
					player1Score++;
					gameEnds();
					deltaX = ((((int) (Math.random() * 2 )) * 2) - 1) * 6;
					deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * 3;
					ballX = 250;
					ballY = 250;
					//nextBall = false;

				}
			}

			ballX += deltaX;
			ballY += deltaY;
		}

		repaint();

		// ifStarted();

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);

		if (startScreen) {
			
			g.setFont(new Font("Joystix", Font.BOLD, 120));
			CenteredText pong = new CenteredText("PONG", 500, 500, g, true, 180);
			//g.drawString("PONG", pong.x, pong.y);
			
			g.setFont(new Font("Joystix", Font.BOLD, 20));
			
			CenteredText pressStart = new CenteredText("Press Enter to", 500, 500, g, true, 250);
			//g.drawString("Press Enter to", pressStart.x, 250);
			
			CenteredText start = new CenteredText("Start", 500, 500, g, true, 280);
			//g.drawString("Start", start.x, 280);
			//System.out.println(deltaX + "\t" + deltaY);
			
		} else if (playing) {
			
			/*
			if (countDown > 0) {
				g.setFont(new Font(Font.DIALOG, Font.BOLD, 80));
				g.drawString(String.valueOf(countDown), 245, 230);
				
				if (countDownTiming == 0) {
					countDown--;
					countDownTiming = 60;
				} else {
					countDownTiming--;
				}
			}
			*/
			
			g.fillOval(ballX, ballY, diameter, diameter);
			g.fillRect(player1X, player1Y, player1Width, player1Height);
			g.fillRect(player2X, player2Y, player2Width, player2Height);

			/*
			 * for (dashedY = 5; dashedY < getHeight(); dashedY += 34) {
			 * g.fillRect(248, dashedY, 5, 15); }
			 */
			g.fillRect(248, 0, 5, getHeight());
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
			g.drawString(String.valueOf(player1Score), 205 - 32 * (spacing()),
					420);
			g.drawString(String.valueOf(player2Score), 269, 420);

		} else if (endGame) {
			
			g.setFont(new Font("Joystix", Font.BOLD, 60));
			
			String playerWon = (player1Score > player2Score) ? "1" : "2";
			
			CenteredText playWon = new CenteredText("Player " + playerWon, 500, 500, g, true, 120);
			//g.drawString("Player " + playerWon, playWon.x, 120);
			
			CenteredText win = new CenteredText("You Win!", 500, 500, g, true, 210);
			//g.drawString("You Win!", win.x, 210);
			
			g.setFont(new Font("Joystix", Font.BOLD, 26));
			CenteredText restart = new CenteredText("Enter to restart", 500, 500, g, true, 320);
			//g.drawString("Enter to Restart", restart.x, 320);
			
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			UpPressed = true;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			DownPressed = true;

		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			WPressed = true;

		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			SPressed = true;

		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			if (startScreen) {
			playing = true;
			startScreen = false;
			} else if (endGame) {
				
				playing = true;
				player1Score = 0;
				player2Score = 0;
				ballX = 250;
				ballY = 250;
				player1X = p1DistanceFromSide;
				player1Y = paddleVerticalLocation;
				player2X = p2DistanceFromSide;
				player2Y = paddleVerticalLocation;
				//countDown = 3;
				//countDownTiming = 20;
				deltaX = ((((int) (Math.random() * 2 )) * 2) - 1) * 6;
				deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * 3;
				
				
			}
			
		}
	}

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			UpPressed = false;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			DownPressed = false;

		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			WPressed = false;

		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			SPressed = false;

		}

	}

	public int spacing() {
		int spacer = player1Score / 10;
		int spaces = 0;
		while (spacer > 0) {

			spaces++;
			spacer /= 10;

		}

		// if (spacer > 0) spacer = 1;

		return spaces;

	}

	public void gameEnds() {

		if (player1Score >= 11 || player2Score >= 11
				&& Math.abs(player1Score - player2Score) > 1) {
			playing = false;
			endGame = true;

		}

	}

}
