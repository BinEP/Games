package utilityClasses;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel extends JPanel implements ActionListener, KeyListener {

	

	private boolean startScreen = true;
	private boolean playing = false;
	private boolean endGame = false;
	private boolean computerPlayer = false;
	
	private boolean UpPressed = false;
	private boolean DownPressed = false;
	
	

	public Panel() {

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
			
			
			
			
			
//			ballX += deltaX;
//			ballY += deltaY;
		}

		repaint();

		// ifStarted();

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);

		if (startScreen) {
//			int a = (int)(Math.random() * 2);
//			System.out.println(a);
			
			g.setFont(new Font("Joystix", Font.BOLD, 120));
			CenteredText.draw("PONG", 180, g);
			//g.drawString("PONG", pong.x, pong.y);
			
			g.setFont(new Font("Joystix", Font.BOLD, 20));
			
			CenteredText.draw("Press Enter to", 250, g);
			//g.drawString("Press Enter to", pressStart.x, 250);
			
			CenteredText.draw("Start", 280, g);
			//g.drawString("Start", start.x, 280);
			//System.out.println(deltaX + "\t" + deltaY);
			

		} else if (endGame) {
			
			g.setFont(new Font("Joystix", Font.BOLD, 60));
			
			
			CenteredText.draw("Player 1", 120, g);
			CenteredText.draw("You Win!", 210, g);
			//g.drawString("Player " + playerWon, playWon.x, 120);
			
			
			
			//g.drawString("You Win!", win.x, 210);
			
			g.setFont(new Font("Joystix", Font.BOLD, 26));
			CenteredText.draw("Enter to restart", 350, g);
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

		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			
			
		}
	}

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			UpPressed = false;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			DownPressed = false;

		}

	}

}
