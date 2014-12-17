package cardGameClasses;

import java.util.ArrayList;
import java.util.Collections;

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

	public int findCard(Card card) {

		return deck.indexOf(card);

	}

	public ArrayList<Card> findMatches(Card card) {

		boolean allSame = true;
		ArrayList<Card> matches = new ArrayList<Card>();
		matches.add(card);
		int i = 1;
		for (Card checkCard : deck) {
			if (card.getCard() == checkCard.getCard()) {
				matches.add(checkCard);
			}

		}

		return matches;
	}

	public boolean removeMatches(Card checkCard) {

		return deck.removeIf(c -> c.getCard() == checkCard.getCard());

	}
	
	public int cardsLeft() {
		return deck.size();
	}
	
	public void shuffle() {
		
		Collections.shuffle(deck);
		
	}
	
	public Card drawCard() {
		Card c = deck.get(0);
		deck.remove(0);
		return c;
	}
	
	public Card get(int i) {
		return deck.get(i);
	}
	
//	public static void main(String[] args) {
//		
//		Deck d = new Deck();
//		System.out.println(d.getDeck());
//		
//		
//	}

}
