package cardGameClasses;

import goFish.Card;

import java.util.ArrayList;

public class Deck {

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

	public ArrayList<Card> getDeck() {

		return deck;

	}

}
