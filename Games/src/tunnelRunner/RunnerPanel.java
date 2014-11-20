package tunnelRunner;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.Timer;

import utilityClasses.CenteredText;

public class RunnerPanel extends JPanel implements ActionListener, KeyListener {

	private boolean UpPressed = false;
	private boolean DownPressed = false;

	private boolean startGame = true;
	private boolean playing = false;
	private boolean endGame = false;

	private int holeX = 500;
	private int holeY = 220;

	private int widthOfHole = 5;
	private int holeNumber = 500/widthOfHole;
	private int holeSize = 150;
	
	private int[] holesX = new int[holeNumber];
	private int[] holesY = new int[holeNumber];
	
	/*private int[] holesX = { 500, 500 + (15), 500 + (15) * 2, 500 + (15) * 3,
			500 + (15) * 4, 500 + (15) * 5, 500 + (15) * 6, 500 + (15) * 7,
			500 + (15) * 8, 500 + (15) * 9, 500 + (15) * 10, 500 + (15) * 11,
			500 + (15) * 12, 500 + (15) * 13, 500 + (15) * 14, 500 + (15) * 15};

	private int[] holesY = { 220, 230, 240, 230, 240, 230, 220, 230, 240, 230, 240, 230, 220, 230, 240, 250};
*/
	private int ballX = 20;
	private int ballY = 40;
	private int deltaX = 0;
	private int deltaY = 0;
	private int diameter = 15;
	private int buffer = 0;

	private int ballSpeed = 4;
	private int origBallSpeed = ballSpeed;
	private int holeSpeed = 5;
	private int origHoleSpeed = holeSpeed;

	private int timeSplit = 0;
	private int timeSeconds = 0;

	public RunnerPanel() {

		
		for (int i = 0; i < holesX.length; i++) {
			holesX[i] = 500 + widthOfHole * i;
			holesY[i] = randomY(i);
			
		}
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
			int nextBallX = ballX + deltaX;
			int nextBallY = ballY + deltaY;

			int leftX = ballX + deltaX;
			int rightX = ballX + deltaX + diameter;
			int topY = ballY + deltaY;
			int bottomY = ballY + deltaY + diameter;

			Color topLeftColor = getColor(leftX + buffer, topY + buffer);
			Color topRightColor = getColor(rightX - buffer, topY + buffer);
			Color bottomLeftColor = getColor(leftX + buffer, bottomY - buffer);
			Color bottomRightColor = getColor(rightX - buffer, bottomY - buffer);

			// System.out.println(topRightColor.toString() + "   ");

			if (topLeftColor.equals(Color.WHITE)
					|| topRightColor.equals(Color.WHITE)
					|| bottomLeftColor.equals(Color.WHITE)
					|| bottomRightColor.equals(Color.WHITE)) {
				playing = false;
				endGame = true;

			}

			if (UpPressed) {
				deltaY = -ballSpeed;
			} else if (DownPressed) {
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

			timeSplit++;
			if (timeSplit == 60) {
				timeSplit = 0;
				timeSeconds++;
			}

			// holeSpeed = (int) (timeSeconds / 10) + 4;

			if (ballY + deltaY + diameter > 0)
				ballY += deltaY;

			// int ballSpeedChange = (int) (timeSeconds / 10);
			// System.out.println(ballSpeed);

		}
		repaint();

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);

		if (startGame) {

			g.setFont(new Font("Joystix", Font.BOLD, 40));
			CenteredText title1 = new CenteredText("HOLE IN THE", 500, 500, g,
					true, 150);
			// g.drawString("HOLE IN THE", 60, 210);
			CenteredText title2 = new CenteredText("WALL", 500, 500, g, true,
					200);
			// g.drawString("WALL", 180, 260);
			g.setFont(new Font("Joystix", Font.BOLD, 20));

			CenteredText start1 = new CenteredText("Press Enter to", 500, 500,
					g, true, 300);
			// g.drawString("Press Enter to", 120, 300);
			CenteredText start2 = new CenteredText("Start", 500, 500, g, true,
					330);
			// g.drawString("Start", 200, 330);

		} else if (playing) {

			// g.fillRect(holeX, holeY + 100, 15, 500 - holeY - 100);

			/*
			 * g.fillRect(leftX, topY, 1, 1); g.fillRect(leftX, bottomY, 1, 1);
			 * g.fillRect(rightX, topY, 1, 1); g.fillRect(rightX, bottomY, 1,
			 * 1);
			 */

			for (int i = 0; i < holesX.length; i++) {

				g.setColor(Color.WHITE);
				g.fillRect(holesX[i], 0, widthOfHole, 500);
				g.setColor(Color.BLACK);

				g.fillRect(holesX[i], holesY[i], widthOfHole, holeSize);
			}
			g.setColor(Color.WHITE);

			g.fillOval(ballX, ballY, diameter, diameter);
			
			
			g.setColor(Color.RED);
			g.setFont(new Font("Joystix", Font.BOLD, 20));
			g.drawString(String.valueOf(timeSeconds), 5, 20);

		} else if (endGame) {

			g.setColor(Color.RED);
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
			// g.drawString("Enter to Restart", 80, 400);

		}

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			UpPressed = true;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			DownPressed = true;

		}
	}

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			UpPressed = false;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			DownPressed = false;

		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (endGame) {
				holeX = 500;
				for (int i = 0; i < holesX.length; i++) {
					holesX[i] = 500 + (widthOfHole) * i;
					holesY[i] = randomY(i);
				}
				holeSpeed = origHoleSpeed;
				ballSpeed = origBallSpeed;
				timeSplit = 0;
				timeSeconds = 0;

			}
			startGame = false;
			playing = true;

		}

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
			i = holesY.length-1;
		int prevHole = holesY[i - 1];
		int wayPrevHole = prevHole;
		/*
		try {
			if (i - 30 < 0) {
				i = 124 - i;
			}
		wayPrevHole = holesY[i];
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
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

}
