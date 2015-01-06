package cardGameClasses;

import java.util.ArrayList;
import java.util.Collections;

public class CardStack extends CardStackMethods {

	protected ArrayList<Card> cardStack;

	public CardStack() {

		cardStack = new ArrayList<Card>();

	}

	public CardStack(ArrayList<Card> cards) {

		cardStack = new ArrayList<Card>();
		cardStack.addAll(cards);

	}

	public ArrayList<Card> newStack() {

		cardStack.clear();
		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while (cardStack.contains(card)) {
				card = new Card();
			}
			cardStack.add(card);
		}

		return cardStack;

	}

	public ArrayList<Card> newStack(int cardNum) {
		cardStack.clear();
		Card card = new Card();
		for (int i = 0; i < cardNum; i++) {
			while (cardStack.contains(card)) {
				card = new Card();
			}
			cardStack.add(card);
		}
		return cardStack;
	}
	
	public ArrayList<Card> subDeck() {
	
		ArrayList < Card > subCards = new ArrayList<Card>();
		subCards = (ArrayList<Card>) cardStack.subList(0, 7);
		cardStack.removeAll(subCards);
		return subCards;
		
	
	
	}
	
	public ArrayList<Card> subDeck(int cardNum) {
		
		
		ArrayList < Card > subCards = new ArrayList<Card>();
		subCards = (ArrayList<Card>) cardStack.subList(0, cardNum);
		cardStack.removeAll(subCards);
		return subCards;
		
		
		
		
	}
	
	

	public ArrayList<Card> addAll(ArrayList<Card> cards) {

		cardStack.addAll(cards);
		return cardStack;

	}

	public ArrayList<Card> add(Card card) {

		cardStack.add(card);
		return cardStack;

	}

	public Card nextCard() {
		Card c = cardStack.get(0);
		cardStack.remove(0);
		return c;
	}
	
	public ArrayList<Card> nextCardList() {
		
		ArrayList < Card > subCards = new ArrayList<Card>();
		subCards = (ArrayList<Card>) cardStack.subList(0, 7);
		return subCards;
		
	
	
	}
	
	public ArrayList<Card> nextCardList(int cardNum) {
		
		
		ArrayList < Card > subCards = new ArrayList<Card>();
		subCards = (ArrayList<Card>) cardStack.subList(0, cardNum);
		return subCards;
		
		
		
		
	}

	public boolean removeMatches(Card checkCard) {

		return cardStack.removeIf(c -> c.getCard() == checkCard.getCard());

	}

	public void clear() {

		cardStack.clear();
	}

	public ArrayList<Card> getStack() {

		return cardStack;

	}

	public Card get(int i) {
		return cardStack.get(i);
	}

	public int find(Card card) {
		return cardStack.indexOf(card);

	}

	public ArrayList<Card> findMatches(Card card) {

		ArrayList<Card> matches = new ArrayList<Card>();
		matches.add(card);
		for (Card checkCard : cardStack) {
			if (card.equalRank(checkCard)) {
				matches.add(checkCard);
			}

		}

		return matches;
	}

	public ArrayList<Card> findMatches(int c) {

		ArrayList<Card> matches = new ArrayList<Card>();
		for (Card checkCard : cardStack) {
			if (c == checkCard.getCard()) {
				matches.add(checkCard);
			}

		}

		return matches;
	}

	public boolean equals(Card card) {

		return true;
	}

	public int cardsLeft() {
		return cardStack.size();
	}

	public ArrayList<Card> shuffle() {

		Collections.shuffle(cardStack);
		return cardStack;

	}

	public ArrayList<Card> sort() {

		Collections.sort(cardStack, Card.CardNumComparator);
		Collections.sort(cardStack, Card.CardSuitComparator);
		return cardStack;
	}
	
	public static void main(String[] args) {

	}
}
