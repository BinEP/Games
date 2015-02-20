package war;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.Timer;

import utilityClasses.*;

public class WarPanel extends JPanel implements ActionListener, KeyListener {

	private ArrayList<Card> deck = new ArrayList<Card>();
	private int numOfPlayers = 4;
	private ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>(
			numOfPlayers);

	private ArrayList<ArrayList<Card>> restOfDeck = new ArrayList<ArrayList<Card>>();
	private ArrayList<ArrayList<Card>> playerCards = new ArrayList<ArrayList<Card>>(
			numOfPlayers);
	private ArrayList<Card> middle = new ArrayList<Card>();
	ArrayList<Card> warCards = new ArrayList<Card>();
	private int[][] handXYs = { { 222, 15 }, { 429, 180 }, { 222, 361 },
			{ 15, 180 } };
	private int[][] middleXYs = { { 222, 130 }, { 329, 180 }, { 222, 246 },
			{ 115, 180 } };

	private Card middleHighP = new Card();
	private int middleHighPNum;

	private boolean startGame = true;
	private boolean playing = false;
	private boolean endGame = false;

	private int winner;
	private boolean won = false;

	private int turn = 1;
	private boolean middleShow = false;

	public WarPanel() {

		newGame();

		setBackground(Color.BLACK);

		setFocusable(true);
		addKeyListener(this);

		Timer timer = new Timer(1000 / 20, this);
		timer.start();

	}

	public WarPanel(int i) {
		newGame();
		numOfPlayers = i;
		setBackground(Color.BLACK);

		setFocusable(true);
		addKeyListener(this);

		Timer timer = new Timer(1000 / 20, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (playing)
			moves();
		repaint();
	}

	public void moves() {

		boolean almostWon = false;
		for (ArrayList<Card> hand : playerCards) {

			if (hand.size() < 51) {
				almostWon = true;
			} else {
				// System.out.println(hand);
			}

		}
		if (almostWon)
			middleAdd();

	}

	public void newDeck() {
		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while (deck.contains(card)) {
				card = new Card();
			}
			deck.add(card);
		}
	}

	public void newHands() {

		playerCards.clear();
		for (int i = 0; i < numOfPlayers; i++)
			playerCards.add(new ArrayList<Card>());

		for (int i = 0; i < deck.size(); i += 4) {

			int m = 0;
			for (int n = i; n < i + numOfPlayers; n++) {
				Card card = deck.get(n);
				playerCards.get(m).add(card);
				m++;
			}

		}
		System.out.println(hands);
	}

	public void deckPairsSetup() {

		restOfDeck.clear();
		for (int i = 0; i < numOfPlayers; i++) {
			restOfDeck.add(new ArrayList<Card>());
		}
	}

	public void newGame() {

		deck.clear();
		hands.clear();
		restOfDeck.clear();
		turn = 1;
		newDeck();
		newHands();
		deckPairsSetup();

	}

	public void shuffleDeck() {

		Collections.shuffle(deck);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);
		if (startGame) {

			g.setColor(Color.WHITE);
			g.setFont(new Font("Joystix", Font.BOLD, 60));
			CenteredText.draw("WAR!!", 500, 500, g, true, 230);

			g.setFont(new Font("Joystix", Font.BOLD, 20));
			CenteredText.draw("Press Enter to", 500, 500, g, true, 350);
			CenteredText.draw("Start", 500, 500, g, true, 380);

		} else if (playing) {

			g.setColor(Color.WHITE);
			g.setFont(new Font("Joystix", Font.BOLD, 25));
			for (int i = 0; i < numOfPlayers; i++) {
				if (playerCards.get(i).size() > 0) {
					g.setColor(Color.CYAN);
					int x = handXYs[i][0];
					int y = handXYs[i][1];
					g.fillRoundRect(x, y, 56, 100, 5, 5);
					g.drawRoundRect(x, y, 56, 100, 5, 5);
					g.setColor(Color.BLACK);

					CenteredText.draw(
							String.valueOf(playerCards.get(i).size()),
							new Rectangle(x, y, 56, 100), g);
					// g.drawString(String.valueOf(playerCards.get(i).size()), x
					// + cardNum.x, y + 60);
				}
			}
			if (middleShow) {
				int m = 0;

				for (Card card : middle) {
					if (card.getCard() != 0) {
						g.setColor(Color.CYAN);
						int x = handXYs[m][0];
						int y = handXYs[m][1];
						g.fillRoundRect(x, y, 56, 100, 5, 5);
						g.drawRoundRect(x, y, 56, 100, 5, 5);
						g.setColor(Color.BLACK);

						CenteredText.draw(
								String.valueOf(playerCards.get(m).size()),
								new Rectangle(x, y, 56, 100), g);

						g.setColor(Color.WHITE);
						x = middleXYs[m][0];
						y = middleXYs[m][1];

						if (card.equals(middleHighP))
							g.setColor(Color.YELLOW);

						g.fillRoundRect(x, y, 56, 100, 5, 5);
						g.drawRoundRect(x, y, 56, 100, 5, 5);
						g.setColor(Color.BLACK);
						CenteredText.draw(card.getShown(), new Rectangle(x, y,
								56, 100), g);

					}
					m++;
				}

			}

		} else if (endGame) {

			g.setColor(Color.WHITE);

			g.setFont(new Font("Joystix", Font.BOLD, 60));

			CenteredText.draw("Player " + winner, 500, 500, g, true, 130);
			CenteredText.draw("Wins!!", 500, 500, g, true, 210);

			g.setFont(new Font("Joystix", Font.BOLD, 26));

			CenteredText.draw("Enter to Restart", 500, 500, g, true, 350);

		}
	}

	public void sortCards() {

		for (ArrayList<Card> theCards : hands) {
			Collections.sort(theCards, Card.CardNumComparator);
			Collections.sort(theCards, Card.CardSuitComparator);
		}

	}

	public void checkIfWon() {

		for (int i = 0; i < numOfPlayers; i++) {

			if (playerCards.get(i).size() == 52)
				playing = false;
			endGame = true;

		}
	}

	public void shuffleHands() {

		for (ArrayList<Card> hand : playerCards) {
			Collections.shuffle(hand);
		}

	}

	public void setWon(int i) {
		winner = i + 1;
		won = true;
		playing = false;
		endGame = true;

	}

	public void nextTurn() {

		turn++;
		if (turn > numOfPlayers)
			turn = 1;

	}

	public void removeBlanks() {

		Card card = new Card(true);
		for (ArrayList<Card> hand : playerCards) {

			hand.removeAll(Collections.singleton(card));

		}

	}

	public void war(ArrayList<Integer> pInWar) {

		warCards = new ArrayList<Card>();
		warCards.addAll(middle);
		for (Integer n : pInWar) {
			warCards.addAll(playerCards.get(n).subList(0, 3));
			playerCards.get(n).removeAll(playerCards.get(n).subList(0, 3));
		}

		for (Integer n : pInWar) {

			warCards.add(playerCards.get(n).get(0));
			playerCards.get(n).remove(0);

		}

	}

	public void middleAdd() {

		if (!middleShow) {
			middle.clear();
			middleHighP = new Card(true);
			middleHighPNum = 0;
			for (int i = 0; i < numOfPlayers; i++) {

				Card card;
				if (playerCards.get(i).size() == 0) {
					card = new Card(true);
				} else {
					card = playerCards.get(i).get(0);
				}
				middle.add(card);
				if (playerCards.get(i).size() > 0) {

					if (card.getCard() == middleHighP.getCard()
							&& card.getSuit() > middleHighP.getSuit()) {
						middleHighP = card;
						middleHighPNum = i;
					} else if (card.getCard() > middleHighP.getCard()) {
						middleHighP = card;
						middleHighPNum = i;
					}

					playerCards.get(i).remove(card);
					middleShow = true;
				}
			}
			System.out.println(middle);
		} else {
			middleShow = false;
			playerCards.get(middleHighPNum).addAll(middle);
			shuffleHands();
			removeBlanks();
			checkIfWon();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (startGame) {

				startGame = false;
				playing = true;

			} else if (playing) {

				middleAdd();

			} else if (endGame) {

				playing = true;
				endGame = false;
				newGame();

			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
