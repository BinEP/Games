package cardClasses;

import java.util.ArrayList;
import java.util.Iterator;

public class Hand extends CardStack {

	ArrayList<Card> cards = new ArrayList<Card>();
	int numOfCards;

	public static void main(String[] args) {

	}

	public Hand() {

	}

	public Hand(Deck deck) {

		numOfCards = 7;

		for (int i = 0; i < numOfCards; i++) {
			cards.add(deck.drawCard());

		}

	}

	public Hand(Deck deck, int numOfCardss) {

		numOfCards = numOfCardss;

		for (int i = 0; i < numOfCards; i++) {
			cards.add(deck.drawCard());

		}

	}

	public ArrayList<Card> getHand() {

		return cards;
	}

	public int getHandSize() {

		return cards.size();
	}

	public void add(Card c) {

		cards.add(c);
	}

	public ArrayList<Card> newHand(Deck deck) {

		for (int i = 0; i < numOfCards; i++) {
			cards.add(deck.drawCard());

		}
		return cards;

	}

}
