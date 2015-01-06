package cardGameClasses;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends CardStack {

	private ArrayList<Card> deck = new ArrayList<Card>();

	public Deck() {

		newDeck(52);

	}

	public Deck(int cardNum) {

		newDeck(cardNum);

	}

	public void newDeck(int cardNum) {

		deck.clear();
		Card card = new Card();
		for (int i = 0; i < cardNum; i++) {
			while (deck.contains(card)) {
				card = new Card();
			}
			deck.add(card);
		}
	}

	public static void main(String[] args) {

		CardStack d = new CardStack();
		System.out.println(d.getStack());

	}

}
