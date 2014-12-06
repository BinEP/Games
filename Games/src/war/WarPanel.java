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
	private int numOfPlayers = 2;
	private ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>(
			numOfPlayers);
	
	private ArrayList<ArrayList<Card>> restOfDeck = new ArrayList<ArrayList<Card>>();
	
	private boolean startGame = true;
	private boolean playing = false;
	private boolean endGame = false;

	private int winner;
	private boolean won = false;
	
	private int turn = 1;
	
	
	
	public WarPanel() {

		newGame();

		setBackground(Color.BLACK);

		setFocusable(true);
		addKeyListener(this);

		Timer timer = new Timer(1000 / 20, this);
		timer.start();

	}

	public WarPanel(int i) {

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
		for (int n = 0; n < numOfPlayers; n++) {
			ArrayList<Card> hand = new ArrayList<Card>();
			for (int i = 0; i < 7; i++) {
				hand.add(deck.get(0));
				deck.remove(0);
			}
			Collections.sort(hand, Card.CardNumComparator);
			Collections.sort(hand, Card.CardSuitComparator);
			hands.add(hand);
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
	
	
	
	public ArrayList<Card> playerHand() {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.get(0));
			deck.remove(0);
		}
		sortCards();

		return hand;
	}
	
	
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);
		if (startGame) {

			g.setColor(Color.WHITE);
			g.setFont(new Font("Joystix", Font.BOLD, 60));
			CenteredText title1 = new CenteredText("GO FISH!!", 500, 500, g,
					true, 230);

			g.setFont(new Font("Joystix", Font.BOLD, 20));
			CenteredText start1 = new CenteredText("Press Enter to", 500, 500,
					g, true, 350);
			CenteredText start2 = new CenteredText("Start", 500, 500, g, true,
					380);

		} else if (playing) {

			

			

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

		int i = 0;
		for (ArrayList<Card> hand : hands) {

			if (hand.isEmpty()) {
				setWon(i);
				return true;

			}
			i++;
		}
		return false;
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
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
