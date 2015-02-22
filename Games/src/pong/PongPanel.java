package pong;
import gameActions.Control;
import gameActions.PlayerInterface;

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

public class PongPanel extends PlayerInterface {

	//public int slopeX = (int) (Math.random() * 2) + 1;
//	public int slopeX = rand4or8();
//	public int slopeY = (int) (Math.random() * 2) + 1;
	// ////////////////////////////////
	public int startBallX = 400;
	public int ballX = startBallX;
	public int ballY = 250;
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

	public int player1X = p1DistanceFromSide;
	public int player1Y = paddleVerticalLocation;
	public int player1Height = paddleHeight;
	public int player1Width = paddleWidth;
	public int player1MiddleY = player1Y + player1Height/2;

	public int player1Score = 0;

	// ///////////////////////////////////////

	public int player2X = p2DistanceFromSide;
	public int player2Y = paddleVerticalLocation;
	public int player2Height = paddleHeight;
	public int player2Width = paddleWidth;

	public int player2Score = 0;

	// ///////////////////////////////////////

	public int paddleSpeed = 5;

	public PongPanel() {

		super();
		setSpeed(60);

	}
	@Override
	public void moves() {

		
			//System.out.println(deltaX);
			//System.out.println(deltaY);
			//System.out.println(slopeX);
			//System.out.println(slopeY);
			if (leftPressed && player1Y - paddleSpeed > 50)
				player1Y -= paddleSpeed;

			if (rightPressed
					&& player1Y + player1Height + paddleSpeed < getHeight() - 50)
				player1Y += paddleSpeed;

			if (upPressed && player2Y - paddleSpeed > 50)
				player2Y -= paddleSpeed;

			if (downPressed
					&& player2Y + player2Height + paddleSpeed < getHeight() - 50)
				player2Y += paddleSpeed;

			int nextBallLeft = ballX + deltaX;
			int nextBallRight = ballX + deltaX + diameter;
			int nextBallTop = ballY + deltaY;
			int nextBallBottom = ballY + deltaY + diameter;
			int nextBallMid = ballY + deltaY + diameter/2;

			int player1Right = player1X + player1Width;
			int player1Top = player1Y;
			int player1Bottom = player1Y + player1Height;
			
			int nextPlayer1Paddle = player1Y;
			int nextPlayer1PaddleMid = player1Y + paddleSpeed;
			
			if (computerPlayer && nextPlayer1Paddle > nextBallMid && nextBallLeft < computerXMove) {
				
				leftReleased();
			}
			if (computerPlayer && nextPlayer1PaddleMid < nextBallMid && nextBallLeft < computerXMove) {
				rightReleased();
			}
			
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
					ballXSpeed = rand4or8();
					ballYSpeed = rand4or8();
					//deltaX = ((((int) (Math.random() * 2 )) * 2) - 1) * ballXSpeed;
					deltaX = randDeltaX();
					deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * ballYSpeed;
					ballX = startBallX;
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
					ballXSpeed = rand4or8();
					ballYSpeed = rand4or8();
					//deltaX = ((((int) (Math.random() * 2 )) * 2) - 1) * ballXSpeed;
					deltaX = randDeltaX();
					deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * ballYSpeed;
					ballX = startBallX;
					ballY = 250;
					//nextBall = false;

				}
			}

			ballX += deltaX;
			ballY += deltaY;
		


		// ifStarted();

	}
	@Override
	public void drawPlaying(Graphics2D g) {
		
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
		
	}
	@Override
	public void drawEnd(Graphics2D g) {
		
		g.setFont(new Font("Joystix", Font.BOLD, 60));
		
		String playerWon = (player1Score > player2Score) ? "1" : "2";
		
		if (!computerPlayer) {
		CenteredText.draw("Player " + playerWon, 500, 500, g, true, 120);
		CenteredText.draw("You Win!", 500, 500, g, true, 210);
		//g.drawString("Player " + playerWon, playWon.x, 120);
		} else {
			
			if (player1Score > player2Score) {
			CenteredText.draw("Computer", 500, 500, g, true, 80);
			CenteredText.draw("Won!", 500, 500, g, true, 150);
			CenteredText.draw("You Lose!", 500, 500, g, true, 280);
			
			} else {
				
				CenteredText.draw("You Win!", 500, 500, g, true, 150);
			}
			computerPlayer = false;
		}
		
		
		//g.drawString("You Win!", win.x, 210);
		
		g.setFont(new Font("Joystix", Font.BOLD, 26));
		CenteredText.draw("Enter to restart", 500, 500, g, true, 350);
		//g.drawString("Enter to Restart", restart.x, 320);
		
	}
	@Override
	public void customPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_1 && (startGame || endGame)) {
			
			computerPlayer = true;
			computerXMove = 200;
			
			
		} else if (e.getKeyCode() == KeyEvent.VK_2 && (startGame || endGame)) {
			
			computerPlayer = true;
			computerXMove = 400;
			
			
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
		ballX = startBallX;
		ballY = 250;
		player1X = p1DistanceFromSide;
		player1Y = paddleVerticalLocation;
		player2X = p2DistanceFromSide;
		player2Y = paddleVerticalLocation;
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

}
