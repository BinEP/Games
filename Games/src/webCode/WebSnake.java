package webCode;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.Timer;

import utilityClasses.CenteredText;
import utilityClasses.ScoreInfo;

public class WebSnake extends Applet implements Runnable{
   
   private final int width = 800;
   private final int height = 600;

   Canvas canvas;
   BufferStrategy bufferStrategy;
   Thread gameloopThread;
   
   
   private boolean startGame = true;
	private boolean playing = false;
	private boolean paused = false;
	private boolean endGame = false;
	private boolean nameEnter = false;
	private boolean highScores = false;

	private ScoreInfo scores = new ScoreInfo("snake");

	private String pName = "";
	private Character letter;

	private ArrayList<Point> snakeBody = new ArrayList<Point>();
	private ArrayList<Color> snakeColor = new ArrayList<Color>();
	private Color[] Colors = { Color.CYAN, Color.RED, Color.GREEN,
			Color.YELLOW, Color.ORANGE, Color.WHITE };
	private int bodySize = 10;
	private Point head = new Point(250, 250);

	private int fruitX = 300;
	private int fruitY = 200;
	private Color fruitColor = Color.WHITE;

	private int deltaX = 0;
	private int deltaY = -bodySize;

	private int prevLoseKey = KeyEvent.VK_DOWN;

	private Timer timer;
	private double speed = 10;

	private int score = 0;
   
   
   
   @Override
   public void init(){
      canvas = new Canvas();
      canvas.setBounds(0, 0, width, height);
      add(canvas);
      canvas.setIgnoreRepaint(true);

      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();

      canvas.addMouseListener(new MouseControl());
      canvas.addMouseMotionListener(new MouseControl());
      canvas.requestFocus();
      
      resetBody();
		for (Point x : snakeBody) {

			// System.out.print(x.x + "  " + x.y);
			// System.out.println();

		}
		setBackground(Color.BLACK);
   }
   
   @Override
   public void start(){
      gameloopThread = new Thread(this);
      gameloopThread.start();
   }
   
   @Override
   public void stop(){
      setRunning(false);
      try {
         gameloopThread.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
   
   private class MouseControl extends MouseAdapter{
      
   }
   
   private long desiredFPS = 60;
        private long desiredDeltaLoop = (1000*1000*1000)/desiredFPS;
    
   private boolean running = true;
   
   private synchronized void setRunning(boolean running){
      this.running = running;
   }
   
   private synchronized boolean isRunning(){
      return running;
   }
   
   public void run(){
      
      setRunning(true);
      
      long beginLoopTime;
      long endLoopTime;
      long currentUpdateTime = System.nanoTime();
      long lastUpdateTime;
      long deltaLoop;
      
      while(!isActive()){
         Thread.yield();
      }
      while(isRunning()){
         beginLoopTime = System.nanoTime();
         
         render();
         
         lastUpdateTime = currentUpdateTime;
         currentUpdateTime = System.nanoTime();
         update((int) ((currentUpdateTime - lastUpdateTime)/(1000*1000)));
         
         endLoopTime = System.nanoTime();
         deltaLoop = endLoopTime - beginLoopTime;
           
           if(deltaLoop > desiredDeltaLoop){
               //Do nothing. We are already late.
           }else{
               try{
                   Thread.sleep((desiredDeltaLoop - deltaLoop)/(1000*1000));
               }catch(InterruptedException e){
                   //Do nothing
               }
           }
      }
   }

   private void render() {
      try{
         Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
         g.clearRect(0, 0, width, height);
         render(g);
         bufferStrategy.show();
         g.dispose();
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   
   //TESTING
   private double x = 0;
   
   /**
    * Overwrite this method in subclass
    */
   protected void update(int deltaTime){
	   if (playing) {

			head.x += deltaX;
			head.y += deltaY;

			// System.out.println("(" + head.x + ", " + head.y + ")");

			for (int i = snakeBody.size() - 1; i > 0; i--) {

				if (head.x == snakeBody.get(i).x
						&& head.y == snakeBody.get(i).y) {
					playing = false;
					nameEnter = true;
				}
				snakeBody.set(i, snakeBody.get(i - 1));

				// System.out.print("(" + x.x + ", " + x.y + ") ");

			}
			snakeBody.set(0, new Point(head.x, head.y));

			/*
			 * for (Point x : snakeBody) { //snakeBody.set(i,
			 * snakeBody.get(i-1));
			 * 
			 * 
			 * System.out.print("(" + x.x + ", " + x.y + ") ");
			 * 
			 * }
			 */
			// System.out.println();

			// System.out.println();

			/*
			 * for (int i = 0; i < snakeBody.size(); i++) {
			 * 
			 * Point body = snakeBody.get(i); body.x += deltaX; body.y +=
			 * deltaY;
			 * 
			 * snakeBody.set(i, body); }
			 */
			/*
			 * Point headOfBody = new Point(); headOfBody = snakeBody.get(0);
			 */
			int nextHeadX = head.x + deltaX;
			int nextHeadY = head.y + deltaY;
			/*
			 * if (Math.abs(nextHeadX - fruitX) < 5 && Math.abs(nextHeadY -
			 * fruitY) < 5) { addBodySquare(); }
			 */

			if (Math.abs(head.x - fruitX) < 5 && Math.abs(head.y - fruitY) < 5) {
				addBodySquare();
			}

			if (head.x < 1 || head.x > 485 || head.y < 8 || head.y > 465) {

				playing = false;
				nameEnter = true;
			}

		}

		repaint();
   }
   
   /**
    * Overwrite this method in subclass
    */
   protected void render(Graphics2D g){
	  // super.paintComponent(g);
		g.setColor(Color.WHITE);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(15));
		g2.drawRect(0, 0, 499, 477);
		g2.setStroke(new BasicStroke(2));

		if (startGame) {

			g.setFont(new Font("Joystix", Font.BOLD, 80));
			CenteredText title1 = new CenteredText("SNAKE!!", 500, 500, g,
					true, 180);
			drawColorOptions(g, 415);
			g.setFont(new Font("Joystix", Font.BOLD, 20));

			CenteredText start1 = new CenteredText("Press Enter to", 500, 500,
					g, true, 300);
			CenteredText start2 = new CenteredText("Start", 500, 500, g, true,
					330);

		} else if (playing || paused) {

			g.setFont(new Font("Joystix", Font.BOLD, 40));
			g.setColor(Color.WHITE);
			CenteredText score1 = new CenteredText(String.valueOf(score), 500,
					500, g, true, 450);
			int i = 0;
			for (Point body : snakeBody) {

				g.setColor(snakeColor.get(i));
				i++;
				g.fillRect(body.x, body.y, bodySize, bodySize);
				g.setColor(Color.BLACK);
				g.drawRect(body.x, body.y, bodySize, bodySize);
				g.drawRect(fruitX, fruitY, bodySize, bodySize);

				// g.setColor(Color.WHITE);
				g.setColor(fruitColor);
				g.fillRect(fruitX + 1, fruitY + 1, bodySize - 2, bodySize - 2);

				if (paused) {
					g.setFont(new Font("Joystix", Font.BOLD, 60));
					g.setColor(Color.WHITE);
					CenteredText pause = new CenteredText("Paused", 500, 500,
							g, true, 200);

					drawColorOptions(g, 300);
				}
			}

		} else if (endGame) {

			g.setFont(new Font("Joystix", Font.BOLD, 40));
			g.setColor(Color.WHITE);
			CenteredText score1 = new CenteredText(String.valueOf(score), 500,
					500, g, true, 450);

			g.setFont(new Font("Joystix", Font.BOLD, 60));

			CenteredText lose = new CenteredText("You Lose!", 500, 500, g,
					true, 170);

			g.setFont(new Font("Joystix", Font.BOLD, 26));

			CenteredText restart = new CenteredText("Enter to Restart", 500,
					500, g, true, 320);
		} else if (nameEnter) {

			scores.enterName(g, 500, 500, snakeBody.size(), pName);

		} else if (highScores) {

			// scores.setScores(timeSeconds, pName);
			scores.drawScores(g);
		}
   }
   
   
   public void drawColorOptions(Graphics g, int colorY) {

	   

		g.setFont(new Font(Font.DIALOG, Font.BOLD, 45));
		g.setColor(Color.RED);
		g.drawString("R", 50, colorY);
		g.setColor(Color.GREEN);
		g.drawString("G", 140, colorY);
		g.setColor(Color.CYAN);
		g.drawString("B", 230, colorY);
		g.setColor(Color.YELLOW);
		g.drawString("Y", 315, colorY);
		g.setColor(Color.ORANGE);
		g.drawString("O", 410, colorY);
		// g.setColor(Color.BLACK);
		// g.drawString("W", 500, colorY);

		g.setColor(Color.WHITE);

	}
   
   
   
   
  
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == prevLoseKey) {

			playing = false;
			endGame = true;

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {

			deltaX = 0;
			deltaY = -bodySize;
			prevLoseKey = KeyEvent.VK_DOWN;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			deltaX = 0;
			deltaY = bodySize;
			prevLoseKey = KeyEvent.VK_UP;

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			deltaY = 0;
			deltaX = -bodySize;
			prevLoseKey = KeyEvent.VK_RIGHT;

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			deltaY = 0;
			deltaX = bodySize;
			prevLoseKey = KeyEvent.VK_LEFT;

		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (startGame) {

				playing = true;
				startGame = false;

			} else if (endGame) {

				resetBody();
				startGame = false;
				playing = true;
				nameEnter = false;
				highScores = false;
				endGame = false;
				pName = "";
				fruitX = randNum();
				fruitY = randNum();
				fruitColor = randColor();
				speed = 10;
				score = 0;

			} else if (nameEnter) {
				nameEnter = false;
				highScores = true;
				scores.setScores(snakeBody.size(), pName);
			} else if (highScores) {

				highScores = false;
				endGame = true;
			} else {
				startGame = false;
				playing = true;

			}

		} else if (e.getKeyCode() == KeyEvent.VK_SPACE && !nameEnter) {

			playing = !playing;
			paused = !paused;
		} else if (e.getKeyLocation() == KeyEvent.KEY_LOCATION_STANDARD
				&& nameEnter) {

			if (pName.length() < 10) {
				letter = e.getKeyChar();

				letter = Character.toUpperCase(letter);
				pName = pName.concat(letter.toString());
			}

		} else {
			// if (startGame || endGame) {
			switch (e.getKeyCode()) {

			case KeyEvent.VK_R:
				fruitColor = Color.RED;

				break;
			case KeyEvent.VK_G:
				fruitColor = Color.GREEN;

				break;
			case KeyEvent.VK_B:
				fruitColor = Color.CYAN;

				break;
			case KeyEvent.VK_Y:
				fruitColor = Color.YELLOW;

				break;
			case KeyEvent.VK_O:
				fruitColor = Color.ORANGE;

				break;
			case KeyEvent.VK_W: // VK_W - White is default case
				fruitColor = Color.WHITE;

				break;

			}

			// }
		}
	}
   
   public Color randColor() {

		return Colors[(int) (Math.random() * Colors.length)];
	}
   
   public int randNum() {

		return ((int) (Math.random() * 45)) * 10 + 10;
	}
   
   public void resetBody() {

		snakeBody.clear();
		snakeColor.clear();
		snakeBody.add(new Point(250, 250));
		snakeBody.add(new Point(250, 260));
		snakeBody.add(new Point(250, 270));
		snakeBody.add(new Point(250, 280));

		for (int i = 0; i < snakeBody.size(); i++) {
			// Whoop
			snakeColor.add(Color.WHITE);

		}

		head.x = 250;
		head.y = 250;
		deltaY = -bodySize;
		deltaX = 0;
		prevLoseKey = KeyEvent.VK_DOWN;

	}


   public void addBodySquare() {

		int lastBodyX = snakeBody.get(snakeBody.size() - 1).x;
		int lastBodyY = snakeBody.get(snakeBody.size() - 1).y;
		int secondLastBodyX = snakeBody.get(snakeBody.size() - 2).x;
		int secondLastBodyY = snakeBody.get(snakeBody.size() - 2).y;

		int changeX = lastBodyX - secondLastBodyX;
		int changeY = lastBodyY - secondLastBodyY;

		snakeBody.add(new Point(lastBodyX + changeX, lastBodyY + changeY));
		snakeColor.add(fruitColor);
		fruitX = randNum();
		fruitY = randNum();
		fruitColor = randColor();

		speed += .5;
		// System.out.println(speed);
		// System.out.println((int) (1000.0 / speed));
		timer.setDelay((int) (1000.0 / speed));
		score++;

	}

}