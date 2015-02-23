package holeInTheWall;

import gameActions.Game;

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
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.Timer;

import utilityClasses.*;

public class HolePanel extends Game {

	
	
	private int holeX = 500;
	private int holeY = 220;

	private int holeNumber = 3;
	private int[] holesX = { 500, 500 + (170), 500 + (170) * 2 };

	private int[] holesY = { 220, 270, 250 };

	private int ballX = 20;
	private int ballY = 240;
	private int deltaX = 0;
	private int deltaY = 0;
	private int diameter = 20;
	private int buffer = 0;

	private int currentHole = 0;

	private int ballSpeed = 5;
	private int holeSpeed = 4;

	
	public HolePanel() {

		super();

	}



	public void moves() {

			int nextBallX = ballX + deltaX;
			int nextBallY = ballY + deltaY;
			int nextBallCenterX = nextBallX + diameter / 2;
			int nextBallCenterY = nextBallY + diameter / 2;

			int leftX = ballX + deltaX;
			int rightX = ballX + deltaX + diameter;
			int topY = ballY + deltaY;
			int bottomY = ballY + deltaY + diameter;
			/*
			 * Color topLeftColor = getColor(leftX + buffer, topY + buffer);
			 * Color topRightColor = getColor(rightX - buffer, topY + buffer);
			 * Color bottomLeftColor = getColor(leftX + buffer, bottomY -
			 * buffer); Color bottomRightColor = getColor(rightX - buffer,
			 * bottomY - buffer);
			 */
			// System.out.println(topRightColor.toString() + "   ");

			/*
			 * if (topLeftColor.equals(Color.WHITE) ||
			 * topRightColor.equals(Color.WHITE) ||
			 * bottomLeftColor.equals(Color.WHITE) ||
			 * bottomRightColor.equals(Color.WHITE)) { playing = false; endGame
			 * = true;
			 * 
			 * }
			 */

			if (upPressed) {
				deltaY = -ballSpeed;
			} else if (downPressed) {
				deltaY = ballSpeed;
			} else {
				deltaY = 0;
			}

			// int holeLeft = holesX[currentHole];
			// int holeRight = holesX[currentHole] + 15;
			// int holeMiddleY = 50 + holesY[currentHole];
			//
			// if (holeLeft < rightX) {
			// if (leftX < holeRight) {
			// if ( distance(nextBallCenterX, nextBallCenterY, holeLeft + 7,
			// holeMiddleY) > 40) {
			// playing = false;
			// endGame = true;
			// }
			//
			// } else {
			// currentHole = (currentHole == 2) ? 0 : currentHole + 1;
			// }
			//
			//
			//
			//
			// }

			for (int i = 0; i < holesX.length; i++) {

				if (holesX[i] <= 0) {
					holesX[i] = 500;
					holesY[i] = randomY(i);

				}

				holesX[i] -= holeSpeed;

			}

			
			holeSpeed = (int) (getTime() / 10) + 4;

			if (ballY + deltaY + diameter > 0)
				ballY += deltaY;

			// int ballSpeedChange = (int) (timeSeconds / 10);
			// System.out.println(ballSpeed);

		

	}

	public double distance(int ballCenterX, int ballCenterY, int boxCenterX,
			int boxCenterY) {

		return Math.sqrt(Math.pow(ballCenterX - boxCenterX, 2)
				+ Math.pow(ballCenterY - boxCenterY, 2));
	}


	
	
	
	public int randomY(int i) {
		// System.out.println(((int) (Math.random() * 6)) * 80);
		/*
		 * int firstX = holesX[0]; holesX[0] = holesX[1]; holesX[1] = holesX[2];
		 * holesX[2] = firstX;
		 * 
		 * int firstY = holesY[0]; holesY[0] = holesY[1]; holesY[1] = holesY[2];
		 * holesY[2] = firstY;
		 */
		if (i == 0)
			i = 3;
		int prevHole = holesY[i - 1];
		int randNum = ((int) (Math.random() * 400));
		while (Math.abs(randNum - prevHole) > 200) {
			randNum = ((int) (Math.random() * 400));
		}
		return randNum;

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



	@Override
	public boolean checkIfDead() {
		// TODO Auto-generated method stub
		
		int nextBallX = ballX + deltaX;
		int nextBallY = ballY + deltaY;
		int nextBallCenterX = nextBallX + diameter / 2;
		int nextBallCenterY = nextBallY + diameter / 2;
		
		
		for (int i = 0; i < holesX.length; i++) {

			if (distance(nextBallCenterX, nextBallCenterY, holesX[i] + 7,
					holesY[i]) - diameter / 2 < 0
					|| distance(nextBallCenterX, nextBallCenterY,
							holesX[i] + 7, holesY[i] + 100) - diameter / 2 < 0
					|| getColor(ballX + deltaX + diameter,
							ballY + deltaY + diameter / 2).equals(
							Color.WHITE)) {

				return true;

			}
		}
		return false;
	}



	@Override
	public void reset() {
		// TODO Auto-generated method stub
		setup();
	}



	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void drawPlaying(Graphics2D g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < holeNumber; i++) {

			g.setColor(Color.WHITE);
			g.fillRect(holesX[i], 0, 15, 500);
			g.setColor(Color.BLACK);

			g.fillRect(holesX[i], holesY[i], 15, 100);
		}
		g.setColor(Color.WHITE);

		g.fillOval(ballX, ballY, diameter, diameter);

		g.setFont(new Font("Joystix", Font.BOLD, 15));
		g.drawString(String.valueOf(getTime()), 5, 15);
	}



	@Override
	public void setup() {
		// TODO Auto-generated method stub
		holeX = 500;
		for (int i = 0; i < holeNumber; i++) {
			holesX[i] = 500 + (170) * i;
			holesY[i] = randomY(i);
		}
		holeSpeed = 4;
		ballSpeed = 5;
	}



	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return "Hole In The Wall";
	}

}
