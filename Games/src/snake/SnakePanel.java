package snake;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements ActionListener, KeyListener {

	
	private boolean startGame = true;
	private boolean playing = false;
	private boolean endGame = false;
	
	private ArrayList<Point> snakeBody = new ArrayList<Point>();
	private int bodySize = 10;
	
	private int fruitX = 300;
	private int fruitY = 200;
	
	private int deltaX = 0;
	private int deltaY = -bodySize;
	
	public SnakePanel() {
		snakeBody.add(new Point(250, 250));
		snakeBody.add(new Point(250, 255));
		snakeBody.add(new Point(250, 260));
		snakeBody.add(new Point(250, 265));
		for (Point x : snakeBody) {
			
			System.out.print(x.x + "  " + x.y);
			System.out.println();
			
		}
		setBackground(Color.BLACK);

		setFocusable(true);
		addKeyListener(this);

		Timer timer = new Timer(1000 / 5, this);
		timer.start();
		

	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		moves();
	}
	
	public void moves() {
		
		
		
		
		
		
		
		
		
		snakeBody.remove(snakeBody.size()-1);
		Point body = snakeBody.get(0);
		body.x += deltaX;
		body.y += deltaY;
		snakeBody.add(0, body);
		
		repaint();
		
	}
	
	public void addBodySquare() {
		
		
		
		
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);
		
		for (Point body : snakeBody) {
			
			g.fillRoundRect(body.x, body.y, bodySize, bodySize, 2, 2);
			
			
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
