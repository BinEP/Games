package goFish;

import utilityClasses.CenteredText;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GoFishPanel extends JPanel implements ActionListener, KeyListener,
		MouseListener {

	private ArrayList<Card> deck = new ArrayList<Card>();
	// private ArrayList<Card> p1Hand = new ArrayList<Card>();
	// private ArrayList<Card> p2Hand = new ArrayList<Card>();
	private int numOfPlayers = 2;
	private ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>(
			numOfPlayers);
	private ArrayList<Buttons> buttons = new ArrayList<Buttons>();
	private ArrayList<Card> restOfDeck = new ArrayList<Card>();
	private ArrayList<Card> matchingCards = new ArrayList<Card>();

	private int turn = 1;

	private boolean startGame = false;
	private boolean playing = true;
	private boolean endGame = false;

	private int winner;
	private boolean won = false;

	ArrayList<Rectangle> cards = new ArrayList<Rectangle>();

	public GoFishPanel() {

		newDeck();
		// p1Hand = playerHand();
		// p2Hand = playerHand();
		newHands();
		setUpButtons();

		setBackground(Color.BLACK);

		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);

		Timer timer = new Timer(1000 / 60, this);
		timer.start();

	}

	public GoFishPanel(int i) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		moves();
	}

	public void moves() {

		if (playing) {

		}
		checkIfWon();

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
		// return hand;
		System.out.println(hands);
	}

	public void shuffleDeck() {

		Collections.shuffle(deck);

	}

	public void setUpButtons() {

		buttons.add(new Buttons("Pair", 400, 250, 80, 50));
		buttons.add(new Buttons("Ask", 50, 250, 80, 50));

	}

	public void drawPlayerHand(int pNum, Graphics g, int startY) {

		ArrayList<Card> hand = hands.get(pNum - 1);

		int HY = (pNum == 1) ? 20 : 550;

		g.setFont(new Font("Joystix", Font.BOLD, 20));
		int i = 0;
		int m = 0;
		int r = 0;
		int startX = 20;
		// int startY = 10;
		// int spacing = (448 - hand.size() * 56) / hand.size();
		// startX = (500 - (i * (56 + spacing)) * hand.size())/2;

		// System.out.println((500 - ((i * (56 + spacing)) * hand.size()))/2);
		int spacing = getSpacing(hand);
		for (Card card : hand) {

			// int x = getXCenter(hand, startX) + i * (56 + spacing);
			int x = getXCenter(hand, startX) + (62 * m);
			// System.out.println(getSpacing(hand));
			int y = startY + (110 * (int) (i / 7));
			// System.out.println(i);
			CenteredText out = new CenteredText(card.getCardFace()
					+ card.getSuitIcon(), 56, 100, g);
			g.setColor(card.getColor());
			g.fillRoundRect(x, y, 56, 100, 5, 5);
			g.drawRoundRect(x, y, 56, 100, 5, 5);
			g.setColor((card.getSuit() % 2 == 0) ? Color.RED : Color.BLACK);
			g.drawString(card.getCardFace() + card.getSuitIcon(), x + out.x,
					y + 56);
			// cards.add(new Rectangle(x, y, 56, 100));

			hands.get(pNum - 1).get(i).setRectangle(x, y, 56, 100);

			i++;
			m++;
			if (m % 7 == 0)
				m = 0;

		}
		// hand.add(new Card());
		// System.out.println("Added Card");

	}

	public int getXCenter(ArrayList<Card> hand, int startX) {

		int size = (hand.size() > 7) ? 7 : hand.size();

		int width = size * 62 - getSpacing(hand);
		startX += (460 - width) / 2;

		return startX;
	}

	public int getSpacing(ArrayList<Card> hand) {

		int size = hand.size();
		int spaceForCard = (int) ((460 - (hand.size() * 56)) / (hand.size()));

		return spaceForCard;

	}

	public ArrayList<Card> playerHand() {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.get(0));
			deck.remove(0);

		}
		Collections.sort(hand, Card.CardNumComparator);
		Collections.sort(hand, Card.CardSuitComparator);

		return hand;
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);

		drawPlayerHand(1, g, 10);
		drawPlayerHand(2, g, 350);
		buttons.get(0).drawRectangle(g);
		buttons.get(1).drawRectangle(g);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// public static void main(String[] args) {
	//
	// GoFishPanel p = new GoFishPanel(1);
	// p.runFromMain();
	//
	// }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (playing) {
			checkIfWon();
			for (ArrayList<Card> aHand : hands) {
				// System.out.println(aHand);
				for (Card r : aHand) {
					if (r.getRectangle().contains(e.getPoint())) {

						r.selected = !r.selected;
						r.setColor((r.selected) ? Color.YELLOW : Color.WHITE);

						// hmmmmm
					}
				}

			}
			for (Buttons b : buttons) {

				if (b.getButton().contains(e.getPoint())) {

					switch (b.getText()) {

					case "Pair":
						pairingsTest();

						break;
					case "Ask":

						asking();

						break;

					}

				}

			}
		}
		repaint();
	}

	public void pairings() {
		ArrayList<Integer[]> pairs = new ArrayList<Integer[]>();
		int n = 0;
		for (ArrayList<Card> aHand : hands) {
			// System.out.println(aHand);

			for (int i = 0; i < aHand.size(); i++) {
				Card r = aHand.get(i);
				if (r.selected) {

					r.selected = false;
					r.setColor(Color.WHITE);
					Integer[] theP = { i, n };
					pairs.add(theP);
					// restOfDeck.add(r);
					// aHand.remove(i);
					i--;
				}

			}

			n++;

		}
		if (pairs.size() > 1) {
			int m = 0;
			for (Integer[] i : pairs) {

				restOfDeck.add(hands.get(i[1]).get(i[0] - m));
				(hands.get(i[1])).remove((int) (i[0] - m));
				m++;

			}

		}
		// repaint();
	}

	public void pairingsTest() {

		ArrayList<Card> selectedCards = getSelected();
		if (checkIfValidPairs(selectedCards)) {

			for (Card currentCard : selectedCards) {

				restOfDeck.add(currentCard);
				for (ArrayList<Card> cardAL : hands) {

					cardAL.remove(currentCard);

				}

			}

		}

	}

	public boolean checkIfValidPairs(ArrayList<Card> selectedCards) {

		boolean allSame = true;

		int i = 1;
		while (i < selectedCards.size() && allSame) {

			allSame = allSame
					&& selectedCards.get(i - 1).getCard() == selectedCards.get(
							i).getCard();

			i++;
		}

		return allSame && selectedCards.size() > 1;

	}

	public ArrayList<Card> getSelected() {

		ArrayList<Card> selected = new ArrayList<Card>();

		for (Card currentCard : hands.get(turn - 1)) {

			if (currentCard.selected)
				selected.add(currentCard);

		}

		return selected;

	}

	public void asking() {

		ArrayList<Integer> pairs = new ArrayList<Integer>();
		ArrayList<Card> aHand = hands.get(turn - 1);
		// System.out.println(aHand);

		for (int i = 0; i < aHand.size(); i++) {
			Card r = aHand.get(i);
			if (r.selected) {

				r.selected = false;
				r.setColor(Color.WHITE);
				pairs.add(i);
				// restOfDeck.add(r);
				// aHand.remove(i);
				i--;
			}

		}
		int n = 0;
		if (pairs.size() < 2 && pairs.size() > 0) {
			int pair = pairs.get(0);
			Card askCard = aHand.get(pair);
			int cardNum = askCard.getCard();
			boolean success = false;
			ArrayList<Integer> matches = new ArrayList<Integer>();

			for (ArrayList<Card> theCards : hands) {
				if (n != turn - 1) {

					for (int m = 0; m < theCards.size(); m++) {
						Card aCard = theCards.get(m);
						if (aCard.getCard() == cardNum) {
							hands.get(turn - 1).add(aCard);
							theCards.remove(m);
							success = true;
							m--;
						}

					}

				}
				n++;
				Collections.sort(theCards, Card.CardNumComparator);
				Collections.sort(theCards, Card.CardSuitComparator);
			}
			if (!success) {

				nextTurn();

			}
		}

	}

	public void checkIfWon() {

		for (int i = 0; i < hands.size(); i++) {

			ArrayList<Card> hand = hands.get(i);
			if (hand.isEmpty()) {
				winner = i + 1;
				won = true;
				playing = false;
				endGame = true;

			}

		}

	}

	public void nextTurn() {

		goFish();
		turn++;
		if (turn > numOfPlayers)
			turn = 1;

	}

	public void goFish() {

		hands.get(turn - 1).add(deck.get(0));
		deck.remove(0);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
