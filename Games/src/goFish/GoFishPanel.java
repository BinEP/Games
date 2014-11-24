package goFish;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GoFishPanel extends JPanel implements ActionListener, KeyListener {

	private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<Card> p1Hand = new ArrayList<Card>();
	private ArrayList<Card> p2Hand = new ArrayList<Card>();

	public GoFishPanel() {

		newDeck();
		setBackground(Color.BLACK);

		setFocusable(true);
		addKeyListener(this);

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

	}

	public void newDeck() {
		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while(deck.contains(card)) {
				
				card = new Card();
				
			}
			deck.add(card);

		}

	}
	
	public ArrayList<Card> playerHand() {
		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.get(i));
			deck.remove(i);
			
		}
		Collections.sort(hand, Card.CardSuitComparator);
		Collections.sort(hand, Card.CardNumComparator);
		
		return hand;
	}

	public void shuffleDeck() {

		Collections.shuffle(deck);
		

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

	public static void main(String[] args) {
		
		GoFishPanel p = new GoFishPanel(1);
		p.runFromMain();

	}

	public void runFromMain() {

		newDeck();
		p1Hand = playerHand();
		p2Hand = playerHand();
		//Collections.sort(deck, Card.CardSuitComparator);
		//Collections.sort(deck, Card.CardNumComparator);
		for (Card x : deck) {

			System.out.println(x.getCardFace() + x.getSuitIcon());
			

		}
		System.out.println("Player 1 Hand");
		for (Card x : p1Hand) {

			System.out.print(x.getCardFace() + x.getSuitIcon() + "   ");
			

		}
		System.out.println("\n Player 2 Hand");
		for (Card x : p2Hand) {

			System.out.print(x.getCardFace() + x.getSuitIcon() + "   ");
			

		}

	}

}
