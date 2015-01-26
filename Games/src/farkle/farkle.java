package farkle;
import java.util.Scanner;
import java.awt.Graphics;

import javax.swing.JFrame;

import java.lang.Integer;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class farkle extends JPanel {

	private static final long serialVersionUID = 1L;
	die die = new die();
	boolean done;
	int totalV;
	int[] roll = new int[6];
	int[] rollPrev = new int[6];
	boolean next;

	public static farkle dice;
	public static int row = 0;
	public static int pTurn;
	public static int playerTotal;
	public static boolean stealTest = false;
	public static boolean rollButton = false;
	public static boolean bankPoints = false;
	public static boolean playing = true;
	public static int players;
	public static int playTo;
	public static farkle game;
	public static boolean newGameClick = false;
	public static boolean endGameClick = false;
	public static farkle theGame;

	public static int[] allInts = { row, pTurn, playerTotal };
	private JTextField textField_1;
	private JTextField textField;
	private JPanel panel_1;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JFrame frame;
	private JCheckBox chckbxSortedDice;

	public farkle() {

		setSize(865, 653);

		JButton btnRoll = new JButton("Roll");
		btnRoll.setBounds(699, 571, 150, 60);
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRoll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rollButton = true;
			}
		});
		setLayout(null);
		add(btnRoll);

		JButton btnBankPoints = new JButton("Bank Points");
		btnBankPoints.setBounds(537, 571, 150, 60);
		btnBankPoints.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bankPoints = true;
			}
		});
		add(btnBankPoints);
		
		panel = new JPanel();
		panel.setBounds(240, 170, 408, 289);
		add(panel);
		panel.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBounds(140, 0, 134, 289);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblHowManyPlayers = new JLabel("How many Players?");
		lblHowManyPlayers.setBounds(0, 0, 134, 16);
		panel_2.add(lblHowManyPlayers);
		lblHowManyPlayers.setHorizontalAlignment(SwingConstants.CENTER);

		textField = new JTextField();
		textField.setBounds(0, 28, 134, 28);
		panel_2.add(textField);
		textField.setColumns(10);

		JLabel lblPlayUpTo = new JLabel("Play up to?");
		lblPlayUpTo.setBounds(0, 106, 134, 16);
		panel_2.add(lblPlayUpTo);
		lblPlayUpTo.setHorizontalAlignment(SwingConstants.CENTER);

		textField_1 = new JTextField();
		textField_1.setBounds(0, 134, 134, 28);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setBounds(0, 196, 134, 29);
		panel_2.add(btnStartGame);

		JButton btnHowTo = new JButton("How To");
		btnHowTo.setVisible(false);
		btnHowTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		btnHowTo.setBounds(0, 222, 134, 29);
		panel_2.add(btnHowTo);

		chckbxSortedDice = new JCheckBox("Sorted Dice");
		chckbxSortedDice.setSelected(true);
		chckbxSortedDice.setBounds(6, 249, 128, 23);
		panel_2.add(chckbxSortedDice);
		
				panel_1 = new JPanel();
				panel_1.setBounds(0, 80, 408, 76);
				panel.add(panel_1);
				panel_1.setVisible(false);
				panel_1.setLayout(null);
				
						JLabel lblYouWon = new JLabel("You Won!!!!");
						lblYouWon.setHorizontalAlignment(SwingConstants.CENTER);
						lblYouWon.setBounds(153, 6, 96, 16);
						panel_1.add(lblYouWon);
						
								JButton btnPlayAgain = new JButton("Play Again");
								btnPlayAgain.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										newGameClick = true;
										
										//panel.setVisible(false);
										
										panel_1.setVisible(false);

									}
								});
								btnPlayAgain.setBounds(77, 34, 117, 29);
								panel_1.add(btnPlayAgain);
								
										JButton btnQuit = new JButton("Quit");
										btnQuit.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseClicked(MouseEvent e) {
												endGameClick = true;
												panel.setVisible(false);
												panel_1.setVisible(false);

											}
										});
										btnQuit.setBounds(206, 34, 117, 29);
										panel_1.add(btnQuit);
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				players = Integer.parseInt(textField.getText());
				playTo = Integer.parseInt(textField_1.getText());

				//panel.setVisible(false);
				panel_2.setVisible(false);
				playing = false;
			}

		});

		panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setBounds(6, 6, 893, 625);
		add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(
						"/Users/88713791/Desktop/Screen Shots/Screen Shot 2014-11-06 at 2.03.54 PM copy 2.png"));
		lblNewLabel.setBounds(0, 0, 890, 625);
		panel_3.add(lblNewLabel);

		setVisible(true);

	}

	public farkle(boolean nex) {

		this.totalV = 0;
		this.done = true;
		this.next = nex;
		row = (nex) ? 1 : row + 1;
		int n = 0;
		while (n < 6) {
			this.roll[n] = die.roll();
			n++;
		}
		this.rollPrev = new int[6];

	}

	public farkle(int[] zeroes, boolean don) {
		int n = 0;

		for (int checkZ : zeroes) {
			this.roll[n] = (checkZ != 0) ? die.roll() : 0;
			n++;
		}
		row++;
		this.totalV = 0;
		this.done = don;
		this.next = false;
		this.rollPrev = new int[6];
	}

	void playAgainPanel() throws InterruptedException {
		
		//panel_3.setVisible(false);
		/*
		Thread.sleep(200);
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_1.setVisible(true);
		*/
		
		panel_2.setVisible(false);
		//panel.setVisible(true);
		panel_1.setVisible(true);
		
		
		
		
		

		//1game.repaint();
		//panel_2.setVisible(false);

		// panel_3.setVisible(false);
		// panel.setBounds(232, 160, 420, 300);

		//frame.getContentPane().add(panel_1);
		// frame.add(panel);
		//frame.validate();
		// frame.setVisible(true);

		// panel.setVisible(true);

		// panel_1.setVisible(true);
		// panel_2.setVisible(false);

	}

	void farklePanel() {

		// panel.setVisible(false);
		// panel.setVisible(false);
		
		panel_3.setVisible(true);
		// panel.setVisible(false);
		// frame.getContentPane().add(panel_3);
		//frame.validate();
		// frame.setVisible(true);

	}

	void farklePanelHide() {
		
		panel_3.setVisible(false);
		//panel_1.setVisible(true);
		//panel_2.setVisible(false);
		//panel_3.setVisible(false);
		// panel.setVisible(true);
		// panel.setVisible(true);
		// panel.setVisible(false);
		// frame.getContentPane().add(panel_3);
		//frame.validate();
		// frame.setVisible(true);

	}

	void playAgainSetup() throws InterruptedException {

		textField.setText("");
		textField_1.setText("");
		//Thread.sleep(200);
		// panel.setVisible(true);
		//frame.getContentPane().add(panel_2);
		//panel_3.setVisible(false);
		//panel_1.setVisible(false);
		panel_1.setVisible(false);

		panel_2.setVisible(true);
		
		


		//frame.validate();
		// frame.setVisible(true);

	}

	public static void main(String[] args) throws InterruptedException {

		theGame = new farkle();
		theGame.frame = new JFrame("Farkle");

		theGame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setAlwaysOnTop(true);
		farkle game = new farkle();

		theGame.frame.setSize(865, 1000);
		theGame.frame.getContentPane().add(game);
		theGame.frame.getContentPane().add(theGame.panel);
		theGame.frame.getContentPane().add((theGame.panel));
		theGame.frame.getContentPane().add(theGame.panel_3);
		theGame.frame.getContentPane().setLayout(null);

		Thread.sleep(2000);
		theGame.frame.setVisible(true);
		while (theGame.newGame(game)) {
		}
		System.out.println("Thanks for playing!!!");
		System.exit(0);

	}

	public void paint(Graphics g) {
		if (dice.next || dicePrevLeft() == 6) {
			row = 1;
			super.paint(g);
		}
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawDice(g2d);
	}

	public void drawDice(Graphics g) {

		ifDiceSort();
		int n = 1;
		for (int dieNum : dice.rollPrev) {
			dieCoord die = new dieCoord(n, row);
			if (dieNum != 0) {

				int r = 16;
				int d = r / 2;

				if (dieNum % 2 != 0) {
					g.fillOval(die.mm.x - d, die.mm.y - d, r, r);

				}
				if (dieNum != 1) {
					g.fillOval(die.ur.x - d, die.ur.y - d, r, r);
					g.fillOval(die.ll.x - d, die.ll.y - d, r, r);
				}
				if (dieNum > 3) {

					g.fillOval(die.ul.x - d, die.ul.y - d, r, r);
					g.fillOval(die.lr.x - d, die.lr.y - d, r, r);

				}
				if (dieNum == 6) {
					g.fillOval(die.ml.x - d, die.ml.y - d, r, r);
					g.fillOval(die.mr.x - d, die.mr.y - d, r, r);

				}
				int dx = 114 * (n - 1) + 10;
				int dy = 114 * (row - 1) + 10;

				g.drawRoundRect(dx, dy, 104, 104, 20, 20);
				g.drawRoundRect(dx + 1, dy + 1, 102, 102, 16, 16);
				/*
				 * g.drawRoundRect(114 * (n - 1) + 10, 114 * (row - 1) + 10,
				 * 104, 104, 20, 20); g.drawRoundRect(114 * (n - 1) + 11, 114 *
				 * (row - 1) + 11, 102, 102, 16, 16);
				 */
				n++;
			}

			g.drawString("Player " + pTurn + " turn total: " + dice.totalV,
					die.total.x, die.total.y - 10);
			g.drawString("Player " + pTurn + " total: " + playerTotal,
					die.total.x, die.total.y + 10);
		}

	}

	public void ifDiceSort() {

		if (getChckbxSortedDice().isSelected()) {
			Arrays.sort(dice.roll);
			Arrays.sort(dice.rollPrev);
		}
	}

	public boolean newGame(farkle game) throws InterruptedException {

		newGameClick = false;
		endGameClick = false;
		playing = true;
		playerTotal = 0;
		pTurn = 1;
		dice = new farkle(true);

		final boolean playersRun = true;

		String answer;

		int total = 0;
		Scanner console = new Scanner(System.in);
		answer = "";
		/*
		 * if (playersRun) { System.out.println("How many Players?"); players =
		 * console.nextInt();
		 * 
		 * System.out.println("How many points to play to?"); playTo =
		 * console.nextInt();
		 * 
		 * answer = "";
		 * 
		 * } else { players = 2; playTo = 3000; answer = "finish"; }
		 */

		int[] totalArr = new int[1];

		pTurn = 1;
		int allTotal = 0;
		// printTurn(pTurn, totalArr, playTo);

		while (playing) {

			Thread.sleep(200);

		}

		ifDiceSort();

		totalArr = new int[players];

		while (allTotal < playTo) {

			total = 0;

			while (dice.done) {

				printDice();

				dice = addPoints(total);
				total = dice.totalV;
				System.out.println(total);

				game.repaint();
				Thread.sleep(800);

				if (dice.done) {
					System.out.println("Dice left: ");
					printDice();

					if (!(answer.equals("finish"))) {
						System.out.println("Want to roll? yes: y, no: n");
						boolean ifWon = (dice.totalV + playerTotal < playTo);
						while (!(rollButton || bankPoints) && ifWon) {
							Thread.sleep(200);
						}
						answer = (rollButton && ifWon) ? "y" : "n";
						// answer = console.next();
						rollButton = false;
						bankPoints = false;

						dice.done = (answer.equals("y"));
					} else {

						dice.done = (diceLeft() > 2);
					}

				} else {
					total = 0;
				}

				int n = 0;
				while (n < 6 && dice.roll[n] == 0) {
					n++;
				}
				dice = (n == 6) ? new farkle(false) : new farkle(dice.roll,
						dice.done);
			}
			String steal = "";
			if (stealTest) {

				System.out
						.println("Player "
								+ pTurn
								+ ", do you want to try to steal\n points from your opponent?\n Yes: y , No: n");
				steal = console.next();

			}

			if (steal.equals("y")) {

				dice = new farkle(dice.roll, dice.done);

			} else {

				totalArr[pTurn - 1] += total;
				allTotal = totalArr[pTurn - 1];
			}

			pTurn = nextTurn(pTurn, players, false);

			printTurn(pTurn, totalArr, playTo);
			dice.done = true;

			if (!(steal.equals("y"))) {
				dice = new farkle(true);
			}
			if (playersRun) {
				Thread.sleep(500);
			}
		}

		System.out.println();
		System.out.println();

		pTurn = nextTurn(pTurn, players, true);

		System.out.println("Player " + pTurn + " won! Player " + pTurn
				+ " had " + totalArr[pTurn - 1] + " points");

		System.out.println("Want to play again? yes: y, no: n");

		Thread.sleep(1000);
		
		panel.setVisible(true);
		//panel_1.setVisible(true);
		playAgainPanel();
		//panel_1.setVisible(true);
		
		while (!(newGameClick || endGameClick)) {
			Thread.sleep(1000);

		}
		// answer = console.next();

		game.repaint();
		Thread.sleep(100);
		// return (answer.equals("y"));
		if (newGameClick) {

			playAgainSetup();

		}
		return newGameClick;

	}

	public static int diceLeft() {
		int count = 0;
		for (int die : dice.roll) {

			if (die != 0) {
				count++;
			}
		}

		return count;

	}

	public static int dicePrevLeft() {
		int count = 0;
		for (int die : dice.rollPrev) {

			if (die != 0) {
				count++;
			}
		}

		return count;

	}

	public static int nextTurn(int pTurn, int players, boolean prev) {
		pTurn++;

		if (prev) {
			pTurn -= 2;
			pTurn = (pTurn == 0) ? players : pTurn;
		}
		if (pTurn > players) {
			pTurn = 1;

		}
		return pTurn;

	}

	public static void printTurn(int turn, int[] totalArr, int playTo) {
		int n = 0;
		boolean notWon = true;
		for (int total : totalArr) {
			total = totalArr[n];
			System.out.println("Player " + (n + 1) + " total: " + total);
			n++;
			notWon = notWon && (total < playTo);
		}
		System.out.println();
		if (notWon) {
			System.out.println("Player " + turn + "\'s turn!");
		}
		playerTotal = totalArr[turn - 1];

	}

	public farkle addPoints(int total) throws InterruptedException {
		int count = 1;
		int subTotal = total;
		while (count < 7) {

			dice = Total(count);
			subTotal += dice.totalV;
			count++;
		}
		subTotal = checkOtherPoints(subTotal);
		if (total == subTotal) {
			dice.done = false;
			System.out.println("Farkle!");
			//farklePanel();
			//Thread.sleep(700);
			//farklePanelHide();
			//Thread.sleep(700);
			dice.totalV = 0;
		} else {
			total = subTotal;
			dice.totalV = total;
		}

		return dice;
	}

	public static int dieCount(int dieNum) {

		int count = 0;

		for (int dieVal : dice.roll) {

			count = (dieVal == dieNum) ? count + 1 : count;
		}

		return count;
	}

	public static void setZeroes(int dieNum, int count) {

		if (count >= 3 || (count > 0 && (dieNum == 1 || dieNum == 5))) {

			int n = 0;
			for (int dieVal : dice.roll) {
				dice.roll[n] = (dieVal == dieNum) ? 0 : dice.roll[n];
				n++;
			}

		}

	}

	public static int numTotal(int dieNum, int count) {
		int total = 0;

		int special = (dieNum == 10) ? 1000 : 0;

		total = (dieNum % 5 == 0 && count < 3) ? count * dieNum * 10 : total;

		total = (count == 3) ? dieNum * 100 : total;

		total = (count > 3) ? (count - 3) * 1000 + special : total;

		return total;
	}

	public static farkle Total(int dieNum) {

		int count;

		count = dieCount(dieNum);

		setZeroes(dieNum, count);

		dieNum = (dieNum == 1) ? 10 : dieNum;
		int total = numTotal(dieNum, count);

		dice.totalV = total;

		return dice;
	}

	public static void printDice() {
		int n = 0;
		for (int diceNum : dice.roll) {
			dice.rollPrev[n] = diceNum;
			if (diceNum != 0) {
				System.out.print(diceNum + "  ");
			}
			n++;
		}
		System.out.println();

	}

	public static int checkOtherPoints(int total) {

		int[] theRoll = dice.roll;
		Arrays.sort(theRoll);

		if (theRoll[0] != 0) {
			boolean set = true;
			for (int i = 0; i < 5; i += 2) {
				set = set && (theRoll[i] == theRoll[i + 1]);

			}

			if (set) {
				return 1500;
			}

			set = true;
			for (int i = 0; i < 4; i += 3) {
				set = theRoll[i] == theRoll[i + 1]
						&& theRoll[i] == theRoll[i + 2];

			}

			if (set) {
				return 2500;
			}
			set = true;
			int prevNum = 0;
			for (int num : theRoll) {
				set = prevNum + 1 == num;
				prevNum++;
			}

			if (set) {
				return 1500;
			}
		}
		return total;

	}

	public JTextField getTextFieldPlayers() {
		return textField;
	}

	public JTextField getTextFieldPlayTo() {
		return textField_1;
	}

	public JCheckBox getChckbxSortedDice() {
		return chckbxSortedDice;
	}
}
