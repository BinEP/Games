package pong;
import gameActions.PlayerInterface;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.Font;

import utilityClasses.CenteredText;

public class PongPanel extends PlayerInterface {

	public int startBallX = 400;
	public Rectangle ball = new Rectangle(startBallX, 250, 20, 20);
	
	public int ballXSpeed = rand4or8();
	public int ballYSpeed = rand4or8();
	
	public int deltaX = randDeltaX();
	public int deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * ballYSpeed;
	public int diameter = 20;

	public boolean computerPlayer = false;
	
	public int computerXMove = 200;
	
	public int paddleHeight = 100;
	public int paddleWidth = 15;
	public int paddleDistanceFromSide = 30;
	public int paddleVerticalLocation = 200;
	public int paddleSpeed = 5;
		
	public int p1DistanceFromSide = paddleDistanceFromSide;
	public int p2DistanceFromSide = width - 10 - paddleDistanceFromSide;
	
	public Rectangle paddleLeft = new Rectangle(p1DistanceFromSide, paddleVerticalLocation, paddleWidth, paddleHeight);
	public Rectangle paddleRight = new Rectangle(p2DistanceFromSide, paddleVerticalLocation, paddleWidth, paddleHeight);
	
	public int player1Score = 0;
	public int player2Score = 0;

	public PongPanel() {
		super();
	}

	@Override
	public void moves() {
		
		ball.x += deltaX;
		ball.y += deltaY;
		
		if (upPressed && !paddleRight.contains(paddleRight.x + 5, 50)) {
			paddleRight.translate(0, -paddleSpeed);
		}
		
		if (downPressed && !paddleRight.contains(paddleRight.x + 5, height - 50)) {
			paddleRight.translate(0, paddleSpeed);
		}
		
		if (leftPressed && !paddleLeft.contains(paddleLeft.x + 5, 50)) {
			paddleLeft.translate(0, -paddleSpeed);
		}
		
		if (rightPressed && !paddleLeft.contains(paddleLeft.x + 5, height - 50)) {
			paddleLeft.translate(0, paddleSpeed);
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
		deltaX = randDeltaX();
		deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * ballYSpeed;
		ball.x = startBallX;
		ball.y = 250;
	}
	
	@Override
	public void drawPlaying(Graphics2D g) {
		
		Ellipse2D.Double e = new Ellipse2D.Double(ball.x, ball.y, diameter, diameter);
		
		g.fill(e);
		g.fill(paddleLeft);
		g.fill(paddleRight);
	
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
		
		g.setFont(new Font("Joystix", Font.BOLD, 26));
		CenteredText.draw("Enter to restart", 350, g);
	}

	public int spacing() {
		int spacer = player1Score / 10;
		int spaces = 0;
		while (spacer > 0) {
			spaces++;
			spacer /= 10;
		}
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
		return player1Score >= 11 || player2Score >= 11
				&& Math.abs(player1Score - player2Score) > 1;
	}

	@Override
	public void reset() {
		setup();
	}

	

	@Override
	public void setup() {
		
		leftKey = KeyEvent.VK_W;
		rightKey = KeyEvent.VK_S;
		
		player1Score = 0;
		player2Score = 0;
		
		ball = new Rectangle(startBallX, 250, 20, 20);
		ball.setLocation(startBallX, 250);
		
		paddleLeft = new Rectangle(p1DistanceFromSide, paddleVerticalLocation, paddleWidth, paddleHeight);
		paddleRight = new Rectangle(width - 10 - p1DistanceFromSide, paddleVerticalLocation, paddleWidth, paddleHeight);

		paddleLeft.setLocation(p1DistanceFromSide, paddleVerticalLocation);
		paddleRight.setLocation(p2DistanceFromSide, paddleVerticalLocation);
		
		ballXSpeed = rand4or8();
		ballYSpeed = rand4or8();

		deltaX = randDeltaX();
		deltaY = ((((int) (Math.random() * 2 )) * 2) - 1) * ballYSpeed;
	}

	@Override
	public void draw(Graphics2D g) {}
	@Override
	public String getGameName() {
		return "Pong";
	}

}
