package war;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
		repaint();
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
			CenteredText title1 = new CenteredText("WAR!!", 500, 500, g, true,
					230);

			g.setFont(new Font("Joystix", Font.BOLD, 20));
			CenteredText start1 = new CenteredText("Press Enter to", 500, 500,
					g, true, 350);
			CenteredText start2 = new CenteredText("Start", 500, 500, g, true,
					380);

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
					CenteredText cardNum = new CenteredText(
							String.valueOf(playerCards.get(i).size()), 56, 100,
							g);
					g.drawString(String.valueOf(playerCards.get(i).size()), x
							+ cardNum.x, y + 60);
				}
				
					if (middleShow && middleCards) {
						g.setColor(Color.WHITE);
						int x = middleXYs[i][0];
						int y = middleXYs[i][1];
						Card card = middle.get(i);
						if (card.equals(middleHighP))
							g.setColor(Color.YELLOW);

						g.fillRoundRect(x, y, 56, 100, 5, 5);
						g.drawRoundRect(x, y, 56, 100, 5, 5);
						g.setColor(Color.BLACK);
						CenteredText cardNum1 = new CenteredText(
								card.getShown(), 56, 100, g);
						g.drawString(card.getShown(), x + cardNum1.x, y + 60);
					}
				

			}

			// if (middleShow) {
			// int m = 0;
			//
			// for (Card card : middle) {
			// // if (playerCards.get(m).size() > 0) {
			//
			// }
			//
			// }

		} else if (endGame) {

			g.setColor(Color.WHITE);

			g.setFont(new Font("Joystix", Font.BOLD, 60));

			CenteredText win = new CenteredText("Player " + winner, 500, 500,
					g, true, 130);
			CenteredText win1 = new CenteredText("Wins!!", 500, 500, g, true,
					210);

			g.setFont(new Font("Joystix", Font.BOLD, 26));

			CenteredText restart = new CenteredText("Enter to Restart", 500,
					500, g, true, 350);

		}
	}

	public void sortCards() {

		for (ArrayList<Card> theCards : hands) {
			Collections.sort(theCards, Card.CardNumComparator);
			Collections.sort(theCards, Card.CardSuitComparator);
		}

	}

	public boolean checkIfWon() {

		for (int i = 0; i < numOfPlayers; i++) {

			if (playerCards.get(i).size() == 52)
				return true;

		}
		return false;
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

				if (!middleShow) {
					middle.clear();
					middleHighP = new Card(true);
					middleHighPNum = 0;
					for (int i = 0; i < numOfPlayers; i++) {
						// if (playerCards.get(i).size() > 0) {
						Card card = playerCards.get(i).get(0);
						middle.add(card);
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
						// }
					}
				} else {
					middleShow = false;
					playerCards.get(middleHighPNum).addAll(middle);
					shuffleHands();
					checkIfWon();
				}

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
