package tunnelRunner;

import gameActions.Game;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.Timer;

import utilityClasses.*;

public class TunnelPanel extends Game {

	private int holeX = 500;
	private int holeY = 220;

	private int widthOfHole = 5;
	private int holeNumber = 500 / widthOfHole;
	private int holeSize = 150;

	private int[] holesX = new int[holeNumber];
	private int[] holesY = new int[holeNumber];

	/*
	 * private int[] holesX = { 500, 500 + (15), 500 + (15) * 2, 500 + (15) * 3,
	 * 500 + (15) * 4, 500 + (15) * 5, 500 + (15) * 6, 500 + (15) * 7, 500 +
	 * (15) * 8, 500 + (15) * 9, 500 + (15) * 10, 500 + (15) * 11, 500 + (15) *
	 * 12, 500 + (15) * 13, 500 + (15) * 14, 500 + (15) * 15};
	 * 
	 * private int[] holesY = { 220, 230, 240, 230, 240, 230, 220, 230, 240,
	 * 230, 240, 230, 220, 230, 240, 250};
	 */
	private int ballX = 20;
	private int ballY = 40;
	private int deltaX = 0;
	private int deltaY = 0;
	private int diameter = 15;
	private int buffer = 0;

	private int ballSpeed = 5;
	private int origBallSpeed = ballSpeed;
	private int holeSpeed = 5;
	private int origHoleSpeed = holeSpeed;

	public TunnelPanel() {

		super();
	}

	
	public void moves() {

		
			int nextBallX = ballX + deltaX;
			int nextBallY = ballY + deltaY;

			

			// System.out.println(topRightColor.toString() + "   ");

			

			if (upPressed) {
				deltaY = -ballSpeed;
			} else if (downPressed) {
				deltaY = ballSpeed;
			} else {
				deltaY = 0;
			}

			for (int i = 0; i < holesX.length; i++) {

				if (holesX[i] <= 0) {
					holesX[i] = 500 + holesX[i];
					holesY[i] = randomY(i);

				}

				holesX[i] -= holeSpeed;

			}


			// holeSpeed = (int) (timeSeconds / 10) + 4;

			if (ballY + deltaY + diameter > 0)
				ballY += deltaY;

			// int ballSpeedChange = (int) (timeSeconds / 10);
			// System.out.println(ballSpeed);

		

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
			i = holesY.length - 1;
		int prevHole = holesY[i - 1];
		int wayPrevHole = prevHole;
		/*
		 * try { if (i - 30 < 0) { i = 124 - i; } wayPrevHole = holesY[i]; }
		 * catch (ArrayIndexOutOfBoundsException e) {
		 * 
		 * }
		 */
		// && Math.abs(randNum - wayPrevHole) > 60
		int randNum = ((int) (Math.random() * 300));
		while (Math.abs(randNum - prevHole) > 20) {
			randNum = ((int) (Math.random() * 300));
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
		
		int leftX = ballX + deltaX;
		int rightX = ballX + deltaX + diameter;
		int topY = ballY + deltaY;
		int bottomY = ballY + deltaY + diameter;

		Color topLeftColor = getColor(leftX + buffer, topY + buffer);
		Color topRightColor = getColor(rightX - buffer, topY + buffer);
		Color bottomLeftColor = getColor(leftX + buffer, bottomY - buffer);
		Color bottomRightColor = getColor(rightX - buffer, bottomY - buffer);
		
		return (topLeftColor.equals(Color.WHITE)
				|| topRightColor.equals(Color.WHITE)
				|| bottomLeftColor.equals(Color.WHITE)
				|| bottomRightColor.equals(Color.WHITE));
			
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		setup();
		resetTime();
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPlaying(Graphics2D g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < holesX.length; i++) {

			g.setColor(Color.WHITE);
			g.fillRect(holesX[i], 0, widthOfHole, 500);
			g.setColor(Color.BLACK);

			g.fillRect(holesX[i], holesY[i], widthOfHole, holeSize);
		}
		g.setColor(Color.WHITE);

		g.fillOval(ballX, ballY, diameter, diameter);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Joystix", Font.BOLD, 20));
		FontMetrics f = g.getFontMetrics();
		int w = f.stringWidth(String.valueOf(getTime()));
		int h = f.getAscent();

		g.fillRect(3, 3, w + 3, h);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Joystix", Font.BOLD, 20));
		g.drawString(String.valueOf(getTime()), 5, 20);

	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		for (int i = 0; i < holeNumber; i++) {
			holesX[i] = 500 + widthOfHole * i;
			holesY[i] = randomY(i);

		}
		ballY = 40;
		
	}

	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return "Tunnel Runner";
	}


	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return getTime();
	}

}
