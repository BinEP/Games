package pong;
import gameActions.Control;
import gameActions.PlayerInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.Font;

import javax.lang.model.element.Element;
import javax.swing.JPanel;
import javax.swing.Timer;

import utilityClasses.CenteredText;

public class PongPanel extends PlayerInterface {

	//public int slopeX = (int) (Math.random() * 2) + 1;
//	public int slopeX = rand4or8();
//	public int slopeY = (int) (Math.random() * 2) + 1;
	// ////////////////////////////////
	public int startBallX = 400;
//	public int ballX = startBallX;
//	public int ballY = 250;
	
	public Rectangle ball = new Rectangle(startBallX, 250, 20, 20);
//	public Ellipse2D.Double ball = new Ellipse2D.Double(startBallX, 250, 20, 20);
	
	public int ballXSpeed = rand4or8();
	public int ballYSpeed = rand4or8();
	//public int ballXSpeed = (slopeX) * (4);
		//public int ballYSpeed = (slopeY) * (4);
	//public int deltaX = -Math.abs(((((int) (Math.random() * 2 )) * 2) - 1) * ballXSpeed);
	public int deltaX = randDeltaX();
	public int deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * ballYSpeed;
	public int diameter = 20;

	public boolean computerPlayer = false;
	
	public int computerXMove = 200;
	//public boolean nextBall = true;
	//public int countDown = 3;
	//public int countDownTiming = 20;

	public int paddleHeight = 100;
	public int paddleWidth = 15;
	public int paddleDistanceFromSide = 30;
	public int paddleVerticalLocation = 200;
	
	public int dashedY = 5;

	public int p1DistanceFromSide = paddleDistanceFromSide;
	public int p2DistanceFromSide = width - paddleDistanceFromSide - 10;

	// ///////////////////////////////////////

//	public int player1X = p1DistanceFromSide;
//	public int player1Y = paddleVerticalLocation;
//	public int player1Height = paddleHeight;
//	public int player1Width = paddleWidth;
	
	
	public Rectangle paddleLeft = new Rectangle(p1DistanceFromSide, paddleVerticalLocation, paddleWidth, paddleHeight);
	public int player1MiddleY = paddleLeft.y + paddleLeft.height / 2;
	
	public int player1Score = 0;

	// ///////////////////////////////////////

//	public int player2X = p2DistanceFromSide;
//	public int player2Y = paddleVerticalLocation;
//	public int player2Height = paddleHeight;
//	public int player2Width = paddleWidth;

	public Rectangle paddleRight = new Rectangle(width - 10 - p1DistanceFromSide, paddleVerticalLocation, paddleWidth, paddleHeight);
	
	public int player2Score = 0;

	// ///////////////////////////////////////

	public int paddleSpeed = 5;

	public PongPanel() {

		super();
		setSpeed(60);

	}
//	@Override
//	public void moves() {
//
//		
//			//System.out.println(deltaX);
//			//System.out.println(deltaY);
//			//System.out.println(slopeX);
//			//System.out.println(slopeY);
//			if (leftPressed && paddleLeft.y - paddleSpeed > 50)
//				paddleLeft.y -= paddleSpeed;
////
////			if (leftPressed && !paddleLeft.contains(paddleLeft.x + 5, 50)) {
////				paddleLeft.y -= paddleSpeed;
////			}
////			
////			if (rightPressed && !paddleLeft.contains(paddleLeft.x + 5, height - 50)) {
////				paddleLeft.y += paddleSpeed;
////			}
//			
//			if (rightPressed
//					&& paddleLeft.y + paddleLeft.height + paddleSpeed < height - 50)
//				paddleLeft.y += paddleSpeed;
//			
//			if (upPressed && paddleRight.y - paddleSpeed > 50)
//				paddleRight.y -= paddleSpeed;
//
//			if (downPressed
//					&& paddleRight.y + paddleRight.width + paddleSpeed < height - 50)
//				paddleRight.y += paddleSpeed;
//			
//			
//			
////			int nextBallLeft = ballX + deltaX;
////			int nextBallRight = ballX + deltaX + diameter;
////			int nextBallTop = ballY + deltaY;
////			int nextBallBottom = ballY + deltaY + diameter;
////			int nextBallMid = ballY + deltaY + diameter/2;
////
////			int player1Right = paddleLeft.x + paddleLeft.width;
////			int player1Top = paddleLeft.y;
////			int player1Bottom = paddleLeft.y + paddleLeft.height;
////			
////			int nextPlayer1Paddle = paddleLeft.y;
////			int nextPlayer1PaddleMid = paddleLeft.y + paddleSpeed;
//			
//			if (!outerbox.contains(ball)) {
//				if (outerbox.contains(ball.x, 250)) {
//					deltaY *= -1;
//				} else {
//					
//					scored();
//				}	
//			}
//			
//			if (computerPlayer && nextPlayer1Paddle > nextBallMid && nextBallLeft < computerXMove) {
//				
//				leftReleased();
//			}
//			if (computerPlayer && nextPlayer1PaddleMid < nextBallMid && nextBallLeft < computerXMove) {
//				rightReleased();
//			}
//			
//			int player2Left = paddleRight.x;
//			int player2Top = paddleRight.y;
//			int player2Bottom = paddleRight.y + paddleRight.width;
//
//			if (nextBallTop < 0 || nextBallBottom > getHeight())
//				deltaY *= -1;
//
//			if (nextBallLeft < player1Right) {
//
//				if (!(nextBallTop > player1Bottom || nextBallBottom < player1Top)) {
//
//					deltaX *= -1;
//
//				} else if (nextBallLeft < 0) {
//					// System.out.println("Score Player 2!");
//					player2Score++;
//					resetBall();
//					//nextBall = false;
//				}
//			}
//
//			if (nextBallRight > player2Left) {
//
//				if (!(nextBallTop > player2Bottom || nextBallBottom < player2Top)) {
//
//					deltaX *= -1;
//
//				} else if (nextBallRight > getWidth()) {
//
//					// System.out.println("Score Player 1!");
//					player1Score++;
//					resetBall();
//					//nextBall = false;
//
//				}
//			}
//
//			ballX += deltaX;
//			ballY += deltaY;
//		
//
//
//		// ifStarted();
//
//	}
	
	@Override
	public void moves() {
		
		ball.x += deltaX;
		ball.y += deltaY;
		
		
		if (upPressed && !paddleRight.contains(paddleRight.x + 5, 50)) {
			paddleRight.y -= paddleSpeed;
		}
		
		if (downPressed && !paddleRight.contains(paddleRight.x + 5, height - 50)) {
			paddleRight.y += paddleSpeed;
		}
		
		if (leftPressed && !paddleLeft.contains(paddleLeft.x + 5, 50)) {
			paddleLeft.y -= paddleSpeed;
		}
		
		if (rightPressed && !paddleLeft.contains(paddleLeft.x + 5, height - 50)) {
			paddleLeft.y += paddleSpeed;
		}
		
		if (computerPlayer) {
			
			if (paddleLeft.getMaxY() > ball.getCenterY()) {
				left();
			} else {
				leftReleased();
			}
			if (paddleLeft.getMinY() < ball.getCenterY()) {
				right();
			} else {
				rightReleased();
			}
			
			
		}
		
//		if (computerPlayer && nextPlayer1Paddle > nextBallMid && nextBallLeft < computerXMove) {
//			
//			leftReleased();
//		}
//		if (computerPlayer && nextPlayer1PaddleMid < nextBallMid && nextBallLeft < computerXMove) {
//			rightReleased();
//		}

		
		if (paddleLeft.intersects(ball) || paddleRight.intersects(ball)) {
			deltaX *= -1;
		}
		
		if (!outerbox.contains(ball)) {
			if (outerbox.contains(ball.x, 250)) {
				deltaY *= -1;
			} else {
				
				scored();
			}	
		}
		
	}
	
	public void scored() {
		
		if (ball.x < 250) {
			player2Score++;
		} else {
			player1Score++;
		}
		
		ballXSpeed = rand4or8();
		ballYSpeed = rand4or8();
		//deltaX = ((((int) (Math.random() * 2 )) * 2) - 1) * ballXSpeed;
		deltaX = randDeltaX();
		deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * ballYSpeed;
		ball.x = startBallX;
		ball.y = 250;
		
	}
	@Override
	public void drawPlaying(Graphics2D g) {
		
		g.fillOval(ball.x, ball.y, diameter, diameter);
//		g.fillRect(paddleLeft.x, paddleLeft.y, paddleLeft.width, paddleLeft.height);
//		g.fillRect(paddleRight.x, paddleRight.y, paddleRight.width, paddleRight.width);
		
		g.fill(paddleLeft);
		g.fill(paddleRight);
		/*
		 * for (dashedY = 5; dashedY < getHeight(); dashedY += 34) {
		 * g.fillRect(248, dashedY, 5, 15); }
		 */
		g.fillRect(248, 0, 5, getHeight());
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
		g.drawString(String.valueOf(player1Score), 205 - 32 * (spacing()),
				420);
		g.drawString(String.valueOf(player2Score), 269, 420);
		
	}
	@Override
	public void drawEnd(Graphics2D g) {
		
		g.setFont(new Font("Joystix", Font.BOLD, 60));
		
		String playerWon = (player1Score > player2Score) ? "1" : "2";
		
		if (!computerPlayer) {
		CenteredText.draw("Player " + playerWon, 120, g);
		CenteredText.draw("You Win!", 210, g);
		//g.drawString("Player " + playerWon, playWon.x, 120);
		} else {
			
			if (player1Score > player2Score) {
			CenteredText.draw("Computer", 80, g);
			CenteredText.draw("Won!", 150, g);
			CenteredText.draw("You Lose!", 280, g);
			
			} else {
				
				CenteredText.draw("You Win!", 150, g);
			}
			computerPlayer = false;
		}
		
		
		//g.drawString("You Win!", win.x, 210);
		
		g.setFont(new Font("Joystix", Font.BOLD, 26));
		CenteredText.draw("Enter to restart", 350, g);
		//g.drawString("Enter to Restart", restart.x, 320);
		
	}
//	@Override
//	public void customPressed(KeyEvent e) {
//
//		if (e.getKeyCode() == KeyEvent.VK_1 && (startGame || endGame)) {
//			
//			computerPlayer = true;
//			computerXMove = 200;
//			
//			
//		} else if (e.getKeyCode() == KeyEvent.VK_2 && (startGame || endGame)) {
//			
//			computerPlayer = true;
//			computerXMove = 400;
//			
//			
//		}
//	}

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
	public int rand4or8() {
		return ((int) (Math.random() * 2) + 1) * (4);
		
		
	}
	
	public int randDeltaX() {
		int pos = ((((int) (Math.random() * 2 )) * 2) - 1);
		startBallX = 250 + (pos * 150);
		return -pos * Math.abs(((((int) (Math.random() * 2 )) * 2) - 1) * ballXSpeed);
		
	}

	

	
	
	@Override
	public boolean checkIfDead() {
		// TODO Auto-generated method stub
		return player1Score >= 11 || player2Score >= 11
				&& Math.abs(player1Score - player2Score) > 1;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		setup();
	}

	

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
		leftKey = KeyEvent.VK_W;
		rightKey = KeyEvent.VK_S;
		player1Score = 0;
		player2Score = 0;
		ball = new Rectangle(startBallX, 250, 20, 20);
		ball.x = startBallX;
		ball.y = 250;
		
		paddleLeft = new Rectangle(p1DistanceFromSide, paddleVerticalLocation, paddleWidth, paddleHeight);
		paddleRight = new Rectangle(width - 10 - p1DistanceFromSide, paddleVerticalLocation, paddleWidth, paddleHeight);

		paddleLeft.x = p1DistanceFromSide;
		paddleLeft.y = paddleVerticalLocation;
		paddleRight.x = p2DistanceFromSide;
		paddleRight.y = paddleVerticalLocation;
		//countDown = 3;
		//countDownTiming = 20;
		ballXSpeed = rand4or8();
		ballYSpeed = rand4or8();
		//deltaX = ((((int) (Math.random() * 2 )) * 2) - 1) * ballXSpeed;
		deltaX = randDeltaX();
		deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * ballYSpeed;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return "Pong";
	}

}
