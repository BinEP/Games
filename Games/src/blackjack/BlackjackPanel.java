package blackjack;

import utilityClasses.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BlackjackPanel extends JPanel implements ActionListener, KeyListener,
		MouseListener {

	private ArrayList<Card> deck = new ArrayList<Card>();
	private int numOfPlayers = 2;
	private ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>(
			numOfPlayers);
	private ArrayList<Buttons> buttons = new ArrayList<Buttons>();
	private ArrayList<ArrayList<Card>> restOfDeck = new ArrayList<ArrayList<Card>>();

	private int turn = 1;

	private boolean startGame = true;
	private boolean playing = false;
	private boolean endGame = false;

	private int winner;
	private boolean won = false;

	public BlackjackPanel() {

		newGame();

		setBackground(Color.BLACK);

		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);

		Timer timer = new Timer(1000 / 20, this);
		timer.start();

	}

	public BlackjackPanel(int i) {

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
		buttons.clear();
		turn = 1;
		newDeck();
		newHands();
		deckPairsSetup();

		setUpButtons();
	}

	public void shuffleDeck() {

		Collections.shuffle(deck);
	}

	public void setUpButtons() {

		buttons.add(new Buttons("Pair", 400, 250, 80, 50));
		buttons.add(new Buttons("Ask", 50, 250, 80, 50));
	}

	public void drawHandCover(int pNum, Graphics g) {

		ArrayList<Card> hand = hands.get(pNum - 1);

		int y = (pNum == 1) ? 10 : 350;
		int i = 0;
		int startX = 20;
		int spacing = getSpacing(hand);
		for (Card card : hand) {

			int x = getXCenter(hand, startX) + (spacing * i);

			g.setColor(Color.BLUE);
			g.fillRoundRect(x, y, 56, 100, 5, 5);
			g.drawRoundRect(x, y, 56, 100, 5, 5);

			i++;
		}
	}

	public void drawPlayerHand(int pNum, Graphics g, int startY) {

		ArrayList<Card> hand = hands.get(pNum - 1);

		g.setFont(new Font("Joystix", Font.BOLD, 20));
		int i = 0;

		int startX = 20;

		int spacing = getSpacing(hand);
		for (Card card : hand) {

			int x = getXCenter(hand, startX) + (spacing * i);
			int y = startY;

			CenteredText out = new CenteredText(card.getCardFace()
					+ card.getSuitIcon(), 56, 100, g);
			g.setColor(card.getColor());
			g.fillRoundRect(x, y, 56, 100, 5, 5);
			g.drawRoundRect(x, y, 56, 100, 5, 5);
			g.setColor((card.getSuit() % 2 == 0) ? Color.RED : Color.BLACK);
			g.drawString(card.getCardFace() + card.getSuitIcon(), x + out.x,
					y + 56);

			hands.get(pNum - 1).get(i).setRectangle(x, y, 56, 100);

			i++;
		}
	}

	public int getXCenter(ArrayList<Card> hand, int startX) {

		int size = hand.size();
		if (size > 7)
			size = 7;

		int width = size * 62 - 6;
		startX += (460 - width) / 2;

		return startX;
	}

	public int getSpacing(ArrayList<Card> hand) {

		if (hand.size() < 8)
			return 62;
		int size = hand.size() + 1;

		int cardWidth = size * 56;
		int space = 460 - cardWidth;
		return (int) (56 + space / (size - 1));
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

			drawPlayerHand(1, g, 10);
			drawPlayerHand(2, g, 350);
			buttons.get(0).drawRectangle(g);
			buttons.get(1).drawRectangle(g);
			g.setColor(Color.YELLOW);
			g.fillRect(10, 40 + (turn - 1) * 350, 10, 30);
			g.setColor(Color.WHITE);

			drawHandCover((turn == 1) ? 2 : 1, g);

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

	public void pairings() {

		ArrayList<Card> selectedCards = getSelected();
		if (checkIfValidPairs(selectedCards)) {

			for (Card currentCard : selectedCards) {

				restOfDeck.get(turn - 1).add(currentCard);
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
		if (!getSelected().isEmpty()) {
			Card selectedCard = getSelected().get(0);
			ArrayList<Card> matchingCards = new ArrayList<Card>();

			int i = 0;
			for (ArrayList<Card> currentHand : hands) {
				if (i != turn - 1) {

					for (Card currentCard : currentHand) {

						if (selectedCard.getCard() == currentCard.getCard())
							matchingCards.add(currentCard);
					}
				}
				for (Card matchCard : matchingCards) {
					currentHand.remove(matchCard);
				}
				i++;
			}

			hands.get(turn - 1).addAll(matchingCards);

			sortCards();
			if (matchingCards.isEmpty())
				nextTurn();
		}
	}

	public void sortCards() {

		for (ArrayList<Card> theCards : hands) {
			Collections.sort(theCards, Card.CardNumComparator);
			Collections.sort(theCards, Card.CardSuitComparator);
		}

	}

	public void resetColors() {

		for (ArrayList<Card> currentHand : hands) {

			for (Card currentCard : currentHand) {

				currentCard.selected = false;
				currentCard.setColor(Color.WHITE);

			}

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

		goFish();
		turn++;
		if (turn > numOfPlayers)
			turn = 1;

	}

	public void goFish() {

		if (!deck.isEmpty()) {
			hands.get(turn - 1).add(deck.get(0));
			deck.remove(0);
		} else {
			int highestPairs = 0;
			int highestPlayer = 0;
			int i = 1;
			for (ArrayList<Card> playerPairs : restOfDeck) {

				if (playerPairs.size() > highestPairs) {
					highestPairs = playerPairs.size();
					highestPlayer = i;
				}

				i++;
			}
			setWon(highestPlayer);

		}
		sortCards();

	}

	// //////////////////////////////////////////////

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!checkIfWon() && playing) {

			for (ArrayList<Card> aHand : hands) {
				for (Card r : aHand) {
					if (r.getRectangle().contains(e.getPoint())) {

						r.selected = !r.selected;
						r.setColor((r.selected) ? Color.YELLOW : Color.WHITE);
					}
				}

			}
			for (Buttons b : buttons) {

				if (b.getButton().contains(e.getPoint())) {

					switch (b.getText()) {

					case "Pair":
						pairings();

						break;
					case "Ask":

						asking();

						break;
					}
					resetColors();
				}
			}
		repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	// //////////////////////////////////////////////

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (startGame) {
			startGame = false;
			playing = true;
		} else if (endGame) {
			endGame = false;
			playing = true;

			newGame();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
