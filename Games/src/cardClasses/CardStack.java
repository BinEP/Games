package cardClasses;

import java.util.ArrayList;
import java.util.Collections;

public class CardStack {

	// new stack
	// sub stack
	// sort
	// shuffle
	// cards left
	// get card
	// add card
	//

	protected ArrayList<Card> cardStack = new ArrayList<Card>();

	public CardStack() {

		newStack();

	}

	public CardStack(int numOfCards) {

		
			double deckCount = Math.ceil((double)numOfCards/52);
			System.out.println(deckCount);
			for (int i = 0; i < deckCount; i++) {
			
				 cardStack.addAll(newStackList(52));
			}
			cardStack.subList(numOfCards, cardStack.size()).clear();
			System.out.println(cardStack.toString());
			System.out.println(cardStack.size());
		
	}

	public ArrayList<Card> newStack() {

		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while (cardStack.contains(card)) {
				card = new Card();
			}
			cardStack.add(card);
		}

		return cardStack;
	}

	public ArrayList<Card> newStack(int numOfCards) {

		Card card = new Card();
		for (int i = 0; i < numOfCards; i++) {
			while (cardStack.contains(card)) {
				card = new Card();
			}
			cardStack.add(card);
		}

		return cardStack;

	}
	
	public ArrayList<Card> newStackList() {

		ArrayList<Card> cardStack = new ArrayList<Card>();
		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while (cardStack.contains(card)) {
				card = new Card();
			}
			cardStack.add(card);
		}

		return cardStack;
	}

	public ArrayList<Card> newStackList(int numOfCards) {

		ArrayList<Card> cardStack = new ArrayList<Card>();
		Card card = new Card();
		for (int i = 0; i < numOfCards; i++) {
			while (cardStack.contains(card)) {
				card = new Card();
			}
			cardStack.add(card);
		}

		return cardStack;

	}

	public void shuffle() {

		Collections.shuffle(cardStack);
	}

	public ArrayList<Card> subStackCopy() {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(cardStack.get(i));
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> subStackRemove() {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(cardStack.get(0));
			cardStack.remove(0);
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> subStack() {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(cardStack.get(0));
			cardStack.remove(0);
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> subStackCopy(int numOfCards) {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < numOfCards; i++) {
			hand.add(cardStack.get(i));
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> subStackRemove(int numOfCards) {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < numOfCards; i++) {
			hand.add(cardStack.get(0));
			cardStack.remove(0);
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> subStack(int numOfCards) {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < numOfCards; i++) {
			hand.add(cardStack.get(0));
			cardStack.remove(0);
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> sortStack() {

		Collections.sort(cardStack, Card.CardSuitComparator);
		Collections.sort(cardStack, Card.CardNumComparator);
		return cardStack;
	}

	public ArrayList<Card> sortStackSuit() {

		Collections.sort(cardStack, Card.CardNumComparator);
		Collections.sort(cardStack, Card.CardSuitComparator);
		return cardStack;
	}

	public ArrayList<Card> sortStack(ArrayList<Card> stack) {

		Collections.sort(stack, Card.CardSuitComparator);
		Collections.sort(stack, Card.CardNumComparator);
		return stack;
	}

	public ArrayList<Card> sortStackSuit(ArrayList<Card> stack) {

		Collections.sort(stack, Card.CardNumComparator);
		Collections.sort(stack, Card.CardSuitComparator);
		return stack;
	}

	public int cardsLeft() {

		return cardStack.size();

	}

	public Card drawCard() {

		Card c = cardStack.remove(0);
		return c;

	}

	public Card getCard(int cardIndex) {

		return cardStack.get(cardIndex);

	}

	public Card getNextCard() {

		return cardStack.get(0);

	}

	public ArrayList<Card> addCard(Card c) {

		cardStack.add(c);
		return cardStack;

	}

	public ArrayList<Card> getStack() {

		return cardStack;
		
	}

	public void clearStack() {
		cardStack.clear();
	}

	public ArrayList<Card> removeCard(Card c) {

		cardStack.remove(c);
		return cardStack;
	}
	
	public String toString() {
		
		return cardStack.toString();
		
		
	}

	public static void main(String[] args) {
		new CardStack(52);
	}
}
