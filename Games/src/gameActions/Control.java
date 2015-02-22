package gameActions;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import utilityClasses.*;

/**
 * @author Brady Stoffel
 */
public class Control extends JPanel implements Screen {

	/**
	 * When start screen is showing Paint checks this variable for whether or
	 * not draw the start screen
	 */
	public boolean startGame = true;
	/**
	 * When game is being played Paint checks this variable for whether or not
	 * draw playing field
	 */
	public boolean playing = false;
	/**
	 * When game is paused Paint checks this variable for whether or not draw
	 * the pause screen
	 */
	public boolean paused = false;
	/**
	 * When end screen is showing Paint checks this variable for whether or not
	 * draw the game over screen
	 */
	public boolean endGame = false;
	/**
	 * When entering name screen is showing Paint checks this variable for
	 * whether or not draw the enter name screen
	 */
	public boolean nameEnter = false;
	/**
	 * When high scores are listed on screen Paint checks this variable for
	 * whether or not draw the high score screen
	 */
	public boolean highScores = false;

	public boolean showMouseCoords = false;

	/**
	 * The value for the upKey This can be changed to suit the user of player
	 */
	public int upKey = KeyEvent.VK_UP;
	/**
	 * The value for the downKey This can be changed to suit the user of player
	 */
	public int downKey = KeyEvent.VK_DOWN;
	/**
	 * The value for the leftKey This can be changed to suit the user of player
	 */
	public int leftKey = KeyEvent.VK_LEFT;
	/**
	 * The value for the rightKey This can be changed to suit the user of player
	 */
	public int rightKey = KeyEvent.VK_RIGHT;

	public boolean upPressed = false;
	public boolean downPressed = false;
	public boolean leftPressed = false;
	public boolean rightPressed = false;
	
	public int width = Window.WIDTH;
	public int height = Window.HEIGHT;
	
	public static String NAME = "Game Name";
	public static String TXT_FILE = NAME.toLowerCase().replaceAll("\\s", "");
	public static String FOLDER_PATH = "InfoFiles/";
	public static String FONT_FILE = "joystix";
	
	public static CustomFont customFont = new CustomFont(FONT_FILE, Font.BOLD, 18);
	/**
	 * Set to true if only one direction per frame
	 * @author Brady Stoffel
	 */
	public boolean singleDirection = false;
	
	public enum Direction {
		up, down, left, right;
	}
	
	/**
	 * The positions that scores could be on screen to make it easier to position the score
	 * @author Brady Stoffel
	 */
	public enum ScoreCoords {
		
		top_left (10, 10), 
		top_middle (Window.WIDTH / 2, 10), 
		top_right (Window.WIDTH - 10, 10), 
		middle_left (10, Window.HEIGHT / 2), 
		middle_middle (Window.WIDTH / 2, Window.HEIGHT / 2), 
		middle_right (Window.WIDTH - 10, Window.HEIGHT / 2), 
		bottom_left (10, Window.HEIGHT - 15), 
		bottom_middle (Window.WIDTH / 2, Window.HEIGHT - Window.TOP_BUFFER), 
		bottom_right (Window.WIDTH - 10, Window.HEIGHT - Window.TOP_BUFFER);
		
		public int x;
		public int y;
		
		private ScoreCoords(int x, int y) {
			
			this.x = x;
			this.y = y;
		}
		
		public Point getCoords() {
			return new Point(this.x, this.y);
		}
		
		/**
		 * Draws text at preset enum position using current font
		 * @param text
		 * @param g
		 */
		public void draw(String text, Graphics2D g) {
			
			g.setFont(CustomFont.makeCustomFont(FONT_FILE, Window.SCORE_SIZE));
			
			FontMetrics fontInfo = g.getFontMetrics();
			int textWidth = fontInfo.stringWidth(text);
			int textHeight = fontInfo.getHeight();
			
			if (x == Window.WIDTH / 2) {
				
				CenteredText.draw(text, y, g);
			} else if (x == 10) {
				
				g.drawString(text, x, y + textHeight / 2);
			} else if (x == Window.WIDTH - 10) {
				
				g.drawString(text, x - textWidth, y + textHeight / 2);
			}
		}
	}

	/**
	 * keyMap - modify this to change key locations Gets modified when on the
	 * start screen and keys are pressed Assigned in order of when pressed then
	 * the key are mapped when the game starts
	 */
	public int[] keyMap = { KeyEvent.VK_UP, KeyEvent.VK_RIGHT,
			KeyEvent.VK_DOWN, KeyEvent.VK_LEFT };

	public int keyIndex = 0;

	/**
	 * The value that deltaX and deltaY will change player position by
	 */
	public int movementVar = 10;
	/**
	 * How much a player moves in the x direction
	 */
	public int deltaX = movementVar;
	/**
	 * How much a player moves in the y direction
	 */
	public int deltaY = 0;
	public String pName = "";

	/**
	 * player x position
	 */
	public int playerX;
	/**
	 * player y position
	 */
	public int playerY;

	public Timer timer;
	public int origSpeed = movementVar;
	public double speed = origSpeed;
	/**
	 * If you want to game to speed up as the score gets higher
	 */
	public boolean speedUp = false;

	public int score;
	public Character letter;

	public double startTime;
	public double totalTime = 0;

	public ArrayList<Direction> nextDirection = new ArrayList<Direction>();

//	public UserGame sub = (UserGame) this;


	public Control() {

		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);

		NAME = getGameName();
		TXT_FILE = NAME.toLowerCase().replaceAll("\\s", "");
		FOLDER_PATH = getFolderPath();
		FONT_FILE = getFontFile();
		
		setup();

		timer = new Timer((int) (1000 / speed), this);
		timer.start();
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
		timer.setDelay(1000 / speed);
	}

	public void setBackgroundColor(Color c) {

		this.setBackground(c);
	}

	/**
	 * can be called to set the direction keys if they have been modified and
	 * sets the keyMap when the game starts
	 */
	public void setKeys() {

		upKey = keyMap[0];
		rightKey = keyMap[1];
		downKey = keyMap[2];
		leftKey = keyMap[3];
	}

	/**
	 * This paintComponent checks which state the game is in using the
	 * startGame, endGame, etc. to know what to paint. Attempts to call methods
	 * in the UserGame class, which override methods in this class so that is
	 * the user has not defined a custom method, a default one is drawn
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.scale((double) width / (double) Window.WIDTH, (double) (height) / (double) Window.HEIGHT);
		g.setColor(Color.WHITE);
		draw(g2);

		if (startGame) {

			drawStart(g2);

		} else if (playing || paused) {

			drawPlaying(g2);

			if (showMouseCoords) {
				Point mouse = MouseInfo.getPointerInfo().getLocation();
				Point screen = this.getLocationOnScreen();

				g.drawString("" + (mouse.x - screen.x) + "  "
						+ (mouse.y - screen.y), 20, 80);
			}
			if (paused) {

				drawPaused(g2);
			}
		} else if (endGame) {

			drawEnd(g2);

		} else if (nameEnter) {

			ScoreInfo.enterName(g2, score, pName);
			
		} else if (highScores) {

			ScoreInfo.drawScores(g2, TXT_FILE, FOLDER_PATH);
		}
	}
	
	public void draw(Graphics2D g) {
		
	}

	/**
	 * Draws the start screen. gets game name from Window class
	 * 
	 * @param g
	 */
	public void drawStart(Graphics2D g) {

		g.setColor(Color.WHITE);
		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.TITLE_SIZE));
		CenteredText.draw(NAME, Window.TITLE_Y, g);
		g.setFont(new Font(Window.FONT_NAME, Font.BOLD,
				Window.ENTER_TO_START_SIZE));

		CenteredText.draw("Press Enter to", Window.ENTER_Y, g);
		CenteredText.draw("Start", Window.START_Y, g);

		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, 12));

		CenteredText.draw("Press keys Up, Right, Down, Left to map new keys",
				30, g);
	}

	/**
	 * Draws the screen when playing
	 * 
	 * @param g
	 */

	public void drawPlaying(Graphics2D g) {

		g.setColor(Color.CYAN);
		g.fillRect(20, 30, playerX, playerY);
	}

	/**
	 * draws the word "Paused" in the middle of the screen
	 * 
	 * @param g
	 */
	public void drawPaused(Graphics2D g) {

		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.PAUSE_SIZE));
		g.setColor(Color.WHITE);
		CenteredText.draw("Paused", Window.PAUSE_Y, g);
	}

	/**
	 * Draws the end game screen
	 * 
	 * @param g
	 */
	public void drawEnd(Graphics2D g) {

		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.END_SCORE_SIZE));
		g.setColor(Color.WHITE);
		CenteredText.draw(String.valueOf(score), Window.END_SCORE_Y, g);

		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.YOU_LOSE_SIZE));

		CenteredText.draw("You Lose!", Window.YOU_LOSE_Y, g);

		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.RESTART_SIZE));

		CenteredText.draw("Enter to Restart", Window.RESTART_Y, g);
	}
	
	public void setup() {
		
	}
	
	public void reset() {
		
	}

	/**
	 * starts the timer that can be displayed on screen. Use getTime() to get
	 * the number seconds that have passed
	 */
	public void startTime() {

		startTime = System.currentTimeMillis();
	}

	/**
	 * Pauses the timer
	 */
	public void stopTime() {

		totalTime += System.currentTimeMillis() - startTime;
		startTime = System.currentTimeMillis();
	}

	/**
	 * gets the number of seconds that have passed since the timer was started
	 * 
	 * @return int
	 */
	public int getTime() {

		return (int) ((totalTime + System.currentTimeMillis() - startTime) / 1000);
	}

	/**
	 * resets the time passed and sets the start time to the current time
	 */
	public void resetTime() {
		totalTime = 0;
		startTime = System.currentTimeMillis();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		
		if (startGame && e.getKeyCode() != KeyEvent.VK_ENTER) {

			keyMap[keyIndex] = e.getKeyCode();
			keyIndex++;
			if (keyIndex > 3)
				keyIndex = 0;

		} else if (e.getKeyCode() == upKey) {

			if (singleDirection) {
				addDirection(Direction.up);
			} else {
				up();
			}

		} else if (e.getKeyCode() == downKey) {

			if (singleDirection) {
				addDirection(Direction.down);
			} else {
				down();
			}

		} else if (e.getKeyCode() == leftKey) {

			if (singleDirection) {
				addDirection(Direction.left);
			} else {
				left();
			}

		} else if (e.getKeyCode() == rightKey) {

			if (singleDirection) {
				addDirection(Direction.right);
			} else {
				right();
			}

		} else if (e.getKeyCode() == KeyEvent.VK_ENTER && !(paused || playing)) {

			if (startGame) {

				playing = true;
				startGame = false;
				setKeys();
				startTime();
				setup();

			} else if (endGame) {

				speed = origSpeed;
				reset();
				stopTime();
				startGame = false;
				playing = true;
				nameEnter = false;
				highScores = false;
				endGame = false;
				pName = "";
				speed = 10;
				score = 0;

			} else if (nameEnter) {
				nameEnter = false;
				highScores = true;
				ScoreInfo.setScores(score, pName, TXT_FILE, FOLDER_PATH);
			} else if (highScores) {

				highScores = false;
				endGame = true;
			} else {
				startGame = false;
				playing = true;
			}

		} else if (e.getKeyCode() == KeyEvent.VK_SPACE && (playing || paused)) {

			playing = !playing;
			paused = !paused;

			repaint();

		} else if (e.getKeyLocation() == KeyEvent.KEY_LOCATION_STANDARD
				&& nameEnter) {

			if (pName.length() < 10) {
				letter = e.getKeyChar();

				letter = Character.toUpperCase(letter);
				pName = pName.concat(letter.toString());
			}
		}
		customPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {

		
		if (e.getKeyCode() == upKey) {

			upReleased();

		} else if (e.getKeyCode() == downKey) {

			downReleased();
			
		} else if (e.getKeyCode() == leftKey) {

			leftReleased();

		} else if (e.getKeyCode() == rightKey) {

			rightReleased();
		}
		
		customReleased(e);
	}

	/**
	 * Gets called when timer activates an action, and the timer fires very
	 * quickly. Calls the moves method in the UserGame class if the playing
	 * variable is true
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		width = getWidth();
		height = getHeight();
//		System.out.println("width: " + width + "\t height: " + height);
		
		alwaysExecute();
		
		if (playing) {

			if (nextDirection.size() > 0 && singleDirection) executeDirection();
			
			moves();

			if (speedUp) timer.setDelay(1000 / (int) ( speed + score / 2));
			
			if (checkIfDead()) {

				playing = false;
				nameEnter = true;
			}
		}
		repaint();
	}

	public boolean checkIfDead() {
		// TODO Auto-generated method stub
		return false;
	}

	public void moves() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	/**
	 * What to set variables to when upKey is pressed. Called by keyPressed
	 */
	@Override
	public void up() {
		upPressed = true;
	}

	/**
	 * What to set variables to when upKey is pressed Called by keyPressed
	 */
	@Override
	public void down() {
		downPressed = true;
	}

	/**
	 * What to set variables to when upKey is pressed Called by keyPressed
	 */
	@Override
	public void left() {
		leftPressed = true;
	}

	/**
	 * What to set variables to when upKey is pressed Called by keyPressed
	 */
	@Override
	public void right() {
		rightPressed = true;
	}

	/**
	 * What to set variables to when upKey is released Called by keyReleased
	 */
	@Override
	public void upReleased() {
		upPressed = false;
	}

	/**
	 * What to set variables to when downKey is released Called by keyReleased
	 */
	@Override
	public void downReleased() {
		downPressed = false;
	}

	/**
	 * What to set variables to when leftKey is released Called by keyReleased
	 */
	@Override
	public void leftReleased() {
		leftPressed = false;
	}

	/**
	 * What to set variables to when rightKey is released Called by keyReleased
	 */
	@Override
	public void rightReleased() {
		rightPressed = false;
	}
	
	public void customPressed(KeyEvent e) {
		
		
		
	}
	
public void customReleased(KeyEvent e) {
		
		
		
	}

	/**
	 * Sets the graphics font at the given size
	 * 
	 * @param g
	 * @param size
	 */
	public Font getFont(int size) {
		return customFont.getFont(size);
	}

	/**
	 * Adds the direction to a list of directions to be executed.
	 * 
	 * @param d
	 */
	public void addDirection(Direction d) {

		if (singleDirection) {
			if (nextDirection.size() < 2) nextDirection.add(d);
		}
	}

	/**
	 * Executes the direction passed into the method
	 */
	public void executeDirection() {

		Direction d = nextDirection.get(0);
		nextDirection.remove(0);

		switch (d) {
		
		case up:
			up();
			break;
			
		case down:
			down();
			break;
			
		case left:
			left();
			break;
			
		case right:
			right();
		}
	}
	
	public Direction getDirection(int keyCode) {
		
		if (keyCode == upKey) {
			return Direction.up;
			
		} else if (keyCode == downKey) {
			return Direction.down;
			
		} else if (keyCode == leftKey) {
			return Direction.left;
			
		} else {
			return Direction.right;
		}
	}
	
	public void alwaysExecute() {}

	public String getGameName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFolderPath() {
		// TODO Auto-generated method stub
		return "InfoFiles/";
	}

	public String getFontFile() {
		// TODO Auto-generated method stub
		return "joystix";
	}
}
